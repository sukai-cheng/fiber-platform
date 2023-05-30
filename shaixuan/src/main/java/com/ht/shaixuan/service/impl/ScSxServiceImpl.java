package com.ht.shaixuan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ht.base.domain.AjaxResult;
import com.ht.shaixuan.entity.ScSx;
import com.ht.shaixuan.mapper.ScSxMapper;
import com.ht.shaixuan.service.ScSxService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 获取筛选信息
 * @author chengsukai
 */
@Service
public class ScSxServiceImpl extends ServiceImpl<ScSxMapper, ScSx> implements ScSxService {

    @Resource
    private ScSxMapper scSxMapper;

    @Override
    public AjaxResult findByMainDiskCode(String mainDiskCode) {
        ScSx scsx = scSxMapper.findByMainDiskCode(mainDiskCode);
        return AjaxResult.success(scsx);
    }
}
