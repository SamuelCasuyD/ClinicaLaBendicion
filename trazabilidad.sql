-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3308
-- Tiempo de generación: 22-05-2021 a las 06:26:48
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
-- Estructura de tabla para la tabla `trazabilidad`
--

DROP TABLE IF EXISTS `trazabilidad`;
CREATE TABLE IF NOT EXISTS `trazabilidad` (
  `idTrazabilidad` int(11) NOT NULL AUTO_INCREMENT,
  `codigoSolicitud` varchar(50) NOT NULL,
  `estadoSolicitud` int(11) NOT NULL,
  `enviadoPor` varchar(75) NOT NULL,
  `asignadoA` varchar(75) NOT NULL,
  `fechaHoraEstado` datetime NOT NULL,
  `duracion` varchar(255) NOT NULL,
  `acumulado` varchar(255) NOT NULL,
  `observaciones` varchar(255) NOT NULL,
  `asignacion` varchar(255) NOT NULL,
  PRIMARY KEY (`idTrazabilidad`),
  KEY `estadoSolicitud` (`estadoSolicitud`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `trazabilidad`
--

INSERT INTO `trazabilidad` (`idTrazabilidad`, `codigoSolicitud`, `estadoSolicitud`, `enviadoPor`, `asignadoA`, `fechaHoraEstado`, `duracion`, `acumulado`, `observaciones`, `asignacion`) VALUES
(1, 'EX-20210515-00006', 2, 'alexamder', 'Elias', '2021-05-21 07:25:12', '5 dias', '10 dias', 'no trajó documentos', ''),
(2, 'EX-20210515-00006', 3, 'elias', 'alex', '2021-05-21 02:03:09', '1 dia', '2 dias', 'No trajo documento', '');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `trazabilidad`
--
ALTER TABLE `trazabilidad`
  ADD CONSTRAINT `trazabilidad_ibfk_1` FOREIGN KEY (`estadoSolicitud`) REFERENCES `estados_solicitudes` (`idEstadoSolicitud`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
