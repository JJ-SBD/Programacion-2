create database Scott;

create table s_customer ( 
id int not null primary key,     
nombre varchar (50) not null,     telefono varchar(50) not null,      direccion varchar (50) not null,      ciudad varchar (50) not null,      credit_rating varchar (50) not null,      emp_id int not null,      region_id int not null 
); 

create table s_dept (id int not null primary key,   	
nombre varchar (50) not null,  
region_id int (50) not null 
); 

create table s_empl ( 
id int not null primary key, 
nombre varchar (50) not null,   fec_ing DATE  not null,     
cargo varchar (50) not null, dept_id int not null,     
 salary int not null 
); 

create table s_item ( 
ord_id int not null,  
 product_id int not null, precio int not null,     
cantidad int not null 
); 

create table s_ord ( 
id int primary key not null,  
 customer_id int not null,  fecha varchar(12) not null,      total int not null 
); 

create table s_product ( 
id int not null primary key, 
nombre varchar (50) not null,
nombre_corto varchar (50) not null,
precio int not null      
); 

create table s_region ( 
id int not null primary key,
nombre varchar (50) not null 	 
); 

Alter table s_customer add constraint custom_reg foreign key (region_id) references s_region (id); 
Alter table s_dept add constraint dept_reg 	foreign 	key 	(region_id) 	references s_region(id); 
alter table s_customer add constraint cust_emp foreign key (emp_id) references s_empl(id); 
alter table s_customer add constraint cust_reg foreign key (region_id) references s_region(id); 
alter table s_ord add constraint ord_cust foreign key (customer_id) references s_customer(id); 
alter table s_item add constraint item_ord foreign key (ord_id) references s_ord(id); 
alter table s_item add constraint cons_prod foreign key (product_id) references s_product(id); 
alter table s_empl add constraint empl_dept foreign key (dept_id) references s_dept(id);  


INSERT INTO  s_customer (id, nombre, telefono, direccion, ciudad, credit_rating, emp_id, region_id ) 
VALUES  	(100,'SERGIO ', '','','','GOOD' , 16,2), 
 (202,'Simms Atheletics', '81-20101', '','Osaka ','POOR',1,3),
   (203,'Delhi Sports', '91-10351', '','New Delhi', 'GOOD',14,4), 
 	 (205,'Kams Sporting Goods', '852-3692888','','Hong Kong', 'EXCELLENT', 2,4), 
 	(206,'Sportique','33-2257201','', 'Cannes', 'EXCELLENT', 15,5), 
 	(207,'Sweet Rock Sports','234-6036201','','' , 'GOOD',1,3), 
 	(208,'Muench Sports','49-527454','','Stuttgart' ,'GOOD ', 14,5), 
 	 (211,'Kuhns Sports','42-111292','','Prague' , 'EXCELLENT', 15,5), 
 	 (212,'Hamada Sport', '20-1209211', '','Alexandria','EXCELLENT', 13,3), 
 	 (215,'Sporta Russia','7-3892456','','Saint Petersburg','POOR',15,5); 

INSERT INTO s_dept (id, nombre, region_id) VALUES  
(6, 'Mkt',7), 
(8, 'Sistems',1), 
(10, 'Finance' ,1), 
(11, 'Finances 2',2), 
(12, 'Contabilidad 1',3), 
(15, 'Mkt' ,1), 
(20, 'Contabilidad',3), 
(21, 'ULMOS' ,5), 
(22, 'MASAYA',4), 
(25, 'Massachuset' ,1), 
(31, 'Sales' ,1), 
(32, 'Sales' ,2), 
(33, 'Sales' ,3), 
(34, 'Sales' ,4), 
(35, 'Sales' ,5), 
(41, 'Operations',1), 
(42, 'Operations',2), 
(43, 'Operations',3), 
(44, 'Operations',4), 
(45, 'Operations',5), 
(50, 'Administration',1); 

INSERT INTO s_empl (id, nombre, fec_ing, cargo, dept_id, salary) VALUES 
(1,'Carmen','1990-03-03','President',50,2500.00), 
(2,'LaDoris','1990-03-08','VP,Operations',41,1450.00), 
(3,'Midori','1991-06-07','VP,Sales',31,7088.00), 
(4,'Mark','1990-04-07','VP,Finance',10,3262.00), 
(5,'Audry','1990-03-04','VPAdministration',50,1550.00), 
(6,'Molly','1991-01-18','WarehouseManager',41,1200.00), 
(7,'Roberta','1990-05-14','WarehouseManager',42,1250.00), 
(8,'Ben','1990-04-07','WarehouseManager',43,1100.00), 
(9,'Antoinette','1992-02-09','WarehouseManager',44,1300.00), 
(10,'Marta','1991-02-27','WarehouseManager',45,1307.00), 
(11,'Colin','1990-05-14','SalesRepresentative',31,15947.00), 
(12,'Henry','1992-01-18','SalesRepresentative',32,16972.00), 
(13,'Yasmin','1991-02-18','SalesRepresentative',33,17257.00), 
(14,'Mai','1992-01-22','SalesRepresentative',34,17371.00), (15,'Andre','1991-10-09','SalesRepresentative',35,16516.00), 
(16,'Elena','1992-02-07','StockClerk',41,1400.00), 
(17,'George','1990-03-08','StockClerk',41,940.00), 
(18,'Akira','1991-02-09','StockClerk',42,1200.00), 
(19,'Vikram','1991-08-06','StockClerk',42,795.00), 
(20,'Chad','1991-07-21','StockClerk',43,750.00), 
(21,'Alexander','1991-05-26','StockClerk',43,850.00), 
(22,'Eddie','1990-11-30','StockClerk',44,800.00), 
(23,'Radha','1990-10-17','StockClerk',34,4025.00), 
(24,'Bela','1991-03-17','StockClerk',45,860.00), 
(25,'Sylvie','1991-05-09','StockClerk',45,1100.00); 

INSERT INTO s_item (ord_id, product_id, precio, cantidad) VALUES 
(101,10013,10,20), 
(107,20106,11,50), 
(102,20108,28,100), 
(107,20108,28,22), 
(102,20201,100,100), 
(107,20201,115,130), 
(99,20510,9,18), 
(104,20510,9,7), 
(108,20510,9,9), 
(99,20512,8,25), 
(104,20512,8,12), 
(108,20512,8,18), 
(104,30321,1669,19), 
(107,30321,1669,75), 
(108,30321,1669,85), 
(104,30421,16,35), (107,30421,16,55), 
(103,30433,20,15), 
(103,32779,7,11), 
(108,32779,7,60), 
(108,32861,60,57), 
(98,40421,85,7), 
(101,40422,50,30), 
(101,41010,8,20), 
(108,41080,35,50), 
(101,41100,45,35), 
(108,41100,45,42), 
(101,50169,4.29,40), 
(99,50417,10,200), 
(101,50417,80,27), 
(99,50530,12,10), 
(101,50530,45,50); 

INSERT INTO s_item (ord_id, product_id, precio, cantidad) VALUES 
(101,10013,10,20), 
(107,20106,11,50), 
(102,20108,28,100), 
(107,20108,28,22), 
(102,20201,100,100), 
(107,20201,115,130), 
(99,20510,9,18), 
(104,20510,9,7), 
(108,20510,9,9), 
(99,20512,8,25), 
(104,20512,8,12), 
(108,20512,8,18), 
(104,30321,1669,19), 
(107,30321,1669,75), 
(108,30321,1669,85), 
(104,30421,16,35), (107,30421,16,55), 
(103,30433,20,15), 
(103,32779,7,11), 
(108,32779,7,60), 
(108,32861,60,57), 
(98,40421,85,7), 
(101,40422,50,30), 
(101,41010,8,20), 
(108,41080,35,50), 
(101,41100,45,35), 
(108,41100,45,42), 
(101,50169,4.29,40), 
(99,50417,10,200), 
(101,50417,80,27), 
(99,50530,12,10), 
(101,50530,45,50); 

INSERT INTO s_ord(id, customer_id, fecha, total) VALUES  
(98,  202, 	'1992-08-31',  595), 
(99,  100, 	'1992-08-31',  2482), 
(101, 205, 	'1992-08-31', 8017), 
(102, 100, 	'1992-09-01', 12800), 
(103, 208, 	'1992-09-02', 377), 
(104, 208, 	'1992-09-03', 32430), 
(107, 211, 	'1992-09-07', 142171), 
(108, 212, 	'1992-09-07', 149570), 
(109, 212, 	'1992-09-07', 1234);

insert into s_product (id, nombre, nombre_corto, precio) VALUES  
(10011,'BunnyBoot','',0), 
(10012,'AceSkiBoot','',0), (10013,'ProSkiBoot','',0), 
(10021,'BunnySkiPole','',0), 
(10022,'AceSkiPole','',0), (10023,'ProSkiPole','',0), 
(20106,'JuniorSoccerBall','',0), 
(20108,'WorldCupSoccerBall','',0), 
(20201,'WorldCupNet','',0), 
(20510,'BlackHawkKneePads','',0), 
(20512,'BlackHawkElbowPads','',0), 
(30321,'GrandPrixBicycle','',0), 
(30326,'HimalayaBicycle','',0), 
(30421,'GrandPrixBicycleTires','',0), 
(30426,'HimalayaTires','',0), 	 
(30433,'NewAirPump','',0), 
(32779,'SlakerWaterBottle','',0), 
(32861,'Safe-THelmet','',0), 
(40421,'AlexeyerProLiftingBar','',0), 
(40422,'ProCurlingBar','',0), 
(41010,'Prostar10PoundWeight','',0), 
(41020,'Prostar20PoundWeight','',0), (41050,'Prostar50PoundWeight','',0), (41080,'Prostar80PoundWeight','',0), (41100,'Prostar100PoundWeight','',0), 
(50169,'MajorLeagueBaseball','',0), 
(50273,'ChapmanHelmet','',0), 
(50417,'GriffeyGlove','',0), 
(50418,'AlomarGlove','',0), 
(50419,'SteinbachGlove','',0), 
(50530,'CabreraBat','',0), 
(50532,'PuckettBat','',0), (50536,'WinfieldBat','',0); 

insert into s_region (id, nombre) values  
 
(1, 'NORTH AMERICA'), 
(2, 'SOUTH AMERICA'), 
(3, 'AFRICA / MIDDLE EAST'), 
(4, 'ASIA'), 
(5, 'EUROPE'), 
(7, 'INGENIERIA DE SISTEMA'), 
(15, 'NICARAGUA'); 