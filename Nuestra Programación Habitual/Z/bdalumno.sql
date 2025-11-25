-- MySQL dump 10.13  Distrib 8.0.43, for Win64 (x86_64)
--
-- Host: localhost    Database: bdalumno
-- ------------------------------------------------------
-- Server version	8.0.43

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
-- Table structure for table `alumno`
--

DROP TABLE IF EXISTS `alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alumno` (
  `cuenta` int NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellidoP` varchar(45) NOT NULL,
  `apellidoM` varchar(45) NOT NULL,
  `edad` int NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `ciudad` varchar(45) NOT NULL,
  `telefono` varchar(15) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `nacionalidad` varchar(45) NOT NULL,
  `licenciatura` varchar(45) NOT NULL,
  `semestre` int NOT NULL,
  PRIMARY KEY (`cuenta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno`
--

LOCK TABLES `alumno` WRITE;
/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;
INSERT INTO `alumno` VALUES (1,'Pepe','Peppone','Peppino',18,'La loma del orto','Lima','555-666','donpeppone@yahoo.com','pastafari','Negocios',5),(2,'Mr Frog','Frogo','Tsui',40,'Mansion Frog No.66','Pensilvania','55666777','mr.frog@smilingmail.com','estadounidense','Actuacion',10),(3,'Maria','Peppone','Bambino',20,'00184 Roma RM','Marsella','645-336-667','maryOnACross@gmail.com','Italiana','Musica',3),(4,'Luigi','Spaghetti','Peppino',21,'Via Roma 123','Roma','390-612-345-678','pizzatowergame@gmail.com','Italiano','Gastronomia',7),(1000,'Izuku','Midoriya','Katsuragi',16,'Aldea Musutafu 12','Musutafu','555-1000','izuku@ua.jp','japonés','Héroes',2),(1001,'Katsuki','Bakugo','Inuzuka',16,'Aldea Musutafu 15','Musutafu','555-1001','bakugo@ua.jp','japonés','Héroes',2),(1002,'Ochako','Uraraka','Mizuno',16,'Barrio Central 5','Musutafu','555-1002','ochako@ua.jp','japonesa','Héroes',2),(1003,'Tenya','Iida','Nogami',17,'Distrito Iida','Musutafu','555-1003','tenya@ua.jp','japonés','Héroes',3),(1004,'Shoto','Todoroki','Fujibayashi',16,'Residencia Todoroki','Musutafu','555-1004','shoto@ua.jp','japonés','Héroes',2),(1005,'Mitsuri','Kanroji','Hanamori',18,'Templo Minami 21','Tokyo','555-1005','mitsuri@kimetsu.jp','japonesa','Gastronomía',4),(1006,'Tanjiro','Kamado','Miyahara',16,'Montaña Sagara','Okutama','555-1006','tanjiro@kimetsu.jp','japonés','Historia',1),(1007,'Nezuko','Kamado','Miyahara',15,'Montaña Sagara','Okutama','555-1007','nezuko@kimetsu.jp','japonesa','Artes',1),(1008,'Zenitsu','Agatsuma','Kitagawa',16,'Pueblo Shiro','Kyoto','555-1008','zenitsu@kimetsu.jp','japonés','Música',2),(1009,'Inosuke','Hashibira','Okano',16,'Montes Azuma','Gunma','555-1009','inosuke@kimetsu.jp','japonés','Deportes',1),(1010,'Yuji','Itadori','Nakazawa',15,'Pueblo Sendai 3','Sendai','555-1010','yuji@jjk.jp','japonés','Deportes',1),(1011,'Megumi','Fushiguro','Kasumi',15,'Barrio Norte 9','Tokyo','555-1011','megumi@jjk.jp','japonés','Biología',1),(1012,'Nobara','Kugisaki','Takeda',16,'Distrito Kamo','Tokyo','555-1012','nobara@jjk.jp','japonesa','Moda',2),(1013,'Ayanokoji','Kiyotaka','Furihata',17,'Dormitorio A-104','Tokyo','555-1013','kio@classroom.jp','japonés','Filosofía',3),(1014,'Horikita','Suzune','Kurokawa',17,'Dormitorio B-201','Tokyo','555-1014','suzune@classroom.jp','japonesa','Derecho',3),(1015,'Kushida','Kikyo','Asano',17,'Dormitorio C-309','Tokyo','555-1015','kikyo@classroom.jp','japonesa','Psicología',3),(1016,'Light','Yagami','Shirosaki',17,'Barrio Kanto 4','Tokyo','555-1016','light@kira.jp','japonés','Derecho',3),(1017,'L','Lawliet','Fujisawa',18,'Hotel Sakura 8','Tokyo','555-1017','l@invest.jp','ingles','Criminología',4),(1018,'Misa','Amane','Tachibana',16,'Residencial Nishi','Tokyo','555-1018','misa@idol.jp','japonesa','Artes',2),(1019,'Naruto','Uzumaki','Namikaze',17,'Aldea Konoha','Konoha','555-1019','naruto@konoha.jp','japonés','Deportes',3),(1020,'Sasuke','Uchiha','Kagami',17,'Distrito Uchiha','Konoha','555-1020','sasuke@konoha.jp','japonés','Tecnología',3),(1021,'Sakura','Haruno','Yamaguchi',17,'Barrio Este 2','Konoha','555-1021','sakura@konoha.jp','japonesa','Medicina',3),(1022,'Hinata','Hyuga','Takanashi',16,'Clan Hyuga','Konoha','555-1022','hinata@konoha.jp','japonesa','Medicina',2),(1023,'Shinji','Ikari','Kurosawa',14,'NERV Bloque C','Tokyo-3','555-1023','shinji@nerv.jp','japonés','Música',1),(1024,'Asuka','Langley','Soryu',14,'NERV Bloque B','Tokyo-3','555-1024','asuka@nerv.jp','alemana','Ingeniería',1),(1025,'Rei','Ayanami','Kazehana',14,'NERV Bloque A','Tokyo-3','555-1025','rei@nerv.jp','japonesa','Filosofía',1),(1026,'Haruhi','Suzumiya','Morimoto',17,'Barrio Kita','Nishinomiya','555-1026','haruhi@sos.jp','japonesa','Física',3),(1027,'Yuki','Nagato','Minase',17,'Dormitorio 204','Nishinomiya','555-1027','yuki@sos.jp','japonesa','Ingeniería',3),(1028,'Mikuru','Asahina','Sakuraba',18,'Dormitorio 112','Nishinomiya','555-1028','mikuru@sos.jp','japonesa','Historia',4),(1029,'Kyon','Johnston','Takagi',17,'Barrio Sur 1','Nishinomiya','555-1029','kyon@sos.jp','japonés','Literatura',3),(1030,'Eren','Yeager','Ackerman',15,'Distrito Shiganshina','Maria','555-1030','eren@paradis.jp','eldiano','Historia',1),(1031,'Mikasa','Ackerman','Kobayashi',15,'Distrito Shiganshina','Maria','555-1031','mikasa@paradis.jp','eldiana','Deportes',1),(1032,'Armin','Arlert','Sato',15,'Distrito Shiganshina','Maria','555-1032','armin@paradis.jp','eldiano','Estrategia',1),(1033,'Hachiman','Hikigaya','Okabe',17,'Barrio Chiba 7','Chiba','555-1033','hachiman@soboreserva.jp','japonés','Filosofía',3),(1034,'Yukino','Yukinoshita','Amano',17,'Barrio Chiba 4','Chiba','555-1034','yukino@soboreserva.jp','japonesa','Literatura',3),(1035,'Yui','Yuigahama','Kinoshita',17,'Barrio Chiba 6','Chiba','555-1035','yui@soboreserva.jp','japonesa','Comunicación',3),(1036,'Komi','Shouko','Minami',16,'Barrio Central','Itan','555-1036','komi@itan.jp','japonesa','Artes',2),(1037,'Tadano','Hitohito','Sagawa',16,'Barrio Sur','Itan','555-1037','tadano@itan.jp','japonés','Tecnología',2),(1038,'Najimi','Osana','Tanaka',16,'Barrio Oeste','Itan','555-1038','najimi@itan.jp','japonés','Mercadotecnia',2),(1039,'Senku','Ishigami','Morita',16,'Pueblo Ishigami','Tokyo','555-1039','senku@stone.jp','japonés','Ciencias',2),(1040,'Taiju','Oki','Tobishima',16,'Barrio Norte 4','Tokyo','555-1040','taiju@stone.jp','japonés','Historia',2),(1041,'Yuzuriha','Ogawa','Kuroda',16,'Barrio Este 9','Tokyo','555-1041','yuzuriha@stone.jp','japonesa','Diseño',2),(1042,'Gon','Freecss','Hanada',13,'Isla Ballena','Ballena','555-1042','gon@hunter.jp','japonés','Deportes',1),(1043,'Killua','Zoldyck','Mizuki',14,'Monte Kukuru','Yorbia','555-1043','killua@hunter.jp','yobiano','Tecnología',1),(1044,'Kurapika','Kurta','Nanase',17,'Pueblo Kurta','Lugnica','555-1044','kurapika@hunter.jp','kurta','Derecho',3),(1045,'Yuuta','Okkotsu','Furude',16,'Dormitorio JJK','Tokyo','555-1045','yuuta@jjk.jp','japonés','Literatura',2),(1046,'Mai','Sakurajima','Honda',17,'Distrito Fujisawa','Kanagawa','555-1046','mai@bunny.jp','japonesa','Actuación',3),(1047,'Sakuta','Azusagawa','Katsura',17,'Distrito Fujisawa','Kanagawa','555-1047','sakuta@bunny.jp','japonés','Psicología',3),(1048,'Nagisa','Furukawa','Shibata',17,'Aldea Hikarizaka','Hikarizaka','555-1048','nagisa@clannad.jp','japonesa','Música',3),(1049,'Tomoya','Okazaki','Midorima',17,'Aldea Hikarizaka','Hikarizaka','555-1049','tomoya@clannad.jp','japonés','Ingeniería',3),(1050,'Keiichi','Maebara','Kawamoto',16,'Casa Maebara','Hinamizawa','555-1000','keiichi@higurashi.jp','japonés','Artes',2),(1051,'Rena','Ryuuguu','Hanamura',16,'Casa Ryuuguu','Hinamizawa','555-1001','rena@higurashi.jp','japonesa','Diseño',2),(1052,'Mion','Sonozaki','Kashiwagi',17,'Mansión Sonozaki','Hinamizawa','555-1002','mion@higurashi.jp','japonesa','Administración',3),(1053,'Shion','Sonozaki','Kashiwagi',17,'Dormitorio St. Lucia','Okinomiya','555-1003','shion@higurashi.jp','japonesa','Psicología',3),(1054,'Satoko','Houjou','Yamasaki',14,'Casa Houjou','Hinamizawa','555-1004','satoko@higurashi.jp','japonesa','Arquitectura',1),(1055,'Rika','Furude','Miyazono',14,'Santuario Furude','Hinamizawa','555-1005','rika@higurashi.jp','japonesa','Religiones Comparadas',1),(1056,'Hanyu','Furude','Takashima',14,'Santuario Furude (anexo)','Hinamizawa','555-1006','hanyu@higurashi.jp','japonesa','Historia',1);
/*!40000 ALTER TABLE `alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `datos_u`
--

DROP TABLE IF EXISTS `datos_u`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `datos_u` (
  `identificador_u` int NOT NULL,
  `nombre_u` varchar(20) NOT NULL,
  `apellido_u` varchar(20) NOT NULL,
  `telefono_u` varchar(20) NOT NULL,
  `email_u` varchar(30) DEFAULT NULL,
  `id_tabla_usuarios` int NOT NULL,
  PRIMARY KEY (`identificador_u`),
  UNIQUE KEY `identificador_u` (`identificador_u`),
  UNIQUE KEY `id` (`id_tabla_usuarios`),
  CONSTRAINT `PK_usuarios` FOREIGN KEY (`id_tabla_usuarios`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `datos_u`
--

LOCK TABLES `datos_u` WRITE;
/*!40000 ALTER TABLE `datos_u` DISABLE KEYS */;
INSERT INTO `datos_u` VALUES (1,'Luis Ángel','Castillo','55-666-2007','ELANTICRISTO2007@youtube.com',2007),(2,'Niko','Bellic','555-2222','Nikobelico@youtube.com',95),(3,'Manuel','Vallin','984-181-1586','cairosneo@gmail.com',7);
/*!40000 ALTER TABLE `datos_u` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id` int NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `pass` varchar(20) NOT NULL,
  `tipo` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (7,'Eliluminado7','Kairos','Plebeyo'),(95,'Nikobelico','GTASA','Operador'),(2007,'ElAnticristo2007','Pipopes','El_Admin');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-11-24 21:57:18
