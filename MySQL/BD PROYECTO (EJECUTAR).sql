-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 07-12-2022 a las 05:17:00
-- Versión del servidor: 5.7.31
-- Versión de PHP: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proyecto2`
--

DELIMITER $$
--
-- Procedimientos
--
DROP PROCEDURE IF EXISTS `actualizarSolicitudJF`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizarSolicitudJF` (IN `c_idSolicitud` VARCHAR(15), IN `c_idUsuarioTI` INT, IN `c_descripcion` VARCHAR(250), IN `c_idTipo_solicitud` INT, IN `c_idEstado_solicitud` INT, IN `c_idPrioridad` INT, IN `c_idCategoria` INT)  BEGIN
update solicitud set 
idUsuarioTI = c_idUsuarioTI,
Descripcion = c_descripcion,
idTipo_solicitud = c_idTipo_solicitud,
idEstado_solicitud = c_idEstado_solicitud,
idPrioridad = c_idPrioridad,
idCategoria = c_idCategoria 
where idSolicitud = c_idSolicitud;
end$$

DROP PROCEDURE IF EXISTS `atenderSolicitud`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `atenderSolicitud` (IN `c_idSolicitud` VARCHAR(15), IN `c_descripcion` VARCHAR(250), IN `c_idTipo_solicitud` INT, IN `c_idEstado_solicitud` INT, IN `c_idPrioridad` INT, IN `c_idCategoria` INT)  BEGIN
update solicitud set 
Descripcion = c_descripcion,
idTipo_solicitud = c_idTipo_solicitud,
idEstado_solicitud = c_idEstado_solicitud,
idPrioridad = c_idPrioridad,
idCategoria = c_idCategoria,
fh_actualizacion = NOW()
where idSolicitud = c_idSolicitud;
end$$

DROP PROCEDURE IF EXISTS `atenderSolicitudJF`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `atenderSolicitudJF` (IN `c_idSolicitud` VARCHAR(15), IN `c_idUsuarioTI` INT, IN `c_descripcion` VARCHAR(250), IN `c_idTipo_solicitud` INT, IN `c_idEstado_solicitud` INT, IN `c_idPrioridad` INT, IN `c_idCategoria` INT)  BEGIN
update solicitud set 
idUsuarioTI = c_idUsuarioTI,
Descripcion = c_descripcion,
idTipo_solicitud = c_idTipo_solicitud,
idEstado_solicitud = c_idEstado_solicitud,
idPrioridad = c_idPrioridad,
idCategoria = c_idCategoria,
fh_actualizacion = NOW()
where idSolicitud = c_idSolicitud;
end$$

DROP PROCEDURE IF EXISTS `cierreSolicitud`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `cierreSolicitud` (IN `c_idSolicitud` VARCHAR(15), IN `c_descripcion` VARCHAR(250), IN `c_idTipo_solicitud` INT, IN `c_idEstado_solicitud` INT, IN `c_idPrioridad` INT, IN `c_idCategoria` INT)  BEGIN
update solicitud set 
Descripcion = c_descripcion,
idTipo_solicitud = c_idTipo_solicitud,
idEstado_solicitud = c_idEstado_solicitud,
idPrioridad = c_idPrioridad,
idCategoria = c_idCategoria,
fh_cierre = NOW()
where idSolicitud = c_idSolicitud;
end$$

DROP PROCEDURE IF EXISTS `cierreSolicitudJF`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `cierreSolicitudJF` (IN `c_idSolicitud` VARCHAR(15), IN `c_idUsuarioTI` INT, IN `c_descripcion` VARCHAR(250), IN `c_idTipo_solicitud` INT, IN `c_idEstado_solicitud` INT, IN `c_idPrioridad` INT, IN `c_idCategoria` INT)  BEGIN
update solicitud set 
idUsuarioTI = c_idUsuarioTI,
Descripcion = c_descripcion,
idTipo_solicitud = c_idTipo_solicitud,
idEstado_solicitud = c_idEstado_solicitud,
idPrioridad = c_idPrioridad,
idCategoria = c_idCategoria,
fh_cierre = NOW()
where idSolicitud = c_idSolicitud;
end$$

DROP PROCEDURE IF EXISTS `econexion`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `econexion` (IN `c_username_ti` VARCHAR(25), IN `c_idEstado_usuarioTI` INT)  BEGIN
update usuarioti set 
idEstado_usuarioTI = c_idEstado_usuarioTI 
where username_ti = c_username_ti;
end$$

DROP PROCEDURE IF EXISTS `registrarSolicitud`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `registrarSolicitud` (IN `c_idUsuario` INT, IN `c_idUsuarioTI` INT, IN `c_Asunto` VARCHAR(45), IN `c_Descripcion` VARCHAR(250), IN `c_idTipoSolicitud` INT, IN `c_idEstadoSolicitud` INT, IN `c_idPrioridad` INT, IN `c_idCategoria` INT)  BEGIN
insert into solicitud values(
CONCAT(YEAR(NOW()),MONTH(NOW()),DAY(NOW()),HOUR(NOW()),MINUTE(NOW()),SECOND(NOW()),MICROSECOND(NOW())),
c_idUsuario,
c_idUsuarioTI,
c_Asunto,
c_Descripcion,
now(),
null,
null,
c_idTiposolicitud,
c_idEstadosolicitud,
c_idPrioridad,
c_idCategoria);
end$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

DROP TABLE IF EXISTS `categoria`;
CREATE TABLE IF NOT EXISTS `categoria` (
  `idCategoria` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_cat` varchar(40) NOT NULL,
  PRIMARY KEY (`idCategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`idCategoria`, `nombre_cat`) VALUES
(1, 'Problemas con software'),
(2, 'Problemas con internet'),
(3, 'Problemas con PC'),
(4, 'Problemas con teclado/mouse'),
(5, 'Problemas con paginas internas'),
(6, 'Problemas con impresora');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado_conexión`
--

DROP TABLE IF EXISTS `estado_conexión`;
CREATE TABLE IF NOT EXISTS `estado_conexión` (
  `idEstado_usuarioTI` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_ec` varchar(15) NOT NULL,
  PRIMARY KEY (`idEstado_usuarioTI`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `estado_conexión`
--

INSERT INTO `estado_conexión` (`idEstado_usuarioTI`, `nombre_ec`) VALUES
(1, 'Conectado'),
(2, 'Desconectado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado_solicitud`
--

DROP TABLE IF EXISTS `estado_solicitud`;
CREATE TABLE IF NOT EXISTS `estado_solicitud` (
  `idEstado_solicitud` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_es` varchar(20) NOT NULL,
  PRIMARY KEY (`idEstado_solicitud`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `estado_solicitud`
--

INSERT INTO `estado_solicitud` (`idEstado_solicitud`, `nombre_es`) VALUES
(1, 'Pendiente'),
(2, 'Atendiendo'),
(3, 'Solucionado');

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `loginusuario`
-- (Véase abajo para la vista actual)
--
DROP VIEW IF EXISTS `loginusuario`;
CREATE TABLE IF NOT EXISTS `loginusuario` (
`idUsuario` int(11)
,`idPersona` int(11)
,`username_u` varchar(25)
,`password_u` varchar(10)
,`Nombres` varchar(91)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `loginusuarioti`
-- (Véase abajo para la vista actual)
--
DROP VIEW IF EXISTS `loginusuarioti`;
CREATE TABLE IF NOT EXISTS `loginusuarioti` (
`idUsuarioTI` int(11)
,`idPersona` int(11)
,`username_ti` varchar(25)
,`password_ti` varchar(10)
,`idRol` int(11)
,`idEstado_usuarioTI` int(11)
,`Nombres` varchar(91)
);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

DROP TABLE IF EXISTS `persona`;
CREATE TABLE IF NOT EXISTS `persona` (
  `idPersona` int(11) NOT NULL AUTO_INCREMENT,
  `Nombres` varchar(45) NOT NULL,
  `Apellidos` varchar(45) NOT NULL,
  `DNI` int(11) NOT NULL,
  `Telefono` int(11) NOT NULL,
  `Correo` varchar(50) NOT NULL,
  PRIMARY KEY (`idPersona`),
  UNIQUE KEY `DNI_UNIQUE` (`DNI`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`idPersona`, `Nombres`, `Apellidos`, `DNI`, `Telefono`, `Correo`) VALUES
(1, 'Rosa Maria', 'Morales Medina', 71548915, 915487598, 'rosa@emptele.com'),
(2, 'Jose Martin', 'Cabares Aguero', 71548978, 915487589, 'jose@emptele.com'),
(3, 'Roberto Carlos', 'Martinez Gonzales', 75489148, 915487798, 'juan@emptele.com'),
(4, 'Martin Pepe', 'Juliaca Torres', 71458978, 912548756, 'martin@emptele.com'),
(5, 'Jose Jose', 'Arega Perez', 74456845, 912354687, 'jose@emptele.com'),
(6, 'Lucho Gonzalo', 'Torres Torres', 71548979, 912345687, 'lucho@emptele.com'),
(7, 'Rosa Rosa', 'Martinez Lopez', 71523651, 912345681, 'rosaa@emptele.com'),
(8, 'Jose Roberto', 'Perez Diaz', 71234567, 915487548, 'joseroberto@emptele.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prioridad`
--

DROP TABLE IF EXISTS `prioridad`;
CREATE TABLE IF NOT EXISTS `prioridad` (
  `idPrioridad` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_p` varchar(20) NOT NULL,
  PRIMARY KEY (`idPrioridad`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `prioridad`
--

INSERT INTO `prioridad` (`idPrioridad`, `nombre_p`) VALUES
(1, 'Baja'),
(2, 'Media'),
(3, 'Alta');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

DROP TABLE IF EXISTS `rol`;
CREATE TABLE IF NOT EXISTS `rol` (
  `idRol` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_rol` varchar(15) NOT NULL,
  PRIMARY KEY (`idRol`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`idRol`, `nombre_rol`) VALUES
(1, 'Técnico'),
(2, 'Jefe');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `solicitud`
--

DROP TABLE IF EXISTS `solicitud`;
CREATE TABLE IF NOT EXISTS `solicitud` (
  `idSolicitud` varchar(15) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `idUsuarioTI` int(11) DEFAULT NULL,
  `Asunto` varchar(45) NOT NULL,
  `Descripcion` varchar(250) NOT NULL,
  `fh_creacion` datetime DEFAULT NULL,
  `fh_actualizacion` datetime DEFAULT NULL,
  `fh_cierre` datetime DEFAULT NULL,
  `idTipo_solicitud` int(11) NOT NULL,
  `idEstado_solicitud` int(11) NOT NULL,
  `idPrioridad` int(11) NOT NULL,
  `idCategoria` int(11) NOT NULL,
  PRIMARY KEY (`idSolicitud`),
  KEY `fk_Solicitud_Usuario1_idx` (`idUsuario`),
  KEY `fk_Solicitud_UsuarioTI1_idx` (`idUsuarioTI`),
  KEY `fk_Solicitud_Tipo_solicitud1_idx` (`idTipo_solicitud`),
  KEY `fk_Solicitud_Estado_solicitud1_idx` (`idEstado_solicitud`),
  KEY `fk_Solicitud_Prioridad1_idx` (`idPrioridad`),
  KEY `fk_Solicitud_Categoria1_idx` (`idCategoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `solicitud`
--

INSERT INTO `solicitud` (`idSolicitud`, `idUsuario`, `idUsuarioTI`, `Asunto`, `Descripcion`, `fh_creacion`, `fh_actualizacion`, `fh_cierre`, `idTipo_solicitud`, `idEstado_solicitud`, `idPrioridad`, `idCategoria`) VALUES
('202211141756140', 1, 1, 'Problemas con PC', 'No carga mi pc', '2022-11-14 17:56:14', '2022-11-20 17:36:29', NULL, 1, 2, 1, 1),
('202211201550180', 1, 1, 'Esto es una prueba', 'Esto esta siendpo una prueba', '2022-11-20 15:50:18', '2022-11-20 16:44:07', NULL, 1, 2, 3, 4),
('202211201649300', 1, 1, '33333', 'Se procede a cerrar ticket\n----------\n33333', '2022-11-20 16:49:30', '2022-11-20 16:50:34', '2022-11-20 23:11:02', 1, 3, 1, 1),
('202211202340460', 2, 3, 'ESTO ES UNA PRUEBA', 'Aqui me equivoque', '2022-11-20 23:40:46', NULL, NULL, 1, 1, 1, 1),
('202211281650160', 1, 4, 'NO FUNCIONA TECLADO', 'Se realiza cambio de teclado, se valida conformidad de usuaria.\n\n--------------------------\nSe atiende ticket\n\n\n-------------------\nTengo problemas con el teclado.\n\nIP: 192.154.125.2\nHOSTNAME: PRUEBA01\nCEL: 915487958\n', '2022-11-28 16:50:16', '2022-11-28 16:54:12', '2022-11-28 16:55:19', 1, 3, 2, 4),
('20221261858230', 1, 1, 'klklñ', 'Se soluciona caso.\n---------\nSe procede atender incidencia', '2022-12-06 18:58:23', '2022-12-06 23:24:18', '2022-12-06 23:24:41', 1, 3, 1, 6),
('20221262327500', 1, 1, 'No carga el windows', 'Se procede a reiniciar PC y se valida conformidad del usuario.\n-----\nSe procede atender caso.\n-----\nNo puedo acceder a mi pc debido que no carga el windows.', '2022-12-06 23:27:50', '2022-12-06 23:31:11', '2022-12-06 23:31:52', 1, 3, 2, 3),
('20221262333390', 1, 5, 'Test1', 'Test1', '2022-12-06 23:33:39', NULL, NULL, 2, 1, 1, 1),
('20221262333520', 1, 5, 'Test2', 'Test2', '2022-12-06 23:33:52', NULL, NULL, 2, 1, 1, 6),
('20221262334170', 1, 5, 'Test3', 'Test3', '2022-12-06 23:34:17', NULL, NULL, 2, 1, 1, 1),
('20221262334300', 1, 5, 'Test5', 'Test5', '2022-12-06 23:34:30', NULL, NULL, 2, 1, 1, 6),
('2022126233470', 1, 5, 'Test4', 'Test4', '2022-12-06 23:34:07', NULL, NULL, 2, 1, 1, 1);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `tecnicoasignado`
-- (Véase abajo para la vista actual)
--
DROP VIEW IF EXISTS `tecnicoasignado`;
CREATE TABLE IF NOT EXISTS `tecnicoasignado` (
`idUsuarioTI` int(11)
,`CantSoli` bigint(21)
,`idEstado_usuarioTI` int(11)
);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_solicitud`
--

DROP TABLE IF EXISTS `tipo_solicitud`;
CREATE TABLE IF NOT EXISTS `tipo_solicitud` (
  `idTipo_solicitud` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) NOT NULL,
  PRIMARY KEY (`idTipo_solicitud`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `tipo_solicitud`
--

INSERT INTO `tipo_solicitud` (`idTipo_solicitud`, `nombre`) VALUES
(1, 'Incidencia'),
(2, 'Requerimiento');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `idPersona` int(11) NOT NULL,
  `username_u` varchar(25) NOT NULL,
  `password_u` varchar(10) NOT NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE KEY `username_u_UNIQUE` (`username_u`),
  KEY `fk_Usuario_Persona_idx` (`idPersona`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idUsuario`, `idPersona`, `username_u`, `password_u`) VALUES
(1, 1, 'rmorales', '123456789'),
(2, 2, 'jcabares', '987654321'),
(3, 3, 'rmartinez', '123789456');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarioti`
--

DROP TABLE IF EXISTS `usuarioti`;
CREATE TABLE IF NOT EXISTS `usuarioti` (
  `idUsuarioTI` int(11) NOT NULL AUTO_INCREMENT,
  `idPersona` int(11) NOT NULL,
  `username_ti` varchar(25) NOT NULL,
  `password_ti` varchar(10) NOT NULL,
  `idRol` int(11) NOT NULL,
  `idEstado_usuarioTI` int(11) NOT NULL,
  PRIMARY KEY (`idUsuarioTI`),
  KEY `fk_UsuarioTI_Persona1_idx` (`idPersona`),
  KEY `fk_UsuarioTI_Rol1_idx` (`idRol`),
  KEY `fk_UsuarioTI_Estado_conexión1_idx` (`idEstado_usuarioTI`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuarioti`
--

INSERT INTO `usuarioti` (`idUsuarioTI`, `idPersona`, `username_ti`, `password_ti`, `idRol`, `idEstado_usuarioTI`) VALUES
(1, 4, 'tecnico1', 'miclave1', 1, 2),
(2, 5, 'tecnico2', 'miclave2', 1, 2),
(3, 6, 'tecnico3', 'miclave3', 1, 2),
(4, 7, 'tecnico4', 'miclave4', 1, 2),
(5, 8, 'jefearea1', 'misrclave1', 2, 2);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vista_solicitud`
-- (Véase abajo para la vista actual)
--
DROP VIEW IF EXISTS `vista_solicitud`;
CREATE TABLE IF NOT EXISTS `vista_solicitud` (
`Nro_solicitud` varchar(15)
,`idUsuario` int(11)
,`Usuario` varchar(91)
,`idUsuarioTI` int(11)
,`Tecnico_asignado` varchar(91)
,`Asunto` varchar(45)
,`Descripcion` varchar(250)
,`fh_creacion` datetime
,`fh_actualizacion` datetime
,`fh_cierre` datetime
,`idTipo_solicitud` int(11)
,`Tipo` varchar(20)
,`idEstado_solicitud` int(11)
,`Estado` varchar(20)
,`idPrioridad` int(11)
,`Prioridad` varchar(20)
,`idCategoria` int(11)
,`Categoria` varchar(40)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vista_tecnicos`
-- (Véase abajo para la vista actual)
--
DROP VIEW IF EXISTS `vista_tecnicos`;
CREATE TABLE IF NOT EXISTS `vista_tecnicos` (
`idUsuarioTI` int(11)
,`Nombres` varchar(91)
);

-- --------------------------------------------------------

--
-- Estructura para la vista `loginusuario`
--
DROP TABLE IF EXISTS `loginusuario`;

DROP VIEW IF EXISTS `loginusuario`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `loginusuario`  AS  select `u`.`idUsuario` AS `idUsuario`,`u`.`idPersona` AS `idPersona`,`u`.`username_u` AS `username_u`,`u`.`password_u` AS `password_u`,concat(upper(`p`.`Nombres`),' ',upper(`p`.`Apellidos`)) AS `Nombres` from (`usuario` `u` join `persona` `p` on((`u`.`idPersona` = `p`.`idPersona`))) ;

-- --------------------------------------------------------

--
-- Estructura para la vista `loginusuarioti`
--
DROP TABLE IF EXISTS `loginusuarioti`;

DROP VIEW IF EXISTS `loginusuarioti`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `loginusuarioti`  AS  select `u`.`idUsuarioTI` AS `idUsuarioTI`,`u`.`idPersona` AS `idPersona`,`u`.`username_ti` AS `username_ti`,`u`.`password_ti` AS `password_ti`,`u`.`idRol` AS `idRol`,`u`.`idEstado_usuarioTI` AS `idEstado_usuarioTI`,concat(upper(`p`.`Nombres`),' ',upper(`p`.`Apellidos`)) AS `Nombres` from (`usuarioti` `u` join `persona` `p` on((`u`.`idPersona` = `p`.`idPersona`))) ;

-- --------------------------------------------------------

--
-- Estructura para la vista `tecnicoasignado`
--
DROP TABLE IF EXISTS `tecnicoasignado`;

DROP VIEW IF EXISTS `tecnicoasignado`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `tecnicoasignado`  AS  select `uti`.`idUsuarioTI` AS `idUsuarioTI`,count(`s`.`idSolicitud`) AS `CantSoli`,`uti`.`idEstado_usuarioTI` AS `idEstado_usuarioTI` from (`usuarioti` `uti` left join `solicitud` `s` on((`s`.`idUsuarioTI` = `uti`.`idUsuarioTI`))) where (`uti`.`idEstado_usuarioTI` = 1) group by `uti`.`idUsuarioTI` order by `CantSoli` limit 1 ;

-- --------------------------------------------------------

--
-- Estructura para la vista `vista_solicitud`
--
DROP TABLE IF EXISTS `vista_solicitud`;

DROP VIEW IF EXISTS `vista_solicitud`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vista_solicitud`  AS  select `s`.`idSolicitud` AS `Nro_solicitud`,`s`.`idUsuario` AS `idUsuario`,concat(`p`.`Nombres`,' ',`p`.`Apellidos`) AS `Usuario`,`s`.`idUsuarioTI` AS `idUsuarioTI`,concat(`pti`.`Nombres`,' ',`pti`.`Apellidos`) AS `Tecnico_asignado`,`s`.`Asunto` AS `Asunto`,`s`.`Descripcion` AS `Descripcion`,`s`.`fh_creacion` AS `fh_creacion`,`s`.`fh_actualizacion` AS `fh_actualizacion`,`s`.`fh_cierre` AS `fh_cierre`,`s`.`idTipo_solicitud` AS `idTipo_solicitud`,`ts`.`nombre` AS `Tipo`,`s`.`idEstado_solicitud` AS `idEstado_solicitud`,`es`.`nombre_es` AS `Estado`,`s`.`idPrioridad` AS `idPrioridad`,`pr`.`nombre_p` AS `Prioridad`,`s`.`idCategoria` AS `idCategoria`,`c`.`nombre_cat` AS `Categoria` from ((((((((`solicitud` `s` join `tipo_solicitud` `ts` on((`ts`.`idTipo_solicitud` = `s`.`idTipo_solicitud`))) join `estado_solicitud` `es` on((`es`.`idEstado_solicitud` = `s`.`idEstado_solicitud`))) join `prioridad` `pr` on((`pr`.`idPrioridad` = `s`.`idPrioridad`))) join `categoria` `c` on((`c`.`idCategoria` = `s`.`idCategoria`))) join `usuario` on((`usuario`.`idUsuario` = `s`.`idUsuario`))) left join `usuarioti` on((`usuarioti`.`idUsuarioTI` = `s`.`idUsuarioTI`))) left join `persona` `pti` on((`usuarioti`.`idPersona` = `pti`.`idPersona`))) join `persona` `p` on((`usuario`.`idPersona` = `p`.`idPersona`))) order by `s`.`fh_creacion` ;

-- --------------------------------------------------------

--
-- Estructura para la vista `vista_tecnicos`
--
DROP TABLE IF EXISTS `vista_tecnicos`;

DROP VIEW IF EXISTS `vista_tecnicos`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vista_tecnicos`  AS  select `u`.`idUsuarioTI` AS `idUsuarioTI`,concat(`p`.`Nombres`,' ',`p`.`Apellidos`) AS `Nombres` from (`usuarioti` `u` join `persona` `p` on((`u`.`idPersona` = `p`.`idPersona`))) ;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `solicitud`
--
ALTER TABLE `solicitud`
  ADD CONSTRAINT `fk_Solicitud_Categoria1` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`idCategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Solicitud_Estado_solicitud1` FOREIGN KEY (`idEstado_solicitud`) REFERENCES `estado_solicitud` (`idEstado_solicitud`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Solicitud_Prioridad1` FOREIGN KEY (`idPrioridad`) REFERENCES `prioridad` (`idPrioridad`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Solicitud_Tipo_solicitud1` FOREIGN KEY (`idTipo_solicitud`) REFERENCES `tipo_solicitud` (`idTipo_solicitud`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Solicitud_Usuario1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Solicitud_UsuarioTI1` FOREIGN KEY (`idUsuarioTI`) REFERENCES `usuarioti` (`idUsuarioTI`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `fk_Usuario_Persona` FOREIGN KEY (`idPersona`) REFERENCES `persona` (`idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `usuarioti`
--
ALTER TABLE `usuarioti`
  ADD CONSTRAINT `fk_UsuarioTI_Estado_conexión1` FOREIGN KEY (`idEstado_usuarioTI`) REFERENCES `estado_conexión` (`idEstado_usuarioTI`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_UsuarioTI_Persona1` FOREIGN KEY (`idPersona`) REFERENCES `persona` (`idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_UsuarioTI_Rol1` FOREIGN KEY (`idRol`) REFERENCES `rol` (`idRol`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
