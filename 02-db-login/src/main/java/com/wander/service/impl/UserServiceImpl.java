package com.wander.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wander.entity.User;
import com.wander.service.UserService;
import com.wander.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
* @author wander
* @description 针对表【user】的数据库操作Service实现
* @createDate 2026-10-19 22:27:21
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService, UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 1. 根据用户名查询信息
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, username);

        User getUser = getOne(wrapper);
        if (getUser == null) {
            throw new UsernameNotFoundException("用户并不存在");
        }

        // 返回原本的SpringSecurity提供的User对象
//        return org.springframework.security.core.userdetails.User.builder()
//                .username(username)
//                .password(getUser.getPassword())
//                .authorities(new ArrayList<>())
//                .build();
        // 在我们的自定义User实现了UserDetails接口之后，可以直接返回我们的User对喜爱给你
        return getUser;
    }
}




