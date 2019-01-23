CREATE TABLE `User` ( `name` varchar(30) DEFAULT NULL, `DateofBirth` date DEFAULT NULL, `Gender` varchar(10) DEFAULT NULL,  `Mail` varchar(30) NOT NULL, `Password` varchar(10) DEFAULT NULL, `Education` varchar(30) DEFAULT NULL, PRIMARY KEY (`Mail`))


CREATE TABLE `Account` (`AccountId` int(11) NOT NULL AUTO_INCREMENT,  `Name` char(100) NOT NULL,  `HouseNo` varchar(200) NOT NULL,  `Street` varchar(200) NOT NULL,  `City` varchar(100) DEFAULT NULL,  `State` char(50) DEFAULT NULL,  `ZipCode` char(30) NOT NULL,  `Role` varchar(45) DEFAULT 'user',  `Email` varchar(45) DEFAULT NULL,  PRIMARY KEY (`AccountId`),  UNIQUE KEY `Email` (`Email`))

CREATE TABLE `Contact` (  `ContactId` int(11) NOT NULL AUTO_INCREMENT,  `AccountId` int(11) DEFAULT NULL,  `LastName` char(50) DEFAULT NULL,  `FirstName` char(50) DEFAULT NULL,  `Phone` char(40) NOT NULL,  `Email` char(100) NOT NULL,  PRIMARY KEY (`ContactId`),  UNIQUE KEY `Email_UNIQUE` (`Email`),  KEY `fk_Contact_1_idx` (`AccountId`),  CONSTRAINT `fk_Contact_1` FOREIGN KEY (`AccountId`) REFERENCES `Account` (`AccountId`) ON DELETE CASCADE ON UPDATE CASCADE) 

CREATE TABLE `ServiceRequest` (  `ID` int(11) NOT NULL AUTO_INCREMENT,  `Title` varchar(512) NOT NULL,  `AccountId` int(11) DEFAULT NULL,  `ContactId` int(11) DEFAULT NULL,  `Status` char(20) NOT NULL,  `Opendate` timestamp(6) NULL DEFAULT NULL,  `CloseDate` timestamp(6) NULL DEFAULT NULL,  `Description` varchar(512) DEFAULT NULL,  PRIMARY KEY (`ID`),  KEY `fk_ServiceRequest_2_idx` (`ContactId`),  KEY `fk_ServiceRequest_1_idx` (`AccountId`),  CONSTRAINT `fk_ServiceRequest_1` FOREIGN KEY (`AccountId`) REFERENCES `Account` (`AccountId`) ON DELETE CASCADE ON UPDATE CASCADE,  CONSTRAINT `fk_ServiceRequest_2` FOREIGN KEY (`ContactId`) REFERENCES `Contact` (`ContactId`) ON DELETE CASCADE ON UPDATE CASCADE)

CREATE TABLE `Activity` (  `ID` int(11) NOT NULL AUTO_INCREMENT,  `ServiceRequestId` int(11) DEFAULT NULL,  `UpdatedDate` timestamp NULL DEFAULT NULL,  `Update` varchar(45) DEFAULT NULL,  PRIMARY KEY (`ID`),  KEY `fk_Activity_1_idx` (`ServiceRequestId`),  CONSTRAINT `fk_Activity_1` FOREIGN KEY (`ServiceRequestId`) REFERENCES `ServiceRequest` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE)
