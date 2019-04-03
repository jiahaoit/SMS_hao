/*
SQLyog v10.2 
MySQL - 5.1.31-community : Database - sms14
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`sms14` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `sms14`;

/*Table structure for table `idinfo` */

DROP TABLE IF EXISTS `idinfo`;

CREATE TABLE `idinfo` (
  `username` varchar(20) DEFAULT '',
  `password` varchar(20) DEFAULT NULL,
  `date` timestamp NULL DEFAULT NULL,
  `id` int(10) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `idinfo` */

insert  into `idinfo`(`username`,`password`,`date`,`id`) values ('a','a','2017-01-05 14:07:55',1),('GHOST韓','GHOST韓','2017-01-06 10:27:47',2);

/*Table structure for table `t_student` */

DROP TABLE IF EXISTS `t_student`;

CREATE TABLE `t_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `myclass` varchar(50) DEFAULT NULL,
  `score` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8;

/*Data for the table `t_student` */

insert  into `t_student`(`id`,`name`,`myclass`,`score`) values (10,'崔国奇','13专2',100),(11,'卫改燕','13专2',100),(12,'赵晓然','13专2',100),(13,'郑亚星','13专2',100),(14,'刘茹勤','13专2',100),(15,'李东','13专2',100),(16,'刘石岩','13专2',100),(17,'刘丹丹','13专2',100),(18,'康康','13专2',100),(19,'曹宁宁','13专2',100),(20,'刘珊珊','13专2',100),(21,'史美玲','13专2',100),(22,'左梦娜','13专2',100),(23,'王昕宇','13专2',100),(24,'宋博涵','13专2',100),(25,'王瑞会','13专2',100),(26,'王扬扬','13专2',100),(27,'于姗姗','13专2',100),(28,'赵佳','13专2',100),(29,'李慧霞','13专2',100),(30,'王兵','13专2',100),(31,'褚晓茹','13专2',100),(32,'刘肖娥','13专2',100),(33,'张硕','13专2',100),(34,'崔盛雅','13专2',100),(35,'张韦龙','13专2',100),(36,'张歌','13专2',100),(37,'杨明','13专2',100),(38,'杨晨蕾','13专2',100),(39,'吴晗笑','13专2',100),(40,'李玉寒','13专2',100),(41,'韩晓倩','13专2',100),(42,'苗烘鑫','13专2',100),(43,'国跃','13专2',100),(44,'张彩霞','13专2',100),(45,'乔瑞芳','13专2',100),(46,'李喜蒙','13专1',100),(47,'吴叶','13专1',100),(48,'申影','13专1',100),(49,'谢宇欣','13专1',100),(50,'柳琦','13专1',100),(51,'安志敏','13专1',100),(52,'冀濛濛','13专1',100),(53,'王瑞华','13专1',100),(54,'孙丽青','13专1',100),(55,'李晓亮','13专1',100),(56,'郭宁','13专1',100),(57,'韩秋霞','13专1',100),(58,'崔孜萌','13专1',100),(59,'张耀强','13专1',100),(60,'刘玉欣','13专1',100),(61,'张晓','13专1',100),(62,'张扬','13专1',100),(63,'郑中雨','13专1',100),(64,'于志朋','13专1',100),(65,'胡静微','13专1',100),(66,'秦甜甜','13专1',100),(67,'柳仕冉','13专1',100),(68,'黄广斌','13专1',100),(69,'刘凯','13专1',100),(70,'陈秋月','13专1',100),(71,'叶昊男','13专1',100),(72,'王素美','13专1',100),(73,'张江涛','13专1',100),(74,'张超','13专1',100),(75,'霍晓政','13专1',100),(77,'朱钧','13专1',100),(78,'李虹艺','13专1',100),(79,'周瑞敏','13专1',100),(80,'罗峰','江南',99),(81,'洪','极限 ',89),(82,'雷','雷',85);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
