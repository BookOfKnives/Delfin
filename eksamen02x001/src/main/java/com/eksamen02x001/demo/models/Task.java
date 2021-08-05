package com.eksamen02x001.demo.models;

public class Task {

    private int id;
    private String title;
    private String description;

    protected Task() {
    }

    public Task(String title, String description) {
        this.id = 01;
        this.title = title;
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("Task[id=%d, title='%s']", id, title);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}