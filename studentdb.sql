CREATE DATABASE  IF NOT EXISTS `studentdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `studentdb`;
-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: studentdb
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `id` int NOT NULL,
  `fees` tinyint(1) NOT NULL DEFAULT '0',
  `student_id` int NOT NULL,
  PRIMARY KEY (`id`,`student_id`),
  KEY `fk_account_student1_idx` (`student_id`),
  CONSTRAINT `fk_account_student1` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES ('65732581','sDdGXmsgsEpe',1,0,1),('97512380','tyfSUdyslbtD',2,0,2),('56252719','g5Yw5ASmAfID',3,0,3),('43444336','RH90IDlJGbuO',4,0,4),('27806734','x3CsGykAMeCP',5,0,5),('79716166','tjIjJUxZWV6i',6,0,6),('38690008','7E6VtzgfhrBZ',7,0,7),('30685181','1IGkzjqm2ZL4',8,0,8),('90441889','wJGVjI0egzNo',9,0,9),('55132590','OwISH2sPpd8h',10,0,10);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `module`
--

DROP TABLE IF EXISTS `module`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `module` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `credit` varchar(45) NOT NULL,
  `professor_id` int NOT NULL,
  `enrolled_stud` int NOT NULL,
  `max_places` int NOT NULL,
  `school` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_module_professor_idx` (`professor_id`),
  CONSTRAINT `fk_module_professor` FOREIGN KEY (`professor_id`) REFERENCES `professor` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `module`
--

LOCK TABLES `module` WRITE;
/*!40000 ALTER TABLE `module` DISABLE KEYS */;
INSERT INTO `module` VALUES (1,'Evolution of Animals','5',1,45,100,'School of Biology'),(2,'Cell and Plant Biology','5',2,49,100,'School of Biology'),(3,'Life on Earth','10',2,12,50,'School of Biology'),(4,'Climate Change','5',1,100,100,'School of Biology'),(5,'Plant Diseases','5',1,95,100,'School of Biology');
/*!40000 ALTER TABLE `module` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `professor`
--

DROP TABLE IF EXISTS `professor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `professor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `surname` varchar(45) NOT NULL,
  `department` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `professor`
--

LOCK TABLES `professor` WRITE;
/*!40000 ALTER TABLE `professor` DISABLE KEYS */;
INSERT INTO `professor` VALUES (1,'Matthew','Shaw','School of Biology'),(2,'Mark','Maxwell','School of Biology');
/*!40000 ALTER TABLE `professor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `surname` varchar(45) NOT NULL,
  `date_of_birth` varchar(45) NOT NULL,
  `nationality` varchar(45) NOT NULL,
  `sex` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'Joseph    ','Freeman     ','2000-07-','English','male'),(2,'Genette','Rennell','2000-07-22','Native American','female'),(3,'Delilah','Strange','1998-05-02','Native American','female'),(4,'Octavia','Causey','1998-06-03','Native American','female'),(5,'Karina','Kendal','1996-12-19','Native American','female'),(6,'Leola','Boone','1995-03-01','Native American','female'),(7,'Wisdom','Bates','2001-09-21','African','male'),(8,'Raymond','Durand','2000-08-08','African','male'),(9,'Braylon','Garbutt','2000-07-11','English','male'),(10,'Benjamin','Auteberry','2002-04-10','English','male');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_has_module`
--

DROP TABLE IF EXISTS `student_has_module`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_has_module` (
  `student_id` int NOT NULL,
  `module_id` int NOT NULL,
  `grade` int DEFAULT NULL,
  PRIMARY KEY (`student_id`,`module_id`),
  KEY `fk_student_has_module_module1_idx` (`module_id`),
  KEY `fk_student_has_module_student1_idx` (`student_id`),
  CONSTRAINT `fk_student_has_module_module1` FOREIGN KEY (`module_id`) REFERENCES `module` (`id`),
  CONSTRAINT `fk_student_has_module_student1` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_has_module`
--

LOCK TABLES `student_has_module` WRITE;
/*!40000 ALTER TABLE `student_has_module` DISABLE KEYS */;
INSERT INTO `student_has_module` VALUES (1,1,0),(1,2,0),(2,2,0),(2,3,0),(8,4,0),(10,1,0),(10,5,0);
/*!40000 ALTER TABLE `student_has_module` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `topics`
--

DROP TABLE IF EXISTS `topics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `topics` (
  `idtopics` int NOT NULL,
  `title` varchar(300) DEFAULT NULL,
  `grade_distribution` int DEFAULT NULL,
  `module_id` int NOT NULL,
  PRIMARY KEY (`idtopics`),
  KEY `fk_topics_module_idx` (`module_id`),
  CONSTRAINT `fk_topics_module` FOREIGN KEY (`module_id`) REFERENCES `module` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topics`
--

LOCK TABLES `topics` WRITE;
/*!40000 ALTER TABLE `topics` DISABLE KEYS */;
INSERT INTO `topics` VALUES (1,'Distinguish between and explain the diversity within the major groups of animals.',1,1),(2,'Describe the basic physiological processes in animals.',1,1),(3,'Understand the key principles of plants’ interactions with biotic components of ecosystems.',1,2),(4,'Link structure (cell, organ) to function and identify major tissues in plants using light microscopy.',1,2),(5,'Use a dichotomous key to identify an unknown organism.',0,3),(6,'Lab Report: Reports for in-laboratory practical exercise in recognising mechanisms of adaptation.',1,3),(7,'Handle, dissect and make accurate drawings of biological specimens.',0,3),(8,'Diagnose and identify the principal causes of crop diseases using macroscopic, microscopic and molecular techniques.',0,5),(9,'Explain how plant pathogens build up to cause epidemics on field crops.',0,5),(10,'Multiple Choice Questionnaire: different plant diseases.',1,5),(11,'Tutorial topic: rebuttal of misconceptions on climate change',0,4),(12,'Tutorial topic:  rural farm system.',0,4),(13,'Tutorial topic: vegetarianism.',0,4),(14,'Tutorial topic:  carbon navigator.',0,4),(15,'Assignment: Individual two page referenced write up of one of the topics.',0,4);
/*!40000 ALTER TABLE `topics` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'studentdb'
--

--
-- Dumping routines for database 'studentdb'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-02-26 16:00:35
