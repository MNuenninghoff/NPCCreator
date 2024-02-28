-- MySQL dump 10.13  Distrib 8.1.0, for macos14.0 (arm64)
--
-- Host: 127.0.0.1    Database: npc_test
-- ------------------------------------------------------
-- Server version	8.1.0

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
-- Table structure for table `ability`
--
DROP TABLE IF EXISTS `npc`;
DROP TABLE IF EXISTS `ability`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ability` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ability` varchar(70) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ability`
--

LOCK TABLES `ability` WRITE;
/*!40000 ALTER TABLE `ability` DISABLE KEYS */;
INSERT INTO `ability` VALUES (1,'High Strength - powerful, brawny'),(2,'High Dexterity - lithe, agile, graceful'),(3,'High Constitution - hardy, hale, healthy'),(4,'High Intelligence - studeious, learned, inquisitive'),(5,'High Wisdom - perceptive, spiritual, insightful'),(6,'High Charisma - persuasive, forceful, born leader'),(7,'Low Strength - feeble, scrawny'),(8,'Low Dexterity - clumsy'),(9,'Low Constitution - sickly'),(10,'Low Wisdom - oblivious, absentminded'),(11,'Low Charisma - dull, boring');
/*!40000 ALTER TABLE `ability` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `appearance`
--

DROP TABLE IF EXISTS `appearance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `appearance` (
  `id` int NOT NULL AUTO_INCREMENT,
  `appearance` varchar(70) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appearance`
--

LOCK TABLES `appearance` WRITE;
/*!40000 ALTER TABLE `appearance` DISABLE KEYS */;
INSERT INTO `appearance` VALUES (1,'Distinctive jewelry: earrings, necklace, circlet, bracelets'),(2,'Piercings'),(3,'Flamboyant or outlandish clothes'),(4,'Formal, clean clothes'),(5,'Ragged, dirty clothes'),(6,'Pronounced scar'),(7,'Missing teeth'),(8,'Missing fingers'),(9,'Unusual eye color (or two different colors)'),(10,'Tattoos'),(11,'Birthmark'),(12,'Unusual skin color'),(13,'Bald'),(14,'Braided beard or hair'),(15,'Unusual hair color'),(16,'Nervous eye twitch'),(17,'Distinctive nose'),(18,'Distinctive posture (crooked or rigid)'),(19,'Exceptionally beautiful'),(20,'Exceptionally ugly');
/*!40000 ALTER TABLE `appearance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Interaction_Traits`
--

DROP TABLE IF EXISTS `Interaction_Traits`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Interaction_Traits` (
  `id` int NOT NULL AUTO_INCREMENT,
  `trait` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Interaction_Traits`
--

LOCK TABLES `Interaction_Traits` WRITE;
/*!40000 ALTER TABLE `Interaction_Traits` DISABLE KEYS */;
INSERT INTO `Interaction_Traits` VALUES (1,'Argumentative'),(2,'Arrogant'),(3,'Blustering'),(4,'Rude'),(5,'Curious'),(6,'Friendly'),(7,'Honest'),(8,'Hot tempered'),(9,'Ponderous'),(10,'Quiet'),(11,'Suspicious'),(12,'Tired');
/*!40000 ALTER TABLE `Interaction_Traits` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `npc`
--

DROP TABLE IF EXISTS `npc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `npc` (
  `id` int NOT NULL AUTO_INCREMENT,
  `interaction_traits` int DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `ability` int DEFAULT NULL,
  `appearance` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `interaction_traits_fk` (`interaction_traits`),
  KEY `npc_appearance_id_fk` (`appearance`),
  KEY `npc_ability_id_fk` (`ability`),
  CONSTRAINT `interaction_traits_fk` FOREIGN KEY (`interaction_traits`) REFERENCES `Interaction_Traits` (`id`),
  CONSTRAINT `npc_ability_id_fk` FOREIGN KEY (`ability`) REFERENCES `ability` (`id`),
  CONSTRAINT `npc_appearance_id_fk` FOREIGN KEY (`appearance`) REFERENCES `appearance` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `npc`
--

LOCK TABLES `npc` WRITE;
/*!40000 ALTER TABLE `npc` DISABLE KEYS */;
INSERT INTO `npc` VALUES (1,2,'barkeep','bob',1,NULL),(2,4,'merchant','mary',2,NULL),(3,6,'innkeeper','Ingrid',3,NULL),(4,2,'bookseller','Bryan',4,NULL);
/*!40000 ALTER TABLE `npc` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-28 17:15:17
