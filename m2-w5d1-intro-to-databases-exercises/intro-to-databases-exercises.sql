-- The following queries utilize the "world" database.
-- Write queries for the following problems. 
-- Notes:
--   GNP is expressed in millions of US Dollars
--   The value immediately after the problem statement is the expected number of rows that should be returned by the query.

-- 1. The name and population of all cities in Ontario, Canada (27 rows)
SELECT name, population FROM city WHERE countrycode = 'CAN' AND district = 'Ontario';

-- 2. The name and population of all cities in Montana (1 row)
Select * FROM city WHERE countrycode = 'USA' and district = 'Montana';

-- 3. The name, form of government, and head of state of all countries in Europe (46 rows)
Select name, governmentform, headofstate FROM country WHERE continent = 'Europe'

-- 4. The name, population, surface area, and average life expectancy of all countries in Asia (51 rows)
Select name, population, surfacearea, lifeexpectancy from country where continent = 'Asia'

-- 5. The name, country code, and population of all cities with a population greater than 8 million people (10 rows)
select name, countrycode, population from city where population > 8000000;

-- 6. The name, country code, and population of all cities with a population less than one thousand people (11 rows)
select name, countrycode, population from city where population < 1000;

-- 7. The name, continent, and GNP of all countries with a GNP greater than one trillion dollars (6 rows)
select name, continent, gnp from country where gnp > 1000000

-- 8. The name, continent, population, GNP, and average life expectancy of all countries with an average life expectancy greater than 80 years (5 rows)
select name, continent, population, gnp, lifeexpectancy from country where lifeexpectancy > 80;

-- 9. The name and population of all cities in the USA with a population of greater than 1 million people (9 rows)
select name, population from city where population > 1000000 and countrycode = 'USA';

-- 10. The name and population of all cities in China with a population of greater than 1 million people (35 rows)
select name, population, * from city where population > 1000000  and countrycode = 'CHN';

-- 11. The name and region of all countries in North or South America (51 rows)
select name, region from country where continent like '%America'

-- 12. The name, continent, and head of state of all countries whose form of government is a monarchy (43 rows)
select * from country where governmentform like '%Monarchy%'

-- 13. The name of all cities in the USA with a population between 1 million and 2 million people (6 rows) 
select name from city where countrycode = 'USA' and population between 1000000 and 2000000;

-- 14. The name and region of all countries in North or South America except for countries in the Caribbean (27 rows)
select name, region from country where continent like '%America' and region <> 'Caribbean'

-- 15. The name, population, and GNP of all countries with a GNP greater than $1 trillion dollars and a population of less than 100 million people (4 rows)
select name, population, gnp from country where gnp > 1000000 and population < 100000000;

-- 16. The name and population of all cities in Texas that have a population of greater than 1 million people (3 rows)
select name, population from city where district = 'Texas' and population > 1000000;

-- 17. The name and average life expectancy of all countries on the continent of Oceania (28 rows)
select name, lifeexpectancy from country where continent = 'Oceania';

-- 18. The name and average life expectancy of all countries on the continent of Oceania for which an average life expectancy has been provided (i.e. not equal to null) (20 rows)
select name, lifeexpectancy from country where continent = 'Oceania' and lifeexpectancy is not null; 

-- 19. The name of all countries on the continent of Oceania for which an average life expectancy has not been provided (i.e. equal to null) (8 rows)
select name from country where lifeexpectancy is null and continent = 'Oceania';

-- 20. The name, continent, GNP, and average life expectancy of all countries that have an average life expectancy of at least 70 years and a GNP between $1 million and $100 million dollars (3 rows)
select name, continent, gnp, lifeexpectancy from country where lifeexpectancy >= 70 and gnp between 1 and 100

-- 21. The per capita GNP (i.e. GNP divided by population) in US Dollars of all countries in Europe (46 rows)
select (gnp / population * 1000000) as per_capita_gnp from country where continent = 'Europe';

-- 22. The number of years since independence for all countries that have a year of independence (192 rows)
select name, (2018 - indepyear) as years_since_independence from country where indepyear is not null;

