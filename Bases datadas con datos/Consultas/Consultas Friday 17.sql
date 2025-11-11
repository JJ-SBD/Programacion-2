SELECT * FROM entradasalidadinero;

#1 cuanto dinero ha ingresado o egresado cada persona
SELECT idPersonas, sum(montoIE) as total_ingresos_egresos
from entradasalidadinero
group by idPersonas
order by total_ingresos_egresos desc;

#obtener la suma, numero maximo ,minimo, promedio del monto es del dinero por persona usando having para promedios que esten enre 1000 y 2000

#1 lo mismo pero ahora un having
SELECT idPersonas, sum(montoIE) as total_monto
from entradasalidadinero
group by idPersonas having total_monto > 26000
order by total_monto desc;

#1 lo mismo pero ahora mostrar tambien el nombre de la persona asi que hay que juntar 2 tablas



#2 total de pendientes por estatus
SELECT e.estatus.COUNT(p.id) as TotalPendientes
From pendientes p.estatusPendiente e
where p.idEstatusPendiente = e.id
group by e.estatus;

#2 lo mismo pero en una sola columna

#3 cantidad de pendeintes por persona asignada
SELECT p.nombre as Persona_asignada,
COUNT(PD.id) as Cantidad_de_pendientes
From pendientes, PD.personas P
where PD.idPersonas_Asignada = P.id
group by P.nombre
order by count(PD.id) desc;

#4 cuenta cuantas tareas o pendientes tiene cada persona
Select p.nombre as PersonaQueAsigno
from pendientes as pen
join personas as p ON pen.idPersonaQueAsigno
group by p.nombre
order by TotalTareasAsignadas desc;

#contar total de ingresos y egresos existentes. la columna debe llamarse tipo de ingreso y debajo van una fila para cada uno llamadas: egresos, ingresos la sig colum se llama: total

SELECT ie.descripcion AS tipo_movimiento, es.idIngresosEgresos, SUM(es.montoIE) AS total_monto
FROM 
entradasalidadinero es
JOIN 
ingresosegresos ie ON es.idIngresosEgresos = ie.id
GROUP BY 
es.idIngresosEgresos
ORDER BY 
total_monto ASC;
