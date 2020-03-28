## SQL script
````
SET FOREIGN_KEY_CHECKS=0;

CREATE TABLE `sys_permission` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `parentId` INT(11) NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  `css` VARCHAR(30) DEFAULT NULL,
  `href` VARCHAR(1000) DEFAULT NULL,
  `type` INT(11) NOT NULL,
  `permission` VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb4;

INSERT INTO `sys_permission` VALUES ('1', '0', '用户管理', '', '', '1', 'sys:user:query');
INSERT INTO `sys_permission` VALUES ('2', '1', '用户列表', '', '/api/getPage?pageName=user/user-list', '1', '');

INSERT INTO `sys_permission` VALUES ('3', '0', '科室管理', '', '', '1', '');
INSERT INTO `sys_permission` VALUES ('4', '3', '科室列表', '', '/api/getPage?pageName=dep/dep-list', '1', '');
INSERT INTO `sys_permission` VALUES ('5', '4', '新增', '', '', '2', 'sys:dep:add');
INSERT INTO `sys_permission` VALUES ('6', '4', '删除', '', '', '2', 'sys:dep:del');
INSERT INTO `sys_permission` VALUES ('7', '4', '修改', '', '', '2', 'sys:dep:edit');

INSERT INTO `sys_permission` VALUES ('8', '0', '医生管理', NULL, '', '1', '');
INSERT INTO `sys_permission` VALUES ('9', '8', '医生列表', '', '/api/getPage?pageName=doc/doc-list', '1', '');
INSERT INTO `sys_permission` VALUES ('10', '9', '新增', '', '', '2', 'sys:doc:add');
INSERT INTO `sys_permission` VALUES ('11', '9', '删除', '', '', '2', 'sys:doc:del');
INSERT INTO `sys_permission` VALUES ('12', '9', '修改', '', '', '2', 'sys:doc:edit');

INSERT INTO `sys_permission` VALUES ('13', '0', '资源管理', NULL, '', '1', 'sys:res:query');
INSERT INTO `sys_permission` VALUES ('14', '13', '轮播列表', '', '/api/getPage?pageName=pic/pic-list', '1', '');
INSERT INTO `sys_permission` VALUES ('15', '13', '文章列表', '', '/api/getPage?pageName=art/art-list', '1', '');

INSERT INTO `sys_permission` VALUES ('16', '0', '咨询管理', NULL, '', '1', 'sys:inq:query');
INSERT INTO `sys_permission` VALUES ('17', '16', '咨询列表', '', '/api/getPage?pageName=inq/inq-list', '1', '');

INSERT INTO `sys_permission` VALUES ('18', '0', '挂号管理', NULL, '', '1', 'sys:order:query');
INSERT INTO `sys_permission` VALUES ('19', '18', '挂号列表', '', '/api/getPage?pageName=order/order-list', '1', '');

INSERT INTO `sys_permission` VALUES ('20', '0', '数据源监控', 'fa-eye', 'druid/index.html', '1', 'sys:datasource:query');

-- ----------------------------

-- ----------------------------

CREATE TABLE `sys_role` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `description` VARCHAR(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`) USING BTREE
) ENGINE=INNODB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;


INSERT INTO `sys_role` VALUES ('1', 'admin', '管理员');
INSERT INTO `sys_role` VALUES ('2', 'doctor', '医生');
INSERT INTO `sys_role` VALUES ('3', 'patient', '病人');

-- ----------------------------

-- ----------------------------

CREATE TABLE `sys_role_permission` (
  `roleId` INT(11) NOT NULL,
  `permissionId` INT(11) NOT NULL,
  PRIMARY KEY (`roleId`,`permissionId`),
  KEY `fk_sysrolepermission_permissionId` (`permissionId`),
  CONSTRAINT `fk_permission_roleId` FOREIGN KEY (`roleId`) REFERENCES `sys_role` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_sysrolepermission_permissionId` FOREIGN KEY (`permissionId`) REFERENCES `sys_permission` (`id`) ON DELETE CASCADE
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4;

INSERT INTO `sys_role_permission` VALUES ('1', '1');
INSERT INTO `sys_role_permission` VALUES ('1', '2');
INSERT INTO `sys_role_permission` VALUES ('1', '3');
INSERT INTO `sys_role_permission` VALUES ('1', '4');
INSERT INTO `sys_role_permission` VALUES ('1', '5');
INSERT INTO `sys_role_permission` VALUES ('1', '6');
INSERT INTO `sys_role_permission` VALUES ('1', '7');
INSERT INTO `sys_role_permission` VALUES ('1', '8');
INSERT INTO `sys_role_permission` VALUES ('1', '9');
INSERT INTO `sys_role_permission` VALUES ('1', '10');
INSERT INTO `sys_role_permission` VALUES ('1', '11');
INSERT INTO `sys_role_permission` VALUES ('1', '12');
INSERT INTO `sys_role_permission` VALUES ('1', '13');
INSERT INTO `sys_role_permission` VALUES ('1', '14');
INSERT INTO `sys_role_permission` VALUES ('1', '15');
INSERT INTO `sys_role_permission` VALUES ('1', '18');
INSERT INTO `sys_role_permission` VALUES ('1', '19');
INSERT INTO `sys_role_permission` VALUES ('1', '20');
INSERT INTO `sys_role_permission` VALUES ('2', '3');
INSERT INTO `sys_role_permission` VALUES ('2', '4');
INSERT INTO `sys_role_permission` VALUES ('2', '8');
INSERT INTO `sys_role_permission` VALUES ('2', '9');
INSERT INTO `sys_role_permission` VALUES ('2', '16');
INSERT INTO `sys_role_permission` VALUES ('2', '17');
INSERT INTO `sys_role_permission` VALUES ('3', '1');

-- ----------------------------

-- ----------------------------

CREATE TABLE `sys_role_user` (
  `userId` INT(11) NOT NULL,
  `roleId` INT(11) NOT NULL,
  PRIMARY KEY (`userId`,`roleId`),
  KEY `fk_roleId` (`roleId`),
  CONSTRAINT `fk_roleId` FOREIGN KEY (`roleId`) REFERENCES `sys_role` (`id`),
  CONSTRAINT `fk_userId` FOREIGN KEY (`userId`) REFERENCES `sys_user` (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4;

-- ----------------------------

-- ----------------------------

CREATE TABLE `sys_user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(50) NOT NULL,
  `password` VARCHAR(60) NOT NULL,
  `nickname` VARCHAR(255) DEFAULT NULL,
  `headImgUrl` VARCHAR(255) DEFAULT NULL,
  `telephone` VARCHAR(30) DEFAULT NULL,
  `birthday` DATE DEFAULT NULL,
  `sex` INT(11) DEFAULT '1',
  `status` INT(11) DEFAULT '1',
  `createTime` DATETIME NOT NULL,
  `updateTime` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`) USING BTREE
) ENGINE=INNODB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4;

-- ----------------------------

-- ----------------------------

CREATE TABLE `doctor` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `depId` INT(11) NOT NULL,
  `posId` INT(11) NOT NULL,
  `detail` VARCHAR(255),
  `intro` VARCHAR(255),
  `regCount` INT(11) DEFAULT 0,
  `inqCount` INT(11) DEFAULT 0,
  `userId` INT(11),
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4;

-- ----------------------------

-- ----------------------------

CREATE TABLE `patient` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `identity` VARCHAR(50),
  `token` VARCHAR(50),
  `userId` INT(11),
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4;

-- ----------------------------

-- ----------------------------

CREATE TABLE `department` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `parentId` INT(11) NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  `location` VARCHAR(255),
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb4;

INSERT INTO `department` VALUES ('1', '0', '内科', '门诊楼三楼东区内科中心');
INSERT INTO `department` VALUES ('2', '1', '心血管内科', '');
INSERT INTO `department` VALUES ('3', '1', '呼吸内科', '');
INSERT INTO `department` VALUES ('4', '1', '消化内科', '');
INSERT INTO `department` VALUES ('5', '1', '神经内科', '');
INSERT INTO `department` VALUES ('6', '1', '肾病中心', '');
INSERT INTO `department` VALUES ('7', '1', '肾移植科', '');
INSERT INTO `department` VALUES ('8', '1', '血液内科', '');
INSERT INTO `department` VALUES ('9', '1', '风湿免疫病科', '');
INSERT INTO `department` VALUES ('10', '1', '感染内科', '');
INSERT INTO `department` VALUES ('11', '1', '内分泌科', '');
INSERT INTO `department` VALUES ('12', '1', '呼吸睡眠中心', '');
INSERT INTO `department` VALUES ('13', '1', '老年病科门诊', '');

INSERT INTO `department` VALUES ('14', '0', '外科', '门诊楼一楼南区外科中心');
INSERT INTO `department` VALUES ('15', '14', '普外科', '');
INSERT INTO `department` VALUES ('16', '14', '胸外科', '');
INSERT INTO `department` VALUES ('17', '14', '神经外科', '');
INSERT INTO `department` VALUES ('18', '14', '肝胆外科', '');
INSERT INTO `department` VALUES ('19', '14', '肛肠科', '');
INSERT INTO `department` VALUES ('20', '14', '泌尿外科', '');
INSERT INTO `department` VALUES ('21', '14', '血管外科', '');
INSERT INTO `department` VALUES ('22', '14', '整形外科', '');
INSERT INTO `department` VALUES ('23', '14', '乳腺科', '');
INSERT INTO `department` VALUES ('24', '14', '烧伤科', '');
INSERT INTO `department` VALUES ('25', '14', '心血管外科', '');

INSERT INTO `department` VALUES ('26', '0', '骨科', '门诊楼一楼西区骨科中心');
INSERT INTO `department` VALUES ('27', '26', '关节与骨病外科','');
INSERT INTO `department` VALUES ('28', '26', '脊柱骨科','');
INSERT INTO `department` VALUES ('29', '26', '创伤骨外科','');

INSERT INTO `department` VALUES ('30', '0', '妇产科', '门诊楼二楼西区妇产科中心');
INSERT INTO `department` VALUES ('31', '30', '妇科', '');
INSERT INTO `department` VALUES ('32', '30', '产科门诊', '');
INSERT INTO `department` VALUES ('33', '30', '生殖中心', '');
INSERT INTO `department` VALUES ('34', '30', '胎儿医学科门诊', '');

INSERT INTO `department` VALUES ('35', '0', '儿科', '门诊楼二楼北区儿科中心');
INSERT INTO `department` VALUES ('36', '35', '小儿科', '');
INSERT INTO `department` VALUES ('37', '35', '新生儿科', '');

INSERT INTO `department` VALUES ('38', '0', '中医科', '门诊楼三楼南区中医科中心');
INSERT INTO `department` VALUES ('39', '38', '中医内科', '');
INSERT INTO `department` VALUES ('40', '38', '中医风湿科', '');
INSERT INTO `department` VALUES ('41', '38', '古中医疑难杂症门诊', '');
INSERT INTO `department` VALUES ('42', '38', '中医正骨科', '');
INSERT INTO `department` VALUES ('43', '38', '中医妇科', '');
INSERT INTO `department` VALUES ('44', '38', '中医针灸科', '');
INSERT INTO `department` VALUES ('45', '38', '中医外科', '');
INSERT INTO `department` VALUES ('46', '38', '中医儿科', '');

-- ----------------------------

-- ----------------------------排班表

CREATE TABLE `duty` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `parentId` INT(11) NOT NULL,
  `time` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb4;

INSERT INTO `duty` VALUES ('1','0','2020-03-29 上午');
INSERT INTO `duty` VALUES ('2','1','09:00-09:29');
INSERT INTO `duty` VALUES ('3','1','10:00-10:29');
INSERT INTO `duty` VALUES ('4','0','2020-03-30 下午');
INSERT INTO `duty` VALUES ('5','4','15:00-15:29');
INSERT INTO `duty` VALUES ('6','4','16:00-16:29');
INSERT INTO `duty` VALUES ('7','4','16:30-16:59');

-- ----------------------------

-- ----------------------------医生排班关联表

CREATE TABLE `doctor_duty` (
  `doctorId` INT(11) NOT NULL,
  `dutyId` INT(11) NOT NULL,
  PRIMARY KEY (`doctorId`,`dutyId`),
  KEY `fk_dutyId` (`dutyId`),
  CONSTRAINT `fk_dutyId` FOREIGN KEY (`dutyId`) REFERENCES `duty` (`id`),
  CONSTRAINT `fk_doctorId` FOREIGN KEY (`doctorId`) REFERENCES `doctor` (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4;

INSERT INTO `doctor_duty` VALUES ('4','1');
INSERT INTO `doctor_duty` VALUES ('4','2');
INSERT INTO `doctor_duty` VALUES ('4','3');
INSERT INTO `doctor_duty` VALUES ('4','4');
INSERT INTO `doctor_duty` VALUES ('4','5');
INSERT INTO `doctor_duty` VALUES ('4','6');
INSERT INTO `doctor_duty` VALUES ('4','7');

INSERT INTO `doctor_duty` VALUES ('5','4');
INSERT INTO `doctor_duty` VALUES ('5','5');
INSERT INTO `doctor_duty` VALUES ('5','6');

INSERT INTO `doctor_duty` VALUES ('1','1');
INSERT INTO `doctor_duty` VALUES ('1','2');
INSERT INTO `doctor_duty` VALUES ('1','4');
INSERT INTO `doctor_duty` VALUES ('1','5');

SELECT duty.* FROM doctor_duty dd LEFT JOIN duty ON duty.`id`=dd.`dutyId` WHERE dd.`doctorId`=5;
-- ----------------------------

-- ----------------------------挂号表

CREATE TABLE `register` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `user_id` INT(11) NOT NULL,
  -- 这个user_id应该是patient id而非sys_user id
  `doc_id` INT(11) NOT NULL,
  `dep_id` INT(11) NOT NULL,
  `duty_id` INT(11) NOT NULL,
  `status` INT(11) NOT NULL,
  -- status是状态：未进行/已取消/已完成
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4;

SELECT * FROM register
DROP TABLE register
-- ----------------------------

-- ----------------------------

CREATE TABLE `article` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(50) NOT NULL,
  `description` VARCHAR(255),
  `create_time` DATETIME NOT NULL,
  `update_time` DATETIME NOT NULL,
  `view_count` INT(11) DEFAULT 0,
  `ImgUrl` VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb4;

INSERT INTO `article` VALUES ('1', 'layui 2.0 的一切准备工作似乎都已到位', '发布之弦，一触即发。不枉近百个日日夜夜与之为伴。因小而大，因弱而强。无论它能走多远，抑或如何支撑？至少我曾倾注全心，无怨无悔', '2020-03-03 15:02','2020-03-03 15:04',2,'http://maaarmot.cn-bj.ufileos.com/pic1.png?UCloudPublicKey=9yqlKyZBOWOHv7dx_OKrzRmzbNrBS7bSRBPdj6rE&Signature=%2FGulYN1MPNhxlUfxV%2Bh5qZYAqeY%3D&Expires=1585299407');
INSERT INTO `article` VALUES ('2', '中国人民抗日战争胜利72周年', '常常在想，尽管对这个国家有这样那样的抱怨，但我们的确生在了最好的时代。铭记、感恩所有为中华民族浴血奋战的英雄将士永垂不朽', '2020-03-03 15:02','2020-03-03 15:04',2,'http://maaarmot.cn-bj.ufileos.com/pic2.png?UCloudPublicKey=9yqlKyZBOWOHv7dx_OKrzRmzbNrBS7bSRBPdj6rE&Signature=2wpeBk%2BzrH0LUxY6gM2l8g8JIDk%3D&Expires=1585299420');
INSERT INTO `article` VALUES ('3', '杜甫的思想核心是儒家的仁政思想', '他有致君尧舜上，再使风俗淳的宏伟抱负。个人最爱的名篇有：《登高》《茅屋为秋风所破歌》', '2020-03-08 15:02','2020-03-08 15:04',1,'http://maaarmot.cn-bj.ufileos.com/pic3.jpg?UCloudPublicKey=9yqlKyZBOWOHv7dx_OKrzRmzbNrBS7bSRBPdj6rE&Signature=cgrHw96DYvoZgNRMGiKkQtKWed8%3D&Expires=1585299435');
-- ----------------------------

-- ----------------------------
SELECT * FROM doctor
SELECT * FROM sys_user
INSERT INTO `sys_user` VALUES ('1','肥圆管理','$2a$10$Ww8SlODnhh.5iBSIWRJzhOyxcIj8nnfrpy5wXr8PcWpsfZl11w/9m','黄金宝',NULL,'15766543324','1997-09-12','1','1','2020-03-01 02:16:36','2020-03-03 15:02');
INSERT INTO `sys_user` VALUES ('2','圆润医生','$2a$10$Zgixbe609gvFwxVUGjEbZuva23bzlJFhNvSgibXIHXoh29vdsH4Xu','张翠花',NULL,'18977654440','1996-07-23','2','1','2020-03-01 02:17:03','2020-03-03 16:23');
INSERT INTO `sys_user` VALUES ('3','普通病号','123456','王小明',NULL,'15700743324','1997-07-02','1','1','2020-03-16 08:16:36','2020-03-16 13:02');

INSERT INTO `sys_user` VALUES ('4','定珍医生','$2a$10$Zgixbe609gvFwxVUGjEbZuva23bzlJFhNvSgibXIHXoh29vdsH4Xu','谭定珍',NULL,'18177654440','1996-07-23','2','1','2020-03-01 02:17:03','2020-03-03 16:23');
INSERT INTO `sys_user` VALUES ('5','天博医生','$2a$10$Zgixbe609gvFwxVUGjEbZuva23bzlJFhNvSgibXIHXoh29vdsH4Xu','杨天博',NULL,'13177654447','1996-07-23','2','1','2020-03-01 02:17:03','2020-03-03 16:23');
INSERT INTO `sys_user` VALUES ('6','郁婷医生','$2a$10$Zgixbe609gvFwxVUGjEbZuva23bzlJFhNvSgibXIHXoh29vdsH4Xu','杨郁婷',NULL,'13177654447','1996-07-23','2','1','2020-03-01 02:17:03','2020-03-03 16:23');
INSERT INTO `sys_user` VALUES ('7','文瑜医生','$2a$10$Zgixbe609gvFwxVUGjEbZuva23bzlJFhNvSgibXIHXoh29vdsH4Xu','张文瑜',NULL,'13177654447','1996-07-23','2','1','2020-03-01 02:17:03','2020-03-03 16:23');

INSERT INTO `doctor` VALUES ('1',2,1,'...','擅长各种创伤、躯干四肢骨折、骨关节损伤、手外伤、脊柱损伤的诊治，严重复合伤的救治，体表畸形的整复...从事外科临床工作近20年。历年来参加中华医学会主办的全国学术交流会议9次，发表医学论文30次',99,0,2);
INSERT INTO `doctor` VALUES ('2',3,1,'...','脊柱损伤的诊治，严重复合伤的救治，体表复合伤的救治，体表畸形的整复...从事外科临床工作近20损伤、手外伤、脊柱损伤的诊治，床工作近20年发表医学论文30次的全国学的整复...从事外科临床工作',39,34,4);
INSERT INTO `doctor` VALUES ('3',4,1,'...','体表复合伤的救治，体工作近20损伤、手外伤、复...从事外科临床工作近20损伤、伤的诊治，床工作近20年发表床工作近20年发表医学论文30次的全国学的整复...从事外科临床工作',79,44,5);
INSERT INTO `doctor` VALUES ('4',2,1,'...','认真钻研业务，精益求精，在神经内科疾病规范化治疗的前提下，根据自己多年来的临床经验，采取个体化治疗，因人施治，疗效显著，给许多病人带来了福音。',22,34,6);
INSERT INTO `doctor` VALUES ('5',2,1,'...','曾先后到河南省人民医院、广州军区总医院等地进修深造，多次到北京、西安、济南、郑州、广州等地参加学术活动，获省科技成果奖三等奖。兢兢业业，一丝不苟。',54,50,7);

INSERT INTO `patient` VALUES ('1','445288777909354698','5bb5a900-5747-42a4-a0f1-c7eab8cbe3ed',3);
INSERT INTO `sys_role_user` VALUES (1,1);
INSERT INTO `sys_role_user` VALUES (2,2);
INSERT INTO `sys_role_user` VALUES (3,3);

INSERT INTO `sys_role_user` VALUES (4,2);
INSERT INTO `sys_role_user` VALUES (5,2);
INSERT INTO `sys_role_user` VALUES (6,2);
INSERT INTO `sys_role_user` VALUES (7,2);