DROP DATABASE IF EXISTS `assignment-flights`;
CREATE DATABASE  `assignment-flights` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `assignment-one-db`;

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

GRANT ALL PRIVILEGES ON *.* TO 'root'@'%'  WITH GRANT OPTION;
FLUSH PRIVILEGES ;

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
 `isAdmin` BOOLEAN NOT NULL,
	PRIMARY KEY (`id`),
	UNIQUE (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;
insert into user values (2,"zdf5","sdf",0);
select * from user;

DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `latitude` FLOAT NOT NULL,
  `longitude` FLOAT NOT NULL,
	PRIMARY KEY (`id`),
UNIQUE (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;
insert into city values (2,"Zalau",45.78,0.89);
select * from city;

drop table if exists `flight`;
create table `flight`(
	id             int(11)     not null AUTO_INCREMENT, 
	airplaneType   varchar(45)          ,
    departureCity  int(11)     not null ,
    departureTime  long        not null ,
    arrivalCity    int(11)     not null ,
    arrivalTime    long        not null ,
	PRIMARY KEY (`id`),
    INDEX `fk_Flight_City_Departure_idx` (`departureCity` ASC),
    INDEX `fk_Flight_City_Arrival_idx` (`arrivalCity` ASC),
	CONSTRAINT `fk_Flight_City_Departure_idx`
		FOREIGN KEY (`departureCity`)
		REFERENCES `City` (`id`)
			ON DELETE CASCADE
			ON UPDATE CASCADE,
	CONSTRAINT `fk_Flight_City_Arrival_idx`
		FOREIGN KEY (`arrivalCity`)
		REFERENCES `City` (`id`)
			ON DELETE CASCADE
			ON UPDATE CASCADE
	
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;
insert into `flight` values (4,"type1",5,3542545,2,354254);
select * from `flight`;