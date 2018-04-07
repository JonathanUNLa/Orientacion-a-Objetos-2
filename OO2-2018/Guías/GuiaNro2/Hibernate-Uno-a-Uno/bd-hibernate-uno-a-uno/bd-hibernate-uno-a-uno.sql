-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema bd-hibernate-uno-a-uno
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bd-hibernate-uno-a-uno
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bd-hibernate-uno-a-uno` DEFAULT CHARACTER SET utf8 ;
USE `bd-hibernate-uno-a-uno` ;

-- -----------------------------------------------------
-- Table `bd-hibernate-uno-a-uno`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-hibernate-uno-a-uno`.`cliente` (
  `idCliente` INT(11) NOT NULL AUTO_INCREMENT,
  `apellido` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `dni` INT(8) NOT NULL,
  `fechaDeNacimiento` DATE NULL DEFAULT NULL,
  `baja` BIT NULL DEFAULT b'0',
  PRIMARY KEY (`idCliente`),
  UNIQUE INDEX `idCliente_UNIQUE` (`idCliente` ASC),
  UNIQUE INDEX `dni_UNIQUE` (`dni` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `bd-hibernate-uno-a-uno`.`contacto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd-hibernate-uno-a-uno`.`contacto` (
  `idContacto` INT(11) NOT NULL,
  `email` VARCHAR(45) NULL,
  `movil` VARCHAR(45) NULL,
  `fijo` VARCHAR(45) NULL,
  PRIMARY KEY (`idContacto`),
  UNIQUE INDEX `idContacto_UNIQUE` (`idContacto` ASC),
  CONSTRAINT `fk_contacto_cliente`
    FOREIGN KEY (`idContacto`)
    REFERENCES `bd-hibernate-uno-a-uno`.`cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
