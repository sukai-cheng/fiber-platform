package com.ht.screening.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ht.base.domain.AjaxResult;
import com.ht.base.utils.bean.BeanUtils;
import com.ht.screening.dto.DrawBenchDto;
import com.ht.screening.dto.FiberDrawingDefectInfo;
import com.ht.screening.entity.ScSx;
import com.ht.screening.entity.ScSx2;
import com.ht.screening.mapper.FiberCutMapper;
import com.ht.screening.mapper.ScLs1Mapper;
import com.ht.screening.mapper.ScSx2Mapper;
import com.ht.screening.mapper.ScSxMapper;
import com.ht.screening.service.ScSxService;
import com.ht.screening.vo.FiberFilterMainDiskVo;
import com.ht.screening.vo.FiberFilterSmallDiskVo;
import com.ht.screening.vo.FiberFilterVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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
    private ScSx2Mapper accessoryPlateMapper;

    @Resource
    private FiberCutMapper fiberCutMapper;

    @Override
    public AjaxResult getMainPlateInfo(String mainDiskCode) {
        ScSx scsx = mainPlateMapper.findByMainDiskCode(mainDiskCode);
        FiberFilterMainDiskVo fiberFilterInfo = new FiberFilterMainDiskVo();
        BeanUtils.copyProperties(scsx, fiberFilterInfo);
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
        return mainPlateMapper.calTotalLen(mainDiskCode);
    }


    @Override
    public String calFilterLen(String mainDiskCode) {

        DrawBenchDto drawBenchInfo = scLs1Mapper.getDrawBenchInfo(mainDiskCode);
        // 获取已筛总长度
        Double totalLen = Double.parseDouble(calTotalLen(mainDiskCode));
        // 切割长度
        Double cutLen = drawBenchInfo.getCutLen();
        // 大盘长度
        Double mainDiskLen = Double.parseDouble(drawBenchInfo.getMainDiskLen());
        // rstqx
        List<FiberDrawingDefectInfo> fiberDrawingDefectInfos = fiberCutMapper.fiberCutDetail(mainDiskCode);

        Double filterLen = calculateQGCD(totalLen, cutLen, mainDiskLen, fiberDrawingDefectInfos);

        return String.valueOf(filterLen);
    }

    /**
     * 计算筛选长度
     *
     * @param totalLen
     * @param cutLen
     * @param mainDiskLen
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


