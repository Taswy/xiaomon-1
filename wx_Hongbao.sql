-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema hongbao
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema hongbao
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `hongbao` DEFAULT CHARACTER SET utf8 ;
USE `hongbao` ;

-- -----------------------------------------------------
-- Table `hongbao`.`hongbao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hongbao`.`hongbao` (
  `id_hongbao` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `kouling` VARCHAR(45) NOT NULL,
  `stauts` TINYINT(1) NULL DEFAULT '1',
  PRIMARY KEY (`id_hongbao`),
  UNIQUE INDEX `id_hongbao_UNIQUE` (`id_hongbao` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hongbao`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hongbao`.`user` (
  `openid` VARCHAR(50) NOT NULL,
  `user_status` TINYINT(1) NULL DEFAULT '1',
  `hongbao_id_hongbao` INT UNSIGNED ,
  `user_id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  INDEX `fk_user_hongbao_idx` (`hongbao_id_hongbao` ASC),
  PRIMARY KEY (`user_id`),
  CONSTRAINT `fk_user_hongbao`
    FOREIGN KEY (`hongbao_id_hongbao`)
    REFERENCES `hongbao`.`hongbao` (`id_hongbao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
