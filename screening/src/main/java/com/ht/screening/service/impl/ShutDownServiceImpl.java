package com.ht.screening.service.impl;


import cn.hutool.extra.servlet.ServletUtil;
import com.ht.base.constant.CommonConstant;
import com.ht.base.utils.NumberUtils;
import com.ht.base.utils.StringUtils;
import com.ht.screening.dto.AbnormalShutdownDto;
import com.ht.screening.dto.FilterDetailUploadDto;
import com.ht.screening.dto.NormalShutdownDto;
import com.ht.screening.entity.ScSx2;
import com.ht.screening.mapper.ScSx2Mapper;
import com.ht.screening.request.AbnormalShutdownRequest;
import com.ht.screening.request.NormalShutdownRequest;
import com.ht.screening.response.AbnormalShutDownResponse;
import com.ht.screening.response.CalculateQGCDResponse;
import com.ht.screening.response.NormalShutDownResponse;
import com.ht.screening.service.ShutDownService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * 停机处理
 *
 * @author chengsukai
 */
@Service
@Slf4j
public class ShutDownServiceImpl implements ShutDownService {

    @Resource
    private FiberInfoUploadServiceImpl fiberInfoUploadService;

    @Resource
    private FilterUploadServiceImpl filterUploadService;

    @Resource
    private ScSx2Mapper scSx2Mapper;

    @Resource
    ScSxServiceImpl scSxService;

    private void initNormalShutdownRequest(NormalShutdownDto normalShutdownDto, NormalShutdownRequest request) {
        normalShutdownDto.setPh(request.getFilterInfo().getPh());
        normalShutdownDto.setSxbh(request.getFilterInfo().getSxbh());
        normalShutdownDto.setSxcd(request.getDeviceDataDto().getSxcd());
        normalShutdownDto.setYscd(request.getDeviceDataDto().getYscd());
        normalShutdownDto.setSycd(request.getDeviceDataDto().getSycd());
        normalShutdownDto.setInitialTime(request.getLoginDataDto().getStartDate());
        normalShutdownDto.setAccoutId(request.getLoginDataDto().getAccountId());
        normalShutdownDto.setBz(request.getLoginDataDto().getBz());
        normalShutdownDto.setUsername(request.getLoginDataDto().getUsername());
        normalShutdownDto.setGlqk(request.getFilterInfo().getGlqk());
        normalShutdownDto.setColor(request.getSelectDataDto().getColor());
        normalShutdownDto.setStartDate(request.getInitialTime());
        normalShutdownDto.setYl(String.valueOf(request.getSelectDataDto().getYl()));
        normalShutdownDto.setPj(request.getSelectDataDto().getPj());
        normalShutdownDto.setXj(request.getSelectDataDto().getXj());
    }

    private void initAbnormalShutdownRequest(AbnormalShutdownDto abnormalShutdownDto, AbnormalShutdownRequest request) {
        abnormalShutdownDto.setPh(request.getFilterInfo().getPh());
        abnormalShutdownDto.setSxbh(request.getFilterInfo().getSxbh());
        abnormalShutdownDto.setSxcd(request.getDeviceDataDto().getSxcd());
        abnormalShutdownDto.setYscd(request.getDeviceDataDto().getYscd());
        abnormalShutdownDto.setSycd(request.getDeviceDataDto().getSycd());
        abnormalShutdownDto.setInitialTime(request.getLoginDataDto().getStartDate());
        abnormalShutdownDto.setAccoutId(request.getLoginDataDto().getAccountId());
        abnormalShutdownDto.setBz(request.getLoginDataDto().getBz());
        abnormalShutdownDto.setUsername(request.getLoginDataDto().getUsername());
        abnormalShutdownDto.setGlqk(request.getFilterInfo().getGlqk());
        abnormalShutdownDto.setColor(request.getSelectDataDto().getColor());
        abnormalShutdownDto.setStartDate(request.getInitialTime());
        abnormalShutdownDto.setYl(String.valueOf(request.getSelectDataDto().getYl()));
        abnormalShutdownDto.setPj(request.getSelectDataDto().getPj());
        abnormalShutdownDto.setXj(request.getSelectDataDto().getXj());
        abnormalShutdownDto.setPyccd(request.getDeviceDataDto().getPyccd());
        abnormalShutdownDto.setHlcd(String.valueOf(request.getDeviceDataDto().getHlcd()));
    }

    @Override
    @Transactional
    public NormalShutDownResponse normalShutdown(NormalShutdownRequest normalShutdownRequest) {
        NormalShutdownDto normalShutdownDto = new NormalShutdownDto();
        initNormalShutdownRequest(normalShutdownDto, normalShutdownRequest);
        NormalShutDownResponse response = new NormalShutDownResponse();
        String ph = normalShutdownDto.getPh();
        String pyccd = normalShutdownRequest.getDeviceDataDto().getPyccd();
        Double yscd = normalShutdownDto.getYscd();

        double ewz;
        double CD;
        String DQQK;
        double dqcd;
        String qxlb;
        double qgcd;
        String sxbh = normalShutdownDto.getSxbh();
        String xptm;
        String glyy;

        String maxxh;
        String xh;
        Boolean SFFQ = fiberInfoUploadService.uploadDataCheckFQ(ph);
        Boolean SFGL = fiberInfoUploadService.uploadDataCheckGL(ph);

        if (yscd < 2.05) {
            CalculateQGCDResponse calculateQGCDResponse = scSxService.calculateQGCD(ph);
            List<ScSx2> recordCount = scSx2Mapper.findByFilterCode(ph);
            if (recordCount.size() >= 1) {
                maxxh = scSx2Mapper.getMaxId(sxbh);
                if (!fiberInfoUploadService.updateDetailQGCD(calculateQGCDResponse, sxbh, String.valueOf(maxxh), BigDecimal.valueOf(yscd).multiply(new BigDecimal(1000).setScale(2, RoundingMode.HALF_UP)).doubleValue(), normalShutdownDto.getInitialTime())) {
                    log.info("update qgcd error");
                }
            } else {
                xh = getxh(sxbh);
                xptm = "";
                ewz = Double.parseDouble(fiberInfoUploadService.getTotalLen(ph)) * 1000;
                CD = 0L;
                DQQK = "abnormity";
                dqcd = 0L;
                qxlb = "";
                qgcd = yscd * 1000;

                FilterDetailUploadDto filterDetailUploadDto = new FilterDetailUploadDto();
                filterDetailUploadDto.setSxbh(sxbh);
                filterDetailUploadDto.setXh(xh);
                filterDetailUploadDto.setXptm(xptm);
                filterDetailUploadDto.setEwz(ewz);
                filterDetailUploadDto.setCd(CD);
                filterDetailUploadDto.setDqqk(DQQK);
                filterDetailUploadDto.setDqcd(dqcd);
                filterDetailUploadDto.setQxlb(qxlb);
                filterDetailUploadDto.setQgcd(Double.valueOf(qgcd));
                filterDetailUploadDto.setBlyy("");
                filterDetailUploadDto.setIsfg(0L);
                filterDetailUploadDto.setDqmscd(0L);
                filterDetailUploadDto.setAccoutId(normalShutdownDto.getAccoutId());
                filterDetailUploadDto.setBz(normalShutdownDto.getBz());
                filterDetailUploadDto.setPh(normalShutdownDto.getPh());
                filterDetailUploadDto.setUsername(normalShutdownDto.getUsername());
                filterDetailUploadDto.setGlqk(normalShutdownDto.getGlqk());
                filterDetailUploadDto.setColor(normalShutdownDto.getColor());
                filterDetailUploadDto.setStartDate(normalShutdownDto.getStartDate());
                filterDetailUploadDto.setYl(normalShutdownDto.getYl());
                filterDetailUploadDto.setPj(normalShutdownDto.getPj());
                filterDetailUploadDto.setXj(normalShutdownDto.getXj());
                if (filterUploadService.SXdetail(filterDetailUploadDto)) {
                    response.setStatus(true);
                    response.setPrintFlag(true);
                    return response;
                }
            }
        } else {
            xh = getxh(sxbh);
            String defaultPh = ph + "00";
            xptm = fiberInfoUploadService.getxptm(sxbh, defaultPh, ph);
            ewz = Double.valueOf(fiberInfoUploadService.getTotalLen(ph)) * 1000;
            // 通过获取设备状态拿到的
            CD = BigDecimal.valueOf(normalShutdownDto.getYscd()).setScale(2, RoundingMode.HALF_UP).multiply(new BigDecimal(1000)).longValue();
            DQQK = "";
            dqcd = 0L;
            qxlb = "";
            qgcd = 0L;
            FilterDetailUploadDto filterDetailUploadDto = new FilterDetailUploadDto();
            filterDetailUploadDto.setSxbh(sxbh);
            filterDetailUploadDto.setXh(xh);
            filterDetailUploadDto.setXptm(xptm);
            filterDetailUploadDto.setEwz(ewz);
            filterDetailUploadDto.setCd(CD);
            filterDetailUploadDto.setDqqk(DQQK);
            filterDetailUploadDto.setDqcd(dqcd);
            filterDetailUploadDto.setQxlb(qxlb);
            filterDetailUploadDto.setQgcd(Double.valueOf(qgcd));
            filterDetailUploadDto.setBlyy("");
            filterDetailUploadDto.setIsfg(0L);
            filterDetailUploadDto.setDqmscd(0L);
            filterDetailUploadDto.setAccoutId(normalShutdownDto.getAccoutId());
            filterDetailUploadDto.setBz(normalShutdownDto.getBz());
            filterDetailUploadDto.setPh(normalShutdownDto.getPh());
            filterDetailUploadDto.setUsername(normalShutdownDto.getUsername());
            filterDetailUploadDto.setGlqk(normalShutdownDto.getGlqk());
            filterDetailUploadDto.setColor(normalShutdownDto.getColor());
            filterDetailUploadDto.setStartDate(normalShutdownDto.getStartDate());
            filterDetailUploadDto.setYl(normalShutdownDto.getYl());
            filterDetailUploadDto.setPj(normalShutdownDto.getPj());
            filterDetailUploadDto.setXj(normalShutdownDto.getXj());
            filterDetailUploadDto.setPyccd(Double.valueOf(pyccd));
            if (filterUploadService.SXdetail(filterDetailUploadDto)) {
                response.setStatus(true);
                response.setXptm(xptm);
                response.setPrintFlag(true);
                ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
                response.setComputerIP(ServletUtil.getClientIP(requestAttributes.getRequest()));
                return response;
            }
        }

            response.setStatus(true);
        response.setPrintFlag(false);
        return response;
    }

    @Override
    @Transactional
    public AbnormalShutDownResponse abnormalShutdown(AbnormalShutdownRequest abnormalShutdownRequest) {

        AbnormalShutdownDto abnormalShutdownDto = new AbnormalShutdownDto();
        initAbnormalShutdownRequest(abnormalShutdownDto, abnormalShutdownRequest);
        AbnormalShutDownResponse response = new AbnormalShutDownResponse();
        String ph = abnormalShutdownDto.getPh();
        double ewz;
        double CD = 0L;
        String machineCategory = "D";
        String region = "四区";
        String DQQK;
        double dqcd = 0d;
        Integer isfg = 0;
        String strCD = ""; // 小盘打印长度
        Long dqmscd = 0L;
        String qxlb = "";
        String dyms = "";
        long qgcd;
        String sxbh = abnormalShutdownDto.getSxbh();
        String xptm;
        BigDecimal cd = BigDecimal.valueOf(abnormalShutdownDto.getYscd()).setScale(2, RoundingMode.HALF_UP);
        String maxxh;
        String xh;
        Boolean SFFQ = fiberInfoUploadService.uploadDataCheckFQ(ph);
        Boolean SFGL = fiberInfoUploadService.uploadDataCheckGL(ph);

        if (SFFQ || (cd.doubleValue() < 2.05)) {
            CalculateQGCDResponse calculateQGCDResponse = scSxService.calculateQGCD(ph);
            List<ScSx2> recordCount = scSx2Mapper.findByFilterCode(ph);
            if (recordCount.size() >= 1) {
                maxxh = scSx2Mapper.getMaxId(sxbh);
                if (!fiberInfoUploadService.updateDetailQGCD(calculateQGCDResponse, sxbh, String.valueOf(maxxh), cd.multiply(new BigDecimal(1000).setScale(2, RoundingMode.HALF_UP)).doubleValue(), abnormalShutdownDto.getInitialTime())) {
                    log.info("update qgcd error");
                }
            } else {
                xh = getxh(sxbh);
                xptm = "";
                ewz = Double.valueOf(fiberInfoUploadService.getTotalLen(ph)) * 1000;
                CD = 0L;
                DQQK = "abnormity";
                if (SFFQ) {
                    dqcd = 0;
                    qgcd = cd.longValue() * 1000;
                } else {
                    dqcd = cd.longValue() * 1000;
                    qgcd = 0;
                }
                FilterDetailUploadDto filterDetailUploadDto = new FilterDetailUploadDto();
                filterDetailUploadDto.setSxbh(sxbh);
                filterDetailUploadDto.setXh(xh);
                filterDetailUploadDto.setXptm(xptm);
                filterDetailUploadDto.setEwz(ewz);
                filterDetailUploadDto.setCd(CD);
                filterDetailUploadDto.setDqqk(DQQK);
                filterDetailUploadDto.setDqcd(dqcd);
                filterDetailUploadDto.setQxlb(qxlb);
                filterDetailUploadDto.setQgcd((double) qgcd);
                filterDetailUploadDto.setBlyy(abnormalShutdownDto.getBlyy());
                filterDetailUploadDto.setIsfg(0L);
                filterDetailUploadDto.setDqmscd(0L);
                filterDetailUploadDto.setAccoutId(abnormalShutdownDto.getAccoutId());
                filterDetailUploadDto.setBz(abnormalShutdownDto.getBz());
                filterDetailUploadDto.setPh(abnormalShutdownDto.getPh());
                filterDetailUploadDto.setUsername(abnormalShutdownDto.getUsername());
                filterDetailUploadDto.setGlqk(abnormalShutdownDto.getGlqk());
                filterDetailUploadDto.setColor(abnormalShutdownDto.getColor());
                filterDetailUploadDto.setStartDate(abnormalShutdownDto.getStartDate());
                filterDetailUploadDto.setYl(abnormalShutdownDto.getYl());
                filterDetailUploadDto.setPj(abnormalShutdownDto.getPj());
                filterDetailUploadDto.setXj(abnormalShutdownDto.getXj());
                if (filterUploadService.SXdetail(filterDetailUploadDto)) {
                    response.setStatus(true);
                    response.setPrintFlag(false);
                    return response;
                }
            }
        } else {
            String pj = abnormalShutdownDto.getPj();
            Double kpcd = 0d;
            if (StringUtils.equals(CommonConstant.FiftyKilometreDish, pj) || StringUtils.equals(CommonConstant.SixtyOneKilometreDish, pj) || StringUtils.equals(CommonConstant.FiftyKilometreHengLiL1,pj) || StringUtils.equals(CommonConstant.FiftyKilometreHengLiL2,pj) || StringUtils.equals(CommonConstant.FiftyKilometreHengLiL3,pj)) {
                kpcd = 2.07 + 1;
            } else {
                kpcd = 2.07 + 0.6;
            }
            if (cd.doubleValue() >= 2.05 && cd.doubleValue() < kpcd) {
                xh = getxh(sxbh);
                String defaultxpbh = ph + "00";
                xptm = fiberInfoUploadService.getxptm(sxbh, defaultxpbh, ph);
                ewz = Long.parseLong(fiberInfoUploadService.getTotalLen(ph)) * 1000;
                DQQK = "abnormity";
                if (StringUtils.equals(region, "四区")) {
                    if (StringUtils.equals(CommonConstant.FiftyKilometreDish, pj) || StringUtils.equals(CommonConstant.SixtyOneKilometreDish, pj)) {
                        dqcd = 170;
                        CD = cd.multiply(new BigDecimal(1000)).longValue();
                    }
                } else {
                    if (StringUtils.equals(CommonConstant.FiftyKilometreDish, pj) || StringUtils.equals(CommonConstant.SixtyOneKilometreDish, pj)) {
                        CD = cd.multiply(new BigDecimal(1000)).longValue();
                        dqcd = 130;
                    } else {
                        CD = cd.multiply(new BigDecimal(1000)).longValue();
                        dqcd = 130;
                    }
                }
                isfg = 0;
                dqmscd = 0L;
                qxlb = "";
                qgcd = 0;
                dyms = "未重筛";
                strCD = new BigDecimal(CD).divide(new BigDecimal(1000), 2, RoundingMode.HALF_UP).toString();
                FilterDetailUploadDto filterDetailUploadDto = new FilterDetailUploadDto();
                filterDetailUploadDto.setSxbh(sxbh);
                filterDetailUploadDto.setXh(xh);
                filterDetailUploadDto.setXptm(xptm);
                filterDetailUploadDto.setEwz(ewz);
                filterDetailUploadDto.setCd(CD);
                filterDetailUploadDto.setDqqk(DQQK);
                filterDetailUploadDto.setDqcd(abnormalShutdownDto.getDqcd());
                filterDetailUploadDto.setQxlb(qxlb);
                filterDetailUploadDto.setQgcd((double) qgcd);
                filterDetailUploadDto.setBlyy("");
                filterDetailUploadDto.setIsfg(0L);
                filterDetailUploadDto.setDqmscd(0L);
                filterDetailUploadDto.setAccoutId(abnormalShutdownDto.getAccoutId());
                filterDetailUploadDto.setBz(abnormalShutdownDto.getBz());
                filterDetailUploadDto.setPh(abnormalShutdownDto.getPh());
                filterDetailUploadDto.setUsername(abnormalShutdownDto.getUsername());
                filterDetailUploadDto.setGlqk(abnormalShutdownDto.getGlqk());
                filterDetailUploadDto.setColor(abnormalShutdownDto.getColor());
                filterDetailUploadDto.setStartDate(abnormalShutdownDto.getStartDate());
                filterDetailUploadDto.setYl(abnormalShutdownDto.getYl());
                filterDetailUploadDto.setPj(abnormalShutdownDto.getPj());
                filterDetailUploadDto.setXj(abnormalShutdownDto.getXj());
                if (filterUploadService.SXdetail(filterDetailUploadDto)) {
                    List<ScSx2> count = scSx2Mapper.selectByXptm(xptm);
                    if (count.size() != 0) {
                        response.setStatus(true);
                        response.setPh(ph);
                        response.setXptm(xptm);
                        response.setPrintFlag(true);
                        return response;
                    } else {
                        response.setStatus(true);
                        response.setPrintFlag(false);
                        return response;
                    }
                }
            } else {
                xh = getxh(sxbh);
                String defaultPh = ph + "00";
                xptm = fiberInfoUploadService.getxptm(sxbh, defaultPh, ph);
                ewz = Double.parseDouble(fiberInfoUploadService.getTotalLen(ph)) * 1000;
                DQQK = "abnormity";
                if (StringUtils.contains(pj, "61") || StringUtils.contains(pj, "50") || StringUtils.contains(pj, "100")) {
                    if (StringUtils.equals(CommonConstant.SixtyOneKilometreDish, pj)) {
                        if (StringUtils.equals(machineCategory, "D")) {
                            if (StringUtils.equals(region, "四区")) {
                                dqcd = 0 + 170 + 1000;
                                CD = cd.setScale(2, RoundingMode.HALF_UP).multiply(new BigDecimal(1000)).subtract(new BigDecimal(1000)).longValue();
                            } else if (StringUtils.equals(region, "五区")) {
                                dqcd = 0 + 1000;
                                CD = cd.setScale(2, RoundingMode.HALF_UP).subtract(new BigDecimal(1000)).longValue();
                            } else {
                                dqcd = 0 + 1000;
                                CD = cd.setScale(2, RoundingMode.HALF_UP).multiply(new BigDecimal(1000)).subtract(new BigDecimal(1000)).longValue();
                            }
                            dqmscd = 0L;
                            dyms = "外端1.0km未处理";
                        }
                        if (StringUtils.equals(machineCategory, "N")) {
                            if (StringUtils.equals(region, "五区")) {
                                dqcd = 1000;
                                CD = cd.setScale(2, RoundingMode.HALF_UP).multiply(new BigDecimal(1000)).subtract(new BigDecimal(1000)).longValue();
                            } else {
                                dqcd = 1000;
                                CD = cd.setScale(2, RoundingMode.HALF_UP).subtract(new BigDecimal(1000)).longValue();
                            }
                            DQQK = "abnormity";
                            dqmscd = 0L;
                            dyms = "外端1.0km未处理";
                        }
                        if (StringUtils.equals(machineCategory, "Y")) {
                            BigDecimal len = BigDecimal.valueOf(Double.parseDouble(abnormalShutdownDto.getPyccd())).multiply(new BigDecimal(1000)).add(new BigDecimal(600)).setScale(2, RoundingMode.HALF_UP);
                            dqcd = len.longValue();
                            CD = cd.multiply(new BigDecimal(1000)).subtract(new BigDecimal(1000)).longValue();
                            DQQK = "abnormity";
                            dqmscd = 0L;
                            dyms = "外端1.0km未处理";
                        }
                    }
                    if (StringUtils.contains(pj, "100")) {
                        if (StringUtils.equals(machineCategory, "D")) {
                            if (StringUtils.equals(region, "四区")) {
                                dqcd = 0 + 170 + 1000;
                                CD = cd.setScale(2, RoundingMode.HALF_UP).multiply(new BigDecimal(1000)).subtract(new BigDecimal(1200)).longValue();
                            } else if (StringUtils.equals(region, "五区")) {
                                dqcd = 0 + 1000;
                                CD = cd.setScale(2, RoundingMode.HALF_UP).subtract(new BigDecimal(1200)).longValue();
                            } else {
                                dqcd = 0 + 1000;
                                CD = cd.setScale(2, RoundingMode.HALF_UP).multiply(new BigDecimal(1000)).subtract(new BigDecimal(1200)).longValue();
                            }
                            dqmscd = 0L;
                            dyms = "外端1.2m未处理";
                        }
                        if (StringUtils.contains(machineCategory, "N")) {
                            if (StringUtils.equals(region, "五区")) {
                                dqcd = 1000;
                                CD = cd.setScale(2, RoundingMode.HALF_UP).multiply(new BigDecimal(1000)).subtract(new BigDecimal(1200)).longValue();
                            } else {
                                dqcd = 1000;
                                CD = cd.setScale(2, RoundingMode.HALF_UP).subtract(new BigDecimal(1200)).longValue();
                            }
                            DQQK = "abnormity";
                            dqmscd = 0L;
                            dyms = "外端1.2km未处理";
                        }
                    }
                    if (StringUtils.contains(pj, "50")) {
                        if (StringUtils.equals(machineCategory, "D")) {
                            if (StringUtils.equals(region, "四区")) {
                                dqcd = 0 + 170 + 1000;
                                CD = cd.setScale(2, RoundingMode.HALF_UP).multiply(new BigDecimal(1000)).subtract(new BigDecimal(1000)).longValue();
                                dqmscd = 0L;
                                dyms = "外端1.0km未处理";
                            } else {
                                dqcd = 0 + 1000;
                                CD = cd.setScale(2, RoundingMode.HALF_UP).multiply(new BigDecimal(1000)).subtract(new BigDecimal(1000)).longValue();
                                dqmscd = 0L;
                                dyms = "外端1.0km未处理";
                            }
                        }
                        if (StringUtils.equals(machineCategory, "N")) {
                            if (StringUtils.equals(region, "五区")) {
                                dqcd = 1000;
                                CD = cd.multiply(new BigDecimal(1000)).subtract(new BigDecimal(1000)).longValue();
                                DQQK = "abnormity";
                                dqmscd = 0L;
                                dyms = "外端1.0km未处理";
                            } else {
                                dqcd = 1000;
                                CD = cd.subtract(new BigDecimal(1000)).longValue();
                                DQQK = "abnormity";
                                dqmscd = 0L;
                                dyms = "外端1.0km未处理";
                            }
                        }
                        if (StringUtils.equals(machineCategory, "Y")) {
                            long pyccd = new BigDecimal(abnormalShutdownDto.getPyccd()).setScale(2, RoundingMode.HALF_UP).longValue();
                            dqcd = 0 + 1000 + pyccd;
                            CD = cd.multiply(new BigDecimal(1000)).subtract(new BigDecimal(1000)).longValue();
                            DQQK = "abnormity";
                            dqmscd = 0L;
                            dyms = "外端1.0km未处理";
                        }
                    }
                } else {
                    if (StringUtils.equals(machineCategory, "D")) {
                        if (StringUtils.equals(region, "四区")) {
                            dqcd = 0 + 600 + 700;
                        } else {
                            dqcd = 0 + 600 + 130;
                        }
                        CD = cd.multiply(new BigDecimal(1000)).subtract(new BigDecimal(600)).longValue();
                        dqmscd = 0L;
                        dyms = "外端600m未处理";
                    }
                    if (StringUtils.equals(machineCategory, "N")) {
                        if (StringUtils.equals(region, "五区")) {
                            dqcd = 1000;
                            CD = cd.setScale(2, RoundingMode.HALF_UP).multiply(new BigDecimal(1000)).subtract(new BigDecimal(1000)).longValue();
                        } else {
                            dqcd = 600;
                            CD = new BigDecimal(abnormalShutdownDto.getHlcd()).subtract(new BigDecimal(600)).setScale(2, RoundingMode.HALF_UP).longValue();
                        }
                        DQQK = "abnormity";
                        dqmscd = 0L;
                        dyms = "外端1.0km未处理";
                    }
                    if (StringUtils.equals(machineCategory, "Y")) {
                        long pyccd = new BigDecimal(abnormalShutdownDto.getPyccd()).setScale(2, RoundingMode.HALF_UP).longValue();
                        dqcd = 0 + 600 + pyccd;
                        CD = cd.setScale(2, RoundingMode.HALF_UP).multiply(new BigDecimal(1000)).subtract(new BigDecimal(1000)).longValue();
                        DQQK = "abnormity";
                        dqmscd = 0L;
                        dyms = "外端600m未处理";
                    }
                }
                qxlb = "";
                qgcd = 0;
                strCD = new BigDecimal(CD).divide(new BigDecimal(1000), 2, RoundingMode.HALF_UP).toString();
                FilterDetailUploadDto filterDetailUploadDto = new FilterDetailUploadDto();
                filterDetailUploadDto.setSxbh(sxbh);
                filterDetailUploadDto.setXh(xh);
                filterDetailUploadDto.setXptm(xptm);
                filterDetailUploadDto.setEwz(ewz);
                filterDetailUploadDto.setCd(CD);
                filterDetailUploadDto.setDqqk(DQQK);
                filterDetailUploadDto.setDqcd(dqcd);
                filterDetailUploadDto.setQxlb(qxlb);
                filterDetailUploadDto.setQgcd(Double.valueOf(qgcd));
                filterDetailUploadDto.setBlyy("");
                filterDetailUploadDto.setIsfg(0L);
                filterDetailUploadDto.setDqmscd(0L);
                filterDetailUploadDto.setAccoutId(abnormalShutdownDto.getAccoutId());
                filterDetailUploadDto.setBz(abnormalShutdownDto.getBz());
                filterDetailUploadDto.setPh(abnormalShutdownDto.getPh());
                filterDetailUploadDto.setUsername(abnormalShutdownDto.getUsername());
                filterDetailUploadDto.setGlqk(abnormalShutdownDto.getGlqk());
                filterDetailUploadDto.setColor(abnormalShutdownDto.getColor());
                filterDetailUploadDto.setPyccd(Double.valueOf(abnormalShutdownDto.getPyccd()));
                filterDetailUploadDto.setStartDate(abnormalShutdownDto.getStartDate());
                filterDetailUploadDto.setYl(abnormalShutdownDto.getYl());
                filterDetailUploadDto.setPj(abnormalShutdownDto.getPj());
                filterDetailUploadDto.setXj(abnormalShutdownDto.getXj());
                if (filterUploadService.SXdetail(filterDetailUploadDto)) {
                    List<ScSx2> count = scSx2Mapper.selectByXptm(xptm);
                    if (count.size() != 0) {
                        response.setStatus(true);
                        response.setPrintFlag(true);
                        response.setDyms(dyms);
                        response.setXptm(xptm);
                        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
                        response.setComputerIP(ServletUtil.getClientIP(requestAttributes.getRequest()));
                        return response;
                    } else {
                        response.setStatus(true);
                        response.setPrintFlag(false);
                        return response;
                    }
                }
            }

        }

        return response;
    }

    /**
     * 获取序号
     * 如果没有则返回01
     * 如果有就在此基础上+1
     *
     * @param sxbh 筛选编号
     * @return 序号
     */
    private String getxh(String sxbh) {
        String xh = scSx2Mapper.getxh(sxbh);
        if (StringUtils.isNotEmpty(xh)) {
            xh = NumberUtils.addNum2(xh);
        } else {
            xh = "01";
        }
        return xh;
    }


}
