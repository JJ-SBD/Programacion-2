DELIMITER //

CREATE FUNCTION contar_registros (letra VARCHAR(20))
RETURNS INT
DETERMINISTIC

BEGIN
DECLARE numero INT;
SELECT COUNT(*) INTO numero FROM articulos WHERE tnombre like CONCAT('%',letra,'%');
Return numero;

END//

DELIMITER ;

SELECT contar_registros('A');

DROP FUNCTION contar_registros;