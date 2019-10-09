/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.40-log : Database - blog
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`blog` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `blog`;

/*Table structure for table `b_admin` */

DROP TABLE IF EXISTS `b_admin`;

CREATE TABLE `b_admin` (
  `id` int(30) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `adminName` varchar(20) NOT NULL DEFAULT '跌名',
  `roles` enum('MEMBER','MEMBER,LEADER','SUPER_ADMIN') NOT NULL DEFAULT 'MEMBER',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `b_admin` */

insert  into `b_admin`(`id`,`username`,`password`,`adminName`,`roles`) values (1,'admin','123','跌名','MEMBER');

/*Table structure for table `b_ainfo` */

DROP TABLE IF EXISTS `b_ainfo`;

CREATE TABLE `b_ainfo` (
  `id` int(200) NOT NULL AUTO_INCREMENT,
  `title` varchar(20) NOT NULL DEFAULT 'Java后端的私人小博客',
  `updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `categoryId` int(50) DEFAULT NULL,
  `keyword` varchar(20) DEFAULT NULL,
  `des` varchar(100) DEFAULT NULL,
  `label` varchar(20) DEFAULT 'Java',
  `prcture` varchar(255) DEFAULT '没有插入图片',
  `createdate` datetime DEFAULT NULL,
  `simpleContent` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `b_ainfo` */

insert  into `b_ainfo`(`id`,`title`,`updatetime`,`categoryId`,`keyword`,`des`,`label`,`prcture`,`createdate`,`simpleContent`) values (1,'Java后端的私人小博客','2019-10-03 23:24:12',40,'test','test','Java','没有插入图片',NULL,''),(3,'标题','2019-10-04 22:39:29',40,'关键词','test','spring','没有插入图片','2019-10-04 22:18:27',''),(4,'标题','2019-10-05 17:10:49',39,NULL,NULL,'Java','没有插入图片','2019-10-05 17:10:49',''),(5,'2','2019-10-05 18:01:58',40,'','test',NULL,NULL,'2019-10-05 18:01:58',''),(6,'testContent','2019-10-05 20:33:37',39,'testContent','test',NULL,NULL,'2019-10-05 20:33:37',''),(7,'testContent','2019-10-05 20:34:22',39,'testContent','test',NULL,NULL,'2019-10-05 20:34:22',''),(8,'testContent','2019-10-05 20:34:56',39,'testContent','test',NULL,NULL,'2019-10-05 20:34:56',''),(9,'testContent','2019-10-05 21:23:48',39,'testContent','testContent',NULL,NULL,'2019-10-05 21:23:48','testContent'),(10,'1','2019-10-07 19:24:32',40,'','',NULL,NULL,'2019-10-07 19:24:32',''),(11,'2','2019-10-07 21:25:12',40,'','',NULL,NULL,'2019-10-07 21:25:12','');

/*Table structure for table `b_category` */

DROP TABLE IF EXISTS `b_category`;

CREATE TABLE `b_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `aliasname` varchar(50) NOT NULL,
  `keyword` varchar(50) DEFAULT NULL,
  `des` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

/*Data for the table `b_category` */

insert  into `b_category`(`id`,`name`,`aliasname`,`keyword`,`des`) values (35,'数据结构','数据结构','数据结构JAVA语言描述','使用JAVA语言描述数据的八大结构数组，栈，队列，链表，树，图，散列表（哈希表）'),(36,'JAVA基础','JAVA','Java基础知识，Java后端开发基础','Java语言的基础知识，关于Java的特性描述'),(37,'Spring框架','Spring','Spring框架，Spring Boot，Spring Cloud','Spring框架的博文，框架的基本用法以及部分源码解析，记录使用Spring遇到的问题'),(38,'Linux系统','Linux','Linux操作系统，Linux的常规使用','Linux的常用指令，使用过程遇到的问题以及解决方案，Linux的使用说明'),(39,'数据存储','MySQL与Redis','MySQL和Redis的使用记录','关系型数据库与非关系型数据库的使用，数据库的特点以及优化方案'),(40,'前端技术','前端展示','Jquery和Ajax，Vue.js','前端数据交互，以及页面展示技术，前端数据处理技术的博文');

/*Table structure for table `b_content` */

DROP TABLE IF EXISTS `b_content`;

CREATE TABLE `b_content` (
  `id` int(200) NOT NULL AUTO_INCREMENT,
  `infoId` int(50) NOT NULL,
  `content` text NOT NULL,
  `cfile` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `b_content` */

insert  into `b_content`(`id`,`infoId`,`content`,`cfile`) values (1,9,'<p>testContent</p>',NULL),(2,10,'<p><img src=\"C:/Users/EL/Desktop/blog/target/classes/static/backstage/lib/ueditor/jsp/ueditor/jsp/upload/image/20191003/1570098840697053558.jpg\" alt=\"1570098840697053558.jpg\"/></p>',NULL),(3,11,'<p><img src=\"C:/Users/EL/Desktop/blog/target/classes/static/backstage/lib/ueditor/jsp/ueditor/jsp/upload/image/20191003/1570098840697053558.jpg\" alt=\"1570098840697053558.jpg\"/></p>',NULL);

/*Table structure for table `b_flink` */

DROP TABLE IF EXISTS `b_flink`;

CREATE TABLE `b_flink` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `linkname` varchar(20) NOT NULL DEFAULT '测试链接',
  `url` varchar(255) NOT NULL DEFAULT '#',
  `image` varchar(255) DEFAULT NULL,
  `des` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `b_flink` */

insert  into `b_flink`(`id`,`linkname`,`url`,`image`,`des`) values (9,'baidu','http://www.baidu.com','http://www.baidu.com',''),(10,'CSDN','https://blog.csdn.net/','https://blog.csdn.net/',''),(11,'GitHub','https://github.com/','https://github.com/','');

/*Table structure for table `b_ilabel` */

DROP TABLE IF EXISTS `b_ilabel`;

CREATE TABLE `b_ilabel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `categoryid` int(200) NOT NULL,
  `labelname` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `b_ilabel` */

insert  into `b_ilabel`(`id`,`categoryid`,`labelname`) values (1,40,'test'),(2,40,'test');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
