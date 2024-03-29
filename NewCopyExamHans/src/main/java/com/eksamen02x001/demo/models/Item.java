package com.eksamen02x001.demo.models;

public class Item {

    private int id;
    private String title;
    private String description;

    protected Item() {
    }

    public Item(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }
    public Item(String title, String description) { //constructor uden id-input
        this.id = 070707;
        this.title = title;
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("Item[id=%d, title='%s']", id, title);
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