-- Query in pgAdmin for city's with spaces in the name
SELECT * FROM city
WHERE city_name ILIKE '% %';

-- If we put this into Java, we need to sub in the entire string!
-- String sql = SELECT * FROM city WHERE city_name ILIKE ?;
-- queryForRowSet(sql, '% %')