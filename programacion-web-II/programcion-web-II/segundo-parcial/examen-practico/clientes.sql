-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 24-10-2019 a las 17:56:27
-- Versión del servidor: 10.1.38-MariaDB
-- Versión de PHP: 7.1.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `practicas`
--

-- --------------------------------------------------------

CREATE DATABASE `examen-practico-2`;
USE `examen-practico-2`;

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `idC` int(2) NOT NULL,
  `NombC` varchar(10) NOT NULL,
  `TelC` varchar(10) NOT NULL,
  `LimCredC` float(7,2) NOT NULL,
  `BancoC` varchar(10) NOT NULL,
  `CorreoC` varchar(20) NOT NULL,
  `CiudadC` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`idC`, `NombC`, `TelC`, `LimCredC`, `BancoC`, `CorreoC`, `CiudadC`) VALUES
(1, 'JUAN', '123456789', 5000.00, 'BANAMEX', 'juan@clientes.com', 'GDL'),
(2, 'MARIA', '321654987', 12000.00, 'BBVA', 'maria@clientes.com', 'TNL'),
(3, 'LUIS', '987456321', 15000.00, 'BBVA', 'luis@clientes.com', 'TNL'),
(4, 'ROCIO', '987456123', 9000.00, 'BANORTE', 'rocio@clientes.com', 'GDL'),
(5, 'JORGE', '9856231', 7500.00, 'BANORTE', 'jorge@clientes.com', 'TLAQUEPAQUE'),
(6, 'IRMA', '9856231', 7500.00, 'BANORTE', 'irma@clientes.com', 'TLAQUEPAQUE'),
(7, 'NICK', '4561239', 2000.00, 'BANAMEX', 'nicck@comercio.mx', 'TNL'),
(8, 'NICKY', '4561323', 20000.00, 'BANAMEX', 'niky@comercio.mx', 'TNL');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`idC`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
