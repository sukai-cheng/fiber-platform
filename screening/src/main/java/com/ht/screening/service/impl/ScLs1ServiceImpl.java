package com.ht.screening.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ht.base.constant.CommonConstant;
import com.ht.base.domain.AjaxResult;
import com.ht.screening.dto.DrawBenchDto;
import com.ht.screening.entity.ScLs1;
import com.ht.screening.mapper.ScLs1Mapper;
import com.ht.screening.response.CalculateQGCDResponse;
import com.ht.screening.service.ScLs1Service;
import com.ht.screening.vo.DrawBenchVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author chengsukai
 */
@Service
public class ScLs1ServiceImpl extends ServiceImpl<ScLs1Mapper, ScLs1> implements ScLs1Service {

    @Resource
    private ScLs1Mapper scLs1Mapper;

    @Resource
    private ScSxServiceImpl scSxService;

    /**
     * 获取拉丝信息
     *
     * @param fiberDiskNum 光纤盘号
     */
    @Override
    public AjaxResult getDrawBenchInfo(String fiberDiskNum) {
        DrawBenchVo drawBenchVo = new DrawBenchVo();
        DrawBenchDto drawBenchInfo = scLs1Mapper.getDrawBenchInfo(fiberDiskNum);
        if (drawBenchInfo == null) {
            return AjaxResult.error("没有拉丝数据");
        }
        CalculateQGCDResponse qgcdResponse = scSxService.calFilterLen(fiberDiskNum);
        String totalLen = scSxService.calTotalLen(fiberDiskNum);
        String filterLen = String.valueOf(BigDecimal.valueOf(qgcdResponse.getValue()).setScale(2, RoundingMode.HALF_UP));
        drawBenchVo.setTotalLen(totalLen);
        drawBenchVo.setFilterLen(filterLen);
        BeanUtils.copyProperties(drawBenchInfo, drawBenchVo);
        drawBenchVo.setCalculateQGCDResponse(qgcdResponse);
        return AjaxResult.success(drawBenchVo);
    }


}
