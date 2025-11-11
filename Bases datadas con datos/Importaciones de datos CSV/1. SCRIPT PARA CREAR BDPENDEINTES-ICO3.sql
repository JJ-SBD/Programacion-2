CREATE database IF NOT EXISTS bdPendientes;
USE bdPendientes;

-- Table personas
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS personas (
  id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(60) NOT NULL,
  correo VARCHAR(30) NULL,
  telefono VARCHAR(30) NULL,
  PRIMARY KEY (id))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table estatusPendiente
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS estatusPendiente (
  id INT NOT NULL AUTO_INCREMENT,
  estatus VARCHAR(20) NOT NULL,
  PRIMARY KEY (id))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table usuarios
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS usuarios (
  id INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(30) NOT NULL,
  password VARCHAR(45) NOT NULL,
  idPersonas INT NOT NULL,
  PRIMARY KEY (id),
  INDEX fkUsuariosPersonas_idx (idPersonas ASC),
  CONSTRAINT fkUsuariosPersonas
    FOREIGN KEY (idPersonas)
    REFERENCES personas (id))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table tipoIngEg
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS tipoIngEg (
  id INT NOT NULL AUTO_INCREMENT,
  descripcion VARCHAR(30) NOT NULL,
  PRIMARY KEY (id))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table grupoIngEg
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS grupoIngEg (
  id INT NOT NULL AUTO_INCREMENT,
  descripcion VARCHAR(30) NOT NULL,
  observaciones VARCHAR(50) NULL,
  PRIMARY KEY (id))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table ingresosEgresos
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS ingresosEgresos (
  id INT NOT NULL AUTO_INCREMENT,
  descripcion VARCHAR(30) NOT NULL,
  idTipoIngEg INT NOT NULL,
  idGrupoIngEg INT NOT NULL,
  observaciones VARCHAR(50) NULL,
  INDEX fkIngresosEgresosTipoIngEg_idx (idTipoIngEg ASC) ,
  INDEX fkIngresosEgresosGrupoIngEg_idx (idGrupoIngEg ASC) ,
  PRIMARY KEY (id),
  CONSTRAINT fkIngresosEgresosTipoIngEg
    FOREIGN KEY (idTipoIngEg)
    REFERENCES tipoIngEg (id),
  CONSTRAINT fkIngresosEgresosGrupoIngEg
    FOREIGN KEY (idGrupoIngEg)
    REFERENCES grupoIngEg (id))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `entradaSalidaDinero`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS entradaSalidaDinero (
  id INT NOT NULL AUTO_INCREMENT,
  fechaES DATETIME NOT NULL,
  idIngresosEgresos INT NOT NULL,
  montoIE DECIMAL(6,2) NOT NULL,
  idPersonas INT NOT NULL,
  observaciones VARCHAR(250) NULL,
  PRIMARY KEY (id),
  INDEX fkEntradaSalidaDineroIngresosEgresos_idx (idIngresosEgresos ASC) ,
  INDEX fkEntradaSalidaDineroPersonas_idx (idPersonas ASC) ,
  CONSTRAINT fkEntradaSalidaDineroIngresosEgresos
    FOREIGN KEY (idIngresosEgresos)
    REFERENCES ingresosEgresos (id),
  CONSTRAINT fkEntradaSalidaDineroPersonas
    FOREIGN KEY (idPersonas)
    REFERENCES personas (id))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pendientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS pendientes (
  id INT NOT NULL AUTO_INCREMENT,
  fechaCreacion DATETIME NOT NULL,
  fechaEntrega DATETIME NOT NULL,
  descripcion VARCHAR(250) NOT NULL,
  idEstatusPendiente INT NOT NULL,
  observaciones VARCHAR(250) NULL,
  idPersonaQueAsigno INT NOT NULL,
  idPersonaAsignado INT NOT NULL,
  solucionPendiente VARCHAR(250) NULL,
  PRIMARY KEY (id),
  CONSTRAINT fkPendientesEstatusPendiente
    FOREIGN KEY (idEstatusPendiente)
    REFERENCES bdPendientes.estatusPendiente (id),
  CONSTRAINT fkPendientesPersonaQueAsigno
    FOREIGN KEY (idPersonaQueAsigno)
    REFERENCES bdPendientes.personas (id),
  CONSTRAINT fkPendientesPersonaAsignado
    FOREIGN KEY (idPersonaAsignado)
    REFERENCES bdPendientes.personas (id))
ENGINE = InnoDB;


