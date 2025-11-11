Delimiter //
create procedure buscar_componente(IN CECE CHAR(10))
begin
select * from componentes
where C = CECE;
end // 
Delimiter ;

call buscar_componente('C5');

#buscar 2