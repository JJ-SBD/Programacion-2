Delimiter //
create procedure mostrar_todo_articulos()
Begin
Select * From articulos;
end //

call mostrar_todo_articulos();