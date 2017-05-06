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
-- Table structure for table `historique`
--

DROP TABLE IF EXISTS `historique`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `historique` (
  `idHistorique` int(11) NOT NULL AUTO_INCREMENT,
  `idClient` int(11) DEFAULT NULL,
  `idCompte` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `nature` varchar(200) DEFAULT NULL,
  `debit` double DEFAULT '0',
  `credit` double DEFAULT '0',
  PRIMARY KEY (`idHistorique`),
  KEY `idClient_idx` (`idClient`),
  CONSTRAINT `` FOREIGN KEY (`idClient`) REFERENCES `client` (`idClient`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historique`
--

LOCK TABLES `historique` WRITE;
/*!40000 ALTER TABLE `historique` DISABLE KEYS */;
INSERT INTO `historique` VALUES (1,1,1,'2017-04-06','Virement émis pour le compte courant N° WLDU3Y4D4PD\n Motif:  Scolaire',500,0),(2,1,2,'2017-04-06','Virement reçu du compte epargne N° 2ZEVDAPZ7RF\n Motif:  Scolaire',0,500),(3,1,2,'2017-04-06','Virement émis pour le compte epargne N° 2ZEVDAPZ7RF\n Motif:  Voyage',200,0),(4,1,3,'2017-04-06','Virement reçu du compte epargne N° FOHV2EZUEFG\n Motif:  Voyage',0,200),(5,1,1,'2017-04-09','Virement émis pour le compte courant N° WLDU3Y4D4PD\n Motif: Ecole',100,0),(6,1,2,'2017-04-09','Virement reçu du compte epargne N° 2ZEVDAPZ7RF\n Motif: Ecole',0,100),(7,1,2,'2017-04-17','Virement émis pour le compte epargne N° 2ZEVDAPZ7RF\n Motif:  ',200,0),(8,1,1,'2017-04-17','Virement reçu du compte courant N° WLDU3Y4D4PD\n Motif:  ',0,200),(9,1,1,'2017-04-19','Virement émis pour le compte courant N° WLDU3Y4D4PD\n Motif:  test',0,0),(10,1,2,'2017-04-19','Virement reçu du compte epargne N° 2ZEVDAPZ7RF\n Motif:  test',0,0),(11,1,1,'2017-04-19','Virement émis pour le compte courant N° WLDU3Y4D4PD\n Motif:  ',0,0),(12,1,4,'2017-04-19','Virement reçu du compte epargne N° MAOGNZAZZYU\n Motif:  ',0,0),(13,1,2,'2017-04-19','Virement émis pour le compte epargne N° 2ZEVDAPZ7RF\n Motif:  ',0,0),(14,1,6,'2017-04-19','Virement reçu du compte epargne N° 13JDUE77NNU\n Motif:  ',0,0),(15,1,19,'2017-04-23','Achat de10actions de Accor Hotels',395.79999999999995,0),(16,1,19,'2017-04-23','Achat de20actions de Accor Hotels',791.5999999999999,0),(17,1,19,'2017-04-24','Achat de 4 actions de Accor Hotels',160.56,0),(18,1,19,'2017-04-24','Vente de 12 actions de Accor Hotels',481.68,0),(19,1,19,'2017-04-24','Vente de 12 actions de Accor Hotels',481.68,0),(20,1,19,'2017-04-24','Vente de 2 actions de Accor Hotels',80.28,0),(21,1,19,'2017-04-24','Vente de 10 actions de Accor Hotels',401.4,0),(22,1,19,'2017-04-24','Vente de 14 actions de Accor Hotels',561.96,0),(23,1,19,'2017-04-24','Vente de 3 actions de Accor Hotels',120.42,0),(24,1,19,'2017-04-24','Vente de 1 actions de Accor Hotels',40.14,0),(25,1,19,'2017-04-24','Vente de 3 actions de Accor Hotels',120.42,0),(26,1,19,'2017-04-24','Vente de 4 actions de Accor Hotels',160.56,0),(27,1,19,'2017-04-24','Vente de 0 actions de Accor Hotels',0,0),(28,1,19,'2017-04-24','Vente de 1 actions de Accor Hotels',40.14,0),(29,1,19,'2017-04-24','Achat de 20 actions de Accor Hotels',802.8,0),(30,1,19,'2017-04-24','Achat de 2 actions de Accor Hotels',80.28,0),(31,1,19,'2017-04-24','Achat de 2 actions de Accor Hotels',80.28,0),(32,1,19,'2017-04-24','Achat de 3 actions de Accor Hotels',120.42,0),(33,1,19,'2017-04-24','Achat de 3 actions de Accor Hotels',120.42,0),(34,1,19,'2017-04-24','Vente de 2 actions de Accor Hotels',80.28,0),(35,1,19,'2017-04-24','Achat de 1 actions de Accor Hotels',40.14,0),(36,1,19,'2017-04-24','Achat de 1 actions de Accor Hotels',40.14,0),(37,1,19,'2017-04-24','Achat de 1 actions de Accor Hotels',40.14,0),(38,1,19,'2017-04-25','Achat de 1 actions de Accor Hotels',40.14,0),(39,1,19,'2017-04-25','Achat de 1 actions de Accor Hotels',40.14,0),(40,1,1,'2017-04-25','Virement émis pour le compte courant N° WLDU3Y4D4PD\n Motif:  ECOLE',10,0),(41,1,2,'2017-04-25','Virement reçu du compte epargne N° 2ZEVDAPZ7RF\n Motif:  ECOLE',0,10),(42,1,19,'2017-04-25','Vente de 1 actions de Accor Hotels',40.14,0),(43,1,19,'2017-04-25','Vente de 1 actions de Accor Hotels',40.14,0),(44,1,19,'2017-04-25','Achat de 1 actions de Accor Hotels',40.14,0),(45,1,19,'2017-04-25','Achat de 1 actions de Accor Hotels',40.14,0),(46,1,19,'2017-04-25','Achat de 1 actions de Accor Hotels',40.14,0),(47,1,1,'2017-04-25','Virement émis pour le compte courant N° WLDU3Y4D4PD\n Motif:  ECOLE',10,0),(48,1,2,'2017-04-25','Virement reçu du compte epargne N° 2ZEVDAPZ7RF\n Motif:  ECOLE',0,10),(49,1,2,'2017-04-25','Virement émis pour le compte epargne N° 2ZEVDAPZ7RF\n Motif:  FFDD',10,0),(50,1,1,'2017-04-25','Virement reçu du compte courant N° WLDU3Y4D4PD\n Motif:  FFDD',0,10),(51,1,1,'2017-04-26','Virement émis pour le compte courant N° WLDU3Y4D4PD\n Motif:  GG',10,0),(52,1,3,'2017-04-26','Virement reçu du compte epargne N° FOHV2EZUEFG\n Motif:  GG',0,10),(53,1,2,'2017-04-26','Dépôtcompte epargneN°2ZEVDAPZ7RF',0,200),(54,1,19,'2017-04-26','Achat de 1 actions de Accor Hotels',40.14,0),(55,1,19,'2017-04-26','Vente de 1 actions de Accor Hotels',40.14,0),(56,1,2,'2017-04-26','Dépôt',0,3),(57,1,1,'2017-04-26','Virement émis pour le compte courant N° WLDU3Y4D4PD\n Motif:  ',10,0),(58,1,4,'2017-04-26','Virement reçu du compte epargne N° MAOGNZAZZYU\n Motif:  ',0,10),(59,1,2,'2017-04-26','Dépôt',0,200),(60,1,19,'2017-04-26','Vente de 2 actions de Accor Hotels',80.28,0),(61,1,19,'2017-04-26','Achat de 1 actions de Accor Hotels',40.14,0),(62,1,19,'2017-04-26','Vente de 5 actions de Accor Hotels',200.7,0),(63,1,19,'2017-04-26','Achat de 10 actions de Air Liquide',1057.5,0),(64,1,19,'2017-05-03','Achat de 1 actions de Accor ',41.35,0),(65,1,19,'2017-05-03','Achat de 1 actions de Accor ',41.35,0),(66,1,19,'2017-05-03','Achat de 2 actions de Accor ',82.7,0),(67,1,19,'2017-05-03','Achat de 2 actions de Accor ',82.7,0),(68,1,19,'2017-05-03','Achat de 2 actions de Accor ',82.7,0),(69,1,19,'2017-05-03','Achat de 2 actions de Accor ',82.7,0),(70,1,19,'2017-05-03','Achat de 1 actions de Accor ',41.35,0),(71,1,19,'2017-05-03','Achat de 1 actions de Accor ',41.35,0),(72,1,19,'2017-05-03','Achat de 3 actions de Accor ',124.05000000000001,0),(73,1,19,'2017-05-03','Achat de 3 actions de Accor ',124.05000000000001,0),(74,1,19,'2017-05-03','Achat de 3 actions de Accor ',124.05000000000001,0),(75,1,19,'2017-05-03','Achat de 1 actions de Accor ',41.35,0),(76,1,19,'2017-05-03','Achat de 1 actions de Accor ',41.35,0),(77,1,19,'2017-05-03','Achat de 1 actions de Accor ',41.35,0),(78,1,19,'2017-05-03','Achat de 1 actions de Accor ',41.35,0),(79,1,19,'2017-05-03','Achat de 1 actions de Accor ',41.35,0),(80,1,19,'2017-05-03','Achat de 1 actions de Accor ',41.35,0),(81,1,19,'2017-05-03','Achat de 1 actions de Accor ',41.35,0),(82,1,19,'2017-05-03','Achat de 1 actions de Accor ',41.35,0),(83,1,19,'2017-05-03','Achat de 1 actions de Accor ',41.35,0),(84,1,19,'2017-05-03','Achat de 1 actions de Accor ',41.35,0),(85,1,19,'2017-05-03','Achat de 1 actions de Accor ',41.35,0),(86,1,19,'2017-05-03','Achat de 1 actions de Accor ',41.35,0),(87,1,19,'2017-05-03','Achat de 1 actions de Accor ',41.35,0),(88,1,19,'2017-05-05','Achat de 3 actions de Accor Hotels',126.81,0),(89,1,19,'2017-05-05','Achat de 3 actions de Accor Hotels',126.81,0),(90,1,19,'2017-05-05','Achat de 3 actions de Accor Hotels',126.81,0),(91,1,19,'2017-05-05','Achat de 3 actions de Accor Hotels',126.81,0),(92,1,19,'2017-05-05','Achat de 3 actions de Accor Hotels',126.81,0),(93,1,19,'2017-05-05','Achat de 3 actions de Accor Hotels',126.81,0),(94,1,19,'2017-05-05','Achat de 3 actions de Accor Hotels',126.81,0),(95,1,19,'2017-05-05','Achat de 3 actions de Accor Hotels',126.81,0),(96,1,19,'2017-05-05','Achat de 3 actions de Accor Hotels',126.81,0),(97,1,19,'2017-05-05','Achat de 3 actions de Accor Hotels',126.81,0),(98,1,19,'2017-05-05','Achat de 3 actions de Accor Hotels',126.81,0),(99,1,19,'2017-05-05','Achat de 3 actions de Accor Hotels',126.81,0),(100,1,19,'2017-05-05','Achat de 3 actions de Accor Hotels',126.81,0),(101,1,19,'2017-05-05','Achat de 3 actions de Accor Hotels',126.81,0),(102,1,19,'2017-05-05','Achat de 3 actions de Accor Hotels',126.81,0),(103,1,19,'2017-05-05','Achat de 3 actions de Accor Hotels',126.81,0),(104,1,19,'2017-05-05','Vente de 1 actions de Accor Hotels',42.27,0);
/*!40000 ALTER TABLE `historique` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-05 15:16:36
