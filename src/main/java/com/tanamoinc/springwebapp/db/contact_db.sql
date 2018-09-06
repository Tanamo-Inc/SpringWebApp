CREATE DATABASE  IF NOT EXISTS `contact_db` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `contact_db`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: contact_db
-- ------------------------------------------------------
-- Server version	5.6.39

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
-- Table structure for table `contact_table`
--

DROP TABLE IF EXISTS `contact_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contact_table` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `cName` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `address` varchar(150) DEFAULT NULL,
  `remark` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`_id`),
  KEY `user_fk_idx` (`userId`),
  CONSTRAINT `user_fk` FOREIGN KEY (`userId`) REFERENCES `user_table` (`_id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contact_table`
--

LOCK TABLES `contact_table` WRITE;
/*!40000 ALTER TABLE `contact_table` DISABLE KEYS */;
INSERT INTO `contact_table` VALUES (1,NULL,'Tonya','0203287292','anthonytandoh90@yahoo.com','Kumasi,Ghana','SSd'),(2,NULL,'Tony','0200200200','tanamoinc@gmail.com','Kumasi',NULL),(4,NULL,'Janet','0341352901','janet@gmail.com','Tadi,GH','Lucas '),(6,4,'Antoinette','0502233004','mensah@knust.edu.gh','Knust,Kumasi','First Medical Doctor'),(8,4,'Lucy','0341352901','lucy@gmail.com','Tadi,Ghana','Lucas Kucy'),(9,2,'Tony','0304140342','a@gmail.com','sa,Hg','wd'),(11,NULL,'Pat','0239142523','pat@gmailcom','Accra,Ghana','The Lord is Good'),(12,4,'Tanamo','032423430238','tanamoinc@gmail.com','Usa','Company');
/*!40000 ALTER TABLE `contact_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_table`
--

DROP TABLE IF EXISTS `user_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_table` (
  `_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `address` varchar(150) DEFAULT NULL,
  `loginName` varchar(45) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  `role` int(1) NOT NULL DEFAULT '2',
  `loginStatus` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`_id`),
  UNIQUE KEY `loginName_UNIQUE` (`loginName`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_table`
--

LOCK TABLES `user_table` WRITE;
/*!40000 ALTER TABLE `user_table` DISABLE KEYS */;
INSERT INTO `user_table` VALUES (2,'Tandoh Anthony','0201302034','antandoh.nsp@knustedu.gh','Kumasi, knust','tony','tony',2,1),(3,'Tanamo','020020','ta@tanamo.org','Knust','tt','tt',1,1),(4,'Tan Tan','+2330913812','an@sd.com','ds','aa','aa',2,1),(7,'Tony','3045323','a@h.com','scsv','Theo','123',2,1),(8,'Mary','0203300123','mary@gmail.com','Kumasi,Ghana','mary','1234',2,2),(9,'Janet','048372439','ja@j.net','ds','aas','aas',2,2);
/*!40000 ALTER TABLE `user_table` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-09-06 17:05:43
