package com.ht.screening.service;


import com.ht.base.domain.AjaxResult;
import com.ht.screening.service.impl.ScSxServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
@Slf4j
public class FiberFilterTest {

    @Resource
    private ScSxServiceImpl filterService;

    @Test
    public void FiberFilterInfoTest(){
//        AjaxResult res = filterService.getMainPlateInfo("10C11LC734ZXI");
//        log.warn(res.get("data").toString());

    }
}
