-- INSERT
SELECT * FROM park_state;

-- Add Disneyland to the park table. (It was established on 7/17/1955, has an area of 2.1 square kilometers and 
-- does not offer camping.)
INSERT INTO park (park_name, date_established, area, has_camping) VALUES ('Disneyland', '07-17-1955', 2.1, false);

-- Add Hawkins, IN (with a population of 30,000 and an area of 38.1 square kilometers)
-- and Cicely, AK (with a popuation of 839 and an area of 11.4 square kilometers) to the city table.
INSERT INTO city (city_name, state_abbreviation, population, area) 
VALUES
('Hawkins', 'IN', 30000, 38.1),
('Cicely', 'AK', 839, 11.4);

-- Since Disneyland is in California (CA), add a record representing that to the park_state table.
SELECT park_id, 'CA' as state_abbreviation FROM park WHERE park_name = 'Disneyland';
-- INSERT INTO park_state (park_id, state_abbreviation) VALUES (64, 'CA');
INSERT INTO park_state (park_id, state_abbreviation)
	SELECT park_id, 'CA' as state_abbreviation FROM park WHERE park_name = 'Disneyland';

SELECT * from park_state WHERE park_id = 64;
DELETE from park_state WHERE park_id = 64;


-- UPDATE

-- Change the state nickname of California to "The Happiest Place on Earth."
SELECT * FROM state WHERE state_name = 'California';

UPDATE state 
SET state_nickname = 'The Happiest Place on Earth'
WHERE state_name = 'California';

-- Increase the population of California by 1,000,000.
UPDATE state
SET population = population + 1000000
WHERE state_name = 'California';

-- Change the capital of California to Anaheim.
SELECT city_id FROM city WHERE city_name = 'Anaheim' AND state_abbreviation = 'CA';

UPDATE state 
SET capital = (SELECT city_id FROM city WHERE city_name = 'Anaheim' AND state_abbreviation = 'CA')
WHERE state_name = 'California';

-- Change California's nickname back to "The Golden State", 
-- reduce the population by 1,000,000, and change the capital back to Sacramento.
UPDATE state 
SET state_nickname = 'The Golden State',
capital = (SELECT city_id FROM city WHERE city_name = 'Sacramento' AND state_abbreviation = 'CA'),
population = population - 1000000
WHERE state_name = 'California';


-- DELETE

-- Delete Hawkins, IN from the city table.
SELECT * FROM city WHERE city_name = 'Hawkins' AND state_abbreviation = 'IN';
DELETE FROM city WHERE city_name = 'Hawkins' AND state_abbreviation = 'IN';

-- Delete all cities with a population of less than 1,000 people from the city table.
SELECT * FROM city WHERE population < 1000;
DELETE FROM city WHERE population < 1000;

-- REFERENTIAL INTEGRITY

-- Delete all cities with a population of less than 10,000 people from the city table.
SELECT * FROM city WHERE population < 10000; -- Gives 3 cities
-- Hagåtña is the capital of GU, so trying to delete gives an error 
-- because it is referenced in the state table as a FK
DELETE FROM city WHERE population < 10000;

-- Try adding a city to the city table with "XX" as the state abbreviation.
INSERT INTO city (state_abbreviation) 
VALUES ('test city', 'XX', 0, 0);

-- Don't have to specify all column on INSERT, 
-- __BUT__ you do need to provide what is required by the table constraints to make it valid (see create script and/or ERD)
INSERT INTO city (city_name, state_abbreviation, area) 
VALUES ('test city', 'FL', 0);

SELECT * FROM city WHERE city_name = 'test city'; -- Note the default value for population is filled in as 0

-- Try deleting California from the state table.
SELECT * FROM state WHERE state_abbreviation = 'CA';
DELETE FROM state WHERE state_abbreviation = 'CA';

-- Try deleting Disneyland from the park table. Try again after deleting its record from the park_state table.
SELECT park_id FROM park WHERE park_name = 'Disneyland';
DELETE FROM park WHERE park_name = 'Disneyland';

SELECT * FROM park_state WHERE park_id = (SELECT park_id FROM park WHERE park_name = 'Disneyland');
DELETE FROM park_state WHERE park_id = (SELECT park_id FROM park WHERE park_name = 'Disneyland');
DELETE FROM park WHERE park_name = 'Disneyland';

-- CONSTRAINTS

-- NOT NULL constraint
-- Try adding Smallville, KS to the city table without specifying its population or area.
-- Fails! Due to not null constraint on area
-- INSERT INTO city (city_name, state_abbreviation) VALUES ('Smallville', 'KS');

-- DEFAULT constraint
-- Try adding Smallville, KS again, specifying an area but not a population.
-- This works because city_id is auto generated and population specifies a default value
INSERT INTO city (city_name, state_abbreviation, area) VALUES ('Smallville', 'KS', 0);

-- Retrieve the new record to confirm it has been given a default, non-null value for population.
SELECT * FROM city WHERE city_name = 'Smallville';

-- UNIQUE constraint
-- Try changing California's nickname to "Vacationland" (which is already the nickname of Maine).
SELECT * FROM state WHERE state_nickname = 'Vacationland';
UPDATE state SET state_nickname = 'Vacationland' WHERE state_abbreviation = 'CA';

-- CHECK constraint
-- Try changing the census region of Florida (FL) to "Southeast" (which is not a valid census region).
UPDATE state SET census_region = 'Southeast' WHERE state_abbreviation = 'FL';


-- TRANSACTIONS

-- Delete the record for Smallville, KS within a transaction.
--BEGIN TRANSACTION; -- also works, but isn't what's in the reading
START TRANSACTION;
DELETE FROM city WHERE city_name = 'Smallville' AND state_abbreviation = 'KS';
COMMIT; -- Makes the transaction final. Like a git commit :-)
ROLLBACK; -- This will undo whatever was done since the start of the transaction. Can't do this AFTER a COMMIT!
-- ROLLBACK doesn't really make sense here in a SQL only script, but works great in our Java code!

SELECT * FROM city WHERE city_name = 'Smallville' AND state_abbreviation = 'KS';

-- Delete all of the records from the park_state table, but then "undo" the deletion by rolling back the transaction.
BEGIN TRANSACTION;
DELETE FROM park_state;
ROLLBACK;

SELECT * FROM park_state;

-- Update all of the cities to be in the state of Texas (TX), but then roll back the transaction.
START TRANSACTION;
UPDATE city SET state_abbreviation = 'TX';
ROLLBACK;

SELECT * FROM city;

