package com.wander.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

/**
 * 老版本需要继承 WebSecurityConfigurerAdapter
 */
@Configuration
public class MySecurityConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    // 不使用密码加密器
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login").permitAll()
                        .requestMatchers("/captcha/get").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        // 设置默认的登录页面
                        // 也就是退出后默认的页面
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/", true)
//                        .passwordParameter("password") // 前端设置自定义的参数名称
                        .permitAll()
                )
                .rememberMe(remember -> {
                    remember.rememberMeParameter("remember-me")
                            .tokenValiditySeconds(60*7)
//                            .key("") //
                            .tokenRepository(persistenceTokenRepository());
                })
                .logout(logout -> logout
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()
                );
        return http.build();
    }

    @Bean
    public PersistentTokenRepository persistenceTokenRepository() {
        JdbcTokenRepositoryImpl repo = new JdbcTokenRepositoryImpl();
        repo.setDataSource(dataSource);

        // 首次可以使用
//        repo.setCreateTableOnStartup(true);
        return repo;
    }

}
