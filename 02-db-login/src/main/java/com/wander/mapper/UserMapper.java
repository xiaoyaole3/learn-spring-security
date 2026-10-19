package com.wander.mapper;

import com.wander.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author wander
* @description 针对表【user】的数据库操作Mapper
* @createDate 2026-10-19 22:27:21
* @Entity com.wander.entity.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




