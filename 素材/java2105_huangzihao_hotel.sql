/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2021/9/10 20:29:28                           */
/*==============================================================*/


drop table if exists t_cuisine;

drop table if exists t_dishes;

drop table if exists t_menu;

drop table if exists t_order;

drop table if exists t_order_details;

drop table if exists t_table;

drop table if exists t_user;

/*==============================================================*/
/* Table: t_cuisine                                             */
/*==============================================================*/
create table t_cuisine
(
   t_cuisine_id         int not null auto_increment comment '菜系ID',
   t_cuisine_name       varchar(40) comment '菜系名称',
   t_cuisine_create_time datetime comment '创建时间',
   t_cuisine_modifie_time datetime comment '修改时间',
   t_cuisine_modifie_user int comment '修改人',
   primary key (t_cuisine_id)
);

alter table t_cuisine comment '菜系实体表';

/*==============================================================*/
/* Table: t_dishes                                              */
/*==============================================================*/
create table t_dishes
(
   t_dishes_id          int not null auto_increment comment '菜品ID',
   t_cuisine_id         int comment '菜系ID',
   t_dishes_name        varchar(100) comment '菜品名称',
   t_dishes_price       decimal(10,2) comment '菜品价格',
   t_dishes_member_price decimal(10,2) comment '会员价格',
   t_dishes_img         varchar(1000) comment '菜品图片',
   t_dishes_introduction longtext comment '菜品简介',
   primary key (t_dishes_id)
);

alter table t_dishes comment '菜品实体表';

/*==============================================================*/
/* Table: t_menu                                                */
/*==============================================================*/
create table t_menu
(
   t_menu_id            int not null auto_increment comment '菜单ID',
   t_menu_name          varchar(100) comment '菜单名称',
   t_menu_url           varchar(100) comment '菜单URL',
   primary key (t_menu_id)
);

alter table t_menu comment '菜单实体表';

/*==============================================================*/
/* Table: t_order                                               */
/*==============================================================*/
create table t_order
(
   t_order_id           int not null auto_increment comment '订单ID',
   t_table_id           int comment '餐桌ID',
   t_user_id            int comment '用户ID',
   t_dishs_number       int comment '菜总数量',
   t_total_amount       decimal(32,4) comment '订单总金额',
   t_order_time         datetime comment '下单时间',
   t_order_status       tinyint comment '订单状态 1:未支付 2:已支付',
   primary key (t_order_id)
);

alter table t_order comment '订单表';

/*==============================================================*/
/* Table: t_order_details                                       */
/*==============================================================*/
create table t_order_details
(
   t_details_id         int not null auto_increment comment '详情ID',
   t_dishes_id          int comment '菜品ID',
   t_order_id           int comment '订单ID',
   t_quantity_note      int comment '菜数量小记',
   t_note               decimal(20,3) comment '小记',
   primary key (t_details_id)
);

alter table t_order_details comment '订单详情表';

/*==============================================================*/
/* Table: t_table                                               */
/*==============================================================*/
create table t_table
(
   t_table_id           int not null auto_increment comment '餐桌ID',
   t_table_name         varchar(20) comment '餐桌名称',
   t_table_status       tinyint comment '餐桌状态 1未预定 2:已预订 3:空闲 4:使用中',
   t_scheduled_time     datetime comment '预定时间',
   primary key (t_table_id)
);

alter table t_table comment '餐桌实体';

/*==============================================================*/
/* Table: t_user                                                */
/*==============================================================*/
create table t_user
(
   t_user_id            int not null auto_increment comment '用户ID',
   t_username           varchar(100) comment '用户名',
   t_password           varchar(100) comment '密码',
   t_nickname           varchar(100) comment '昵称',
   t_admin              tinyint comment '是否管理员 1:是管理员  2:不是管理员',
   t_phone              varchar(100) comment '手机号',
   t_gender             tinyint comment '性别  1:男  2:女',
   t_status             tinyint comment '用户状态  1:激活 2:未激活 3:锁定 4:异常',
   t_user_create_time   datetime comment '创建时间',
   t_user_modifie_time  datetime comment '修改时间',
   t_deleted            tinyint comment '是否删除  1:未删除 2:已删除',
   t_member             tinyint comment '是否会员 1:非会员 2:会员',
   t_balance            decimal(32,4) comment '账户余额',
   primary key (t_user_id)
);

alter table t_user comment '用户表';

