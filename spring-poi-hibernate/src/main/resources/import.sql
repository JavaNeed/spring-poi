create table POWER_SUPPLY (
	ID bigint not null auto_increment, 
	BRAND varchar(255), 
	EFFICIENCY double precision, 
	MAXIMUM_POWER varchar(255), 
	MODEL varchar(255), 
	PRICE double precision, 
	primary key (ID)) ENGINE=InnoDB;

insert into POWER_SUPPLY (ID, BRAND, MODEL, MAXIMUM_POWER, PRICE, EFFICIENCY) values (null, 'Corsair', 'CMPSU-750TX', '750W', '109.99', '0.80');
insert into POWER_SUPPLY (ID, BRAND, MODEL, MAXIMUM_POWER, PRICE, EFFICIENCY) values (null, 'Antec', 'NEO ECO 620C', '620W', '69.99', '0.80');
insert into POWER_SUPPLY (ID, BRAND, MODEL, MAXIMUM_POWER, PRICE, EFFICIENCY) values (null, 'OCZ', 'OCZ700MXSP', '700W', '89.99', '0.86');
insert into POWER_SUPPLY (ID, BRAND, MODEL, MAXIMUM_POWER, PRICE, EFFICIENCY) values (null, 'Thermaltake', 'W0070RUC', '430W', '43.99', '0.65');
insert into POWER_SUPPLY (ID, BRAND, MODEL, MAXIMUM_POWER, PRICE, EFFICIENCY) values (null, 'COOLER MASTER', 'RS-460-PSAR-J3', '460W', '29.99', '0.70');
insert into POWER_SUPPLY (ID, BRAND, MODEL, MAXIMUM_POWER, PRICE, EFFICIENCY) values (null, 'Rosewill', 'RG530-S12', '530W', '54.99', '0.80');