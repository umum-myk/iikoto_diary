-- MySQL dump 10.13  Distrib 5.7.33, for Win64 (x86_64)
--
-- Host: localhost    Database: iikoto_diary
-- ------------------------------------------------------
-- Server version	5.7.33-log

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
-- Table structure for table `diary`
--

DROP TABLE IF EXISTS `diary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `diary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `iikoto` varchar(255) NOT NULL,
  `create_date` date NOT NULL DEFAULT '0000-00-00',
  `iine` int(11) NOT NULL DEFAULT '0',
  `create_month` int(11) NOT NULL DEFAULT '0',
  `create_year` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diary`
--

LOCK TABLES `diary` WRITE;
/*!40000 ALTER TABLE `diary` DISABLE KEYS */;
INSERT INTO `diary` VALUES (1,'おいしいお寿司食べた！','2021-05-11',0,5,2021),(2,'秋葉原友達と散歩した','2021-05-11',1,5,2021),(3,'洗濯たくさんした','2021-04-11',0,4,2021),(4,'部屋の片づけ頑張った！','2021-04-11',0,4,2021),(5,'CD買った。かなりいい','2021-03-11',0,3,2021),(6,'友達と長電話','2021-03-11',0,3,2021),(7,'VRゲームで沢山遊んだ','2021-03-11',0,3,2021),(8,'Unity上手になってきた','2021-03-11',0,3,2021),(9,'料理がうまくできた！','2021-03-11',0,3,2021),(10,'歌声を褒められた','2021-03-11',0,3,2021),(11,'ゲーセンでぬいぐるみ取れた！','2021-03-11',0,3,2021),(12,'ドライブたのしかった','2021-03-11',0,3,2021),(13,'新しい靴を買った！','2021-03-11',0,3,2021),(14,'新しいアイシャドウかわいい！','2021-03-11',0,3,2021),(15,'最近料理たのしい','2021-03-11',1,3,2021),(16,'桜がきれいだ','2021-03-11',1,3,2021),(17,'部屋にバラを飾った','2021-03-17',0,3,2021),(18,'ITの新しい知識ついた！','2021-03-17',0,3,2021),(19,'ページネーション直せた！','2021-03-17',1,3,2021),(20,'アプリ大体できてきた！','2021-03-28',0,3,2021);
/*!40000 ALTER TABLE `diary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'iikoto_diary'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-03  6:26:38
