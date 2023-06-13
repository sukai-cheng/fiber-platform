package com.ht.screening.service.impl;

import com.ht.base.utils.DateUtils;
import com.ht.base.utils.StringUtils;
import com.ht.base.utils.bean.BeanUtils;
import com.ht.screening.dto.FilterDetailUploadDto;
import com.ht.screening.dto.FilterUploadDto;
import com.ht.screening.entity.ScSx;
import com.ht.screening.entity.ScSx2;
import com.ht.screening.entity.SxLog;
import com.ht.screening.mapper.ScSx2Mapper;
import com.ht.screening.mapper.ScSxMapper;
import com.ht.screening.mapper.SxLogMapper;
import com.ht.screening.service.FilterUploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static com.ht.base.utils.Ini4jUtils.getPropertiesFromIni;

/**
 * 筛选数据上传实现类
 * @author chengsukai
 */
@Service
@Slf4j
public class FilterUploadServiceImpl implements FilterUploadService {

    @Resource
    ScSxMapper scSxMapper;

    @Resource
    private ScSx2Mapper scSx2Mapper;

    @Resource
    SxLogMapper sxLogMapper;

    /**
     * 筛选数据上传
     *
     * @param filterUploadDto 筛选数据上传对象
     */
    @Override
    public void addXSMAIN(FilterUploadDto filterUploadDto) {
        ScSx scSx = new ScSx();
        BeanUtils.copyProperties(filterUploadDto, scSx);
        scSxMapper.insert(scSx);
    }

    @Override
    public Boolean SXdetail(FilterDetailUploadDto filterDetailUploadDto) {

        Double dqcd = filterDetailUploadDto.getDqcd();
        String xptm = filterDetailUploadDto.getXptm();
        String strPxptm = xptm;
        String strsxbh = filterDetailUploadDto.getSxbh();
        String ysph = scSxMapper.getYsph(strsxbh);
        Integer yccs;
        if (dqcd > 0) {
            yccs = 1;
        } else {
            yccs = 0;
        }
        if (StringUtils.isEmpty(strsxbh)) {
            SxLog sxLog = new SxLog();
            sxLog.setLx(1);
            sxLog.setSxbh(strsxbh);
            sxLog.setXptm(filterDetailUploadDto.getXptm());
            sxLog.setDpph(filterDetailUploadDto.getPh());
            sxLog.setSxjt(getPropertiesFromIni().getText837());
            sxLogMapper.insert(sxLog);
            log.info("筛选编号为空");
            return false;
        }
        // 如果小盘条码不为空
        if (StringUtils.isNotEmpty(xptm)) {
            if (!StringUtils.equals(xptm.substring(0, 13), ysph)) {
                SxLog sxLog = new SxLog();
                sxLog.setLx(2);
                sxLog.setSxbh(strsxbh);
                sxLog.setXptm(filterDetailUploadDto.getXptm());
                sxLog.setDpph(filterDetailUploadDto.getPh());
                sxLog.setSxjt(getPropertiesFromIni().getText837());
                sxLogMapper.insert(sxLog);
                log.info("小盘1生成错误");
                return false;
            }
        }
        List<ScSx2> res = scSx2Mapper.getXptm(strsxbh);
        if (res.size() > 0) {
            SxLog sxLog = new SxLog();
            sxLog.setLx(2);
            sxLog.setSxbh(strsxbh);
            sxLog.setXptm(filterDetailUploadDto.getXptm());
            sxLog.setDpph(filterDetailUploadDto.getPh());
            sxLog.setSxjt(getPropertiesFromIni().getText837());
            sxLog.setDates(new Date());
            sxLogMapper.insert(sxLog);
            log.info("小盘2生成错误");
            return false;
        }
        SxLog sxLog = new SxLog();
        sxLog.setLx(4);
        sxLog.setSxbh(strsxbh);
        sxLog.setXptm(filterDetailUploadDto.getXptm());
        sxLog.setDpph(filterDetailUploadDto.getPh());
        sxLog.setSxjt(getPropertiesFromIni().getText837());
        sxLogMapper.insert(sxLog);
        log.info("小盘2生成错误");

        if (StringUtils.equals(xptm.substring(0, 13), ysph) || StringUtils.isEmpty(xptm)) {
            if (StringUtils.equals(getPropertiesFromIni().getText837(), "N")) {
                ScSx2 scSx2 = new ScSx2();
                scSx2.setSxbh(strsxbh);
                scSx2.setXh(filterDetailUploadDto.getXh());
                scSx2.setXptm(xptm);
                scSx2.setEwz(BigDecimal.valueOf(filterDetailUploadDto.getEwz()));
                scSx2.setCd(BigDecimal.valueOf(filterDetailUploadDto.getCd()));
                scSx2.setDqqk(filterDetailUploadDto.getDqqk());
                scSx2.setDqcd(BigDecimal.valueOf(filterDetailUploadDto.getDqcd()));
                scSx2.setQxlb(filterDetailUploadDto.getQxlb());
                scSx2.setQgcd(BigDecimal.valueOf(filterDetailUploadDto.getQgcd()));
                scSx2.setLabour(filterDetailUploadDto.getAccoutId());
                scSx2.setSxshr(filterDetailUploadDto.getUsername());
                scSx2.setBlyy(filterDetailUploadDto.getBlyy());
                scSx2.setGlqk(filterDetailUploadDto.getGlqk());
                scSx2.setCrdate(new Date());
                scSx2.setStime(filterDetailUploadDto.getStartDate());
                scSx2.setEtime(new Date());
                scSx2.setSyl(filterDetailUploadDto.getYl());
                scSx2.setPj(filterDetailUploadDto.getPj());
                scSx2.setXj(filterDetailUploadDto.getXj());
                scSx2.setIsfg(0);
                scSx2.setDqmscd(BigDecimal.ZERO);
                scSx2.setSbbhd(getPropertiesFromIni().getText836());
                scSx2.setIsdy(2);
                scSx2.setDqcd(BigDecimal.valueOf(yccs));
                scSx2.setSxms(2); // todo 筛选模式不确定
                scSx2.setLastupdatetime(new Date());
                scSx2.setLastupdateaccountid(filterDetailUploadDto.getUsername());

                scSx2Mapper.insert(scSx2);
            }
            if (StringUtils.equals(getPropertiesFromIni().getText837(), "D") || StringUtils.equals(getPropertiesFromIni().getText837(), "Y")) {
                ScSx2 scSx2 = new ScSx2();
                scSx2.setSxbh(strsxbh);
                scSx2.setXh(filterDetailUploadDto.getXh());
                scSx2.setXptm(xptm);
                scSx2.setEwz(BigDecimal.valueOf(filterDetailUploadDto.getEwz()));
                scSx2.setCd(BigDecimal.valueOf(filterDetailUploadDto.getCd()));
                scSx2.setDqqk(filterDetailUploadDto.getDqqk());
                scSx2.setDqcd(BigDecimal.valueOf(filterDetailUploadDto.getDqcd()));
                scSx2.setQxlb(filterDetailUploadDto.getQxlb());
                scSx2.setQgcd(BigDecimal.valueOf(filterDetailUploadDto.getQgcd()));
                scSx2.setLabour(filterDetailUploadDto.getAccoutId());
                scSx2.setSxshr(filterDetailUploadDto.getUsername());
                scSx2.setBlyy(filterDetailUploadDto.getBlyy());
                scSx2.setGlqk(filterDetailUploadDto.getGlqk());
                scSx2.setCrdate(new Date());
                scSx2.setStime(filterDetailUploadDto.getStartDate());
                scSx2.setEtime(new Date());
                scSx2.setSyl(filterDetailUploadDto.getYl());
                scSx2.setPj(filterDetailUploadDto.getPj());
                scSx2.setXj(filterDetailUploadDto.getXj());
                scSx2.setIsfg(0);
                scSx2.setDqmscd(BigDecimal.ZERO);
                scSx2.setSbbhd(getPropertiesFromIni().getText836());
                scSx2.setIsdy(2);
                scSx2.setDqcd(BigDecimal.valueOf(yccs));
                scSx2.setSxms(null);
                scSx2.setLastupdatetime(new Date());
                scSx2.setLastupdateaccountid(filterDetailUploadDto.getUsername());

                scSx2Mapper.insert(scSx2);
            }
            return true;
        }
        return false;
    }

    /**
     * 更新断纤长度
     *
     * @param sxbh
     * @param xh
     * @param dqcd
     * @param qxlx
     * @param glqk
     * @param blyy
     * @param startDrawingTime
     * @param accountId
     * @return
     */
    public Boolean updateDetailDQCD(String sxbh, String xh, Long dqcd, String qxlx, String glqk, String blyy, Date startDrawingTime, String accountId) {
        if (StringUtils.isEmpty(sxbh)) {
            log.info("筛选编号为空");
            return false;
        }
        if (StringUtils.isEmpty(qxlx)) {
            log.info("切割原因为空");
        }
        // 计算小盘开始拉时间和当前时间相差的分钟数
        String diff = DateUtils.DateDiff(new Date(), startDrawingTime);
        scSx2Mapper.updateScSx2DQCD(dqcd, Integer.valueOf(diff), qxlx, glqk, blyy, new Date(), accountId, sxbh, xh);
        // todo 前端要清空不良原因,缺陷类别,隔离情况
        return true;
    }


    /**
     * 更新切割长度
     *
     * @param sxbh
     * @param xh
     * @param qgcd
     * @param qxlx
     * @param glqk
     * @param blyy
     * @param startDrawingTime
     * @param accountId
     * @return
     */
    public Boolean updateDetailQGCD(String sxbh, String xh, Long qgcd, String qxlx, String glqk, String blyy, Date startDrawingTime, String accountId) {
        if (StringUtils.isEmpty(sxbh)) {
            log.info("筛选编号为空");
            return false;
        }
        if (StringUtils.isEmpty(qxlx)) {
            log.info("切割原因为空");
        }
        // 计算小盘开始拉时间和当前时间相差的分钟数
        String diff = DateUtils.DateDiff(new Date(), startDrawingTime);
        scSx2Mapper.updateScSx2QGCD(qgcd, Integer.valueOf(diff), qxlx, glqk, blyy, new Date(), accountId, sxbh, xh);
        // todo 前端要清空不良原因,缺陷类别,隔离情况
        return true;
    }


}
