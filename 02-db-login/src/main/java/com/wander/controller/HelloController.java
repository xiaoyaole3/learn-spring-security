package com.wander.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 注意这里不能为RestController，否则不会走视图解析器，就无法跳转到对应的html
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello security.";
    }

    @GetMapping("/")
    public String home() {
        return "home";   // 随便建个 home.html 显示"登录成功"即可
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
