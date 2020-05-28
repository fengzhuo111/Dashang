package com.fengzhuo.dashang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;


@SpringBootApplication
@MapperScan(value = "com.fengzhuo.dashang.dao")
public class DashangApplication {

    public static void main(String[] args) {
        SpringApplication.run(DashangApplication.class, args);
    }

}
