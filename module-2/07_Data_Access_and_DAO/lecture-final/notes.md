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

## CRUD

Create - SQL INSERT
Read   - SQL SELECT
Update - SQL UPDATE
Delete - SQL DELETE


