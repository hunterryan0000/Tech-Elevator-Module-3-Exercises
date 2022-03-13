package com.mbmosman.dao;

import com.mbmosman.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPostDao implements PostDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Post createPost(Post postData) {
        String sql = "INSERT INTO post (title, text) VALUES (?, ?) RETURNING id;";
        Integer id = jdbcTemplate.queryForObject(sql, Integer.class, postData.getTitle(), postData.getText());
        return getPost(id);
    }

    @Override
    public List<Post> getAllPosts() {
        return null;
    }

    @Override
    public List<Post> getPostsForUser(int userID) {
        return null;
    }

    @Override
    public List<Post> getPosts() {
        String sql = "SELECT * FROM post ORDER BY create_date;";
        SqlRowSet resultSet = jdbcTemplate.queryForRowSet(sql);

        List<Post> results = new ArrayList<>();
        while (resultSet.next()) {
            results.add( mapRowToPost(resultSet) );
        }
        return results;
    }

    @Override
    public Post getPost(int id) {
        String sql = "SELECT * FROM post WHERE id = ?;";
        SqlRowSet resultSet = jdbcTemplate.queryForRowSet(sql, id);

        Post result = null;
        if (resultSet.next()) {
            result = mapRowToPost(resultSet);
        }
        return result;
    }

    @Override
    public Post updatePost(int id, Post postData) {
        String sql = "UPDATE post SET title=?, text=? WHERE id=?;";
        jdbcTemplate.update(sql, postData.getTitle(), postData.getText(), id);
        return getPost(id);
    }

    @Override
    public void deletePost(int id) {
        String sql = "DELETE FROM post WHERE id = ?;";
        jdbcTemplate.update(sql, id);
    }

    private Post mapRowToPost(SqlRowSet resultSet) {
        Post post = new Post();
        post.setId(resultSet.getInt("id"));
        post.setTitle(resultSet.getString("title"));
        post.setText(resultSet.getString("text"));
        Date createDate = resultSet.getDate("create_date");
        if (createDate != null) {
            post.setCreateDate(createDate.toLocalDate());
        }
        return post;
    }
}
