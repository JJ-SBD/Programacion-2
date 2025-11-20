#Funcion para cambiar nombre a letra minuscula en toda la columna

DELIMITER //

CREATE FUNCTION minusculas (a CHAR(20))
RETURNS CHAR (20)
DETERMINISTIC

BEGIN

RETURN LOWER(a);

END//

DELIMITER //;

SELECT minusculas (tnombre) FROM articulos;

DROP FUNCTION minusculas;