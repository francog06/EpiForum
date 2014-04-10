CREATE DATABASE  IF NOT EXISTS `epiforum` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `epiforum`;
-- MySQL dump 10.13  Distrib 5.5.35, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: epiforum
-- ------------------------------------------------------
-- Server version	5.5.35-0ubuntu0.12.04.2-log

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

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `created` datetime NOT NULL,
  `modified` datetime NOT NULL,
  `status` int(11) NOT NULL DEFAULT '0',
  `type` int(11) NOT NULL DEFAULT '0',
  `email` varchar(128) NOT NULL,
  `password` varchar(64) NOT NULL,
  `activationCode` varchar(16) NOT NULL,
  `ipAddress` varchar(16) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (8,'2014-03-27 20:24:42','2014-03-27 21:42:15',2,2,'guillomef06@gmail.com','IapAzx8iKMkIl2xr0K8eww1RHmsAAAAAAAAAAAAAAAAAAAAAAAAAAA==','5WpZmETSdD40IRaF','127.0.0.1'),(9,'2014-04-06 05:53:55','2014-04-06 23:44:55',2,1,'moreno.igor06@gmail.com','WeTeL9eKhGYO9qU7QoDizTzizKwAAAAAAAAAAAAAAAAAAAAAAAAAAA==','tHWxvVAJUY1taTsI','127.0.0.1'),(10,'2014-04-07 01:41:15','2014-04-09 01:00:37',0,0,'guillaumef06@live.fr','IapAzx8iKMkIl2xr0K8eww1RHmsAAAAAAAAAAAAAAAAAAAAAAAAAAA==','sPSjIRiaHqs5ZAXY','127.0.0.1');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `board`
--

DROP TABLE IF EXISTS `board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `board` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `created` datetime NOT NULL,
  `modified` datetime NOT NULL,
  `categoryId` int(10) unsigned NOT NULL,
  `title` varchar(64) NOT NULL,
  `description` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_board_categoryId_idx` (`categoryId`),
  CONSTRAINT `fk_board_categoryId` FOREIGN KEY (`categoryId`) REFERENCES `category` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `board`
--

LOCK TABLES `board` WRITE;
/*!40000 ALTER TABLE `board` DISABLE KEYS */;
INSERT INTO `board` VALUES (1,'2014-03-28 03:02:06','2014-03-28 03:02:06',1,'News et annonces de EpiForum','Restez branchés !'),(2,'2014-03-28 03:02:06','2014-03-28 03:02:06',1,'Astuces et suggestions','Vous avez un doutes sur le fonctionnement du forum ? C\'est par ici !'),(3,'2014-03-28 03:02:06','2014-03-28 03:02:06',1,'Comme à la maison','Entrez, c\'est ouvert ! On vous à laissé une place. Presentez vous et faites connaissances avec les membres.'),(4,'2014-03-28 03:28:45','2014-03-28 03:28:45',2,'Le C','Le C est un langage de programmation impératif, généraliste, issu de la programmation système. Inventé au début des années 1970 pour réécrire UNIX, C est devenu un des langages les plus utilisés.'),(5,'2014-03-28 03:28:45','2014-03-28 03:28:45',2,'Le C++','Le C++ est un langage de programmation permettant la programmation sous de multiples paradigmes comme la programmation procédurale, la programmation orientée objet et la programmation générique.'),(6,'2014-03-28 03:28:45','2014-03-28 03:28:45',2,'Le Python','Le Python est un langage de programmation objet, multi-paradigme et multi-plateformes. Il est doté d\'un typage dynamique fort, d\'un ramasse-miettes et d\'un système de gestion d\'exceptions.'),(7,'2014-03-28 03:28:45','2014-03-28 03:28:45',2,'Le Java','Le langage Java est un langage de programmation informatique orienté objet, multi-plateformes. Write once, run anywhere !'),(8,'2014-03-28 03:28:45','2014-03-28 03:28:45',2,'Le PHP','Le PHP est un langage impératif orienté-objet. Il est principalement utilisé pour produire des pages Web dynamiques via un serveur HTTP, mais pouvant également fonctionner comme n\'importe quel langage interprété de façon locale.'),(9,'2014-03-28 03:28:45','2014-03-28 03:28:45',2,'Le Perl','Le Perl est un langage de programmation reprenant certaines fonctionnalités du langage C et des langages de scripts sed, awk et shell.'),(10,'2014-03-28 03:28:45','2014-03-28 03:28:45',2,'Le Ruby','Le Ruby est un langage de programmation libre. Il est interprété, orienté objet et multi-paradigme.'),(11,'2014-03-28 03:28:45','2014-03-28 03:28:45',2,'Le JavaScript','Le JavaScript est un langage de programmation de scripts principalement utilisé dans les pages web interactives mais aussi côté serveur.'),(12,'2014-03-28 10:09:42','2014-03-28 10:09:42',3,'Les réseaux LAN','LAN de Local Area Network est un réseau informatique tel que les terminaux qui y participent s\'envoient des trames au niveau de la couche de liaison sans utiliser d’accès à internet.'),(13,'2014-03-28 10:09:42','2014-03-28 10:09:42',3,'Les réseaux MAN','MAN de Metropolitan Area Network désigne un réseau composé d\'ordinateurs habituellement utilisé dans les campus ou dans les villes.'),(14,'2014-03-28 10:09:42','2014-03-28 10:09:42',3,'Les réseaux WAN','WAN de Wide Area Network est un réseau informatique couvrant une grande zone géographique, typiquement à l\'échelle d\'un pays, d\'un continent, voire de la planète entière. Le plus grand WAN est le réseau Internet.'),(15,'2014-03-28 10:09:43','2014-03-28 10:09:43',4,'La sécurité de l\'information','La sécurité de l\'information est un processus visant à protéger des données. Elle s\'applique à tous les aspects de la sûreté, la garantie, et la protection d\'une donnée ou d\'une information, quelle que soit sa forme.'),(16,'2014-03-28 10:09:43','2014-03-28 10:09:43',4,'La sécurité des données','La sécurité des données est la branche qui s\'intéresse principalement aux données, en complément des aspects de traitement de l\'information.'),(17,'2014-03-28 10:09:43','2014-03-28 10:09:43',4,'La sécurité des réseaux','Les technologies de sécurité réseau protègent votre réseau contre les vols et l\'utilisation abusive des informations confidentielles et offrent une sécurité contre les attaques malveillantes qui circulent sur Internet.'),(18,'2014-03-28 10:09:43','2014-03-28 10:09:43',4,'La sécurité des applications','La programmation sécurisée consiste à prendre en compte la sécurité informatique à tous les moments de la conception, de la réalisation et de l\'utilisation d\'un programme informatique.'),(19,'2014-03-28 10:09:43','2014-03-28 10:09:43',4,'La sécurité physique','La sécurité physique est la sécurité au niveau des infrastructures matérielles : salles sécurisées, lieux ouverts au public, espaces communs de l\'entreprise, postes de travail des personnels etc.'),(20,'2014-03-28 11:06:56','2014-03-28 11:06:56',2,'Le C#','Le C# est un langage de programmation orienté objet à typage fort, créé par la société Microsoft.');
/*!40000 ALTER TABLE `board` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `created` datetime NOT NULL,
  `modified` datetime NOT NULL,
  `title` varchar(64) NOT NULL,
  `description` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'2014-03-28 02:42:07','2014-03-28 02:42:07','EpiForum','Vous trouverez ici les news, les annonces, de l\'aide, les suggestions et une place sur le canapé !'),(2,'2014-03-28 02:42:07','2014-03-28 02:42:07','Programmation','La programmation dans le domaine informatique est l\'ensemble des activités qui permettent l\'écriture des programmes informatiques. C\'est une étape importante du développement de logiciels.'),(3,'2014-03-28 02:42:07','2014-03-28 02:42:07','Réseau','Un réseau informatique est un ensemble d\'équipements reliés entre eux pour échanger des informations. Par analogie avec un filet, on appelle nœud l\'extrémité d\'une connexion, qui peut être une intersection de plusieurs connexions ou équipements.'),(4,'2014-03-28 02:42:07','2014-03-28 02:42:07','Sécurité','La sécurité des systèmes d’information est l’ensemble des moyens techniques, organisationnels, juridiques et humains nécessaire et mis en place pour conserver, rétablir, et garantir la sécurité du système d\'information.');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contentPost`
--

DROP TABLE IF EXISTS `contentPost`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contentPost` (
  `postId` int(10) unsigned NOT NULL,
  `content` text NOT NULL,
  PRIMARY KEY (`postId`),
  UNIQUE KEY `postId_UNIQUE` (`postId`),
  CONSTRAINT `fk_contentPost_postId` FOREIGN KEY (`postId`) REFERENCES `post` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contentPost`
--

LOCK TABLES `contentPost` WRITE;
/*!40000 ALTER TABLE `contentPost` DISABLE KEYS */;
INSERT INTO `contentPost` VALUES (2,'Salut tout le monde !\r\nCertains me connaissent déjà, d\'autres non alors que les présentations commencent !\r\n\r\nGuillaume François, 23 ans passionné par l\'IT, je suis le co-créateur de EpiForum avec Igor Moreno !'),(3,'Ceci est une réponse au premier message !'),(4,'Et voici une deuxiéme réponse c\'est la folie ce soir !'),(5,'Et voila la 3éme réponse omg :D c\'est trop SWAG\r\n\r\nIGOR JTE KIFFE'),(6,'Et voila le 4éme !!!'),(7,'Encore une réponse on arrête plus !'),(8,'Et le dernier message avant d\'aller dormir avec les tags s\'il vous plait !\r\n\r\nSi c\'est pas beau tout ca :D'),(9,'Izy ca marche le feu Igor in da place mothafucka'),(10,'EDIT: J\'me réponds à moi même parce que je m\'aime ! \r\n\r\n\r\nEt voila j\'ai mis a jour mon message oueche !!!'),(13,'Bientot la v1!'),(14,'Ça commence sérieusement à avoir de la gueule tout ça hein ! Bogoss Igor :)'),(15,'Je poste un message et je me desinscris direct !'),(16,'Et je peux repondre meme si ce sujet est vérouillé !\r\nC\'est ca d\'avoir la puissance !!!'),(17,'Même si le forum n\'est pas totalement terminé, nous espérons que la futur v1 vous plaira !');
/*!40000 ALTER TABLE `contentPost` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `post` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `created` datetime NOT NULL,
  `modified` datetime NOT NULL,
  `topicId` int(10) unsigned NOT NULL,
  `profileId` int(10) unsigned NOT NULL,
  `tag` varchar(64) DEFAULT NULL,
  `deleted` bit(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_post_topicId_idx` (`topicId`),
  KEY `fk_post_profileId_idx` (`profileId`),
  CONSTRAINT `fk_post_profileId` FOREIGN KEY (`profileId`) REFERENCES `profile` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_post_topicId` FOREIGN KEY (`topicId`) REFERENCES `topic` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
INSERT INTO `post` VALUES (2,'2014-04-05 20:08:48','2014-04-05 20:08:48',5,8,'#Presentation#Membres#EpiForum','\0'),(3,'2014-04-06 05:01:34','2014-04-06 05:01:34',5,8,NULL,'\0'),(4,'2014-04-06 05:04:49','2014-04-06 05:04:49',5,8,NULL,'\0'),(5,'2014-04-06 05:31:17','2014-04-06 05:31:17',5,8,NULL,'\0'),(6,'2014-04-06 05:34:50','2014-04-06 05:34:50',5,8,NULL,'\0'),(7,'2014-04-06 05:35:12','2014-04-06 05:35:12',5,8,NULL,'\0'),(8,'2014-04-06 06:33:46','2014-04-06 06:33:46',5,8,'#Pres#Membres#Izy','\0'),(9,'2014-04-06 16:46:27','2014-04-06 16:46:27',5,9,'#Pres#IgoroSan#EpiForum','\0'),(10,'2014-04-06 17:14:58','2014-04-07 00:36:46',5,9,NULL,''),(13,'2014-04-06 17:35:23','2014-04-06 17:35:23',8,9,'#news#epiforum','\0'),(14,'2014-04-06 20:00:45','2014-04-06 20:00:45',8,8,'#News#EpiForum','\0'),(15,'2014-04-07 01:43:16','2014-04-07 01:43:16',5,10,'#Ragequit','\0'),(16,'2014-04-07 04:35:00','2014-04-07 04:35:00',8,8,'#News#EpiForum#Power','\0'),(17,'2014-04-07 17:23:55','2014-04-07 17:23:55',9,9,'#EpiForum#Annonce','\0');
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profile`
--

DROP TABLE IF EXISTS `profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `profile` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `created` datetime NOT NULL,
  `modified` datetime NOT NULL,
  `accountId` int(10) unsigned NOT NULL,
  `firstname` varchar(64) DEFAULT NULL,
  `lastname` varchar(64) DEFAULT NULL,
  `nickname` varchar(128) NOT NULL,
  `phone` varchar(16) DEFAULT NULL,
  `facebookPage` varchar(64) DEFAULT NULL,
  `twitterPage` varchar(64) DEFAULT NULL,
  `skypeContact` varchar(64) DEFAULT NULL,
  `city` varchar(128) DEFAULT NULL,
  `description` varchar(256) DEFAULT NULL,
  `signature` varchar(256) DEFAULT NULL,
  `gender` bit(1) DEFAULT NULL,
  `picture` bit(1) NOT NULL,
  `birthdate` date DEFAULT NULL,
  `posts` int(10) unsigned NOT NULL,
  `thanks` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `nickname_UNIQUE` (`nickname`),
  KEY `fk_profile_accountId_idx` (`accountId`),
  CONSTRAINT `fk_profile_accountId` FOREIGN KEY (`accountId`) REFERENCES `account` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profile`
--

LOCK TABLES `profile` WRITE;
/*!40000 ALTER TABLE `profile` DISABLE KEYS */;
INSERT INTO `profile` VALUES (8,'2014-03-27 20:24:42','2014-04-07 04:35:00',8,'Guillaume','Francois','Guillomef06','+33781170329','guillomef06','guillomef06','guillaumef06','Nice','Créateur avec Moreno Igor de EpiForum !','Like the wind I come to win','','','1991-04-06',9,3),(9,'2014-04-06 05:53:55','2014-04-08 02:38:25',9,'Igor','Moreno','IgoroSan','0695143759',NULL,NULL,'snakelecaps','Nice','Japonais noir !','Never sleep','','','1987-04-23',7,2),(10,'2014-04-07 01:41:15','2014-04-07 01:43:16',10,NULL,NULL,'franco',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'\0',NULL,1,0);
/*!40000 ALTER TABLE `profile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `session`
--

DROP TABLE IF EXISTS `session`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `session` (
  `id` varchar(16) NOT NULL,
  `created` datetime NOT NULL,
  `modified` datetime NOT NULL,
  `profileId` int(10) unsigned NOT NULL,
  `lastActivity` varchar(64) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_session_profileId_idx` (`profileId`),
  CONSTRAINT `fk_session_profileId` FOREIGN KEY (`profileId`) REFERENCES `profile` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `session`
--

LOCK TABLES `session` WRITE;
/*!40000 ALTER TABLE `session` DISABLE KEYS */;
INSERT INTO `session` VALUES ('nlxyMmwDmHx7tPJo','2014-04-09 01:00:33','2014-04-09 01:00:37',8,'banMember');
/*!40000 ALTER TABLE `session` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `topic`
--

DROP TABLE IF EXISTS `topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `topic` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `created` datetime NOT NULL,
  `modified` datetime NOT NULL,
  `boardId` int(10) unsigned NOT NULL,
  `title` varchar(64) NOT NULL,
  `description` varchar(256) DEFAULT NULL,
  `locked` bit(1) NOT NULL,
  `nbPost` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_topic_boardId_idx` (`boardId`),
  CONSTRAINT `fk_topic_boardId` FOREIGN KEY (`boardId`) REFERENCES `board` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topic`
--

LOCK TABLES `topic` WRITE;
/*!40000 ALTER TABLE `topic` DISABLE KEYS */;
INSERT INTO `topic` VALUES (5,'2014-04-05 20:08:48','2014-04-08 03:18:34',3,'Présentation des membres','Et si vous nous parliez un peu de vous ?','\0',9),(8,'2014-04-06 17:35:23','2014-04-07 23:11:56',1,'News Epiforum','Vous trouverez ici toute l\'actualité d\'EpiForum !','\0',3),(9,'2014-04-07 17:23:55','2014-04-07 23:12:49',1,'Annonces EpiForum','Vous trouverez les annonces D\'EpiForum par ici ! :D','\0',1);
/*!40000 ALTER TABLE `topic` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-04-09  1:07:35
