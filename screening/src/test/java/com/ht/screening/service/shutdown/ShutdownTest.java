package com.ht.screening.service.shutdown;

import com.ht.screening.dto.AbnormalShutdownDto;
import com.ht.screening.dto.NormalShutdownDto;
import com.ht.screening.service.impl.ShutDownServiceImpl;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;

@Slf4j
@SpringBootTest
public class ShutdownTest {
    @Resource
    private ShutDownServiceImpl shutDownService;


    @Test
    public void normalShutdownTest() {
        log.info("正常停机处理函数开始");
//        NormalShutdownDto normalShutdownDto = new NormalShutdownDto();
//        normalShutdownDto.setPh("28H12LD109XXG");
//        normalShutdownDto.setSxbh("SX130101212");
//        normalShutdownDto.setSxcd(54.51d);
//        normalShutdownDto.setInitialTime(new Date());
//        normalShutdownDto.setDqcd(13.3);
//        normalShutdownDto.setAccoutId("2015090124");
//        normalShutdownDto.setBz("A");
//        normalShutdownDto.setUsername("承苏凯");
//        normalShutdownDto.setGlqk("调试偏移量隔离");
//        normalShutdownDto.setColor("蓝色");
//        normalShutdownDto.setStartDate(new Date());
//        normalShutdownDto.setYl("1.26");
//        normalShutdownDto.setPj("富鑫100公里");
//        normalShutdownDto.setXj("新盘");
//        shutDownService.normalShutdown(normalShutdownDto);
        log.info("正常停机处理函数结束");
    }

    @Test
    @Ignore
    public void abnormalShutdownTest() {
//        log.info("异常停机处理函数开始");
//        AbnormalShutdownDto abnormalShutdownDto = new AbnormalShutdownDto();
//        abnormalShutdownDto.setPh("28H12LD109XXG");
//        abnormalShutdownDto.setSxbh("SX130101212");
//        abnormalShutdownDto.setSxcd(54.51d);
//        abnormalShutdownDto.setInitialTime(new Date());
//        abnormalShutdownDto.setDqcd(13.3);
//        abnormalShutdownDto.setAccoutId("2015090124");
//        abnormalShutdownDto.setBz("A");
//        abnormalShutdownDto.setUsername("承苏凯");
//        abnormalShutdownDto.setGlqk("调试偏移量隔离");
//        abnormalShutdownDto.setColor("蓝色");
//        abnormalShutdownDto.setStartDate(new Date());
//        abnormalShutdownDto.setYl("1.26");
//        abnormalShutdownDto.setPj("富鑫100公里");
//        abnormalShutdownDto.setXj("新盘");
//        abnormalShutdownDto
//        shutDownService.abnormalShutdown();
//        log.info("异常停机处理函数结束");
    }
}


