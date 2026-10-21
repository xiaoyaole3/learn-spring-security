package com.wander.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wander.entity.SysUser;
import com.wander.service.SysUserService;
import com.wander.mapper.SysUserMapper;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
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
        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(SysUser::getUsername, username);

        SysUser getUser = getOne(wrapper);
        if (getUser == null) {
            throw new UsernameNotFoundException("用户并不存在");
        }

        // 该权限列表传入一个Role对象
//        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority();

        return User.builder()
                .username(getUser.getUsername())
                .password(getUser.getPassword())
                .accountLocked(getUser.getLocked() == 1)
                .build();

    }
}




