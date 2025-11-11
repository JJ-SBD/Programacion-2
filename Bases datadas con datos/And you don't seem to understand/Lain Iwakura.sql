#GRANTS Y REVOKES

CREATE USER 'Lain_Iwakura'@'%' IDENTIFIED BY '1';

DROP USER 'Lain_Iwakura'@'%';

GRANT SELECT ON changarrito.* TO 'Lain_Iwakura'@'%';

GRANT INSERT ON changarrito.* TO 'Lain_Iwakura'@'%';

GRANT UPDATE ON changarrito.* TO 'Lain_Iwakura'@'%';

REVOKE UPDATE ON changarrito.* FROM 'Lain_Iwakura'@'%';

#Garantizar todos los privilegios en una base especifica
GRANT ALL PRIVILEGES ON changarrito.* TO 'Lain_Iwakura'@'%';

#Views

CREATE VIEW Vista_1 AS SELECT * FROM articulos WHERE ciudad like 'Caceres';

select * from Vista_1;

CREATE VIEW Vista_2 AS SELECT * FROM componentes WHERE color like 'rojo';

select * from Vista_2;

CREATE VIEW Vista_3 AS SELECT * FROM envios WHERE cantidad Between 200 and 1000 Order by cantidad asc;

select * from Vista_3;

drop view Vista_3;

#corregir esto porque no funciona
#sintaxis para actualizar vista
UPDATE Vista_3
SET cantidad = 500
WHERE cantidad BETWEEN 500 AND 1000;