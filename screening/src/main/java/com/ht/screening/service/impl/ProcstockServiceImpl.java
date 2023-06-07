package com.ht.screening.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ht.base.utils.StringUtils;
import com.ht.screening.entity.Procstock;
import com.ht.screening.mapper.ProcstockMapper;
import com.ht.screening.service.ProcstockService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 * @author chengsukai
 */
@Service
public class ProcstockServiceImpl extends ServiceImpl<ProcstockMapper, Procstock> implements ProcstockService {

    @Resource
    private ProcstockMapper procstockMapper;


    @Override
    public Boolean checkFinished(String fiberDiskCode) {
        String res = procstockMapper.checkFinished(fiberDiskCode);
        if (StringUtils.isNotEmpty(res)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean checkExists(String fiberDiskCode) {
        String res = procstockMapper.checkExists(fiberDiskCode);
        if (StringUtils.isNotEmpty(res)) {
            return true;
        } else {
            return false;
        }
    }
}
