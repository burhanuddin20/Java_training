-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: BurhanUddinHotelDB
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `roomamenities`
--

DROP TABLE IF EXISTS `roomamenities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roomamenities` (
  `roomAmenitiesId` int NOT NULL,
  `amenitiesId` int NOT NULL,
  `roomNum` int NOT NULL,
  PRIMARY KEY (`roomAmenitiesId`),
  KEY `fk_roomAmenities_amenitiesId` (`amenitiesId`),
  KEY `fk_roomAmenities_roomNum` (`roomNum`),
  CONSTRAINT `roomamenities_ibfk_1` FOREIGN KEY (`amenitiesId`) REFERENCES `amenities` (`amenitiesId`),
  CONSTRAINT `roomamenities_ibfk_2` FOREIGN KEY (`roomNum`) REFERENCES `room` (`roomNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roomamenities`
--

LOCK TABLES `roomamenities` WRITE;
/*!40000 ALTER TABLE `roomamenities` DISABLE KEYS */;
INSERT INTO `roomamenities` VALUES (1,1,201),(2,2,201),(3,3,202),(4,2,203),(5,1,203),(6,3,204),(7,3,205),(8,2,205),(9,1,205),(10,1,206),(11,3,206),(12,1,207),(13,3,207),(14,2,207),(15,3,208),(16,1,208),(17,2,301),(18,1,301),(19,3,302),(20,1,303),(21,2,303),(22,3,304),(23,3,305),(24,2,305),(25,1,305),(26,1,306),(27,3,306),(28,1,307),(29,2,307),(30,3,307),(31,1,308),(32,3,308),(33,4,401),(34,3,401),(35,1,401),(36,1,402),(37,3,402),(38,4,402);
/*!40000 ALTER TABLE `roomamenities` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-08 19:12:03
