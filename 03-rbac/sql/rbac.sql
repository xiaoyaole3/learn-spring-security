-- create database security_db_2026 character set utf8mb4;

-- 用户表
drop table if exists `sys_user`;
create table `sys_user` (
        `id` bigint(20) not null auto_increment comment '用户编号',
        `username` varchar(255) character set utf8mb4 collate utf8mb4_general_ci not null comment '用户名',
        `password` varchar(255) character set utf8mb4 collate utf8mb4_general_ci not null comment '用户密码',
        `nickname` varchar(255) character set utf8mb4 collate utf8mb4_general_ci not null comment '用户密码',
        `locked` tinyint default 0 comment '锁定状态：0 正常 1 锁定',
        `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
        primary key (`id`) using BTREE,
        unique key `idx_username`(username) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT=1 CHARACTER SET = utf8mb4 collate utf8mb4_general_ci ROW_FORMAT = dynamic ;

-- BCrypt 加密 123456
INSERT INTO `sys_user` values (1, 'zs', '$2a$10$nKfBA3tfgVPnH3o0V/DnqeUgGGoeIIXi9v0kAZE9Gvpt/mH.0JlmK', 'zs', 0, now());
INSERT INTO `sys_user` values (2, 'ls', '$2a$10$nKfBA3tfgVPnH3o0V/DnqeUgGGoeIIXi9v0kAZE9Gvpt/mH.0JlmK', 'ls', 0, now());

-- 角色表
drop table if exists `sys_role`;
create table `sys_role` (
    `id` bigint(20) not null auto_increment comment '角色编号',
    `role_name` varchar(255) character set utf8mb4 collate utf8mb4_general_ci not null comment '角色名称',
    `role_code` varchar(255) character set utf8mb4 collate utf8mb4_general_ci not null comment '角色编码',
    `description` varchar(255) character set utf8mb4 collate utf8mb4_general_ci not null comment '角色描述',
    primary key (`id`) using BTREE,
    unique key `idx_role_code`(role_code) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT=1 CHARACTER SET = utf8mb4 collate utf8mb4_general_ci ROW_FORMAT = dynamic ;

INSERT INTO `sys_role` values (1, '管理员', 'admin', '管理员用户');
INSERT INTO `sys_role` values (2, '普通用户', 'user', '普通用户');


-- 用户和角色之间的关系
drop table if exists sys_user_role;
create table `sys_user_role` (
    `id` bigint(20) not null auto_increment comment '唯一id',
    `user_id` bigint(20) not null comment '用户id',
    `role_id` bigint(20) not null comment '角色id',
    primary key (`id`) using BTREE,
    unique key `idx_user_role`(user_id, role_id) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 collate utf8mb4_general_ci ROW_FORMAT = dynamic ;

insert into `sys_user_role` values (1, 1, 1);
insert into `sys_user_role` values (2, 2, 2);

-- 权限表（资源权限，如接口、菜单）
drop table if exists `sys_permission`;
create table `sys_permission` (
  `id` bigint(20) not null auto_increment comment '权限ID',
  `perm_name` varchar(255) character set utf8mb4 collate utf8mb4_general_ci not null comment '权限名称（如查询用户、删除订单）',
  `perm_code` varchar(255) character set utf8mb4 collate utf8mb4_general_ci not null comment '权限编码（如user:query, order:delete）',
  `resource_type` varchar(20) character set utf8mb4 collate utf8mb4_general_ci not null comment '资源类型（API：接口，MENU:菜单）',
  `resource_path` varchar(255) character set utf8mb4 collate utf8mb4_general_ci default null comment '资源路径（例如：/admin/**, /user/info）',
  primary key (`id`) using BTREE,
  unique key `idx_perm_code`(perm_code)
) ENGINE = InnoDB AUTO_INCREMENT=1 CHARACTER SET = utf8mb4 collate utf8mb4_general_ci ROW_FORMAT = dynamic ;

INSERT INTO `sys_permission` values (1, '查询学生', 'stu:query','API', 'student/get');
INSERT INTO `sys_permission` values (2, '新增学生', 'stu:add','API', 'student/add');
INSERT INTO `sys_permission` values (3, '删除学生', 'stu:del','API', 'student/del');
INSERT INTO `sys_permission` values (4, '修改学生', 'stu:update','API', 'student/update');


-- 角色权限-关系表
drop table if exists sys_role_permission;
create table `sys_role_permission` (
     `id` bigint(20) not null auto_increment comment '唯一id',
     `role_id` bigint(20) not null comment '角色id',
     `perm_id` bigint(20) not null comment '资源id',
     primary key (`id`) using BTREE,
     unique key `idx_role_perm`(role_id, perm_id) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 collate utf8mb4_general_ci ROW_FORMAT = dynamic ;

INSERT INTO sys_role_permission values (1,1, 1);
INSERT INTO sys_role_permission values (2,1, 2);
INSERT INTO sys_role_permission values (3,1, 3);
INSERT INTO sys_role_permission values (4,1, 4);
INSERT INTO sys_role_permission values (5,2, 1);