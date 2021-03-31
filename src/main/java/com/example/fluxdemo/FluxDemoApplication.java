package com.example.fluxdemo;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class, DruidDataSourceAutoConfigure.class})
@MapperScan("com.example.fluxdemo.mapper")
public class FluxDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(FluxDemoApplication.class, args);
    }

}
