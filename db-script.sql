-- Adminer 4.8.0 MySQL 5.5.5-10.5.8-MariaDB-1:10.5.8+maria~focal dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

SET NAMES utf8mb4;

DROP TABLE IF EXISTS `BeneficiaryLists`;
CREATE TABLE `BeneficiaryLists` (
                                    `query_id` int(11) NOT NULL AUTO_INCREMENT,
                                    `kind` varchar(45) NOT NULL,
                                    `name` varchar(45) NOT NULL,
                                    `logic` varchar(45) NOT NULL,
                                    PRIMARY KEY (`query_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


DROP TABLE IF EXISTS `CropCultivation`;
CREATE TABLE `CropCultivation` (
                                   `id` int(30) NOT NULL AUTO_INCREMENT,
                                   `cropType` varchar(45) NOT NULL,
                                   `numberOfAcres` int(30) NOT NULL,
                                   `numberOfCultivators` int(30) NOT NULL,
                                   `estimatedFertilizer` int(30) NOT NULL,
                                   `receivedFertilize` int(30) NOT NULL,
                                   PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


DROP TABLE IF EXISTS `Event`;
CREATE TABLE `Event` (
                         `id` int(30) NOT NULL AUTO_INCREMENT,
                         `name` varchar(45) NOT NULL,
                         `venue` varchar(45) NOT NULL,
                         `date` varchar(45) NOT NULL,
                         `organizer` varchar(45) NOT NULL,
                         `numberOfSponsorships` int(30) NOT NULL,
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


DROP TABLE IF EXISTS `Family`;
CREATE TABLE `Family` (
                          `id` int(30) NOT NULL AUTO_INCREMENT,
                          `surname` varchar(45) NOT NULL,
                          `numberOfMembers` int(30) NOT NULL,
                          `totalIncome` int(30) NOT NULL,
                          `religion` varchar(45) NOT NULL,
                          `headOfFamily` varchar(45) NOT NULL,
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


DROP TABLE IF EXISTS `Home`;
CREATE TABLE `Home` (
                        `id` int(30) NOT NULL AUTO_INCREMENT,
                        `number` int(30) NOT NULL,
                        `constructionsStatus` varchar(45) NOT NULL,
                        `areaOfTheHouse` int(30) NOT NULL,
                        `address` varchar(45) NOT NULL,
                        `electricityAndWaterSupply` varchar(45) NOT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


DROP TABLE IF EXISTS `Person`;
CREATE TABLE `Person` (
                          `id` int(30) NOT NULL AUTO_INCREMENT,
                          `name` varchar(45) NOT NULL,
                          `nic` varchar(45) NOT NULL,
                          `gender` varchar(45) NOT NULL,
                          `address` varchar(45) NOT NULL,
                          `employmentStats` varchar(45) NOT NULL,
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


DROP TABLE IF EXISTS `Shops`;
CREATE TABLE `Shops` (
                         `id` int(30) NOT NULL AUTO_INCREMENT,
                         `name` varchar(45) NOT NULL,
                         `registrationNumber` varchar(45) NOT NULL,
                         `ownersName` varchar(45) NOT NULL,
                         `address` varchar(45) NOT NULL,
                         `type` varchar(45) NOT NULL,
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


DROP TABLE IF EXISTS `Societies`;
CREATE TABLE `Societies` (
                             `id` int(30) NOT NULL AUTO_INCREMENT,
                             `name` varchar(45) NOT NULL,
                             `orientation` varchar(45) NOT NULL,
                             `officeBearer` varchar(45) NOT NULL,
                             `monthlyMembershipFee` int(30) NOT NULL,
                             `ageGroup` varchar(45) NOT NULL,
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


DROP TABLE IF EXISTS `Users`;
CREATE TABLE `Users` (
                         `user_id` int(11) NOT NULL AUTO_INCREMENT,
                         `username` varchar(45) NOT NULL,
                         `password` varchar(45) NOT NULL,
                         `fullname` varchar(45) NOT NULL,
                         `email` varchar(45) NOT NULL,
                         PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `Users` (`user_id`, `username`, `password`, `fullname`, `email`) VALUES
(12,	'name-1',	'100',	'name one',	''),
(13,	'name-2',	'150',	'name two',	''),
(14,	'name-2',	'50',	'name three',	''),
(16,	'name-5',	'200',	'name five',	''),
(17,	'name-6',	'180',	'name alpha',	'');

DROP TABLE IF EXISTS `UsersQuery`;
CREATE TABLE `UsersQuery` (
                              `query_id` int(11) NOT NULL AUTO_INCREMENT,
                              `name` varchar(45) NOT NULL,
                              `logic` varchar(45) NOT NULL,
                              PRIMARY KEY (`query_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `UsersQuery` (`query_id`, `name`, `logic`) VALUES
(2,	'Password more 150',	'password > 150'),
(4,	'Pss new',	'password < 150');

-- 2021-07-30 04:40:16
