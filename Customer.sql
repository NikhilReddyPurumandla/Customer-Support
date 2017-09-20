/*User table*/
'User', 'CREATE TABLE `User` (\n  `name` varchar(30) DEFAULT NULL,\n  `DateofBirth` date DEFAULT NULL,\n  `Gender` varchar(10) DEFAULT NULL,\n  `Mail` varchar(30) NOT NULL,\n  `Password` varchar(10) DEFAULT NULL,\n  `Education` varchar(30) DEFAULT NULL,\n  PRIMARY KEY (`Mail`)\n) ENGINE=InnoDB DEFAULT CHARSET=latin1'


/* Account table */
'Account', 'CREATE TABLE `Account` (\n  `AccountId` int(11) NOT NULL AUTO_INCREMENT,\n  `Name` char(100) NOT NULL,\n  `HouseNo` varchar(200) NOT NULL,\n  `Street` varchar(200) NOT NULL,\n  `City` varchar(100) DEFAULT NULL,\n  `State` char(50) DEFAULT NULL,\n  `ZipCode` char(30) NOT NULL,\n  `Role` varchar(45) DEFAULT \'user\',\n  `Email` varchar(45) DEFAULT NULL,\n  PRIMARY KEY (`AccountId`),\n  UNIQUE KEY `Email` (`Email`)\n) ENGINE=InnoDB AUTO_INCREMENT=168 DEFAULT CHARSET=latin1'

/* Activity table */
'Activity', 'CREATE TABLE `Activity` (\n  `ID` int(11) NOT NULL AUTO_INCREMENT,\n  `ServiceRequestId` int(11) DEFAULT NULL,\n  `UpdatedDate` timestamp NULL DEFAULT NULL,\n  `Update` varchar(45) DEFAULT NULL,\n  PRIMARY KEY (`ID`),\n  KEY `fk_Activity_1_idx` (`ServiceRequestId`),\n  CONSTRAINT `fk_Activity_1` FOREIGN KEY (`ServiceRequestId`) REFERENCES `ServiceRequest` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE\n) ENGINE=InnoDB AUTO_INCREMENT=122 DEFAULT CHARSET=latin1'

/* Contact table */
'Contact', 'CREATE TABLE `Contact` (\n  `ContactId` int(11) NOT NULL AUTO_INCREMENT,\n  `AccountId` int(11) DEFAULT NULL,\n  `LastName` char(50) DEFAULT NULL,\n  `FirstName` char(50) DEFAULT NULL,\n  `Phone` char(40) NOT NULL,\n  `Email` char(100) NOT NULL,\n  PRIMARY KEY (`ContactId`),\n  UNIQUE KEY `Email_UNIQUE` (`Email`),\n  KEY `fk_Contact_1_idx` (`AccountId`),\n  CONSTRAINT `fk_Contact_1` FOREIGN KEY (`AccountId`) REFERENCES `Account` (`AccountId`) ON DELETE CASCADE ON UPDATE CASCADE\n) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=latin1'

/* ServiceRequest table */
'ServiceRequest', 'CREATE TABLE `ServiceRequest` (\n  `ID` int(11) NOT NULL AUTO_INCREMENT,\n  `Title` varchar(512) NOT NULL,\n  `AccountId` int(11) DEFAULT NULL,\n  `ContactId` int(11) DEFAULT NULL,\n  `Status` char(20) NOT NULL,\n  `Opendate` timestamp(6) NULL DEFAULT NULL,\n  `CloseDate` timestamp(6) NULL DEFAULT NULL,\n  `Description` varchar(512) DEFAULT NULL,\n  PRIMARY KEY (`ID`),\n  KEY `fk_ServiceRequest_2_idx` (`ContactId`),\n  KEY `fk_ServiceRequest_1_idx` (`AccountId`),\n  CONSTRAINT `fk_ServiceRequest_1` FOREIGN KEY (`AccountId`) REFERENCES `Account` (`AccountId`) ON DELETE CASCADE ON UPDATE CASCADE,\n  CONSTRAINT `fk_ServiceRequest_2` FOREIGN KEY (`ContactId`) REFERENCES `Contact` (`ContactId`) ON DELETE CASCADE ON UPDATE CASCADE\n) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=latin1'


