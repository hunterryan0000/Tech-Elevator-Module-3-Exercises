package com.mbmosman.controller;

import com.mbmosman.dao.PostDao;
import com.mbmosman.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    private PostDao postDao;

    public PostController(PostDao postDao){
        this.postDao = postDao;
    }

    @RequestMapping(path="", method= RequestMethod.GET)
    public List<Post> getAllPosts() {
        return postDao.getPosts();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Post getPost(@PathVariable int id) {
        return postDao.getPost(id);
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public Post addPost(@RequestBody Post postData){
        return postDao.createPost(postData);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable int id) {
        postDao.deletePost(id);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public Post updatePost(@PathVariable int id, @RequestBody Post postData) {
        return postDao.updatePost(id, postData);
    }

}
