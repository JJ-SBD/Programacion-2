create database BDAlumno;

create table alumno
(Cuenta INT primary key not null,
Paterno VARCHAR(45) not null,
Materno VARCHAR (45) not null,
Nombre VARCHAR (45) not null,
Direccion VARCHAR (45) not null,
Telefono VARCHAR (15),
Licenciatura VARCHAR (45),
Semestre VARCHAR (45));