-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema changarrito
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema changarrito
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `changarrito` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `changarrito` ;

-- -----------------------------------------------------
-- Table `changarrito`.`articulos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `changarrito`.`articulos` (
  `T` CHAR(10) NOT NULL,
  `tnombre` CHAR(20) NOT NULL,
  `ciudad` CHAR(20) NOT NULL,
  PRIMARY KEY (`T`),
  UNIQUE INDEX `T` (`T` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `changarrito`.`componentes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `changarrito`.`componentes` (
  `C` CHAR(10) NOT NULL,
  `cnombre` CHAR(20) NOT NULL,
  `color` CHAR(20) NOT NULL,
  `peso` INT NOT NULL,
  `ciudad` CHAR(20) NOT NULL,
  PRIMARY KEY (`C`),
  UNIQUE INDEX `C` (`C` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `changarrito`.`proveedores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `changarrito`.`proveedores` (
  `P` CHAR(10) NOT NULL,
  `pnombre` CHAR(20) NOT NULL,
  `categoria` CHAR(20) NOT NULL,
  `ciudad` CHAR(20) NOT NULL,
  PRIMARY KEY (`P`),
  UNIQUE INDEX `P` (`P` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `changarrito`.`envios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `changarrito`.`envios` (
  `P` CHAR(10) NOT NULL,
  `C` CHAR(10) NOT NULL,
  `T` CHAR(10) NOT NULL,
  `cantidad` INT NOT NULL,
  INDEX `FK_proveedor` (`P` ASC) VISIBLE,
  INDEX `FK_componentes` (`C` ASC) VISIBLE,
  INDEX `FK_articulos` (`T` ASC) VISIBLE,
  CONSTRAINT `FK_articulos`
    FOREIGN KEY (`T`)
    REFERENCES `changarrito`.`articulos` (`T`),
  CONSTRAINT `FK_componentes`
    FOREIGN KEY (`C`)
    REFERENCES `changarrito`.`componentes` (`C`),
  CONSTRAINT `FK_proveedor`
    FOREIGN KEY (`P`)
    REFERENCES `changarrito`.`proveedores` (`P`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

USE `changarrito` ;

-- -----------------------------------------------------
-- Placeholder table for view `changarrito`.`vista_1`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `changarrito`.`vista_1` (`T` INT, `tnombre` INT, `ciudad` INT);

-- -----------------------------------------------------
-- Placeholder table for view `changarrito`.`vista_2`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `changarrito`.`vista_2` (`C` INT, `cnombre` INT, `color` INT, `peso` INT, `ciudad` INT);

-- -----------------------------------------------------
-- Placeholder table for view `changarrito`.`vista_3`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `changarrito`.`vista_3` (`P` INT, `C` INT, `T` INT, `cantidad` INT);

-- -----------------------------------------------------
-- procedure actualizar_nombre_articulo
-- -----------------------------------------------------

DELIMITER $$
USE `changarrito`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_nombre_articulo`(IN p_T CHAR(10), IN p_nombre_nuevo CHAR(20))
begin
update articulos SET tnombre = p_nombre_nuevo
where T = p_T;
end$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure actualizar_nombre_articulo_nuevo
-- -----------------------------------------------------

DELIMITER $$
USE `changarrito`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `actualizar_nombre_articulo_nuevo`(IN p_T CHAR(10), IN p_nombre_nuevo CHAR(20), p_ciudad CHAR(20))
begin
update articulos SET tnombre = p_nombre_nuevo
where T = p_T;
end$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure agregar_articulo
-- -----------------------------------------------------

DELIMITER $$
USE `changarrito`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `agregar_articulo`(IN T CHAR(10), IN tnombre CHAR(20), IN ciudad char(20))
begin
insert into articulos (tnombre, ciudad)
values('CONSOLA','MADRID');
end$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure agregar_articulo_2
-- -----------------------------------------------------

DELIMITER $$
USE `changarrito`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `agregar_articulo_2`(IN tnombre CHAR(20), IN ciudad char(20))
begin
insert into articulos (tnombre, ciudad)
values('CONSOLA','MADRID');
end$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure agregar_articulo_nuevo
-- -----------------------------------------------------

DELIMITER $$
USE `changarrito`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `agregar_articulo_nuevo`(IN T CHAR(10), IN tnombre CHAR(20), IN ciudad char(20))
begin
insert into articulos (T, tnombre, ciudad)
values(T, tnombre, ciudad);
end$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure buscar_articulo
-- -----------------------------------------------------

DELIMITER $$
USE `changarrito`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `buscar_articulo`(IN indice CHAR)
begin
select * from articulos
where T = indice;
end$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure buscar_articulo_2
-- -----------------------------------------------------

DELIMITER $$
USE `changarrito`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `buscar_articulo_2`(IN indice CHAR(10))
begin
select * from articulos
where T = indice;
end$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure buscar_componente
-- -----------------------------------------------------

DELIMITER $$
USE `changarrito`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `buscar_componente`(IN CECE CHAR(10))
begin
select * from componentes
where C = CECE;
end$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure consulta_comp_1
-- -----------------------------------------------------

DELIMITER $$
USE `changarrito`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `consulta_comp_1`()
Begin
Select color, peso From componentes
where color = 'rojo' and peso > 12;
end$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure eliminar_articulo
-- -----------------------------------------------------

DELIMITER $$
USE `changarrito`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `eliminar_articulo`( IN p_T CHAR(10), IN p_tnombre CHAR(20), IN p_ciudad CHAR(20))
BEGIN
DELETE FROM articulos
WHERE T = p_T AND tnombre = p_tnombre AND ciudad = p_ciudad;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure mostrar_todo_articulos
-- -----------------------------------------------------

DELIMITER $$
USE `changarrito`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `mostrar_todo_articulos`()
Begin
Select * From articulos;
end$$

DELIMITER ;

-- -----------------------------------------------------
-- View `changarrito`.`vista_1`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `changarrito`.`vista_1`;
USE `changarrito`;
CREATE  OR REPLACE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `changarrito`.`vista_1` AS select `changarrito`.`articulos`.`T` AS `T`,`changarrito`.`articulos`.`tnombre` AS `tnombre`,`changarrito`.`articulos`.`ciudad` AS `ciudad` from `changarrito`.`articulos` where (`changarrito`.`articulos`.`ciudad` like 'Caceres');

-- -----------------------------------------------------
-- View `changarrito`.`vista_2`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `changarrito`.`vista_2`;
USE `changarrito`;
CREATE  OR REPLACE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `changarrito`.`vista_2` AS select `changarrito`.`componentes`.`C` AS `C`,`changarrito`.`componentes`.`cnombre` AS `cnombre`,`changarrito`.`componentes`.`color` AS `color`,`changarrito`.`componentes`.`peso` AS `peso`,`changarrito`.`componentes`.`ciudad` AS `ciudad` from `changarrito`.`componentes` where (`changarrito`.`componentes`.`color` like 'rojo');

-- -----------------------------------------------------
-- View `changarrito`.`vista_3`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `changarrito`.`vista_3`;
USE `changarrito`;
CREATE  OR REPLACE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `changarrito`.`vista_3` AS select `changarrito`.`envios`.`P` AS `P`,`changarrito`.`envios`.`C` AS `C`,`changarrito`.`envios`.`T` AS `T`,`changarrito`.`envios`.`cantidad` AS `cantidad` from `changarrito`.`envios` where (`changarrito`.`envios`.`cantidad` between 200 and 1000) order by `changarrito`.`envios`.`cantidad`;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
