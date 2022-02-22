# Database Access & DAOs

## Database Connection String example

Example format: 
postgres://YourUserName:YourPassword@YourHostname:5432/YourDatabaseName

Actual example from Heroku:
postgres://bpwehlucvecvme:7380c44e425db266b6858e05b0aa7ae80eccbeb60b8f19c030c3e7b4a1e27c94@ec2-54-157-160-218.compute-1.amazonaws.com:5432/dasna5uu301h2j

## Parameterized query

ALWAYS just do this!!!

Uses `?` in the SQL string to make placeholders for values that you plug in later when you call the JdbcTemplate method:
```
  String sql = "SELECT city_id, city_name, state_abbreviation, population, area " +
                "FROM city " +
                "WHERE city_id = ?;";
  SqlRowSet results = jdbcTemplate.queryForRowSet(sql, cityId);
```

Remember Bobby Drop Tables: https://xkcd.com/327/

## CRUD

Create - SQL INSERT
Read   - SQL SELECT
Update - SQL UPDATE
Delete - SQL DELETE

## The DAO pattern

The **Data Access Object (DAO)** design pattern _encapsulates__ the details of data storage & management (CRUD). These classes *only* manage the data - no business rules around the data or processes.

The DAO pattern makes code **loosely coupled**. Programming to an interface!

- Isolating data access code inside of DAOs decouples the rest of the application from the details of persistence. This makes it really easy to change or modify how/where that data is stored

- Relational databases are often used for persistent storage, but other technologies could be used such as the filesystem, NoSQL database, or a web service.

- It also isolates the code changes that need to be made in the event of a database schema change.

Each DAO consists of three components:

1. A domain object (`City`)
2. An interface (`CityDao`)
3. An implementation of that interface (`JdbcCityDao`)
