CREATE DATABASE  IF NOT EXISTS `education` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `education`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: education
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `adrs_id` int(11) NOT NULL AUTO_INCREMENT,
  `adrs_day` int(11) NOT NULL,
  `adrs_week` int(11) NOT NULL,
  `adrs_part` varchar(45) NOT NULL,
  `adrs_site` varchar(45) NOT NULL,
  `adrs_week2` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`adrs_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,1,1,'1-2','逸夫楼南405','12'),(2,1,1,'3-4','逸夫楼南201','14'),(3,2,1,'7-8','一教北512','10'),(4,1,1,'1-2','三教102','14'),(5,3,1,'7-8','三教102','13'),(6,2,1,'3-4','九教302','12'),(7,4,1,'5-6','三教102','14'),(11,5,1,'1-2','七教402','12'),(12,7,1,'3-4','三教312','11'),(13,6,1,'7-8','七教408','14');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clazz`
--

DROP TABLE IF EXISTS `clazz`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clazz` (
  `clas_id` int(11) NOT NULL AUTO_INCREMENT,
  `clas_name` varchar(45) NOT NULL,
  `clas_period` int(11) NOT NULL,
  `majo_id` int(11) NOT NULL,
  PRIMARY KEY (`clas_id`),
  KEY `major_id_idx` (`majo_id`),
  CONSTRAINT `cla_major` FOREIGN KEY (`majo_id`) REFERENCES `major` (`majo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clazz`
--

LOCK TABLES `clazz` WRITE;
/*!40000 ALTER TABLE `clazz` DISABLE KEYS */;
INSERT INTO `clazz` VALUES (7,'一班',2015,17),(8,'二班',2015,17),(9,'一班',2016,17),(10,'一班',2015,18),(11,'二班',2015,18),(12,'三班',2015,18);
/*!40000 ALTER TABLE `clazz` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `college`
--

DROP TABLE IF EXISTS `college`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `college` (
  `col_id` int(11) NOT NULL AUTO_INCREMENT,
  `col_name` varchar(45) NOT NULL,
  `col_president` varchar(45) NOT NULL,
  `col_phone` char(11) NOT NULL,
  PRIMARY KEY (`col_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `college`
--

LOCK TABLES `college` WRITE;
/*!40000 ALTER TABLE `college` DISABLE KEYS */;
INSERT INTO `college` VALUES (13,'计算机与信息工程学院','王敦','15785632158'),(14,'林学院','李茂','15362584562'),(15,'商学院','熊志','18956243591'),(16,'体育学院','张无忌','17835422695'),(17,'旅游学院','刘能','15325633562'),(18,'外国语学院','李孔德','15454251235'),(19,'材料科学与工程学院','李二妹','17856958635'),(20,'风景园林学院','王大宝','15963544820'),(21,'马克思学院','刘小红','13025862485'),(22,'理学院','李小绿','13253689548'),(23,'机电工程学院','王大黑','15836548952'),(24,'家具与艺术设计学院','王紫','15863575924');
/*!40000 ALTER TABLE `college` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course` (
  `cour_id` int(11) NOT NULL AUTO_INCREMENT,
  `cour_name` varchar(45) NOT NULL,
  `cour_nature` varchar(45) NOT NULL,
  `cour_credit` int(11) NOT NULL,
  `cour_period` int(11) DEFAULT NULL,
  `addr_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`cour_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (10,'高等数学（上）','必修',3,45,1),(11,'c程序设计','必修',4,53,2),(12,'心理健康教育','必修',2,30,3),(13,'马克思一生','选修',1,15,4),(14,'专业英语','必修',3,15,5),(15,'信息与编码','必修',3,15,6),(16,'WEB开发技术','必修',2,20,7),(17,'毛泽东思想','选修',1,15,8);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grade`
--

DROP TABLE IF EXISTS `grade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grade` (
  `gra_id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` int(11) NOT NULL,
  `tea_id` int(11) NOT NULL,
  `gra_score` int(11) NOT NULL,
  `gra_point` int(11) NOT NULL,
  `gra_judge` varchar(10) NOT NULL,
  PRIMARY KEY (`gra_id`),
  KEY `table1_stu_idx` (`stu_id`),
  KEY `table1_tes_idx` (`tea_id`),
  CONSTRAINT `table1_stu` FOREIGN KEY (`stu_id`) REFERENCES `student` (`stu_id`),
  CONSTRAINT `table1_tea` FOREIGN KEY (`tea_id`) REFERENCES `teaching` (`tea_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grade`
--

LOCK TABLES `grade` WRITE;
/*!40000 ALTER TABLE `grade` DISABLE KEYS */;
INSERT INTO `grade` VALUES (1,20153855,1,85,3,'过'),(2,20153855,2,59,0,'没过'),(3,20153855,2,75,0,'重修过'),(4,20153856,1,92,4,'过'),(5,20153856,2,83,3,'过'),(6,20153856,3,71,2,'过'),(7,20153856,4,91,4,'过'),(8,20153856,5,63,1,'过'),(9,20153855,3,86,3,'过'),(10,20153855,4,81,3,'过'),(11,20153855,5,59,0,'没过');
/*!40000 ALTER TABLE `grade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grade1`
--

DROP TABLE IF EXISTS `grade1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grade1` (
  `gra1_id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` int(11) NOT NULL,
  `sele_id` int(11) NOT NULL,
  `gra1_score` int(11) NOT NULL,
  `gra1_point` int(11) NOT NULL,
  `gra1_judge` varchar(10) NOT NULL,
  PRIMARY KEY (`gra1_id`),
  KEY `stu_id_idx` (`stu_id`),
  KEY `select_id_idx` (`sele_id`),
  CONSTRAINT `grade1_selec` FOREIGN KEY (`sele_id`) REFERENCES `selec` (`sele_id`),
  CONSTRAINT `grade1_stu` FOREIGN KEY (`stu_id`) REFERENCES `student` (`stu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grade1`
--

LOCK TABLES `grade1` WRITE;
/*!40000 ALTER TABLE `grade1` DISABLE KEYS */;
INSERT INTO `grade1` VALUES (2,20153855,2,90,1,'过');
/*!40000 ALTER TABLE `grade1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `major`
--

DROP TABLE IF EXISTS `major`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `major` (
  `majo_id` int(11) NOT NULL AUTO_INCREMENT,
  `majo_name` varchar(45) NOT NULL,
  `col_id` int(11) NOT NULL,
  `majo_year` int(11) NOT NULL,
  PRIMARY KEY (`majo_id`),
  KEY `colege_id_idx` (`col_id`),
  CONSTRAINT `major_colle` FOREIGN KEY (`col_id`) REFERENCES `college` (`col_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `major`
--

LOCK TABLES `major` WRITE;
/*!40000 ALTER TABLE `major` DISABLE KEYS */;
INSERT INTO `major` VALUES (17,'软件工程',13,2000),(18,'计算机科学与技术',13,2001),(19,'信息与计算科学',22,2008),(20,'林学',14,1997),(21,'会计学',15,2002);
/*!40000 ALTER TABLE `major` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manager`
--

DROP TABLE IF EXISTS `manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `manager` (
  `mana_id` int(11) NOT NULL,
  `mana_password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`mana_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manager`
--

LOCK TABLES `manager` WRITE;
/*!40000 ALTER TABLE `manager` DISABLE KEYS */;
INSERT INTO `manager` VALUES (20181001,'123456');
/*!40000 ALTER TABLE `manager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notice`
--

DROP TABLE IF EXISTS `notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notice` (
  `noti_id` int(11) NOT NULL AUTO_INCREMENT,
  `noti_title` varchar(100) NOT NULL,
  `noti_content` mediumtext NOT NULL,
  `noti_editor` varchar(11) DEFAULT NULL,
  `noti_time` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`noti_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notice`
--

LOCK TABLES `notice` WRITE;
/*!40000 ALTER TABLE `notice` DISABLE KEYS */;
INSERT INTO `notice` VALUES (1,'关于我校2018年度申报国家公园管理本科专业的公示','2018年7月10日下午，学校教务处召开2018年度本科专业设置工作的评审会，经学院申报、会议评审与校学术委员会论证等环节，认为国家公园管理专业申报顺应国家生态文明战略，对接国家资源自然管理机构系统性调整，有利于完善国家公园管理这一领域人才需求，符合我校的办学要求，同意申报。特此公示。<br/><br/>公示时间为2018年7月31日至2018年8月6日。','张名','2018年8月17日'),(2,'关于2018年“专升本”录取有关事项的通知','根据湖南省教育厅《关于印发〈湖南省普通高等教育“专升本”工作实施办法〉的通知》（湘教发[2018]1号）、《关于认真做好2018年“专升本”生源择优推荐工作的通知》（湘教通〔2018〕114号）文件精神和《中南林业科技大学2018年“专升本”工作实施方案》的通知要求和安排，我校开展了2018年“专升本”选拔录取工作。根据“按专业按比例、三门课程总成绩从高分到低分录取”和“违纪考生不予录取”的原则，择优录取55名学生。请被录取的学生凭有效证件于2018年8月31日上午9：00-11:30到教务处学籍与成绩管理科（崇德楼503室）报到入学。','亿鑫','2018年7月17日'),(3,'关于2018年“‘树人学者’优秀教学人才奖”“教学工作先进单位”和“教学先进个人”评选表彰工作评审结果的公示','公示期为2017年7月17日至2017年7月19日。公示期间，如有异议，请以书面形式、传真或邮件等方式实名向教务处反映，并提供必要证明材料。','宜信','2018年7月17日');
/*!40000 ALTER TABLE `notice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persche`
--

DROP TABLE IF EXISTS `persche`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persche` (
  `ps_id` int(11) NOT NULL AUTO_INCREMENT,
  `sele_id` int(11) NOT NULL,
  `adrs_id` int(11) NOT NULL,
  PRIMARY KEY (`ps_id`),
  KEY `select_id_idx` (`sele_id`),
  KEY `adrs_id_idx` (`adrs_id`),
  CONSTRAINT `ps_adrs` FOREIGN KEY (`adrs_id`) REFERENCES `address` (`adrs_id`),
  CONSTRAINT `ps_sele` FOREIGN KEY (`sele_id`) REFERENCES `selec` (`sele_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persche`
--

LOCK TABLES `persche` WRITE;
/*!40000 ALTER TABLE `persche` DISABLE KEYS */;
INSERT INTO `persche` VALUES (2,2,4);
/*!40000 ALTER TABLE `persche` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restudy`
--

DROP TABLE IF EXISTS `restudy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `restudy` (
  `id` int(11) NOT NULL,
  `stu_id` int(11) DEFAULT NULL,
  `teac_id` int(11) DEFAULT NULL,
  `cour_id` int(11) DEFAULT NULL,
  `adrs_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `restudy_student_idx` (`stu_id`),
  KEY `restudy_teacher_idx` (`teac_id`),
  KEY `restudy_course_idx` (`cour_id`),
  KEY `restudy_address_idx` (`adrs_id`),
  CONSTRAINT `restudy_address` FOREIGN KEY (`adrs_id`) REFERENCES `address` (`adrs_id`),
  CONSTRAINT `restudy_course` FOREIGN KEY (`cour_id`) REFERENCES `course` (`cour_id`),
  CONSTRAINT `restudy_student` FOREIGN KEY (`stu_id`) REFERENCES `student` (`stu_id`),
  CONSTRAINT `restudy_teacher` FOREIGN KEY (`teac_id`) REFERENCES `teacher` (`teac_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restudy`
--

LOCK TABLES `restudy` WRITE;
/*!40000 ALTER TABLE `restudy` DISABLE KEYS */;
INSERT INTO `restudy` VALUES (1001,20153855,20021234,10,1),(1002,20153856,20044232,11,1),(1003,20163564,20051234,12,2),(1004,20153856,20021234,11,2),(1005,20163564,20021234,12,3),(1006,20163564,20021234,13,4),(1008,20153856,20021234,10,3),(1009,20163564,20021234,11,2);
/*!40000 ALTER TABLE `restudy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedule`
--

DROP TABLE IF EXISTS `schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schedule` (
  `sche_id` int(11) NOT NULL AUTO_INCREMENT,
  `tea_id` int(11) NOT NULL,
  `adrs_id` int(11) NOT NULL,
  PRIMARY KEY (`sche_id`),
  KEY `adrs_id_idx` (`adrs_id`),
  KEY `sche_tea_idx` (`tea_id`),
  CONSTRAINT `sche_adr` FOREIGN KEY (`adrs_id`) REFERENCES `address` (`adrs_id`),
  CONSTRAINT `sche_tea` FOREIGN KEY (`tea_id`) REFERENCES `teaching` (`tea_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedule`
--

LOCK TABLES `schedule` WRITE;
/*!40000 ALTER TABLE `schedule` DISABLE KEYS */;
INSERT INTO `schedule` VALUES (1,1,1),(2,2,2),(3,1,2),(4,4,5),(5,1,6),(6,5,7),(7,5,11),(8,1,12),(9,3,13);
/*!40000 ALTER TABLE `schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `selec`
--

DROP TABLE IF EXISTS `selec`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `selec` (
  `sele_id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_id` int(11) NOT NULL,
  `cour_id` int(11) NOT NULL,
  `teac_id` int(11) NOT NULL,
  `selecour_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`sele_id`),
  KEY `teac_id_idx` (`teac_id`),
  KEY `stu_id_idx` (`stu_id`),
  KEY `sele_cour_idx` (`cour_id`),
  KEY `sele_selectcourse_idx` (`selecour_id`),
  CONSTRAINT `sele_cour` FOREIGN KEY (`cour_id`) REFERENCES `course` (`cour_id`),
  CONSTRAINT `sele_selectcourse` FOREIGN KEY (`selecour_id`) REFERENCES `selectcourse` (`selecour_id`),
  CONSTRAINT `sele_stu` FOREIGN KEY (`stu_id`) REFERENCES `student` (`stu_id`),
  CONSTRAINT `sele_teach` FOREIGN KEY (`teac_id`) REFERENCES `teacher` (`teac_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `selec`
--

LOCK TABLES `selec` WRITE;
/*!40000 ALTER TABLE `selec` DISABLE KEYS */;
INSERT INTO `selec` VALUES (2,20153855,13,20021234,1);
/*!40000 ALTER TABLE `selec` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `selectcourse`
--

DROP TABLE IF EXISTS `selectcourse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `selectcourse` (
  `selecour_id` int(11) NOT NULL AUTO_INCREMENT,
  `cour_id` int(11) DEFAULT NULL,
  `teac_id` int(11) DEFAULT NULL,
  `selecour_time` char(4) DEFAULT NULL,
  PRIMARY KEY (`selecour_id`),
  KEY `teac_id_idx` (`teac_id`),
  KEY `cour_id_idx` (`cour_id`),
  CONSTRAINT `cour_id` FOREIGN KEY (`cour_id`) REFERENCES `course` (`cour_id`),
  CONSTRAINT `teac_id` FOREIGN KEY (`teac_id`) REFERENCES `teacher` (`teac_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `selectcourse`
--

LOCK TABLES `selectcourse` WRITE;
/*!40000 ALTER TABLE `selectcourse` DISABLE KEYS */;
INSERT INTO `selectcourse` VALUES (1,13,20021234,'第二学期'),(2,17,20044232,'第一学期');
/*!40000 ALTER TABLE `selectcourse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `stu_id` int(11) NOT NULL,
  `stu_name` varchar(45) NOT NULL,
  `stu_password` char(32) NOT NULL DEFAULT '123456',
  `stu_sex` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `stu_addr` varchar(45) NOT NULL,
  `stu_phone` char(11) NOT NULL,
  `stu_email` varchar(45) NOT NULL,
  `stu_pic` varchar(45) NOT NULL,
  `clas_id` int(11) NOT NULL,
  `majo_id` int(11) NOT NULL,
  PRIMARY KEY (`stu_id`),
  KEY `cla_id_idx` (`clas_id`),
  KEY `stu_maj_idx` (`majo_id`),
  CONSTRAINT `stu_claz` FOREIGN KEY (`clas_id`) REFERENCES `clazz` (`clas_id`),
  CONSTRAINT `stu_maj` FOREIGN KEY (`majo_id`) REFERENCES `major` (`majo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (20153502,'p','123456','女','p','p','p','../images/student/c3.png',9,17),(20153855,'陈妍希','123','男','湖南株洲','13567894531','2345619@qq.com','../images/student/20153855.jpg',7,17),(20153856,'李四','321','男','湖南湘潭','14578903245','45988@qq.com','2.png',8,17),(20163564,'小红','555','女','江西南昌','15038475837','12573824@qq.com','3.png',9,17);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subject` (
  `sub_id` int(11) NOT NULL AUTO_INCREMENT,
  `majo_id` int(11) NOT NULL,
  `sub_time` char(4) NOT NULL,
  `cour_id` int(11) NOT NULL,
  PRIMARY KEY (`sub_id`),
  KEY `major_id_idx` (`majo_id`),
  KEY `course_id_idx` (`cour_id`),
  CONSTRAINT `sub_cour` FOREIGN KEY (`cour_id`) REFERENCES `course` (`cour_id`),
  CONSTRAINT `sub_majo` FOREIGN KEY (`majo_id`) REFERENCES `major` (`majo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (6,17,'第一学期',10),(7,17,'第一学期',11),(8,17,'第二学期',12),(10,17,'第一学期',14),(11,17,'第一学期',15),(12,17,'第一学期',16);
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject1`
--

DROP TABLE IF EXISTS `subject1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subject1` (
  `sub_id` int(11) NOT NULL AUTO_INCREMENT,
  `majo_id` int(11) NOT NULL,
  `sub_time` int(11) NOT NULL,
  `cour_id` int(11) NOT NULL,
  PRIMARY KEY (`sub_id`),
  KEY `sub_cour_idx` (`cour_id`),
  KEY `sub_majo_idx` (`majo_id`),
  CONSTRAINT `cour` FOREIGN KEY (`cour_id`) REFERENCES `course` (`cour_id`),
  CONSTRAINT `majo` FOREIGN KEY (`majo_id`) REFERENCES `major` (`majo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject1`
--

LOCK TABLES `subject1` WRITE;
/*!40000 ALTER TABLE `subject1` DISABLE KEYS */;
INSERT INTO `subject1` VALUES (6,17,2015,10),(7,17,2015,11),(8,17,2015,12);
/*!40000 ALTER TABLE `subject1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `table`
--

DROP TABLE IF EXISTS `table`;
/*!50001 DROP VIEW IF EXISTS `table`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `table` AS SELECT 
 1 AS `adrs_day`,
 1 AS `adrs_week`,
 1 AS `adrs_part`,
 1 AS `adrs_site`,
 1 AS `cour_name`,
 1 AS `clas_period`,
 1 AS `cour_period`,
 1 AS `majo_name`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher` (
  `teac_id` int(11) NOT NULL,
  `teac_name` varchar(45) NOT NULL,
  `teac_sex` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `teac_password` char(32) NOT NULL DEFAULT '123456',
  `teac_addr` varchar(45) NOT NULL,
  `teac_phone` char(11) NOT NULL,
  `teac_email` varchar(45) NOT NULL,
  `teac_pic` varchar(45) NOT NULL,
  `col_id` int(11) NOT NULL,
  `teac_title` varchar(45) NOT NULL,
  `teac_time` varchar(45) NOT NULL,
  PRIMARY KEY (`teac_id`),
  KEY `college_id_idx` (`col_id`),
  CONSTRAINT `teach_coll` FOREIGN KEY (`col_id`) REFERENCES `college` (`col_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (20021234,'李云','女','1213','湖南永州','15082736742','12347584@qq.com','./images/teacher/1.jpg',21,'教授','2002'),(20034321,'吴联','男','111','上海','15029384758','139222@qq.com','10.png',18,'讲师','2003'),(20044232,'张杰','男','123','四川成都','17548652254','954785@qq.com','4.png',13,'教授','2004'),(20051234,'王天','男','321','湖南长沙','16734821938','139432@qq.com','5.png',13,'讲师','2005');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teaching`
--

DROP TABLE IF EXISTS `teaching`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teaching` (
  `tea_id` int(11) NOT NULL,
  `clas_id` int(11) NOT NULL,
  `sub_id` int(11) NOT NULL,
  `teac_id` int(11) NOT NULL,
  PRIMARY KEY (`tea_id`),
  KEY `cla_id_idx` (`clas_id`),
  KEY `teaching__idx` (`teac_id`),
  KEY `teaching_cour_idx` (`sub_id`),
  CONSTRAINT `tea_cla` FOREIGN KEY (`clas_id`) REFERENCES `clazz` (`clas_id`),
  CONSTRAINT `tea_sub` FOREIGN KEY (`sub_id`) REFERENCES `subject` (`sub_id`),
  CONSTRAINT `tea_teach` FOREIGN KEY (`teac_id`) REFERENCES `teacher` (`teac_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teaching`
--

LOCK TABLES `teaching` WRITE;
/*!40000 ALTER TABLE `teaching` DISABLE KEYS */;
INSERT INTO `teaching` VALUES (1,7,6,20021234),(2,7,7,20044232),(3,7,10,20051234),(4,7,11,20044232),(5,7,12,20034321);
/*!40000 ALTER TABLE `teaching` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `v_grade`
--

DROP TABLE IF EXISTS `v_grade`;
/*!50001 DROP VIEW IF EXISTS `v_grade`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `v_grade` AS SELECT 
 1 AS `stuId`,
 1 AS `courName`,
 1 AS `courCredit`,
 1 AS `courNature`,
 1 AS `teacName`,
 1 AS `subTime`,
 1 AS `score`,
 1 AS `point`,
 1 AS `judge`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `v_maincourinfo`
--

DROP TABLE IF EXISTS `v_maincourinfo`;
/*!50001 DROP VIEW IF EXISTS `v_maincourinfo`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `v_maincourinfo` AS SELECT 
 1 AS `tea_id`,
 1 AS `clas_id`,
 1 AS `majo_id`,
 1 AS `cour_id`,
 1 AS `mcCourName`,
 1 AS `mcCourCredit`,
 1 AS `mcCourNature`,
 1 AS `mcCourPeriod`,
 1 AS `mcSubTime`,
 1 AS `mcTeacName`,
 1 AS `mcTeacTitle`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `v_majocourinfo`
--

DROP TABLE IF EXISTS `v_majocourinfo`;
/*!50001 DROP VIEW IF EXISTS `v_majocourinfo`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `v_majocourinfo` AS SELECT 
 1 AS `mcSubId`,
 1 AS `mcMajorName`,
 1 AS `mcSubTime`,
 1 AS `mcCourName`,
 1 AS `mcCourNature`,
 1 AS `mcCourCredit`,
 1 AS `mcCourPeriod`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `v_persche`
--

DROP TABLE IF EXISTS `v_persche`;
/*!50001 DROP VIEW IF EXISTS `v_persche`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `v_persche` AS SELECT 
 1 AS `stu_id`,
 1 AS `courName`,
 1 AS `teacName`,
 1 AS `subTime`,
 1 AS `day`,
 1 AS `week`,
 1 AS `part`,
 1 AS `site`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `v_poinscor`
--

DROP TABLE IF EXISTS `v_poinscor`;
/*!50001 DROP VIEW IF EXISTS `v_poinscor`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `v_poinscor` AS SELECT 
 1 AS `stuId`,
 1 AS `sum`,
 1 AS `subTime`,
 1 AS `clasId`,
 1 AS `period`,
 1 AS `majoId`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `v_schedule`
--

DROP TABLE IF EXISTS `v_schedule`;
/*!50001 DROP VIEW IF EXISTS `v_schedule`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `v_schedule` AS SELECT 
 1 AS `clas_id`,
 1 AS `courName`,
 1 AS `teacName`,
 1 AS `subTime`,
 1 AS `day`,
 1 AS `week`,
 1 AS `part`,
 1 AS `site`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `v_selecourinfo`
--

DROP TABLE IF EXISTS `v_selecourinfo`;
/*!50001 DROP VIEW IF EXISTS `v_selecourinfo`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `v_selecourinfo` AS SELECT 
 1 AS `scId`,
 1 AS `scSubTime`,
 1 AS `scCourName`,
 1 AS `scCourCredit`,
 1 AS `scCourNature`,
 1 AS `scCourPeriod`,
 1 AS `scTeacName`,
 1 AS `scTeacTitle`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `v_stuinfo`
--

DROP TABLE IF EXISTS `v_stuinfo`;
/*!50001 DROP VIEW IF EXISTS `v_stuinfo`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `v_stuinfo` AS SELECT 
 1 AS `stu_id`,
 1 AS `stu_name`,
 1 AS `stu_addr`,
 1 AS `stu_sex`,
 1 AS `stu_phone`,
 1 AS `stu_email`,
 1 AS `stu_pic`,
 1 AS `stu_clas`,
 1 AS `stu_majo`,
 1 AS `stu_col`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `table`
--

/*!50001 DROP VIEW IF EXISTS `table`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `table` AS select `address`.`adrs_day` AS `adrs_day`,`address`.`adrs_week` AS `adrs_week`,`address`.`adrs_part` AS `adrs_part`,`address`.`adrs_site` AS `adrs_site`,`course`.`cour_name` AS `cour_name`,`clazz`.`clas_period` AS `clas_period`,`course`.`cour_period` AS `cour_period`,`major`.`majo_name` AS `majo_name` from ((`address` join `course` on((`address`.`adrs_id` = `course`.`addr_id`))) join (`clazz` join `major` on((`clazz`.`majo_id` = `major`.`majo_id`)))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_grade`
--

/*!50001 DROP VIEW IF EXISTS `v_grade`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_grade` AS select `gra`.`stu_id` AS `stuId`,`vm`.`mcCourName` AS `courName`,`vm`.`mcCourCredit` AS `courCredit`,`vm`.`mcCourNature` AS `courNature`,`vm`.`mcTeacName` AS `teacName`,`vm`.`mcSubTime` AS `subTime`,`gra`.`gra_score` AS `score`,`gra`.`gra_point` AS `point`,`gra`.`gra_judge` AS `judge` from ((`grade` `gra` join `teaching` `tea` on((`gra`.`tea_id` = `tea`.`tea_id`))) join `v_maincourinfo` `vm` on((`vm`.`tea_id` = `tea`.`tea_id`))) union select `gra`.`stu_id` AS `stu_id`,`vs`.`scCourName` AS `scCourName`,`vs`.`scCourCredit` AS `scCourCredit`,`vs`.`scCourNature` AS `scCourNature`,`vs`.`scTeacName` AS `scTeacName`,`vs`.`scSubTime` AS `scSubTime`,`gra`.`gra1_score` AS `gra1_score`,`gra`.`gra1_point` AS `gra1_point`,`gra`.`gra1_judge` AS `gra1_judge` from ((`grade1` `gra` join `selec` `sele` on((`sele`.`sele_id` = `gra`.`sele_id`))) join `v_selecourinfo` `vs` on((`vs`.`scId` = `sele`.`selecour_id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_maincourinfo`
--

/*!50001 DROP VIEW IF EXISTS `v_maincourinfo`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_maincourinfo` AS select `tea`.`tea_id` AS `tea_id`,`clas`.`clas_id` AS `clas_id`,`clas`.`majo_id` AS `majo_id`,`cour`.`cour_id` AS `cour_id`,`cour`.`cour_name` AS `mcCourName`,`cour`.`cour_credit` AS `mcCourCredit`,`cour`.`cour_nature` AS `mcCourNature`,`cour`.`cour_period` AS `mcCourPeriod`,`sub`.`sub_time` AS `mcSubTime`,`teac`.`teac_name` AS `mcTeacName`,`teac`.`teac_title` AS `mcTeacTitle` from ((((`clazz` `clas` join `teaching` `tea` on((`tea`.`clas_id` = `clas`.`clas_id`))) join `subject` `sub` on((`tea`.`sub_id` = `sub`.`sub_id`))) join `course` `cour` on((`cour`.`cour_id` = `sub`.`cour_id`))) join `teacher` `teac` on((`teac`.`teac_id` = `tea`.`teac_id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_majocourinfo`
--

/*!50001 DROP VIEW IF EXISTS `v_majocourinfo`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_majocourinfo` AS select `sub`.`sub_id` AS `mcSubId`,`m`.`majo_name` AS `mcMajorName`,`sub`.`sub_time` AS `mcSubTime`,`c`.`cour_name` AS `mcCourName`,`c`.`cour_nature` AS `mcCourNature`,`c`.`cour_credit` AS `mcCourCredit`,`c`.`cour_period` AS `mcCourPeriod` from ((`subject` `sub` join `course` `c` on((`sub`.`cour_id` = `c`.`cour_id`))) join `major` `m` on((`m`.`majo_id` = `sub`.`majo_id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_persche`
--

/*!50001 DROP VIEW IF EXISTS `v_persche`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_persche` AS select `sele`.`stu_id` AS `stu_id`,`vs`.`scCourName` AS `courName`,`vs`.`scTeacName` AS `teacName`,`vs`.`scSubTime` AS `subTime`,`addr`.`adrs_day` AS `day`,`addr`.`adrs_week` AS `week`,`addr`.`adrs_part` AS `part`,`addr`.`adrs_site` AS `site` from (((`persche` `ps` join `selec` `sele` on((`ps`.`sele_id` = `sele`.`sele_id`))) join `v_selecourinfo` `vs` on((`sele`.`selecour_id` = `vs`.`scId`))) join `address` `addr` on((`ps`.`adrs_id` = `addr`.`adrs_id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_poinscor`
--

/*!50001 DROP VIEW IF EXISTS `v_poinscor`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_poinscor` AS select `vg`.`stuId` AS `stuId`,sum((`vg`.`point` * `vg`.`courCredit`)) AS `sum`,`vg`.`subTime` AS `subTime`,`s`.`clas_id` AS `clasId`,`c`.`clas_period` AS `period`,`s`.`majo_id` AS `majoId` from ((`v_grade` `vg` join `student` `s` on((`vg`.`stuId` = `s`.`stu_id`))) join `clazz` `c` on((`c`.`clas_id` = `s`.`clas_id`))) group by `vg`.`stuId`,`vg`.`subTime` order by `sum` desc */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_schedule`
--

/*!50001 DROP VIEW IF EXISTS `v_schedule`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_schedule` AS select `tea`.`clas_id` AS `clas_id`,`vm`.`mcCourName` AS `courName`,`vm`.`mcTeacName` AS `teacName`,`vm`.`mcSubTime` AS `subTime`,`addr`.`adrs_day` AS `day`,`addr`.`adrs_week` AS `week`,`addr`.`adrs_part` AS `part`,`addr`.`adrs_site` AS `site` from (((`schedule` `sch` join `teaching` `tea` on((`sch`.`tea_id` = `tea`.`tea_id`))) join `v_maincourinfo` `vm` on((`tea`.`tea_id` = `vm`.`tea_id`))) join `address` `addr` on((`addr`.`adrs_id` = `sch`.`adrs_id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_selecourinfo`
--

/*!50001 DROP VIEW IF EXISTS `v_selecourinfo`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_selecourinfo` AS select `s`.`selecour_id` AS `scId`,`s`.`selecour_time` AS `scSubTime`,`c`.`cour_name` AS `scCourName`,`c`.`cour_credit` AS `scCourCredit`,`c`.`cour_nature` AS `scCourNature`,`c`.`cour_period` AS `scCourPeriod`,`t`.`teac_name` AS `scTeacName`,`t`.`teac_title` AS `scTeacTitle` from ((`selectcourse` `s` join `course` `c` on((`s`.`cour_id` = `c`.`cour_id`))) join `teacher` `t` on((`t`.`teac_id` = `s`.`teac_id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_stuinfo`
--

/*!50001 DROP VIEW IF EXISTS `v_stuinfo`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_stuinfo` AS select `s`.`stu_id` AS `stu_id`,`s`.`stu_name` AS `stu_name`,`s`.`stu_addr` AS `stu_addr`,`s`.`stu_sex` AS `stu_sex`,`s`.`stu_phone` AS `stu_phone`,`s`.`stu_email` AS `stu_email`,`s`.`stu_pic` AS `stu_pic`,`c`.`clas_name` AS `stu_clas`,`m`.`majo_name` AS `stu_majo`,`col`.`col_name` AS `stu_col` from (((`student` `s` join `clazz` `c` on((`s`.`clas_id` = `c`.`clas_id`))) join `major` `m` on((`s`.`majo_id` = `m`.`majo_id`))) join `college` `col` on((`col`.`col_id` = `m`.`col_id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-09-09 15:52:55
