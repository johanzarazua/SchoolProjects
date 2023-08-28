CREATE DATABASE  IF NOT EXISTS `Hotel` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `Hotel`;
-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: hotel
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `idPersona` int(11) NOT NULL,
  `tipo` varchar(45) NOT NULL,
  `descuento` int(2) DEFAULT NULL,
  `usuario` varchar(45) NOT NULL,
  `contrasena` varchar(45) NOT NULL,
  `estadoLog` varchar(45) NOT NULL,
  `preguntaSeguridad` varchar(700) DEFAULT NULL,
  `respuetaSeguridad` varchar(700) DEFAULT NULL,
  PRIMARY KEY (`idPersona`),
  UNIQUE KEY `usuario_UNIQUE` (`usuario`),
  CONSTRAINT `cliente_persona` FOREIGN KEY (`idPersona`) REFERENCES `persona` (`idPersona`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (4,'Habitual',10,'LPS','123456789','Activa','¿Cual es tu comida favorita?','tacos'),(5,'VIP',15,'paty','monchis123','Activa','¿Cual fue el nombre de tu primer mascota?','copo'),(6,'Ocasional',5,'pSp','123456789','Activa','¿Cual es tu comida favorita?','tacos');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compra`
--

DROP TABLE IF EXISTS `compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compra` (
  `idCompra` int(11) NOT NULL AUTO_INCREMENT,
  `idReservacion` int(11) NOT NULL,
  `idServicio` int(11) NOT NULL,
  `fecha_compra` date NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio` decimal(7,2) NOT NULL,
  `estado` varchar(15) NOT NULL,
  PRIMARY KEY (`idCompra`),
  KEY `compra_reservacion_idx` (`idReservacion`),
  KEY `compra_servicios_idx` (`idServicio`),
  CONSTRAINT `compra_reservacion` FOREIGN KEY (`idReservacion`) REFERENCES `reservacion` (`idReservacion`),
  CONSTRAINT `compra_servicios` FOREIGN KEY (`idServicio`) REFERENCES `servicio` (`idServicio`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra`
--

LOCK TABLES `compra` WRITE;
/*!40000 ALTER TABLE `compra` DISABLE KEYS */;
INSERT INTO `compra` VALUES (2,5,4,'2019-11-17',1,350.00,'En cargo'),(3,5,5,'2019-11-17',1,450.00,'En cargo'),(4,5,6,'2019-11-17',1,348.00,'En cargo'),(8,5,5,'2019-11-17',2,450.00,'En cargo'),(21,5,6,'2019-11-17',4,348.00,'En cargo'),(22,5,4,'2019-11-17',1,350.00,'En cargo'),(23,9,4,'2019-11-18',1,350.00,'En cargo'),(24,8,6,'2019-11-18',3,348.00,'En cargo');
/*!40000 ALTER TABLE `compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `habitacion`
--

DROP TABLE IF EXISTS `habitacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `habitacion` (
  `idHabitacion` int(11) NOT NULL AUTO_INCREMENT,
  `numero` int(3) NOT NULL,
  `piso` int(2) NOT NULL,
  `tipo` varchar(45) NOT NULL,
  `camas` int(11) NOT NULL,
  `estado` varchar(15) NOT NULL,
  `descripcion` varchar(550) NOT NULL,
  `precioNoche` decimal(7,2) NOT NULL,
  PRIMARY KEY (`idHabitacion`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `habitacion`
--

LOCK TABLES `habitacion` WRITE;
/*!40000 ALTER TABLE `habitacion` DISABLE KEYS */;
INSERT INTO `habitacion` VALUES (4,10,1,'Matrimonial',1,'Disponible','Habitacion matrimonial con vista a la playa',1500.00),(5,4,2,'Individual',1,'Disponible','Habitacion individual cerca del elevador.',800.00),(6,15,5,'Familiar',2,'Ocupado','Habitacion familiar con dos camas cerca de\nrestaurante\n',1200.00),(7,20,1,'Presidencial',4,'Ocupado','Habitacion presidencial con bar y mesa\nde billar',4500.00),(8,7,1,'Familiar',3,'Disponible','habitacion con 1 cama matrimonial y 2 individuales',1965.00);
/*!40000 ALTER TABLE `habitacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pago`
--

DROP TABLE IF EXISTS `pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pago` (
  `idPago` int(11) NOT NULL AUTO_INCREMENT,
  `idCompra` int(11) NOT NULL,
  `fecha_emision` date NOT NULL,
  `fecha_pago` date NOT NULL,
  `tipoPago` varchar(45) NOT NULL,
  `comprobante` varchar(45) NOT NULL,
  `numeroComprobante` varchar(45) NOT NULL,
  `total` decimal(7,2) DEFAULT NULL,
  PRIMARY KEY (`idPago`),
  KEY `pago_reservacion_idx` (`idCompra`),
  CONSTRAINT `pago_reservacion` FOREIGN KEY (`idCompra`) REFERENCES `reservacion` (`idReservacion`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pago`
--

LOCK TABLES `pago` WRITE;
/*!40000 ALTER TABLE `pago` DISABLE KEYS */;
INSERT INTO `pago` VALUES (4,5,'2019-11-19','2019-11-20','Tarjeta','Factura','10',8290.00);
/*!40000 ALTER TABLE `pago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `persona` (
  `idPersona` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `aPaterno` varchar(45) NOT NULL,
  `aMaterno` varchar(45) NOT NULL,
  `telefono` varchar(10) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`idPersona`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `telefono_UNIQUE` (`telefono`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1,'Ricardo','Carrillo','Sanchez','5552545856','richi@gmail.com'),(2,'Alejandro','Hernandez','Gomez','5552515457','ale@gmail.com'),(3,'Johan','Zarazua','Ramirez','5552535659','johan@gmail.com'),(4,'Luis','Perez','Salazar','5556595857','LPS03@gmail.com'),(5,'Paty','Ramirez','Balderas','5551525354','paty@gmail.com'),(6,'Pedro','Sanchez','Perez','5550525154','pSp@gmail.com');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservacion`
--

DROP TABLE IF EXISTS `reservacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservacion` (
  `idReservacion` int(11) NOT NULL AUTO_INCREMENT,
  `idCliente` int(11) NOT NULL,
  `idTrabajador` int(11) NOT NULL,
  `idHabitacion` int(11) NOT NULL,
  `fecha_tramite` date NOT NULL,
  `fechaIngreso` date NOT NULL,
  `fechaSalida` date NOT NULL,
  `estado` varchar(15) NOT NULL,
  `costo` decimal(7,2) NOT NULL,
  PRIMARY KEY (`idReservacion`),
  KEY `reservacion_cliente_idx` (`idCliente`),
  KEY `reservacion_trabajador_idx` (`idTrabajador`),
  KEY `reservacion_habitacion_idx` (`idHabitacion`),
  CONSTRAINT `reservacion_cliente` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idPersona`),
  CONSTRAINT `reservacion_habitacion` FOREIGN KEY (`idHabitacion`) REFERENCES `habitacion` (`idHabitacion`),
  CONSTRAINT `reservacion_trabajador` FOREIGN KEY (`idTrabajador`) REFERENCES `trabajador` (`idPersona`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservacion`
--

LOCK TABLES `reservacion` WRITE;
/*!40000 ALTER TABLE `reservacion` DISABLE KEYS */;
INSERT INTO `reservacion` VALUES (5,5,3,4,'2019-11-17','2019-11-22','2019-11-24','Pagada',4500.00),(8,4,3,5,'2019-11-18','2019-11-20','2019-11-23','Pagada',1200.00),(9,6,3,5,'2019-11-18','2019-11-21','2019-11-23','Pagada',500.00);
/*!40000 ALTER TABLE `reservacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicio`
--

DROP TABLE IF EXISTS `servicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `servicio` (
  `idServicio` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(45) NOT NULL,
  `descripcion` varchar(550) NOT NULL,
  `precio` decimal(7,2) NOT NULL,
  PRIMARY KEY (`idServicio`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicio`
--

LOCK TABLES `servicio` WRITE;
/*!40000 ALTER TABLE `servicio` DISABLE KEYS */;
INSERT INTO `servicio` VALUES (4,'wifi','internet',350.00),(5,'gimnasio','gimnasio con aparatos electricos',450.00),(6,'guarderia','servicio de guarderia de 7 a 24',348.00);
/*!40000 ALTER TABLE `servicio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trabajador`
--

DROP TABLE IF EXISTS `trabajador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trabajador` (
  `idPersona` int(11) NOT NULL,
  `sueldo` decimal(7,2) NOT NULL,
  `puesto` varchar(45) NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `contrasena` varchar(45) NOT NULL,
  `estadoLog` varchar(15) NOT NULL,
  `preguntaSeguridad` varchar(700) DEFAULT NULL,
  `respuetaSeguridad` varchar(700) DEFAULT NULL,
  PRIMARY KEY (`idPersona`),
  UNIQUE KEY `usuario_UNIQUE` (`usuario`),
  CONSTRAINT `trabajador_persona` FOREIGN KEY (`idPersona`) REFERENCES `persona` (`idPersona`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trabajador`
--

LOCK TABLES `trabajador` WRITE;
/*!40000 ALTER TABLE `trabajador` DISABLE KEYS */;
INSERT INTO `trabajador` VALUES (1,99999.00,'Sub-Gerente','richi','Reikiavik1','Activa','¿Cual es tu equipo deportivo favorito?','Arsenal'),(2,99999.00,'Gerente','ale','Spartan123','Activa','¿Cual es tu equipo deportivo favorito?','Barca'),(3,99999.00,'Director','johan','johan','Activa','¿Cual es tu equipo deportivo favorito?','Pumas');
/*!40000 ALTER TABLE `trabajador` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-18 15:40:35
