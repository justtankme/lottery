/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost
 Source Database       : lottery

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : utf-8

 Date: 03/15/2018 21:52:50 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `lottery_award`
-- ----------------------------
DROP TABLE IF EXISTS `lottery_award`;
CREATE TABLE `lottery_award` (
  `award_id` int(11) NOT NULL AUTO_INCREMENT,
  `award_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `award_percent` decimal(10,10) NOT NULL COMMENT '中奖率',
  `award_num` int(10) DEFAULT NULL COMMENT '奖品总数量',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`award_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `lottery_award`
-- ----------------------------
BEGIN;
INSERT INTO `lottery_award` VALUES ('1', '苹果电脑不要钱', '0.0000010000', '1', '2018-03-15 21:11:52', null), ('2', '华为手机白送你', '0.0000100000', '10', '2018-03-15 21:13:08', null), ('3', '雷蛇鼠标一车拉', '0.0001000000', '100', '2018-03-15 21:13:56', null), ('4', '小米音响也不错', '0.0010000000', '1000', '2018-03-15 21:14:40', null);
COMMIT;

-- ----------------------------
--  Table structure for `lottery_record`
-- ----------------------------
DROP TABLE IF EXISTS `lottery_record`;
CREATE TABLE `lottery_record` (
  `record_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `award_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`record_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `lottery_record`
-- ----------------------------

-- ----------------------------
--  Table structure for `lottery_user`
-- ----------------------------
DROP TABLE IF EXISTS `lottery_user`;
CREATE TABLE `lottery_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `user_times` int(10) DEFAULT NULL,
  `user_priority` int(11) DEFAULT NULL COMMENT '用户权重',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `lottery_user`
-- ----------------------------
BEGIN;
INSERT INTO `lottery_user` VALUES ('1', '百抽百中1', '2', '1', '2018-03-15 21:23:46', '2018-03-15 21:23:46'), ('2', '百抽百中2', '2', '1', '2018-03-15 21:23:46', '2018-03-15 21:23:46'), ('3', '百抽百中3', '2', '1', '2018-03-15 21:23:46', '2018-03-15 21:23:46'), ('4', '百抽百中4', '2', '1', '2018-03-15 21:23:46', '2018-03-15 21:23:46'), ('5', '百抽百中5', '2', '1', '2018-03-15 21:23:46', '2018-03-15 21:23:46');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
