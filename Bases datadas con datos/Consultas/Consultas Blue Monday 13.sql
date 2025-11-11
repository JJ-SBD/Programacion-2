#1 registros donde la fecha sea menor al dia de hoy
select * from entradasalidadinero
where fechaES < curdate()
limit 50;

#2 personas cuyos primeros 3 digitos de cel sean 492 o 493
select * from personas
where left(telefono, 3) = 493 or left(telefono, 3) = 492
order by telefono desc;

#3 personas cuyos primeros 3 digitos de cel no sean 492 o 493
select * from personas
where not (left (telefono, 3) = '493' or left (telefono, 3) = '492')
order by telefono desc;

#4 personas cuyos primeros 3 digitos de cel sean 492 o 493 con in
select * from personas
where;

#5 personas cuyos primeros 3 digitos de cel no sean 492 o 493 con in
select * from personas
where;

#6 lista de las personas cuyo tamaño de nombre sea menor a 4 caracteres (todas las condiciones van despues de un where)
select * from personas
where length(nombre) <= 20;

#7 nombres de las personas junto a su correo donde su telefono empiece con 493 y su correo sea hotmail
select nombre, correo, telefono from personas
where left(telefono, 3) = 493 and correo like '%hotmail%';

#8 registros que se encuentren entre el primero enero 2018 al 31 julio 2018 cuyo monto sea mayor a 1500 pesos ordenado por fecha y por monto de manera descendente
select * from entradasalidadinero
where fechaES between '2018-01-01' AND '2018-07-31'
and montoIE > 1500
order by fechaES ,montoIE desc;

#9 todos los telefonos que terminen en 9
select * from personas
where right(telefono, 1) = 9;

#10 todos los telefonos que terminen en 732
select * from personas
where right(telefono, 3) = 732;

#11 correos terminen en mx
select * from personas
where right(correo, 2) = 'mx';

#12 de la tabla entradas y sal dinero todos los montos incluidos sin ser repetidos
select distinct montoIE from entradasalidadinero;

#13 calcular una comision del %5 para todos los montos en la tabla entradas sal dinero, enseñar el id persona, el monto, la comision calculada y el monto contemplando la comision de solo los 50 primeros y su nombre ordenado desc por monto
select montoIE
where () as 'salario anual', ingreso * 2 as 'salario bimestral'
from entradasalidadinero
limit 50;

#14 selecciona todo de la tabla de los dineros ordenando por idPersonas ascendente
select * from entradasalidadinero
order by idPersonas asc;

#15 la persona el tipo de ingreso y egreso y el monto de las personas cuyo id es 1, 4, 10
select * from ingresosegresos 
where idPersonas = idIngresosEgresos
and ;

#15 una mamadota que nadie supo hacer
select ESD.idPersonas, montoIE
from entradassalidasdinicio ESD, ingresosegresos IE
where ESD.idEgresoEgresos = IE.id and ESD.idPersona = PE.id
and ESD.idpersona in (1,4,10)
order by ESD.idPersona;

#15 Muestra el tipo de ingreso o egreso y el monto de las personas con id 1, 4 y 10.
SELECT 
ESD.idPersonas, 
ESD.montoIE, 
TIE.descripcion AS 'Tipo de ingreso/egreso'
FROM entradaSalidaDinero ESD, ingresosEgresos IE, tipoIngEg TIE
WHERE ESD.idIngresosEgresos = IE.id
AND IE.idTipoIngEg = TIE.id
AND ESD.idPersonas IN (1, 4, 10)
ORDER BY ESD.idPersonas;