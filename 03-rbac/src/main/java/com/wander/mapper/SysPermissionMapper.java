package com.wander.mapper;

import com.wander.entity.SysPermission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author wander
* @description 针对表【sys_permission】的数据库操作Mapper
* @createDate 2026-10-21 22:36:24
* @Entity com.wander.entity.SysPermission
*/
@Mapper
public interface SysPermissionMapper extends BaseMapper<SysPermission> {

    List<String> listPermissionByUserId(@Param("userId") Long userId);
}




