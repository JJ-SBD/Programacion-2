-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`department`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`department` (
  `DEPTNO` CHAR(3) NOT NULL,
  `DEPTNAME` VARCHAR(36) NOT NULL,
  `MGRNO` CHAR(6) NULL,
  `ADMRDEPT` CHAR(3) NOT NULL,
  `LOCATION` CHAR(5) NULL,
  PRIMARY KEY (`DEPTNO`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`employee` (
  `EMPNO` CHAR(6) NOT NULL,
  `FIRSTNME` VARCHAR(20) NOT NULL,
  `MIDINIT` CHAR(1) NOT NULL,
  `LASTNAME` VARCHAR(15) NOT NULL,
  `WORKDEPT` CHAR(3) NULL,
  `PHONENO` CHAR(4) NULL,
  `HIREDATE` DATE NULL,
  `JOB` CHAR(8) NULL,
  `EDLEVEL` SMALLINT(6) NULL,
  `SEX` CHAR(1) NULL,
  `BIRTHDATE` DATE NULL,
  `SALARY` DECIMAL(9,2) NULL,
  `BONUS` DECIMAL(9,2) NULL,
  `COMM` DECIMAL(9,2) NULL,
  PRIMARY KEY (`EMPNO`),
  INDEX `FK_DEPTNO-WORKDEPT_idx` (`WORKDEPT` ASC) VISIBLE,
  CONSTRAINT `FK_DEPTNO-WORKDEPT`
    FOREIGN KEY (`WORKDEPT`)
    REFERENCES `mydb`.`department` (`DEPTNO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`project`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`project` (
  `PROJNO` CHAR(6) NOT NULL,
  `PROJNAME` VARCHAR(24) NOT NULL,
  `DEPTNO` CHAR(3) NOT NULL,
  `RESEMP` CHAR(6) NOT NULL,
  `PRSTAFF` DECIMAL(5,2) NULL,
  `PRSTDATE` DATE NULL,
  `PRENDATE` DATE NULL,
  `MAJPROG` CHAR(6) NULL,
  PRIMARY KEY (`PROJNO`),
  INDEX `FK_DEPTNO_idx` (`DEPTNO` ASC) VISIBLE,
  INDEX `FK_RESEMP-EMPNO_idx` (`RESEMP` ASC) VISIBLE,
  CONSTRAINT `FK_DEPTNO`
    FOREIGN KEY (`DEPTNO`)
    REFERENCES `mydb`.`department` (`DEPTNO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_RESEMP-EMPNO`
    FOREIGN KEY (`RESEMP`)
    REFERENCES `mydb`.`employee` (`EMPNO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`emp_act`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`emp_act` (
  `EMPNO` CHAR(6) NOT NULL,
  `PROJNO` CHAR(6) NOT NULL,
  `ACTNO` SMALLINT(6) NOT NULL,
  `EMPTIME` DECIMAL(5,2) NULL,
  `EMSTDATE` DATE NULL,
  `EMENDATE` DATE NULL,
  INDEX `FK_PROJNO_idx` (`PROJNO` ASC) VISIBLE,
  CONSTRAINT `FK_EMPNO`
    FOREIGN KEY (`EMPNO`)
    REFERENCES `mydb`.`employee` (`EMPNO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_PROJNO`
    FOREIGN KEY (`PROJNO`)
    REFERENCES `mydb`.`project` (`PROJNO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
