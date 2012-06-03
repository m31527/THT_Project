/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50146
 Source Host           : 127.0.0.1
 Source Database       : tht

 Target Server Type    : MySQL
 Target Server Version : 50146
 File Encoding         : utf-8

 Date: 09/01/2011 00:30:06 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `People`
-- ----------------------------
DROP TABLE IF EXISTS `People`;
CREATE TABLE `People` (
  `people_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `people_name` varchar(255) DEFAULT NULL,
  `people_birthday` varchar(255) DEFAULT NULL,
  `people_birthdayTime` varchar(255) DEFAULT NULL,
  `people_lunerBirthday` varchar(255) DEFAULT NULL,
  `people_address` varchar(255) DEFAULT NULL,
  `people_phone` varchar(255) DEFAULT NULL,
  `people_cellPhone` varchar(255) DEFAULT NULL,
  `people_email` varchar(255) DEFAULT NULL,
  `people_gender` int(20) DEFAULT NULL,
  `people_main` int(20) DEFAULT NULL,
  PRIMARY KEY (`people_id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

