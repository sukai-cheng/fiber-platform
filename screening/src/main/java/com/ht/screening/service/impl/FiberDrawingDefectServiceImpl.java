package com.ht.screening.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ht.base.domain.AjaxResult;
import com.ht.screening.dto.FiberDrawingDefectInfo;
import com.ht.screening.entity.WireDrawingDefectRemovalEntity;
import com.ht.screening.mapper.FiberCutMapper;
import com.ht.screening.service.FiberDrawingDefectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author chengsukai
 */
@Service
@Slf4j
public class FiberDrawingDefectServiceImpl extends ServiceImpl<FiberCutMapper, WireDrawingDefectRemovalEntity> implements FiberDrawingDefectService {

    @Resource
    private FiberCutMapper fiberCutMapper;

    @Override
    public AjaxResult fiberCutDetail(String fiberDiskNum) {
        List<FiberDrawingDefectInfo> fiberDrawingDefectInfoList = fiberCutMapper.fiberCutDetail(fiberDiskNum);
        return AjaxResult.success(fiberDrawingDefectInfoList);
    }
}
