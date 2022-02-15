-- This will select all the columns & rows from the  city table
SELECT * FROM city;

-- This will select only the named columns - city_name & state_abbreviation
-- but still selects all the rows
SELECT city_name, state_abbreviation FROM city;

-- The WHERE limits the number of rows coming back
SELECT * FROM city WHERE state_abbreviation = 'NM';

-- Give me all the cities in TX, showing just the city name & population
SELECT city_name, population FROM city WHERE state_abbreviation = 'TX';

-- All the cities that are NOT in TX
SELECT city_name, population FROM city WHERE state_abbreviation != 'TX';

-- Sort the results by state_abbreviation
SELECT * FROM city ORDER BY state_abbreviation DESC;

-- All the cities with a population under 5000
SELECT * FROM city WHERE population < 5000 ORDER BY state_abbreviation;

-- NULL data... null means the value is not set 
-- Special syntax to handle NULL values 
SELECT * FROM state WHERE census_region is NULL; 
SELECT * FROM state WHERE census_region is NOT NULL; 

-- can do basic math opperations when selecting data
SELECT state_abbreviation, sales_tax * 2 FROM state WHERE sales_tax < 4;

-- Select all states with population > 100000 and sales tax >= 7
SELECT * FROM state WHERE population > 100000 AND sales_tax >= 7;

-- Select all states where the population is between 100000 and 500000
SELECT * FROM state WHERE population > 100000 AND population < 500000;
SELECT * FROM state WHERE population BETWEEN 100000 AND 500000;

-- Select all states starting with the letter A
SELECT * FROM state WHERE state_name LIKE 'A%';

-- Select all states that end with the letter A - ILIKE is case insensitive
SELECT * FROM state WHERE state_name ILIKE '%A';

-- Select all states that have two or more words in their name...
SELECT * FROM state WHERE state_name ILIKE '% %';

-- Find me all the parks that were established before 1900
SELECT * FROM park WHERE date_established < '01/01/1900';

--  Can use aliases to help with long table or column names or just to rename a column in the results
SELECT state_abbreviation as abbrevation, state_name as name FROM state WHERE state_abbreviation LIKE 'S%';


-- Exercise #1
--- name and pop of all cities in OH
SELECT city_name, population FROM city WHERE state_abbreviation = 'OH';