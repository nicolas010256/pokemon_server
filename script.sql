-- CREATE DATABASE --
CREATE DATABASE IF NOT EXISTS `POKEMON_APP`;
-- DROP DATABASE `POKEMON_APP`;

USE `POKEMON_APP`;

-- CREATE TABLES --
CREATE TABLE IF NOT EXISTS `POKEMON` (
    `ID` INT NOT NULL,
    `POKEDEX_ID` INT,
    `NAME` VARCHAR(30) NOT NULL,
    `IS_DEFAULT` BOOLEAN,
    `HP` INT(3),
    `ATK` INT(3),
    `DEF` INT(3),
    `SP_ATK` INT(3),
    `SP_DEF` INT(3),
    `SPEED` INT(3),
    `SPRITE` VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS `TYPE` (
    `ID` INT NOT NULL,
    `NAME` VARCHAR(8) NOT NULL
);

CREATE TABLE IF NOT EXISTS `POKEMON_TYPE` (
    `POKEMON_ID` INT NOT NULL,
    `TYPE_ID` INT NOT NULL
);

CREATE TABLE IF NOT EXISTS `ABILITY` (
	`ID` INT NOT NULL,
    `NAME` VARCHAR(30),
    `DESCRIPTION` VARCHAR(200)
);

CREATE TABLE IF NOT EXISTS `POKEMON_ABILITY` (
	`POKEMON_ID` INT NOT NULL,
    `ABILITY_ID` INT NOT NULL
);

CREATE TABLE IF NOT EXISTS `MOVE` (
	`ID` INT NOT NULL,
    `NAME` VARCHAR(50),
    `DESCRIPTION` VARCHAR(200),
    `POWER` INT(3),
    `ACCURACY` INT(3),
    `PP` INT(2),
    `DAMAGE_CATEGORY` VARCHAR(10),
    `TYPE_ID` INT
);


CREATE TABLE IF NOT EXISTS `POKEMON_MOVE` (
	`POKEMON_ID` INT NOT NULL,
    `MOVE_ID` INT NOT NULL
);

CREATE TABLE IF NOT EXISTS `ITEM` (
    `ID` INT NOT NULL,
    `NAME` VARCHAR(50),
    `DESCRIPTION` VARCHAR(250),
    `SPRITE` VARCHAR(200)
);

CREATE TABLE IF NOT EXISTS `NATURE` (
	`ID` INT NOT NULL,
    `NAME` VARCHAR(20),
    `DESCRIPTION` VARCHAR(50)
);

-- DROP TABLE `USER`;

CREATE TABLE IF NOT EXISTS `USER` (
	`USERNAME` VARCHAR(12) NOT NULL,
    `PASSWORD` VARCHAR(60) NOT NULL,
    `EMAIL` VARCHAR(30) NOT NULL UNIQUE,
    `ENABLED` BOOLEAN NOT NULL
);

CREATE TABLE IF NOT EXISTS `TEAM` (
	`ID` INT NOT NULL,
	`USERNAME` VARCHAR(12) NOT NULL,
    `NAME` VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS `POKEMON_TEAM` (
	`ID` INT NOT NULL,
    `TEAM_ID` INT NOT NULL,
    `USERNAME` VARCHAR(12) NOT NULL,
    `POKEMON_ID` INT NOT NULL,
    `NICKNAME` VARCHAR(60),
    `ABILITY_ID` INT NOT NULL,
    `ITEM_ID` INT,
    `HP_IV` INT(2),
    `ATK_IV` INT(2),
    `DEF_IV` INT(2),
    `SP_ATK_IV` INT(2),
    `SP_DEV_IV` INT(2),
    `SPEED_IV` INT(2),
    `HP_EV` INT(3),
    `ATK_EV` INT(3),
    `DEF_EV` INT(3),
    `SP_ATK_EV` INT(3),
    `SP_DEV_EV` INT(3),
    `SPEED_EV` INT(3)
);

CREATE TABLE IF NOT EXISTS `POKEMON_TEAM_MOVE` (
    `POKEMON_TEAM_ID` INT NOT NULL,
    `TEAM_ID` INT NOT NULL,
    `USERNAME` VARCHAR(12) NOT NULL,
    `MOVE_ID` INT NOT NULL
);

-- PRIMRAY KEY --
ALTER TABLE `POKEMON` ADD CONSTRAINT `PK_POKEMON` PRIMARY KEY (`ID`);
ALTER TABLE `TYPE` ADD CONSTRAINT `PK_TYPE` PRIMARY KEY (`ID`);
ALTER TABLE `POKEMON_TYPE` ADD CONSTRAINT `PK_POKEMON_TYPE` PRIMARY KEY (`POKEMON_ID`, `TYPE_ID`);
ALTER TABLE `ABILITY` ADD CONSTRAINT `PK_ABILITY` PRIMARY KEY (`ID`);
ALTER TABLE `POKEMON_ABILITY` ADD CONSTRAINT `PK_POKEMON_ABILITY` PRIMARY KEY (`POKEMON_ID`, `ABILITY_ID`);
ALTER TABLE `MOVE` ADD CONSTRAINT `PK_MOVE` PRIMARY KEY (`ID`);
ALTER TABLE `POKEMON_MOVE` ADD CONSTRAINT `PK_POKEMON_MOVE` PRIMARY KEY (`POKEMON_ID`, `MOVE_ID`);
ALTER TABLE `USER` ADD CONSTRAINT `PK_USER` PRIMARY KEY (`USERNAME`);
ALTER TABLE `ITEM` ADD CONSTRAINT `PK_ITEM` PRIMARY KEY (`ID`);
ALTER TABLE `TEAM` ADD CONSTRAINT `PK_TEAM` PRIMARY KEY (`ID`, `USERNAME`);
ALTER TABLE `POKEMON_TEAM` ADD CONSTRAINT `PK_POKEMON_TEAM` PRIMARY KEY (`ID`, `TEAM_ID`, `USERNAME`);
ALTER TABLE `POKEMON_TEAM_MOVE` ADD CONSTRAINT `PK_POKEMON_TEAM_MOVE` PRIMARY KEY (`POKEMON_TEAM_ID`, `TEAM_ID`, `USERNAME`, `MOVE_ID`);
ALTER TABLE `NATURE` ADD CONSTRAINT `PK_NATURE` PRIMARY KEY (`ID`);

-- FOREIGN KEY --
ALTER TABLE `POKEMON_TYPE` ADD CONSTRAINT `FK_POKEMON_TYPE_POKEMON` FOREIGN KEY (`POKEMON_ID`) REFERENCES `POKEMON`(`ID`);
ALTER TABLE `POKEMON_TYPE` ADD CONSTRAINT `FK_POKEMON_TYPE_TYPE` FOREIGN KEY (`TYPE_ID`) REFERENCES `TYPE`(`ID`);
ALTER TABLE `POKEMON_ABILITY` ADD CONSTRAINT `FK_POKEMON_ABILITY_POKEMON` FOREIGN KEY (`POKEMON_ID`) REFERENCES `POKEMON`(`ID`);
ALTER TABLE `MOVE` ADD CONSTRAINT `FK_MOVE_TYPE` FOREIGN KEY (`TYPE_ID`) REFERENCES `TYPE`(`ID`);
ALTER TABLE `POKEMON_MOVE` ADD CONSTRAINT `FK_POKEMON_MOVE_POKEMON` FOREIGN KEY (`POKEMON_ID`) REFERENCES `POKEMON`(`ID`);
ALTER TABLE `POKEMON_MOVE` ADD CONSTRAINT `FK_POKEMON_MOVE_MOVE` FOREIGN KEY (`MOVE_ID`) REFERENCES `MOVE`(`ID`);
ALTER TABLE `TEAM` ADD CONSTRAINT `FK_TEAM_USER` FOREIGN KEY (`USERNAME`) REFERENCES `USER`(`USERNAME`);
ALTER TABLE `POKEMON_TEAM` ADD CONSTRAINT `FK_POKEMON_TEAM_TEAM` FOREIGN KEY (`TEAM_ID`, `USERNAME`) REFERENCES `TEAM`(`ID`, `USERNAME`);
ALTER TABLE `POKEMON_TEAM` ADD CONSTRAINT `FK_POKEMON_TEAM_POKEMON` FOREIGN KEY (`POKEMON_ID`) REFERENCES `POKEMON`(`ID`);
ALTER TABLE `POKEMON_TEAM` ADD CONSTRAINT `FK_POKEMON_TEAM_ABILITY` FOREIGN KEY (`ABILITY_ID`) REFERENCES `ABILITY`(`ID`);
ALTER TABLE `POKEMON_TEAM` ADD CONSTRAINT `FK_POKEMON_TEAM_ITEM` FOREIGN KEY (`ITEM_ID`) REFERENCES `ITEM`(`ID`);
ALTER TABLE `POKEMON_TEAM_MOVE` ADD CONSTRAINT `FK_POKEMON_TEAM_MOVE_POKEMON_TEAM` FOREIGN KEY (`POKEMON_TEAM_ID`, `TEAM_ID`, `USERNAME`) REFERENCES `POKEMON_TEAM`(`ID`, `TEAM_ID`, `USERNAME`);
ALTER TABLE `POKEMON_TEAM_MOVE` ADD CONSTRAINT `FK_POKEMON_TEAM_MOVE_MOVE` FOREIGN KEY (`MOVE_ID`) REFERENCES `MOVE`(`ID`);

-- select * from `pokemon`;
-- select * from `type`;
-- select * from `pokemon_type`;
-- select * from `user`;


-- delete from `pokemon_type`;
-- delete from `type`;
-- delete from `pokemon`;

-- set global time_zone = '-3:00';

-- SELECT * FROM `POKEMON` WHERE `NAME` LIKE '%Lycanroc%';