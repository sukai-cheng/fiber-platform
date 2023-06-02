package com.ht.screening.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ht.base.domain.AjaxResult;
import com.ht.screening.dto.DrawBenchDto;
import com.ht.screening.entity.ScLs1;
import com.ht.screening.mapper.ScLs1Mapper;
import com.ht.screening.service.ScLs1Service;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author chengsukai
 */
@Service
public class ScLs1ServiceImpl extends ServiceImpl<ScLs1Mapper, ScLs1> implements ScLs1Service {

    @Resource
    private ScLs1Mapper scLs1Mapper;

    /**
     * 获取拉丝信息
     * @param fiberDiskNum 光纤盘号
     */
    @Override
    public AjaxResult getDrawBenchInfo(String fiberDiskNum) {
        DrawBenchDto drawBenchInfo = scLs1Mapper.getDrawBenchInfo(fiberDiskNum);
        return AjaxResult.success(drawBenchInfo);
    }


}
