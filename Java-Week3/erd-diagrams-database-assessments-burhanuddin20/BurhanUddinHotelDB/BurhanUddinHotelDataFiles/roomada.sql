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
-- Table structure for table `roomadaaccessible`
--

DROP TABLE IF EXISTS `roomadaaccessible`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roomadaaccessible` (
  `adaAccessibleId` int NOT NULL,
  `roomNum` int NOT NULL,
  PRIMARY KEY (`adaAccessibleId`,`roomNum`),
  KEY `fk_roomAdaAccessible_roomNum` (`roomNum`),
  CONSTRAINT `roomadaaccessible_ibfk_1` FOREIGN KEY (`adaAccessibleId`) REFERENCES `adaaccessible` (`adaAccessibleId`),
  CONSTRAINT `roomadaaccessible_ibfk_2` FOREIGN KEY (`roomNum`) REFERENCES `room` (`roomNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roomadaaccessible`
--

LOCK TABLES `roomadaaccessible` WRITE;
/*!40000 ALTER TABLE `roomadaaccessible` DISABLE KEYS */;
INSERT INTO `roomadaaccessible` VALUES (2,201),(1,202),(2,203),(1,204),(2,205),(1,206),(2,207),(1,208),(2,301),(1,302),(2,303),(1,304),(2,305),(1,306),(2,307),(1,308),(1,401),(1,402);
/*!40000 ALTER TABLE `roomadaaccessible` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-08 18:39:57
