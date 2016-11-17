CREATE DATABASE  IF NOT EXISTS `assignment-three-db` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `assignment-three-db`;
drop table if exists `dvd`;

CREATE TABLE `dvd` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `year` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;
select * from dvd;
