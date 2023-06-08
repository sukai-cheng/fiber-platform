package com.ht.screening.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ht.base.domain.AjaxResult;
import com.ht.base.utils.bean.BeanUtils;
import com.ht.screening.dto.DrawBenchDto;
import com.ht.screening.dto.FiberDrawingDefectInfo;
import com.ht.screening.dto.FilterUploadDto;
import com.ht.screening.entity.ScSx;
import com.ht.screening.entity.ScSx2;
import com.ht.screening.mapper.FiberCutMapper;
import com.ht.screening.mapper.ScLs1Mapper;
import com.ht.screening.mapper.ScSx2Mapper;
import com.ht.screening.mapper.ScSxMapper;
import com.ht.screening.request.FilterInfoRequest;
import com.ht.screening.service.PaperInfoService;
import com.ht.screening.service.ScSxService;
import com.ht.screening.vo.FiberFilterMainDiskVo;
import com.ht.screening.vo.FiberFilterSmallDiskVo;
import com.ht.screening.vo.FiberFilterVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.ht.base.utils.Ini4jUtils.getPropertiesFromIni;

/**
 * 获取筛选信息
 *
 * @author chengsukai
 */
@Service
@Slf4j
public class ScSxServiceImpl extends ServiceImpl<ScSxMapper, ScSx> implements ScSxService {

    @Resource
    private ScSxMapper mainPlateMapper;

    @Resource
    private ScLs1Mapper scLs1Mapper;

    @Resource
    private ScSxMapper scSxMapper;

    @Resource
    private ScSx2Mapper accessoryPlateMapper;

    @Resource
    private FiberCutMapper fiberCutMapper;

    @Resource
    private JcYzbServiceImpl jcYzbService;

    @Resource
    FilterUploadServiceImpl filterUploadService;

    @Resource
    PaperInfoService paperInfoService;

    @Override
    public AjaxResult getMainPlateInfo(FilterInfoRequest request) {
        String mainDiskCode = request.getFiberDiskCode();
        if (StringUtils.isEmpty(mainDiskCode) || StringUtils.isEmpty(request.getAccountId()) || StringUtils.isEmpty(request.getBz())) {
            return AjaxResult.error("查询请求信息不全");
        }
        // 筛选信息上传
        getSxbh(request.getAccountId(), request.getBz(), mainDiskCode);
        ScSx scsx = mainPlateMapper.findByMainDiskCode(mainDiskCode);
        if (scsx == null) {
            return AjaxResult.error("大盘号无效或无筛选数据");
        }
        FiberFilterMainDiskVo fiberFilterInfo = new FiberFilterMainDiskVo();
        BeanUtils.copyProperties(scsx, fiberFilterInfo);
        fiberFilterInfo.setCategoryName(jcYzbService.getCategoryName(mainDiskCode));
        List<FiberFilterSmallDiskVo> accessoryPlateInfo = getAccessoryPlateInfo(scsx.getYsph());
        FiberFilterVo fiberFilterVo = new FiberFilterVo();
        fiberFilterVo.setFiberFilterMainDiskVo(fiberFilterInfo);
        fiberFilterVo.setFilterSmallDiskVoList(accessoryPlateInfo);

        return AjaxResult.success(fiberFilterVo);
    }

    @Override
    public List<FiberFilterSmallDiskVo> getAccessoryPlateInfo(String filterCode) {
        List<ScSx2> scsxList = accessoryPlateMapper.findByFilterCode(filterCode);
        List<FiberFilterSmallDiskVo> filterSmallDiskVoList = new ArrayList<>();
        for (ScSx2 sx2 : scsxList) {
            FiberFilterSmallDiskVo fiberFilterSmallDiskVo = new FiberFilterSmallDiskVo();
            BeanUtils.copyProperties(sx2, fiberFilterSmallDiskVo);
            filterSmallDiskVoList.add(fiberFilterSmallDiskVo);
        }
        return filterSmallDiskVoList;
    }

    @Override
    public String calTotalLen(String mainDiskCode) {
        String totalLen = mainPlateMapper.calTotalLen(mainDiskCode);
        BigDecimal res = BigDecimal.valueOf(Double.parseDouble(totalLen));
        return res.divide(new BigDecimal(1000), 2, BigDecimal.ROUND_HALF_UP).toString();
    }


    @Override
    public String calFilterLen(String mainDiskCode) {

        DrawBenchDto drawBenchInfo = scLs1Mapper.getDrawBenchInfo(mainDiskCode);
        if (drawBenchInfo == null) {
            return "";
        }
        // 获取已筛总长度
        Double totalLen = Double.parseDouble(calTotalLen(mainDiskCode));
        // 切割长度
        Double cutLen = drawBenchInfo.getCutLen();
        // 大盘长度
        Double mainDiskLen = Double.parseDouble(drawBenchInfo.getMainDiskLen());
        // rstqx
        List<FiberDrawingDefectInfo> fiberDrawingDefectInfos = fiberCutMapper.fiberCutDetail(mainDiskCode);

        BigDecimal filterLen = BigDecimal.valueOf(calculateQGCD(totalLen, cutLen, mainDiskLen, fiberDrawingDefectInfos)).setScale(2, RoundingMode.HALF_UP);


        char c = mainDiskCode.charAt(mainDiskCode.length() - 1);
        if (StringUtils.equalsIgnoreCase(String.valueOf(Character.toUpperCase(c)), "Z")) {
            String xptmByPh = accessoryPlateMapper.getXptmByPh(mainDiskCode);
            if (StringUtils.isEmpty(xptmByPh)) {
                return String.valueOf(6.3);
            }
        }

        return String.valueOf(filterLen);
    }

    public static void main(String[] args) {
        String code = "48S23F9055XXL";
        System.out.println(code.charAt(code.length() - 1));
    }

    @Override
    public String getSxbh(String accountId, String bz, String ph) {
        //
        String sxbh = scSxMapper.getSxbh(ph);
        // 如果有筛选记录则直接返回筛选编号
        if (StringUtils.isNotEmpty(sxbh)) {
            return sxbh;
        } else {
            // 上传
            sxbh = paperInfoService.getPaperNo();
            FilterUploadDto filterUploadDto = new FilterUploadDto();
            filterUploadDto.setSxbh(sxbh);
            filterUploadDto.setYsph(ph);
            filterUploadDto.setScbz(bz);
            filterUploadDto.setScrq(new Date());
            filterUploadDto.setSbbh(getPropertiesFromIni().getText837());
            filterUploadDto.setGh(accountId);
            filterUploadDto.setFxzl(0.26);
            filterUploadDto.setSbzk("正常");
            filterUploadDto.setSxzl(0.5);
            filterUploadDto.setSxsd(2000);
            filterUploadDto.setSfqx("0");
            filterUploadDto.setSfqx("0");
            filterUploadDto.setZdr("");
            filterUploadDto.setZdrq(new Date());
            filterUploadDto.setChecker(null);
            filterUploadDto.setShrq(null);
            filterUploadDto.setGqcd(26.0);
            filterUploadDto.setYl(null);
            filterUploadDto.setLsrate(null);
            filterUploadDto.setMpsh(scLs1Mapper.getDrawBenchInfo(ph).getCommandOrder());
            filterUploadDto.setZlh(scLs1Mapper.getDrawBenchInfo(ph).getProductPlanNum());
            filterUploadDto.setLastupdatetime(new Date());
            filterUploadDto.setLastupdateaccountid(accountId);
            scLs1Mapper.getDrawBenchInfo(ph);
            filterUploadService.addXSMAIN(filterUploadDto);
        }
        return sxbh;
    }

    /**
     * 计算筛选长度
     *
     * @param totalLen                已筛选总长度
     * @param cutLen                  切割长度
     * @param mainDiskLen             大盘长度
     * @param fiberDrawingDefectInfos
     * @return
     */
    private Double calculateQGCD(Double totalLen, Double cutLen, Double mainDiskLen, List<FiberDrawingDefectInfo> fiberDrawingDefectInfos) {

        int q = 0;
        int i = 0;
        double isqc = 0;
        double QCCD = 0;
        double Xqcqcd = 0;
        double res = 0;
        String sblyy = "";
        String sqxlx = "";
        String sglqk = "";

        for (int index = 0; index < fiberDrawingDefectInfos.size() && q != 1; index++) {
            FiberDrawingDefectInfo drawingDefectInfo = fiberDrawingDefectInfos.get(index);
            if (totalLen < drawingDefectInfo.getStartPos()) {
                q = 1;
                if (totalLen + cutLen < drawingDefectInfo.getStartPos()) {
                    res = cutLen;
                    isqc = 0;
                    QCCD = 0;
                    Xqcqcd = 0;
                } else {
                    QCCD = drawingDefectInfo.getSlitterLen();
                    Xqcqcd = drawingDefectInfo.getStartPos() - totalLen;
                    if (Xqcqcd >= 2.05) {
                        res = Xqcqcd;
                        sqxlx = drawingDefectInfo.getDefectType();
                    } else {
                        res = Xqcqcd + QCCD;
                        sqxlx = drawingDefectInfo.getDefectType();
                    }
                }
                if (StringUtils.isNotEmpty(drawingDefectInfo.getIsDefective())) {
                    sqxlx = drawingDefectInfo.getDefectType();
                }
            }
            if (totalLen >= drawingDefectInfo.getStartPos() && totalLen < drawingDefectInfo.getEndPos() && StringUtils.equals(drawingDefectInfo.getIsExcision(), "yes")) {
                q = 1;
                if (drawingDefectInfo.getEndPos() - totalLen < 34) {
                    res = drawingDefectInfo.getEndPos() - totalLen;
                } else {
                    res = 34;
                }
            }
            sqxlx = drawingDefectInfo.getDefectType();
            log.info("Please cut");
            if (totalLen >= drawingDefectInfo.getStartPos() && totalLen < drawingDefectInfo.getEndPos() && StringUtils.equals(drawingDefectInfo.getIsIsolation(), "yes")) {
                q = 1;
                if (drawingDefectInfo.getEndPos() - totalLen < cutLen) {
                    res = drawingDefectInfo.getEndPos() - totalLen;
                } else {
                    res = cutLen;
                }
                sglqk = drawingDefectInfo.getIsolationReason();
                log.info("Please cut");
            }
            if (totalLen >= drawingDefectInfo.getStartPos() && totalLen < drawingDefectInfo.getEndPos() && StringUtils.equals(drawingDefectInfo.getIsDefective(), "yes")) {
                sblyy = drawingDefectInfo.getIsDefective();
            }
        }

        if (q == 0) {
            if (totalLen + cutLen <= mainDiskLen - 0.5) {
                res = cutLen;
            } else {
                res = mainDiskLen - totalLen - 0.5;
            }
        }

        return res;
    }


}


