SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

CREATE TABLE ‘user’(
    id int(10) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '用户管理表id',
    username varchar(10) NOT NULL COMMENT '用户名',
    password varchar(20) NOT NULL COMMENT '用户密码'
);

CREATE TABLE 'pic_style'(
    id int(10) PRIMARY KEY NOT NULL AUTO_INCREMENT COMMENT '图片风格表id',
    style varchar(10) NOT NULL COMMENT '图片风格'
);

CREATE TABLE 'user_target'(
    id int(10) PRIMARY KEY NOT NULL AUTO_INCREMENT COMMENT '目标用户表id',
    type varchar(10) PRIMARY KEY NOT NULL COMMENT '目标用户的类型'
);

CREATE TABLE 'target_in_label'(
    target_id int(10) NOT NULL COMMENT '目标用户id',
    label_id int(10) NOT NULL COMMENT 'label的id'
);

CREATE TABLE 'event'(
    id int(10) PRIMARY KEY NOT NULL AUTO_INCREMENT COMMENT '场景id',
    name varchar(10) NOT NULL COMMENT '场景名称'
);

CREATE TABLE 'event_in_label'(
    event_id int(10) NOT NULL COMMENT '场景id',
    label_id int(10) NOT NULL COMMENT 'label的id'
);

CREATE TABLE 'pic'(
    id int(10) PRIMARY KEY NOT NULL AUTO_INCREMENT COMMENT '图片表id',
    label_id int(10) COMMENT '关联的label的id',
    width int(10) NOT NULL COMMENT '图片宽度',
    length int(10) NOT NULL COMMENT '图片长度',
    url varchar(100) NOT NULL COMMENT '图片url',
    style_id int(10) NOT NULL COMMENT '图片风格id',
    filename varchar(20) NOT NULL COMMENT '文件名字'
);

CREATE TABLE 'text'(
    id int(10) PRIMARY KEY NOT NULL AUTO_INCREMENT COMMENT '文字表id',
    label_id int(10) COMMENT '关联的label的id',
    content TEXT NOT NULL COMMENT '文字内容',
    filename varchar(20) NOT NULL COMMENT '文件名字'
);


CREATE TABLE 'label'(
    id int(10) PRIMARY KEY NOT NULL AUTO_INCREMENT COMMENT 'label表id'
);

CREATE TABLE 'other'(
    id int(10) PRIMARY KEY NOT NULL AUTO_INCREMENT COMMENT '其他要求表的id',
    label_id int(10) COMMENT '关联的label的id',
    content text NOT NULL COMMENT '要求的内容'
);