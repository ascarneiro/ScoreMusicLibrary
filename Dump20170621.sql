-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: scoreold
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
-- Table structure for table `documento`
--

DROP TABLE IF EXISTS `documento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `documento` (
  `nr_sequencia` int(10) DEFAULT NULL,
  `ds_autor` char(255) DEFAULT NULL,
  `ds_livro` char(255) DEFAULT NULL,
  `DS_INSTRUMENTO` char(255) DEFAULT NULL,
  `DS_caminho_arquivo` char(255) DEFAULT NULL,
  `ds_obra` char(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `documento`
--

LOCK TABLES `documento` WRITE;
/*!40000 ALTER TABLE `documento` DISABLE KEYS */;
INSERT INTO `documento` VALUES (1952520629,'asdasd','asdasd','Tuba',NULL,'adas');
/*!40000 ALTER TABLE `documento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `documento_processo`
--

DROP TABLE IF EXISTS `documento_processo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `documento_processo` (
  `nr_sequencia` int(10) DEFAULT NULL,
  `nr_seq_documento` int(11) DEFAULT NULL,
  `nm_usuario` varchar(255) DEFAULT NULL,
  `dt_atualizacao` char(255) DEFAULT NULL,
  `nr_seq_midia_pdf` int(11) DEFAULT NULL,
  `nr_seq_midia_midi` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `documento_processo`
--

LOCK TABLES `documento_processo` WRITE;
/*!40000 ALTER TABLE `documento_processo` DISABLE KEYS */;
INSERT INTO `documento_processo` VALUES (-2085146044,-2085146044,'asdasd','21/06/2017 02 52 55',-2001162773,-1906588376),(1809948213,1809948213,NULL,'21/06/2017 03 00 33',-2001162773,-1906588376),(1809948213,1809948213,NULL,'21/06/2017 03 00 33',-2001162773,-1906588376),(479507237,479507237,'asasdas','21/06/2017 03 05 38',-2001162773,-1906588376),(278320494,278320494,'dasd','21/06/2017 03 05 50',-2001162773,-1906588376),(1952520629,1952520629,'asdasd','21/06/2017 03 24 36',-2001162773,-1906588376);
/*!40000 ALTER TABLE `documento_processo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `imagem`
--

DROP TABLE IF EXISTS `imagem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `imagem` (
  `nr_sequencia` int(10) DEFAULT NULL,
  `ds_imagem` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `imagem`
--

LOCK TABLES `imagem` WRITE;
/*!40000 ALTER TABLE `imagem` DISABLE KEYS */;
/*!40000 ALTER TABLE `imagem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `imagem_documento`
--

DROP TABLE IF EXISTS `imagem_documento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `imagem_documento` (
  `nr_sequencia` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `imagem_documento`
--

LOCK TABLES `imagem_documento` WRITE;
/*!40000 ALTER TABLE `imagem_documento` DISABLE KEYS */;
/*!40000 ALTER TABLE `imagem_documento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instrumento`
--

DROP TABLE IF EXISTS `instrumento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `instrumento` (
  `nr_sequencia` int(11) DEFAULT NULL,
  `ds_instrumento` char(255) DEFAULT NULL,
  `ds_familia` char(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instrumento`
--

LOCK TABLES `instrumento` WRITE;
/*!40000 ALTER TABLE `instrumento` DISABLE KEYS */;
INSERT INTO `instrumento` VALUES (1140464815,'Tuba','Metais'),(844289623,'Flauta','Madeiras'),(-813472621,'Saxofone','Palhetas'),(-191825276,'Fagote','Madeiras'),(-407929167,'Trompete','Metais'),(-1597728029,'Clarineta','Madeiras'),(-1051527446,'Violino','Cordas'),(-997025831,'Oboe','Madeiras'),(-1913057042,'Basson','Madeiras'),(-2068707982,'Horn','Metais'),(-1597662306,'Double bass','Cordas');
/*!40000 ALTER TABLE `instrumento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `midia`
--

DROP TABLE IF EXISTS `midia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `midia` (
  `nr_sequencia` int(10) DEFAULT NULL,
  `ds_caminho` varchar(400) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `midia`
--

LOCK TABLES `midia` WRITE;
/*!40000 ALTER TABLE `midia` DISABLE KEYS */;
INSERT INTO `midia` VALUES (-2001162773,'c:/file.pdf'),(-1906588376,'c:/file.midi'),(-2001162773,'c:/file.pdf'),(-2001162773,'c:/file.pdf'),(-1906588376,'c:/file.midi'),(-1906588376,'c:/file.midi'),(-2001162773,'c:/file.pdf'),(-1906588376,'c:/file.midi'),(-2001162773,'c:/file.pdf'),(-1906588376,'c:/file.midi'),(-2001162773,'c:/file.pdf'),(-1906588376,'c:/file.midi');
/*!40000 ALTER TABLE `midia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `nr_sequencia` int(10) DEFAULT NULL,
  `ds_email` char(255) DEFAULT NULL,
  `ds_senha` char(255) DEFAULT NULL,
  `nm_usuario` char(255) DEFAULT NULL,
  `ie_administrador` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (NULL,'alan@','123',NULL,NULL),(1555981636,'elemar@terra.com.br',NULL,'el.sol','N'),(-49005937,'anna.franca@gmail.com',NULL,'anna.franca','S');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-21  4:02:26
