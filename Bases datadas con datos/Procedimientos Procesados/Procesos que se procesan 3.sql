Delimiter //
create procedure consulta_comp_1()
Begin
Select color, peso From componentes
where color = 'rojo' and peso > 12;
end //
Delimiter //

call consulta_comp_1();

#mi consulta 2