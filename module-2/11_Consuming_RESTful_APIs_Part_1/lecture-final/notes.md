# HTTP & Consuming API's Part 1

REST API - REpresentational State Transfer
    - Focused on sending information about things (entities, or objects)
    - Uses HTTP as the network protocol - HTTP is the (network) language of the web
    - An example REST URL might be:
        - http://localhost:3000/hotels/1/
        - First part is the protocol (http)
        - next is the domain - where is the request going to (localhost)
        - next is the port (3000)
        - then we have the rest of the path (/hotels/1/) 
            - this tells us what type of thing/entity/object we are requesting (hotel)
            - any additional pieces get more specific about the particular thing we are asking for
            - for example (1) is the id of the specific hotel to get information on

Another (made up example)
http://techelevator.com:5000/campus/nlr/cohort/january/classroom/purple
http://techelevator.com:5000/campus/cleveland/cohort/january/classroom/blue
http://techelevator.com:5000/campus/cleveland?cohort=january&classroom=blue
- https://localhost:3000/hotels/1/
  - First part is the protocol (https)
  - next is the domain - where is the request going to (techelevator.com)
  - next is the port (5000)
  - then we have the rest of the path (/nlr/january/purple)
  - this tells us what type of thing/entity/object we are requesting (campus location / program session (cohort) / classroom)
  - any additional pieces get more specific about the particular thing we are asking for
  - for example (1) is the id of the specific hotel to get information on
