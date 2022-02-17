-- Review & Intro to joins

SELECT * FROM city;

SELECT * FROM park;

--- Get city name, state abbreviation, AND state name (which is in the state table)
-- Yesterday we used a subquery for this: THIS IS NOT THE BEST WAY TO DO THIS!
SELECT COUNT(*) as city_count, state_abbreviation,
	(
		SELECT state_name FROM state WHERE state_abbreviation = city.state_abbreviation
	) as state_name
FROM city
GROUP BY state_abbreviation
ORDER BY city_count DESC;

-- Joins make this easier...
SELECT COUNT(*) as city_count, city.state_abbreviation, state_name
FROM city
JOIN state ON city.state_abbreviation = state.state_abbreviation
GROUP BY city.state_abbreviation, state_name
ORDER BY city_count DESC;

-- A little more straightforward without the count
SELECT * FROM city
INNER JOIN state ON city.state_abbreviation = state.state_abbreviation
ORDER BY city.state_abbreviation;


-- INNER JOIN

-- Write a query to retrieve the name and state abbreviation for the 2 cities named "Columbus" in the database
SELECT city_name, state_abbreviation FROM city
WHERE city_name = 'Columbus';

-- Modify the previous query to retrieve the names of the states (rather than their abbreviations).
SELECT city_name, state_name FROM city
INNER JOIN state ON city.state_abbreviation = state.state_abbreviation
WHERE city_name = 'Columbus';

-- Write a query to retrieve the names of all the national parks with their state abbreviations.
-- (Some parks will appear more than once in the results, because they cross state boundaries.)
SELECT park_name, state_abbreviation FROM park
JOIN park_state ON park.park_id = park_state.park_id;

-- The park_state table is an associative table that can be used to connect the park and state tables.
-- Modify the previous query to retrieve the names of the states rather than their abbreviations.
SELECT park.park_id, park_name, state_name FROM park
JOIN park_state ON park.park_id = park_state.park_id
JOIN state ON state.state_abbreviation = park_state.state_abbreviation;

-- Modify the previous query to include the name of the state's capital city.
SELECT park.park_id, park_name, state_name, city.city_name as state_capital FROM park
JOIN park_state ON park.park_id = park_state.park_id
JOIN state ON state.state_abbreviation = park_state.state_abbreviation
JOIN city ON state.capital = city.city_id;

-- Modify the previous query to include the area of each park.
SELECT park.park_id, park_name, park.area as park_area, state_name, city.city_name as state_capital FROM park
JOIN park_state ON park.park_id = park_state.park_id
JOIN state ON state.state_abbreviation = park_state.state_abbreviation
JOIN city ON state.capital = city.city_id;

-- Write a query to retrieve the names and populations of all the cities in the Midwest census region.
SELECT  city_name, city.population, census_region FROM city
JOIN state ON city.state_abbreviation = state.state_abbreviation
WHERE census_region = 'Midwest';

-- Write a query to retrieve the number of cities in the city table for each state in the Midwest census region.
SELECT COUNT(city_name), state_name FROM city
JOIN state ON city.state_abbreviation = state.state_abbreviation
WHERE census_region = 'Midwest'
GROUP BY state_name;

-- Modify the previous query to sort the results by the number of cities in descending order.
SELECT COUNT(city_name) as city_count, state_name FROM city
JOIN state ON city.state_abbreviation = state.state_abbreviation
WHERE census_region = 'Midwest'
GROUP BY state_name
ORDER BY city_count DESC;


-- LEFT JOIN

-- Write a query to retrieve the state name and the earliest date a park was established in that state (or territory) 
-- for every record in the state table that has park records associated with it.
SELECT state_name, MIN(date_established) FROM state
-- INNER JOIN is the default if you don't say otherwise
JOIN park_state ON state.state_abbreviation = park_state.state_abbreviation
JOIN park ON park_state.park_id = park.park_id
GROUP BY state_name
ORDER BY state_name;

-- Modify the previous query so the results include entries for all the records in the state table, even if they have no park records associated with them.
SELECT state_name, park.park_id, park_name, date_established FROM state
-- INNER JOIN is the default if you don't say otherwise
-- If you want any other type of JOIN you need to specify that out fully
LEFT JOIN park_state ON state.state_abbreviation = park_state.state_abbreviation
LEFT JOIN park ON park_state.park_id = park.park_id
ORDER BY state_name;


SELECT state_name, MIN(date_established) FROM state
-- INNER JOIN is the default if you don't say otherwise
-- If you want any other type of JOIN you need to specify that out fully
LEFT JOIN park_state ON state.state_abbreviation = park_state.state_abbreviation
LEFT JOIN park ON park_state.park_id = park.park_id
GROUP BY state_name
ORDER BY state_name;


-- UNION

-- Write a query to retrieve all the place names in the city and state tables that begin with "W" sorted alphabetically. 
-- (Washington is the name of a city and a state--how many times does it appear in the results?)
SELECT city_name as place_name FROM city WHERE city_name ILIKE 'W%'
UNION
SELECT state_name as place_name FROM state WHERE state_name ILIKE 'W%'
ORDER BY place_name;

-- Modify the previous query to include a column that indicates whether the place is a city or state.
SELECT city_name as place_name, 'city' as type FROM city WHERE city_name ILIKE 'W%'
UNION
SELECT state_name as place_name, 'state' as type FROM state WHERE state_name ILIKE 'W%'
ORDER BY place_name;


-- MovieDB (for exercises)
-- After creating the MovieDB database and running the setup script, make sure it is selected in DbVisualizer and confirm it is working correctly by writing queries to retrieve...

-- The names of all the movie genres


-- The titles of all the Comedy movies

