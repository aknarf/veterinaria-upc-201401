SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `Veterinaria_peru` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;

CREATE TABLE IF NOT EXISTS `Veterinaria_peru`.`Doctores` (
  `DniDoc` INT(11) NOT NULL,
  `Nombre` VARCHAR(45) NULL DEFAULT NULL,
  `ApePaterno` VARCHAR(45) NULL DEFAULT NULL,
  `ApeMaterno` VARCHAR(45) NULL DEFAULT NULL,
  `Email` VARCHAR(45) NULL DEFAULT NULL,
  `Telefono` VARCHAR(45) NULL DEFAULT NULL,
  `Tipo` VARCHAR(45) NULL DEFAULT NULL,
  `Contraseña` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`DniDoc`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_swedish_ci;

CREATE TABLE IF NOT EXISTS `Veterinaria_peru`.`Cliente` (
  `Dni` INT(11) NOT NULL,
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
  `Tamaño` VARCHAR(45) NULL DEFAULT NULL,
  `Actividad` VARCHAR(45) NULL DEFAULT NULL,
  `Peso` INT(11) NULL DEFAULT NULL,
  `FechaNacimiento` DATETIME NULL DEFAULT NULL,
  `Alergia` VARCHAR(45) NULL DEFAULT NULL,
  `Cliente_Dni` INT(11) NOT NULL,
  `Especie_idEspecie` INT(11) NOT NULL,
  PRIMARY KEY (`idMascota`),
  INDEX `fk_Mascota_Cliente1_idx` (`Cliente_Dni` ASC),
  INDEX `fk_Mascota_Especie1_idx` (`Especie_idEspecie` ASC),
  CONSTRAINT `fk_Mascota_Cliente1`
    FOREIGN KEY (`Cliente_Dni`)
    REFERENCES `Veterinaria_peru`.`Cliente` (`Dni`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Mascota_Especie1`
    FOREIGN KEY (`Especie_idEspecie`)
    REFERENCES `Veterinaria_peru`.`Especie` (`idEspecie`)
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
  `DniDoc` INT(11) NOT NULL,
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
  `Correlativo` VARCHAR(45) NULL DEFAULT NULL,
  `direccion` VARCHAR(45) NULL DEFAULT NULL,
  `fechaRegistro` VARCHAR(45) NULL DEFAULT NULL,
  `Tipo` VARCHAR(45) NULL DEFAULT NULL,
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



insert into especie values (1,'PERRO');
insert into especie values (2,'GATO');
insert into especie values (3,'LORO') ;

insert into raza values (11,'Affenpinscher',1);
insert into raza values (12,'Airedale terrier',1);
insert into raza values (13,'Akita Inu',1);
insert into raza values (14,'Akita Americano',1);
insert into raza values (15,'Alano español',1);
insert into raza values (16,'Alaskan malamute',1);
insert into raza values (17,'American Hairless terrier',1);
insert into raza values (18,'American Staffordshire Terrier',1);
insert into raza values (19,'Antiguo Perro Pastor Inglés',1);
insert into raza values (20,'Bardino (Perro majorero)',1);
insert into raza values (21,'Basenji',1);
insert into raza values (22,'Basset hound',1);
insert into raza values (23,'Beagle',1);
insert into raza values (24,'Beauceron',1);
insert into raza values (25,'Bichon frisé',1);
insert into raza values (26,'Bichón maltés',1);
insert into raza values (27,'Bloodhound',1);
insert into raza values (28,'Border collie',1);
insert into raza values (29,'Borzoi',1);
insert into raza values (30,'Boston terrier',1);
insert into raza values (31,'Bóxer',1);
insert into raza values (32,'Braco alemán de pelo corto',1);
insert into raza values (33,'Braco alemán de pelo duro',1);
insert into raza values (34,'Braco de Auvernia',1);
insert into raza values (35,'Braco francés',1);
insert into raza values (36,'Braco húngaro',1);
insert into raza values (37,'Braco italiano',1);
insert into raza values (38,'Braco tirolés',1);
insert into raza values (39,'Braco de Saint Germain',1);
insert into raza values (40,'Braco de Weimar',1);
insert into raza values (41,'Bull Terrier',1);
insert into raza values (42,'Bulldog americano',1);
insert into raza values (43,'Bulldog francés',1);
insert into raza values (44,'Bulldog inglés',1);
insert into raza values (45,'Bullmastiff',1);
insert into raza values (46,'Can de palleiro',1);
insert into raza values (47,'Caniche',1);
insert into raza values (48,'Abisinio ',2);
insert into raza values (49,'American shorthair',2);
insert into raza values (50,'American wirehair',2);
insert into raza values (51,'Angora turco',2);
insert into raza values (52,'Azul ruso',2);
insert into raza values (53,'Gato balinés',2);
insert into raza values (54,'Bengala ',2);
insert into raza values (55,'Burmés',2);
insert into raza values (56,'Bobtail japonés',2);
insert into raza values (57,'Bombay ',2);
insert into raza values (58,'Bosque de Noruega',2);
insert into raza values (59,'British Shorthair',2);
insert into raza values (60,'Burmilla',2);
insert into raza values (61,'California Spangled',2);
insert into raza values (62,'Chantilly-Tiffany',2);
insert into raza values (63,'Chartreux',2);
insert into raza values (64,'Gato color point',2);
insert into raza values (65,'Cornish rex',2);
insert into raza values (66,'Guacamayo militar',3);
insert into raza values (67,'Guacamayo jacinto',3);
insert into raza values (68,'Guacamayo rojo ',3);
insert into raza values (69,'Guacamayo rojo de alas verdes',3);
insert into raza values (70,'Guacamayo azul y amarillo ',3);

insert into doctores values (43564198,'Carmen','Rios','Samaniego','askur@gmail.com','3356643','ADMINISTRADOR','564$65');
insert into doctores values (43564197,'Esteban','Sandro','Casas','esandro@gmail.com','3355343','ADMINISTRADOR','564$65');
insert into doctores values (43567718,'Grecia','Samaniego','Ojeda','gSamaniego@hotmail.com','3345643','ADMINISTRADOR','564$65');
insert into doctores values (43364198,'Javier','Casas','Peña','Jcasas@gmail.com','3356643','DOCTOR','564$65');
insert into doctores values (43564772,'Juan','Rios','Samaniego','jrios@gmail.com','3356643','DOCTOR','564$65');
insert into doctores values (43564643,'Jose','Alvarez','Olguin','jAlvarez@gmail.com','3356643','DOCTOR','564$65');
insert into doctores values (43654198,'Maria','Flores','cervantes','mflores@gmail.com','3356643','DOCTOR','564$65');
insert into doctores values (43565698,'Esteban','Palomino','llaury','epalomino@gmail.com','3356643','DOCTOR','564$65');
insert into doctores values (43568698,'Roberto','Ku','Cortes','Rku@gmail.com','3356643','DOCTOR','564$65');
insert into doctores values (43579198,'Lorena','cabanillas','Rios','askur@gmail.com','3356643','DOCTOR','564$65');
insert into doctores values (43532198,'Viviana','castillo','sandoval','vcastillo@gmail.com','3356643','DOCTOR','564$65');

insert into cliente values (44544398,'Carmen','Palomo','Casas','cpalomo@gmail.com','av las flores 254 - SJL','F','945168883','3356672','0');
insert into cliente values (44565398,'Sandra','Rivera','Mejia','srivera@gmail.com','av los sauces 365 -SMP','F','945168883','3356672','0');
insert into cliente values (44544798,'Ronald','Caceres','Arcaya','rcaceres@hotmail.com','av Brasil 365- BREÑA','F','945168883','3356672','0');
insert into cliente values (44994398,'ridee','sanchez','saldaña','rsanchez@gmail.com','av izaguirre 765 -los olivos','F','945168883','3356672','0');
insert into cliente values (44543598,'Jhoan','saldaña','ruiz','jsaldaña@gmail.com','av larco 62- miraflores','F','945168883','3356672','0');
insert into cliente values (44546598,'Jesus','candela',' pareja','jcandela@gmail.com','av alfredo mendiola -los olivos','F','945168883','3356672','0');
insert into cliente values (43844398,'Miguel','Carpio','Fernandes','mcarpio@gmail.com','av iquitos 652 - la victoria','F','945168883','3356672','0');
insert into cliente values (44474398,'susan','montero','calderon','smontero@gmail.com','av alcazar 65- Rimac','F','945168883','3356672','0');
insert into cliente values (44514798,'karla ','Chicata','cabanillas','kchicata@gmail.com','av marte- los olivos','F','945168883','3356672','0');
insert into cliente values (44694398,'Maria Ines ','Fernandes','Rios','mFernandes@gmail.com','av los casas 546- comas','F','945168883','3356672','0');
insert into cliente values (44541798,'Bruno','Espinoza','sandoval','bespinoza@gmail.com','av emancipacion 69 -surco','F','945168883','3356672','0');



