-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: hiperpuntosdb
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `customers` (
  `cus_id` int(11) NOT NULL AUTO_INCREMENT,
  `cus_dni` int(11) NOT NULL,
  `cus_name` varchar(45) NOT NULL,
  `cus_last_name` varchar(45) NOT NULL,
  `cus_phone` varchar(45) NOT NULL,
  `cus_email` varchar(45) NOT NULL,
  `cus_point` int(11) DEFAULT NULL,
  PRIMARY KEY (`cus_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (9,34561919,'Maximiliano','Pavolini','0351-3514898','maxi@gmail.com',9940),(10,41333456,'Emanuel','Valdiviezo','0351-15123567','ema@hotmail.com',10);
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `products` (
  `pro_id` int(11) NOT NULL AUTO_INCREMENT,
  `pro_code` int(11) NOT NULL,
  `pro_description` varchar(45) NOT NULL,
  `pro_stock` int(11) NOT NULL,
  `pro_point` int(11) DEFAULT NULL,
  PRIMARY KEY (`pro_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (5,10,'Alfajor',92,30),(6,20,'Caramelo',2,60),(7,30,'Gaseosa',100,1);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchases_orders`
--

DROP TABLE IF EXISTS `purchases_orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `purchases_orders` (
  `pur_id` int(11) NOT NULL AUTO_INCREMENT,
  `pro_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`pur_id`),
  KEY `pur_pro_fk_idx` (`pro_id`),
  CONSTRAINT `pur_pro_fk` FOREIGN KEY (`pro_id`) REFERENCES `products` (`pro_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchases_orders`
--

LOCK TABLES `purchases_orders` WRITE;
/*!40000 ALTER TABLE `purchases_orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchases_orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `temporals`
--

DROP TABLE IF EXISTS `temporals`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `temporals` (
  `tem_id` int(11) NOT NULL AUTO_INCREMENT,
  `tem_dni` int(11) NOT NULL,
  `tem_point` int(11) NOT NULL,
  PRIMARY KEY (`tem_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `temporals`
--

LOCK TABLES `temporals` WRITE;
/*!40000 ALTER TABLE `temporals` DISABLE KEYS */;
INSERT INTO `temporals` VALUES (1,34561919,35),(2,34561919,12),(3,34561919,43),(4,34561919,56),(5,41333456,65),(6,41333456,88);
/*!40000 ALTER TABLE `temporals` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transactions`
--

DROP TABLE IF EXISTS `transactions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `transactions` (
  `tra_id` int(11) NOT NULL AUTO_INCREMENT,
  `cus_id` int(11) DEFAULT NULL,
  `pro_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`tra_id`),
  KEY `fk_custid_idx` (`cus_id`),
  KEY `fk_proid_idx` (`pro_id`),
  CONSTRAINT `cus_tra_fk` FOREIGN KEY (`cus_id`) REFERENCES `customers` (`cus_id`),
  CONSTRAINT `pro_tra_fk` FOREIGN KEY (`pro_id`) REFERENCES `products` (`pro_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transactions`
--

LOCK TABLES `transactions` WRITE;
/*!40000 ALTER TABLE `transactions` DISABLE KEYS */;
INSERT INTO `transactions` VALUES (1,9,5),(2,9,6),(3,9,6);
/*!40000 ALTER TABLE `transactions` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-10 22:48:22
