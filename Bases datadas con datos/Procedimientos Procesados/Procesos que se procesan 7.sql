delimiter //

create procedure actualizar_nombre_articulo_nuevo(IN p_T CHAR(10), IN p_nombre_nuevo CHAR(20), p_ciudad CHAR(20))
begin
update articulos SET tnombre = p_nombre_nuevo
where T = p_T;
end //
delimiter ;

CALL actualizar_nombre_articulo_nuevo('T8', 'REMACHADORA', 'MADRID');

#actualizar