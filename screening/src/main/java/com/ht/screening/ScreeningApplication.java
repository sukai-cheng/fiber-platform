package com.ht.screening;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author chengsukai
 */
@SpringBootApplication
@MapperScan("com.ht.screening.mapper")
public class ScreeningApplication {
    public static void main(String[] args) {
        SpringApplication.run(ScreeningApplication.class, args);
    }
}
