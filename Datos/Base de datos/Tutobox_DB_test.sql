-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: tutobox
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `curso`
--

DROP TABLE IF EXISTS `curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `curso` (
  `idCurso` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idCurso`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` VALUES (1,'Geografia'),(2,'Matematicas'),(3,'Historia'),(4,'Fisica'),(5,'Biologia'),(6,'Literatura'),(7,'Quimica'),(8,'Arte'),(9,'Ingles'),(10,'Introduccion a laProgramacion'),(11,'Economia'),(12,'Filosofia'),(13,'Programacion Web'),(14,'Ciencias Sociales'),(15,'Gestion Financiera');
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mensaje`
--

DROP TABLE IF EXISTS `mensaje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mensaje` (
  `idMensaje` int NOT NULL AUTO_INCREMENT,
  `asunto` varchar(70) DEFAULT NULL,
  `cuerpo` varchar(500) DEFAULT NULL,
  `fechaEnvio` varchar(50) DEFAULT NULL,
  `idUsuarioEmisor` int DEFAULT NULL,
  `idUsuarioReceptor` int DEFAULT NULL,
  PRIMARY KEY (`idMensaje`),
  KEY `fk_usuemi_usu_idx` (`idUsuarioEmisor`),
  KEY `fk_usurec_usu_idx` (`idUsuarioReceptor`),
  CONSTRAINT `fk_usuemi_usu` FOREIGN KEY (`idUsuarioEmisor`) REFERENCES `usuario` (`idUsuario`),
  CONSTRAINT `fk_usurec_usu` FOREIGN KEY (`idUsuarioReceptor`) REFERENCES `usuario` (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mensaje`
--

LOCK TABLES `mensaje` WRITE;
/*!40000 ALTER TABLE `mensaje` DISABLE KEYS */;
INSERT INTO `mensaje` VALUES (1,'ayuda','Buenas tardes me puede apoyar en el problema 15 del libro?','2023-06-06',1,4),(2,'consulta','Tengo una duda sobre el tema de geometría','2023-06-07',2,4),(3,'solicitud','Necesito una extensión para entregar el trabajo final','2023-06-08',3,6),(4,'pregunta','¿Cuál es la fecha límite para entregar el proyecto?','2023-06-08',1,8),(5,'reunión','¿Podemos programar una reunión para discutir el proyecto?','2023-06-09',5,8),(6,'duda','No entiendo cómo resolver el ejercicio de álgebra','2023-06-09',7,10),(7,'recordatorio','Recuerda entregar el informe antes del viernes','2023-06-10',9,12),(8,'urgente','Necesito ayuda inmediata con el ejercicio de física','2023-06-10',11,6),(9,'confirmación','Por favor, confirma tu asistencia al evento','2023-06-11',13,8),(10,'información','Adjunto encontrarás el archivo con los detalles del proyecto','2023-06-11',1,10),(11,'sugerencia','¿Qué te parece si implementamos esta idea?','2023-06-12',2,12),(12,'problema','Estoy experimentando un error en el programa','2023-06-12',3,4),(13,'consulta','¿Cuáles son los requisitos para el proyecto?','2023-06-13',5,6),(14,'ayuda','No puedo acceder a mi cuenta, ¿puedes ayudarme?','2023-06-13',7,8),(15,'seguimiento','Quería hacer un seguimiento sobre el estado de mi solicitud','2023-06-14',9,10),(16,'duda','Tengo una pregunta sobre el ejercicio de química','2023-06-14',11,12),(17,'recordatorio','No olvides entregar el formulario firmado','2023-06-15',13,4),(18,'urgente','Necesito asesoramiento sobre el proyecto de biología','2023-06-15',1,12),(19,'confirmación','Confirma tu participación en el taller','2023-06-16',2,10),(20,'información','Adjunto encontrarás el enlace al material de estudio','2023-06-16',3,8);
/*!40000 ALTER TABLE `mensaje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `publicacion`
--

DROP TABLE IF EXISTS `publicacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `publicacion` (
  `idPublicacion` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(100) DEFAULT NULL,
  `cuerpo` varchar(500) DEFAULT NULL,
  `fecha` varchar(50) DEFAULT NULL,
  `documento` blob,
  `idCurso` int DEFAULT NULL,
  `idUsuario` int DEFAULT NULL,
  PRIMARY KEY (`idPublicacion`),
  KEY `fk_curso_publi_idx` (`idCurso`),
  KEY `fk_usu_publi_idx` (`idUsuario`),
  CONSTRAINT `fk_curso_publi` FOREIGN KEY (`idCurso`) REFERENCES `curso` (`idCurso`),
  CONSTRAINT `fk_usu_publi` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publicacion`
--

LOCK TABLES `publicacion` WRITE;
/*!40000 ALTER TABLE `publicacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `publicacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipousuario`
--

DROP TABLE IF EXISTS `tipousuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipousuario` (
  `idTipousuario` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idTipousuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipousuario`
--

LOCK TABLES `tipousuario` WRITE;
/*!40000 ALTER TABLE `tipousuario` DISABLE KEYS */;
INSERT INTO `tipousuario` VALUES (1,'Alumno'),(2,'Tutor');
/*!40000 ALTER TABLE `tipousuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tutoria`
--

DROP TABLE IF EXISTS `tutoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tutoria` (
  `idTutoria` int NOT NULL AUTO_INCREMENT,
  `tema` varchar(100) DEFAULT NULL,
  `estado` varchar(50) DEFAULT NULL,
  `fecha` varchar(50) DEFAULT NULL,
  `horaIni` varchar(50) DEFAULT NULL,
  `horaFin` varchar(50) DEFAULT NULL,
  `puntuacion` int DEFAULT NULL,
  `comentario` varchar(300) DEFAULT NULL,
  `estadoPago` tinyint DEFAULT NULL,
  `idTutor` int DEFAULT NULL,
  `idEstudiante` int DEFAULT NULL,
  `idCurso` int DEFAULT NULL,
  PRIMARY KEY (`idTutoria`),
  KEY `fk_tutoria_usuario_idx` (`idTutor`),
  KEY `fk_curso_tuto_idx` (`idCurso`),
  KEY `fk_est_tuto_idx` (`idEstudiante`),
  CONSTRAINT `fk_curso_tuto` FOREIGN KEY (`idCurso`) REFERENCES `curso` (`idCurso`),
  CONSTRAINT `fk_est_tuto` FOREIGN KEY (`idEstudiante`) REFERENCES `usuario` (`idUsuario`),
  CONSTRAINT `fk_usu_tuto` FOREIGN KEY (`idTutor`) REFERENCES `usuario` (`idUsuario`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tutoria`
--

LOCK TABLES `tutoria` WRITE;
/*!40000 ALTER TABLE `tutoria` DISABLE KEYS */;
/*!40000 ALTER TABLE `tutoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `idUsuario` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `apellidos` varchar(45) DEFAULT NULL,
  `correo` varchar(100) DEFAULT NULL,
  `contrasena` varchar(100) DEFAULT NULL,
  `idTipo` int DEFAULT NULL,
  PRIMARY KEY (`idUsuario`),
  KEY `fk_usu_tipo_idx` (`idTipo`),
  CONSTRAINT `fk_usu_tipo` FOREIGN KEY (`idTipo`) REFERENCES `tipousuario` (`idTipousuario`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Pedro ','Diaz','diazallca@gmail.com','123456',1),(2,'Diego','Arroyo','diego.arroyo@gmail.com','123456',1),(3,'Javier','Mendez','javier@example.com','abcdef',1),(4,'Maria','Guevara','maria@example.com','abcdef',2),(5,'Juan','Perez','juan@example.com','123456',1),(6,'Luisa','Gonzalez','luisa@example.com','123456',2),(7,'Pedro','Ramirez','pedro@example.com','123456',1),(8,'Ana','Lopez','ana@example.com','123456',2),(9,'Carlos','Martinez','carlos@example.com','123456',1),(10,'Sofia','Sanchez','sofia@example.com','hello123',2),(11,'Manuel','Rodriguez','manuel@example.com','secret',1),(12,'Laura','Torres','laura@example.com','123456',2),(13,'Diego','Hernandez','diego@example.com','123456',1);
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

-- Dump completed on 2023-06-09 12:51:16
