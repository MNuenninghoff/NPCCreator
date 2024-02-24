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
INSERT INTO `ability` VALUES (4,'High Strength - powerful, brawny'),(5,'High Dexterity - lithe, agile, graceful'),(6,'High Constitution - hardy, hale, healthy'),(7,'High Intelligence - studeious, learned, inquisitive'),(8,'High Wisdom - perceptive, spiritual, insightful'),(9,'High Charisma - persuasive, forceful, born leader'),(10,'Low Strength - feeble, scrawny'),(11,'Low Dexterity - clumsy'),(12,'Low Constitution - sickly'),(13,'Low Wisdom - oblivious, absentminded'),(14,'Low Charisma - dull, boring');
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
-- Table structure for table `bond`
--

DROP TABLE IF EXISTS `bond`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bond` (
  `id` int NOT NULL AUTO_INCREMENT,
  `bond` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bond`
--

LOCK TABLES `bond` WRITE;
/*!40000 ALTER TABLE `bond` DISABLE KEYS */;
INSERT INTO `bond` VALUES (1,'Dedicated to fulfilling a personal life goal'),(2,'Protective of close family members'),(3,'Protective of colleagues or compatriots'),(4,'Loyal to a benefactor, patron, or employer'),(5,'Captivated by a romantic interest'),(6,'Drawn to a special place'),(7,'Protective of a sentimental keepsake'),(8,'Protective of a valuable possession'),(9,'Out for revenge');
/*!40000 ALTER TABLE `bond` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flaw`
--

DROP TABLE IF EXISTS `flaw`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flaw` (
  `id` int NOT NULL AUTO_INCREMENT,
  `flaw` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flaw`
--

LOCK TABLES `flaw` WRITE;
/*!40000 ALTER TABLE `flaw` DISABLE KEYS */;
INSERT INTO `flaw` VALUES (1,'Forbidden love or susceptibility to romance'),(2,'Enjoys decadent pleasures'),(3,'Arrogance'),(4,'Envies another creature\'s possessions or station'),(5,'Overpowering greed'),(6,'Prone to rage'),(7,'Has a powerful enemy'),(8,'Specific phobia'),(9,'Shameful or scandalous history'),(10,'Secret crime or misdeed'),(11,'Possession of forbidden lore'),(12,'Foolhardy bravery');
/*!40000 ALTER TABLE `flaw` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Interaction_Traits`
--

LOCK TABLES `Interaction_Traits` WRITE;
/*!40000 ALTER TABLE `Interaction_Traits` DISABLE KEYS */;
INSERT INTO `Interaction_Traits` VALUES (1,'Argumentative'),(2,'Arrogant'),(3,'Blustering'),(4,'Rude'),(5,'Curious'),(6,'Friendly'),(7,'Honest'),(8,'Hot tempered'),(9,'Ponderous'),(10,'Quiet'),(11,'Suspicious');
/*!40000 ALTER TABLE `Interaction_Traits` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mannerisms`
--

DROP TABLE IF EXISTS `mannerisms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mannerisms` (
  `id` int NOT NULL AUTO_INCREMENT,
  `mannerisms` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mannerisms`
--

LOCK TABLES `mannerisms` WRITE;
/*!40000 ALTER TABLE `mannerisms` DISABLE KEYS */;
INSERT INTO `mannerisms` VALUES (1,'Prone to singing, whistling, or humming quietly'),(2,'Speaks in rhyme or some other peculiar way'),(3,'Particularly low or high voice'),(4,'Slurs words, lisps, or stutters'),(5,'Enunciates overly clearly'),(6,'Speaks loudly'),(7,'Whispers'),(8,'Uses flowery speech or long words'),(9,'Frequently uses the wrong word'),(10,'Uses colorful oaths and exclamations'),(11,'Makes constant jokes or puns'),(12,'Prone to predictions of doom'),(13,'Fidgets'),(14,'Squints'),(15,'Stares into the distance'),(16,'Chews something'),(17,'Paces'),(18,'Taps fingers'),(19,'Bites fingernails'),(20,'Twirls hair or tugs beard');
/*!40000 ALTER TABLE `mannerisms` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `npc`
--

DROP TABLE IF EXISTS `npc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `npc` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user` int DEFAULT NULL,
  `ability` int DEFAULT NULL,
  `appearance` int DEFAULT NULL,
  `bond` int DEFAULT NULL,
  `flaw` int DEFAULT NULL,
  `interaction_traits` int DEFAULT NULL,
  `mannerisms` int DEFAULT NULL,
  `race` int DEFAULT NULL,
  `talent` int DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ability_fk` (`ability`),
  KEY `appearance_fk` (`appearance`),
  KEY `bond_fk` (`bond`),
  KEY `flaw_fk` (`flaw`),
  KEY `interaction_traits_fk` (`interaction_traits`),
  KEY `mannerisms_fk` (`mannerisms`),
  KEY `race_fk` (`race`),
  KEY `talent_fk` (`talent`),
  KEY `user_fk` (`user`),
  CONSTRAINT `ability_fk` FOREIGN KEY (`ability`) REFERENCES `ability` (`id`),
  CONSTRAINT `appearance_fk` FOREIGN KEY (`appearance`) REFERENCES `appearance` (`id`),
  CONSTRAINT `bond_fk` FOREIGN KEY (`bond`) REFERENCES `bond` (`id`),
  CONSTRAINT `flaw_fk` FOREIGN KEY (`flaw`) REFERENCES `flaw` (`id`),
  CONSTRAINT `interaction_traits_fk` FOREIGN KEY (`interaction_traits`) REFERENCES `Interaction_Traits` (`id`),
  CONSTRAINT `mannerisms_fk` FOREIGN KEY (`mannerisms`) REFERENCES `mannerisms` (`id`),
  CONSTRAINT `race_fk` FOREIGN KEY (`race`) REFERENCES `race` (`id`),
  CONSTRAINT `talent_fk` FOREIGN KEY (`talent`) REFERENCES `talent` (`id`),
  CONSTRAINT `user_fk` FOREIGN KEY (`user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `npc`
--

LOCK TABLES `npc` WRITE;
/*!40000 ALTER TABLE `npc` DISABLE KEYS */;
/*!40000 ALTER TABLE `npc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `race`
--

DROP TABLE IF EXISTS `race`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `race` (
  `id` int NOT NULL AUTO_INCREMENT,
  `race` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `race`
--

LOCK TABLES `race` WRITE;
/*!40000 ALTER TABLE `race` DISABLE KEYS */;
INSERT INTO `race` VALUES (1,'Human'),(2,'Dragonborn'),(3,'Dwarf'),(4,'Elf'),(5,'Gnome'),(6,'Half-Elf'),(7,'Halfling'),(8,'Half-Orc'),(9,'Tiefling'),(10,'Aasimar'),(11,'Aarakocra'),(12,'Firbolg'),(13,'Goliath'),(14,'Tabaxi');
/*!40000 ALTER TABLE `race` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `talent`
--

DROP TABLE IF EXISTS `talent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `talent` (
  `id` int NOT NULL AUTO_INCREMENT,
  `talent` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `talent`
--

LOCK TABLES `talent` WRITE;
/*!40000 ALTER TABLE `talent` DISABLE KEYS */;
INSERT INTO `talent` VALUES (1,'Plays a musical instrument'),(2,'Speaks several languages fluently'),(3,'Unbelievably lucky'),(4,'Perfect memory'),(5,'Great with animals'),(6,'Great with children'),(7,'Great at solving puzzles'),(8,'Great at one game'),(9,'Great at impersonations'),(10,'Draws beautifully'),(11,'Paints beautifully'),(12,'Sings beautifully'),(13,'Drinks everyone under the table'),(14,'Expert carpenter'),(15,'Expert cook'),(16,'Expert dart thrower and rock skipper'),(17,'Expert juggler'),(18,'Skilled actor and master of disguise'),(19,'Skilled dancer'),(20,'Knows thieves\' cant');
/*!40000 ALTER TABLE `talent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_name` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'MichaelN');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-24 11:25:04
