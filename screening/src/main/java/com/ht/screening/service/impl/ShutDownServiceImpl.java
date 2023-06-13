package com.ht.screening.service.impl;


import com.ht.base.constant.CommonConstant;
import com.ht.base.utils.NumberUtils;
import com.ht.base.utils.StringUtils;
import com.ht.screening.dto.AbnormalShutdownDto;
import com.ht.screening.dto.FilterDetailUploadDto;
import com.ht.screening.dto.NormalShutdownDto;
import com.ht.screening.entity.ScSx2;
import com.ht.screening.mapper.ScSx2Mapper;
import com.ht.screening.mapper.ScSxMapper;
import com.ht.screening.response.AbnormalShutDownResponse;
import com.ht.screening.response.NormalShutDownResponse;
import com.ht.screening.service.ShutDownService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private ScSxMapper scSxMapper;

    @Override
    @Transactional
    public NormalShutDownResponse normalShutdown(NormalShutdownDto normalShutdownDto) {

        NormalShutDownResponse response = new NormalShutDownResponse();
        String ph = normalShutdownDto.getPh();
        long ewz;
        long CD;
        String DQQK;
        long dqcd;
        String qxlb;
        long qgcd;
        String sxbh = normalShutdownDto.getSxbh();
        String xptm;
        BigDecimal cd = BigDecimal.valueOf(normalShutdownDto.getCd()).setScale(2, RoundingMode.HALF_UP);
        Integer maxxh;
        String xh;
        Boolean SFFQ = fiberInfoUploadService.uploadDataCheckFQ(ph);
        Boolean SFGL = fiberInfoUploadService.uploadDataCheckGL(ph);
        if (SFFQ || (cd.doubleValue() < 2.05)) {
            List<ScSx2> recordCount = scSx2Mapper.findByFilterCode(ph);
            if (recordCount.size() >= 1) {
                maxxh = scSx2Mapper.getMaxId(sxbh);
                if (!SFFQ) {
                    if (!fiberInfoUploadService.updateDetailDQCD(sxbh, String.valueOf(maxxh), cd.longValue() * 1000, normalShutdownDto.getInitialTime())) {
                        log.info("update DQCD error");
                    } else {
                        if (!fiberInfoUploadService.updateDetailQGCD(sxbh, String.valueOf(maxxh), cd.longValue() * 1000, normalShutdownDto.getInitialTime())) {
                            log.info("update qgcd error");
                        }
                    }
                }
            } else {
                xh = getxh(sxbh);
                xptm = "";
                ewz = Long.parseLong(scSxMapper.calTotalLen(ph));
                CD = 0L;
                DQQK = "abnormity";
                dqcd = 0L;
                qxlb = "";
                qgcd = cd.longValue() * 1000;

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
                    response.setPrintFlag(false);
                    return response;
                }
            }
        } else {
            xh = getxh(sxbh);
            String defaultPh = ph + "00";
            xptm = fiberInfoUploadService.getxptm(sxbh, defaultPh);
            ewz = Long.parseLong(fiberInfoUploadService.getTotalLen(ph)) * 1000;
            BigDecimal cd1 = BigDecimal.valueOf(normalShutdownDto.getCd());
            CD = BigDecimal.valueOf(normalShutdownDto.getCd()).setScale(2, RoundingMode.HALF_UP).multiply(new BigDecimal(1000)).longValue();
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
            if (filterUploadService.SXdetail(filterDetailUploadDto)) {
                response.setStatus(true);
                response.setPrintFlag(true);
                return response;
            }
        }

        response.setStatus(false);
        response.setPrintFlag(false);
        return response;
    }

    @Override
    @Transactional
    public AbnormalShutDownResponse abnormalShutdown(AbnormalShutdownDto abnormalShutdownDto) {

        AbnormalShutDownResponse response = new AbnormalShutDownResponse();
        String ph = abnormalShutdownDto.getPh();
        long ewz;
        long CD = 0L;
        String machineCategory = "D";
        String region = "四区";
        String DQQK;
        long dqcd;
        Integer isfg = 0;
        String strCD = ""; // 小盘打印长度
        Long dqmscd = 0L;
        String qxlb = "";
        String dyms = "";
        long qgcd;
        String sxbh = abnormalShutdownDto.getSxbh();
        String xptm;
        BigDecimal cd = BigDecimal.valueOf(abnormalShutdownDto.getCd()).setScale(2, RoundingMode.HALF_UP);
        Integer maxxh;
        String xh;
        Boolean SFFQ = fiberInfoUploadService.uploadDataCheckFQ(ph);
        Boolean SFGL = fiberInfoUploadService.uploadDataCheckGL(ph);
        if (SFFQ || (cd.doubleValue() < 2.05)) {
            List<ScSx2> recordCount = scSx2Mapper.findByFilterCode(ph);
            if (recordCount.size() >= 1) {
                maxxh = scSx2Mapper.getMaxId(sxbh);
                if (!SFFQ) {
                    if (!fiberInfoUploadService.updateDetailDQCD(sxbh, String.valueOf(maxxh), cd.longValue() * 1000, abnormalShutdownDto.getInitialTime())) {
                        log.info("update DQCD error");
                    } else {
                        if (!fiberInfoUploadService.updateDetailQGCD(sxbh, String.valueOf(maxxh), cd.longValue() * 1000, abnormalShutdownDto.getInitialTime())) {
                            log.info("update qgcd error");
                        }
                    }
                }
            } else {
                xh = getxh(sxbh);
                xptm = "";
                ewz = Long.parseLong(scSxMapper.calTotalLen(ph));
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
            if (StringUtils.equals(CommonConstant.FifityKilometreDish, pj) || StringUtils.equals(CommonConstant.SixtyOneKilometreDish, pj)) {
                kpcd = 2.07 + 1;
            } else {
                kpcd = 2.07 + 0.6;
            }
            if (cd.doubleValue() > 2.05 && cd.doubleValue() < kpcd) {
                xh = getxh(sxbh);
                String defaultPh = ph + "00";
                xptm = fiberInfoUploadService.getxptm(sxbh, defaultPh);
                ewz = Long.parseLong(fiberInfoUploadService.getTotalLen(ph)) * 1000;
                DQQK = "abnormity";
                if (StringUtils.equals(region, "四区")) {
                    if (StringUtils.equals(CommonConstant.FifityKilometreDish, pj) || StringUtils.equals(CommonConstant.SixtyOneKilometreDish, pj)) {
                        dqcd = 170;
                        CD = cd.multiply(new BigDecimal(1000)).longValue();
                    }
                } else {
                    if (StringUtils.equals(CommonConstant.FifityKilometreDish, pj) || StringUtils.equals(CommonConstant.SixtyOneKilometreDish, pj)) {
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
                filterDetailUploadDto.setStartDate(abnormalShutdownDto.getStartDate());
                filterDetailUploadDto.setYl(abnormalShutdownDto.getYl());
                filterDetailUploadDto.setPj(abnormalShutdownDto.getPj());
                filterDetailUploadDto.setXj(abnormalShutdownDto.getXj());
                if (filterUploadService.SXdetail(filterDetailUploadDto)) {
                    List<ScSx2> count = scSx2Mapper.getXptm(xptm);
                    if (count.size() != 0) {
                        response.setStatus(true);
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
                xptm = fiberInfoUploadService.getxptm(sxbh, defaultPh);
                ewz = Long.parseLong(fiberInfoUploadService.getTotalLen(ph)) * 1000;
                DQQK = "abnormity";
                if (StringUtils.contains(pj, "61") || StringUtils.contains(pj, "50") || StringUtils.contains(pj, "100")) {
                    if (StringUtils.equals(CommonConstant.SixtyOneKilometreDish, pj)) {
                        if (StringUtils.equals(machineCategory, "D")) {
                            if (StringUtils.equals(region, "四区")) {
                                dqcd = 0 + 170 + 1000;
                                CD = cd.multiply(new BigDecimal(1000)).subtract(new BigDecimal(1000)).longValue();
                            } else if (StringUtils.equals(region, "五区")) {
                                dqcd = 0 + 1000;
                                CD = cd.subtract(new BigDecimal(1000)).longValue();
                            } else {
                                dqcd = 0 + 1000;
                                CD = cd.multiply(new BigDecimal(1000)).subtract(new BigDecimal(1000)).longValue();
                            }
                            dqmscd = 0L;
                            dyms = "外端1.0km未处理";
                        }
                        if (StringUtils.equals(machineCategory, "N")) {
                            if (StringUtils.equals(region, "五区")) {
                                dqcd = 1000;
                                CD = cd.multiply(new BigDecimal(1000)).subtract(new BigDecimal(1000)).longValue();
                            } else {
                                dqcd = 1000;
                                CD = cd.subtract(new BigDecimal(1000)).longValue();
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
                            dyms = "外端600m未处理";
                        }
                    }
                    if (StringUtils.contains(pj, "100")) {
                        if (StringUtils.equals(machineCategory, "D")) {
                            if (StringUtils.equals(region, "四区")) {
                                dqcd = 0 + 170 + 1000;
                                CD = cd.multiply(new BigDecimal(1000)).subtract(new BigDecimal(1200)).longValue();
                            } else if (StringUtils.equals(region, "五区")) {
                                dqcd = 0 + 1000;
                                CD = cd.subtract(new BigDecimal(1200)).longValue();
                            } else {
                                dqcd = 0 + 1000;
                                CD = cd.multiply(new BigDecimal(1000)).subtract(new BigDecimal(1200)).longValue();
                            }
                            dqmscd = 0L;
                            dyms = "外端1.2m未处理";
                        }
                        if (StringUtils.contains(machineCategory, "N")) {
                            if (StringUtils.equals(region, "五区")) {
                                dqcd = 1000;
                                CD = cd.multiply(new BigDecimal(1000)).subtract(new BigDecimal(1200)).longValue();
                            } else {
                                dqcd = 1000;
                                CD = cd.subtract(new BigDecimal(1200)).longValue();
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
                                CD = cd.multiply(new BigDecimal(1000)).subtract(new BigDecimal(1000)).longValue();
                                dqmscd = 0L;
                                dyms = "外端1.0km未处理";
                            } else {
                                dqcd = 0 + 1000;
                                CD = cd.multiply(new BigDecimal(1000)).subtract(new BigDecimal(1000)).longValue();
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
                            CD = cd.multiply(new BigDecimal(1000)).subtract(new BigDecimal(1000)).longValue();
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
                        CD = cd.multiply(new BigDecimal(1000)).subtract(new BigDecimal(1000)).longValue();
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
                filterDetailUploadDto.setDqcd(abnormalShutdownDto.getDqcd());
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
                filterDetailUploadDto.setStartDate(abnormalShutdownDto.getStartDate());
                filterDetailUploadDto.setYl(abnormalShutdownDto.getYl());
                filterDetailUploadDto.setPj(abnormalShutdownDto.getPj());
                filterDetailUploadDto.setXj(abnormalShutdownDto.getXj());
                if (filterUploadService.SXdetail(filterDetailUploadDto)) {
                    List<ScSx2> count = scSx2Mapper.getXptm(xptm);
                    if (count.size() != 0) {
                        response.setStatus(true);
                        response.setPrintFlag(true);
                        return response;
                    } else {
                        response.setStatus(true);
                        response.setPrintFlag(false);
                        return response;
                    }
                }
            }

        }

        response.setStatus(false);
        response.setPrintFlag(false);
        return response;
    }

    private String getxh(String sxbh) {
        String xh = scSx2Mapper.getxh(sxbh);
        if (StringUtils.isNotEmpty(xh)) {
            xh = NumberUtils.addNum2(xh);
        } else {
            xh = "01";
        }
        return xh;
    }

    public static void main(String[] args) {
        String str = "富鑫100公里";
        System.out.println(StringUtils.contains(str, "100"));
    }

}
