package com.ht.screening.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ht.screening.entity.ScLsYcdj;
import com.ht.screening.mapper.ScLsYcdjMapper;
import com.ht.screening.service.ElevationDifferenceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 获取强度差反馈
 * @author chengsukai
 */
@Service
public class ElevationDifferenceServiceImpl extends ServiceImpl<ScLsYcdjMapper, ScLsYcdj> implements ElevationDifferenceService {

    @Resource
    private ScLsYcdjMapper elevationDifferenceMapper;

    @Override
    public List<ScLsYcdj> getElevationDifference(String sx) {
        return elevationDifferenceMapper.getElevationDifference(sx);
    }
}
