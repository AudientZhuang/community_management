/*
 Navicat Premium Data Transfer

 Source Server         : LK_Connection
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : cm

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 23/04/2020 10:06:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity`  (
  `id` int(10) NOT NULL COMMENT '自增ID',
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '活动图片路径',
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '活动标题',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '活动内容',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '活动地址',
  `number` int(10) NOT NULL COMMENT '活动人数',
  `date` datetime(0) NOT NULL COMMENT '活动日期',
  `publisher` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '活动发布者',
  `publishDate` datetime(0) NOT NULL COMMENT '活动发布日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for activity_register
-- ----------------------------
DROP TABLE IF EXISTS `activity_register`;
CREATE TABLE `activity_register`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `act_id` int(10) NOT NULL COMMENT '外键绑定活动ID',
  `hh_id` int(11) NOT NULL COMMENT '外键绑定住户ID',
  `telephone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '联系电话',
  `num` int(5) NOT NULL COMMENT '报名人数',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `act_rst_activity_fk`(`act_id`) USING BTREE,
  INDEX `act_rst_hh_fk`(`hh_id`) USING BTREE,
  CONSTRAINT `act_rst_activity_fk` FOREIGN KEY (`act_id`) REFERENCES `activity` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `act_rst_hh_fk` FOREIGN KEY (`hh_id`) REFERENCES `household` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '000000' COMMENT '密码(默认6个0)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for admin_role
-- ----------------------------
DROP TABLE IF EXISTS `admin_role`;
CREATE TABLE `admin_role`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `adminId` int(10) NOT NULL COMMENT '外键绑定管理员ID',
  `roleId` int(10) NOT NULL COMMENT '外键绑定角色ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `admin_ar_fk`(`adminId`) USING BTREE,
  INDEX `role_ar_fk`(`roleId`) USING BTREE,
  CONSTRAINT `admin_ar_fk` FOREIGN KEY (`adminId`) REFERENCES `admin` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `role_ar_fk` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for building
-- ----------------------------
DROP TABLE IF EXISTS `building`;
CREATE TABLE `building`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `buildName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '楼栋名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for charge
-- ----------------------------
DROP TABLE IF EXISTS `charge`;
CREATE TABLE `charge`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '缴费项目名称',
  `desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '缴费项目描述',
  `standard` double(10, 0) NOT NULL COMMENT '缴费标准(金额)',
  `creationDate` datetime(0) NOT NULL COMMENT '创建日期',
  `note` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `standard`(`standard`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for facility
-- ----------------------------
DROP TABLE IF EXISTS `facility`;
CREATE TABLE `facility`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '设施名称',
  `cateId` int(10) NOT NULL COMMENT '外键绑定分类ID',
  `num` int(10) NOT NULL COMMENT '设施购入数量',
  `price` double(10, 0) NOT NULL COMMENT '设施价格',
  `purchaseDate` datetime(0) NOT NULL COMMENT '购买日期',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fac_fac_category_fk`(`cateId`) USING BTREE,
  CONSTRAINT `fac_fac_category_fk` FOREIGN KEY (`cateId`) REFERENCES `facility_category` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for facility_category
-- ----------------------------
DROP TABLE IF EXISTS `facility_category`;
CREATE TABLE `facility_category`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `cateName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '设施分类名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for feedback
-- ----------------------------
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `householdId` int(10) NOT NULL COMMENT '外键绑定住户ID',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '反馈内容',
  `date` datetime(0) NOT NULL COMMENT '反馈日期',
  `status` int(1) NOT NULL COMMENT '反馈回复状态(0表示未回复，1表示已回复)',
  `reply` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回复信息',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `feedback_hh-fk`(`householdId`) USING BTREE,
  CONSTRAINT `feedback_hh-fk` FOREIGN KEY (`householdId`) REFERENCES `household` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for fire_security
-- ----------------------------
DROP TABLE IF EXISTS `fire_security`;
CREATE TABLE `fire_security`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `buildId` int(10) NOT NULL COMMENT '外键绑定楼栋ID',
  `createDate` datetime(0) NOT NULL COMMENT '记录创建日期',
  `checkContent` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '检查内容',
  `level` int(1) NULL DEFAULT NULL COMMENT '消防状态等级(0差,需要更新,1良好,2优秀)',
  `checkDate` datetime(0) NULL DEFAULT NULL COMMENT '检查日期',
  `updateDate` datetime(0) NULL DEFAULT NULL COMMENT '更新日期',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fs_build_fk`(`buildId`) USING BTREE,
  CONSTRAINT `fs_build_fk` FOREIGN KEY (`buildId`) REFERENCES `building` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for household
-- ----------------------------
DROP TABLE IF EXISTS `household`;
CREATE TABLE `household`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `gender` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别(男 或 女)',
  `age` int(5) NULL DEFAULT NULL COMMENT '年龄',
  `telephone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `IDcard` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号码',
  `arrivalDate` datetime(0) NULL DEFAULT NULL COMMENT '入住日期',
  `isOwner` int(1) NOT NULL COMMENT '是否为业主(1表示是,0表示否)',
  `buildingId` int(10) NOT NULL COMMENT '外键绑定楼栋ID',
  `roomId` int(10) NOT NULL COMMENT '外键绑定房间ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `build_hh_fk`(`buildingId`) USING BTREE,
  INDEX `room_ff_fk`(`roomId`) USING BTREE,
  CONSTRAINT `build_hh_fk` FOREIGN KEY (`buildingId`) REFERENCES `building` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `room_ff_fk` FOREIGN KEY (`roomId`) REFERENCES `room` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for maintenance
-- ----------------------------
DROP TABLE IF EXISTS `maintenance`;
CREATE TABLE `maintenance`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `facilityId` int(10) NOT NULL COMMENT '外键绑定设施iD',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '维护内容',
  `status` int(1) NOT NULL COMMENT '维护状态(0表示未维护，1表示已维护)',
  `cost` double(10, 0) NULL DEFAULT NULL COMMENT '维护费用',
  `createDate` datetime(0) NOT NULL COMMENT '记录创建日期',
  `date` datetime(0) NULL DEFAULT NULL COMMENT '维护日期',
  `note` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `mt_fac_fk`(`facilityId`) USING BTREE,
  CONSTRAINT `mt_fac_fk` FOREIGN KEY (`facilityId`) REFERENCES `facility` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '新闻图片路径',
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '新闻标题',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '新闻内容',
  `author` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '作者',
  `date` datetime(0) NOT NULL COMMENT '发布日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for payment
-- ----------------------------
DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `householdId` int(10) NOT NULL COMMENT '外键绑定住户ID',
  `charId` int(10) NOT NULL COMMENT '外键绑定缴费项目ID',
  `charStandard` double(10, 0) NOT NULL COMMENT '外键绑定缴费标准',
  `payReal` double(10, 0) NULL DEFAULT NULL COMMENT '实际支付',
  `payStatus` int(1) NOT NULL COMMENT '支付状态(1表示已支付,0表示未支付)',
  `payDate` datetime(0) NULL DEFAULT NULL COMMENT '支付日期',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `pay_hh_fk`(`householdId`) USING BTREE,
  INDEX `pay_charge_fk`(`charId`) USING BTREE,
  INDEX `pay_chargeS_fk`(`charStandard`) USING BTREE,
  CONSTRAINT `pay_chargeS_fk` FOREIGN KEY (`charStandard`) REFERENCES `charge` (`standard`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `pay_charge_fk` FOREIGN KEY (`charId`) REFERENCES `charge` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `pay_hh_fk` FOREIGN KEY (`householdId`) REFERENCES `household` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `permission` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理权限',
  `description` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for repair
-- ----------------------------
DROP TABLE IF EXISTS `repair`;
CREATE TABLE `repair`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `householdId` int(10) NOT NULL COMMENT '外键绑定住户ID',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '报修住户姓名',
  `telephone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '联系电话',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '报修内容',
  `date` datetime(0) NOT NULL COMMENT '报修日期',
  `status` int(1) NOT NULL COMMENT '报修状态(1表示已解决,0表示未解决)',
  `reply` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回复信息',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `repair_hh_fk`(`householdId`) USING BTREE,
  CONSTRAINT `repair_hh_fk` FOREIGN KEY (`householdId`) REFERENCES `household` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `role` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色',
  `description` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `roleId` int(10) NOT NULL COMMENT '外键绑定角色ID',
  `permissionId` int(10) NOT NULL COMMENT '外键绑定权限ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `role_rp_fk`(`roleId`) USING BTREE,
  INDEX `permission_rp_fk`(`permissionId`) USING BTREE,
  CONSTRAINT `permission_rp_fk` FOREIGN KEY (`permissionId`) REFERENCES `permission` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `role_rp_fk` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `buildingId` int(10) NOT NULL COMMENT '外键绑定楼栋ID',
  `roomNum` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '房间号',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `room_building_fk`(`buildingId`) USING BTREE,
  CONSTRAINT `room_building_fk` FOREIGN KEY (`buildingId`) REFERENCES `building` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `hh_id` int(10) NOT NULL COMMENT '外键关联住户id',
  `account` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '住户账号',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '123456' COMMENT '住户密码(默认123456)',
  `unionId` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '住户绑定微信？',
  `openId` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '住户绑定微信？',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_hh_fk`(`hh_id`) USING BTREE,
  CONSTRAINT `user_hh_fk` FOREIGN KEY (`hh_id`) REFERENCES `household` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
