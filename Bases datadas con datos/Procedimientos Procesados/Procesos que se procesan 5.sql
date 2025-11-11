delimiter //

create procedure eliminar_articulo(IN p_T CHAR(10), IN p_tnombre CHAR(20), IN p_ciudad CHAR(20))
begin
delete from articulos
where T = p_T AND tnombre = p_tnombre AND ciudad = p_ciudad;
end //

delimiter ;

call eliminar_articulo('T8', 'CONSOLA', 'MADRID');