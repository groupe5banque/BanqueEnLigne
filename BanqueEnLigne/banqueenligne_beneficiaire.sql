-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: banqueenligne
-- ------------------------------------------------------
-- Server version	5.7.18-log

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
-- Table structure for table `beneficiaire`
--

DROP TABLE IF EXISTS `beneficiaire`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `beneficiaire` (
  `idbeneficiaire` int(11) NOT NULL AUTO_INCREMENT,
  `idClient` int(11) DEFAULT NULL,
  `nomben` varchar(200) DEFAULT NULL,
  `prenomben` varchar(200) DEFAULT NULL,
  `ibanben` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idbeneficiaire`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `beneficiaire`
--

LOCK TABLES `beneficiaire` WRITE;
/*!40000 ALTER TABLE `beneficiaire` DISABLE KEYS */;
INSERT INTO `beneficiaire` VALUES (1,1,'HGHH','ANJT',NULL),(2,1,'HGHH','ANJT',NULL),(3,1,'TCHAMANI','Anais',NULL),(4,1,'tyyyfyg','gbujbn;',NULL),(5,1,'nk','kjk',NULL),(6,1,'hukj','lj',NULL),(7,1,'n','n',NULL),(8,1,'hj','jhk',NULL),(9,1,'uyhhkhjn','kkjhkj',NULL),(10,1,'HHKJ','JJHJ',NULL),(11,1,'UKGU','UUU.YKKU.',NULL),(12,1,'uj','pi',NULL),(13,1,'ULIH D','JKKN',NULL),(14,1,'UIBJ','FBB',NULL);
/*!40000 ALTER TABLE `beneficiaire` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-05 15:16:37
