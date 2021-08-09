package com.eksamen02x003.models;


public class Task {

    private Long id;
    private String title;
    private String description;

    protected Task() {
    }

    public Task(String title, String description) {
        this.title = title;
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("Task[id=%d, title='%s']", id, title);
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
