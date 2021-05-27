-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3308
-- Tiempo de generación: 27-05-2021 a las 02:19:34
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
-- Estructura de tabla para la tabla `items`
--

DROP TABLE IF EXISTS `items`;
CREATE TABLE IF NOT EXISTS `items` (
  `IdItems` int(11) NOT NULL AUTO_INCREMENT,
  `NombreItems` varchar(250) DEFAULT NULL,
  `FechaCreacion` datetime DEFAULT NULL,
  `FechaModificacion` datetime DEFAULT NULL,
  `Eliminado` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`IdItems`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `items`
--

INSERT INTO `items` (`IdItems`, `NombreItems`, `FechaCreacion`, `FechaModificacion`, `Eliminado`) VALUES
(1, 'Macrobiotico', '2021-05-25 00:00:00', NULL, 0),
(2, 'Trigliceridos', '2021-05-25 00:00:00', NULL, 0),
(3, 'Diabetes', '2021-05-25 05:20:20', NULL, 0),
(4, 'Embarazo', '2021-05-25 03:19:19', NULL, 0),
(5, 'Test de drogas', '2021-05-25 14:31:19', NULL, 0),
(6, 'Test de enfermedades renales', '2021-05-25 04:13:13', NULL, 0),
(7, 'Bacterianas', '2021-05-25 04:11:11', NULL, 0);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
