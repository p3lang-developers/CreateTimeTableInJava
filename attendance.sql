-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: attendance
-- ------------------------------------------------------
-- Server version	5.7.12-log

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `admin_id` varchar(45) NOT NULL,
  `admin_password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES ('abhi','abhi'),('hello','hello');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class_details`
--

DROP TABLE IF EXISTS `class_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `class_details` (
  `class_id` varchar(45) NOT NULL,
  `class_stream` varchar(45) DEFAULT NULL,
  `class_semester` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_details`
--

LOCK TABLES `class_details` WRITE;
/*!40000 ALTER TABLE `class_details` DISABLE KEYS */;
INSERT INTO `class_details` VALUES ('1st_semester_cse','CSE','1st'),('1st_semester_ece','ECE','1st'),('1st_semester_it','IT','1st'),('1st_semester_mech','MECH','1st');
/*!40000 ALTER TABLE `class_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject_details`
--

DROP TABLE IF EXISTS `subject_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subject_details` (
  `subject_id` varchar(45) NOT NULL,
  `subject_name` varchar(45) DEFAULT NULL,
  `subject_lecture` varchar(45) DEFAULT NULL,
  `subject_tutorial` varchar(45) DEFAULT NULL,
  `subject_practical` varchar(45) DEFAULT NULL,
  `subject_total` varchar(45) DEFAULT NULL,
  `subject_year` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`subject_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject_details`
--

LOCK TABLES `subject_details` WRITE;
/*!40000 ALTER TABLE `subject_details` DISABLE KEYS */;
INSERT INTO `subject_details` VALUES ('CH-101F','ENGINEERING CHEMISTRY','3','1','0','4','1'),('CH-103F','ENGINEERING CHEMISTRY LAB','0','0','2','2','1'),('CSE-101F','FUNDAMENTALS OF COMPUTER & PROGRAMMING IN C','3','1','0','4','1'),('CSE-103F','FCPC LAB','0','0','2','2','1'),('ECE-101F','BASICS OF ELECTRONICS','3','0','0','3','1'),('ECE-103F','BASICS OF ELECTRONICS LAB','0','0','2','2','1'),('EE-101F','ELECTRICAL TECHNOLOGY','3','1','0','4','1'),('EE-103F','ELECTRICAL TECHNOLOGY LAB','0','0','2','2','1'),('HUM-101F','ESSENTIALS OF COMMUNICATION','3','1','0','4','1'),('MATH-101F','MATHEMATICS-I','4','1','0','5','1'),('ME-101F','BASICS OF MECHANICAL ENGINEERING','3','0','0','3','1'),('ME-103F','ENGG. GRAPHICS & DRAWING','1','2','3','4','1'),('ME-105F','WORKSHOP TECHNOLOGY','2','0','2','4','1'),('ME-107F','BASICS OF MECH. ENGG. LAB','0','0','2','2','1'),('PHY-101F','PHYSICS-I','3','1','0','4','1'),('PHY-103F','PHYSICS LAB – I','0','0','2','2','1');
/*!40000 ALTER TABLE `subject_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject_stream`
--

DROP TABLE IF EXISTS `subject_stream`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subject_stream` (
  `subject_stream_id` int(11) NOT NULL AUTO_INCREMENT,
  `subject_id` varchar(45) DEFAULT NULL,
  `subject_stream` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`subject_stream_id`),
  UNIQUE KEY `subject_stream_id_UNIQUE` (`subject_stream_id`),
  KEY `subject_id` (`subject_id`),
  KEY `subject_stream` (`subject_stream`),
  CONSTRAINT `subject_id` FOREIGN KEY (`subject_id`) REFERENCES `subject_details` (`subject_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `subject_stream` FOREIGN KEY (`subject_stream`) REFERENCES `class_details` (`class_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=117 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject_stream`
--

LOCK TABLES `subject_stream` WRITE;
/*!40000 ALTER TABLE `subject_stream` DISABLE KEYS */;
INSERT INTO `subject_stream` VALUES (53,'CH-101F','1st_semester_cse'),(54,'CH-101F','1st_semester_ece'),(55,'CH-101F','1st_semester_it'),(56,'CH-101F','1st_semester_mech'),(57,'CH-103F','1st_semester_cse'),(58,'CH-103F','1st_semester_ece'),(59,'CH-103F','1st_semester_it'),(60,'CH-103F','1st_semester_mech'),(61,'CSE-101F','1st_semester_cse'),(62,'CSE-101F','1st_semester_ece'),(63,'CSE-101F','1st_semester_it'),(64,'CSE-101F','1st_semester_mech'),(65,'CSE-103F','1st_semester_cse'),(66,'CSE-103F','1st_semester_ece'),(67,'CSE-103F','1st_semester_it'),(68,'CSE-103F','1st_semester_mech'),(69,'ECE-101F','1st_semester_cse'),(70,'ECE-101F','1st_semester_ece'),(71,'ECE-101F','1st_semester_it'),(72,'ECE-101F','1st_semester_mech'),(73,'ECE-103F','1st_semester_cse'),(74,'ECE-103F','1st_semester_ece'),(75,'ECE-103F','1st_semester_it'),(76,'ECE-103F','1st_semester_mech'),(77,'EE-101F','1st_semester_cse'),(78,'EE-101F','1st_semester_ece'),(79,'EE-101F','1st_semester_it'),(80,'EE-101F','1st_semester_mech'),(81,'EE-103F','1st_semester_cse'),(82,'EE-103F','1st_semester_ece'),(83,'EE-103F','1st_semester_it'),(84,'EE-103F','1st_semester_mech'),(85,'HUM-101F','1st_semester_cse'),(86,'HUM-101F','1st_semester_ece'),(87,'HUM-101F','1st_semester_it'),(88,'HUM-101F','1st_semester_mech'),(89,'MATH-101F','1st_semester_cse'),(90,'MATH-101F','1st_semester_ece'),(91,'MATH-101F','1st_semester_it'),(92,'MATH-101F','1st_semester_mech'),(93,'ME-101F','1st_semester_cse'),(94,'ME-101F','1st_semester_ece'),(95,'ME-101F','1st_semester_it'),(96,'ME-101F','1st_semester_mech'),(97,'ME-103F','1st_semester_cse'),(98,'ME-103F','1st_semester_ece'),(99,'ME-103F','1st_semester_it'),(100,'ME-103F','1st_semester_mech'),(101,'ME-105F','1st_semester_cse'),(102,'ME-105F','1st_semester_ece'),(103,'ME-105F','1st_semester_it'),(104,'ME-105F','1st_semester_mech'),(105,'ME-107F','1st_semester_cse'),(106,'ME-107F','1st_semester_ece'),(107,'ME-107F','1st_semester_it'),(108,'ME-107F','1st_semester_mech'),(109,'PHY-101F','1st_semester_cse'),(110,'PHY-101F','1st_semester_ece'),(111,'PHY-101F','1st_semester_it'),(112,'PHY-101F','1st_semester_mech'),(113,'PHY-103F','1st_semester_cse'),(114,'PHY-103F','1st_semester_ece'),(115,'PHY-103F','1st_semester_it'),(116,'PHY-103F','1st_semester_mech');
/*!40000 ALTER TABLE `subject_stream` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher_class`
--

DROP TABLE IF EXISTS `teacher_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher_class` (
  `teacher_class_id` int(11) NOT NULL AUTO_INCREMENT,
  `teacher_details_id1` varchar(45) DEFAULT NULL,
  `class_details_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`teacher_class_id`),
  KEY `teacher_details_id1` (`teacher_details_id1`),
  KEY `class_details_id` (`class_details_id`),
  CONSTRAINT `class_details_id` FOREIGN KEY (`class_details_id`) REFERENCES `class_details` (`class_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `teacher_details_id1` FOREIGN KEY (`teacher_details_id1`) REFERENCES `teacher_details` (`teacher_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_class`
--

LOCK TABLES `teacher_class` WRITE;
/*!40000 ALTER TABLE `teacher_class` DISABLE KEYS */;
INSERT INTO `teacher_class` VALUES (40,'cse_8001','1st_semester_cse'),(42,'cse_8002','1st_semester_ece'),(44,'cse_8003','1st_semester_it'),(46,'cse_8004','1st_semester_mech'),(48,'cse_8005','1st_semester_it');
/*!40000 ALTER TABLE `teacher_class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher_details`
--

DROP TABLE IF EXISTS `teacher_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher_details` (
  `teacher_id` varchar(45) NOT NULL,
  `teacher_name` varchar(45) DEFAULT NULL,
  `teacher_gender` varchar(45) DEFAULT NULL,
  `teacher_address` varchar(45) DEFAULT NULL,
  `teacher_contact_number` varchar(45) DEFAULT NULL,
  `teacher_email` varchar(45) DEFAULT NULL,
  `teacher_alternate_email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_details`
--

LOCK TABLES `teacher_details` WRITE;
/*!40000 ALTER TABLE `teacher_details` DISABLE KEYS */;
INSERT INTO `teacher_details` VALUES ('cse_8001','abhishek aggarwal','male','1a/225 NIT fbd','9555559613','abhishek.smile09@gmail.com',''),('cse_8002','Deepak singh','male','350/29 fbd','9999605166','dipak350@gmail.com',''),('cse_8003','abhishek bhandari','male','21/10 fbd','9953887892','abhishekbhandari211990@gmail.com',''),('cse_8004','Ritika kant','female','1B/99 NIT fbd','96548868750','iritikakant@gmail.com',''),('cse_8005','saru tyagi','female','22/18','9654640344','tyagi.saru91@gmail.com','');
/*!40000 ALTER TABLE `teacher_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher_subject`
--

DROP TABLE IF EXISTS `teacher_subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher_subject` (
  `teacher_subject_id` int(11) NOT NULL AUTO_INCREMENT,
  `teacher_details_id` varchar(45) DEFAULT NULL,
  `subject_details_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`teacher_subject_id`),
  UNIQUE KEY `teacher_subject_id_UNIQUE` (`teacher_subject_id`),
  KEY `teacher_details_id` (`teacher_details_id`),
  KEY `subject_details_id` (`subject_details_id`),
  CONSTRAINT `subject_details_id` FOREIGN KEY (`subject_details_id`) REFERENCES `subject_details` (`subject_id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `teacher_details_id` FOREIGN KEY (`teacher_details_id`) REFERENCES `teacher_details` (`teacher_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_subject`
--

LOCK TABLES `teacher_subject` WRITE;
/*!40000 ALTER TABLE `teacher_subject` DISABLE KEYS */;
INSERT INTO `teacher_subject` VALUES (57,'cse_8001','CH-101F'),(58,'cse_8001','CH-103F'),(59,'cse_8001','CSE-101F'),(60,'cse_8001','CSE-103F'),(62,'cse_8002','ECE-101F'),(63,'cse_8002','ECE-103F'),(64,'cse_8002','EE-101F'),(65,'cse_8002','EE-103F'),(67,'cse_8003','CH-101F'),(68,'cse_8003','CH-103F'),(69,'cse_8003','ECE-101F'),(70,'cse_8003','ECE-103F'),(72,'cse_8004','ME-101F'),(73,'cse_8004','ME-103F'),(74,'cse_8004','ME-105F'),(75,'cse_8004','ME-107F'),(77,'cse_8005','PHY-103F'),(78,'cse_8005','PHY-101F'),(79,'cse_8005','MATH-101F'),(80,'cse_8005','HUM-101F');
/*!40000 ALTER TABLE `teacher_subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `time_table_details`
--

DROP TABLE IF EXISTS `time_table_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `time_table_details` (
  `time_table_id` int(11) NOT NULL AUTO_INCREMENT,
  `time_table_class_id` varchar(45) DEFAULT NULL,
  `day` varchar(45) DEFAULT NULL,
  `lecture` varchar(45) DEFAULT NULL,
  `time_table_subject_id` varchar(45) DEFAULT NULL,
  `time_table_teacher_id` varchar(45) DEFAULT NULL,
  `class_councillor1` varchar(45) DEFAULT NULL,
  `class_councillor2` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`time_table_id`),
  UNIQUE KEY `time_table_details_id_UNIQUE` (`time_table_id`),
  KEY `time_table_class_id` (`time_table_class_id`),
  KEY `time_table_subject_id` (`time_table_subject_id`),
  KEY `time_table_teacher_id` (`time_table_teacher_id`),
  KEY `class_councillor1` (`class_councillor1`),
  KEY `class_councillor2` (`class_councillor2`),
  CONSTRAINT `class_councillor1` FOREIGN KEY (`class_councillor1`) REFERENCES `teacher_details` (`teacher_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `class_councillor2` FOREIGN KEY (`class_councillor2`) REFERENCES `teacher_details` (`teacher_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `time_table_class_id` FOREIGN KEY (`time_table_class_id`) REFERENCES `class_details` (`class_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `time_table_subject_id` FOREIGN KEY (`time_table_subject_id`) REFERENCES `subject_details` (`subject_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `time_table_teacher_id` FOREIGN KEY (`time_table_teacher_id`) REFERENCES `teacher_details` (`teacher_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `time_table_details`
--

LOCK TABLES `time_table_details` WRITE;
/*!40000 ALTER TABLE `time_table_details` DISABLE KEYS */;
INSERT INTO `time_table_details` VALUES (4,'1st_semester_cse','1','1','CH-101F','cse_8001','cse_8001','cse_8001','true'),(5,'1st_semester_cse','1','2','CH-103F','cse_8003','cse_8001','cse_8001','true'),(6,'1st_semester_cse','1','3','CSE-101F','cse_8001','cse_8001','cse_8001','true'),(7,'1st_semester_cse','1','4','ECE-101F','cse_8002','cse_8001','cse_8001','true'),(8,'1st_semester_cse','1','5','CSE-103F','cse_8001','cse_8001','cse_8001','true'),(9,'1st_semester_cse','1','6','ECE-103F','cse_8003','cse_8001','cse_8001','true'),(10,'1st_semester_cse','1','7','EE-101F','cse_8002','cse_8001','cse_8001','true'),(11,'1st_semester_cse','2','1','ECE-103F','cse_8003','cse_8001','cse_8001','true'),(12,'1st_semester_cse','2','2','EE-101F','cse_8002','cse_8001','cse_8001','true'),(13,'1st_semester_cse','2','3','EE-103F','cse_8002','cse_8001','cse_8001','true'),(14,'1st_semester_cse','2','4','HUM-101F','cse_8005','cse_8001','cse_8001','true'),(15,'1st_semester_cse','2','5','ME-101F','cse_8004','cse_8001','cse_8001','true'),(16,'1st_semester_cse','2','6','ME-103F','cse_8004','cse_8001','cse_8001','true'),(17,'1st_semester_cse','2','7','ME-105F','cse_8004','cse_8001','cse_8001','true'),(18,'1st_semester_cse','2','7','PHY-103F','cse_8005','cse_8001','cse_8001','true'),(19,'1st_semester_cse','3','1','PHY-101F','cse_8005','cse_8001','cse_8001','true'),(20,'1st_semester_cse','3','2','PHY-101F','cse_8005','cse_8001','cse_8001','true'),(21,'1st_semester_cse','3','3','ME-107F','cse_8004','cse_8001','cse_8001','true'),(22,'1st_semester_cse','3','4','ME-107F','cse_8004','cse_8001','cse_8001','true'),(23,'1st_semester_cse','3','5','PHY-101F','cse_8005','cse_8001','cse_8001','true'),(24,'1st_semester_cse','3','6','CH-101F','cse_8001','cse_8001','cse_8001','true'),(25,'1st_semester_cse','3','7','CSE-101F','cse_8001','cse_8001','cse_8001','true'),(26,'1st_semester_cse','4','1','CSE-103F','cse_8001','cse_8001','cse_8001','true'),(27,'1st_semester_cse','4','2','CSE-101F','cse_8001','cse_8001','cse_8001','true'),(28,'1st_semester_cse','4','3','ECE-103F','cse_8003','cse_8001','cse_8001','true'),(29,'1st_semester_cse','4','4','ECE-103F','cse_8003','cse_8001','cse_8001','true'),(30,'1st_semester_cse','4','5','PHY-101F','cse_8005','cse_8001','cse_8001','true'),(31,'1st_semester_cse','4','6','ECE-103F','cse_8002','cse_8001','cse_8001','true'),(32,'1st_semester_cse','4','7','CSE-103F','cse_8001','cse_8001','cse_8001','true'),(33,'1st_semester_cse','5','1','ME-107F','cse_8004','cse_8001','cse_8001','true'),(34,'1st_semester_cse','5','2','EE-101F','cse_8002','cse_8001','cse_8001','true'),(35,'1st_semester_cse','5','3','CH-101F','cse_8003','cse_8001','cse_8001','true'),(36,'1st_semester_cse','5','4','CSE-101F','cse_8001','cse_8001','cse_8001','true'),(37,'1st_semester_cse','5','5','CSE-101F','cse_8001','cse_8001','cse_8001','true'),(38,'1st_semester_cse','5','6','ECE-101F','cse_8003','cse_8001','cse_8001','true'),(39,'1st_semester_cse','5','7','ECE-103F','cse_8003','cse_8001','cse_8001','true');
/*!40000 ALTER TABLE `time_table_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `today_attendance`
--

DROP TABLE IF EXISTS `today_attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `today_attendance` (
  `today_attendance_id` int(11) NOT NULL AUTO_INCREMENT,
  `today_date` datetime DEFAULT NULL,
  `today_status` varchar(45) DEFAULT NULL,
  `today_teacher_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`today_attendance_id`),
  KEY `today_teacher_id` (`today_teacher_id`),
  CONSTRAINT `today_teacher_id` FOREIGN KEY (`today_teacher_id`) REFERENCES `teacher_details` (`teacher_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `today_attendance`
--

LOCK TABLES `today_attendance` WRITE;
/*!40000 ALTER TABLE `today_attendance` DISABLE KEYS */;
INSERT INTO `today_attendance` VALUES (3,'2016-05-11 00:00:00','present','cse_8001'),(5,'2016-05-11 00:00:00','present','cse_8002'),(6,'2016-05-11 00:00:00','present','cse_8001'),(7,'2016-05-11 00:00:00','present','cse_8002'),(8,'2016-05-11 00:00:00','absent','cse_8005');
/*!40000 ALTER TABLE `today_attendance` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-12  8:41:36
