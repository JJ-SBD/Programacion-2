# Obtener el nombre de un artículo según su clave T

DELIMITER //

CREATE FUNCTION obtener_nombre_articulo(p_T CHAR(10))
RETURNS CHAR(20)
DETERMINISTIC
BEGIN
DECLARE nombre CHAR(20);

SELECT tnombre INTO nombre
FROM articulos
WHERE T = p_T;

RETURN nombre;
END//

DELIMITER ;

SELECT obtener_nombre_articulo('T1');


# Verificar si un articulo existe

DELIMITER //

CREATE FUNCTION existe_articulo(p_T CHAR(10))
RETURNS TINYINT
DETERMINISTIC
BEGIN
DECLARE cantidad INT;

SELECT COUNT(*) INTO cantidad
FROM articulos
WHERE T = p_T;

RETURN (cantidad > 0);
END//

DELIMITER ;

SELECT existe_articulo('T5');


# Obtener la ciudad de un artículo

DELIMITER //

CREATE FUNCTION obtener_ciudad_articulo(p_T CHAR(10))
RETURNS CHAR(20)
DETERMINISTIC
BEGIN

DECLARE ciudad_res CHAR(20);

SELECT ciudad INTO ciudad_res
FROM articulos
WHERE T = p_T;

RETURN ciudad_res;
END//

DELIMITER ;

SELECT obtener_ciudad_articulo('T2');