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

INSERT INTO `CropCultivation` (`id`, `cropType`, `numberOfAcres`, `numberOfCultivators`, `estimatedFertilizer`, `receivedFertilize`) VALUES
(2,	'fooo',	120,	10,	10,	10),
(3,	'noo',	20,	30,	15,	12);

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

INSERT INTO `Event` (`id`, `name`, `venue`, `date`, `organizer`, `numberOfSponsorships`) VALUES
(3,	'foo',	'hoo',	'202/20',	'koo',	20);

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

INSERT INTO `Family` (`id`, `surname`, `numberOfMembers`, `totalIncome`, `religion`, `headOfFamily`) VALUES
(2,	'peee',	10,	1000,	'goo',	'mooo'),
(3,	'uuuu',	2,	33333,	'fffff',	'llllll'),
(4,	'frrrrrrrrr',	233,	3333,	'rtyu',	'nvd'),
(5,	'nooo',	35,	34777,	'ggggg',	'yui');

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

INSERT INTO `Home` (`id`, `number`, `constructionsStatus`, `areaOfTheHouse`, `address`, `electricityAndWaterSupply`) VALUES
(2,	200,	'gggg',	1000,	'hhhh.hhhh.10',	'ffffff');

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

INSERT INTO `Person` (`id`, `name`, `nic`, `gender`, `address`, `employmentStats`) VALUES
(2,	'yyyy',	'vvdvvdvvd',	'fvfvvv',	'vvvvvv',	'SVBVBB');

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

INSERT INTO `Shops` (`id`, `name`, `registrationNumber`, `ownersName`, `address`, `type`) VALUES
(2,	'ggggg',	'2222',	'fffff',	'dvvdvvd',	'ffff');

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

INSERT INTO `Societies` (`id`, `name`, `orientation`, `officeBearer`, `monthlyMembershipFee`, `ageGroup`) VALUES
(2,	'ngngng',	'fbfhh',	'rgrgrg',	3333,	'fbf');

DROP TABLE IF EXISTS `Users`;
CREATE TABLE `Users` (
                         `user_id` int(11) NOT NULL AUTO_INCREMENT,
                         `username` varchar(45) NOT NULL,
                         `password` varchar(45) NOT NULL,
                         `fullname` varchar(45) NOT NULL,
                         `email` varchar(45) NOT NULL,
                         PRIMARY KEY (`user_id`),
                         UNIQUE KEY `Users_username_uindex` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `Users` (`user_id`, `username`, `password`, `fullname`, `email`) VALUES
(12,	'name-1',	'100',	'name one',	''),
(13,	'name-2',	'150',	'name two',	''),
(14,	'name-7',	'50',	'name three',	''),
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

-- 2021-09-13 13:20:36
