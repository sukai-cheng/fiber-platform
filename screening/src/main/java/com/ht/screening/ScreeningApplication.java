package com.ht.screening;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
