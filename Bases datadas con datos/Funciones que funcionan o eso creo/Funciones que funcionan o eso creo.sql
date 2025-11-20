#Funcion para sumar

DELIMITER //

CREATE FUNCTION sumar (una_cosa INT, otra_cosa INT)
returns INT
DETERMINISTIC

BEGIN
return una_cosa + otra_cosa;

END//

DELIMITER //;

SELECT sumar(20 ,30);

DROP FUNCTION sumar;