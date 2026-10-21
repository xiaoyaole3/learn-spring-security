package com.wander;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.wander.mapper")
@SpringBootApplication
public class App03RBAC {
    public static void main(String[] args) {
        SpringApplication.run(App03RBAC.class, args);
    }
}