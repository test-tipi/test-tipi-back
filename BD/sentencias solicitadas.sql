SET SQL_SAFE_UPDATES = 0;

select 
	id as identificador,
	concat(name,' ', last_name) as nombres,
    age as edad
from tipitest.person;

select 
	age as edad,
    count(*) cantidad
from tipitest.person
group by age;


select
	name as nombre,
    age as edad,
    IF(age>=18,'SI',null) as 'mayor de edad'
from tipitest.person;


update  tipitest.person 
SET
	age = age-5
WHERE age >=50;

SELECT * FROM  tipitest.person;

DELETE FROM tipitest.person  WHERE last_name like '%DEL';


