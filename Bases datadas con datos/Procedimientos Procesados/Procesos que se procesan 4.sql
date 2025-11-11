Delimiter //
create procedure agregar_articulo_nuevo(IN T CHAR(10), IN tnombre CHAR(20), IN ciudad char(20))
begin
insert into articulos (T, tnombre, ciudad)
values(T, tnombre, ciudad);
end // 
Delimiter ;

call agregar_articulo_nuevo('T8','CONSOLA','MADRID');

#agregar

#crear un proce que elimine un paciente segun su id

#crear un procedimiento que reciba el id y devuleva el valor correspondiente ya lo hicimos

#actualizacion de un registro actualizar el precio de un producto se usa el update insert