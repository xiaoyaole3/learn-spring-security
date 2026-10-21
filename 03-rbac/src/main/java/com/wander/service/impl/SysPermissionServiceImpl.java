package com.wander.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wander.entity.SysPermission;
import com.wander.service.SysPermissionService;
import com.wander.mapper.SysPermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author wander
* @description 针对表【sys_permission】的数据库操作Service实现
* @createDate 2026-10-21 22:36:24
*/
@Service
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission>
    implements SysPermissionService{

    @Autowired
    private SysPermissionMapper sysPermissionMapper;


    @Override
    public List<String> listPermissionByUserId(Long userId) {
        return sysPermissionMapper.listPermissionByUserId(userId);
    }
}




