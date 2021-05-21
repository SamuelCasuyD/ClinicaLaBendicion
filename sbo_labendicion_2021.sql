-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3308
-- Tiempo de generación: 21-05-2021 a las 01:53:42
-- Versión del servidor: 8.0.18
-- Versión de PHP: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sbo_labendicion_2021`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `expedientes`
--

DROP TABLE IF EXISTS `expedientes`;
CREATE TABLE IF NOT EXISTS `expedientes` (
  `idexpediente` int(11) NOT NULL AUTO_INCREMENT,
  `NoExpediente` varchar(30) NOT NULL,
  `Dpi` varchar(15) NOT NULL,
  `PrimerNombre` varchar(50) NOT NULL,
  `SegundoNombre` varchar(50) DEFAULT NULL,
  `OtroNombre` varchar(50) DEFAULT NULL,
  `PrimerApellido` varchar(50) NOT NULL,
  `SegundoApellido` varchar(50) DEFAULT NULL,
  `FechaNacimiento` varchar(12) NOT NULL,
  `TelDomicilio` varchar(15) DEFAULT NULL,
  `TelMovil` varchar(15) DEFAULT NULL,
  `Eamil` varchar(75) DEFAULT NULL,
  `Nit` varchar(10) DEFAULT NULL,
  `FechaCreacion` varchar(25) NOT NULL,
  `FechaModificacion` varchar(25) DEFAULT NULL,
  `UsuaroiCreacion` int(11) NOT NULL,
  `UsuarioModificaion` int(11) DEFAULT NULL,
  `numeroFactura` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idexpediente`),
  UNIQUE KEY `NoExpediente` (`NoExpediente`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `expedientes`
--

INSERT INTO `expedientes` (`idexpediente`, `NoExpediente`, `Dpi`, `PrimerNombre`, `SegundoNombre`, `OtroNombre`, `PrimerApellido`, `SegundoApellido`, `FechaNacimiento`, `TelDomicilio`, `TelMovil`, `Eamil`, `Nit`, `FechaCreacion`, `FechaModificacion`, `UsuaroiCreacion`, `UsuarioModificaion`, `numeroFactura`) VALUES
(1, '2021-04-27-01-0000001', '2983312054875', 'Douglas', 'Alexander', NULL, 'Sacalxot', 'Elias', '01-05-1996', '25547865', '32243548', 'd.alexelias@gmail.com', '94754878', '31-03-2021 17:06:42', NULL, 10, NULL, '12345678910'),
(2, '2021-05-08-02-0000002', '2052853760101', 'Hector ', 'Santiago', NULL, 'Casuy', 'Rodriguez', '01-05-1995', '24226120', '30213865', 'test@info.com', NULL, '', NULL, 0, NULL, NULL);

--
-- Disparadores `expedientes`
--
DROP TRIGGER IF EXISTS `tg_NoExpediente`;
DELIMITER $$
CREATE TRIGGER `tg_NoExpediente` BEFORE INSERT ON `expedientes` FOR EACH ROW BEGIN
DECLARE correlativo int;
SET correlativo =(SELECT ifnull(MAX(CONVERT(substring(idexpediente,1), signed integer)),0) FROM expedientes) +1;

set new.NoExpediente = concat(year(now()),'-',lpad(MONTH (NOW()),2,'0'),"-",lpad(DAY(NOW()),2,'0'),"-",lpad(correlativo,2,"0"),"-",lpad(correlativo,7,"0"));
    
end
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `muestra`
--

DROP TABLE IF EXISTS `muestra`;
CREATE TABLE IF NOT EXISTS `muestra` (
  `IdMuestra` int(11) NOT NULL AUTO_INCREMENT,
  `NumMuestra` varchar(50) DEFAULT NULL,
  `IdTipoMuestra` int(8) DEFAULT NULL,
  `Presentacion` varchar(2000) DEFAULT NULL,
  `CantidadUnidades` int(4) DEFAULT NULL,
  `IdUnidadMedida` int(8) DEFAULT NULL,
  `Adjunto` varchar(250) DEFAULT NULL,
  `FechaCreacion` datetime DEFAULT NULL,
  `FechaModificacion` datetime DEFAULT NULL,
  `Eliminado` tinyint(1) DEFAULT NULL,
  `idSolicitudes` int(11) DEFAULT NULL,
  PRIMARY KEY (`IdMuestra`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `muestra`
--

INSERT INTO `muestra` (`IdMuestra`, `NumMuestra`, `IdTipoMuestra`, `Presentacion`, `CantidadUnidades`, `IdUnidadMedida`, `Adjunto`, `FechaCreacion`, `FechaModificacion`, `Eliminado`, `idSolicitudes`) VALUES
(1, 'AAAAA-AA-01-000001', 1, 'Somos bananos 3333333', 1, 1, 'trrr', '2021-05-08 00:00:00', '2021-05-15 00:00:00', 0, NULL),
(2, 'AAAAAA2-02-000002', 2, 'msta', 2, 2, 'ttrterert', '2021-05-08 00:00:00', NULL, 0, NULL),
(3, 'AAAAA-A3-03-000003', 1, 'temerarios', 3, 1, 'trest', '2021-05-08 00:00:00', NULL, 0, NULL),
(4, 'ABCD4-A4-04-000004', 3, 'Muestras de orina ', 4, 1, '/test/res', '2021-05-08 00:00:00', '2021-05-15 00:00:00', 1, NULL),
(5, 'ABCD5-A5-05-000005', 4, 'tetser', 2255, 3, NULL, '2021-05-02 00:00:00', NULL, 1, NULL),
(6, 'ABCD6-A6-06-000006', 2, 'Amores', 8989, 2, NULL, '2021-05-01 00:00:00', NULL, 1, NULL),
(7, 'ABCD7-A7-07-000007', 1, 'Muestra de Sangre', 12, 1, NULL, '2021-05-01 00:00:00', NULL, 1, NULL),
(8, 'ABCD8-A8-08-000008', 2, 'De la abuela coco', 2, 2, NULL, '2021-05-01 00:00:00', '2021-05-15 00:00:00', 0, NULL),
(9, 'ABCD9-A9-09-000009', 2, 'fdfdf', 7878, 1, NULL, '2021-05-15 00:00:00', NULL, 0, NULL),
(10, 'ABC10-10-10-000010', 1, 'ttetet   eerere ererere', 100, 1, NULL, '2021-05-15 00:00:00', NULL, 0, NULL),
(11, 'ABC11-11-11-000011', 4, 'Color amarillento', 2133, 1, NULL, '2021-05-15 00:00:00', NULL, 0, NULL),
(12, 'ABC12-12-12-000012', 1, 'Ormonas', 8555, 2, NULL, '2021-05-15 00:00:00', NULL, 0, NULL),
(13, 'ABC13-13-13-000013', 3, 'Color negro', 78, 2, NULL, '2021-05-15 00:00:00', NULL, 0, NULL),
(14, 'ABC14-14-14-000014', 2, 'tres Tres', 12, 2, NULL, '2021-05-15 00:00:00', '2021-05-19 00:00:00', 0, NULL),
(15, 'ABC15-15-15-000015', 1, 'Muestras de Sangre', 8565, 2, NULL, '2021-05-15 00:00:00', '2021-05-19 00:00:00', 0, NULL),
(16, 'ABC16-16-16-000016', 4, 'Test liquido', 1, 1, NULL, '2021-05-19 00:00:00', NULL, 0, NULL);

--
-- Disparadores `muestra`
--
DROP TRIGGER IF EXISTS `generar_codigo`;
DELIMITER $$
CREATE TRIGGER `generar_codigo` BEFORE INSERT ON `muestra` FOR EACH ROW BEGIN
DECLARE correlativo int;

SET correlativo =(SELECT ifnull(MAX(CONVERT(substring(IdMuestra,1), signed integer)),0) FROM muestra) +1;

set new.NumMuestra = concat(
lpad(correlativo,5,"ABCDE"),"-",
lpad(correlativo,2,"AB"),"-",
lpad(correlativo,2,"0"),"-",
lpad(correlativo,6,"0"));
    
end
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rollusuario`
--

DROP TABLE IF EXISTS `rollusuario`;
CREATE TABLE IF NOT EXISTS `rollusuario` (
  `IdRoll` int(11) NOT NULL AUTO_INCREMENT,
  `NombreRoll` varchar(100) DEFAULT NULL,
  `FechaCreacion` datetime DEFAULT NULL,
  `Eliminado` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`IdRoll`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `rollusuario`
--

INSERT INTO `rollusuario` (`IdRoll`, `NombreRoll`, `FechaCreacion`, `Eliminado`) VALUES
(1, 'Cliente', '2021-05-15 00:00:00', 0),
(2, 'Administrador', '2021-05-15 00:00:00', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `solicitudes_medicas`
--

DROP TABLE IF EXISTS `solicitudes_medicas`;
CREATE TABLE IF NOT EXISTS `solicitudes_medicas` (
  `idSolicitudes` int(11) NOT NULL AUTO_INCREMENT,
  `codigoSolicitud` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `tipoSolicitante` int(4) NOT NULL,
  `tipoSolicitud` int(11) NOT NULL,
  `Descripcion` varchar(2000) NOT NULL,
  `NoExpediente` varchar(30) NOT NULL,
  `nit` varchar(10) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `Telefono` varchar(15) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `FechaCreacion` varchar(25) NOT NULL,
  `FechaModificacion` varchar(25) DEFAULT NULL,
  `UsuarioCreacion` int(11) NOT NULL,
  `UsuarioModificacion` int(11) DEFAULT NULL,
  `UsuarioAsignacion` int(11) DEFAULT NULL,
  `tipoSoporte` int(2) NOT NULL,
  `numSoporte` varchar(50) NOT NULL,
  `estado_solicitud` int(11) DEFAULT NULL,
  PRIMARY KEY (`idSolicitudes`),
  KEY `tipoSolicitante` (`tipoSolicitante`),
  KEY `tipoSolicitud` (`tipoSolicitud`),
  KEY `estado_solicitud` (`estado_solicitud`),
  KEY `NoExpediente` (`NoExpediente`),
  KEY `tipoSoporte` (`tipoSoporte`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `solicitudes_medicas`
--

INSERT INTO `solicitudes_medicas` (`idSolicitudes`, `codigoSolicitud`, `tipoSolicitante`, `tipoSolicitud`, `Descripcion`, `NoExpediente`, `nit`, `nombre`, `Telefono`, `email`, `FechaCreacion`, `FechaModificacion`, `UsuarioCreacion`, `UsuarioModificacion`, `UsuarioAsignacion`, `tipoSoporte`, `numSoporte`, `estado_solicitud`) VALUES
(1, 'EX-20210507-00001', 20, 1, 'Solotrajounasolicitudmedica', '2021-05-03-02-0000002', '45434567', 'Katherine Castellanos', '54505853', 'ejemplo@gmail.com', '07-05-2021', NULL, 2, NULL, NULL, 1, '10000AAAAAAAAAA', 1),
(2, 'IN-20210507-00002', 10, 2, 'Faltamuestradeheces', '2021-05-03-02-0000002', '45434567', 'Katherine Castellanos', '45685245', 'ktha@gmail.com', '07-05-2021', NULL, 2, NULL, NULL, 1, '10000AAAAAAAAAA', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_muestras`
--

DROP TABLE IF EXISTS `tipo_muestras`;
CREATE TABLE IF NOT EXISTS `tipo_muestras` (
  `IdTipoMuestra` int(11) NOT NULL AUTO_INCREMENT,
  `TipoMuestra` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`IdTipoMuestra`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `tipo_muestras`
--

INSERT INTO `tipo_muestras` (`IdTipoMuestra`, `TipoMuestra`) VALUES
(1, 'Cultivo'),
(2, 'Plaquetas'),
(3, 'Eses'),
(4, 'orina');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `unida_medida`
--

DROP TABLE IF EXISTS `unida_medida`;
CREATE TABLE IF NOT EXISTS `unida_medida` (
  `IdUnidadMedida` int(11) NOT NULL AUTO_INCREMENT,
  `UnidadMedida` varchar(100) NOT NULL,
  PRIMARY KEY (`IdUnidadMedida`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `unida_medida`
--

INSERT INTO `unida_medida` (`IdUnidadMedida`, `UnidadMedida`) VALUES
(1, 'Mililitros'),
(2, 'Gramos'),
(3, 'Miligramos');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE IF NOT EXISTS `usuarios` (
  `EntityID` int(11) NOT NULL AUTO_INCREMENT,
  `PrimerNombre` varchar(30) NOT NULL,
  `SegundoNombre` varchar(30) DEFAULT NULL,
  `OtroNombre` varchar(25) DEFAULT NULL,
  `PrimerApellido` varchar(30) NOT NULL,
  `SegundoApellido` varchar(30) DEFAULT NULL,
  `IdRoll` int(11) NOT NULL,
  `Usuario` varchar(12) NOT NULL,
  `PasswordUser` varchar(18) NOT NULL,
  `FechaNacimiento` varchar(15) NOT NULL,
  `Genero` int(11) NOT NULL,
  `Telefono` varchar(12) NOT NULL,
  `Movil` varchar(12) DEFAULT NULL,
  `Correo` varchar(60) DEFAULT NULL,
  `FechaCreacion` varchar(25) NOT NULL,
  `FechaModificacion` varchar(15) DEFAULT NULL,
  `Estado` int(11) NOT NULL,
  PRIMARY KEY (`EntityID`),
  KEY `IdRoll` (`IdRoll`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`EntityID`, `PrimerNombre`, `SegundoNombre`, `OtroNombre`, `PrimerApellido`, `SegundoApellido`, `IdRoll`, `Usuario`, `PasswordUser`, `FechaNacimiento`, `Genero`, `Telefono`, `Movil`, `Correo`, `FechaCreacion`, `FechaModificacion`, `Estado`) VALUES
(2, 'Douglas', 'Alexander', NULL, 'Sacalxot', 'Elias', 2, 'Elias3224', '@elias3224', '01-05-1996', 1, '24365878', '53856987', 'd.alexelias@gmail.com', '31-03-2021 17:06:42', NULL, 1);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`IdRoll`) REFERENCES `rollusuario` (`IdRoll`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
