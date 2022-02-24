# Integration Testing

General gist of integration testing is testing across two or more parts of your system.

Some examples:
    - java DAO to the database (sql queries in DAOs & model classes) -- what we currently know
    - Java server to another 3rd party API (Talk about this later in Mod 2)
    - HTML/CSS front-end to our Java server back-end (Talk about this in Mod 3)

Contrast with Unit Testing
- Unit Testing stays within a small "unit" of your application, generally within one class
- Focused around testing individual methods within that class (or unit)
- Important to limit dependencies on outside things 
   so that the focus is on the logic within that small unit or function/method

Just like unit tests, the goal is that the tests are repeatable and consistent.
- avoid random things in your tests (selecting randomly something from a list or result set to verify) 
  or using a value that is unpredicatable or might change - randomly generated number or "current date/time"

Good tests 
 - are repeatable
 - are independent of other tests - tests should be able to run in any order
 - should clearly & obviously state why they fail (if they do)
