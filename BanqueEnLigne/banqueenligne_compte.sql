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
-- Table structure for table `compte`
--

DROP TABLE IF EXISTS `compte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `compte` (
  `idCompte` int(11) NOT NULL AUTO_INCREMENT,
  `idClient_Compte` int(11) NOT NULL,
  `codeGuichet` int(11) DEFAULT NULL,
  `numeroDeCompte` varchar(45) DEFAULT NULL,
  `clefRIB` int(11) DEFAULT NULL,
  `codeBanque` int(11) DEFAULT NULL,
  `soldeBanque` varchar(45) DEFAULT NULL,
  `typeCompte` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idCompte`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compte`
--

LOCK TABLES `compte` WRITE;
/*!40000 ALTER TABLE `compte` DISABLE KEYS */;
INSERT INTO `compte` VALUES (1,1,39471,'WLDU3Y4D4PD',58,39471,'170.0','compte courant'),(2,1,39471,'2ZEVDAPZ7RF',58,39471,'4000913.0','compte epargne'),(3,1,39471,'FOHV2EZUEFG',58,39471,'210.0','compte epargne'),(4,1,39471,'MAOGNZAZZYU',58,39471,'210.0','compte epargne'),(5,1,39471,'LE268IQ6V2P',58,39471,'0','compte epargne'),(6,1,39471,'13JDUE77NNU',58,39471,'100.0','compte epargne'),(7,1,39471,'ONQLJR5D1PP',58,39471,'0','compte epargne'),(8,1,39471,'25Q4NVZ7Y3M',58,39471,'0','compte epargne'),(9,1,39471,'HOO47DDULUJ',58,39471,'0','compte epargne'),(10,1,39471,'1U8FOFHRJIL',58,39471,'0','compte epargne'),(11,1,39471,'51H21IX4B4U',58,39471,'0','compte epargne'),(12,1,39471,'NFM1W4FOCWR',58,39471,'0','compte epargne'),(13,1,39471,'F6Q7UA8MSS2',58,39471,'0','compte epargne'),(14,1,39471,'ZCFED65UNWD',58,39471,'0','compte epargne'),(15,1,39471,'CVZVPV9BOX4',58,39471,'0','compte epargne'),(16,1,39471,'RNPGSSO1ISQ',58,39471,'0','compte epargne'),(17,1,39471,'41S2632X7RY',58,39471,'0','compte epargne'),(18,1,39471,'J6CFYPH6FZ1',58,39471,'0','compte epargne'),(19,1,39471,'XSELI6HEKNT',58,39471,'566.710000000001','compte titre'),(20,1,39471,'YEICHWA7M72',58,39471,'0','compte epargne'),(21,1,39471,'NMKR2MJWYQ2',58,39471,'0','compte epargne'),(22,1,39471,'OIN21TB3HKJ',58,39471,'0','compte epargne'),(23,1,39471,'J1EEXKMPO3V',58,39471,'0','compte titre'),(24,1,39471,'5LAEQ9QNQ57',58,39471,'0','compte epargne'),(25,2,87758,'EECBWA5XJXU',89,87758,'0','compte courant'),(26,2,87758,'O1ULFBA3D19',89,87758,'0','compte epargne'),(27,1,39471,'9PHNKXH94K7',58,39471,'0','compte epargne'),(28,1,39471,'JLBO2XAP4JB',58,39471,'0','compte titre'),(29,1,39471,'37VVT5G6O2F',58,39471,'0','compte epargne'),(30,1,39471,'6L6CD31ENKC',58,39471,'0','compte epargne'),(31,1,39471,'X4X3P7GPGKO',58,39471,'0','compte epargne'),(32,1,39471,'1AJ597SMZ3N',58,39471,'0','compte epargne'),(33,1,39471,'DL2UMVBNIPW',58,39471,'0','compte epargne'),(34,1,39471,'VNO3IWAHLP3',58,39471,'0','compte epargne'),(35,1,39471,'GC9EEFQK9JY',58,39471,'0','compte epargne'),(36,1,39471,'6QCHIK7MHQA',58,39471,'0','compte titre'),(37,1,39471,'XPQNDJ8Y85F',58,39471,'0','compte titre');
/*!40000 ALTER TABLE `compte` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-05 15:16:38
