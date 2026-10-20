package com.wander.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

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

    @GetMapping("/current/user/default")
    @ResponseBody
    public void getCurrentUser() {
        // 方式一
        Authentication authenticationLocal = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authenticationLocal);
    }

    // 方式二，直接注入Authentication
    @GetMapping("/current/user/authentication")
    @ResponseBody
    public void getCurrentUserAuthentication(Authentication authentication) {
        System.out.println("---- authentication ----");
        System.out.println(authentication);
    }

    @GetMapping("/current/user/principal")
    @ResponseBody
    public void getCurrentUserPrincipal(Principal principal) {
        System.out.println("---- principal ----");
        System.out.println(principal);
    }

    @GetMapping("/current/user/rememberMe")
    @ResponseBody
    public void getCurrentUserRememberMe(RememberMeAuthenticationToken rememberMeAuthenticationToken) {
        System.out.println("---- rememberMeAuthenticationToken ----");
        System.out.println(rememberMeAuthenticationToken);
    }
}
