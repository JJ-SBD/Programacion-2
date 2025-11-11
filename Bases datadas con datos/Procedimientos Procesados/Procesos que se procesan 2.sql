Delimiter //
create procedure buscar_articulo_2(IN indice CHAR(10))
begin
select * from articulos
where T = indice;
end // 
Delimiter ;

call buscar_articulo_2('T3');

#Buscar