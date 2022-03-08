package com.mbmosman.controller;

import com.mbmosman.dao.PostDao;
import com.mbmosman.dao.UserDao;
import com.mbmosman.model.NotAuthorizedException;
import com.mbmosman.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

/**
 *  REST API
 *  Routes
 *  - GET /post  - This returns all the posts ordered newest to oldest
 *  - GET /post/{id} - Return the post with that id
 *  - POST /post - This adds a new POST
 *  - DELETE /post/{id} - Remove the post with the specified id
 *  - PUT /post/{id} - Allows us to edit an existing post
 *
 */

@PreAuthorize("isAuthenticated()")
@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    private PostDao postDao;
    @Autowired
    private UserDao userDao;

    public PostController(PostDao postDao){
        this.postDao = postDao;
    }

    @RequestMapping(path="", method= RequestMethod.GET)
    public List<Post> getAllPosts() {
        return postDao.getAllPosts();
    }

    // Want a path for "posts" but narrowed down to a specific feed for the logged in user like /api/post/feed/
    @RequestMapping(path="/feed", method = RequestMethod.GET)
    public List<Post> getPostsForUser(Principal principal){
        // Pricipal gives us the logged in user! Use that to get the userID that our postDao needs.
        int userId = userDao.findIdByUsername(principal.getName());
        return postDao.getPostsForUser(userId);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Post getPost(@PathVariable int id) {
        return postDao.getPost(id);
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public Post addPost(@RequestBody Post postData, Principal principal) throws NotAuthorizedException {
        // Pricipal gives us the logged in user! Use that to get the userID that our postDao needs.
        int userId = userDao.findIdByUsername(principal.getName());
        if (postData.getUserId() <= 0) {
            // if the userId was not set, then set it to the logged in user
            postData.setUserId(userId);
        } else if (postData.getUserId() != userId){
            // if the userId IS set AND it does not match the logged in user, then send an error
            throw new NotAuthorizedException();
        }
        // If we get here, we have the correct userId on the postData
        return postDao.createPost(postData);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable int id, Principal principal) throws NotAuthorizedException {
        // Pricipal gives us the logged in user! Use that to get the userID that our postDao needs.
        int userId = userDao.findIdByUsername(principal.getName());

        // Want to make sure that the logged in user can only delete their posts... So we need the post to check first
        Post postToDelete = postDao.getPost(id);
        if (postToDelete.getUserId() == userId) {
            // Id's match OK to delete
            postDao.deletePost(id);
        } else {
            throw new NotAuthorizedException();
        }
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public Post updatePost(@PathVariable int id, @RequestBody Post postData, Principal principal) throws NotAuthorizedException {
        // Pricipal gives us the logged in user! Use that to get the userID that our postDao needs.
        int userId = userDao.findIdByUsername(principal.getName());
        if (postData.getUserId() <= 0) {
            // if the userId was not set, then set it to the logged in user
            postData.setUserId(userId);
        } else if (postData.getUserId() != userId){
            // if the userId IS set AND it does not match the logged in user, then send an error
            throw new NotAuthorizedException();
        }
        // Want to make sure that the logged in user can only update their posts... So we need the post to check first
        Post postToUpdate = postDao.getPost(id);
        if (postToUpdate.getUserId() != userId) {
            // Post does not belong to the logged in user
            throw new NotAuthorizedException();
        }
        // We're sure the post data is correct & the post belongs to the logged in user
        return postDao.updatePost(id, postData);
    }

}
