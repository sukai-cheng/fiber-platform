package com.ht.shaixuan.service;

import com.ht.shaixuan.entity.TAccount;
import com.ht.shaixuan.service.impl.TAccountServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@Slf4j
@SpringBootTest
public class AccountTest {
    @Resource
    private TAccountServiceImpl accountService;

    @Test
    public void findAccount(){
        TAccount res = accountService.getById(25);
        System.out.println(res);
    }
}
