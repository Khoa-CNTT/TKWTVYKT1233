CREATE DATABASE  IF NOT EXISTS `medicalwebsite` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `medicalwebsite`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: medicalwebsite
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `appointment`
--

DROP TABLE IF EXISTS `appointment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `appointment` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `issue_description` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `id_consulation_schedule` bigint DEFAULT NULL,
  `birth_date` varchar(255) DEFAULT NULL,
  `date_appointment` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpigpadw7k2f3b2xpdyevbb9uq` (`id_consulation_schedule`),
  CONSTRAINT `FKpigpadw7k2f3b2xpdyevbb9uq` FOREIGN KEY (`id_consulation_schedule`) REFERENCES `consultation_schedule` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointment`
--

LOCK TABLES `appointment` WRITE;
/*!40000 ALTER TABLE `appointment` DISABLE KEYS */;
INSERT INTO `appointment` VALUES (66,'Liên chiểu','hung789@gmail.com','Nguyen Duc Hung','Nữ','Đau lưng','0918890797','COMPLETED',1386,'2006-12-12','2025-05-06 23:42:46.675834'),(67,'Liên chiểu','hung789@gmail.com','Nguyễn Miĩ hạnh','Nữ','Mệt mỏi','0918890797','PENDING',1141,'2004-12-12','2025-05-06 23:44:05.495395'),(68,'Liên chiểu','hung789@gmail.com','Le minh dung','Nữ','Dau lung','0918890797','PENDING',936,'2004-12-12','2025-05-08 20:36:49.588681'),(71,'Le Huu Tho k7/38','thanhnam23@gmail.com','ThanhNam','Nam','Tôi hay bị ho và chóng mặt','0123456789','CANCELLED',1825,'14-05-2006','2025-05-09 02:52:50.092581'),(72,'Liên chiểu','hung789@gmail.com','Nguyen Duc Hung','Nam','Đau lưng','0123456789','CONFIRMED',411,'2004-12-12','2025-05-09 03:09:25.923506'),(73,'Đà nẵng','hung789@gmail.com','Nguyen Duc Hung','Nam','Đau lưng','0918890797','CANCELLED',1042,'2004-12-12','2025-05-09 03:39:34.933229'),(82,'Thanh khê','hung789@gmail.com','Nguyen Duc Hung','Nam','Đau lưng','0918890797','CANCELLED',1147,'2004-12-12','2025-05-09 23:25:39.976977'),(83,'Liên chiểu','hung789@gmail.com','Nguyen Duc Hung','Nam','Đau lưng','0918890797','CANCELLED',1442,'2004-12-12','2025-05-09 23:52:04.527515'),(84,'Đà nẵng','hung789@gmail.com','Mr.Tom','Nam','Đau lưng','0918890797','CANCELLED',937,'2006-12-12','2025-05-10 00:06:12.782414'),(85,'Liên chiểu','hung789@gmail.com','Nguyen Duc Hung','Nam','Đau lưng','0918890797','CANCELLED',306,'2004-12-12','2025-05-10 00:07:46.622284'),(86,'Liên chiểu','hung789@gmail.com','Nguyen Duc Hung','Nam','Đau lưng','0918890797','CANCELLED',1237,'2006-12-12','2025-05-10 00:08:46.798960'),(87,'Liên chiểu','hung789@gmail.com','Nguyen Duc Hung','Nam','Đau lưng','0918890797','CANCELLED',96,'2006-12-12','2025-05-10 00:58:39.741046'),(88,'Liên chiểu','hung789@gmail.com','Nguyen Duc Hung','Nam','Đà nẵng','0918890797','CANCELLED',1816,'2004-12-12','2025-05-10 00:58:55.637215'),(89,'Liên chiểu','hung789@gmail.com','Nguyen Duc Hung','Nam','Đau lưng','0918890797','CANCELLED',1161,'2004-12-12','2025-05-10 00:59:12.351638');
/*!40000 ALTER TABLE `appointment` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-10  1:18:35
