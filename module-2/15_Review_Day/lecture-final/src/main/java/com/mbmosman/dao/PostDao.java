package com.mbmosman.dao;

import com.mbmosman.model.Post;

import java.util.List;

public interface PostDao {

    Post createPost(Post data);

    List<Post> getPosts();

    Post getPost(int id);

    Post updatePost(int id, Post data);

    void deletePost(int id);
}
