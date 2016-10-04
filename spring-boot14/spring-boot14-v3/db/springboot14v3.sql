-- MySQL Script generated by MySQL Workbench
-- Tue Oct  4 14:45:12 2016
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema springboot14v3
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `springboot14v3` ;

-- -----------------------------------------------------
-- Schema springboot14v3
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `springboot14v3` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin ;
USE `springboot14v3` ;

-- -----------------------------------------------------
-- Table `springboot14v3`.`foo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `springboot14v3`.`foo` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `create_utc` BIGINT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
