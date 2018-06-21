-- Write queries to return the following:
-- Make the following changes in the "world" database.

-- 1. Add Superman's hometown, Smallville, Kansas to the city table. The 
-- countrycode is 'USA', and population of 45001. (Yes, I looked it up on 
-- Wikipedia.)
select * from city
insert into city (id, name, countrycode, district, population) values (4080, 'Smallville', 'USA', 'Kansas', 45001)
select count(*) from city

-- 2. Add Kryptonese to the countrylanguage table. Kryptonese is spoken by 0.0001
-- percentage of the 'USA' population.

select * from countrylanguage where countrycode = 'USA'
insert into countrylanguage (countrycode, language, isofficial, percentage) values ('USA', 'Kryptonese', false, 0.0001)

-- 3. After heated debate, "Kryptonese" was renamed to "Krypto-babble", change 
-- the appropriate record accordingly.

update countrylanguage set language = 'Krypto-babble' where language = 'Kryptonese'

-- 4. Set the US captial to Smallville, Kansas in the country table.
select * from country where code = 'USA'

update country set capital = (select id from city where name = 'Smallville')
where code = 'USA'

-- 5. Delete Smallville, Kansas from the city table. (Did it succeed? Why?)

delete from city where name = 'Smallville'
--*** This did not work because the city id for Smallville is a foreign key in the capital column of the country table

-- 6. Return the US captial to Washington.

update country set capital = (select id from city where name = 'Washington') where code = 'USA'

-- 7. Delete Smallville, Kansas from the city table. (Did it succeed? Why?)

delete from city where name = 'Smallville'
-- *** it did succeed becuase this city id is no longer being used as a foreign key in the capital column of the country table

-- 8. Reverse the "is the official language" setting for all languages where the
-- country's year of independence is within the range of 1800 and 1972 
-- (exclusive). 
-- (590 rows affected)
start transaction;
rollback;
commit;

update countrylanguage set isofficial = not isofficial 
where countrycode in (select code from country where indepyear > 1800 and indepyear < 1972);

select * from countrylanguage where countrycode = 'ARG'

-- 9. Convert population so it is expressed in 1,000s for all cities. (Round to
-- the nearest integer value greater than 0.)
-- (4079 rows affected)
start transaction;
rollback;
commit;

select name, population from city order by population

update city set population = CEILING(population / 1000.0)


-- 10. Assuming a country's surfacearea is expressed in miles, convert it to 
-- meters for all countries where French is spoken by more than 20% of the 
-- population.
-- (7 rows affected)
start transaction;
rollback;
commit;

select name, surfacearea from country 
join countrylanguage cl on cl.countrycode = country.code
where language = 'French' and percentage > 20

update country set surfacearea = (surfacearea * 2590000) where name in (
        select name from country 
        join countrylanguage cl on cl.countrycode = country.code
        where language = 'French' and percentage > 20
        )




