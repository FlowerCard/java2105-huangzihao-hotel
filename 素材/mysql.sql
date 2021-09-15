/*
SQLyog Ultimate v12.4.3 (64 bit)
MySQL - 5.7.25-log : Database - java2105-huangzihao-hotel
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`java2105-huangzihao-hotel` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `java2105-huangzihao-hotel`;

/*Table structure for table `order_id_order_details_id` */

DROP TABLE IF EXISTS `order_id_order_details_id`;

CREATE TABLE `order_id_order_details_id` (
  `t_order_id` int(11) NOT NULL COMMENT '订单ID',
  `t_details_id` int(11) NOT NULL COMMENT '详情ID',
  PRIMARY KEY (`t_order_id`,`t_details_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单对多订单详情';

/*Data for the table `order_id_order_details_id` */

/*Table structure for table `t_cuisine` */

DROP TABLE IF EXISTS `t_cuisine`;

CREATE TABLE `t_cuisine` (
  `t_cuisine_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜系ID',
  `t_cuisine_name` varchar(40) NOT NULL COMMENT '菜系名称',
  `t_cuisine_create_time` date DEFAULT NULL COMMENT '菜系创建时间',
  `t_cuisine_modifie_time` date DEFAULT NULL COMMENT '菜系修改时间',
  `t_cuisine_modifie_user` int(11) DEFAULT NULL COMMENT '修改人',
  `t_cuisine_status` int(11) DEFAULT '1' COMMENT '菜系状态 1:正常 2:禁用',
  PRIMARY KEY (`t_cuisine_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='菜系实体表';

/*Data for the table `t_cuisine` */

insert  into `t_cuisine`(`t_cuisine_id`,`t_cuisine_name`,`t_cuisine_create_time`,`t_cuisine_modifie_time`,`t_cuisine_modifie_user`,`t_cuisine_status`) values 
(1,'鲁菜','2021-09-12','2021-09-12',1,1),
(2,'川菜','2021-09-12','2021-09-12',1,1),
(3,'粤菜','2021-09-12','2021-09-12',1,1),
(4,'江苏菜','2021-09-12','2021-09-12',1,1),
(5,'闽菜','2021-09-12','2021-09-12',1,1),
(6,'浙江菜','2021-09-12','2021-09-12',1,1),
(7,'湘菜','2021-09-12','2021-09-12',1,1),
(8,'徽菜','2021-09-12','2021-09-14',1,1),
(9,'海菜','2021-09-12','2021-09-12',1,2),
(10,'河菜','2021-09-13','2021-09-13',1,1),
(11,'火菜','2021-09-13','2021-09-13',1,2);

/*Table structure for table `t_dishes` */

DROP TABLE IF EXISTS `t_dishes`;

CREATE TABLE `t_dishes` (
  `t_dishes_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜品ID',
  `t_cuisine_id` int(11) NOT NULL COMMENT '菜系ID',
  `t_dishes_name` varchar(100) NOT NULL COMMENT '菜品名称',
  `t_dishes_price` decimal(10,2) NOT NULL COMMENT '菜品价格',
  `t_dishes_member_price` decimal(10,2) DEFAULT NULL COMMENT '会员价格',
  `t_dishes_img` varchar(1000) NOT NULL COMMENT '菜品图片',
  `t_dishes_introduction` longtext COMMENT '菜品简介',
  `t_dishes_status` int(11) DEFAULT '1' COMMENT '菜品状态 1:正常 2:售罄 3:删除',
  PRIMARY KEY (`t_dishes_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='菜品实体表';

/*Data for the table `t_dishes` */

insert  into `t_dishes`(`t_dishes_id`,`t_cuisine_id`,`t_dishes_name`,`t_dishes_price`,`t_dishes_member_price`,`t_dishes_img`,`t_dishes_introduction`,`t_dishes_status`) values 
(1,3,'白切鸡',1010.00,10.00,'/image/dishes/d00d538c1dc04a5293afdbdbb30fb75f.jpg','好吃,真好吃',1),
(2,3,'白灼虾',100.00,80.00,'/image/dishes/507053c8681b46c7b772637d36eb2243.jpg','白灼虾！',1),
(3,3,'佛跳墙',1010.00,810.00,'/image/dishes/091f504e99e94f9a8bdf867bcf7c2274.jpg','佛跳墙佛跳墙佛跳墙佛跳墙',1),
(4,1,'白切',1010.00,810.00,'/image/dishes/307d5f3bd15b4a1497d7afc86bfc6857.jpg','1111111',3),
(5,3,'黄埔炒蛋',100.00,90.00,'/image/dishes/6927b604c94247b4a3a18f583b3fe453.jpg','黄埔炒蛋黄埔炒蛋黄埔炒蛋',1),
(6,2,'辣子鸡',50.00,40.00,'/image/dishes/2ed2314ba1004d069214a25e04d72e2a.jpg','辣子鸡辣子鸡',1),
(7,3,'烤乳猪',40.00,30.00,'/image/dishes/4016b52011d64e09b697ef1eae3339c9.jpg','烤乳猪烤乳猪',1),
(8,3,'清炒荷兰豆',30.00,25.00,'/image/dishes/d8ff1679fb924e9894efbab3253fadeb.jpg','清炒荷兰豆',1),
(9,2,'青椒鸡丁',25.00,20.00,'/image/dishes/4b2c8552f30a4434a0dfcbd615c2d388.jpg','青椒鸡丁',1),
(10,3,'烧鹅',50.00,45.00,'/image/dishes/288a0143a6854238aa945b9707ae292a.jpg','烧鹅',3),
(11,2,'水煮活鱼',89.00,78.00,'/image/dishes/99ea9a2658e14d5189bc7b9f7e8ffee8.jpg','水煮活鱼',1),
(12,1,'葱烧海参',100.00,80.00,'/image/dishes/26f91b8666ef43198a15b4e5a798c5d7.jpg','葱烧海参真不错哇！！',1),
(13,1,'三丝鱼翅',80.00,70.00,'/image/dishes/6bb55d378094498ea50bb8891f3243b4.jpg','三丝鱼翅，有营养哇！',1),
(14,1,'白扒四宝',70.00,60.00,'/image/dishes/cefbcb2c8e7643118af92dc4562dc628.jpg','白扒四宝，真不错哇',1),
(15,1,'乌云托月',500.00,400.00,'/image/dishes/24f9ec781e294019b112e855e91cc52f.jpg','乌云托月，有诗意哇！',1),
(16,7,'潇湘猪手',50.00,40.00,'/image/dishes/7998cc7bc23d4cc9b5e34cbec9cfe4d0.jpg','潇湘猪手，逍遥自在！',1),
(17,7,'牛肉米粉',20.00,25.00,'/image/dishes/9758482980c24c7096ee647ccb74b36a.jpg','牛肉米粉，真米粉哇！！',1),
(18,1,'香锅肉丸',100.00,80.00,'/image/dishes/511ea651e5c0410287dcff32046c04ae.jpg','香锅肉丸',1);

/*Table structure for table `t_menu` */

DROP TABLE IF EXISTS `t_menu`;

CREATE TABLE `t_menu` (
  `t_menu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `t_menu_name` varchar(100) NOT NULL COMMENT '菜单名称',
  `t_menu_url` varchar(100) DEFAULT NULL COMMENT '菜单URL',
  PRIMARY KEY (`t_menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单实体表';

/*Data for the table `t_menu` */

/*Table structure for table `t_order` */

DROP TABLE IF EXISTS `t_order`;

CREATE TABLE `t_order` (
  `t_order_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `t_table_id` int(11) NOT NULL COMMENT '餐桌ID',
  `t_user_id` int(11) NOT NULL COMMENT '用户ID',
  `t_dishs_number` int(11) NOT NULL COMMENT '菜总数量',
  `t_total_amount` decimal(32,4) NOT NULL COMMENT '订单总金额',
  `t_order_time` datetime NOT NULL COMMENT '下单时间',
  `t_order_status` tinyint(4) DEFAULT '1' COMMENT '订单状态 1:未支付 2:已支付',
  PRIMARY KEY (`t_order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';

/*Data for the table `t_order` */

/*Table structure for table `t_order_details` */

DROP TABLE IF EXISTS `t_order_details`;

CREATE TABLE `t_order_details` (
  `t_details_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '详情ID',
  `t_dishes_id` int(11) NOT NULL COMMENT '菜品ID',
  `t_quantity_note` int(11) DEFAULT NULL COMMENT '菜数量小记',
  `t_note` decimal(20,3) DEFAULT NULL COMMENT '小记',
  PRIMARY KEY (`t_details_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单详情表';

/*Data for the table `t_order_details` */

/*Table structure for table `t_table` */

DROP TABLE IF EXISTS `t_table`;

CREATE TABLE `t_table` (
  `t_table_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '餐桌ID',
  `t_table_name` varchar(20) NOT NULL COMMENT '餐桌名称',
  `t_table_status` tinyint(4) NOT NULL DEFAULT '3' COMMENT '餐桌状态 1未预定 2:已预订 3:空闲 4:使用中',
  `t_scheduled_time` datetime DEFAULT NULL COMMENT '预定时间',
  PRIMARY KEY (`t_table_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='餐桌实体';

/*Data for the table `t_table` */

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `t_user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `t_username` varchar(100) NOT NULL COMMENT '用户名',
  `t_password` varchar(100) NOT NULL COMMENT '密码',
  `t_nickname` varchar(100) NOT NULL COMMENT '昵称',
  `t_admin` tinyint(4) DEFAULT '2' COMMENT '是否管理员 1:是管理员  2:不是管理员',
  `t_phone` varchar(100) DEFAULT NULL COMMENT '手机号',
  `t_gender` tinyint(4) DEFAULT NULL COMMENT '性别  1:男  2:女',
  `t_status` tinyint(4) DEFAULT '1' COMMENT '用户状态  1:激活 2:未激活 3:锁定 4:异常',
  `t_create_time` datetime DEFAULT NULL COMMENT '用户创建时间',
  `t_modifie_time` datetime DEFAULT NULL COMMENT '用户修改时间',
  `t_deleted` tinyint(4) DEFAULT '1' COMMENT '是否删除  1:未删除 2:已删除',
  `t_member` tinyint(4) DEFAULT '1' COMMENT '是否会员 1:非会员 2:会员',
  `t_balance` decimal(32,4) DEFAULT '0.0000' COMMENT '账户余额',
  PRIMARY KEY (`t_user_id`),
  UNIQUE KEY `t_username` (`t_username`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='用户表';

/*Data for the table `t_user` */

insert  into `t_user`(`t_user_id`,`t_username`,`t_password`,`t_nickname`,`t_admin`,`t_phone`,`t_gender`,`t_status`,`t_create_time`,`t_modifie_time`,`t_deleted`,`t_member`,`t_balance`) values 
(1,'admin','cb24e04e1c23699ad92febaff0d75df9','管理员',1,'15356023550',2,1,NULL,'2021-09-15 15:44:30',1,2,0.0000),
(2,'zhangsan','202cb962ac59075b964b07152d234b70','张三122',2,'1111111',1,1,NULL,'2021-09-15 15:54:08',1,2,10000.0000),
(3,'admin1','202cb962ac59075b964b07152d234b70','HuaPai',2,NULL,1,1,'2021-09-14 20:51:41',NULL,1,1,0.0000),
(4,'tom','202cb962ac59075b964b07152d234b70','tom',2,NULL,2,1,'2021-09-14 20:56:38',NULL,1,2,0.0000),
(5,'jack','4297f44b13955235245b2497399d7a93','jacker',2,NULL,2,1,'2021-09-15 16:10:23',NULL,1,2,0.0000);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
