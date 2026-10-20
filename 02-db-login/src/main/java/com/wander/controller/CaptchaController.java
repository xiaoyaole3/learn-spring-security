package com.wander.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.lang.Console;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class CaptchaController {

    @GetMapping("/captcha/get")
    public void getCaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //定义图形验证码的长和宽
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100);

        //图形验证码写出，可以写出到文件，也可以写出到流
//        lineCaptcha.write("d:/line.png");
        //输出code
        Console.log(lineCaptcha.getCode());
        //验证图形验证码的有效性，返回boolean值
//        lineCaptcha.verify("1234");

//        //重新生成验证码
//        lineCaptcha.createCode();
//        lineCaptcha.write("d:/line.png");
//        //新的验证码
//        Console.log(lineCaptcha.getCode());
//        //验证图形验证码的有效性，返回boolean值
//        lineCaptcha.verify("1234");

        HttpSession session = request.getSession();
        session.setAttribute("captcha", lineCaptcha.getCode());

        // 设置响应头，禁止缓存，防止验证码重复展示
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Expires", "0");
        // 设置响应类型为图片
        response.setContentType("image/png");

        // 将验证码写出
        lineCaptcha.write(response.getOutputStream());
    }
}
