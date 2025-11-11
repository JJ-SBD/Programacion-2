create database Changarrito;

create table proveedores
(P CHAR(10) primary key not null unique,
pnombre CHAR(20) not null,
categoria CHAR (20) not null,
ciudad CHAR (20) not null);

create table componentes
(C CHAR(10) primary key not null unique,
cnombre CHAR(20) not null,
color CHAR (20) not null,
peso INT (20) not null,
ciudad CHAR (20) not null);

create table articulos
(T CHAR(10) primary key not null unique,
tnombre CHAR(20) not null,
ciudad CHAR (20) not null);

create table envios
(P CHAR(10) not null,
C CHAR(10) not null,
T CHAR(10) not null,
cantidad INT (20) not null);

alter table envios
add constraint FK_proveedor foreign key
(P) references proveedores (P);

alter table envios
add constraint FK_componentes foreign key
(C) references componentes (C);

alter table envios
add constraint FK_articulos foreign key
(T) references articulos (T);

INSERT INTO Proveedores (P, PNombre, Categoria, Ciudad)
VALUES 
    ('P1', 'CARLOS', 20, 'SEVILLA'),
    ('P2', 'JUAN',   10, 'MADRID'),
    ('P3', 'JOSE',   30, 'SEVILLA'),
    ('P4', 'INMA',   20, 'SEVILLA'),
    ('P5', 'EVA',    30, 'CACERES');

INSERT INTO Componentes (C, CNombre, Color, Peso, Ciudad)
VALUES
    ('C1', 'X3A', 'ROJO', 12, 'SEVILLA'),
    ('C2', 'B85', 'VERDE', 17, 'MADRID'),
    ('C3', 'C4B', 'AZUL', 17, 'MALAGA'),
    ('C4', 'C4B', 'ROJO', 14, 'SEVILLA'),
    ('C5', 'VT8', 'AZUL', 12, 'MADRID'),
    ('C6', 'C30', 'ROJO', 19, 'SEVILLA');

INSERT INTO Articulos (T, TNombre, Ciudad)
VALUES
    ('T1', 'CLASIFICADORA', 'MADRID'),
    ('T2', 'PERFORADORA',   'MALAGA'),
    ('T3', 'LECTORA',       'CACERES'),
    ('T4', 'CONSOLA',       'CACERES'),
    ('T5', 'MEZCLADORA',    'SEVILLA'),
    ('T6', 'TERMINAL',      'BARCELONA'),
    ('T7', 'CINTA',         'SEVILLA');
    
INSERT INTO ENVIOS (P, C, T, CANTIDAD)
VALUES
	('P1','C1','T1',200),
	('P1','C1','T4',700),
	('P2','C3','T1',400),
	('P2','C3','T2',200),
	('P2','C3','T3',200),
	('P2','C3','T4',500),
	('P2','C3','T5',600),
	('P2','C3','T6',400),
	('P2','C3','T7',800),
	('P2','C5','T2',100),
	('P3','C3','T1',200),
	('P3','C4','T2',500),
	('P4','C6','T3',300),
	('P4','C6','T7',300),
	('P5','C2','T2',200),
	('P5','C2','T4',100),
	('P5','C5','T4',500),
	('P5','C5','T7',100),
	('P5','C6','T2',200),
	('P5','C1','T4',100),
	('P5','C3','T4',200),
	('P5','C4','T4',800),
	('P5','C5','T5',400),
	('P5','C6','T4',500);
    
-- 1. Todos los detalles de los artículos de CACERES ♣
SELECT *
FROM articulos
WHERE ciudad = 'CACERES';

-- 2. Valores de P para proveedores que abastecen el artículo T1
SELECT P
FROM envios
WHERE T = 'T1';

-- 3. Lista de pares (COLOR, CIUDAD) eliminando duplicados
SELECT DISTINCT color, ciudad
FROM componentes;

-- 4. Valores de T y CIUDAD donde la ciudad acaba en 'D' o contiene al menos una 'E'
SELECT T, ciudad
FROM articulos
WHERE ciudad LIKE '%D' OR ciudad LIKE '%E%';

-- 5. Valores de P que suministran para el artículo T1 el componente C1
SELECT P
FROM envios
WHERE T = 'T1' AND C = 'C1';

-- 6. TNOMBRE en orden alfabético para artículos abastecidos por P1
SELECT a.tnombre
FROM articulos a, envios e
WHERE a.T = e.T
  AND e.P = 'P1'
ORDER BY a.tnombre;

-- 7. Valores de C para componentes suministrados para cualquier artículo de MADRID
SELECT e.C
FROM envios e, articulos a
WHERE e.T = a.T
  AND a.ciudad = 'MADRID';

-- 8. Valores de C tales que ningún otro componente tiene peso inferior (componentes de peso mínimo)
SELECT C
FROM componentes
WHERE peso = (SELECT MIN(peso) FROM componentes);

-- 9. Valores de P que suministren los artículos T1 y T2 (ambos) — sin EXISTS (self-join)
SELECT e1.P
FROM envios e1, envios e2
WHERE e1.P = e2.P
  AND e1.T = 'T1'
  AND e2.T = 'T2';

-- 10. Valores de P que suministran para un artículo de SEVILLA o MADRID un componente ROJO
SELECT DISTINCT e.P
FROM envios e, componentes c, articulos a
WHERE e.C = c.C
  AND e.T = a.T
  AND c.color = 'ROJO'
  AND (a.ciudad = 'SEVILLA' OR a.ciudad = 'MADRID');

-- 11. Valores de C (mediante subconsultas) para componentes suministrados para algún artículo de SEVILLA por un proveedor de SEVILLA
SELECT C
FROM envios
WHERE T IN (SELECT T FROM articulos WHERE ciudad = 'SEVILLA')
  AND P IN (SELECT P FROM proveedores WHERE ciudad = 'SEVILLA');

-- 12. Valores de T para artículos que usan al menos un componente que se puede obtener con el proveedor P1
SELECT DISTINCT T
FROM envios
WHERE C IN (SELECT C FROM envios WHERE P = 'P1');

-- 13. Número de suministros y cantidad total de artículos suministrados por P2
SELECT COUNT(*) AS numero_suministros, SUM(cantidad) AS total_cantidad
FROM envios
WHERE P = 'P2';

-- 14. Para cada artículo y componente suministrado: C y cantidad total correspondiente
SELECT T, C, SUM(cantidad) AS cantidad_total
FROM envios
GROUP BY T, C;

-- 15. Identificadores de artículos T para los que se ha suministrado algún componente cuyo promedio > 320
SELECT DISTINCT e.T
FROM envios e
WHERE (SELECT AVG(e2.cantidad) FROM envios e2 WHERE e2.C = e.C) > 320;

-- 16. Identificadores de proveedores que hayan realizado algún envío con cantidad mayor que la media de envíos para ese componente
SELECT e.P
FROM envios e
WHERE e.cantidad > (
  SELECT AVG(e2.cantidad) FROM envios e2 WHERE e2.C = e.C
);

-- 17. Identificadores de componentes suministrados para el artículo 'T2' por el proveedor 'P2'
SELECT C
FROM envios
WHERE T = 'T2' AND P = 'P2';

-- 18. Todos los datos de los envíos de componentes cuyo color no sea 'ROJO'
SELECT e.*
FROM envios e, componentes c
WHERE e.C = c.C
  AND c.color <> 'ROJO';

-- 19. Identificadores de componentes que se suministran para los artículos 'T1' y 'T2' (ambos) — sin EXISTS
SELECT e1.C
FROM envios e1, envios e2
WHERE e1.C = e2.C
  AND e1.T = 'T1'
  AND e2.T = 'T2';

-- 20. Identificador de proveedor y número de envíos de componentes de color 'ROJO' por cada proveedor
SELECT e.P, COUNT(*) AS num_envios_rojo
FROM envios e, componentes c
WHERE e.C = c.C
  AND c.color = 'ROJO'
GROUP BY e.P;

-- 21. Colores de componentes suministrados por el proveedor 'P1'
SELECT c.color
FROM componentes c, envios e
WHERE e.C = c.C
  AND e.P = 'P1';

-- 22. Datos de envío y nombre de ciudad donde artículo, proveedor y componente son de la misma ciudad
SELECT e.*, a.ciudad AS ciudad
FROM envios e, articulos a, proveedores p, componentes c
WHERE e.T = a.T
  AND e.P = p.P
  AND e.C = c.C
  AND a.ciudad = p.ciudad
  AND p.ciudad = c.ciudad;

-- 23. Nombres de los componentes que son suministrados en una cantidad total superior a 500 (sin COALESCE)
SELECT c.cnombre
FROM componentes c
WHERE (SELECT SUM(e.cantidad) FROM envios e WHERE e.C = c.C) > 500;

-- 24. Identificadores de proveedores que residan en Sevilla
SELECT P
FROM proveedores
WHERE ciudad = 'SEVILLA';

-- 25. Códigos de proveedor y artículo que suministran al menos dos componentes de color 'ROJO'
SELECT e.P, e.T
FROM envios e
WHERE (
  SELECT COUNT(DISTINCT e2.C)
  FROM envios e2, componentes c2
  WHERE e2.P = e.P
    AND e2.T = e.T
    AND e2.C = c2.C
    AND c2.color = 'ROJO'
) >= 2;
