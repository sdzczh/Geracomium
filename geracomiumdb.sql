/*
 Navicat MySQL Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : localhost:3306
 Source Schema         : geracomiumdb

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 20/11/2018 00:14:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', 'admin');

-- ----------------------------
-- Table structure for appointment
-- ----------------------------
DROP TABLE IF EXISTS `appointment`;
CREATE TABLE `appointment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '\'姓名\'',
  `phone` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '\'手机号\'',
  `content` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `create_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '预约登记表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of appointment
-- ----------------------------
INSERT INTO `appointment` VALUES (1, '阿萨德', '155555222', '发生的士大夫12', NULL);
INSERT INTO `appointment` VALUES (2, '大师傅但是', '3213日13', '的身份删掉', '2018-11-19 17:17:39');
INSERT INTO `appointment` VALUES (3, '士大夫', '33', '士大夫', '1899-12-08 10:45');

-- ----------------------------
-- Table structure for bed
-- ----------------------------
DROP TABLE IF EXISTS `bed`;
CREATE TABLE `bed`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL COMMENT '床类型',
  `create_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '床' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bed
-- ----------------------------
INSERT INTO `bed` VALUES (1, 2, 1, '2018-11-19 21:58:29');
INSERT INTO `bed` VALUES (2, 3, 1, '2018-11-19 21:58:35');

-- ----------------------------
-- Table structure for bed_type
-- ----------------------------
DROP TABLE IF EXISTS `bed_type`;
CREATE TABLE `bed_type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `price` decimal(8, 2) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '床位类型' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bed_type
-- ----------------------------
INSERT INTO `bed_type` VALUES (1, '普通', 10.50);
INSERT INTO `bed_type` VALUES (3, '高级', 80.00);

-- ----------------------------
-- Table structure for consult
-- ----------------------------
DROP TABLE IF EXISTS `consult`;
CREATE TABLE `consult`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '\'咨询访客姓名\'',
  `content` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '\'咨询内容\'',
  `create_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '咨询登记表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of consult
-- ----------------------------
INSERT INTO `consult` VALUES (1, '啊啊啊', '手动阀手动阀', '2018-11-19 16:54:40');
INSERT INTO `consult` VALUES (3, '啊啊', '胜多负少的', '2018-11-19 17:06:40');

-- ----------------------------
-- Table structure for device
-- ----------------------------
DROP TABLE IF EXISTS `device`;
CREATE TABLE `device`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `userId` int(11) DEFAULT NULL COMMENT '老人id',
  `state` int(11) DEFAULT NULL COMMENT '0使用中 1使用完成',
  `create_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '设备使用情况' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of device
-- ----------------------------
INSERT INTO `device` VALUES (1, '阿萨德1', 3, 0, NULL);

-- ----------------------------
-- Table structure for diet
-- ----------------------------
DROP TABLE IF EXISTS `diet`;
CREATE TABLE `diet`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `price` decimal(8, 2) DEFAULT NULL,
  `create_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '饮食' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of diet
-- ----------------------------
INSERT INTO `diet` VALUES (1, '大师傅1', 221.00, '2018-11-14 17:50');

-- ----------------------------
-- Table structure for info
-- ----------------------------
DROP TABLE IF EXISTS `info`;
CREATE TABLE `info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL DEFAULT 0 COMMENT '老人id',
  `bedId` int(11) NOT NULL DEFAULT 0 COMMENT '床位id',
  `state` int(11) NOT NULL DEFAULT 0 COMMENT '是否缴费 0未缴 1已缴',
  `create_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '入住时间',
  `exit_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '离院时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of info
-- ----------------------------
INSERT INTO `info` VALUES (1, 2, 11, 1, '2018-11-07 10:50', '2018-11-10 06:30');

-- ----------------------------
-- Table structure for nurse
-- ----------------------------
DROP TABLE IF EXISTS `nurse`;
CREATE TABLE `nurse`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `userId` int(11) DEFAULT NULL COMMENT '老人id',
  `create_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '护工管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of nurse
-- ----------------------------
INSERT INTO `nurse` VALUES (1, '大方1', 3, '2018-11-20 00:02:19');

-- ----------------------------
-- Table structure for oper_reper
-- ----------------------------
DROP TABLE IF EXISTS `oper_reper`;
CREATE TABLE `oper_reper`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rid` int(11) DEFAULT NULL COMMENT '仓库id',
  `sid` int(11) DEFAULT NULL COMMENT '员工id',
  `type` int(11) DEFAULT NULL COMMENT '0入库 1出库',
  `create_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '入库/出库管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of oper_reper
-- ----------------------------
INSERT INTO `oper_reper` VALUES (1, 1, 3, 0, '2018-11-23 14:50:00');
INSERT INTO `oper_reper` VALUES (3, 1, 1, 1, '2018-11-19 23:34:35');

-- ----------------------------
-- Table structure for outlog
-- ----------------------------
DROP TABLE IF EXISTS `outlog`;
CREATE TABLE `outlog`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL COMMENT '老人id',
  `withName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '陪同人姓名',
  `create_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '外出' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of outlog
-- ----------------------------
INSERT INTO `outlog` VALUES (1, 2, '士大夫', '1899-12-14 14:45');
INSERT INTO `outlog` VALUES (3, 3, '的身份22', '1899-12-06 00:30');

-- ----------------------------
-- Table structure for register
-- ----------------------------
DROP TABLE IF EXISTS `register`;
CREATE TABLE `register`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `age` int(11) NOT NULL,
  `sex` int(11) NOT NULL,
  `remark` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '无',
  `create_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '入住登记' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for repertory
-- ----------------------------
DROP TABLE IF EXISTS `repertory`;
CREATE TABLE `repertory`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '仓库名称',
  `sid` int(11) DEFAULT NULL COMMENT '员工id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '仓库' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of repertory
-- ----------------------------
INSERT INTO `repertory` VALUES (1, '地方', 3);

-- ----------------------------
-- Table structure for staff
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `position` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '职位',
  `create_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '员工' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of staff
-- ----------------------------
INSERT INTO `staff` VALUES (1, '下次2', 223, '131653732803', '站长11', NULL);
INSERT INTO `staff` VALUES (3, '地方', 22, '13954786025', '山东', '2018-11-19 22:41:24');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `age` int(50) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `bedId` int(11) DEFAULT NULL COMMENT '床位号',
  `create_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (2, '张三', 88, 0, 1, '2018-11-19 00:00:00');
INSERT INTO `user` VALUES (3, 'zgsdzczh', 33, 0, 2, '2018-11-19 15:36:38');

-- ----------------------------
-- Table structure for visit
-- ----------------------------
DROP TABLE IF EXISTS `visit`;
CREATE TABLE `visit`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `userId` int(11) DEFAULT NULL COMMENT '老人id',
  `relation` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '关系',
  `create_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `exit_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '离开时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '探视' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of visit
-- ----------------------------
INSERT INTO `visit` VALUES (1, '斯蒂芬1', 2, '斯蒂芬2', '2018-11-20 09:25', '2018-10-12 20:25');

SET FOREIGN_KEY_CHECKS = 1;
