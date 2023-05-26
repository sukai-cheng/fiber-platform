package com.ht.shaixuan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ht.shaixuan.entity.TAccount;
import com.ht.shaixuan.mapper.TAccountMapper;
import com.ht.shaixuan.service.TAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author chengsukai
 */
@Service
@Slf4j
public class TAccountServiceImpl extends ServiceImpl<TAccountMapper, TAccount> implements TAccountService {
}
