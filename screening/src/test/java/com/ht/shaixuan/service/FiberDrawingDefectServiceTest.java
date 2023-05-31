package com.ht.shaixuan.service;


import com.ht.base.domain.AjaxResult;
import com.ht.shaixuan.service.impl.FiberDrawingDefectServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@Slf4j
@SpringBootTest
public class FiberDrawingDefectServiceTest {
    @Resource
    private FiberDrawingDefectServiceImpl fiberDrawingDefectService;

    @Test
    public void fiberCutDetailTest() {
        AjaxResult res = fiberDrawingDefectService.fiberCutDetail("14H12LD112XXA");
        System.out.println(res.get("data"));
    }
}
