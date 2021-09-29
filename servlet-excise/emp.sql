# Host: localhost  (Version: 5.5.15)
# Date: 2021-08-20 15:34:52
# Generator: MySQL-Front 5.3  (Build 4.269)

/*!40101 SET NAMES gb2312 */;

#
# Structure for table "emp"
#

DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(20) NOT NULL,
  `salary` double NOT NULL,
  `age` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

#
# Data for table "emp"
#

INSERT INTO `emp` VALUES (2,'ericting',2001230,20),(3,'xiaoyong',3000000,22),(4,'dayong',5000000,25);

#
# Structure for table "empmanager"
#

DROP TABLE IF EXISTS `empmanager`;
CREATE TABLE `empmanager` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "empmanager"
#

INSERT INTO `empmanager` VALUES ('qingwa','123456');
