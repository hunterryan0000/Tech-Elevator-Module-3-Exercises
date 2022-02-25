package com.techelevator.dao;

import com.techelevator.model.Category;
import com.techelevator.model.Task;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class JdbcTaskDao implements TaskDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcTaskDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Task getTask(int taskId) {
        Task task = null;
        String sql = "SELECT task.*, category.id as category_id, category.name as category_name FROM task " +
                "JOIN category on task.category_id = category.id " +
                "WHERE task.id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, taskId);
        if (results.next()) {
            task = mapRow(results);
        }
        return task;
    }

    @Override
    public List<Task> getAllTasks() {
        List<Task> tasks = new ArrayList<>();
        String sql = "SELECT task.*, category.id as category_id, category.name as category_name FROM task " +
                "JOIN category on task.category_id = category.id \n" +
                "ORDER BY complete, due;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            tasks.add(mapRow(results));
        }
        return tasks;
    }

    @Override
    public Task createTask(Task task) {
        String sql = "INSERT INTO task (description, due, complete, category_id) VALUES " +
                "(?, ?, ?, ?) RETURNING id;";
        Integer newId = jdbcTemplate.queryForObject(sql, Integer.class, task.getDescription(), task.getDueDate(),
                task.isComplete(), task.getCategory().getId());

        return getTask(newId);
    }

    @Override
    public void updateTask(Task task) {
        String sql = "UPDATE task SET description=?, due=?, complete=?, category_id=? " +
                "WHERE id=?;";
        jdbcTemplate.update(sql, task.getDescription(), task.getDueDate(),
                task.isComplete(), task.getCategory().getId(), task.getId());
    }

    @Override
    public void deleteTask(int taskId) {
        String sql = "DELETE FROM task WHERE id = ?;";
        jdbcTemplate.update(sql, taskId);
    }

    private Task mapRow(SqlRowSet rowSet) {
        Task task = new Task();
        task.setId(rowSet.getInt("id"));
        task.setDescription(rowSet.getString("description"));
        Date date = rowSet.getDate("created");
        if (date != null){
            task.setCreated(date.toLocalDate());
        }
        date = rowSet.getDate("due");
        if (date != null){
            task.setDueDate(date.toLocalDate());
        }
        task.setComplete(rowSet.getBoolean("complete"));
        Category category = new Category();
        category.setId(rowSet.getInt("category_id"));
        category.setName(rowSet.getString("category_name"));
        task.setCategory(category);
        return task;
    }
}
