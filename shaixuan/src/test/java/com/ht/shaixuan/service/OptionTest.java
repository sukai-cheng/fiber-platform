package com.ht.shaixuan.service;


import com.ht.base.domain.AjaxResult;
import com.ht.shaixuan.service.impl.TOptionServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@Slf4j
@SpringBootTest
public class OptionTest {

    @Resource
    private TOptionServiceImpl optionService;

    @Test
    public void getOptionList(){
        AjaxResult res = optionService.getOptionList("color");
        log.warn(res.get("data").toString());
    }
}
