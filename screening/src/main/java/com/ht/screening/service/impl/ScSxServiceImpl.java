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
        String totalLen = calTotalLen(mainDiskCode);
        // 切割长度
        Double cutLen = drawBenchInfo.getCutLen();
        // 大盘长度
        String mainDiskLen = drawBenchInfo.getMainDiskLen();
        // rstqx
        List<FiberDrawingDefectInfo> fiberDrawingDefectInfos = fiberCutMapper.fiberCutDetail(mainDiskCode);


        return null;
    }

    /**
     *
     * @param totalLen
     * @param cutLen
     * @param mainDiskLen
     * @param fiberDrawingDefectInfos
     * @return
     */
    private String calculateQGCD(String totalLen, String cutLen, String mainDiskLen, List<FiberDrawingDefectInfo> fiberDrawingDefectInfos) {

        int q = 0;
        for (FiberDrawingDefectInfo drawingDefectInfo : fiberDrawingDefectInfos) {
            if (Double.parseDouble(totalLen) < Double.parseDouble(drawingDefectInfo.getStartPos())) {

            }

        }
        return null;
    }


}
