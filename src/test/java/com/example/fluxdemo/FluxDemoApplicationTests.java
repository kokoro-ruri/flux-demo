package com.example.fluxdemo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.SpringVersion;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FluxDemoApplication.class)
class FluxDemoApplicationTests {

    @Test
    public void contextLoads() {
        String springVersion = SpringVersion.getVersion();
        String springBootVersion = SpringBootVersion.getVersion();
        System.out.println("SpringVersion: " + springVersion);
        System.out.println("SpringBootVersion: " + springBootVersion);
    }

}
