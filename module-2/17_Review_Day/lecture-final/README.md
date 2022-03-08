# Pet Friends App


## Updates
The app now has database with a user table & friend table, so make sure to run the database.sql script & check out the new DAO classes.

Auth has been added to the application. This is very similar to what you'll see in the Capstone project. Most of this is contained in the `security` package.

Also note the controller paths now begin with `/api`. It is a good practice to prefix your api path with something like `api`, and optionally a version number, to avoid path conflicts with static resources that may be part of your applications later (module 3 & beyond). You'll see this in many 3rd party APIs.

## ToDo's 

### Secure the application! 
1. Prevent access to posts unless logged into the app. (DONE!!!)
2. Restrict get posts to the logged in user. Should show their own posts + their friends posts ONLY! (DONE!!!!)
3. Update the create to associate the post to the logged in user. (DONE!!!)
4. Restrict edit/delete to only the author of the post.

## REST API 

- /api/post - GET all posts
- /api/post/feed/{userId} - GET all posts for the logged in user's feed
- /api/post - POST add a new post for a user


### Optional

If we have time...  Get, add, delete for friend relationships.

1. Get all users. This is to allow someone to select a user to 'friend'
2. Add a new friend. Check to make sure they are not already friends before adding again.
3. Get a user's friends.
4. Delete a friend by id. 
