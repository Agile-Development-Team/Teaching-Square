/*
 Navicat Premium Data Transfer

 Source Server         : adweb_project
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : ts

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 19/04/2022 14:56:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for _user
-- ----------------------------
DROP TABLE IF EXISTS `_user`;
CREATE TABLE `_user`  (
  `number` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `identity` int(11) NOT NULL,
  PRIMARY KEY (`number`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of _user
-- ----------------------------
INSERT INTO `_user` VALUES ('LS001', '123', 2);
INSERT INTO `_user` VALUES ('LS0010', '17643grtw', 2);
INSERT INTO `_user` VALUES ('LS002', '12345', 2);
INSERT INTO `_user` VALUES ('LS003', '8795219', 2);
INSERT INTO `_user` VALUES ('LS004', '7638276', 2);
INSERT INTO `_user` VALUES ('LS005', '1872849', 2);
INSERT INTO `_user` VALUES ('LS006', '16724638', 2);
INSERT INTO `_user` VALUES ('LS007', '5268abcd', 2);
INSERT INTO `_user` VALUES ('LS008', '63746zxcv', 2);
INSERT INTO `_user` VALUES ('LS009', '17636gutf', 2);
INSERT INTO `_user` VALUES ('MF21320000', '123', 1);
INSERT INTO `_user` VALUES ('MF21320001', '123', 1);
INSERT INTO `_user` VALUES ('MF21320100', '12345678', 1);
INSERT INTO `_user` VALUES ('MF21320110', '12345678ab', 1);
INSERT INTO `_user` VALUES ('MF21320119', '12345678ef', 1);
INSERT INTO `_user` VALUES ('MF21320120', '12345678cd', 1);
INSERT INTO `_user` VALUES ('MF21320124', '12345678gh', 1);
INSERT INTO `_user` VALUES ('MF21320154', '765ngtr', 1);
INSERT INTO `_user` VALUES ('MF21320178', '1234567', 1);
INSERT INTO `_user` VALUES ('MF21320250', '123456', 1);
INSERT INTO `_user` VALUES ('MF21320911', '12345678xy', 1);

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `course_id` int(11) NOT NULL AUTO_INCREMENT,
  `course_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`course_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, '敏捷软件开发', 'mjrjkf');
INSERT INTO `course` VALUES (2, '机器学习入门', 'graduate21');
INSERT INTO `course` VALUES (3, '算法导论', 'graduate21');
INSERT INTO `course` VALUES (4, '数据结构与算法', 'graduate21');
INSERT INTO `course` VALUES (5, '高级算法', 'graduate21');
INSERT INTO `course` VALUES (6, '编译原理', 'graduate21');
INSERT INTO `course` VALUES (7, '高级软件设计', 'graduate21');
INSERT INTO `course` VALUES (8, '软件工程管理', 'graduate21');
INSERT INTO `course` VALUES (9, '软件需求工程', 'graduate21');
INSERT INTO `course` VALUES (10, '大数据理论与实践', 'graduate21');

-- ----------------------------
-- Table structure for homework
-- ----------------------------
DROP TABLE IF EXISTS `homework`;
CREATE TABLE `homework`  (
  `homework_id` int(11) NOT NULL,
  `course_id` int(11) NOT NULL,
  `homework_title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `deadline` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `percentage` int(11) NOT NULL,
  PRIMARY KEY (`course_id`, `homework_id`) USING BTREE,
  INDEX `homework_id`(`homework_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of homework
-- ----------------------------
INSERT INTO `homework` VALUES (1, 1, '《人月神话》读书报告', '阅读《人月神话》并完成一篇1000-3000字的读书报告，不得抄袭', '2022-04-30 00:00:00', 10);
INSERT INTO `homework` VALUES (2, 1, '《人件》读书报告', '阅读《人件》并完成一篇1000-3000字的读书报告，不得抄袭', '2022-04-30 00:00:00', 10);
INSERT INTO `homework` VALUES (3, 1, '《极限编程》读书报告', '阅读《极限编程》并完成一篇1000-3000字的读书报告，不得抄袭', '2022-04-30 00:00:00', 10);
INSERT INTO `homework` VALUES (4, 1, '《Clean Agile》读书报告', '阅读《Clean Agile》并完成一篇1000-3000字的读书报告，不得抄袭', '2022-04-30 00:00:00', 10);
INSERT INTO `homework` VALUES (5, 1, '《教堂与大市集》读书报告', '阅读《教堂与大市集》并完成一篇1000-3000字的读书报告，不得抄袭', '2022-04-30 00:00:00', 10);
INSERT INTO `homework` VALUES (1, 5, '算法编程练习', '完成练习一，排序与分治', '2022-04-30 00:00:00', 10);
INSERT INTO `homework` VALUES (2, 5, '算法编程练习', '完成练习二，贪心算法', '2022-04-30 00:00:00', 10);
INSERT INTO `homework` VALUES (3, 5, '算法编程练习', '完成练习三，递归与迭代', '2022-04-30 00:00:00', 10);
INSERT INTO `homework` VALUES (4, 5, '算法编程练习', '完成练习四，动态规划', '2022-04-30 00:00:00', 10);
INSERT INTO `homework` VALUES (5, 5, '算法编程练习', '完成练习五，二叉树遍历', '2022-04-30 00:00:00', 10);

-- ----------------------------
-- Table structure for resource
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource`  (
  `course_id` int(11) NOT NULL,
  `ppt_id` int(11) NOT NULL,
  `ppt_title` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `published_time` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `link` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`course_id`, `ppt_id`) USING BTREE,
  CONSTRAINT `course_id` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of resource
-- ----------------------------
INSERT INTO `resource` VALUES (1, 1, 'ppt_test', '2022-01-09', 'link*');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `number` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `college` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `major` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `e_mail` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `tel` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`number`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('MF21320000', '张三', '软件学院', '软件工程', 'zhangsan@smail.nju.edu.cn', '13815877688');
INSERT INTO `student` VALUES ('MF21320001', '张三丰', '软件学院', '软件工程', 'zhangsanfeng@smail.nju.edu.cn', '19807685637');
INSERT INTO `student` VALUES ('MF21320100', '赵徽柔', '软件学院', '软件工程', 'huirouzhao@smail.nju.edu.cn', '18877665639');
INSERT INTO `student` VALUES ('MF21320110', '肖鹤云', '软件学院', '软件工程', 'heyunxiao@smail.nju.edu.cn', '18877993627');
INSERT INTO `student` VALUES ('MF21320119', '玄彬', '软件学院', '软件工程', 'xuanbing@smail.nju.edu.cn', '17766542906');
INSERT INTO `student` VALUES ('MF21320120', '李诗情', '软件学院', '软件工程', 'shiqingli@smail.nju.edu.cn', '18877559027');
INSERT INTO `student` VALUES ('MF21320124', '孙艺珍', '软件学院', '软件工程', 'yizhensun@smail.nju.edu.cn', '17766537829');
INSERT INTO `student` VALUES ('MF21320154', '张怀吉', '软件学院', '软件工程', 'huaijizhang@smail.nju.edu.cn', '18877669078');
INSERT INTO `student` VALUES ('MF21320178', '马化腾', '软件学院', '软件工程', 'huatengma@smail.nju.edu.cn', '18877665589');
INSERT INTO `student` VALUES ('MF21320250', '马云', '软件学院', '软件工程', 'jackma@smail.nju.edu.cn', '12345678911');
INSERT INTO `student` VALUES ('MF21320911', '张若昀', '软件学院', '软件工程', 'ruoyunzhang@smail.nju.edu.cn', '19908783678');

-- ----------------------------
-- Table structure for student_course
-- ----------------------------
DROP TABLE IF EXISTS `student_course`;
CREATE TABLE `student_course`  (
  `number` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `course_id` int(11) NOT NULL,
  PRIMARY KEY (`number`, `course_id`) USING BTREE,
  INDEX `student_course_ibfk_2`(`course_id`) USING BTREE,
  CONSTRAINT `student_course_ibfk_1` FOREIGN KEY (`number`) REFERENCES `student` (`number`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `student_course_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student_course
-- ----------------------------
INSERT INTO `student_course` VALUES ('MF21320000', 1);
INSERT INTO `student_course` VALUES ('MF21320001', 1);
INSERT INTO `student_course` VALUES ('MF21320100', 1);
INSERT INTO `student_course` VALUES ('MF21320110', 1);
INSERT INTO `student_course` VALUES ('MF21320119', 1);
INSERT INTO `student_course` VALUES ('MF21320120', 1);
INSERT INTO `student_course` VALUES ('MF21320124', 1);
INSERT INTO `student_course` VALUES ('MF21320154', 1);
INSERT INTO `student_course` VALUES ('MF21320178', 1);
INSERT INTO `student_course` VALUES ('MF21320250', 1);
INSERT INTO `student_course` VALUES ('MF21320911', 1);
INSERT INTO `student_course` VALUES ('MF21320000', 2);
INSERT INTO `student_course` VALUES ('MF21320001', 2);
INSERT INTO `student_course` VALUES ('MF21320100', 2);
INSERT INTO `student_course` VALUES ('MF21320110', 2);
INSERT INTO `student_course` VALUES ('MF21320119', 2);
INSERT INTO `student_course` VALUES ('MF21320120', 2);
INSERT INTO `student_course` VALUES ('MF21320124', 2);
INSERT INTO `student_course` VALUES ('MF21320154', 2);
INSERT INTO `student_course` VALUES ('MF21320178', 2);
INSERT INTO `student_course` VALUES ('MF21320250', 2);
INSERT INTO `student_course` VALUES ('MF21320911', 2);
INSERT INTO `student_course` VALUES ('MF21320000', 3);
INSERT INTO `student_course` VALUES ('MF21320001', 3);
INSERT INTO `student_course` VALUES ('MF21320100', 3);
INSERT INTO `student_course` VALUES ('MF21320110', 3);
INSERT INTO `student_course` VALUES ('MF21320119', 3);
INSERT INTO `student_course` VALUES ('MF21320120', 3);
INSERT INTO `student_course` VALUES ('MF21320124', 3);
INSERT INTO `student_course` VALUES ('MF21320154', 3);
INSERT INTO `student_course` VALUES ('MF21320178', 3);
INSERT INTO `student_course` VALUES ('MF21320250', 3);
INSERT INTO `student_course` VALUES ('MF21320911', 3);
INSERT INTO `student_course` VALUES ('MF21320000', 4);
INSERT INTO `student_course` VALUES ('MF21320001', 4);
INSERT INTO `student_course` VALUES ('MF21320100', 4);
INSERT INTO `student_course` VALUES ('MF21320110', 4);
INSERT INTO `student_course` VALUES ('MF21320119', 4);
INSERT INTO `student_course` VALUES ('MF21320120', 4);
INSERT INTO `student_course` VALUES ('MF21320124', 4);
INSERT INTO `student_course` VALUES ('MF21320154', 4);
INSERT INTO `student_course` VALUES ('MF21320178', 4);
INSERT INTO `student_course` VALUES ('MF21320250', 4);
INSERT INTO `student_course` VALUES ('MF21320911', 4);
INSERT INTO `student_course` VALUES ('MF21320000', 5);
INSERT INTO `student_course` VALUES ('MF21320001', 5);
INSERT INTO `student_course` VALUES ('MF21320100', 5);
INSERT INTO `student_course` VALUES ('MF21320110', 5);
INSERT INTO `student_course` VALUES ('MF21320119', 5);
INSERT INTO `student_course` VALUES ('MF21320120', 5);
INSERT INTO `student_course` VALUES ('MF21320124', 5);
INSERT INTO `student_course` VALUES ('MF21320154', 5);
INSERT INTO `student_course` VALUES ('MF21320178', 5);
INSERT INTO `student_course` VALUES ('MF21320250', 5);
INSERT INTO `student_course` VALUES ('MF21320911', 5);

-- ----------------------------
-- Table structure for student_homework
-- ----------------------------
DROP TABLE IF EXISTS `student_homework`;
CREATE TABLE `student_homework`  (
  `number` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `course_id` int(11) NOT NULL,
  `homework_id` int(11) NOT NULL,
  `link` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `grade` double NOT NULL,
  PRIMARY KEY (`number`, `course_id`, `homework_id`) USING BTREE,
  INDEX `course_id2`(`course_id`) USING BTREE,
  INDEX `homework_id2`(`homework_id`) USING BTREE,
  CONSTRAINT `course_id2` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `homework_id2` FOREIGN KEY (`homework_id`) REFERENCES `homework` (`homework_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `number_2` FOREIGN KEY (`number`) REFERENCES `student` (`number`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student_homework
-- ----------------------------
INSERT INTO `student_homework` VALUES ('MF21320001', 1, 1, 'link*', 0);

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `number` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `college` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `e_mail` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `tel` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`number`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('LS001', '李四', '软件学院', 'lisi@nju.edu.cn', '88888888');
INSERT INTO `teacher` VALUES ('LS0010', '杨立铭', '软件学院', 'limingyang@nju.edu.cn', '15183208956');
INSERT INTO `teacher` VALUES ('LS002', '李四光', '地质学院', 'lisiguang@nju.edu.cn', '18702567888');
INSERT INTO `teacher` VALUES ('LS003', '图灵', '软件学院', 'tuling@nju.edu.cn', '18702457830');
INSERT INTO `teacher` VALUES ('LS004', '姚期智', '软件学院', 'qizhiyao@nju.edu.cn', '13378209857');
INSERT INTO `teacher` VALUES ('LS005', '吴恩达', '软件学院', 'endawu@nju.edu.cn', '17682359014');
INSERT INTO `teacher` VALUES ('LS006', '周志华', '软件学院', 'zhihuazhou@nju.edu.cn', '19978782490');
INSERT INTO `teacher` VALUES ('LS007', '潘云鹤', '软件学院', 'yunhepan@nju.edu.cn', '17856283098');
INSERT INTO `teacher` VALUES ('LS008', '李未', '软件学院', 'weili@nju.edu.cn', '17689001234');
INSERT INTO `teacher` VALUES ('LS009', '夏培肃', '软件学院', 'peisuxia@nju.edu.cn', '19978780000');

-- ----------------------------
-- Table structure for teacher_course
-- ----------------------------
DROP TABLE IF EXISTS `teacher_course`;
CREATE TABLE `teacher_course`  (
  `number` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `course_id` int(11) NOT NULL,
  PRIMARY KEY (`number`, `course_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher_course
-- ----------------------------
INSERT INTO `teacher_course` VALUES ('LS001', 1);
INSERT INTO `teacher_course` VALUES ('LS004', 2);
INSERT INTO `teacher_course` VALUES ('LS004', 3);
INSERT INTO `teacher_course` VALUES ('LS004', 4);
INSERT INTO `teacher_course` VALUES ('LS004', 5);
INSERT INTO `teacher_course` VALUES ('LS004', 6);
INSERT INTO `teacher_course` VALUES ('LS006', 7);
INSERT INTO `teacher_course` VALUES ('LS006', 8);
INSERT INTO `teacher_course` VALUES ('LS006', 9);
INSERT INTO `teacher_course` VALUES ('LS006', 10);

SET FOREIGN_KEY_CHECKS = 1;
