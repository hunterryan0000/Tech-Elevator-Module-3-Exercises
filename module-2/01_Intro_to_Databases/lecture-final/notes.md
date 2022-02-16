# Intro to Databases

--------------------------------------------------------------------
 `postgres1` is the default password for the `postgres` user!
--------------------------------------------------------------------

## Vocab / Acronyms

A **database** is an organized collection of data that can be accessed, managed, and updated.

- Data in a **relational database** can be accessed and reassembled in many different ways without having to reorganize the data.
    - __Tables__ hold the data for each **entity**
    - __Columns__ are called also called **attributes**
    - __Rows__ represent individual **records** 


- RDMS - Relational Database Management System 
    - Examples: Oracle, Microsoft SQL Server, PostgreSQL, IBM Db2, MySQL, SQLite
    - All use SQL
    - May also here RDMS called a "database" for short, but these are the systems that manage databases. 
    - four basic functions are:
        1. Data definition
        2. Data storage
        3. Data retrieval
        4. Administration

- SQL - Structured Query Language
    - Used by relational database systems to get, update, delete, create data in the databases
    - Note: **ANSI SQL** refers to the standardized form of the language, but each RDBMS typically includes its own proprietary version that offers additional features and alternative syntax.

- CRUD - create, read (get), update, delete

NoSQL databases - databases that are not relational
    - come in a variety of types that manage data differently
    - Examples: MongoDB (document), Cassandra(wide-column store), Neo4J (graph), Redis (key-value cache)
    - [Wikipedia: NoSQL](https://en.wikipedia.org/wiki/NoSQ)