SELECT * FROM bdpendientes.entradasalidadinero;

SELECT fechaES, id, (montoIE * 2)
FROM entradasalidadinero
WHERE fechaES BETWEEN '2018-01-01' AND '2018-01-31'
order by montoIE desc;

SELECT id, montoIE
FROM entradasalidadinero;

SELECT DISTINCT CONCAT (id,' ',montoIE)
FROM entradasalidadinero;

-- Realizar una consulta donde el monto de ingreso y egreso sea menor a 1000
SELECT montoIE
FROM entradasalidadinero
WHERE montoIE < 1000
ORDER BY montoIE asc;

-- Realizar una consulta donde el monto de ingreso y egreso sea entre 1000 y 3000
SELECT montoIE
FROM entradasalidadinero
WHERE montoIE BETWEEN 1000 and 3000
ORDER BY montoIE asc;

-- Realizar una consulta donde el monto de ingreso y egreso sea distinto a 2000
SELECT montoIE
FROM entradasalidadinero
WHERE montoIE <> 2000
ORDER BY montoIE asc;
