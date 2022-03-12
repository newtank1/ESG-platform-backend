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
  PRIMARY KEY (`corporation_id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `corporation_basic`
--

LOCK TABLES `corporation_basic` WRITE;
/*!40000 ALTER TABLE `corporation_basic` DISABLE KEYS */;
INSERT INTO `corporation_basic` VALUES (1,'xya',4,'construction','nanjing'),(2,'a',5,'chemistry','beijing'),(3,'xy',6,'chemistry','shanghai'),(4,'go',7,'chemistry','nanjing');
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
  `ESG_total_ranking` int NOT NULL,
  `ESG_industry_ranking` int NOT NULL,
  `record_id` int NOT NULL,
  `esg_id` int NOT NULL AUTO_INCREMENT,
  UNIQUE KEY `corporation_esg_esg_id_uindex` (`esg_id`),
  KEY `corporation_id` (`corporation_id`),
  KEY `record_id` (`record_id`),
  CONSTRAINT `corporation_esg_ibfk_1` FOREIGN KEY (`corporation_id`) REFERENCES `corporation_basic` (`corporation_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `corporation_esg_ibfk_2` FOREIGN KEY (`record_id`) REFERENCES `corporation_esg_history` (`record_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `corporation_esg`
--

LOCK TABLES `corporation_esg` WRITE;
/*!40000 ALTER TABLE `corporation_esg` DISABLE KEYS */;
INSERT INTO `corporation_esg` VALUES (1,2,1,1,1),(4,3,2,5,5),(3,1,1,34,20);
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
  `ESG_total_score` double NOT NULL,
  `E_score` double NOT NULL,
  `S_score` double NOT NULL,
  `G_score` double NOT NULL,
  `e_punished` int DEFAULT NULL,
  `e_have_accidents` int DEFAULT NULL,
  `e_monitored` int DEFAULT NULL,
  `e_publish_idea` int DEFAULT NULL,
  `e_publish_goal` int DEFAULT NULL,
  `e_publish_regulation` int DEFAULT NULL,
  `e_use_emergency` int DEFAULT NULL,
  `e_three_wastes_measure` int DEFAULT NULL,
  `e_education` int DEFAULT NULL,
  `e_investment` decimal(10,5) DEFAULT NULL,
  `e_recycle_eco` int DEFAULT NULL,
  `e_save_resource` int DEFAULT NULL,
  `e_green_office` int DEFAULT NULL,
  `e_invention` int DEFAULT NULL,
  `e_useful_invention` int DEFAULT NULL,
  `e_action` int DEFAULT NULL,
  `e_product` int DEFAULT NULL,
  `e_certification` int DEFAULT NULL,
  `e_award` int DEFAULT NULL,
  `e_pollution` int DEFAULT NULL,
  `s_poverty_alleviation_amount` decimal(10,5) DEFAULT NULL,
  `s_poverty_escape` int DEFAULT NULL,
  `s_poverty_future_plan` int DEFAULT NULL,
  `s_poverty_activity` int DEFAULT NULL,
  `s_publish_staff_protection` int DEFAULT NULL,
  `s_publish_supplier_protection` int DEFAULT NULL,
  `s_publish_responsibility` int DEFAULT NULL,
  `s_publish_responsibility_construction` int DEFAULT NULL,
  `s_publish_safe_production` int DEFAULT NULL,
  `s_product_issue` int DEFAULT NULL,
  `s_donation` decimal(10,5) DEFAULT NULL,
  `s_support_education` int DEFAULT NULL,
  `s_support_charity` int DEFAULT NULL,
  `s_volunteer` int DEFAULT NULL,
  `s_international_assistance` int DEFAULT NULL,
  `s_activate_employment` int DEFAULT NULL,
  `s_promote_economy` int DEFAULT NULL,
  `s_quality_award` int DEFAULT NULL,
  `s_patent` int DEFAULT NULL,
  `s_research_pay` decimal(10,5) DEFAULT NULL,
  `s_researcher_proportion` double DEFAULT NULL,
  `s_skill_proportion` double DEFAULT NULL,
  `s_anti_corruption` int DEFAULT NULL,
  `s_share_strategy` int DEFAULT NULL,
  `s_operation_integrity` int DEFAULT NULL,
  `s_employee_safe_issue` int DEFAULT NULL,
  `s_layoff` int DEFAULT NULL,
  `s_employee_stake` int DEFAULT NULL,
  `s_employee_welfare` int DEFAULT NULL,
  `s_safe_management` int DEFAULT NULL,
  `s_safe_education` int DEFAULT NULL,
  `s_employment_safety_certification` int DEFAULT NULL,
  `s_employment_safety_education` int DEFAULT NULL,
  `s_employee_communication` int DEFAULT NULL,
  `g_directors` double DEFAULT NULL,
  `g_supervisors` double DEFAULT NULL,
  `g_executives` double DEFAULT NULL,
  `g_independent_directors` double DEFAULT NULL,
  `g_primary_stockholder` double DEFAULT NULL,
  `g_cash_bonus_proportion` double DEFAULT NULL,
  `g_capital_award` double DEFAULT NULL,
  `g_interest_guarantee` double DEFAULT NULL,
  `g_net_asset_reward` double DEFAULT NULL,
  `g_finance_audit` int DEFAULT NULL,
  `g_control_audit` int DEFAULT NULL,
  `g_executive_quitting` double DEFAULT NULL,
  `g_nonrecurring_gains_and_losses` double DEFAULT NULL,
  `g_dishonesty_person` int DEFAULT NULL,
  `g_dishonesty_action` int DEFAULT NULL,
  `g_dishonesty_punished` int DEFAULT NULL,
  `g_illegal` int DEFAULT NULL,
  `g_have_extra_finance_form` int DEFAULT NULL,
  `g_willing_publish` int DEFAULT NULL,
  `g_have_publish` int DEFAULT NULL,
  `g_publish_quality` int DEFAULT NULL,
  PRIMARY KEY (`record_id`),
  KEY `corporation_id` (`corporation_id`),
  CONSTRAINT `corporation_esg_history_ibfk_1` FOREIGN KEY (`corporation_id`) REFERENCES `corporation_basic` (`corporation_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `corporation_esg_history`
--

LOCK TABLES `corporation_esg_history` WRITE;
/*!40000 ALTER TABLE `corporation_esg_history` DISABLE KEYS */;
INSERT INTO `corporation_esg_history` VALUES (1,1,'2022-02-11',5,1,1,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(2,2,'2022-03-07',6,5,2,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,3,'2022-03-06',5,1,1,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(4,5,'2022-03-03',1,2,3,4,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(1,14,'2022-01-21',3,1,1,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,30,'2022-03-07',10,3,3,4,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,34,'2022-03-08',11,3,3,4,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `corporation_esg_history` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `corporation_event`
--

LOCK TABLES `corporation_event` WRITE;
/*!40000 ALTER TABLE `corporation_event` DISABLE KEYS */;
INSERT INTO `corporation_event` VALUES (1,'2022-03-06','a',1),(1,'2022-02-26','b',12);
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
 1 AS `stoke`,
 1 AS `industry`,
 1 AS `location`,
 1 AS `ESG_total_ranking`,
 1 AS `ESG_industry_ranking`,
 1 AS `record_id`,
 1 AS `ESG_total_score`,
 1 AS `time`*/;
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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `corporation_opinion`
--

LOCK TABLES `corporation_opinion` WRITE;
/*!40000 ALTER TABLE `corporation_opinion` DISABLE KEYS */;
INSERT INTO `corporation_opinion` VALUES (1,'2022-02-21','\"abc\"',1,1),(3,'2022-03-03','zxc',1,7),(3,'2022-03-03','zxc',1,8),(3,'2022-03-03','zxc',1,9);
/*!40000 ALTER TABLE `corporation_opinion` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `corporation_stock`
--

LOCK TABLES `corporation_stock` WRITE;
/*!40000 ALTER TABLE `corporation_stock` DISABLE KEYS */;
INSERT INTO `corporation_stock` VALUES (1,'2022-02-17',10,1);
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
INSERT INTO `user` VALUES (2,'1','2','0');
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
/*!50001 VIEW `corporation_info` AS select `corporation_basic`.`corporation_id` AS `corporation_id`,`corporation_basic`.`name` AS `name`,`corporation_basic`.`stoke` AS `stoke`,`corporation_basic`.`industry` AS `industry`,`corporation_basic`.`location` AS `location`,`corporation_esg`.`ESG_total_ranking` AS `ESG_total_ranking`,`corporation_esg`.`ESG_industry_ranking` AS `ESG_industry_ranking`,`corporation_esg`.`record_id` AS `record_id`,`corporation_esg_history`.`ESG_total_score` AS `ESG_total_score`,`corporation_esg_history`.`time` AS `time` from ((`corporation_basic` join `corporation_esg`) join `corporation_esg_history`) where ((`corporation_basic`.`corporation_id` = `corporation_esg`.`corporation_id`) and (`corporation_esg`.`record_id` = `corporation_esg_history`.`record_id`)) */;
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

-- Dump completed on 2022-03-12  9:25:21
