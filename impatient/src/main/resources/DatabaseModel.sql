CREATE DATABASE `impatient` /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE `appointment` (
  `idappointment` int(11) NOT NULL AUTO_INCREMENT,
  `iduser` varchar(12) DEFAULT NULL,
  `date_appointment` date DEFAULT NULL,
  `hour` varchar(7) DEFAULT NULL,
  `remember` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`idappointment`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE `checkin` (
  `idcheckin` int(11) NOT NULL AUTO_INCREMENT,
  `iduser` varchar(12) DEFAULT NULL,
  `date_checkin` date DEFAULT NULL,
  `hour` varchar(7) DEFAULT NULL,
  PRIMARY KEY (`idcheckin`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE `login` (
  `idlogin` int(11) DEFAULT NULL,
  `iduser` varchar(12) NOT NULL,
  `idrol` int(11) DEFAULT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`iduser`,`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `rol` (
  `idrol` int(11) NOT NULL,
  `rol_name` varchar(45) DEFAULT NULL,
  `description` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`idrol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `state` (
  `idstate` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `description` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`idstate`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `treatment` (
  `idtreatment` int(11) NOT NULL AUTO_INCREMENT,
  `iduser` varchar(12) DEFAULT NULL,
  `medicine` varchar(150) DEFAULT NULL,
  `description` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`idtreatment`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

CREATE TABLE `user` (
  `iduser` varchar(12) NOT NULL,
  `first_name` varchar(100) DEFAULT NULL,
  `last_name` varchar(100) DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`iduser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='User table. This table store the users of the app.';

CREATE TABLE `waitinglist` (
  `idwaitinglist` int(11) NOT NULL AUTO_INCREMENT,
  `idcheckin` int(11) DEFAULT NULL,
  `idstate` int(11) DEFAULT NULL,
  PRIMARY KEY (`idwaitinglist`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
