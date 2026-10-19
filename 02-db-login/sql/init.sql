create database security_db_2026 character set utf8mb4;


-- 用户表
drop table if exists `user`;
create table `user` (
                        `id` bigint(20) not null auto_increment comment '用户编号',
                        `username` varchar(255) character set utf8mb4 collate utf8mb4_general_ci not null comment '用户名',
                        `password` varchar(255) character set utf8mb4 collate utf8mb4_general_ci not null comment '用户密码',
                        primary key (`id`) using BTREE,
                        unique index `username_idx`(username) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT=1 CHARACTER SET = utf8mb4 collate utf8mb4_general_ci ROW_FORMAT = dynamic ;

-- BCrypt 加密 123456
INSERT INTO `user` values (1, 'zs', '$2a$10$nKfBA3tfgVPnH3o0V/DnqeUgGGoeIIXi9v0kAZE9Gvpt/mH.0JlmK');
INSERT INTO `user` values (2, 'ls', '$2a$10$nKfBA3tfgVPnH3o0V/DnqeUgGGoeIIXi9v0kAZE9Gvpt/mH.0JlmK');

-- 角色表
drop table if exists `role`;
create table `role` (
                        `id` bigint(20) not null auto_increment comment '角色编号',
                        `name` varchar(255) character set utf8mb4 collate utf8mb4_general_ci not null comment '角色名称',
                        primary key (`id`) using BTREE
) ENGINE = InnoDB AUTO_INCREMENT=1 CHARACTER SET = utf8mb4 collate utf8mb4_general_ci ROW_FORMAT = dynamic ;

INSERT INTO `role` values (1, '管理员');
INSERT INTO `role` values (2, '普通用户');


-- 菜单表
drop table if exists `menu`;
create table `menu` (
                        `id` bigint(20) not null auto_increment comment '角色编号',
                        `name` varchar(255) character set utf8mb4 collate utf8mb4_general_ci not null comment '菜单名称',
                        `url` varchar(255) character set utf8mb4 collate utf8mb4_general_ci not null comment '菜单地址',
                        `permission` varchar(255) character set utf8mb4 collate utf8mb4_general_ci default null comment '菜单访问权限',
                        primary key (`id`) using BTREE
) ENGINE = InnoDB AUTO_INCREMENT=1 CHARACTER SET = utf8mb4 collate utf8mb4_general_ci ROW_FORMAT = dynamic ;

INSERT INTO `menu` values (1, '查询学生', 'stu/select', 'stu:select');
INSERT INTO `menu` values (2, '添加学生', 'stu/insert', 'stu:insert');
INSERT INTO `menu` values (3, '修改学生', 'stu/update', 'stu:update');
INSERT INTO `menu` values (4, '删除学生', 'stu/delete', NULL);


-- 菜单角色之间关系
drop table if exists `role_menu`;
create table `role_menu` (
                             `rid` bigint(20) not null comment '角色编号',
                             `mid` bigint(20) not null comment '菜单编号',
                             primary key (`rid`, `mid`) using BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 collate utf8mb4_general_ci ROW_FORMAT = dynamic ;

INSERT INTO `role_menu` values (1, 1);
INSERT INTO `role_menu` values (1, 2);
INSERT INTO `role_menu` values (1, 3);
INSERT INTO `role_menu` values (1, 4);
INSERT INTO `role_menu` values (1, 5);