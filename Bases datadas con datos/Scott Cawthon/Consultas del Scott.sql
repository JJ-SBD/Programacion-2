#1
SELECT dep.nombre AS 'nombre del departamento', reg.nombre AS 'nombre de la region'
FROM s_dept dep, s_region reg
WHERE dep.region_id = reg.id
ORDER BY reg.nombre;
#2
SELECT e.nombre AS 'nombre de empleado', e.dept_id AS 'id de departamento',
d.nombre AS 'nombre de departamento'
FROM s_empl e, s_dept d
WHERE e.dept_id = d.id;
#3
SELECT e.nombre AS 'nombre de empleado', d.nombre AS 'nombre de departamento',
r.nombre AS 'nombre de region'
FROM s_empl e, s_dept d, s_region r
WHERE e.dept_id = d.id AND d.region_id = r.id;
#4
SELECT e.nombre AS 'nombre de empleado', e.dept_id AS 'id de departamento',
d.nombre AS 'nombre de departamento'
FROM s_empl e, s_dept d
WHERE e.dept_id = d.id AND d.id > 20 AND d.id < 50;
#5
SELECT c.nombre AS 'nombre de cliente', r.nombre AS 'nombre de region'
FROM s_customer c, s_region r
WHERE c.region_id = r.id
ORDER BY r.nombre ASC;
#6
SELECT d.id AS 'id de departamento', d.nombre AS 'nombre de departamento',
SUM(e.salary) AS 'suma de salarios'
FROM s_empl e, s_dept d
WHERE e.dept_id = d.id
GROUP BY d.id, d.nombre;
#7
SELECT r.id AS 'id de region', r.nombre AS 'nombre de region', SUM(e.salary) AS 'suma de salarios'
FROM s_empl e, s_dept d, s_region r
WHERE e.dept_id = d.id AND d.region_id = r.id
GROUP BY r.id, r.nombre;
#8
SELECT d.id AS 'id de departamento', d.nombre AS 'nombre de departamento',
SUM(e.salary) AS 'suma de salarios', MAX(e.salary) AS 'salario maximo',
MIN(e.salary) AS salario_minimo, AVG(e.salary) AS salario_promedio
FROM s_empl e, s_dept d
WHERE e.dept_id = d.id
GROUP BY d.id, d.nombre;
#9
SELECT c.nombre AS 'nombre de cliente'
FROM s_customer c, s_region r
WHERE c.region_id = r.id AND r.nombre LIKE '%EUROPE%';
#10
SELECT e.nombre AS 'nombre de empleado', e.id AS 'id de empleado'
FROM s_customer c, s_empl e
WHERE c.emp_id = e.id AND c.nombre LIKE '%sportique%';







-- 1. Seleccionar las regiones que comiencen con la letra N.
SELECT nombre AS 'Nombre de región'
FROM s_region
WHERE nombre LIKE 'N%';

-- 2. Seleccionar los departamentos que pertenecen a la región donde id_región sea igual a 1.
SELECT id AS 'Id de departamento', nombre AS 'Nombre de departamento'
FROM s_dept
WHERE region_id = 1;

-- 3. Seleccionar id_depto, nombre, salario y cargo para empleados que ganen más de 100 y el departamento esté en 41,10 y 50.
SELECT dept_id AS 'Id de departamento', nombre AS 'Nombre de empleado', salary AS 'Salario', cargo AS 'Cargo'
FROM s_empl
WHERE salary > 100 AND dept_id IN (41, 10, 50);

-- 4. Seleccionar los clientes que pertenezcan a la región 3.
SELECT nombre AS 'Nombre de cliente'
FROM s_customer
WHERE region_id = 3;

-- 5. Fecha de ingreso del empleado Yasmin
SELECT fec_ing AS 'Fecha de ingreso'
FROM s_empl
WHERE nombre LIKE '%YASMIN%';

-- 6. Nombre de los empleados con identificador menor o igual a 10.
SELECT nombre AS 'Nombre de empleado'
FROM s_empl
WHERE id <= 10;

-- 7. Seleccionar los empleados cuya fecha de ingreso esté entre 1990 y 1991.
SELECT nombre AS 'Nombre empleado', fec_ing AS 'Fecha de ingreso'
FROM s_empl
WHERE year(fec_ing) BETWEEN 1990 AND 1991;

-- 8. Seleccionar las órdenes que pertenezcan al cliente con código 208.
SELECT id AS 'Id de orden', customer_id AS 'Id de cliente', fecha AS 'Fecha', total AS 'Total'
FROM s_ord
WHERE customer_id = 208;

-- 9. Seleccionar los productos ordenados por nombre ascendente.
SELECT id AS 'Id de producto', nombre AS 'Nombre de producto', precio AS 'Precio'
FROM s_product
ORDER BY nombre ASC;

-- 10. Nombre del cliente de la ciudad de Osaka.
SELECT nombre AS 'Nombre de cliente'
FROM s_customer
WHERE ciudad LIKE '%OSAKA%';

-- 11. Número total de empleados
SELECT COUNT(*) AS 'Número total de empleados'
FROM s_empl;
