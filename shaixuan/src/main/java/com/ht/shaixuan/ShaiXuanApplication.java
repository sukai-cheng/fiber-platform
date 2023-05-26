package com.ht.shaixuan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author chengsukai
 */
@SpringBootApplication
@MapperScan("com.ht.shaixuan.mapper")
public class ShaiXuanApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShaiXuanApplication.class, args);
    }
}
