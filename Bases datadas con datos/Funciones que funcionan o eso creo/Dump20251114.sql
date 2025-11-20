-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
--
-- Host: localhost    Database: changarrito
-- ------------------------------------------------------
-- Server version	8.0.42

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `articulos`
--

DROP TABLE IF EXISTS `articulos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `articulos` (
  `T` char(10) NOT NULL,
  `tnombre` char(20) NOT NULL,
  `ciudad` char(20) NOT NULL,
  PRIMARY KEY (`T`),
  UNIQUE KEY `T` (`T`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `articulos`
--

LOCK TABLES `articulos` WRITE;
/*!40000 ALTER TABLE `articulos` DISABLE KEYS */;
INSERT INTO `articulos` VALUES ('T1','CLASIFICADORA','MADRID'),('T2','PERFORADORA','MALAGA'),('T3','LECTORA','CACERES'),('T4','CONSOLA','CACERES'),('T5','MEZCLADORA','SEVILLA'),('T6','TERMINAL','BARCELONA'),('T7','CINTA','SEVILLA'),('T8','REMACHADORA','MADRID');
/*!40000 ALTER TABLE `articulos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `componentes`
--

DROP TABLE IF EXISTS `componentes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `componentes` (
  `C` char(10) NOT NULL,
  `cnombre` char(20) NOT NULL,
  `color` char(20) NOT NULL,
  `peso` int NOT NULL,
  `ciudad` char(20) NOT NULL,
  PRIMARY KEY (`C`),
  UNIQUE KEY `C` (`C`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `componentes`
--

LOCK TABLES `componentes` WRITE;
/*!40000 ALTER TABLE `componentes` DISABLE KEYS */;
INSERT INTO `componentes` VALUES ('C1','X3A','ROJO',12,'SEVILLA'),('C2','B85','VERDE',17,'MADRID'),('C3','C4B','AZUL',17,'MALAGA'),('C4','C4B','ROJO',14,'SEVILLA'),('C5','VT8','AZUL',12,'MADRID'),('C6','C30','ROJO',19,'SEVILLA');
/*!40000 ALTER TABLE `componentes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `envios`
--

DROP TABLE IF EXISTS `envios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `envios` (
  `P` char(10) NOT NULL,
  `C` char(10) NOT NULL,
  `T` char(10) NOT NULL,
  `cantidad` int NOT NULL,
  KEY `FK_proveedor` (`P`),
  KEY `FK_componentes` (`C`),
  KEY `FK_articulos` (`T`),
  CONSTRAINT `FK_articulos` FOREIGN KEY (`T`) REFERENCES `articulos` (`T`),
  CONSTRAINT `FK_componentes` FOREIGN KEY (`C`) REFERENCES `componentes` (`C`),
  CONSTRAINT `FK_proveedor` FOREIGN KEY (`P`) REFERENCES `proveedores` (`P`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `envios`
--

LOCK TABLES `envios` WRITE;
/*!40000 ALTER TABLE `envios` DISABLE KEYS */;
INSERT INTO `envios` VALUES ('P1','C1','T1',200),('P1','C1','T4',700),('P2','C3','T1',400),('P2','C3','T2',200),('P2','C3','T3',200),('P2','C3','T4',500),('P2','C3','T5',600),('P2','C3','T6',400),('P2','C3','T7',800),('P2','C5','T2',100),('P3','C3','T1',200),('P3','C4','T2',500),('P4','C6','T3',300),('P4','C6','T7',300),('P5','C2','T2',200),('P5','C2','T4',100),('P5','C5','T4',500),('P5','C5','T7',100),('P5','C6','T2',200),('P5','C1','T4',100),('P5','C3','T4',200),('P5','C4','T4',800),('P5','C5','T5',400),('P5','C6','T4',500),('P1','C1','T1',200),('P1','C1','T4',700),('P2','C3','T1',400),('P2','C3','T2',200),('P2','C3','T3',200),('P2','C3','T4',500),('P2','C3','T5',600),('P2','C3','T6',400),('P2','C3','T7',800),('P2','C5','T2',100),('P3','C3','T1',200),('P3','C4','T2',500),('P4','C6','T3',300),('P4','C6','T7',300),('P5','C2','T2',200),('P5','C2','T4',100),('P5','C5','T4',500),('P5','C5','T7',100),('P5','C6','T2',200),('P5','C1','T4',100),('P5','C3','T4',200),('P5','C4','T4',800),('P5','C5','T5',400),('P5','C6','T4',500);
/*!40000 ALTER TABLE `envios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedores`
--

DROP TABLE IF EXISTS `proveedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedores` (
  `P` char(10) NOT NULL,
  `pnombre` char(20) NOT NULL,
  `categoria` char(20) NOT NULL,
  `ciudad` char(20) NOT NULL,
  PRIMARY KEY (`P`),
  UNIQUE KEY `P` (`P`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedores`
--

LOCK TABLES `proveedores` WRITE;
/*!40000 ALTER TABLE `proveedores` DISABLE KEYS */;
INSERT INTO `proveedores` VALUES ('P1','CARLOS','20','SEVILLA'),('P2','JUAN','10','MADRID'),('P3','JOSE','30','SEVILLA'),('P4','INMA','20','SEVILLA'),('P5','EVA','30','CACERES');
/*!40000 ALTER TABLE `proveedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `vista_1`
--

DROP TABLE IF EXISTS `vista_1`;
/*!50001 DROP VIEW IF EXISTS `vista_1`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vista_1` AS SELECT 
 1 AS `T`,
 1 AS `tnombre`,
 1 AS `ciudad`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vista_2`
--

DROP TABLE IF EXISTS `vista_2`;
/*!50001 DROP VIEW IF EXISTS `vista_2`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vista_2` AS SELECT 
 1 AS `C`,
 1 AS `cnombre`,
 1 AS `color`,
 1 AS `peso`,
 1 AS `ciudad`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vista_3`
--

DROP TABLE IF EXISTS `vista_3`;
/*!50001 DROP VIEW IF EXISTS `vista_3`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vista_3` AS SELECT 
 1 AS `P`,
 1 AS `C`,
 1 AS `T`,
 1 AS `cantidad`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `vista_1`
--

/*!50001 DROP VIEW IF EXISTS `vista_1`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vista_1` AS select `articulos`.`T` AS `T`,`articulos`.`tnombre` AS `tnombre`,`articulos`.`ciudad` AS `ciudad` from `articulos` where (`articulos`.`ciudad` like 'Caceres') */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vista_2`
--

/*!50001 DROP VIEW IF EXISTS `vista_2`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vista_2` AS select `componentes`.`C` AS `C`,`componentes`.`cnombre` AS `cnombre`,`componentes`.`color` AS `color`,`componentes`.`peso` AS `peso`,`componentes`.`ciudad` AS `ciudad` from `componentes` where (`componentes`.`color` like 'rojo') */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vista_3`
--

/*!50001 DROP VIEW IF EXISTS `vista_3`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vista_3` AS select `envios`.`P` AS `P`,`envios`.`C` AS `C`,`envios`.`T` AS `T`,`envios`.`cantidad` AS `cantidad` from `envios` where (`envios`.`cantidad` between 200 and 1000) order by `envios`.`cantidad` */;
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

-- Dump completed on 2025-11-14  9:03:09
