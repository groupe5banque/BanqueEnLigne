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
-- Table structure for table `bourse`
--

DROP TABLE IF EXISTS `bourse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bourse` (
  `idEntreprise` int(11) NOT NULL AUTO_INCREMENT,
  `nomEnt` varchar(45) DEFAULT NULL,
  `ouverture` varchar(45) DEFAULT NULL,
  `haut` varchar(45) DEFAULT NULL,
  `bas` varchar(45) DEFAULT NULL,
  `volume` varchar(45) DEFAULT NULL,
  `veille` varchar(45) DEFAULT NULL,
  `actuel` varchar(45) DEFAULT NULL,
  `variation` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idEntreprise`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bourse`
--

LOCK TABLES `bourse` WRITE;
/*!40000 ALTER TABLE `bourse` DISABLE KEYS */;
INSERT INTO `bourse` VALUES (1,'Nom','Ouverture','+Haut','+Bas','Volume','Veille','Dernier','Var'),(2,'Accor Hotels','42.2','42.425','41.855','848972.0','42.0','42.28','0.0067'),(3,'Air Liquide','113.4','114.2','112.95','577541.0','113.3','113.85','0.0049'),(4,'Airbus','74.8','75.62','74.12','1233664.0','75.03','75.51','0.0064'),(5,'Arcelor Mittal','6.895','7.122','6.816','1.2714441E7','6.915','7.12','0.0296'),(6,'Atos','124.8','125.35','123.6','204450.0','124.05','125.25','0.0097'),(7,'Axa','24.71','24.89','24.525','5427393.0','25.8','24.87','-0.036'),(8,'Bnp Paribas','65.95','67.12','65.83','3118604.0','66.37','66.98','0.0092'),(9,'Bouygues','38.2','38.715','38.12','738121.0','38.1','38.425','0.0085'),(10,'Cap Gemini','93.98','95.36','93.98','393896.0','93.84','95.14','0.0139'),(11,'Carrefour','21.49','21.62','21.37','1383175.0','21.485','21.59','0.0049'),(12,'Credit Agricole','14.13','14.48','14.07','4459474.0','14.13','14.425','0.0209'),(13,'Danone','63.89','64.61','63.73','1046927.0','65.5','64.59','-0.0139'),(14,'Engie','13.62','13.78','13.5','3584145.0','13.86','13.6','-0.0188'),(15,'Essilor Intl','120.0','120.4','119.4','278917.0','119.75','119.95','0.0017'),(16,'Kering','290.5','291.85','290.4','126507.0','290.5','291.7','0.0041'),(17,'LafargeHolcim','52.17','52.24','51.62','280610.0','52.26','52.19','-0.0013'),(18,'Legrand SA','60.66','61.37','60.56','269086.0','60.54','61.29','0.0124'),(19,'L\'oreal','186.45','187.5','186.2','272963.0','186.75','187.45','0.0037'),(20,'Lvmh','234.5','237.3','234.1','380233.0','234.4','237.05','0.0113'),(21,'Michelin','119.45','120.7','119.45','167894.0','119.7','120.65','0.0079'),(22,'Nokia','5.507','5.569','5.484','1591034.0','5.504','5.567','0.0114'),(23,'Orange','14.695','14.885','14.65','5228324.0','14.6','14.875','0.0188'),(24,'Pernod Ricard','118.35','119.05','118.1','187881.0','118.6','118.75','0.0013'),(25,'Peugeot','18.9','19.16','18.805','965393.0','18.91','19.15','0.0127'),(26,'Publicis Groupe','65.35','65.61','64.81','339565.0','65.22','65.61','0.006'),(27,'Renault','84.35','84.76','83.6','445301.0','84.27','84.74','0.0056'),(28,'Safran','77.97','78.22','76.98','497843.0','77.83','78.19','0.0046'),(29,'Saint Gobain','51.07','52.17','50.98','1264411.0','51.03','52.08','0.0206'),(30,'Sanofi','89.3','89.73','89.14','1150149.0','89.4','89.65','0.0028'),(31,'Schneider Electric','72.8','73.6','72.58','640342.0','72.81','73.52','0.0098'),(32,'Societe Generale','51.25','51.84','51.16','2854122.0','51.72','51.54','-0.0035'),(33,'Sodexo','118.35','118.7','117.4','83707.0','118.15','118.05','-8.0E-4'),(34,'Solvay','122.45','124.05','122.25','137790.0','123.05','123.95','0.0073'),(35,'TechnipFMC','28.155','28.735','27.935','782933.0','28.32','28.535','0.0076'),(36,'Total','46.315','47.41','46.285','3880806.0','47.045','47.24','0.0041'),(37,'Unibail-Rodamco','228.15','229.5','227.65','102312.0','228.15','229.45','0.0057'),(38,'Valeo','66.01','66.84','66.01','376291.0','66.3','66.78','0.0072'),(39,'Veolia Environ.','18.55','18.745','18.505','2116926.0','18.605','18.66','0.003'),(40,'Vinci','79.2','79.32','78.27','973095.0','79.33','79.08','-0.0032'),(41,'Vivendi','18.39','18.635','18.31','2428186.0','18.3','18.605','0.0167');
/*!40000 ALTER TABLE `bourse` ENABLE KEYS */;
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
