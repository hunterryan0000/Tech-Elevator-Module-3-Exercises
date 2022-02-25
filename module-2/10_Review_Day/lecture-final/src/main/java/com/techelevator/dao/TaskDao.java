package com.techelevator.dao;

import com.techelevator.model.Task;

import java.util.List;

public interface TaskDao {

    Task getTask(int taskId);

    List<Task> getAllTasks();

    Task createTask(Task task);

    void updateTask(Task task);

    void deleteTask(int taskId);
}
