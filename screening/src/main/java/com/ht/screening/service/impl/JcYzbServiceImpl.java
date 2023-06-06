package com.ht.screening.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ht.screening.entity.JcYzb;
import com.ht.screening.mapper.JcYzbMapper;
import com.ht.screening.service.JcYzbService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 获取类别名称
 *
 * @author chengsukai
 */
@Service
@Slf4j
public class JcYzbServiceImpl extends ServiceImpl<JcYzbMapper, JcYzb> implements JcYzbService {
    @Resource
    private JcYzbMapper jcYzbMapper;

    public String getCategoryName(String zzpbh) {
        return jcYzbMapper.getCategoryName(zzpbh);
    }
}
