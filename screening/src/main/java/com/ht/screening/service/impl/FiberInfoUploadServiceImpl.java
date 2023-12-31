package com.ht.screening.service.impl;

import com.ht.base.utils.DateUtils;
import com.ht.base.utils.NumberUtils;
import com.ht.base.utils.bean.BeanUtils;
import com.ht.screening.dto.DpCheckResult2Dto;
import com.ht.screening.dto.FilterUploadDto;
import com.ht.screening.entity.ScSx;
import com.ht.screening.entity.ScSx2;
import com.ht.screening.mapper.ScLsQxqcMapper;
import com.ht.screening.mapper.ScSx2Mapper;
import com.ht.screening.mapper.ScSxMapper;
import com.ht.screening.mapper.ZlLshMapper;
import com.ht.screening.response.CalculateQGCDResponse;
import com.ht.screening.service.FiberInfoUploadService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;

/**
 * @author chengsukai
 */
@Service
@Slf4j
public class FiberInfoUploadServiceImpl implements FiberInfoUploadService {

    @Resource
    ScSxMapper scSxMapper;

    @Resource
    ScSx2Mapper scSx2Mapper;

    @Resource
    ScLsQxqcMapper scLsQxqcMapper;

    @Resource
    ZlLshMapper zlLshMapper;

    /**
     * 上传数据前置校验FQ
     *
     * @param diskNum 大盘号
     */
    @Override
    public Boolean uploadDataCheckFQ(String diskNum) {
        BigDecimal totalLen = BigDecimal.ZERO;
        String res = scSxMapper.calTotalLen(diskNum);
        if (StringUtils.isNotEmpty(res)) {
            totalLen = new BigDecimal(res).divide(new BigDecimal(1000), 2, BigDecimal.ROUND_HALF_UP);
        }
        int recordCount = scLsQxqcMapper.checkUploadDataFQ(diskNum, totalLen.doubleValue());
        return recordCount >= 1;

    }

    /**
     * 上传数据前置校验GL
     *
     * @param diskNum 大盘号
     */
    @Override
    public Boolean uploadDataCheckGL(String diskNum) {
        BigDecimal totalLen = BigDecimal.ZERO;
        String res = scSxMapper.calTotalLen(diskNum);
        if (StringUtils.isNotEmpty(res)) {
            totalLen = new BigDecimal(res).divide(new BigDecimal(1000), 2, BigDecimal.ROUND_HALF_UP);
        }
        int recordCount = scLsQxqcMapper.checkUploadDataGL(diskNum, totalLen.doubleValue());
        return recordCount >= 1;

    }


    /**
     * 断纤更新小盘信息
     *
     * @param filterCode  筛选编号
     * @param serialNum   序号
     * @param initialTime 初始时间
     */
    @Override
    public Boolean updateDetailDQCD(String filterCode, String serialNum, Double dqcd, Date initialTime) {
        Boolean aBoolean = checkFilterCodeIsExist(filterCode);
        if (aBoolean == false) {
            return false;
        }
        ScSx2 scSx2 = scSx2Mapper.findByFilterCodeAndSerialNumber(filterCode, serialNum);
        String qxlb = scSx2.getQxlb();
        String glqk = scSx2.getGlqk();
        String blyy = scSx2.getBlyy();
        Date lastupdatetime = scSx2.getLastupdatetime();
        String lastupdateaccountid = scSx2.getLastupdateaccountid();
        String gapTime = DateUtils.DateDiff(new Date(), initialTime);
        try {
            scSx2Mapper.updateScSx2DQCD(dqcd, Integer.valueOf(gapTime), qxlb, glqk, blyy, lastupdatetime, lastupdateaccountid, filterCode, serialNum);
            return true;
        } catch (Exception e) {
            log.info("数据库写入失败");
            return false;
        }
    }

    /**
     * 断纤更新小盘信息
     *
     * @param filterCode  筛选编号
     * @param serialNum   序号
     * @param initialTime 初始时间
     */
    @Override
    public Boolean updateDetailQGCD(CalculateQGCDResponse response, String filterCode, String serialNum, Double yscd, Date initialTime) {
        if (!checkFilterCodeIsExist(filterCode)) {
            return false;
        }
        ScSx2 scSx2 = scSx2Mapper.findByFilterCodeAndSerialNumber(filterCode, serialNum);
        long dqcd = scSx2.getDqcd().longValue();
        String qxlb = scSx2.getQxlb();
        String glqk = scSx2.getGlqk();
        BigDecimal qgcd = scSx2.getQgcd();
        String blyy = response.getDefectType();
        Date lastupdatetime = scSx2.getLastupdatetime();
        String lastupdateaccountid = scSx2.getLastupdateaccountid();
        String gapTime = DateUtils.DateDiff(new Date(), initialTime);
        try {
            if (yscd < response.getValue() * 1000) {
                BigDecimal cd = new BigDecimal(dqcd).add(new BigDecimal(yscd));
                scSx2Mapper.updateScSx2DQCD(cd.doubleValue(), Integer.valueOf(gapTime), qxlb, glqk, blyy, lastupdatetime, lastupdateaccountid, filterCode, serialNum);
            } else {
                BigDecimal cd = qgcd.add(new BigDecimal(yscd));
                scSx2Mapper.updateScSx2QGCD(cd.doubleValue(), Integer.valueOf(gapTime), qxlb, glqk, blyy, lastupdatetime, lastupdateaccountid, filterCode, serialNum);
            }
            return true;
        } catch (Exception e) {
            log.info("数据库写入失败");
            return false;
        }
    }

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

    /**
     * 判断筛选编号是否为空
     *
     * @param filterCode 筛选编号
     */
    private Boolean checkFilterCodeIsExist(String filterCode) {
        if (StringUtils.isEmpty(filterCode)) {
            log.info("筛选编号为空");
            return false;
        }
        return true;
    }

    public String getxptm(String sxbh, String defaultPh, String ph1) {
        String totalLen;
        String res = "";
        String maxxptm = "";
        String xh = "";
        totalLen = getTotalLen(ph1);
        String xptm = scSx2Mapper.getxptm(sxbh);
        if (StringUtils.isNotEmpty(xptm)) {
            maxxptm = xptm;
        } else {
            maxxptm = defaultPh.substring(0, 13) + "00";
        }
        xh = NumberUtils.addNum2(maxxptm.substring(13, 15));
        // 质量部留样
        if (scLsQxqcMapper.isLy(ph1, Double.valueOf(totalLen)).size() != 0) {
            xh = "00";
        }
        res = ph1.substring(0, 13) + xh;
        // 外端分切生成的小盘号带"-"
        List<DpCheckResult2Dto> dpCheckResult2DtoList = zlLshMapper.checkFromLsh2(ph1);
        if (dpCheckResult2DtoList.size() > 0) {
            res = ph1.substring(0, 13) + "-" + xh;
        }


        return res;
    }

    public String getTotalLen(String ph) {
        BigDecimal totalLen;
        String res = scSxMapper.calTotalLen(ph);
        if (StringUtils.isEmpty(res)) {
            totalLen = BigDecimal.ZERO;
        } else {
            totalLen = new BigDecimal(res).divide(new BigDecimal(1000), 2, RoundingMode.HALF_UP);
        }
        return String.valueOf(totalLen);
    }

    public static void main(String[] args) {
        String ph = "34H11LD639XXE";
        System.out.println(ph + "00");
//        String substring = ph.substring(13, 15);
//        System.out.println(substring);
    }

}
