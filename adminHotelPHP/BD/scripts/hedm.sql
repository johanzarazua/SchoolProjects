drop database if exists hedm;
create database hedm;
use hedm;

-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-06-2020 a las 22:49:15
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `hedm`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL,
  `Tarjeta_Credito` varchar(16) NOT NULL,
  `TC_CV` varchar(4) NOT NULL,
  `TC_Vencimiento` varchar(5) NOT NULL,
  `Estado` varchar(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`idCliente`, `Tarjeta_Credito`, `TC_CV`, `TC_Vencimiento`, `Estado`) VALUES
(5, '4755023649125870', '059', '01/26', '1'),
(6, '4955162801125648', '106', '02/22', '1'),
(7, '0312567489150316', '083', '03/21', '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compra`
--

CREATE TABLE `compra` (
  `idCompra` int(11) NOT NULL,
  `idReservacion` int(11) NOT NULL,
  `idServicio` int(11) NOT NULL,
  `Fecha` date NOT NULL,
  `Precio` decimal(7,2) NOT NULL,
  `Estado` varchar(45) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `idEmpleado` int(11) NOT NULL,
  `Puesto` varchar(1) NOT NULL,
  `Usuario` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  `Pregunta_seguridad` varchar(45) NOT NULL,
  `Respuesta_seguridad` varchar(45) NOT NULL,
  `Estado` varchar(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`idEmpleado`, `Puesto`, `Usuario`, `Password`, `Pregunta_seguridad`, `Respuesta_seguridad`, `Estado`) VALUES
(1, 'G', 'JohanZR', MD5('admin1234@'), '¿Equipo deportivo favorito?', 'pumas', '1'),
(2, 'A', 'BWinter', MD5('admin1234@'), '¿Equipo deportivo favorito?', 'Barca', '1'),
(3, 'G', 'RICHIII', MD5('admin1234@'), '¿Equipo deportivo favorito?', 'arsenal', '1'),
(4, 'A', 'MAXQRRR', MD5('admin1234@'), '¿Comida favorita?', 'tacos', '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `habitacion`
--

CREATE TABLE `habitacion` (
  `idHabitacion` int(11) NOT NULL,
  `Numero` varchar(3) NOT NULL,
  `Piso` varchar(2) NOT NULL,
  `Tipo` varchar(45) NOT NULL,
  `Descripcion` varchar(500) NOT NULL,
  `Precio` decimal(7,2) NOT NULL,
  `Estado` varchar(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `habitacion`
--

INSERT INTO `habitacion` (`idHabitacion`, `Numero`, `Piso`, `Tipo`, `Descripcion`, `Precio`, `Estado`) VALUES
(1, '101', '1', 'Estandar', 'Habitación para 1 a 2 personas, sin frigobar', '1000.00', '2'),
(2, '102', '1', 'Estandar', 'Habitación para 1 a 2 personas, sin frigobar', '1000.00', '1'),
(3, '103', '1', 'Estandar', 'Habitación para 1 a 2 personas, sin frigobar', '1000.00', '2'),
(4, '104', '1', 'Estandar', 'Habitación para 1 a 2 personas, con frigobar', '1500.00', '1'),
(5, '105', '1', 'Estandar', 'Habitación para 1 a 2 personas, con frigobar', '1500.00', '1'),
(6, '106', '1', 'Estandar', 'Habitación para 1 a 2 personas, con frigobar', '1500.00', '1'),
(7, '201', '2', 'Estandar', 'Habitación para 1 a 2 personas, sin frigobar', '1000.00', '1'),
(8, '202', '2', 'Estandar', 'Habitación para 1 a 2 personas, sin frigobar', '1000.00', '1'),
(9, '203', '2', 'Estandar', 'Habitación para 1 a 2 personas, sin frigobar', '1000.00', '1'),
(10, '204', '2', 'Estandar', 'Habitación para 1 a 2 personas, con frigobar', '1500.00', '1'),
(11, '205', '2', 'Estandar', 'Habitación para 1 a 2 personas, con frigobar', '1500.00', '2'),
(12, '206', '2', 'Estandar', 'Habitación para 1 a 2 personas, con frigobar', '1500.00', '1'),
(13, '301', '3', 'Estandar', 'Habitación para 1 a 2 personas, sin frigobar', '1000.00', '1'),
(14, '302', '3', 'Estandar', 'Habitación para 1 a 2 personas, sin frigobar', '1000.00', '1'),
(15, '303', '3', 'Estandar', 'Habitación para 1 a 2 personas, sin frigobar', '1000.00', '1'),
(16, '304', '3', 'Estandar', 'Habitación para 1 a 2 personas, con frigobar', '1500.00', '1'),
(17, '305', '3', 'Estandar', 'Habitación para 1 a 2 personas, con frigobar', '1500.00', '1'),
(18, '306', '3', 'Estandar', 'Habitación para 1 a 2 personas, con frigobar', '1500.00', '1'),
(19, '401', '4', 'Estandar', 'Habitación para 1 a 2 personas, sin frigobar', '1000.00', '1'),
(20, '402', '4', 'Estandar', 'Habitación para 1 a 2 personas, sin frigobar', '1000.00', '1'),
(21, '403', '4', 'Estandar', 'Habitación para 1 a 2 personas, sin frigobar', '1000.00', '1'),
(22, '404', '4', 'Estandar', 'Habitación para 1 a 2 personas, con frigobar', '1500.00', '1'),
(23, '405', '4', 'Estandar', 'Habitación para 1 a 2 personas, con frigobar', '1500.00', '1'),
(24, '406', '4', 'Estandar', 'Habitación para 1 a 2 personas, con frigobar', '1500.00', '1'),
(25, '501', '5', 'Junior suite', 'Habitación para 1 a 5 personas', '3000.00', '1'),
(26, '502', '5', 'Junior suite', 'Habitación para 1 a 5 personas', '3000.00', '1'),
(27, '503', '5', 'Junior suite', 'Habitación para 1 a  personas', '3000.00', '1'),
(28, '504', '5', 'Estandar', 'Habitación para 1 a 2 personas, con frigobar', '1500.00', '1'),
(29, '505', '5', 'Estandar', 'Habitación para 1 a 2 personas, con frigobar', '1500.00', '1'),
(30, '506', '5', 'Estandar', 'Habitación para 1 a 2 personas, con frigobar', '1500.00', '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pago`
--

CREATE TABLE `pago` (
  `idPago` int(11) NOT NULL,
  `idReservacion` int(11) NOT NULL,
  `Fecha` date NOT NULL,
  `Monto` decimal(7,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `idPersona` int(11) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Apellido_P` varchar(50) NOT NULL,
  `Apellido_M` varchar(50) NOT NULL,
  `Direccion` varchar(250) NOT NULL,
  `Telefono` varchar(10) NOT NULL,
  `Email` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`idPersona`, `Nombre`, `Apellido_P`, `Apellido_M`, `Direccion`, `Telefono`, `Email`) VALUES
(1, 'Johan', 'Zarazua', 'R', 'Calle L 10, CDMX', '5502908010', 'johanzarazua@gmail.com'),
(2, 'Alejandro', 'H*******', 'G*******', 'Coyoacan, Ciudad de Mexico', '5502908011', 'emailAHG@gmail.com'),
(3, 'Ricardo', 'C******', 'S*******', 'neza 125, Neza, EDOMEX', '5502908012', 'emailRCS@gmail.com'),
(4, 'Max', 'Q******', 'R******', 'reforma 135, CDMX', '5502908013', 'emailMQR@hotmail.com'),
(5, 'Paty', 'R******', 'B*******', 'Calle L 20, CDMX', '5502908014', 'emailPRB@gmail.com'),
(6, 'Jesus Antonio', 'C*******', 'P*******', 'Calle C 126, CDMX', '5502908015', 'emailJACP@gmail.com'),
(7, 'Efren', 'Z*******', 'E*****', 'Calle L 26, CDMX', '5502908016', 'emailEZE@gmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reservacion`
--

CREATE TABLE `reservacion` (
  `idReservacion` int(11) NOT NULL,
  `idEmpleado` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `idHabitacion` int(11) NOT NULL,
  `Fecha_Ingreso` date NOT NULL,
  `Fecha_Salida` date NOT NULL,
  `Fecha` date NOT NULL,
  `Costo` decimal(7,2) NOT NULL,
  `Estado` varchar(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `reservacion`
--

INSERT INTO `reservacion` (`idReservacion`, `idEmpleado`, `idCliente`, `idHabitacion`, `Fecha_Ingreso`, `Fecha_Salida`, `Fecha`, `Costo`, `Estado`) VALUES
(1, 1, 5, 1, '2020-06-24', '2020-06-27', '2020-06-23', '3000.00', '1'),
(2, 2, 6, 3, '2020-06-25', '2020-06-27', '2020-06-23', '2000.00', '1'),
(3, 2, 7, 11, '2020-06-27', '2020-06-30', '2020-06-23', '4500.00', '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicio`
--

CREATE TABLE `servicio` (
  `idServicio` int(11) NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  `Descripcion` varchar(500) NOT NULL,
  `Precio` decimal(7,2) NOT NULL,
  `Estado` varchar(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `servicio`
--

INSERT INTO `servicio` (`idServicio`, `Nombre`, `Descripcion`, `Precio`, `Estado`) VALUES
(1, 'Gimnasio', 'Gimnasio con área para cardio y pesas', '100.00', '1'),
(2, 'Zumba', 'Clases de zumba [1 hora]', '100.00', '1'),
(3, 'Yoga', 'Clases de yoga [1 hora]', '100.00', '1'),
(4, 'Box', 'Clases de box [1 hora]', '100.00', '1');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`idCliente`);

--
-- Indices de la tabla `compra`
--
ALTER TABLE `compra`
  ADD PRIMARY KEY (`idCompra`),
  ADD KEY `Compra-Reservacion_idx` (`idReservacion`),
  ADD KEY `Compra-Servicio_idx` (`idServicio`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`idEmpleado`),
  ADD UNIQUE KEY `Usuario_UNIQUE` (`Usuario`);

--
-- Indices de la tabla `habitacion`
--
ALTER TABLE `habitacion`
  ADD PRIMARY KEY (`idHabitacion`),
  ADD UNIQUE KEY `Numero_UNIQUE` (`Numero`);

--
-- Indices de la tabla `pago`
--
ALTER TABLE `pago`
  ADD PRIMARY KEY (`idPago`),
  ADD KEY `Pago-Reservacion_idx` (`idReservacion`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`idPersona`);

--
-- Indices de la tabla `reservacion`
--
ALTER TABLE `reservacion`
  ADD PRIMARY KEY (`idReservacion`),
  ADD KEY `Reservacion-Empleado_idx` (`idEmpleado`),
  ADD KEY `Reservacion-Cliente_idx` (`idCliente`),
  ADD KEY `Reservacion-Habitacion_idx` (`idHabitacion`);

--
-- Indices de la tabla `servicio`
--
ALTER TABLE `servicio`
  ADD PRIMARY KEY (`idServicio`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `compra`
--
ALTER TABLE `compra`
  MODIFY `idCompra` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `habitacion`
--
ALTER TABLE `habitacion`
  MODIFY `idHabitacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT de la tabla `pago`
--
ALTER TABLE `pago`
  MODIFY `idPago` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `persona`
--
ALTER TABLE `persona`
  MODIFY `idPersona` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `reservacion`
--
ALTER TABLE `reservacion`
  MODIFY `idReservacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `servicio`
--
ALTER TABLE `servicio`
  MODIFY `idServicio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `Cliente-Persona` FOREIGN KEY (`idCliente`) REFERENCES `persona` (`idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `compra`
--
ALTER TABLE `compra`
  ADD CONSTRAINT `Compra-Reservacion` FOREIGN KEY (`idReservacion`) REFERENCES `reservacion` (`idReservacion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `Compra-Servicio` FOREIGN KEY (`idServicio`) REFERENCES `servicio` (`idServicio`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD CONSTRAINT `Empleado-Persona` FOREIGN KEY (`idEmpleado`) REFERENCES `persona` (`idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `pago`
--
ALTER TABLE `pago`
  ADD CONSTRAINT `Pago-Reservacion` FOREIGN KEY (`idReservacion`) REFERENCES `reservacion` (`idReservacion`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `reservacion`
--
ALTER TABLE `reservacion`
  ADD CONSTRAINT `Reservacion-Cliente` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `Reservacion-Empleado` FOREIGN KEY (`idEmpleado`) REFERENCES `empleado` (`idEmpleado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `Reservacion-Habitacion` FOREIGN KEY (`idHabitacion`) REFERENCES `habitacion` (`idHabitacion`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
