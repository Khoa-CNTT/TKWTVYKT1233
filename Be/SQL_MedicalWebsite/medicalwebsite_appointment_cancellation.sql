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
-- Table structure for table `appointment_cancellation`
--

DROP TABLE IF EXISTS `appointment_cancellation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `appointment_cancellation` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `create_at` datetime(6) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `id_payment` bigint DEFAULT NULL,
  `refund` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK12a4bbl6q9iiffbka71phfpt0` (`id_payment`),
  CONSTRAINT `FK12a4bbl6q9iiffbka71phfpt0` FOREIGN KEY (`id_payment`) REFERENCES `payment` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointment_cancellation`
--

LOCK TABLES `appointment_cancellation` WRITE;
/*!40000 ALTER TABLE `appointment_cancellation` DISABLE KEYS */;
INSERT INTO `appointment_cancellation` VALUES (3,'2025-05-09 23:34:27.108331','Appointment Cancel',32,25000),(4,'2025-05-09 23:47:23.828534','Appointment Cancel',32,25000),(5,'2025-05-09 23:52:12.218256','Appointment Cancel',33,25000),(6,'2025-05-10 00:06:45.073367','Appointment Cancel',34,25000),(7,'2025-05-10 00:11:11.206863','Appointment Cancel',36,200000),(8,'2025-05-10 00:11:13.118756','Appointment Cancel',35,200000),(9,'2025-05-10 01:00:01.888109','Appointment Cancel',39,150000),(10,'2025-05-10 01:00:04.566918','Appointment Cancel',38,150000),(11,'2025-05-10 01:00:11.814367','Appointment Cancel',37,150000);
/*!40000 ALTER TABLE `appointment_cancellation` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-10  1:18:34
