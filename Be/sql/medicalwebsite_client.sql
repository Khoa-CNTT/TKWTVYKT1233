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
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `full_name` varchar(50) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `role` varchar(50) DEFAULT NULL,
  `is_clock` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,'Nguyen Huu Tho','2025-04-11 23:25:33.491228','jun03@gmail.com','Mr.Jun','123456','123456789','ROLE_DOCTOR',_binary '\0'),(2,'Le Huu Tho k7/38','2025-04-11 23:28:02.989257','HungXL@gmail.com','Nguyen Duc Hung','456789','0123456789','ROLE_USER',_binary '\0'),(3,'Le Duan ','2025-04-12 14:48:20.202094','Tantai03@gmail.com','Nguyen Tan Tai','123456','0456789321','ROLE_DOCTOR',_binary '\0'),(4,'Le Duan ','2025-04-12 14:48:46.004840','thanhnam23@gmail.com','Nguyen Thanh Nam','123456','125478963','ROLE_USER',_binary '\0'),(5,'Son Tra ','2025-04-18 10:01:02.123773','phuctam72003@gmail.com','Ho Phuc Tam','123456','0128756789','ROLE_USER',_binary '\0'),(6,'Son Tra ','2025-04-18 13:22:50.768860','kieumy9872@gmail.com','Nguyen kieu my ','123456','0128756789','ROLE_DOCTOR',_binary '\0'),(7,'Son Tra ','2025-04-19 12:47:07.228191','dinhcong03@gmail.com','Nguyễn Đình Công','123456','0128756789','ROLE_DOCTOR',_binary '\0'),(8,'Son Tra','2025-04-19 13:33:42.208282','KieuMy123123123@gmail.com','Nguyen Thanh kieu my','123','0123456789','ROLE_USER',_binary '\0'),(10,'Thanh Khê','2025-04-19 13:38:17.837487','ThanhKieu@gmail.com','Nguyễn Thanh Kiều','123','0123456789','ROLE_DOCTOR',_binary '\0'),(11,'Thanh Khê','2025-04-19 13:43:35.488235','thanhhung003@gmail.com','Nguyễn Thành Hưng','123','0123456789','ROLE_USER',_binary '\0'),(14,'Sơn Trà Đà Nẵng','2025-04-19 14:39:12.898388','nguyenPhan@gmail.com','Nguyễn Phan','123','0213654789','ROLE_DOCTOR',_binary '\0'),(15,'Sơn Trà Đà Nẵng','2025-04-19 14:40:03.798139','nguyenPhan23@gmail.com','Nguyễn Phan','123','0213654789','ROLE_USER',_binary '\0'),(16,'Sơn Trà Đà Nẵng','2025-04-19 14:47:24.271383','PhanMinh@gmail.com','Phan Minh','123','0213654789','ROLE_USER',_binary '\0'),(17,'Sơn Trà Đà Nẵng','2025-04-19 14:48:26.151966','PhanMinh12@gmail.com','Phan Minh','123','0213654789','ROLE_USER',_binary '\0'),(18,'Lê Duẩn','2025-04-19 14:54:40.175562','tantai03@gmail.com','Tan tai','abc123','0213654789','ROLE_USER',_binary '\0'),(19,'Lê Duẩn','2025-04-19 14:56:30.222457','tantai032@gmail.com','Tan tai','123','0213654789','ROLE_USER',_binary '\0'),(20,'Lê Duẩn','2025-04-19 15:08:26.470574','tt0322032@gmail.com','Tan tai','123','0213654789','ROLE_USER',_binary '\0'),(21,'Lê Duẩn','2025-04-19 15:12:48.917231','tantai03111@gmail.com','Tan tai','123','0213654789','ROLE_DOCTOR',_binary '\0'),(22,'Sơn Trà','2025-04-19 15:14:39.870893','KieuMy2003@gmail.com','Nguyễn Văn Kiều My','123','0123456789','ROLE_USER',_binary '\0'),(23,'Sơn Trà','2025-04-19 15:19:38.272442','KieuMy03@gmail.com','Nguyễn Phan Kiều My','123','0123456789','ROLE_USER',_binary '\0'),(24,'Sơn Trà','2025-04-19 16:36:52.240030','PhanMinh123@gmail.com','Lê Phan','123456','+84984427846','ROLE_USER',_binary '\0'),(25,'Sơn Trà','2025-04-19 16:38:53.477971','PhanMinh10@gmail.com','Lê Phan','123456','+84984427846','ROLE_DOCTOR',_binary '\0'),(26,'Thanh Khê','2025-04-19 16:46:57.511078','minhhoang03@gmail.com','Lê Hoàng                                 ','123123','0213654789','ROLE_USER',_binary '\0'),(27,'Thanh Khê','2025-04-19 16:47:44.344510','minh789@gmail.com','Lê Minh','123','0213654789','ROLE_USER',_binary '\0'),(28,'Sơn trà','2025-04-19 16:50:52.163003','hophuctam7112003@gmail.com','Hồ Phúc Tâm','123','0984427846','ROLE_USER',_binary '\0'),(29,'Sơn trà','2025-04-19 16:51:22.722397','minh0983123@gmail.com','Minh Mạnh','123','0984427846','ROLE_USER',_binary '\0'),(30,'Sơn Trà Đà Nẵng','2025-04-19 16:53:05.780842','PhanMinh13@gmail.com','Phan Minh','123','0984427846','ROLE_DOCTOR',_binary '\0'),(31,'Sơn Trà Đà Nẵng','2025-04-19 16:57:30.564709','PhanMinh789654@gmail.com','Phan Minh','123','0984427846','ROLE_USER',_binary '\0'),(32,'Sơn Trà Đà Nẵng','2025-04-19 17:01:25.388359','PhanMinh65@gmail.com','Phan Minh','123','0984427846','ROLE_USER',_binary '\0'),(33,'Sơn Trà Đà Nẵng','2025-04-20 14:13:23.262419','lemang03@gmail.com','Lê Mạng','123','0123456789','ROLE_DOCTOR',_binary '\0'),(34,'Sơn trà','2025-04-20 22:39:57.727435','Minhkhanh@gmail.com','Minh Khánh','123','0984427846','ROLE_USER',_binary '\0'),(35,'Sơn trà','2025-04-20 22:47:04.809177','Minhkhanh03@gmail.com','Minh Khánh','123','0984427846','ROLE_USER',_binary '\0'),(36,'Sơn trà','2025-04-20 22:56:50.604202','mang0321@gmail.com','Lê Mạng','123','0984427846','ROLE_USER',_binary '\0'),(37,'Sơn trà','2025-04-20 23:13:43.042447','mang032155@gmail.com','Lê Mạng','123','0984427846','ROLE_USER',_binary '\0'),(38,'Sơn trà','2025-04-22 12:58:13.505005','thanhnam03@gmail.com','Thanh Nam','123','0984427846','ROLE_USER',_binary '\0'),(39,'Sơn trà','2025-04-24 22:49:54.349213','hungday03@gmail.com','Nguyen Duc Hung','123','0918890797','ROLE_USER',_binary '\0'),(40,'Sơn trà','2025-04-26 13:59:19.703278','dhungit209@gmail.com','Nguyen Duc Hung','123','0918890797','ROLE_USER',_binary '\0');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-04-26 15:59:28
