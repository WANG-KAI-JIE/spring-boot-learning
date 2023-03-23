/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80032
 Source Host           : localhost:3306
 Source Schema         : spring_boot_data

 Target Server Type    : MySQL
 Target Server Version : 80032
 File Encoding         : 65001

 Date: 23/03/2023 08:29:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_article
-- ----------------------------
DROP TABLE IF EXISTS `t_article`;
CREATE TABLE `t_article` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '文章id',
  `title` varchar(200) DEFAULT NULL COMMENT '文章标题',
  `content` longtext COMMENT '文章内容',
  `cover` varchar(255) DEFAULT NULL COMMENT '文章封面\n',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of t_article
-- ----------------------------
BEGIN;
INSERT INTO `t_article` (`id`, `title`, `content`, `cover`) VALUES (1, 'Spring Boot基础入门', '从入门到精通讲解...', 'https://fatcat666.oss-cn-nanjing.aliyuncs.com/image/202303201643820.pn');
INSERT INTO `t_article` (`id`, `title`, `content`, `cover`) VALUES (2, 'Spring Cloud基础入门', '从入门到精通讲解...', 'https://fatcat666.oss-cn-nanjing.aliyuncs.com/image/202303201645459.png');
INSERT INTO `t_article` (`id`, `title`, `content`, `cover`) VALUES (3, '概率论与数理统计', '概率统计是高等院校理工类、经管类的重要课程之一。在考研数学中的比重大约占22%左右（数一、数三）。包括概率论的基本概念、随机变量及其概率分布、数字特征、大数定律与中心极限定理、统计量及其概率分布、参数估计和假设检验、回归分析、方差分析、马尔科夫链等内容。', 'https://fatcat666.oss-cn-nanjing.aliyuncs.com/image/202303201905036.png');
INSERT INTO `t_article` (`id`, `title`, `content`, `cover`) VALUES (4, '马克思主义基本原理', '马克思主义基本原理是指马克思主义政治经济学、辩证唯物主义和历史唯物主义以及科学社会主义。它是马克思主义科学体系的基本理论、基本范畴，是其立场、观点和方法的理论表达。', 'https://fatcat666.oss-cn-nanjing.aliyuncs.com/image/202303201907379.png');
COMMIT;

-- ----------------------------
-- Table structure for t_clazz
-- ----------------------------
DROP TABLE IF EXISTS `t_clazz`;
CREATE TABLE `t_clazz` (
  `clazz_id` int NOT NULL AUTO_INCREMENT COMMENT '班级id',
  `clazz_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '班级名称',
  `teacher_id` int NOT NULL COMMENT '班级管理⽼师的id',
  PRIMARY KEY (`clazz_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_clazz
-- ----------------------------
BEGIN;
INSERT INTO `t_clazz` (`clazz_id`, `clazz_name`, `teacher_id`) VALUES (1, '后端开发班', 1);
INSERT INTO `t_clazz` (`clazz_id`, `clazz_name`, `teacher_id`) VALUES (2, '前端开发班', 2);
COMMIT;

-- ----------------------------
-- Table structure for t_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '评论id',
  `content` longtext COMMENT '评论内容',
  `author` varchar(200) DEFAULT NULL COMMENT '评论作者',
  `a_id` int DEFAULT NULL COMMENT '关联的文章id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of t_comment
-- ----------------------------
BEGIN;
INSERT INTO `t_comment` (`id`, `content`, `author`, `a_id`) VALUES (1, '很全、很详细', '一只蜗牛', 1);
INSERT INTO `t_comment` (`id`, `content`, `author`, `a_id`) VALUES (2, '赞一个', 'tom', 1);
INSERT INTO `t_comment` (`id`, `content`, `author`, `a_id`) VALUES (3, '很详细', 'kitty', 1);
INSERT INTO `t_comment` (`id`, `content`, `author`, `a_id`) VALUES (4, '很好，非常详细', '张三', 1);
INSERT INTO `t_comment` (`id`, `content`, `author`, `a_id`) VALUES (5, '很不错', '张杨', 2);
INSERT INTO `t_comment` (`id`, `content`, `author`, `a_id`) VALUES (6, '内容丰富', '肥猫猫', 3);
INSERT INTO `t_comment` (`id`, `content`, `author`, `a_id`) VALUES (7, '可以，不错的', 'Jerry', 4);
COMMIT;

-- ----------------------------
-- Table structure for t_course
-- ----------------------------
DROP TABLE IF EXISTS `t_course`;
CREATE TABLE `t_course` (
  `course_id` int NOT NULL AUTO_INCREMENT COMMENT '课程id',
  `course_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '课程名称',
  PRIMARY KEY (`course_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=20003 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_course
-- ----------------------------
BEGIN;
INSERT INTO `t_course` (`course_id`, `course_name`) VALUES (20001, '后端⼯程化开发');
INSERT INTO `t_course` (`course_id`, `course_name`) VALUES (20002, '前端⼯程化开发');
COMMIT;

-- ----------------------------
-- Table structure for t_course_student
-- ----------------------------
DROP TABLE IF EXISTS `t_course_student`;
CREATE TABLE `t_course_student` (
  `id` int NOT NULL,
  `course_id` int DEFAULT NULL COMMENT '课程id',
  `student_id` int DEFAULT NULL COMMENT '学生id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_course_student
-- ----------------------------
BEGIN;
INSERT INTO `t_course_student` (`id`, `course_id`, `student_id`) VALUES (1, 20001, 1001);
INSERT INTO `t_course_student` (`id`, `course_id`, `student_id`) VALUES (2, 20001, 1002);
INSERT INTO `t_course_student` (`id`, `course_id`, `student_id`) VALUES (3, 20001, 1003);
INSERT INTO `t_course_student` (`id`, `course_id`, `student_id`) VALUES (4, 20001, 1004);
INSERT INTO `t_course_student` (`id`, `course_id`, `student_id`) VALUES (5, 20001, 1005);
INSERT INTO `t_course_student` (`id`, `course_id`, `student_id`) VALUES (6, 20001, 1006);
INSERT INTO `t_course_student` (`id`, `course_id`, `student_id`) VALUES (7, 20001, 1007);
INSERT INTO `t_course_student` (`id`, `course_id`, `student_id`) VALUES (8, 20001, 1008);
INSERT INTO `t_course_student` (`id`, `course_id`, `student_id`) VALUES (9, 20001, 1009);
INSERT INTO `t_course_student` (`id`, `course_id`, `student_id`) VALUES (10, 20002, 1001);
INSERT INTO `t_course_student` (`id`, `course_id`, `student_id`) VALUES (11, 20002, 1002);
INSERT INTO `t_course_student` (`id`, `course_id`, `student_id`) VALUES (12, 20002, 1003);
INSERT INTO `t_course_student` (`id`, `course_id`, `student_id`) VALUES (13, 20002, 1004);
INSERT INTO `t_course_student` (`id`, `course_id`, `student_id`) VALUES (14, 20002, 1005);
INSERT INTO `t_course_student` (`id`, `course_id`, `student_id`) VALUES (15, 20002, 1006);
INSERT INTO `t_course_student` (`id`, `course_id`, `student_id`) VALUES (16, 20002, 1007);
INSERT INTO `t_course_student` (`id`, `course_id`, `student_id`) VALUES (17, 20002, 1008);
COMMIT;

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `student_id` int NOT NULL AUTO_INCREMENT COMMENT '学⽣id',
  `clazz_id` int NOT NULL COMMENT '学⽣所属班级的id',
  `student_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '学⽣姓名',
  `hometown` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '学⽣籍贯',
  `birthday` date DEFAULT NULL COMMENT '出⽣⽇期',
  PRIMARY KEY (`student_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3108 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_student
-- ----------------------------
BEGIN;
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (1001, 2, '新名字', '江苏苏州', '2000-01-18');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (1002, 1, '李智康', '江苏⽆锡', '2000-02-18');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (1003, 1, '张智康', '江苏常州', '2000-03-18');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (1004, 1, '王智康', '江苏南京', '2000-04-18');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (1005, 1, '孙志康', '江苏徐州', '2001-05-18');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (1006, 2, '周志康', '江苏泰州', '2001-06-18');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (1007, 2, '郭志康', '江苏扬州', '2001-07-18');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (1008, 2, '陈志康', '江苏盐城', '2001-08-18');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (2000, 1, '测试20条0', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (2001, 1, '测试20条1', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (2002, 1, '测试20条2', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (2003, 1, '测试20条3', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (2004, 1, '测试20条4', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (2005, 1, '测试20条5', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (2006, 1, '测试20条6', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (2007, 1, '测试20条7', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (2008, 1, '测试20条8', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (2009, 1, '测试20条9', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (2010, 1, '测试20条10', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (2011, 1, '测试20条11', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (2012, 1, '测试20条12', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (2013, 1, '测试20条13', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (2014, 1, '测试20条14', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (2015, 1, '测试20条15', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (2016, 1, '测试20条16', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (2017, 1, '测试20条17', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (2018, 1, '测试20条18', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (2019, 1, '测试20条19', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3004, 1, '新名字4', '苏州', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3005, 1, '新名字5', '苏州', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3006, 1, '新名字6', '苏州', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3007, 1, '新名字7', '苏州', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3008, 1, '新名字8', '苏州', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3009, 1, '新名字9', '苏州', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3010, 1, '新名字10', '苏州', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3011, 1, '新名字11', '苏州', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3012, 1, '新名字12', '苏州', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3013, 1, '新名字13', '苏州', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3014, 1, '新名字14', '苏州', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3015, 1, '新名字15', '苏州', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3016, 1, '新名字16', '苏州', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3017, 1, '新名字17', '苏州', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3018, 1, '新名字18', '苏州', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3019, 1, '新名字19', '苏州', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3020, 1, '新名字20', '苏州', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3021, 1, '新名字21', '苏州', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3022, 1, '新名字22', '苏州', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3023, 1, '新名字23', '苏州', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3024, 1, '新名字24', '苏州', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3025, 1, '新名字25', '苏州', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3026, 1, '新名字26', '苏州', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3027, 1, '新名字27', '苏州', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3028, 1, '新名字28', '苏州', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3029, 1, '新名字29', '苏州', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3030, 1, '新名字30', '苏州', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3031, 1, '新名字31', '苏州', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3032, 1, '新名字32', '苏州', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3033, 1, '新名字33', '苏州', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3034, 1, '新名字34', '苏州', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3035, 1, '新名字35', '苏州', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3036, 1, '新名字36', '苏州', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3037, 1, '新名字37', '苏州', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3038, 1, '新名字38', '苏州', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3039, 1, '新名字39', '苏州', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3040, 1, '新名字40', '苏州', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3041, 1, '新名字41', '苏州', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3042, 1, '新名字42', '苏州', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3043, 1, '新名字43', '苏州', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3044, 1, '新名字44', '苏州', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3045, 1, '新名字45', '苏州', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3046, 1, '新名字46', '苏州', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3047, 1, '新名字47', '苏州', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3048, 1, '新名字48', '苏州', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3049, 1, '新名字49', '苏州', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3050, 1, '测试学生50', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3051, 1, '测试学生51', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3052, 1, '测试学生52', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3053, 1, '测试学生53', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3054, 1, '测试学生54', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3055, 1, '测试学生55', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3056, 1, '测试学生56', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3057, 1, '测试学生57', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3058, 1, '测试学生58', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3059, 1, '测试学生59', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3060, 1, '测试学生60', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3061, 1, '测试学生61', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3062, 1, '测试学生62', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3063, 1, '测试学生63', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3064, 1, '测试学生64', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3065, 1, '测试学生65', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3066, 1, '测试学生66', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3067, 1, '测试学生67', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3068, 1, '测试学生68', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3069, 1, '测试学生69', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3070, 1, '测试学生70', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3071, 1, '测试学生71', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3072, 1, '测试学生72', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3073, 1, '测试学生73', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3074, 1, '测试学生74', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3075, 1, '测试学生75', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3076, 1, '测试学生76', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3077, 1, '测试学生77', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3078, 1, '测试学生78', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3079, 1, '测试学生79', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3080, 1, '测试学生80', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3081, 1, '测试学生81', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3082, 1, '测试学生82', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3083, 1, '测试学生83', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3084, 1, '测试学生84', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3085, 1, '测试学生85', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3086, 1, '测试学生86', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3087, 1, '测试学生87', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3088, 1, '测试学生88', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3089, 1, '测试学生89', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3090, 1, '测试学生90', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3091, 1, '测试学生91', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3092, 1, '测试学生92', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3093, 1, '测试学生93', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3094, 1, '测试学生94', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3095, 1, '测试学生95', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3096, 1, '测试学生96', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3098, 2, '修改学生', '南京', NULL);
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3099, 1, '测试学生99', '南京', '2003-10-11');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3100, 6, '肥猫猫', '南通', NULL);
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3101, 6, '哦哟哟', '南通', NULL);
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3103, 6, '哦哟哟', '南通', NULL);
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3104, 6, '哦哟哟', '南通', '2023-03-08');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3105, 1, '黎明', '南京', '2000-10-10');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3106, 1, '黎明', '南京', '2000-10-10');
INSERT INTO `t_student` (`student_id`, `clazz_id`, `student_name`, `hometown`, `birthday`) VALUES (3107, 1, '黎明', '南京', '2000-10-10');
COMMIT;

-- ----------------------------
-- Table structure for t_teacher
-- ----------------------------
DROP TABLE IF EXISTS `t_teacher`;
CREATE TABLE `t_teacher` (
  `teacher_id` int NOT NULL AUTO_INCREMENT COMMENT '教师id',
  `teacher_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '教师姓名',
  `clazz_id` int NOT NULL COMMENT '教师管理的班级id',
  PRIMARY KEY (`teacher_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of t_teacher
-- ----------------------------
BEGIN;
INSERT INTO `t_teacher` (`teacher_id`, `teacher_name`, `clazz_id`) VALUES (1, '许⽼师', 1);
INSERT INTO `t_teacher` (`teacher_id`, `teacher_name`, `clazz_id`) VALUES (2, '张⽼师', 2);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
