# Auth 

2 two parts to "auth":

- Authentication - is the user who they say they are. 
  - We will be confirming this by username & password, but there are many ways to do this

- Authorization - what data can the verified user access
  - comes after authentication
  - data can be tied to a user id
  - different *types* of users can see different data
    - for example in a health care app:
      - a patient may be able to see only their data or their family's data, 
      - but the doctor may be able to see the data for all of their patients

3 potential tiers for access to data:

- just being authenticated - all users logged in or not (@PreAuthorized("isAuthenticated()") OR @PreAuthorized("permitAll))
- role based access - for example "user" or "admin" OR "patient" or "doctor" (@PreAuthorized("hasRole('ADMIN')"))
- access based on logged in user ID - specifically for a single user
  - Add a Principle object to the method parameters to access
  - [Spring controller method parameters](https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#mvc-ann-methods)

- DTO - Data Transfer Object
  - This is often used to hold smaller amounts of data for a specific request (like login)
