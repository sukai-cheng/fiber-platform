package com.ht.shaixuan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ht.base.domain.AjaxResult;
import com.ht.shaixuan.dto.FiberDrawingDefectInfo;
import com.ht.shaixuan.entity.ScLsQxqc;
import com.ht.shaixuan.mapper.ScLs1Mapper;
import com.ht.shaixuan.mapper.FiberCutMapper;
import com.ht.shaixuan.service.FiberDrawingDefectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author chengsukai
 */
@Service
@Slf4j
public class FiberDrawingDefectServiceImpl extends ServiceImpl<FiberCutMapper, ScLsQxqc> implements FiberDrawingDefectService {

    @Resource
    private FiberCutMapper fiberCutMapper;

    @Override
    public AjaxResult fiberCutDetail(String fiberDiskNum) {
        List<FiberDrawingDefectInfo> fiberDrawingDefectInfoList = fiberCutMapper.fiberCutDetail(fiberDiskNum);
        return AjaxResult.success(fiberDrawingDefectInfoList);
    }
}
