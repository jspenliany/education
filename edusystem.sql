/*
 Navicat MySQL Data Transfer

 Source Server         : edusys
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : localhost:3306
 Source Schema         : edusystem

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 01/05/2021 15:01:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for class_bind
-- ----------------------------
DROP TABLE IF EXISTS `class_bind`;
CREATE TABLE `class_bind`  (
  `gcid` int(11) NOT NULL COMMENT '班编号',
  `gid` int(11) NOT NULL COMMENT '年级编号',
  `cId` int(11) NOT NULL COMMENT '班级编号',
  PRIMARY KEY (`gcid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for class_info
-- ----------------------------
DROP TABLE IF EXISTS `class_info`;
CREATE TABLE `class_info`  (
  `cid` int(8) NOT NULL,
  `ctype` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for classmap_bystu
-- ----------------------------
DROP TABLE IF EXISTS `classmap_bystu`;
CREATE TABLE `classmap_bystu`  (
  `id` int(11) NOT NULL,
  `stuid` int(11) NOT NULL COMMENT '学生编号',
  `claid` int(11) NOT NULL COMMENT '班级编号',
  `roletype` int(8) NOT NULL COMMENT '职务',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `stuid`(`stuid`) USING BTREE,
  INDEX `claid`(`claid`) USING BTREE,
  CONSTRAINT `classmap_bystu_ibfk_1` FOREIGN KEY (`stuid`) REFERENCES `stud_info` (`sid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `classmap_bystu_ibfk_2` FOREIGN KEY (`claid`) REFERENCES `class_bind` (`gcid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for course_info
-- ----------------------------
DROP TABLE IF EXISTS `course_info`;
CREATE TABLE `course_info`  (
  `cid` int(11) NOT NULL COMMENT '课程编号',
  `coursename` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '汉字' COMMENT '教学科目',
  PRIMARY KEY (`cid`) USING BTREE,
  INDEX `cid`(`cid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course_info
-- ----------------------------
INSERT INTO `course_info` VALUES (10010001, '语文');
INSERT INTO `course_info` VALUES (10010002, '数学');
INSERT INTO `course_info` VALUES (10010003, '英语');
INSERT INTO `course_info` VALUES (10010004, '计算机');
INSERT INTO `course_info` VALUES (10010005, '音乐');
INSERT INTO `course_info` VALUES (10010006, '美术');
INSERT INTO `course_info` VALUES (10010007, '体育');
INSERT INTO `course_info` VALUES (10010008, '手工');
INSERT INTO `course_info` VALUES (10010009, '历史');
INSERT INTO `course_info` VALUES (10010010, '地理');
INSERT INTO `course_info` VALUES (10010011, '生物');
INSERT INTO `course_info` VALUES (10010012, '化学');
INSERT INTO `course_info` VALUES (10010013, '物理');
INSERT INTO `course_info` VALUES (10010014, '政治');

-- ----------------------------
-- Table structure for coursemap_bystu
-- ----------------------------
DROP TABLE IF EXISTS `coursemap_bystu`;
CREATE TABLE `coursemap_bystu`  (
  `csid` int(11) NOT NULL,
  `stuid` int(11) NOT NULL COMMENT '学生编号',
  `couid` int(11) NOT NULL COMMENT '课程编号',
  PRIMARY KEY (`csid`) USING BTREE,
  INDEX `stuid`(`stuid`) USING BTREE,
  INDEX `couid`(`couid`) USING BTREE,
  CONSTRAINT `coursemap_bystu_ibfk_1` FOREIGN KEY (`stuid`) REFERENCES `stud_info` (`sid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `coursemap_bystu_ibfk_2` FOREIGN KEY (`couid`) REFERENCES `course_info` (`cid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for coursemap_bytea
-- ----------------------------
DROP TABLE IF EXISTS `coursemap_bytea`;
CREATE TABLE `coursemap_bytea`  (
  `ctid` int(11) NOT NULL AUTO_INCREMENT,
  `teaid` int(11) NOT NULL COMMENT '教师编号',
  `couid` int(11) NOT NULL COMMENT '课程编号',
  PRIMARY KEY (`ctid`) USING BTREE,
  INDEX `teaid`(`teaid`) USING BTREE,
  INDEX `couid`(`couid`) USING BTREE,
  CONSTRAINT `coursemap_bytea_ibfk_1` FOREIGN KEY (`teaid`) REFERENCES `teacher_info` (`tid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `coursemap_bytea_ibfk_2` FOREIGN KEY (`couid`) REFERENCES `course_info` (`cid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for employee_info
-- ----------------------------
DROP TABLE IF EXISTS `employee_info`;
CREATE TABLE `employee_info`  (
  `eid` int(11) NOT NULL,
  `teaname` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '李老师' COMMENT '姓名',
  `idserial` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '身份证号码',
  `telephone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `address` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '家庭地址',
  `email` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电子邮件',
  `sex` enum('男','女') CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '男' COMMENT '性别',
  `age` int(11) NULL DEFAULT 199 COMMENT '年龄',
  PRIMARY KEY (`eid`) USING BTREE,
  CONSTRAINT `employee_info_ibfk_1` FOREIGN KEY (`eid`) REFERENCES `user_info` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for grade_info
-- ----------------------------
DROP TABLE IF EXISTS `grade_info`;
CREATE TABLE `grade_info`  (
  `gid` int(8) NOT NULL COMMENT '年级编号',
  `gtype` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`gid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for period_info
-- ----------------------------
DROP TABLE IF EXISTS `period_info`;
CREATE TABLE `period_info`  (
  `peid` int(8) NOT NULL COMMENT '第几节课编号',
  `periodname` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '第几节课',
  `starttime` time(0) NOT NULL COMMENT '开始时间',
  `endtime` time(0) NOT NULL COMMENT '结束时间',
  PRIMARY KEY (`peid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for prof_type
-- ----------------------------
DROP TABLE IF EXISTS `prof_type`;
CREATE TABLE `prof_type`  (
  `tid` int(8) NOT NULL COMMENT '等级编号',
  `type` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '等级名称',
  PRIMARY KEY (`tid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role_info
-- ----------------------------
DROP TABLE IF EXISTS `role_info`;
CREATE TABLE `role_info`  (
  `rid` int(11) NOT NULL COMMENT '职务编号',
  `rolename` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '职务',
  PRIMARY KEY (`rid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for room_info
-- ----------------------------
DROP TABLE IF EXISTS `room_info`;
CREATE TABLE `room_info`  (
  `rid` int(11) NOT NULL COMMENT '教室编号',
  `location` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '教室位置',
  PRIMARY KEY (`rid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for score_chinese
-- ----------------------------
DROP TABLE IF EXISTS `score_chinese`;
CREATE TABLE `score_chinese`  (
  `stuid` int(11) NOT NULL COMMENT '学生编号',
  `score` float(5, 2) NOT NULL DEFAULT 0.00 COMMENT '语文成绩',
  PRIMARY KEY (`stuid`) USING BTREE,
  CONSTRAINT `score_chinese_ibfk_1` FOREIGN KEY (`stuid`) REFERENCES `stud_info` (`sid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for score_english
-- ----------------------------
DROP TABLE IF EXISTS `score_english`;
CREATE TABLE `score_english`  (
  `stuid` int(11) NOT NULL COMMENT '学生编号',
  `score` float(5, 2) NOT NULL DEFAULT 0.00 COMMENT '英语成绩',
  PRIMARY KEY (`stuid`) USING BTREE,
  CONSTRAINT `score_english_ibfk_1` FOREIGN KEY (`stuid`) REFERENCES `stud_info` (`sid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for score_math
-- ----------------------------
DROP TABLE IF EXISTS `score_math`;
CREATE TABLE `score_math`  (
  `stuid` int(11) NOT NULL COMMENT '学生编号',
  `score` float(5, 2) NOT NULL DEFAULT 0.00 COMMENT '数学成绩',
  PRIMARY KEY (`stuid`) USING BTREE,
  CONSTRAINT `score_math_ibfk_1` FOREIGN KEY (`stuid`) REFERENCES `stud_info` (`sid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for score_type
-- ----------------------------
DROP TABLE IF EXISTS `score_type`;
CREATE TABLE `score_type`  (
  `sid` int(8) NOT NULL COMMENT '成绩等级编号',
  `stypename` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '良',
  PRIMARY KEY (`sid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for stud_info
-- ----------------------------
DROP TABLE IF EXISTS `stud_info`;
CREATE TABLE `stud_info`  (
  `sid` int(11) NOT NULL,
  `stuname` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '学生甲' COMMENT '姓名',
  `idserial` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '身份证号码',
  `telephone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `address` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '家庭地址',
  `email` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电子邮件',
  `sex` enum('男','女') CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '男' COMMENT '性别',
  `age` int(11) NULL DEFAULT 199 COMMENT '年龄',
  PRIMARY KEY (`sid`) USING BTREE,
  CONSTRAINT `stud_info_ibfk_1` FOREIGN KEY (`sid`) REFERENCES `user_info` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for teacher_info
-- ----------------------------
DROP TABLE IF EXISTS `teacher_info`;
CREATE TABLE `teacher_info`  (
  `tid` int(11) NOT NULL,
  `teaname` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '李老师' COMMENT '姓名',
  `type` int(8) NOT NULL COMMENT '教授级别',
  `idserial` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '身份证号码',
  `telephone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `address` varchar(80) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '家庭地址',
  `email` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电子邮件',
  `sex` enum('男','女') CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '男' COMMENT '性别',
  `age` int(11) NULL DEFAULT 199 COMMENT '年龄',
  PRIMARY KEY (`tid`) USING BTREE,
  INDEX `type`(`type`) USING BTREE,
  CONSTRAINT `firstfkey` FOREIGN KEY (`tid`) REFERENCES `user_info` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `teacher_info_ibfk_1` FOREIGN KEY (`type`) REFERENCES `prof_type` (`tid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL DEFAULT 1000001 COMMENT '编号',
  `username` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'NEWvisitor' COMMENT '登录名',
  `userpwd` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '123456' COMMENT '密码',
  `email` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电子邮件',
  `sex` enum('男','女','undif') CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'undif' COMMENT '性别',
  `role` enum('superm','admin','teacher','student','employee','undif') CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT 'undif' COMMENT '角色',
  `active` tinyint(4) NULL DEFAULT 0 COMMENT '当前在线',
  `lastLogin` datetime(0) NULL DEFAULT NULL COMMENT '最近登录时刻',
  PRIMARY KEY (`id`, `userid`) USING BTREE,
  INDEX `did`(`userid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (2, 1004000002, 'rain', '123456', 'penliany01@sina.cn', '男', 'admin', 0, NULL);
INSERT INTO `user_info` VALUES (3, 1003000003, 'rabbit', '123456', 'penliany03@qq.com', '女', 'teacher', 0, '2021-04-06 07:11:39');
INSERT INTO `user_info` VALUES (9, 1005000001, 'self', 'self', 'self@self.org', '男', 'superm', 1, '2021-04-07 09:18:45');
INSERT INTO `user_info` VALUES (11, 1004000003, 'east', 'east', 'penlianyeast@east.edu', '女', 'admin', 0, '2021-03-13 04:14:46');
INSERT INTO `user_info` VALUES (12, 1003000004, 'epone', 'epone', 'penliany00@163.com', '男', 'employee', 0, NULL);
INSERT INTO `user_info` VALUES (13, 1003000005, 'eptwo', 'eptwo', 'penliany00@163.com', '女', 'employee', 0, '2021-03-13 05:24:31');
INSERT INTO `user_info` VALUES (19, 1004000004, 'admchen', 'chen', 'penliany00@163.com', '女', 'admin', 0, '2021-03-13 05:34:57');
INSERT INTO `user_info` VALUES (21, 1002000001, 'teahan', 'han', 'hanmin@sacu.edu', '男', 'teacher', 0, '2021-03-13 05:44:02');
INSERT INTO `user_info` VALUES (22, 1001000001, 'stusun', 'sun', 'sunzhen@qrnu.edu', '男', 'student', 0, NULL);
INSERT INTO `user_info` VALUES (23, 1001000002, 'stuwang', 'wang', 'wangcheng@shjt.edu', '男', 'student', 0, NULL);
INSERT INTO `user_info` VALUES (24, 1001000003, 'stusong', 'song', 'songling@xbu.edu', '女', 'student', 0, '2021-04-05 03:26:59');
INSERT INTO `user_info` VALUES (25, 1003000006, 'epgu', 'gu', 'gu@163.com', '男', 'employee', 1, '2021-04-06 07:12:35');
INSERT INTO `user_info` VALUES (26, 1002000002, 'teayuan', 'yuan', 'yuanshang@renmin.edu', '女', 'teacher', 0, '2021-03-14 09:00:36');
INSERT INTO `user_info` VALUES (27, 1002000003, 'teazhao', 'zhao', 'zhaozhang@tsinghua.edu', '男', 'teacher', 0, NULL);
INSERT INTO `user_info` VALUES (28, 1002000004, 'teachen', 'chen', 'chenwei@pku.edu', '男', 'teacher', 0, '2021-03-16 02:06:53');
INSERT INTO `user_info` VALUES (29, 1002000005, 'teageng', 'geng', 'gengzhong@sdu.edu', '男', 'teacher', 0, NULL);
INSERT INTO `user_info` VALUES (31, 1003000007, 'epthree', 'three', 'epthreee@163.com', '男', 'employee', 0, NULL);

SET FOREIGN_KEY_CHECKS = 1;
