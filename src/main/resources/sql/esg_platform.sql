-- MySQL dump 10.13  Distrib 5.7.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: esg_database
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `corporation_basic`
--

DROP TABLE IF EXISTS `corporation_basic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `corporation_basic` (
  `corporation_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `stoke` int NOT NULL,
  `industry` varchar(255) NOT NULL,
  `location` varchar(255) NOT NULL,
  `introduction` text,
  PRIMARY KEY (`corporation_id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `corporation_basic`
--

LOCK TABLES `corporation_basic` WRITE;
/*!40000 ALTER TABLE `corporation_basic` DISABLE KEYS */;
/*!40000 ALTER TABLE `corporation_basic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `corporation_esg`
--

DROP TABLE IF EXISTS `corporation_esg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `corporation_esg` (
  `corporation_id` int NOT NULL,
  `record_id` int NOT NULL,
  `esg_id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`esg_id`),
  UNIQUE KEY `corporation_esg_esg_id_uindex` (`esg_id`),
  KEY `corporation_id` (`corporation_id`),
  KEY `corporation_esg_corporation_esg_history_record_id_fk` (`record_id`),
  CONSTRAINT `corporation_esg_corporation_esg_history_record_id_fk` FOREIGN KEY (`record_id`) REFERENCES `corporation_esg_history` (`record_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `corporation_esg_ibfk_1` FOREIGN KEY (`corporation_id`) REFERENCES `corporation_basic` (`corporation_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `corporation_esg`
--

LOCK TABLES `corporation_esg` WRITE;
/*!40000 ALTER TABLE `corporation_esg` DISABLE KEYS */;
/*!40000 ALTER TABLE `corporation_esg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `corporation_esg_history`
--

DROP TABLE IF EXISTS `corporation_esg_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `corporation_esg_history` (
  `corporation_id` int NOT NULL,
  `record_id` int NOT NULL AUTO_INCREMENT,
  `time` date NOT NULL,
  `steady_record_id` int NOT NULL,
  `risky_record_id` int NOT NULL,
  PRIMARY KEY (`record_id`),
  UNIQUE KEY `corporation_esg_history_record_id_uindex` (`record_id`),
  KEY `corporation_esg_history_corporation_basic_corporation_id_fk` (`corporation_id`),
  KEY `corporation_esg_history_corporation_esg_score_steady_fk` (`steady_record_id`),
  KEY `corporation_esg_history_corporation_esg_score_risky_fk_2` (`risky_record_id`),
  CONSTRAINT `corporation_esg_history_corporation_basic_corporation_id_fk` FOREIGN KEY (`corporation_id`) REFERENCES `corporation_basic` (`corporation_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `corporation_esg_history_corporation_esg_score_risky_fk_2` FOREIGN KEY (`risky_record_id`) REFERENCES `corporation_esg_score` (`score_record_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `corporation_esg_history_corporation_esg_score_steady_fk` FOREIGN KEY (`steady_record_id`) REFERENCES `corporation_esg_score` (`score_record_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `corporation_esg_history`
--

LOCK TABLES `corporation_esg_history` WRITE;
/*!40000 ALTER TABLE `corporation_esg_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `corporation_esg_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `corporation_esg_score`
--

DROP TABLE IF EXISTS `corporation_esg_score`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `corporation_esg_score` (
  `corporation_id` int NOT NULL,
  `score_record_id` int NOT NULL AUTO_INCREMENT,
  `score_type` enum('risky','steady') NOT NULL,
  `ESG_total_score` double NOT NULL,
  `E_score` double NOT NULL,
  `S_score` double NOT NULL,
  `G_score` double NOT NULL,
  `e_accident` double NOT NULL DEFAULT '0',
  `e_advantage` double NOT NULL DEFAULT '0',
  `e_idea` double NOT NULL DEFAULT '0',
  `e_pollution` double NOT NULL DEFAULT '0',
  `s_charity` double NOT NULL DEFAULT '0',
  `s_publish` double NOT NULL DEFAULT '0',
  `s_responsibility` double NOT NULL DEFAULT '0',
  `s_employee_variety` double NOT NULL DEFAULT '0',
  `s_employee_guarantee` double NOT NULL DEFAULT '0',
  `g_structure` double NOT NULL DEFAULT '0',
  `g_result` double NOT NULL DEFAULT '0',
  `g_audit` double NOT NULL DEFAULT '0',
  `g_exception` double NOT NULL DEFAULT '0',
  `g_visibility` double NOT NULL DEFAULT '0',
  PRIMARY KEY (`score_record_id`),
  KEY `corporation_id` (`corporation_id`),
  CONSTRAINT `corporation_esg_score_ibfk_1` FOREIGN KEY (`corporation_id`) REFERENCES `corporation_basic` (`corporation_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `corporation_esg_score`
--

LOCK TABLES `corporation_esg_score` WRITE;
/*!40000 ALTER TABLE `corporation_esg_score` DISABLE KEYS */;
/*!40000 ALTER TABLE `corporation_esg_score` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `corporation_event`
--

DROP TABLE IF EXISTS `corporation_event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `corporation_event` (
  `corporation_id` int NOT NULL,
  `time` date NOT NULL,
  `event` text NOT NULL,
  `event_id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`event_id`),
  UNIQUE KEY `corporation_event_event_id_uindex` (`event_id`),
  KEY `corporation_id` (`corporation_id`),
  CONSTRAINT `corporation_event_ibfk_1` FOREIGN KEY (`corporation_id`) REFERENCES `corporation_basic` (`corporation_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `corporation_event`
--

LOCK TABLES `corporation_event` WRITE;
/*!40000 ALTER TABLE `corporation_event` DISABLE KEYS */;
/*!40000 ALTER TABLE `corporation_event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `corporation_info`
--

DROP TABLE IF EXISTS `corporation_info`;
/*!50001 DROP VIEW IF EXISTS `corporation_info`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `corporation_info` AS SELECT 
 1 AS `corporation_id`,
 1 AS `name`,
 1 AS `introduction`,
 1 AS `industry`,
 1 AS `location`,
 1 AS `stoke`,
 1 AS `ESG_risky_score`,
 1 AS `ESG_steady_score`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `corporation_opinion`
--

DROP TABLE IF EXISTS `corporation_opinion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `corporation_opinion` (
  `corporation_id` int NOT NULL,
  `time` date NOT NULL,
  `opinion_text` text NOT NULL,
  `opinion_score` double NOT NULL,
  `opinion_id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`opinion_id`),
  UNIQUE KEY `corporation_opinion_opinion_id_uindex` (`opinion_id`),
  KEY `corporation_id` (`corporation_id`),
  CONSTRAINT `corporation_opinion_ibfk_1` FOREIGN KEY (`corporation_id`) REFERENCES `corporation_basic` (`corporation_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `corporation_opinion`
--

LOCK TABLES `corporation_opinion` WRITE;
/*!40000 ALTER TABLE `corporation_opinion` DISABLE KEYS */;
/*!40000 ALTER TABLE `corporation_opinion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `corporation_second_factor`
--

DROP TABLE IF EXISTS `corporation_second_factor`;
/*!50001 DROP VIEW IF EXISTS `corporation_second_factor`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `corporation_second_factor` AS SELECT 
 1 AS `corporation_id`,
 1 AS `industry`,
 1 AS `score_type`,
 1 AS `score_record_id`,
 1 AS `e_accident`,
 1 AS `e_advantage`,
 1 AS `e_idea`,
 1 AS `e_pollution`,
 1 AS `s_charity`,
 1 AS `s_publish`,
 1 AS `s_responsibility`,
 1 AS `s_employee_variety`,
 1 AS `s_employee_guarantee`,
 1 AS `g_structure`,
 1 AS `g_result`,
 1 AS `g_audit`,
 1 AS `g_exception`,
 1 AS `g_visibility`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `corporation_stock`
--

DROP TABLE IF EXISTS `corporation_stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `corporation_stock` (
  `corporation_id` int NOT NULL,
  `time` date NOT NULL,
  `price` decimal(10,0) NOT NULL,
  `stock_record_id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`stock_record_id`),
  UNIQUE KEY `corporation_stock_stock_record_id_uindex` (`stock_record_id`),
  KEY `corporation_id` (`corporation_id`),
  CONSTRAINT `corporation_stock_ibfk_1` FOREIGN KEY (`corporation_id`) REFERENCES `corporation_basic` (`corporation_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `corporation_stock`
--

LOCK TABLES `corporation_stock` WRITE;
/*!40000 ALTER TABLE `corporation_stock` DISABLE KEYS */;
/*!40000 ALTER TABLE `corporation_stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `uid` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `is_admin` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_interest`
--

DROP TABLE IF EXISTS `user_interest`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_interest` (
  `uid` int NOT NULL,
  `interest_corporation_id` int(10) unsigned zerofill DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_interest`
--

LOCK TABLES `user_interest` WRITE;
/*!40000 ALTER TABLE `user_interest` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_interest` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `corporation_info`
--

/*!50001 DROP VIEW IF EXISTS `corporation_info`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `corporation_info` AS select `corporation_basic`.`corporation_id` AS `corporation_id`,`corporation_basic`.`name` AS `name`,`corporation_basic`.`introduction` AS `introduction`,`corporation_basic`.`industry` AS `industry`,`corporation_basic`.`location` AS `location`,`corporation_basic`.`stoke` AS `stoke`,`r`.`ESG_total_score` AS `ESG_risky_score`,`s`.`ESG_total_score` AS `ESG_steady_score` from ((((`corporation_basic` join `corporation_esg_score` `r`) join `corporation_esg_score` `s`) join `corporation_esg`) join `corporation_esg_history`) where ((`corporation_basic`.`corporation_id` = `corporation_esg`.`corporation_id`) and (`corporation_esg`.`record_id` = `corporation_esg_history`.`record_id`) and (`corporation_esg_history`.`risky_record_id` = `r`.`score_record_id`) and (`corporation_esg_history`.`steady_record_id` = `s`.`score_record_id`)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `corporation_second_factor`
--

/*!50001 DROP VIEW IF EXISTS `corporation_second_factor`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `corporation_second_factor` AS select `corporation_basic`.`corporation_id` AS `corporation_id`,`corporation_basic`.`industry` AS `industry`,`corporation_esg_score`.`score_type` AS `score_type`,`corporation_esg_score`.`score_record_id` AS `score_record_id`,`corporation_esg_score`.`e_accident` AS `e_accident`,`corporation_esg_score`.`e_advantage` AS `e_advantage`,`corporation_esg_score`.`e_idea` AS `e_idea`,`corporation_esg_score`.`e_pollution` AS `e_pollution`,`corporation_esg_score`.`s_charity` AS `s_charity`,`corporation_esg_score`.`s_publish` AS `s_publish`,`corporation_esg_score`.`s_responsibility` AS `s_responsibility`,`corporation_esg_score`.`s_employee_variety` AS `s_employee_variety`,`corporation_esg_score`.`s_employee_guarantee` AS `s_employee_guarantee`,`corporation_esg_score`.`g_structure` AS `g_structure`,`corporation_esg_score`.`g_result` AS `g_result`,`corporation_esg_score`.`g_audit` AS `g_audit`,`corporation_esg_score`.`g_exception` AS `g_exception`,`corporation_esg_score`.`g_visibility` AS `g_visibility` from (((`corporation_basic` join `corporation_esg`) join `corporation_esg_history`) join `corporation_esg_score`) where ((`corporation_basic`.`corporation_id` = `corporation_esg`.`corporation_id`) and (`corporation_esg`.`record_id` = `corporation_esg_history`.`record_id`) and ((`corporation_esg_score`.`score_record_id` = `corporation_esg_history`.`steady_record_id`) or (`corporation_esg_score`.`score_record_id` = `corporation_esg_history`.`risky_record_id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-17 17:30:03
