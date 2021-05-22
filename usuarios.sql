-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3308
-- Tiempo de generación: 22-05-2021 a las 06:27:05
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
-- Base de datos: `sbo_laboratoriolb_2021`
--

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
