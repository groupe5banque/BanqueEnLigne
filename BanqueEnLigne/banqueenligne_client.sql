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
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client` (
  `idClient` int(11) NOT NULL AUTO_INCREMENT,
  `nomClient` varchar(45) DEFAULT NULL,
  `prenomClient` varchar(45) DEFAULT NULL,
  `civiliteClient` varchar(45) DEFAULT NULL,
  `emailClient` varchar(45) DEFAULT NULL,
  `dateNaissanceClient` varchar(45) DEFAULT NULL,
  `motDePasseClient` varchar(45) DEFAULT NULL,
  `nationaliteClient` varchar(45) DEFAULT NULL,
  `typeCompte` varchar(45) DEFAULT NULL,
  `telephoneClient` varchar(45) DEFAULT NULL,
  `adresseClient` varchar(45) DEFAULT NULL,
  `codepostalClient` varchar(45) DEFAULT NULL,
  `villeClient` varchar(45) DEFAULT NULL,
  `paysClient` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idClient`),
  UNIQUE KEY `emailClient_UNIQUE` (`emailClient`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,'asso','florin',NULL,'p.ass@yahoo.fr','01-09-200','01','Gabon','Compte individuel','768613223','30 rue julian grima','76800','Rouen','France'),(2,'ANATO','Anaelle',NULL,'anaelle.anato@yahoo.fr','01-06-1996','01','France','Compte individuel','768613232','30 rue julian grimau','76800','rouen','France');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
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
