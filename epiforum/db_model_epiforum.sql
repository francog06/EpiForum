SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `epiforum` DEFAULT CHARACTER SET utf8 ;
USE `epiforum` ;

-- -----------------------------------------------------
-- Table `epiforum`.`account`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `epiforum`.`account` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `created` DATETIME NOT NULL,
  `modified` DATETIME NOT NULL,
  `status` INT(11) NOT NULL DEFAULT '0',
  `type` INT(11) NOT NULL DEFAULT '0',
  `email` VARCHAR(128) NOT NULL,
  `password` VARCHAR(64) NOT NULL,
  `activationCode` VARCHAR(16) NOT NULL,
  `ipAddress` VARCHAR(16) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `epiforum`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `epiforum`.`category` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `created` DATETIME NOT NULL,
  `modified` DATETIME NOT NULL,
  `title` VARCHAR(64) NOT NULL,
  `description` VARCHAR(256) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `epiforum`.`board`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `epiforum`.`board` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `created` DATETIME NOT NULL,
  `modified` DATETIME NOT NULL,
  `categoryId` INT(10) UNSIGNED NOT NULL,
  `title` VARCHAR(64) NOT NULL,
  `description` VARCHAR(256) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_board_categoryId_idx` (`categoryId` ASC),
  CONSTRAINT `fk_board_categoryId`
    FOREIGN KEY (`categoryId`)
    REFERENCES `epiforum`.`category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `epiforum`.`profile`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `epiforum`.`profile` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `created` DATETIME NOT NULL,
  `modified` DATETIME NOT NULL,
  `accountId` INT(10) UNSIGNED NOT NULL,
  `firstname` VARCHAR(64) NULL DEFAULT NULL,
  `lastname` VARCHAR(64) NULL DEFAULT NULL,
  `nickname` VARCHAR(128) NOT NULL,
  `phone` VARCHAR(16) NULL DEFAULT NULL,
  `facebookPage` VARCHAR(64) NULL DEFAULT NULL,
  `twitterPage` VARCHAR(64) NULL DEFAULT NULL,
  `skypeContact` VARCHAR(64) NULL DEFAULT NULL,
  `city` VARCHAR(128) NULL DEFAULT NULL,
  `description` VARCHAR(256) NULL DEFAULT NULL,
  `signature` VARCHAR(256) NULL DEFAULT NULL,
  `gender` BIT(1) NULL DEFAULT NULL,
  `birthdate` DATE NULL DEFAULT NULL,
  `posts` INT(10) UNSIGNED NOT NULL,
  `thanks` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  UNIQUE INDEX `nickname_UNIQUE` (`nickname` ASC),
  INDEX `fk_profile_accountId_idx` (`accountId` ASC),
  CONSTRAINT `fk_profile_accountId`
    FOREIGN KEY (`accountId`)
    REFERENCES `epiforum`.`account` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `epiforum`.`topic`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `epiforum`.`topic` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `created` DATETIME NOT NULL,
  `modified` DATETIME NOT NULL,
  `boardId` INT(10) UNSIGNED NOT NULL,
  `title` VARCHAR(64) NOT NULL,
  `description` VARCHAR(256) NULL DEFAULT NULL,
  `locked` BIT(1) NOT NULL,
  `nbPost` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_topic_boardId_idx` (`boardId` ASC),
  CONSTRAINT `fk_topic_boardId`
    FOREIGN KEY (`boardId`)
    REFERENCES `epiforum`.`board` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `epiforum`.`post`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `epiforum`.`post` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `created` DATETIME NOT NULL,
  `modified` DATETIME NOT NULL,
  `topicId` INT(10) UNSIGNED NOT NULL,
  `profileId` INT(10) UNSIGNED NOT NULL,
  `tag` VARCHAR(64) NULL DEFAULT NULL,
  `deleted` BIT(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC),
  INDEX `fk_post_topicId_idx` (`topicId` ASC),
  INDEX `fk_post_profileId_idx` (`profileId` ASC),
  CONSTRAINT `fk_post_profileId`
    FOREIGN KEY (`profileId`)
    REFERENCES `epiforum`.`profile` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_post_topicId`
    FOREIGN KEY (`topicId`)
    REFERENCES `epiforum`.`topic` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `epiforum`.`contentPost`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `epiforum`.`contentPost` (
  `postId` INT(10) UNSIGNED NOT NULL,
  `content` TEXT NOT NULL,
  PRIMARY KEY (`postId`),
  UNIQUE INDEX `postId_UNIQUE` (`postId` ASC),
  CONSTRAINT `fk_contentPost_postId`
    FOREIGN KEY (`postId`)
    REFERENCES `epiforum`.`post` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `epiforum`.`session`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `epiforum`.`session` (
  `id` VARCHAR(16) NOT NULL,
  `created` DATETIME NOT NULL,
  `modified` DATETIME NOT NULL,
  `profileId` INT(10) UNSIGNED NOT NULL,
  `lastActivity` VARCHAR(64) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_session_profileId_idx` (`profileId` ASC),
  CONSTRAINT `fk_session_profileId`
    FOREIGN KEY (`profileId`)
    REFERENCES `epiforum`.`profile` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
