CREATE DATABASE  IF NOT EXISTS `banqueenligne` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `banqueenligne`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: banqueenligne
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
INSERT INTO `client` VALUES (1,'asso','pri',NULL,'p.ass@yahoo.fr','01-09-200','01','France','Compte individuel','768613223','30 rue julian grimau','76800','Rouen','France'),(2,'ANATO','Anaelle',NULL,'anaelle.anato@yahoo.fr','01-06-1996','01','France','Compte individuel','768613232','30 rue julian grimau','76800','rouen','France');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `code`
--

DROP TABLE IF EXISTS `code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `code` (
  `idCode` int(11) NOT NULL AUTO_INCREMENT,
  `pays` varchar(45) DEFAULT NULL,
  `codeGuichet` varchar(45) DEFAULT NULL,
  `clefRib` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idCode`)
) ENGINE=InnoDB AUTO_INCREMENT=192 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `code`
--

LOCK TABLES `code` WRITE;
/*!40000 ALTER TABLE `code` DISABLE KEYS */;
INSERT INTO `code` VALUES (1,'Afghanistan','35381','57'),(2,'Albanie','78356','28'),(3,'Algérie','53156','94'),(4,'Allemagne','61778','44'),(5,'Andorre','16428','88'),(6,'Angola','27817','25'),(7,'Antigua-et-Barbuda','73396','83'),(8,'Arabie Saoudite','22179','78'),(9,'Argentine','38291','44'),(10,'Armenie','11963','42'),(11,'Australie','77598','35'),(12,'Autriche','64732','39'),(13,'Azerbaidjan','65769','37'),(14,'Bahamas','72689','39'),(15,'Bahrein','65747','14'),(16,'Bangladesh','91514','95'),(17,'Barbade','18373','83'),(18,'Belgique','27156','26'),(19,'Belize','75474','44'),(20,'Benin','44388','69'),(21,'Bhoutan','52912','71'),(22,'Bielorussie','72183','42'),(23,'Birmanie','11535','77'),(24,'Bolivie','62183','75'),(25,'Bosnie-Herzegovine','49958','88'),(26,'Botswana','86393','39'),(27,'Bresil','27773','44'),(28,'Brunei','22993','91'),(29,'Bulgarie','64546','86'),(30,'Burkina Faso','62655','38'),(31,'Buundi','12882','32'),(32,'Cambodge','69253','29'),(33,'Cameroun','88995','36'),(34,'Canada','78655','83'),(35,'Cap vert','73562','24'),(36,'Chili','92185','14'),(37,'Chine','98617','73'),(38,'Chypre','43291','73'),(39,'Colombie','23612','76'),(40,'Corée du Nord','84716','61'),(41,'Corée du  sud','11112','58'),(42,'Costa Rica','52178','92'),(43,'Côte d’Ivoire','21388','94'),(44,'Croatie','23659','68'),(45,'Cuba','69474','19'),(46,'Danemark','98463','46'),(47,'Dominique','59132','82'),(48,'Djibouti','35344','82'),(49,'Égypte','56295','44'),(50,'Émirats arabes unis','51362','75'),(51,'Équateur','64478','42'),(52,'Érythrée','23878','72'),(53,'Espagne','54884','95'),(54,'Estonie','13833','97'),(55,'États-Unis','87391','58'),(56,'Éthiopie','52635','17'),(57,'Fidji','39471','58'),(58,'Finlande','25437','64'),(59,'France','87758','89'),(60,'Gabon','91278','69'),(61,'Gambie','68264','72'),(62,'Géorgie','22337','13'),(63,'Ghana','18865','99'),(64,'Grèce','14329','68'),(65,'Grenade','74876','93'),(66,'Guatemala','62699','89'),(67,'Guinée Conakry','26461','79'),(68,'Guinée équatoriale','99933','17'),(69,'Guinée-Bissau','17992','75'),(70,'Guyana','69994','45'),(71,'Haïti','84354','59'),(72,'Honduras','77775','53'),(73,'Hongrie','84153','11'),(74,'Îles Cook','35479','59'),(75,'Îles Marshall','93148','97'),(76,'Inde','11435','99'),(77,'Irak','76743','41'),(78,'Iran','13514','95'),(79,'Irlande','15449','96'),(80,'Islande','81489','88'),(81,'Israël','97915','52'),(82,'Italie','66417','13'),(83,'Jamaïque','97834','45'),(84,'Japon','91585','21'),(85,'Jordanie','59145','22'),(86,'Kazakhstan','81393','27'),(87,'Kenya','69332','84'),(88,'Kirghizistan','85392','44'),(89,'Kiribati','57315','96'),(90,'Kosovo','78618','52'),(91,'koweit','27888','45'),(92,'Laos','69842','28'),(93,'Lesotho','71537','21'),(94,'Lettonie','57749','86'),(95,'Liban','33248','37'),(96,'Liberia','21342','31'),(97,'Libye','28874','46'),(98,'Liechtenstein','95796','41'),(99,'Lituanie','55368','52'),(100,'Luxembourg','74884','41'),(101,'Macédoine','12426','34'),(102,'Madagascar','21356','46'),(103,'Malaisie','88754','77'),(104,'Malawi','57646','56'),(105,'Maldives','19957','72'),(106,'Mali','53876','42'),(107,'Malte','15797','17'),(108,'Maroc','12294','45'),(109,'Maurice','55797','36'),(110,'Mauritanie','84513','45'),(111,'Mexique','82424','53'),(112,'Micronésie','75675','82'),(113,'Moldavie','96387','63'),(114,'Monaco','63897','43'),(115,'Mongolie','74584','96'),(116,'Monténégro','47968','26'),(117,'Mozambique','12624','75'),(118,'Namibie','88393','86'),(119,'Nauru','13139','85'),(120,'Népal','38452','57'),(121,'Nicaragua','32998','79'),(122,'Nigeria','57833','71'),(123,'Niue','32516','31'),(124,'Norvège','13153','85'),(125,'Nouvelle-Zélande','31722','55'),(126,'Oman','87419','16'),(127,'Ouganda','36817','81'),(128,'Ouzbékistan','97533','56'),(129,'Pakistan','54711','88'),(130,'Palaos','71349','73'),(131,'Panama','45257','35'),(132,'Papouasie-Nouvelle-Guinée','97411','38'),(133,'Paraguay','89446','27'),(134,'Pays-Bas','33663','77'),(135,'Pérou','57155','68'),(136,'Pologne','88532','44'),(137,'Portugal','94754','76'),(138,'Niger','57825','61'),(139,'Palestine','15843','49'),(140,'Qatar','93418','23'),(141,'République centrafricaine','43558','53'),(142,'République démocratique du Congo','66963','18'),(143,'République Dominicaine','81554','87'),(144,'République du Congo','69742','52'),(145,'République tchèque','34429','64'),(146,'Roumanie','12781','14'),(147,'Royaume-Uni','84447','25'),(148,'Russie','82723','55'),(149,'Rwanda','41112','34'),(150,'Saint-Kitts-et-Nevis','45472','41'),(151,'Saint-Vincent-et-les-Grenadines','34183','79'),(152,'Sainte-Lucie','96884','81'),(153,'Salomon','72453','82'),(154,'Salvador','98943','76'),(155,'Samoa','97335','59'),(156,'São Tomé-et-Principe','15561','27'),(157,'Sénégal','69291','43'),(158,'Serbie','59167','71'),(159,'Seychelles','81781','17'),(160,'Sierra Leone','91599','51'),(161,'Singapour','57959','77'),(162,'Slovaquie','27737','24'),(163,'Slovénie','42616','85'),(164,'Somalie','39733','77'),(165,'Soudan','44832','89'),(166,'Soudan du Sud','92984','21'),(167,'Sri Lanka','37882','98'),(168,'Suède','79718','62'),(169,'Suisse','16188','98'),(170,'Surivalue','82787','84'),(171,'Swaziland','78446','71'),(172,'Syrie','86333','69'),(173,'Tadjikistan','86553','46'),(174,'Tanzanie','22876','91'),(175,'Tchad','46731','56'),(176,'Thaïlande','46486','32'),(177,'Timor oriental','92594','38'),(178,'Togo','96718','63'),(179,'Tonga','64629','97'),(180,'Trinité-et-Tobago','57133','41'),(181,'Tunisie','17794','87'),(182,'Turkménistan','47178','85'),(183,'Turquie','48844','86'),(184,'Tuvalu','91745','31'),(185,'Uruguay','58374','49'),(186,'Vatican','86812','28'),(187,'Venezuela','15425','71'),(188,'Viêt Nam','89245','59'),(189,'Yémen','24743','14'),(190,'Zambie','41653','15'),(191,'Zimbabwe','11934','85');
/*!40000 ALTER TABLE `code` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compte`
--

LOCK TABLES `compte` WRITE;
/*!40000 ALTER TABLE `compte` DISABLE KEYS */;
INSERT INTO `compte` VALUES (1,1,39471,'WLDU3Y4D4PD',58,39471,'500','compte courant'),(2,1,39471,'2ZEVDAPZ7RF',58,39471,'500','compte epargne'),(3,1,39471,'FOHV2EZUEFG',58,39471,'200','compte epargne'),(4,1,39471,'MAOGNZAZZYU',58,39471,'0','compte epargne'),(5,1,39471,'LE268IQ6V2P',58,39471,'0','compte epargne'),(6,1,39471,'13JDUE77NNU',58,39471,'0','compte epargne'),(7,1,39471,'ONQLJR5D1PP',58,39471,'0','compte epargne'),(8,1,39471,'25Q4NVZ7Y3M',58,39471,'0','compte epargne'),(9,1,39471,'HOO47DDULUJ',58,39471,'0','compte epargne'),(10,1,39471,'1U8FOFHRJIL',58,39471,'0','compte epargne'),(11,1,39471,'51H21IX4B4U',58,39471,'0','compte epargne'),(12,1,39471,'NFM1W4FOCWR',58,39471,'0','compte epargne'),(13,1,39471,'F6Q7UA8MSS2',58,39471,'0','compte epargne'),(14,1,39471,'ZCFED65UNWD',58,39471,'0','compte epargne'),(15,1,39471,'CVZVPV9BOX4',58,39471,'0','compte epargne'),(16,1,39471,'RNPGSSO1ISQ',58,39471,'0','compte epargne'),(17,1,39471,'41S2632X7RY',58,39471,'0','compte epargne'),(18,1,39471,'J6CFYPH6FZ1',58,39471,'0','compte epargne'),(19,1,39471,'XSELI6HEKNT',58,39471,'0','compte titre'),(20,1,39471,'YEICHWA7M72',58,39471,'0','compte epargne'),(21,1,39471,'NMKR2MJWYQ2',58,39471,'0','compte epargne'),(22,1,39471,'OIN21TB3HKJ',58,39471,'0','compte epargne'),(23,1,39471,'J1EEXKMPO3V',58,39471,'0','compte titre'),(24,1,39471,'5LAEQ9QNQ57',58,39471,'0','compte epargne'),(25,2,87758,'EECBWA5XJXU',89,87758,'0','compte courant'),(26,2,87758,'O1ULFBA3D19',89,87758,'0','compte epargne');
/*!40000 ALTER TABLE `compte` ENABLE KEYS */;
UNLOCK TABLES;

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
  `debit` int(11) DEFAULT '0',
  `credit` int(11) DEFAULT '0',
  PRIMARY KEY (`idHistorique`),
  KEY `idClient_idx` (`idClient`),
  CONSTRAINT `` FOREIGN KEY (`idClient`) REFERENCES `client` (`idClient`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historique`
--

LOCK TABLES `historique` WRITE;
/*!40000 ALTER TABLE `historique` DISABLE KEYS */;
INSERT INTO `historique` VALUES (1,1,1,'2017-04-06','Virement émis pour le compte courant N° WLDU3Y4D4PD\n Motif:  Scolaire',500,0),(2,1,2,'2017-04-06','Virement reçu du compte epargne N° 2ZEVDAPZ7RF\n Motif:  Scolaire',0,500),(3,1,2,'2017-04-06','Virement émis pour le compte epargne N° 2ZEVDAPZ7RF\n Motif:  Voyage',200,0),(4,1,3,'2017-04-06','Virement reçu du compte epargne N° FOHV2EZUEFG\n Motif:  Voyage',0,200);
/*!40000 ALTER TABLE `historique` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rib`
--

DROP TABLE IF EXISTS `rib`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rib` (
  `idRIB` int(11) NOT NULL AUTO_INCREMENT,
  `codeGuichet` int(11) DEFAULT NULL,
  `numeroDeCompte` varchar(45) DEFAULT NULL,
  `cleRIB` varchar(45) DEFAULT NULL,
  `codeBanque` int(11) DEFAULT NULL,
  PRIMARY KEY (`idRIB`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rib`
--

LOCK TABLES `rib` WRITE;
/*!40000 ALTER TABLE `rib` DISABLE KEYS */;
INSERT INTO `rib` VALUES (1,84813,'AZ2O5ZYJGJ8','66',84813),(2,71295,'WAUU851GT7M','84',71295),(3,99289,'VOPV8TE7M8P','75',99289);
/*!40000 ALTER TABLE `rib` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `virement`
--

DROP TABLE IF EXISTS `virement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `virement` (
  `idVirement` int(11) NOT NULL AUTO_INCREMENT,
  `compteEmetteur` varchar(45) DEFAULT NULL,
  `compteBeneficiaire` varchar(45) DEFAULT NULL,
  `montantVirement` int(11) DEFAULT NULL,
  `dateVirement` date DEFAULT NULL,
  `motifVirement` varchar(200) DEFAULT 'Pas de motif précisé',
  `idClient` int(11) DEFAULT NULL,
  PRIMARY KEY (`idVirement`),
  KEY `idClient_idx` (`idClient`),
  CONSTRAINT `idClient` FOREIGN KEY (`idClient`) REFERENCES `client` (`idClient`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `virement`
--

LOCK TABLES `virement` WRITE;
/*!40000 ALTER TABLE `virement` DISABLE KEYS */;
INSERT INTO `virement` VALUES (1,'WLDU3Y4D4PD','2ZEVDAPZ7RF',500,'2017-04-06','  Scolaire',1),(2,'2ZEVDAPZ7RF','FOHV2EZUEFG',200,'2017-04-06','  Voyage',1);
/*!40000 ALTER TABLE `virement` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-06 16:32:57
