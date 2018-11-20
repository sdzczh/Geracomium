/*
SQLyog Ultimate v11.13 (64 bit)
MySQL - 5.7.19 : Database - geracomiumdb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`geracomiumdb` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `geracomiumdb`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `admin` */

insert  into `admin`(`id`,`account`,`password`) values (1,'admin','123');

/*Table structure for table `appointment` */

DROP TABLE IF EXISTS `appointment`;

CREATE TABLE `appointment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL COMMENT '''姓名''',
  `phone` varchar(45) DEFAULT NULL COMMENT '''手机号''',
  `content` varchar(45) DEFAULT NULL COMMENT '备注',
  `create_time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='预约登记表';

/*Data for the table `appointment` */

insert  into `appointment`(`id`,`name`,`phone`,`content`,`create_time`) values (1,'阿萨德','155555222','发生的士大夫12',NULL),(2,'大师傅但是','3213日13','的身份删掉','2018-11-19 17:17:39'),(3,'士大夫','33','士大夫','1899-12-08 10:45');

/*Table structure for table `bed` */

DROP TABLE IF EXISTS `bed`;

CREATE TABLE `bed` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL COMMENT '床类型',
  `create_time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='床';

/*Data for the table `bed` */

insert  into `bed`(`id`,`userId`,`type`,`create_time`) values (1,2,1,NULL),(2,3,1,'2018-11-20 11:08:09');

/*Table structure for table `bed_type` */

DROP TABLE IF EXISTS `bed_type`;

CREATE TABLE `bed_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `price` decimal(8,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='床位类型';

/*Data for the table `bed_type` */

insert  into `bed_type`(`id`,`name`,`price`) values (1,'common',50.00),(2,'ggg',90.00);

/*Table structure for table `consult` */

DROP TABLE IF EXISTS `consult`;

CREATE TABLE `consult` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL COMMENT '''咨询访客姓名''',
  `content` varchar(45) DEFAULT NULL COMMENT '''咨询内容''',
  `create_time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='咨询登记表';

/*Data for the table `consult` */

insert  into `consult`(`id`,`name`,`content`,`create_time`) values (1,'啊啊啊','手动阀手动阀','2018-11-19 16:54:40'),(3,'啊啊','胜多负少的','2018-11-19 17:06:40');

/*Table structure for table `device` */

DROP TABLE IF EXISTS `device`;

CREATE TABLE `device` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL COMMENT '老人id',
  `state` int(11) DEFAULT NULL COMMENT '0使用中 1使用完成',
  `create_time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='设备使用情况';

/*Data for the table `device` */

insert  into `device`(`id`,`name`,`userId`,`state`,`create_time`) values (1,'等等',1,0,'2018-11-20 11:18:21');

/*Table structure for table `diet` */

DROP TABLE IF EXISTS `diet`;

CREATE TABLE `diet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `create_time` varchar(255) DEFAULT NULL,
  `price` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='饮食';

/*Data for the table `diet` */

insert  into `diet`(`id`,`name`,`create_time`,`price`) values (1,'爱的色放 ','2018-11-29 09:50',22.00),(2,'稍等','1899-12-20 09:45',22.00);

/*Table structure for table `info` */

DROP TABLE IF EXISTS `info`;

CREATE TABLE `info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL DEFAULT '0' COMMENT '老人id',
  `bedId` int(11) NOT NULL DEFAULT '0' COMMENT '床位id',
  `state` int(11) NOT NULL DEFAULT '0' COMMENT '是否缴费 0未缴 1已缴',
  `amount` decimal(8,2) DEFAULT NULL COMMENT '缴费金额',
  `create_time` varchar(255) DEFAULT NULL COMMENT '入住时间',
  `exit_time` varchar(255) DEFAULT NULL COMMENT '离院时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `info` */

insert  into `info`(`id`,`userId`,`bedId`,`state`,`amount`,`create_time`,`exit_time`) values (1,2,1,1,50.00,'2018-11-07 10:50:00','2018-11-10 06:30:00'),(3,3,2,0,11.00,'2018-11-13 11:11:20','2018-11-16 06:30:12');

/*Table structure for table `nurse` */

DROP TABLE IF EXISTS `nurse`;

CREATE TABLE `nurse` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL COMMENT '老人id',
  `create_time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='护工管理';

/*Data for the table `nurse` */

insert  into `nurse`(`id`,`name`,`userId`,`create_time`) values (1,'撒旦',2,'2018-11-20 11:18:30');

/*Table structure for table `oper_reper` */

DROP TABLE IF EXISTS `oper_reper`;

CREATE TABLE `oper_reper` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rid` int(11) DEFAULT NULL COMMENT '仓库id',
  `sid` int(11) DEFAULT NULL COMMENT '员工id',
  `type` int(11) DEFAULT NULL COMMENT '0入库 1出库',
  `create_time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='入库/出库管理';

/*Data for the table `oper_reper` */

insert  into `oper_reper`(`id`,`rid`,`sid`,`type`,`create_time`) values (1,1,1,0,'2018-11-20 11:18:14');

/*Table structure for table `outlog` */

DROP TABLE IF EXISTS `outlog`;

CREATE TABLE `outlog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL COMMENT '老人id',
  `withName` varchar(50) DEFAULT NULL COMMENT '陪同人姓名',
  `create_time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='外出';

/*Data for the table `outlog` */

insert  into `outlog`(`id`,`userId`,`withName`,`create_time`) values (1,2,'士大夫','1899-12-14 14:45'),(3,3,'的身份22','1899-12-06 00:30');

/*Table structure for table `register` */

DROP TABLE IF EXISTS `register`;

CREATE TABLE `register` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL COMMENT '姓名',
  `age` int(11) NOT NULL,
  `sex` int(11) NOT NULL,
  `remark` varchar(45) NOT NULL DEFAULT '无',
  `create_time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='入住登记';

/*Data for the table `register` */

/*Table structure for table `repertory` */

DROP TABLE IF EXISTS `repertory`;

CREATE TABLE `repertory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL COMMENT '仓库名称',
  `sid` int(11) DEFAULT NULL COMMENT '员工id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='仓库';

/*Data for the table `repertory` */

insert  into `repertory`(`id`,`name`,`sid`) values (1,'阿瑟东',1);

/*Table structure for table `staff` */

DROP TABLE IF EXISTS `staff`;

CREATE TABLE `staff` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `position` varchar(50) DEFAULT NULL COMMENT '职位',
  `create_time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='员工';

/*Data for the table `staff` */

insert  into `staff`(`id`,`name`,`age`,`phone`,`position`,`create_time`) values (1,'爱的色放',22,'13165373280','稍等','2018-11-20 11:17:49');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `age` int(50) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `bedId` int(11) DEFAULT NULL COMMENT '床位号',
  `create_time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`age`,`sex`,`bedId`,`create_time`) values (2,'张三',88,0,1,'2018-11-19 00:00:00'),(3,'zgsdzczh',33,0,0,'2018-11-19 15:36:38');

/*Table structure for table `visit` */

DROP TABLE IF EXISTS `visit`;

CREATE TABLE `visit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL COMMENT '老人id',
  `relation` varchar(50) DEFAULT NULL COMMENT '关系',
  `create_time` varchar(255) DEFAULT NULL,
  `exit_time` varchar(255) DEFAULT NULL COMMENT '离开时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='探视';

/*Data for the table `visit` */

insert  into `visit`(`id`,`name`,`userId`,`relation`,`create_time`,`exit_time`) values (1,'稍等',2,'父子','2018-11-20 11:20:39','2018-11-10 11:35');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
