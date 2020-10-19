CREATE DATABASE  IF NOT EXISTS `hotel` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `hotel`;
-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: localhost    Database: hotel
-- ------------------------------------------------------
-- Server version	5.6.26-log

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
-- Table structure for table `alojamientos`
--

DROP TABLE IF EXISTS `alojamientos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alojamientos` (
  `id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `check_in` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `check_out` datetime DEFAULT NULL,
  `reservas_id` smallint(5) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_alojamientos_reservas1_idx` (`reservas_id`),
  CONSTRAINT `fk_alojamientos_reservas1` FOREIGN KEY (`reservas_id`) REFERENCES `reservas` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alojamientos`
--

LOCK TABLES `alojamientos` WRITE;
/*!40000 ALTER TABLE `alojamientos` DISABLE KEYS */;
/*!40000 ALTER TABLE `alojamientos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `boletas`
--

DROP TABLE IF EXISTS `boletas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `boletas` (
  `id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `serie` tinyint(3) unsigned NOT NULL,
  `numero` tinyint(3) unsigned NOT NULL,
  `det_comprobante_id` smallint(5) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_boletas_det_comprobante1_idx` (`det_comprobante_id`),
  CONSTRAINT `fk_boletas_det_comprobante1` FOREIGN KEY (`det_comprobante_id`) REFERENCES `det_comprobante` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `boletas`
--

LOCK TABLES `boletas` WRITE;
/*!40000 ALTER TABLE `boletas` DISABLE KEYS */;
/*!40000 ALTER TABLE `boletas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cambio_tipo_hab`
--

DROP TABLE IF EXISTS `cambio_tipo_hab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cambio_tipo_hab` (
  `habitaciones_id` tinyint(3) unsigned NOT NULL,
  `tipo_hab_id` tinyint(4) NOT NULL,
  `desde` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `hasta` datetime DEFAULT NULL,
  PRIMARY KEY (`habitaciones_id`,`tipo_hab_id`),
  KEY `fk_cambio_tipo_hab_habitaciones1_idx` (`habitaciones_id`),
  KEY `fk_cambio_tipo_hab_tipo_hab1` (`tipo_hab_id`),
  CONSTRAINT `fk_cambio_tipo_hab_habitaciones1` FOREIGN KEY (`habitaciones_id`) REFERENCES `habitaciones` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cambio_tipo_hab_tipo_hab1` FOREIGN KEY (`tipo_hab_id`) REFERENCES `tipo_hab` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cambio_tipo_hab`
--

LOCK TABLES `cambio_tipo_hab` WRITE;
/*!40000 ALTER TABLE `cambio_tipo_hab` DISABLE KEYS */;
/*!40000 ALTER TABLE `cambio_tipo_hab` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cargos`
--

DROP TABLE IF EXISTS `cargos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cargos` (
  `id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `cargo` varchar(45) NOT NULL,
  `sueldo` decimal(6,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cargos`
--

LOCK TABLES `cargos` WRITE;
/*!40000 ALTER TABLE `cargos` DISABLE KEYS */;
INSERT INTO `cargos` VALUES (1,'Gerente',2500.00),(2,'Recepcionista',1350.00),(3,'Personal de Limpieza',1150.00),(4,'Botones',1150.00),(5,'Chef',1890.00),(6,'Camarero',1150.00);
/*!40000 ALTER TABLE `cargos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clientes` (
  `id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `personas_id` smallint(5) unsigned NOT NULL,
  `provincias_id` smallint(5) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_clientes_personas1_idx` (`personas_id`),
  KEY `fk_clientes_provincias1_idx` (`provincias_id`),
  CONSTRAINT `fk_clientes_personas1` FOREIGN KEY (`personas_id`) REFERENCES `personas` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_clientes_provincias1` FOREIGN KEY (`provincias_id`) REFERENCES `provincias` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `datos_empresa`
--

DROP TABLE IF EXISTS `datos_empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `datos_empresa` (
  `id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `razon_social` varchar(45) NOT NULL,
  `ruc` varchar(11) NOT NULL,
  `telefono` int(9) unsigned zerofill DEFAULT NULL,
  `direccion` varchar(75) NOT NULL,
  `pagina_web` varchar(45) DEFAULT NULL,
  `url_logo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `datos_empresa`
--

LOCK TABLES `datos_empresa` WRITE;
/*!40000 ALTER TABLE `datos_empresa` DISABLE KEYS */;
INSERT INTO `datos_empresa` VALUES (1,'EMPRESA TURISTICA S & D E.I.R.L.','20603815816',043236408,'Av. Centenario No. 1187 Independencia - Huaraz -  Ancash',NULL,NULL);
/*!40000 ALTER TABLE `datos_empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deptos`
--

DROP TABLE IF EXISTS `deptos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `deptos` (
  `id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `depto` varchar(45) NOT NULL,
  `paises_id` tinyint(3) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_departamentos_paises1_idx` (`paises_id`),
  CONSTRAINT `fk_departamentos_paises1` FOREIGN KEY (`paises_id`) REFERENCES `paises` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deptos`
--

LOCK TABLES `deptos` WRITE;
/*!40000 ALTER TABLE `deptos` DISABLE KEYS */;
INSERT INTO `deptos` VALUES (1,'Ancash',1),(2,'Lima',1),(3,'Cusco',1),(4,'Nueva York',2),(5,'California',2),(6,'Florida',2),(7,'Buenos Aires',3),(8,'Santa Fe',3),(9,'Cordoba',3);
/*!40000 ALTER TABLE `deptos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `det_comprobante`
--

DROP TABLE IF EXISTS `det_comprobante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `det_comprobante` (
  `id` smallint(5) unsigned NOT NULL,
  `subtotal` decimal(6,2) DEFAULT '0.00',
  `descuento` decimal(5,2) DEFAULT '0.00',
  `total` decimal(6,2) DEFAULT '0.00',
  `alojamientos_id` smallint(5) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_detalle_comprobante_alojamientos1_idx` (`alojamientos_id`),
  CONSTRAINT `fk_detalle_comprobante_alojamientos1` FOREIGN KEY (`alojamientos_id`) REFERENCES `alojamientos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `det_comprobante`
--

LOCK TABLES `det_comprobante` WRITE;
/*!40000 ALTER TABLE `det_comprobante` DISABLE KEYS */;
/*!40000 ALTER TABLE `det_comprobante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleados`
--

DROP TABLE IF EXISTS `empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empleados` (
  `id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `telefono` int(9) unsigned zerofill DEFAULT NULL,
  `cargos_id` tinyint(3) unsigned NOT NULL,
  `personas_id` smallint(5) unsigned NOT NULL,
  `estado_empleo_id` tinyint(3) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_empleados_cargos1_idx` (`cargos_id`),
  KEY `fk_empleados_personas1_idx` (`personas_id`),
  KEY `fk_empleados_estado_empleo1_idx` (`estado_empleo_id`),
  CONSTRAINT `fk_empleados_cargos1` FOREIGN KEY (`cargos_id`) REFERENCES `cargos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_empleados_estado_empleo1` FOREIGN KEY (`estado_empleo_id`) REFERENCES `estado_empleo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_empleados_personas1` FOREIGN KEY (`personas_id`) REFERENCES `personas` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados`
--

LOCK TABLES `empleados` WRITE;
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
INSERT INTO `empleados` VALUES (1,NULL,1,1,1),(2,963258741,2,2,1),(3,NULL,5,3,1);
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER crear_usuario AFTER INSERT ON empleados
FOR EACH ROW
BEGIN
  IF NEW.cargos_id in (select id from cargos where cargo in ('Gerente', 'Recepcionista'))
    THEN
		set @dni = (select dni from personas where id = new.personas_id);
		insert into usuarios (usuario, contrasena, empleados_id) values (@dni, md5(@dni), new.id);
  END IF ;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER des_habilitar_usuario AFTER UPDATE ON empleados
FOR EACH ROW
BEGIN

	set @esta_habilitado = (NEW.cargos_id in (select id from cargos where cargo in ('Gerente', 'Recepcionista')));
	update usuarios set habilitado = @esta_habilitado where empleados_id = old.id;
		
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `empresas`
--

DROP TABLE IF EXISTS `empresas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empresas` (
  `id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `ruc` varchar(11) NOT NULL,
  `razon_social` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ruc_UNIQUE` (`ruc`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresas`
--

LOCK TABLES `empresas` WRITE;
/*!40000 ALTER TABLE `empresas` DISABLE KEYS */;
/*!40000 ALTER TABLE `empresas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estado_empleo`
--

DROP TABLE IF EXISTS `estado_empleo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estado_empleo` (
  `id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `estado` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estado_empleo`
--

LOCK TABLES `estado_empleo` WRITE;
/*!40000 ALTER TABLE `estado_empleo` DISABLE KEYS */;
INSERT INTO `estado_empleo` VALUES (1,'Activo'),(2,'Despedido');
/*!40000 ALTER TABLE `estado_empleo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estado_hab`
--

DROP TABLE IF EXISTS `estado_hab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estado_hab` (
  `id` tinyint(4) NOT NULL AUTO_INCREMENT,
  `estado` varchar(45) NOT NULL,
  `color` varchar(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estado_hab`
--

LOCK TABLES `estado_hab` WRITE;
/*!40000 ALTER TABLE `estado_hab` DISABLE KEYS */;
INSERT INTO `estado_hab` VALUES (1,'Disponible','70E083'),(2,'Reservado','FAC56B'),(3,'Ocupado','FF5374'),(4,'En mantenimiento','3395FF');
/*!40000 ALTER TABLE `estado_hab` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estado_reserva`
--

DROP TABLE IF EXISTS `estado_reserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estado_reserva` (
  `id` tinyint(4) NOT NULL AUTO_INCREMENT,
  `estado` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estado_reserva`
--

LOCK TABLES `estado_reserva` WRITE;
/*!40000 ALTER TABLE `estado_reserva` DISABLE KEYS */;
INSERT INTO `estado_reserva` VALUES (1,'En espera'),(2,'Cancelado'),(3,'Aceptado');
/*!40000 ALTER TABLE `estado_reserva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facturas`
--

DROP TABLE IF EXISTS `facturas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `facturas` (
  `id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `serie` tinyint(3) unsigned NOT NULL,
  `numero` tinyint(3) unsigned NOT NULL,
  `det_comprobante_id` smallint(5) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_facturas_det_comprobante1_idx` (`det_comprobante_id`),
  CONSTRAINT `fk_facturas_det_comprobante1` FOREIGN KEY (`det_comprobante_id`) REFERENCES `det_comprobante` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facturas`
--

LOCK TABLES `facturas` WRITE;
/*!40000 ALTER TABLE `facturas` DISABLE KEYS */;
/*!40000 ALTER TABLE `facturas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `habitaciones`
--

DROP TABLE IF EXISTS `habitaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `habitaciones` (
  `id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `numero` varchar(5) NOT NULL,
  `estado_hab_id` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `numero_UNIQUE` (`numero`),
  KEY `fk_habitaciones_estado_hab1_idx` (`estado_hab_id`),
  CONSTRAINT `fk_habitaciones_estado_hab1` FOREIGN KEY (`estado_hab_id`) REFERENCES `estado_hab` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `habitaciones`
--

LOCK TABLES `habitaciones` WRITE;
/*!40000 ALTER TABLE `habitaciones` DISABLE KEYS */;
/*!40000 ALTER TABLE `habitaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paises`
--

DROP TABLE IF EXISTS `paises`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paises` (
  `id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `pais` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paises`
--

LOCK TABLES `paises` WRITE;
/*!40000 ALTER TABLE `paises` DISABLE KEYS */;
INSERT INTO `paises` VALUES (1,'Peru'),(2,'EE.UU.'),(3,'Argentina');
/*!40000 ALTER TABLE `paises` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `periodo_trabajo`
--

DROP TABLE IF EXISTS `periodo_trabajo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `periodo_trabajo` (
  `id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `contratacion` date NOT NULL,
  `despido` date DEFAULT NULL,
  `empleados_id` smallint(5) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_periodo_trabajo_empleados1_idx` (`empleados_id`),
  CONSTRAINT `fk_periodo_trabajo_empleados1` FOREIGN KEY (`empleados_id`) REFERENCES `empleados` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `periodo_trabajo`
--

LOCK TABLES `periodo_trabajo` WRITE;
/*!40000 ALTER TABLE `periodo_trabajo` DISABLE KEYS */;
INSERT INTO `periodo_trabajo` VALUES (1,'2020-09-18',NULL,1),(2,'2020-09-23',NULL,2),(4,'2020-10-12',NULL,3);
/*!40000 ALTER TABLE `periodo_trabajo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personal_empresa`
--

DROP TABLE IF EXISTS `personal_empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `personal_empresa` (
  `clientes_id` smallint(5) unsigned NOT NULL,
  `empresas_id` smallint(5) unsigned NOT NULL,
  PRIMARY KEY (`clientes_id`,`empresas_id`),
  KEY `fk_personal_empresa_empresas1_idx` (`empresas_id`),
  CONSTRAINT `fk_personal_empresa_clientes1` FOREIGN KEY (`clientes_id`) REFERENCES `clientes` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_personal_empresa_empresas1` FOREIGN KEY (`empresas_id`) REFERENCES `empresas` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personal_empresa`
--

LOCK TABLES `personal_empresa` WRITE;
/*!40000 ALTER TABLE `personal_empresa` DISABLE KEYS */;
/*!40000 ALTER TABLE `personal_empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personas`
--

DROP TABLE IF EXISTS `personas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `personas` (
  `id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `dni` int(8) unsigned zerofill DEFAULT NULL,
  `ap_paterno` varchar(45) NOT NULL,
  `ap_materno` varchar(45) DEFAULT NULL,
  `nombres` varchar(45) NOT NULL,
  `correo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `dni_UNIQUE` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personas`
--

LOCK TABLES `personas` WRITE;
/*!40000 ALTER TABLE `personas` DISABLE KEYS */;
INSERT INTO `personas` VALUES (1,32145698,'Paucar','Colonia','Frank',NULL),(2,40125784,'Melgarejo',NULL,'Jescenia',NULL),(3,41257016,'Pineda','Quispe','Gonzalo','gonzalo@mail.com');
/*!40000 ALTER TABLE `personas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `provincias`
--

DROP TABLE IF EXISTS `provincias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `provincias` (
  `id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `provincia` varchar(45) NOT NULL,
  `deptos_id` smallint(5) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_provincias_deptos1_idx` (`deptos_id`),
  CONSTRAINT `fk_provincias_deptos1` FOREIGN KEY (`deptos_id`) REFERENCES `deptos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provincias`
--

LOCK TABLES `provincias` WRITE;
/*!40000 ALTER TABLE `provincias` DISABLE KEYS */;
INSERT INTO `provincias` VALUES (1,'Huaraz',1),(2,'Santa',1),(3,'Huarmey',1),(4,'Lima',2),(5,'Barranca',2),(6,'Espinar',3),(7,'Manhattan',4),(8,'Brooklyn',4),(9,'Queens',4),(10,'Los Angeles',5),(11,'San Francisco',5),(12,'Jacksonville',6),(13,'Miami',6),(14,'Belgrano',7),(15,'Almagro',7),(16,'Centro',8),(17,'Santa Cruz',9);
/*!40000 ALTER TABLE `provincias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservas`
--

DROP TABLE IF EXISTS `reservas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reservas` (
  `id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `fecha_reserva` datetime DEFAULT CURRENT_TIMESTAMP,
  `fecha_entrada` date NOT NULL,
  `fecha_salida` date NOT NULL,
  `estado_reserva_id` tinyint(4) NOT NULL,
  `habitaciones_id` tinyint(3) unsigned NOT NULL,
  `clientes_id` smallint(5) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_reservas_estado_reserva1_idx` (`estado_reserva_id`),
  KEY `fk_reservas_habitaciones1_idx` (`habitaciones_id`),
  KEY `fk_reservas_clientes1_idx` (`clientes_id`),
  CONSTRAINT `fk_reservas_clientes1` FOREIGN KEY (`clientes_id`) REFERENCES `clientes` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_reservas_estado_reserva1` FOREIGN KEY (`estado_reserva_id`) REFERENCES `estado_reserva` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_reservas_habitaciones1` FOREIGN KEY (`habitaciones_id`) REFERENCES `habitaciones` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservas`
--

LOCK TABLES `reservas` WRITE;
/*!40000 ALTER TABLE `reservas` DISABLE KEYS */;
/*!40000 ALTER TABLE `reservas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicio_prestado`
--

DROP TABLE IF EXISTS `servicio_prestado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `servicio_prestado` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `cantidad` decimal(3,1) NOT NULL,
  `fecha_servicio` datetime DEFAULT CURRENT_TIMESTAMP,
  `servicios_id` tinyint(3) unsigned NOT NULL,
  `alojamientos_id` smallint(5) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_servicio_prestado_servicios1_idx` (`servicios_id`),
  KEY `fk_servicio_prestado_alojamientos1_idx` (`alojamientos_id`),
  CONSTRAINT `fk_servicio_prestado_alojamientos1` FOREIGN KEY (`alojamientos_id`) REFERENCES `alojamientos` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_servicio_prestado_servicios1` FOREIGN KEY (`servicios_id`) REFERENCES `servicios` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicio_prestado`
--

LOCK TABLES `servicio_prestado` WRITE;
/*!40000 ALTER TABLE `servicio_prestado` DISABLE KEYS */;
/*!40000 ALTER TABLE `servicio_prestado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicios`
--

DROP TABLE IF EXISTS `servicios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `servicios` (
  `id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `servicio` varchar(45) NOT NULL,
  `precio` decimal(5,2) NOT NULL,
  `unidad_medida_id` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_servicios_unidad_medida1_idx` (`unidad_medida_id`),
  CONSTRAINT `fk_servicios_unidad_medida1` FOREIGN KEY (`unidad_medida_id`) REFERENCES `unidad_medida` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicios`
--

LOCK TABLES `servicios` WRITE;
/*!40000 ALTER TABLE `servicios` DISABLE KEYS */;
INSERT INTO `servicios` VALUES (1,'Desayuno',5.00,3),(2,'Lavanderia',2.50,2);
/*!40000 ALTER TABLE `servicios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_hab`
--

DROP TABLE IF EXISTS `tipo_hab`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_hab` (
  `id` tinyint(4) NOT NULL AUTO_INCREMENT,
  `tipo_hab` varchar(45) NOT NULL,
  `precio` decimal(5,2) NOT NULL,
  `unidad_medida_id` tinyint(4) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_tipo_hab_unidad_medida1_idx` (`unidad_medida_id`),
  CONSTRAINT `fk_tipo_hab_unidad_medida1` FOREIGN KEY (`unidad_medida_id`) REFERENCES `unidad_medida` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_hab`
--

LOCK TABLES `tipo_hab` WRITE;
/*!40000 ALTER TABLE `tipo_hab` DISABLE KEYS */;
INSERT INTO `tipo_hab` VALUES (1,'Individual',95.00,1),(2,'Doble',135.00,1),(3,'Triple',185.00,1),(4,'Matrimonial',185.00,1);
/*!40000 ALTER TABLE `tipo_hab` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unidad_medida`
--

DROP TABLE IF EXISTS `unidad_medida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `unidad_medida` (
  `id` tinyint(4) NOT NULL AUTO_INCREMENT,
  `unidad` varchar(45) NOT NULL,
  `abrev` varchar(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unidad_medida`
--

LOCK TABLES `unidad_medida` WRITE;
/*!40000 ALTER TABLE `unidad_medida` DISABLE KEYS */;
INSERT INTO `unidad_medida` VALUES (1,'Dias','Dia'),(2,'Kilogramos','Kg'),(3,'Unidades','Ud');
/*!40000 ALTER TABLE `unidad_medida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `usuario` varchar(45) NOT NULL,
  `contrasena` varchar(45) NOT NULL,
  `empleados_id` smallint(5) unsigned NOT NULL,
  `habilitado` tinyint(4) DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `usuario_UNIQUE` (`usuario`),
  KEY `fk_usuarios_empleados1_idx` (`empleados_id`),
  CONSTRAINT `fk_usuarios_empleados1` FOREIGN KEY (`empleados_id`) REFERENCES `empleados` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'32145698','4b230338cc1174886bf8609cbe292619',1,1),(2,'40125784','bf456601245c0b69cae995e18d555c8a',2,1);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'hotel'
--
/*!50003 DROP FUNCTION IF EXISTS `f_crear_usuario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `f_crear_usuario`(_persona_id int) RETURNS tinyint(1)
BEGIN

	-- verificar que esta persona sea empleado
	if (select count(*) from empleados where personas_id = _persona_id = 1) then
		-- verificar que aun no tenga usuario
		if (select count(*) from usuarios where empleados_id = (select id from empleados where personas_id = _persona_id)) = 0 then
			set @usuario = (select dni from personas where id = _persona_id);
			set @contrasena = md5((select dni from personas where id = _persona_id));
			insert into usuarios (usuario, contrasena, empleados_id) values (@usuario, @contrasena, (select id from empleados where personas_id = _persona_id));
			return true;
		else
			return false;
		end if;
	else
		return false;
    end if;

	
RETURN false;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `f_existe_persona` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `f_existe_persona`(_dni int(8), _ap_pat varchar(45), _ap_mat varchar(45), _nombres varchar(45)) RETURNS tinyint(1)
BEGIN
	
    declare rsta bool default false;
    
	if (_dni is not null) then
		set rsta = if ((select count(id) from personas where dni = _dni) > 0, true, false); 
	else
		if (_ap_mat is not null) then
			set rsta = if ((select count(id) from personas where ap_paterno = _ap_pat and ap_materno = _ap_mat and nombres = _nombres) > 0, true, false);
        else
			set rsta = if ((select count(id) from personas where ap_paterno = _ap_pat and ap_materno = _ap_mat and nombres = _nombres) > 0, true, false);
        end if;
    end if;
    
RETURN rsta;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_actualizar_empleado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_actualizar_empleado`(in _empleado_id smallint, _dni int(8), _ap_pat varchar(45), _ap_mat varchar(45), _nombres varchar(45), _correo varchar(45), _telefono int(9), _cargo varchar(45), _estado_empleo varchar(45))
BEGIN

	set @persona_id = (select personas_id from empleados where id = _empleado_id);
    
    if (@persona_id is not null) then
		if (length(_dni) = 8) then
			update personas set dni = _dni, ap_paterno = _ap_pat, ap_materno = _ap_mat, nombres = _nombres, correo = _correo where id = @persona_id;
            update empleados set telefono = _telefono, cargos_id = (select id from cargos where cargo = _cargo), personas_id = @persona_id, estado_empleo_id = (select id from estado_empleo where estado = _estado_empleo) where id = _empleado_id;
		else
			select false codigo, 'El DNI debe tener 8 caracteres' mensaje; 
        end if;
	else
		select false codigo, 'Este empleado aun no esta registrado' mensaje;
    end if;
    

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_registrar_empleado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_registrar_empleado`(in _dni int(8), _ap_pat varchar(45), _ap_mat varchar(45), _nombres varchar(45), _correo varchar(45), _telefono int(9), _cargo varchar(45))
BEGIN
	
    declare _persona_id int default 0;
    
    if (length(_dni) = 8) then
		-- Verieficar si existe o no la persona
		if (!f_existe_persona(_dni, _ap_pat, _ap_mat, _nombres)) then
			
			-- Si la persona no existe, lo creamos
			insert into personas (dni, ap_paterno, ap_materno, nombres, correo) values (_dni, _ap_pat, _ap_mat, _nombres, _correo);		
			set _persona_id = (select id from personas order by id desc limit 1);
					
		end if;
		
		-- Conseguir el id de la persona si ya existia en la BD
		if (_persona_id = 0) then
			set _persona_id = (select id from personas where dni = _dni);
		end if;
		
		-- Registrar el empleado
		if (select count(*) from empleados where personas_id = _persona_id) = 0 then
			
			insert into empleados (telefono, cargos_id, personas_id, estado_empleo_id) values (_telefono, (select id from cargos where cargo = _cargo), _persona_id, (select id from estado_empleo where estado = 'Activo'));
						   
			-- Registrar la fecha de contratacion
			insert into periodo_trabajo (contratacion, empleados_id) values ( curdate(), (select id from empleados where personas_id = _persona_id));
					
			select true codigo, concat_ws(' ', 'El empleado', _ap_pat, _ap_mat, _nombres, 'se registró exitosamente') mensaje;
		else
			select false codigo, concat_ws(' ', 'El empleado',  _ap_pat, _ap_mat, _nombres, 'ya estaba registrado') mensaje;        
		end if;
    
    else
		select false codigo, 'El DNI debe tener 8 caracteres' mensaje;    
    end if;
    
      
    
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-10-19 10:11:15
