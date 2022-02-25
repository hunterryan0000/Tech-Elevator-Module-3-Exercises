package com.techelevator.model;

public class SubTask {

    private int id;
    private int taskId;
    private String description;
    private boolean complete;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    @Override
    public String toString() {
        return String.format(" (ID: %d) %s, %s",
                getId(), getDescription(), (isComplete() ? "Completed" : "Incomplete"));
    }
}
