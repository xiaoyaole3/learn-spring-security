package com.wander.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class CaptchaValidatorFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // 只拦截 POST /login，GET 是显示登录页，不校验
        boolean isLoginPost = "POST".equalsIgnoreCase(request.getMethod())
                && "/login".equals(request.getServletPath());

        if (!isLoginPost) {
            filterChain.doFilter(request, response);   // 放行
            return;
        }

        String captchaCode = request.getParameter("captchaCode");
        String captcha = (String) request.getSession().getAttribute("captcha");

        // 验证码一次性使用，无论成功失败都清掉，防止重放
        request.getSession().removeAttribute("captcha");

        // 1. 参数为空
        if (captchaCode == null || captchaCode.isBlank()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "验证码不能为空");
            return;
        }

        // 2. session 里没有验证码（过期或没生成）
        if (captcha == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "验证码已过期，请刷新");
            return;
        }

        // 3. 比对不一致（验证码通常不区分大小写，按你的生成逻辑调整）
        if (!captchaCode.equalsIgnoreCase(captcha)) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "验证码不正确");
            return;
        }

        // 校验通过，放行一次
        filterChain.doFilter(request, response);

    }
}
