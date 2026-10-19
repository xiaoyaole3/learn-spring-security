package com.wander;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.wander")
@SpringBootApplication
public class App02DatabaseLogin {
    public static void main(String[] args) {
        SpringApplication.run(App02DatabaseLogin.class, args);
    }
}