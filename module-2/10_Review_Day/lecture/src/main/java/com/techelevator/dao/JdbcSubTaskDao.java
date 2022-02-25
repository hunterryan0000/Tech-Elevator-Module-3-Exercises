package com.techelevator.dao;

import com.techelevator.model.SubTask;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcSubTaskDao implements SubTaskDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcSubTaskDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public SubTask getSubTask(int subtaskId) {
        // TODO - used in CLI
        return null;
    }

    @Override
    public List<SubTask> getSubTasksByTask(int taskId) {
        // TODO - used in CLI
        return null;
    }

    @Override
    public SubTask createSubTask(SubTask park) {
        // TODO - Challenge
        return null;
    }

    @Override
    public void updateSubTask(SubTask park) {
        // TODO - Challenge
    }

    @Override
    public void deleteSubTask(int parkId) {
        // TODO - Challenge
    }

    private SubTask mapRow(SqlRowSet rowSet) {
        SubTask subTask = new SubTask();
        // TODO - Fill in mappings
        return subTask;
    }
}
