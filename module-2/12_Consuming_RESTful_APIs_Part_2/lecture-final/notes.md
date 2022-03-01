# Consuming API's Part 2

Yesterday we looked at GET requests, the R (read) part of CRUD.
Today we're going to look at C (create), U (update), D (delete) parts.

- All HTTP Requests! 
- They are all stateless... That means, the requests themselves have no context or info of what requests may have 
    been made before or what might come after. They only know where they are going and what (if any) information is 
    packaged up inside of them.
- HTTP Response comes back from the server: 
  - 200 status code means OK - good response
  - 200-299 are a range of good response status codes (all mean slightly different thing)
    - 201 = created (usually used as a good response for Create or POST request)
  - 300 range can be fine (might not), for example might indicate response was cached and can be reused from a recent request
  - 400 range - something bad has happened (should be able to fix on the client side)
    - 404 - (Not Found) Request URL was not found (maybe you've got a typo, not asking for the right path, etc)
    - 403 - (Forbidden) Request URL is likely correct, but you don't have access to it
    - There seems to be a trend toward being more vague and using 404 for any bad request to avoid giving too much 
        detail on what is wrong to aid in hacking
  - 500 range - something bad has happened __BUT__ it's on (internal to) the server & you likely can do nothing to 
       fix it from the client side

Additional Resourced for status codes:
  - [Cats](https://http.cat/) 
  - [Dogs](https://httpstatusdogs.com/)
  - [Official](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status)

