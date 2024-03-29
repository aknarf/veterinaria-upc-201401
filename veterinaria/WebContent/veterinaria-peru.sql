SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `Veterinaria_peru` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;

CREATE TABLE IF NOT EXISTS `Veterinaria_peru`.`Doctores` (
  `DniDoc` VARCHAR(8) NOT NULL,
  `Nombre` VARCHAR(45) NULL DEFAULT NULL,
  `ApePaterno` VARCHAR(45) NULL DEFAULT NULL,
  `ApeMaterno` VARCHAR(45) NULL DEFAULT NULL,
  `Email` VARCHAR(45) NULL DEFAULT NULL,
  `Telefono` VARCHAR(45) NULL DEFAULT NULL,
  `Tipo` VARCHAR(45) NULL DEFAULT NULL,
  `Contrase�a` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`DniDoc`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_swedish_ci;

CREATE TABLE IF NOT EXISTS `Veterinaria_peru`.`Cliente` (
  `Dni` VARCHAR(8) NOT NULL,
  `Nombre` VARCHAR(45) NULL DEFAULT NULL,
  `ApePaterno` VARCHAR(45) NULL DEFAULT NULL,
  `ApeMaterno` VARCHAR(45) NULL DEFAULT NULL,
  `CorreoElectronico` VARCHAR(45) NULL DEFAULT NULL,
  `Direccion` VARCHAR(45) NULL DEFAULT NULL,
  `Foto` BLOB NULL DEFAULT NULL,
  `Celular` VARCHAR(45) NULL DEFAULT NULL,
  `TelefonoFijo` VARCHAR(45) NULL DEFAULT NULL,
  `RUC` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`Dni`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_swedish_ci;

CREATE TABLE IF NOT EXISTS `Veterinaria_peru`.`Mascota` (
  `idMascota` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL DEFAULT NULL,
  `Genero` VARCHAR(45) NULL DEFAULT NULL,
  `TipoSangre` VARCHAR(45) NULL DEFAULT NULL,
  `Esterilizado` VARCHAR(45) NULL DEFAULT NULL,
  `Tama�o` VARCHAR(45) NULL DEFAULT NULL,
  `Actividad` VARCHAR(45) NULL DEFAULT NULL,
  `Peso` INT(11) NULL DEFAULT NULL,
  `FechaNacimiento` DATE NULL DEFAULT NULL,
  `Alergia` VARCHAR(45) NULL DEFAULT NULL,
  `Cliente_Dni` VARCHAR(8) NOT NULL,
  `Raza_idRaza` INT(11) NOT NULL,
  PRIMARY KEY (`idMascota`),
  INDEX `fk_Mascota_Cliente1_idx` (`Cliente_Dni` ASC),
  INDEX `fk_Mascota_Especie1_idx` (`Raza_idRaza` ASC),
  CONSTRAINT `fk_Mascota_Cliente1`
    FOREIGN KEY (`Cliente_Dni`)
    REFERENCES `Veterinaria_peru`.`Cliente` (`Dni`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Mascota_Raza1`
    FOREIGN KEY (`Raza_idRaza`)
    REFERENCES `Veterinaria_peru`.`raza` (`idRaza`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_swedish_ci;

CREATE TABLE IF NOT EXISTS `Veterinaria_peru`.`Especie` (
  `idEspecie` INT(11) NOT NULL AUTO_INCREMENT,
  `nombreEspecie` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idEspecie`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_swedish_ci;

CREATE TABLE IF NOT EXISTS `Veterinaria_peru`.`Raza` (
  `idRaza` INT(11) NOT NULL AUTO_INCREMENT,
  `nombreRaza` VARCHAR(45) NULL DEFAULT NULL,
  `idEspecie` INT(11) NOT NULL,
  PRIMARY KEY (`idRaza`),
  INDEX `fk_Raza_Especie1_idx` (`idEspecie` ASC),
  CONSTRAINT `fk_Raza_Especie1`
    FOREIGN KEY (`idEspecie`)
    REFERENCES `Veterinaria_peru`.`Especie` (`idEspecie`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_swedish_ci;

CREATE TABLE IF NOT EXISTS `Veterinaria_peru`.`Citas` (
  `NroCita` INT(11) NOT NULL AUTO_INCREMENT,
  `Fecha` DATETIME NULL DEFAULT NULL,
  `Estado` VARCHAR(45) NULL DEFAULT NULL,
  `cantidad` VARCHAR(45) NULL DEFAULT NULL,
  `NotasMedicas` VARCHAR(45) NULL DEFAULT NULL,
  `ImagenMedica` VARCHAR(45) NULL DEFAULT NULL,
  `Tipo` VARCHAR(45) NULL DEFAULT NULL,
  `idTarea` INT(11) NOT NULL,
  `idMascota` INT(11) NOT NULL,
  `DniDoc` VARCHAR(8) NOT NULL,
  PRIMARY KEY (`NroCita`),
  INDEX `fk_Citas_Tarea1_idx` (`idTarea` ASC),
  INDEX `fk_Citas_Mascota1_idx` (`idMascota` ASC),
  INDEX `fk_Citas_Doctores1_idx` (`DniDoc` ASC),
  CONSTRAINT `fk_Citas_Tarea1`
    FOREIGN KEY (`idTarea`)
    REFERENCES `Veterinaria_peru`.`Tarea` (`idTarea`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Citas_Mascota1`
    FOREIGN KEY (`idMascota`)
    REFERENCES `Veterinaria_peru`.`Mascota` (`idMascota`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Citas_Doctores1`
    FOREIGN KEY (`DniDoc`)
    REFERENCES `Veterinaria_peru`.`Doctores` (`DniDoc`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_swedish_ci;

CREATE TABLE IF NOT EXISTS `Veterinaria_peru`.`Comprobantes` (
  `NroComprobante` INT(11) NOT NULL AUTO_INCREMENT,
  `Serie` VARCHAR(45) NULL DEFAULT NULL,
  `Correlativo` VARCHAR(45) NULL DEFAULT NULL,
  `Tipo` VARCHAR(45) NULL DEFAULT NULL,
  `direccion` VARCHAR(45) NULL DEFAULT NULL,
  `fechaRegistro` VARCHAR(45) NULL DEFAULT NULL,
  `Citas_NroCita` INT(11) NOT NULL,
  PRIMARY KEY (`NroComprobante`),
  INDEX `fk_Comprobantes_Citas1_idx` (`Citas_NroCita` ASC),
  CONSTRAINT `fk_Comprobantes_Citas1`
    FOREIGN KEY (`Citas_NroCita`)
    REFERENCES `Veterinaria_peru`.`Citas` (`NroCita`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_swedish_ci;

CREATE TABLE IF NOT EXISTS `Veterinaria_peru`.`Tarea` (
  `idTarea` INT(11) NOT NULL AUTO_INCREMENT,
  `DescripcionTarea` VARCHAR(45) NULL DEFAULT NULL,
  `Precio` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idTarea`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_swedish_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;



