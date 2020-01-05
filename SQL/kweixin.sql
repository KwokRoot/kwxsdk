/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50553
Source Host           : localhost:3306
Source Database       : kweixin

Target Server Type    : MYSQL
Target Server Version : 50553
File Encoding         : 65001

Date: 2017-09-30 17:23:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user_a`
-- ----------------------------
DROP TABLE IF EXISTS `user_a`;
CREATE TABLE `user_a` (
  `openid` varchar(60) NOT NULL DEFAULT '' COMMENT '用户的唯一标识',
  `nickname` varchar(60) DEFAULT NULL COMMENT '用户昵称',
  `sex` int(2) DEFAULT NULL COMMENT '用户的性别，值为1时是男性，值为2时是女性，值为0时是未知',
  `country` varchar(60) DEFAULT NULL COMMENT '国家，如中国为CN',
  `province` varchar(60) DEFAULT NULL COMMENT '用户个人资料填写的省份',
  `city` varchar(60) DEFAULT NULL COMMENT '普通用户个人资料填写的城市',
  `language` varchar(60) DEFAULT NULL COMMENT '用户的语言，简体中文为zh_CN',
  `headimgurl` varchar(255) DEFAULT NULL COMMENT '用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。',
  `privilege` varchar(255) DEFAULT NULL COMMENT '用户特权信息，json 数组，如微信沃卡用户为（chinaunicom）',
  `unionid` varchar(60) DEFAULT NULL COMMENT '只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。',
  PRIMARY KEY (`openid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `user_b`
-- ----------------------------
DROP TABLE IF EXISTS `user_b`;
CREATE TABLE `user_b` (
  `openid` varchar(60) NOT NULL DEFAULT '' COMMENT '用户的唯一标识',
  `nickname` varchar(60) DEFAULT NULL COMMENT '用户昵称',
  `sex` int(2) DEFAULT NULL COMMENT '用户的性别，值为1时是男性，值为2时是女性，值为0时是未知',
  `country` varchar(60) DEFAULT NULL COMMENT '国家，如中国为CN',
  `province` varchar(60) DEFAULT NULL COMMENT '用户个人资料填写的省份',
  `city` varchar(60) DEFAULT NULL COMMENT '普通用户个人资料填写的城市',
  `language` varchar(60) DEFAULT NULL COMMENT '用户的语言，简体中文为zh_CN',
  `headimgurl` varchar(255) DEFAULT NULL COMMENT '用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。',
  `subscribe_time` varchar(20) DEFAULT NULL COMMENT '用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间',
  `remark` varchar(60) DEFAULT NULL COMMENT '公众号运营者对粉丝的备注，公众号运营者可在微信公众平台用户管理界面对粉丝添加备注',
  `groupid` int(6) DEFAULT NULL COMMENT '用户所在的分组ID（兼容旧的用户分组接口）',
  `tagid_list` varchar(60) DEFAULT NULL COMMENT '用户被打上的标签ID列表',
  `unionid` varchar(60) DEFAULT NULL COMMENT '只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。',
  `subscribe` int(2) DEFAULT NULL COMMENT '用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息。',
  PRIMARY KEY (`openid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for `record_1`
-- ----------------------------
DROP TABLE IF EXISTS `record_1`;
CREATE TABLE `record_1` (
  `unionid` varchar(60) NOT NULL,
  `itemid` varchar(60) NOT NULL,
  `time` datetime NOT NULL,
  PRIMARY KEY (`unionid`,`itemid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

