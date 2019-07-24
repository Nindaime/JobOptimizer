CREATE DATABASE  IF NOT EXISTS `JobOptimizer` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `JobOptimizer`;
-- MySQL dump 10.13  Distrib 5.7.26, for Linux (x86_64)
--
-- Host: localhost    Database: JobOptimizer
-- ------------------------------------------------------
-- Server version	5.7.26-0ubuntu0.18.04.1

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
-- Table structure for table `AssignableJob`
--

DROP TABLE IF EXISTS `AssignableJob`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `AssignableJob` (
  `JobID` int(11) NOT NULL,
  `JobName` varchar(16) DEFAULT '',
  `JobDifficulty` tinyint(4) DEFAULT NULL,
  `JobTitleID` int(11) NOT NULL,
  `JobObjectID` int(11) NOT NULL,
  `IntrPrioNumb` int(11) NOT NULL,
  `JobRestTime` timestamp NULL DEFAULT NULL,
  `JobType` varchar(16) NOT NULL,
  `JobGroup` varchar(16) DEFAULT NULL,
  `JobSubgroup` varchar(16) DEFAULT NULL,
  `EstiExecDuration` tinyint(4) NOT NULL,
  PRIMARY KEY (`JobID`,`JobTitleID`,`JobObjectID`),
  KEY `fk_AssignableJob_JobObject1_idx` (`JobObjectID`),
  KEY `fk_AssignableJob_UserJobRole1_idx` (`JobTitleID`),
  CONSTRAINT `fk_AssignableJob_JobObject1` FOREIGN KEY (`JobObjectID`) REFERENCES `JobObject` (`JobObjectID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_AssignableJob_JobToDo2` FOREIGN KEY (`JobID`) REFERENCES `JobToDo` (`JobID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_AssignableJob_UserJobRole1` FOREIGN KEY (`JobTitleID`) REFERENCES `UserJobRole` (`JobTitleID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Branch`
--

DROP TABLE IF EXISTS `Branch`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Branch` (
  `BranchID` int(11) NOT NULL,
  `BranchName` varchar(16) NOT NULL,
  `BranchLocation` varchar(12) NOT NULL,
  PRIMARY KEY (`BranchID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `JobObject`
--

DROP TABLE IF EXISTS `JobObject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `JobObject` (
  `JobObjectID` int(11) NOT NULL,
  `JobObjectName` varchar(16) NOT NULL,
  `JobObjectLocation` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`JobObjectID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `JobToDo`
--

DROP TABLE IF EXISTS `JobToDo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `JobToDo` (
  `JobID` int(11) NOT NULL,
  `JobAssigner` int(11) NOT NULL,
  `TimeOfAssignment` timestamp NULL DEFAULT NULL,
  `JobAssigneeGroup` varchar(12) NOT NULL,
  `JobStartTime` timestamp NULL DEFAULT NULL,
  `JobSubmissionTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `LinkedJobID` int(11) DEFAULT NULL,
  `PriorityNumber` int(11) DEFAULT NULL,
  `JobAffinity` varchar(12) DEFAULT NULL,
  `JobDeadline` datetime DEFAULT NULL,
  PRIMARY KEY (`JobID`,`JobAssigner`,`JobSubmissionTime`),
  KEY `fk_JobToDo_Users1_idx` (`JobAssigner`),
  CONSTRAINT `fk_JobToDo_Users1` FOREIGN KEY (`JobAssigner`) REFERENCES `Users` (`UserID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `UserFatigue`
--

DROP TABLE IF EXISTS `UserFatigue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `UserFatigue` (
  `UserID` int(11) NOT NULL,
  `JobSubmissionTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `FatigueValue` int(11) NOT NULL,
  `Workload` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`UserID`,`JobSubmissionTime`),
  CONSTRAINT `fk_UserFatigue_Users` FOREIGN KEY (`UserID`) REFERENCES `Users` (`UserID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `UserJobRole`
--

DROP TABLE IF EXISTS `UserJobRole`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `UserJobRole` (
  `JobTitleID` int(11) NOT NULL,
  `JobTitle` varchar(45) DEFAULT NULL,
  `JobSupervisorID` int(11) DEFAULT NULL,
  PRIMARY KEY (`JobTitleID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Users`
--

DROP TABLE IF EXISTS `Users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Users` (
  `UserID` int(11) NOT NULL,
  `BranchID` int(11) NOT NULL,
  `JobTitleID` int(11) NOT NULL,
  `SkillLevel` tinyint(4) DEFAULT NULL,
  `ProdCurvAmpl` enum('low-low-low','low-low-mid','low-low-high','low-mid-low','low-mid-mid','low-mid-high','low-high-low','low-high-mid','low-high-high','mid-low-low','mid-low-mid','mid-low-high','mid-mid-low','mid-mid-mid','mid-mid-high','mid-high-low','mid-high-mid','mid-high-high','high-low-low','high-low-mid','high-low-high','high-mid-low','high-mid-mid','high-mid-high','high-high-low','high-high-mid','high-high-high') DEFAULT NULL,
  `CurrentLocation` varchar(12) NOT NULL,
  PRIMARY KEY (`UserID`,`BranchID`,`JobTitleID`),
  KEY `fk_Users_Branch1_idx` (`BranchID`),
  KEY `fk_Users_UserJobRole1_idx` (`JobTitleID`),
  CONSTRAINT `fk_Users_Branch1` FOREIGN KEY (`BranchID`) REFERENCES `Branch` (`BranchID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Users_UserJobRole1` FOREIGN KEY (`JobTitleID`) REFERENCES `UserJobRole` (`JobTitleID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping events for database 'JobOptimizer'
--

--
-- Dumping routines for database 'JobOptimizer'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-11 23:06:41
