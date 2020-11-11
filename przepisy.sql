-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: przepisy
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categories` (
  `id` char(36) NOT NULL,
  `code` varchar(20) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  `active` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_UNIQUE` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comments` (
  `id` char(36) NOT NULL,
  `id_recipe` char(36) NOT NULL,
  `id_user` char(36) NOT NULL,
  `description` text NOT NULL,
  `data` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_COM_RECIPE_idx` (`id_recipe`),
  KEY `FK_COM_USER_idx` (`id_user`),
  CONSTRAINT `FK_COM_RECIPE` FOREIGN KEY (`id_recipe`) REFERENCES `recipes_header` (`id`),
  CONSTRAINT `FK_COM_USER` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comments`
--

LOCK TABLES `comments` WRITE;
/*!40000 ALTER TABLE `comments` DISABLE KEYS */;
/*!40000 ALTER TABLE `comments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `components`
--

DROP TABLE IF EXISTS `components`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `components` (
  `id` char(36) NOT NULL,
  `id_categories` char(36) NOT NULL,
  `id_unit` char(36) NOT NULL,
  `code` varchar(20) NOT NULL,
  `description` varchar(50) DEFAULT NULL,
  `active` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `FK_CC_CAT_idx` (`id_unit`),
  KEY `FK_COMP_CAT_idx` (`id_categories`),
  CONSTRAINT `FK_COMP_CAT` FOREIGN KEY (`id_categories`) REFERENCES `categories` (`id`),
  CONSTRAINT `FK_COMP_UNITS` FOREIGN KEY (`id_unit`) REFERENCES `units` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `components`
--

LOCK TABLES `components` WRITE;
/*!40000 ALTER TABLE `components` DISABLE KEYS */;
/*!40000 ALTER TABLE `components` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `favourite`
--

DROP TABLE IF EXISTS `favourite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `favourite` (
  `id` char(36) NOT NULL,
  `recipe_header_id` char(36) NOT NULL,
  `user_id` char(36) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_FAV_USER_idx` (`user_id`),
  KEY `FK_FAV_RECIPE_H_idx` (`recipe_header_id`),
  CONSTRAINT `FK_FAV_RECIPE_H` FOREIGN KEY (`recipe_header_id`) REFERENCES `recipes_header` (`id`),
  CONSTRAINT `FK_FAV_USER` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `favourite`
--

LOCK TABLES `favourite` WRITE;
/*!40000 ALTER TABLE `favourite` DISABLE KEYS */;
/*!40000 ALTER TABLE `favourite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `premium`
--

DROP TABLE IF EXISTS `premium`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `premium` (
  `id` char(36) NOT NULL,
  `id_user` char(36) NOT NULL,
  `day_start` datetime NOT NULL,
  `day_end` datetime NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_PREM_USER_idx` (`id_user`),
  CONSTRAINT `FK_PREM_USER` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `premium`
--

LOCK TABLES `premium` WRITE;
/*!40000 ALTER TABLE `premium` DISABLE KEYS */;
/*!40000 ALTER TABLE `premium` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rates`
--

DROP TABLE IF EXISTS `rates`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rates` (
  `id` char(36) NOT NULL,
  `id_recipe` char(36) NOT NULL,
  `rate` int NOT NULL,
  `id_user` char(36) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_RAT_RECIPE_idx` (`id_recipe`),
  KEY `FK_RAT_USER_idx` (`id_user`),
  CONSTRAINT `FK_RAT_RECIPE` FOREIGN KEY (`id_recipe`) REFERENCES `recipes_header` (`id`),
  CONSTRAINT `FK_RAT_USER` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rates`
--

LOCK TABLES `rates` WRITE;
/*!40000 ALTER TABLE `rates` DISABLE KEYS */;
/*!40000 ALTER TABLE `rates` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recipes_header`
--

DROP TABLE IF EXISTS `recipes_header`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recipes_header` (
  `id` char(36) NOT NULL,
  `name` varchar(50) NOT NULL,
  `description` varchar(50) DEFAULT NULL,
  `active` int NOT NULL,
  `id_user` char(36) NOT NULL,
  `data_creation` date DEFAULT NULL,
  `video_link` varchar(255) DEFAULT NULL,
  `note` text,
  `photo_path` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `FK_RECH_USER_idx` (`id_user`),
  CONSTRAINT `FK_RECH_USER` FOREIGN KEY (`id_user`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipes_header`
--

LOCK TABLES `recipes_header` WRITE;
/*!40000 ALTER TABLE `recipes_header` DISABLE KEYS */;
/*!40000 ALTER TABLE `recipes_header` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recipes_row`
--

DROP TABLE IF EXISTS `recipes_row`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recipes_row` (
  `id` char(36) NOT NULL,
  `id_recipe` char(36) NOT NULL,
  `id_componente` char(36) NOT NULL,
  `componente_qta` float NOT NULL,
  `componente_pos` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `FK_RECR_RECIPEHEADER_idx` (`id_recipe`),
  KEY `FK_RECR_COMPONENTE_idx` (`id_componente`),
  CONSTRAINT `FK_RECR_COMPONENTE` FOREIGN KEY (`id_componente`) REFERENCES `components` (`id`),
  CONSTRAINT `FK_RECR_RECIPEHEADER` FOREIGN KEY (`id_recipe`) REFERENCES `recipes_header` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipes_row`
--

LOCK TABLES `recipes_row` WRITE;
/*!40000 ALTER TABLE `recipes_row` DISABLE KEYS */;
/*!40000 ALTER TABLE `recipes_row` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `units`
--

DROP TABLE IF EXISTS `units`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `units` (
  `id` char(36) NOT NULL,
  `code` varchar(25) NOT NULL,
  `description` varchar(70) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `units`
--

LOCK TABLES `units` WRITE;
/*!40000 ALTER TABLE `units` DISABLE KEYS */;
INSERT INTO `units` VALUES ('49bcf9b1-5a24-4189-b4b7-6bf8203335c6','kg','Kilogram'),('84dd65e1-b510-4245-b452-1f97858dd01b','mm','milimetr'),('a35b6a69-fe0f-44c2-b9aa-00b77a6c92cf','cm','centymetr');
/*!40000 ALTER TABLE `units` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` char(36) NOT NULL,
  `login` varchar(30) NOT NULL,
  `password` varchar(64) NOT NULL,
  `name` varchar(40) NOT NULL,
  `email` varchar(55) NOT NULL,
  `active` int NOT NULL,
  `admin` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `login_UNIQUE` (`login`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('545a15cf-90b5-4181-91f3-5344c351ac3f','Jarek','fd35cc36b83015844a387a57f709a027be10a54691b9606c0d84d263bcfd6bb2','Jarek','aquillanie@gmail.com',1,0);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-11 19:06:22
