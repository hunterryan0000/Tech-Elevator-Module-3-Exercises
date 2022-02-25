package com.techelevator.dao;

import com.techelevator.model.SubTask;

import java.util.List;

public interface SubTaskDao {

    SubTask getSubTask(int parkId);

    List<SubTask> getSubTasksByTask(int taskId);

    SubTask createSubTask(SubTask park);

    void updateSubTask(SubTask park);

    void deleteSubTask(int parkId);

}
