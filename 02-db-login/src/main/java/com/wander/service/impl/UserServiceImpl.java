package com.wander.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wander.entity.User;
import com.wander.service.UserService;
import com.wander.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author wander
* @description 针对表【user】的数据库操作Service实现
* @createDate 2026-10-19 22:27:21
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




