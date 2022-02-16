-- Questions around alias...
-- Can alias a table & use that elsewhere in the query
-- Alias from the SELECT are the last thing that happens and CANNOT be used elsewhere
SELECT park_id as id, park_name as name FROM park as p 
WHERE p.area > 200 ORDER BY name;


-- ORDERING RESULTS

-- Populations of all states from largest to smallest.
SELECT state_abbreviation, state_name, population FROM state ORDER BY population DESC;

-- States sorted alphabetically (A-Z) within their census region. 
-- The census regions are sorted in reverse alphabetical (Z-A) order.
SELECT state_name, census_region FROM state 
WHERE census_region IS NOT NULL 
ORDER BY census_region DESC, state_name ASC;

-- The biggest park by area
SELECT * FROM park ORDER BY area DESC; -- All Parks ordered by area
SELECT * FROM park ORDER BY area DESC LIMIT 1; -- Single biggest park by area


-- LIMITING RESULTS

-- The 10 largest cities by populations
SELECT city_name, population FROM city
ORDER BY population DESC 
LIMIT 10;

-- The 20 oldest parks from oldest to youngest in years, sorted alphabetically by name.
SELECT park_name, ((CURRENT_DATE - date_established) / 365) as age FROM park
ORDER BY age DESC, park_name  
LIMIT 20;

-- SELECT park_name, (date_part('year', CURRENT_DATE) - date_part('year', date_established)) as age 
-- FROM park
-- ORDER BY age DESC, park_name  
-- LIMIT 20;



-- CONCATENATING OUTPUTS

-- All city names and their state abbreviation.
SELECT (city_name || ', ' || state_abbreviation) as city_state 
FROM city
ORDER BY state_abbreviation, city_name;

-- The all parks by name and date established.


-- The census region and state name of all states in the West & Midwest sorted in ascending order.



-- AGGREGATE FUNCTIONS

-- Average population across all the states. 
-- Note the use of alias, common with aggregated values.
SELECT AVG(population) as average_state_population FROM state;

-- Total population in the West and South census regions
SELECT SUM(population) as total_population_west_and_south
FROM state
WHERE census_region = 'West' OR census_region = 'South';

-- The number of cities with populations greater than 1 million
SELECT COUNT(*) as city_count FROM city
WHERE population > 1000000;

-- The number of state nicknames.
SELECT COUNT(*) as nickname_count FROM state WHERE state_nickname IS NOT NULL;

-- Can put a specific column in count to ignore nulls in that column
SELECT COUNT(state_nickname) as nickname_count FROM state;

-- The area of the smallest and largest parks.
SELECT MIN(area) as smallest, MAX(area) as largest FROM park;


-- GROUP BY

-- Count the number of cities in each state, ordered from most cities to least.
SELECT * FROM city ORDER BY state_abbreviation;

SELECT COUNT(*) as city_count, state_abbreviation 
FROM city
GROUP BY state_abbreviation
ORDER BY city_count DESC;

-- Show state name with abbreviation
SELECT state_name FROM state WHERE state_abbreviation = 'CA';

SELECT COUNT(*) as city_count, state_abbreviation,
	(
		SELECT state_name FROM state WHERE state_abbreviation = city.state_abbreviation
	) as state_name
FROM city
GROUP BY state_abbreviation
ORDER BY city_count DESC;


-- Determine the average park area depending upon whether parks allow camping or not.
SELECT AVG(area) as average_park_area, has_camping FROM park
GROUP BY has_camping;

-- Sum of the population of cities in each state ordered by state abbreviation.
SELECT SUM(population), state_abbreviation FROM city
GROUP BY state_abbreviation
ORDER BY state_abbreviation;

-- The smallest city population in each state ordered by city population.
SELECT population, city_name, state_abbreviation FROM city
ORDER BY state_abbreviation, population;

SELECT MIN(population) as min_city_population, state_abbreviation FROM city
GROUP BY state_abbreviation
ORDER BY state_abbreviation;

-- I think  we can do this with a subquery...
SELECT population as min_population, city_name, state_abbreviation FROM city 
WHERE population = (
	SELECT MIN(population) FROM city as c
	WHERE city.state_abbreviation = c.state_abbreviation
)
ORDER BY state_abbreviation;

SELECT city_name FROM city WHERE population = 31276;



-- Miscelleneous

-- While you can use LIMIT to limit the number of results returned by a query,
-- it's recommended to use OFFSET and FETCH if you want to get
-- "pages" of results.
-- For instance, to get the first 10 rows in the city table
-- ordered by the name, you could use the following query.
-- (Skip 0 rows, and return only the first 10 rows from the sorted result set.)
SELECT city_name, population
FROM city
ORDER BY city_name
OFFSET 0 ROWS FETCH NEXT 10 ROWS ONLY;


-- SUBQUERIES (optional)

-- Include state name rather than the state abbreviation while counting the number of cities in each state,
-- SELECT state_name FROM state WHERE state_abbreviation = 'CA';

SELECT COUNT(*) as city_count, 
	(
		SELECT state_name FROM state WHERE state_abbreviation = city.state_abbreviation
	) as state_name
FROM city
GROUP BY state_abbreviation
ORDER BY city_count DESC;

-- Include the names of the smallest and largest parks
SELECT state_abbreviation, city_name
FROM city
WHERE city_id IN
    (
        SELECT capital
        FROM state
        WHERE census_region = 'Northeast'
    )
ORDER BY state_abbreviation;


-- List the capital cities for the states in the Northeast census region.
SELECT s.state_abbreviation,
	(SELECT c.city_name FROM city AS c WHERE c.city_id = s.capital)
FROM state AS s
WHERE s.census_region = 'Northeast'
ORDER BY s.state_abbreviation;
