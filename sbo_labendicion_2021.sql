-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3308
-- Tiempo de generación: 20-05-2021 a las 14:21:03
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
  PRIMARY KEY (`IdMuestra`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `muestra`
--

INSERT INTO `muestra` (`IdMuestra`, `NumMuestra`, `IdTipoMuestra`, `Presentacion`, `CantidadUnidades`, `IdUnidadMedida`, `Adjunto`, `FechaCreacion`, `FechaModificacion`, `Eliminado`) VALUES
(1, 'AAAAA-AA-01-000001', 1, 'Somos bananos 3333333', 1, 1, 'trrr', '2021-05-08 00:00:00', '2021-05-15 00:00:00', 0),
(2, 'AAAAAA2-02-000002', 2, 'msta', 2, 2, 'ttrterert', '2021-05-08 00:00:00', NULL, 0),
(3, 'AAAAA-A3-03-000003', 1, 'temerarios', 3, 1, 'trest', '2021-05-08 00:00:00', NULL, 0),
(4, 'ABCD4-A4-04-000004', 3, 'Muestras de orina ', 4, 1, '/test/res', '2021-05-08 00:00:00', '2021-05-15 00:00:00', 1),
(5, 'ABCD5-A5-05-000005', 4, 'tetser', 2255, 3, NULL, '2021-05-02 00:00:00', NULL, 1),
(6, 'ABCD6-A6-06-000006', 2, 'Amores', 8989, 2, NULL, '2021-05-01 00:00:00', NULL, 1),
(7, 'ABCD7-A7-07-000007', 1, 'Muestra de Sangre', 12, 1, NULL, '2021-05-01 00:00:00', NULL, 1),
(8, 'ABCD8-A8-08-000008', 2, 'De la abuela coco', 2, 2, NULL, '2021-05-01 00:00:00', '2021-05-15 00:00:00', 0),
(9, 'ABCD9-A9-09-000009', 2, 'fdfdf', 7878, 1, NULL, '2021-05-15 00:00:00', NULL, 0),
(10, 'ABC10-10-10-000010', 1, 'ttetet   eerere ererere', 100, 1, NULL, '2021-05-15 00:00:00', NULL, 0),
(11, 'ABC11-11-11-000011', 4, 'Color amarillento', 2133, 1, NULL, '2021-05-15 00:00:00', NULL, 0),
(12, 'ABC12-12-12-000012', 1, 'Ormonas', 8555, 2, NULL, '2021-05-15 00:00:00', NULL, 0),
(13, 'ABC13-13-13-000013', 3, 'Color negro', 78, 2, NULL, '2021-05-15 00:00:00', NULL, 0),
(14, 'ABC14-14-14-000014', 2, 'tres Tres', 12, 2, NULL, '2021-05-15 00:00:00', '2021-05-19 00:00:00', 0),
(15, 'ABC15-15-15-000015', 1, 'Muestras de Sangre', 8565, 2, NULL, '2021-05-15 00:00:00', '2021-05-19 00:00:00', 0),
(16, 'ABC16-16-16-000016', 4, 'Test liquido', 1, 1, NULL, '2021-05-19 00:00:00', NULL, 0);

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
