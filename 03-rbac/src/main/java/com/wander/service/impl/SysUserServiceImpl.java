package com.wander.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wander.entity.SysUser;
import com.wander.service.SysUserService;
import com.wander.mapper.SysUserMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
* @author wander
* @description 针对表【sys_user】的数据库操作Service实现
* @createDate 2026-10-21 22:36:24
*/
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
    implements SysUserService, UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}




