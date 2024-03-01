-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `SISTEMA_CONSULTAS` DEFAULT CHARACTER SET utf8 ;
USE `SISTEMA_CONSULTAS` ;

-- -----------------------------------------------------
-- Table `SISTEMA_CONSULTAS`.`Expedientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SISTEMA_CONSULTAS`.`Expedientes` (
  `idExpediente` INT NOT NULL AUTO_INCREMENT,
  `numExpediente` VARCHAR(10) NULL,
  `fechaExpediente` DATE NULL,
  `movimientoExpediente` VARCHAR(100) NULL,
  `caratula` VARCHAR(45) NULL,
  `segundaInstancia` VARCHAR(45) NULL,
  PRIMARY KEY (`idExpediente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SISTEMA_CONSULTAS`.`Cuadernillos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SISTEMA_CONSULTAS`.`Cuadernillos` (
  `idCuadernillo` INT NOT NULL AUTO_INCREMENT,
  `tipoCuadernillo` VARCHAR(50) NULL,
  `movimientoCuadernillo` LONGTEXT NULL,
  `fechaCuadernillo` DATE NULL,
  `Expedientes_idExpediente` INT NOT NULL,
  PRIMARY KEY (`idCuadernillo`),
  INDEX `fk_Cuadernillos_Expedientes1_idx` (`Expedientes_idExpediente` ASC) VISIBLE,
  CONSTRAINT `fk_Cuadernillos_Expedientes1`
    FOREIGN KEY (`Expedientes_idExpediente`)
    REFERENCES `SISTEMA_CONSULTAS`.`Expedientes` (`idExpediente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `SISTEMA_CONSULTAS`.`Escritos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SISTEMA_CONSULTAS`.`Escritos` (
  `idEscritos` INT NOT NULL,
  `descripcionEscritos` VARCHAR(45) NULL,
  `tituloEscritos` VARCHAR(45) NULL,
  `Expedientes_idExpediente` INT NOT NULL,
  PRIMARY KEY (`idEscritos`),
  INDEX `fk_Escritos_Expedientes1_idx` (`Expedientes_idExpediente` ASC) VISIBLE,
  CONSTRAINT `fk_Escritos_Expedientes1`
    FOREIGN KEY (`Expedientes_idExpediente`)
    REFERENCES `SISTEMA_CONSULTAS`.`Expedientes` (`idExpediente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SISTEMA_CONSULTAS`.`Juzgados`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SISTEMA_CONSULTAS`.`Juzgados` (
  `idJuzgados` INT NOT NULL,
  `denominacionJuzgado` VARCHAR(100) NULL,
  PRIMARY KEY (`idJuzgados`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SISTEMA_CONSULTAS`.`Expedientes-Juzgados`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SISTEMA_CONSULTAS`.`ExpedientesJuzgados` (
  `idExpedientes-Juzgados` INT NOT NULL AUTO_INCREMENT,
  `DenominacionExpedienteJuzgado` VARCHAR(100) NULL,
  `Expedientes_idExpediente` INT NOT NULL,
  `Juzgados_idJuzgados` INT NOT NULL,
  PRIMARY KEY (`idExpedientes-Juzgados`),
  INDEX `fk_Expedientes-Juzgados_Expedientes1_idx` (`Expedientes_idExpediente` ASC) VISIBLE,
  INDEX `fk_Expedientes-Juzgados_Juzgados1_idx` (`Juzgados_idJuzgados` ASC) VISIBLE,
  CONSTRAINT `fk_Expedientes-Juzgados_Expedientes1`
    FOREIGN KEY (`Expedientes_idExpediente`)
    REFERENCES `SISTEMA_CONSULTAS`.`Expedientes` (`idExpediente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Expedientes-Juzgados_Juzgados1`
    FOREIGN KEY (`Juzgados_idJuzgados`)
    REFERENCES `SISTEMA_CONSULTASexpedientesjuzgados`.`Juzgados` (`idJuzgados`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;