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
-- Table structure for table `doctor`
--

DROP TABLE IF EXISTS `doctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctor` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `datetime` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `image_path` varchar(255) DEFAULT NULL,
  `id_client` bigint DEFAULT NULL,
  `id_speciality` bigint DEFAULT NULL,
  `examination_price` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKn43q7dw2nkwrt0o4bwv7impu2` (`id_client`),
  KEY `FKth8nc9mtk2799h5iesj6xp19l` (`id_speciality`),
  CONSTRAINT `FKn43q7dw2nkwrt0o4bwv7impu2` FOREIGN KEY (`id_client`) REFERENCES `client` (`id`),
  CONSTRAINT `FKth8nc9mtk2799h5iesj6xp19l` FOREIGN KEY (`id_speciality`) REFERENCES `speciality` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctor`
--

LOCK TABLES `doctor` WRITE;
/*!40000 ALTER TABLE `doctor` DISABLE KEYS */;
INSERT INTO `doctor` VALUES (1,'2025-04-12 16:02:56.087095','nhiet huyet tan tam','https://benhvienphuongdong.vn/public/uploads/doi-ngu-bac-si/thumbs/500x0/bs-han-van-ba_2.png',1,2,300000),(2,'2025-04-12 15:40:54.922446','Tận tâm nhiệt huyết','https://benhvienphuongdong.vn/public/uploads/doi-ngu-bac-si/thumbs/500x0/bs-nguyen-trung-chinh_4.png',3,2,100000),(3,'2025-04-20 12:42:34.847306','nhiet huyet, tan tam','https://benhvienphuongdong.vn/public/uploads/doi-ngu-bac-si/thumbs/500x0/bs-nguyen-trung-chinh_4.png',6,7,400000),(4,'2025-04-20 16:57:39.262852','nhiet huyet, tan tam','https://benhvienphuongdong.vn/public/uploads/doi-ngu-bac-si/thumbs/500x0/bs-nguyen-trung-chinh_4.png',7,8,500000),(5,'2025-04-20 16:59:23.971743','nhiet huyet, tan tam','https://benhvienphuongdong.vn/public/uploads/doi-ngu-bac-si/thumbs/500x0/bs-nguyen-trung-chinh_4.png',10,10,50000),(6,'2025-04-20 16:59:34.435849','nhiet huyet, tan tam','https://benhvienphuongdong.vn/public/uploads/doi-ngu-bac-si/thumbs/500x0/bs-nguyen-trung-chinh_4.png',21,7,50000),(7,'2025-04-20 16:59:44.700533','nhiet huyet, tan tam','https://benhvienphuongdong.vn/public/uploads/doi-ngu-bac-si/thumbs/500x0/bs-nguyen-trung-chinh_4.png',30,1,50000),(8,'2025-04-20 17:00:07.015535','nhiet huyet, tan tam','https://benhvienphuongdong.vn/public/uploads/doi-ngu-bac-si/thumbs/500x0/bs-nguyen-trung-chinh_4.png',33,6,50000),(9,'2025-04-20 17:00:16.133102','nhiet huyet, tan tam','https://benhvienphuongdong.vn/public/uploads/doi-ngu-bac-si/thumbs/500x0/bs-nguyen-trung-chinh_4.png',25,6,50000),(10,'2025-04-22 10:46:54.611440','nhiet huyet, tan tam','https://benhvienphuongdong.vn/public/uploads/doi-ngu-bac-si/thumbs/500x0/bs-nguyen-trung-chinh_4.png',14,8,50000);
/*!40000 ALTER TABLE `doctor` ENABLE KEYS */;
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
