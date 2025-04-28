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
-- Table structure for table `medical_type`
--

DROP TABLE IF EXISTS `medical_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medical_type` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `create_at` datetime(6) DEFAULT NULL,
  `name_service` varchar(120) DEFAULT NULL,
  `image_path` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medical_type`
--

LOCK TABLES `medical_type` WRITE;
/*!40000 ALTER TABLE `medical_type` DISABLE KEYS */;
INSERT INTO `medical_type` VALUES (4,'2025-04-22 10:49:37.475501','Gói khám Tổng quát','https://th.bing.com/th/id/OIP.CkSM5kBhfDxzJrNydhEJCwHaE8?rs=1&pid=ImgDetMain',50000,'giúp bạn đánh giá toàn diện tình trạng sức khỏe hiện tại thông qua các xét nghiệm'),(5,'2025-04-22 10:50:24.067948','Gói khám Tổng quát','https://th.bing.com/th/id/OIP.ff7i3P5hNN3BG_DPTxVJLQHaE8?rs=1&pid=ImgDetMain',50000,'giúp bạn đánh giá toàn diện tình trạng sức khỏe hiện tại thông qua các xét nghiệm'),(6,'2025-04-22 10:51:16.191008','Gói khám Xét nghiệm','https://th.bing.com/th/id/OIP.K50IY76qO58qnn0iaD5XPgHaE7?rs=1&pid=ImgDetMain',50000,'giúp bạn đánh giá toàn diện tình trạng sức khỏe hiện tại thông qua các xét nghiệm'),(7,'2025-04-22 10:51:44.833479','Gói khám Xét nghiệm','https://th.bing.com/th/id/OIP.bId0qoeLSijQIZzeYEuc0wHaE7?w=800&h=533&rs=1&pid=ImgDetMain',50000,'giúp bạn đánh giá toàn diện tình trạng sức khỏe hiện tại thông qua các xét nghiệm'),(8,'2025-04-22 10:51:52.571703','Gói khám Xét nghiệm','https://th.bing.com/th/id/OIP.urOAaZAWMzvIysigOOEvdwHaEs?w=626&h=397&rs=1&pid=ImgDetMain',50000,'giúp bạn đánh giá toàn diện tình trạng sức khỏe hiện tại thông qua các xét nghiệm'),(9,'2025-04-22 10:52:23.145777','Gói khám Phẫu Thuật','https://th.bing.com/th/id/OIP.geSd-IB9ly5BE---0BgHjQHaEK?rs=1&pid=ImgDetMain',50000,'giúp bạn đánh giá toàn diện tình trạng sức khỏe hiện tại thông qua các xét nghiệm'),(10,'2025-04-22 10:53:20.280554','Gói khám Phẫu Thuật','https://th.bing.com/th/id/OIP.OZPxGA0Yjk6Ng4oMM2kZzAHaE8?w=600&h=400&rs=1&pid=ImgDetMain',50000,'giúp bạn đánh giá toàn diện tình trạng sức khỏe hiện tại thông qua các xét nghiệm'),(11,'2025-04-22 10:53:38.627283','Gói khám Phẫu Thuật','https://th.bing.com/th/id/OIP.DEcOViduvg7QrQT_KG9EJgHaEA?w=768&h=416&rs=1&pid=ImgDetMain',50000,'giúp bạn đánh giá toàn diện tình trạng sức khỏe hiện tại thông qua các xét nghiệm'),(12,'2025-04-22 10:54:11.396269','Gói khám Siêu âm','https://th.bing.com/th/id/OIP.cUUagTVD6Ag8gut9rZCpRgHaGU?rs=1&pid=ImgDetMain',50000,'giúp bạn đánh giá toàn diện tình trạng sức khỏe hiện tại thông qua các xét nghiệm'),(13,'2025-04-22 10:55:00.817555','Gói khám Siêu âm','https://th.bing.com/th/id/OIP.T9Zbv5f6fRxe9XrgPXbmrQHaFW?w=1600&h=1157&rs=1&pid=ImgDetMain',50000,'giúp bạn đánh giá toàn diện tình trạng sức khỏe hiện tại thông qua các xét nghiệm'),(14,'2025-04-22 11:28:47.702219','Gói khám Ung thư','https://th.bing.com/th/id/OIP.fGTe_eZxF2k96c-dxsZpngHaFz?rs=1&pid=ImgDetMain',50000,'giúp bạn đánh giá toàn diện tình trạng sức khỏe hiện tại thông qua các xét nghiệm'),(15,'2025-04-22 10:55:28.417756','Gói khám Ung thư','https://img.freepik.com/premium-photo/closeup-cancer-cell-different-bacteria-view-microscope-various-virus-attack-shell-tumor_124507-11142.jpg?w=2000',50000,'giúp bạn đánh giá toàn diện tình trạng sức khỏe hiện tại thông qua các xét nghiệm');
/*!40000 ALTER TABLE `medical_type` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-04-26 15:59:27
