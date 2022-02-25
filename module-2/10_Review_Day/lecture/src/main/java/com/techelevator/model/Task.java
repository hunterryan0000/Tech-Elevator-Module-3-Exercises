package com.techelevator.model;

import java.time.LocalDate;

public class Task {

    private int id;
    private String description;
    private Category category;
    private LocalDate created;
    private LocalDate dueDate;
    private boolean complete;

    public Task () { }

    protected Task(int id, String description, Category category, LocalDate createdOn, LocalDate dueOn, boolean complete) {
        this.id = id;
        this.description = description;
        this.category = category;
        this.created = createdOn;
        this.dueDate = dueOn;
        this.complete = complete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s, %s (Task ID: %d)",
                getDescription(), getCategory().getName(), "Created on: " + getCreated(),
                (getDueDate() == null ? "No due date" : "Due On: " + getDueDate()),
                (isComplete() ? "Completed" : "Incomplete"), getId());
    }
}
