package com.techelevator.dao;

import com.techelevator.model.Category;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcCategoryDao implements CategoryDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcCategoryDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Category getCategory(int category_id) {
        Category category = null;
        String sql = "SELECT * FROM category WHERE id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, category_id);
        if (results.next()) {
            category = mapRow(results);
        }
        return category;
    }

    @Override
    public List<Category> getCategories() {
        List<Category> states = new ArrayList<>();
        SqlRowSet results = jdbcTemplate.queryForRowSet("SELECT * FROM category ORDER BY name;");
        while (results.next()) {
            states.add(mapRow(results));
        }
        return states;
    }

    private Category mapRow(SqlRowSet rowSet) {
        Category category = new Category();
        category.setId(rowSet.getInt("id"));
        category.setName(rowSet.getString("name"));
        return category;
    }
}

