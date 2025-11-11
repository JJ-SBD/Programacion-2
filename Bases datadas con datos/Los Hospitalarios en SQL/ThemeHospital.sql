create database Hospital;

create table Medicos
(cod_m INT(10) primary key not null unique,
nombre CHAR(20) not null,
apellido_p CHAR (20) not null,
apellido_m CHAR (20) not null,
especialidad CHAR (20) not null,
telefono INT(20));

create table Pacientes
(cod_p INT(10) primary key not null unique,
nombre CHAR(20) not null,
apellido_p CHAR (20) not null,
apellido_m CHAR (20) not null,
poblacion CHAR (20) not null,
provincia CHAR (20) not null,
codigo_postal INT(20) not null,
calle CHAR (20) not null,
numero INT(20) not null,
telefono INT(20),
fecha_nacimiento date not null);

create table Ingresos
(codigo_ingreso INT(10) primary key not null unique,
num_habitacion INT(10) not null,
fecha_ingreso date not null,
cama_asignada INT(10) not null,
cod_m INT(10) not null,
cod_p INT(10) not null);

alter table Ingresos
add constraint PK_paciente foreign key
(cod_p) references Pacientes (cod_p);

alter table Ingresos
add constraint PK_doctor foreign key
(cod_m) references Medicos (cod_m);

#Otra forma de poner las FK pero sin darles apodo
#FOREIGN KEY (cod_m) REFERENCES Medicos(cod_m),
#FOREIGN KEY (cod_p) REFERENCES Pacientes(cod_p));

INSERT INTO Medicos (cod_m, nombre, apellido_p, apellido_m, especialidad, telefono)
VALUES
(1, 'Juan', 'Pérez', 'Gómez', 'Cardiología', 5512345678),
(2, 'María', 'López', 'Ramírez', 'Pediatría', 5598765432),
(3, 'Carlos', 'Sánchez', 'Díaz', 'Neurología', 5522334455),
(4, 'Ana', 'Torres', 'Vega', 'Dermatología', 5533445566),
(5, 'Damesio', 'John', 'Uribe', 'Dermatología', 5533445566);

#Al capturar surge un error de tipo "Out of Range"
#Cambiando tipo de Dato a VARCHAR
ALTER TABLE Medicos MODIFY telefono VARCHAR(20);

INSERT INTO Pacientes (cod_p, nombre, apellido_p, apellido_m, poblacion, provincia, codigo_postal, calle, numero, telefono, fecha_nacimiento)
VALUES
(1, 'Luis', 'García', 'Pérez', 'Madrid', 'Madrid', 28001, 'Calle Mayor', 12, 611223344, '1985-03-15'),
(2, 'Ana', 'López', 'Ramírez', 'Barcelona', 'Barcelona', 08002, 'Calle Balmes', 45, 622334455, '1990-07-22'),
(3, 'Carlos', 'Sánchez', 'Díaz', 'Valencia', 'Valencia', 46003, 'Calle Colón', 78, 633445566, '1978-11-09'),
(4, 'María', 'Torres', 'Vega', 'Sevilla', 'Sevilla', 41004, 'Calle Sierpes', 5, 644556677, '1995-01-30'),
(5, 'Jorge', 'Hernández', 'Gómez', 'Bilbao', 'Vizcaya', 48005, 'Calle Gran Vía', 23, 655667788, '1982-05-18'),
(6, 'Luis', 'García', 'Pérez', 'Madrid', 'Madrid', 28001, 'Calle Mayor', 12, 611223344, '1985-03-15');

INSERT INTO Ingresos (codigo_ingreso, num_habitacion, fecha_ingreso, cama_asignada, cod_m, cod_p)
VALUES
(1, 101, '2025-01-02', 1, 1, 1),
(2, 102, '2025-01-03', 2, 2, 2),
(3, 103, '2025-01-04', 1, 3, 3),
(4, 104, '2025-01-05', 2, 4, 4),
(5, 105, '2025-01-06', 1, 1, 5),
(6, 106, '2025-01-07', 2, 2, 1),
(7, 107, '2025-01-08', 1, 3, 2),
(8, 108, '2025-01-09', 2, 4, 3),
(9, 109, '2025-01-10', 1, 1, 4),
(10, 110, '2025-01-11', 2, 2, 5),
(11, 111, '2025-01-12', 1, 3, 1),
(12, 112, '2025-01-13', 2, 4, 2),
(13, 113, '2025-01-14', 1, 1, 3),
(14, 114, '2025-01-15', 2, 2, 4),
(15, 115, '2025-01-16', 1, 3, 5);

SELECT * FROM medicos;
SELECT * FROM pacientes;
SELECT * FROM ingresos;

#Consultas

#Creamos una VIEW ojo esta madre si se guarda entonces si la quieres borra ponle DROP VIEW

create view Consulta1 as select * from medicos where cod_m <3;
select * from Consulta1;

SELECT * FROM ingresos; #Selecciona todos los registros de la tabla ingresos
SELECT cod_m, fecha_ingreso FROM ingresos; #Selecciona solo estas columnas
SELECT cod_m AS "codigo de ingreso" , fecha_ingreso AS "fecha de ingreso" FROM ingresos; #Cambia los nombres de las columnas
SELECT cod_m AS "codigo" , concat(nombre, ' ', apellido_p, ' ', apellido_m) AS "nombre del medico" FROM medicos #Concatena los datos con espacios, para que se vean los espacios basta con que dentro de las comillas ' ' haya espacio
ORDER BY 2 DESC; #Ordena los datos descendentemente tomando como ejemplo la segunda columna

#Consultas con condiciones AND, OR

SELECT * FROM ingresos WHERE fecha_ingreso = "2025-01-02";
SELECT * FROM ingresos WHERE fecha_ingreso > "2025-01-02";
SELECT * FROM ingresos WHERE fecha_ingreso < "2025-01-02";
SELECT * FROM ingresos WHERE fecha_ingreso > "2025-01-02" AND cod_p = 4;
SELECT * FROM pacientes WHERE nombre = 'Luis' AND poblacion = "Madrid" OR fecha_nacimiento <= "1995-01-30";
SELECT DISTINCT (cod_p) FROM pacientes;

#IN busca registros con caracteristicas especificas

SELECT * FROM ingresos
WHERE cod_m in(1,3,4)
ORDER BY 1 DESC;

#Beetween busca registros dentro de un intervalo

SELECT * FROM ingresos
WHERE fecha_ingreso BETWEEN '2025-01-02' AND '2025-01-10';

#Empezamos a usar like

SELECT * FROM pacientes
WHERE nombre like 'A%'; #Le estoy pidiendo que busque pacientes con nombres que emepiecen con A
SELECT * FROM pacientes
WHERE nombre like '%S'; #Le estoy pidiendo que busque pacientes con nombres que terminen con S
SELECT * FROM pacientes
WHERE poblacion like 'Mad%'; #Le estoy pidiendo que busque pacientes cuya poblacion tenga como primeras letras Mad
SELECT * FROM pacientes
WHERE poblacion like '______'; #Le estoy pidiendo que busque pacientes cuya poblacion tenga 6 letras, un guion bajo por cada letra
SELECT concat(nombre,' ',apellido_p,' ',apellido_m) as 'Nombre Completo' FROM pacientes
WHERE poblacion like '_______'; #Le estoy pidiendo que busque pacientes cuya poblacion tenga 6 letras, un guion bajo por cada letra