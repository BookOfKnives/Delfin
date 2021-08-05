package com.eksamen203.demo.model;

import java.util.ArrayList;

public class Task {

    private ArrayList<Task> TaskArrayList;
    private String taskName;
    private String taskDescription;
    private int taskDate;
    private int taskTime;
    private int taskBudget;

    public Task(){
        this.taskDate = 20;
        this.taskTime = 5;
        this.taskBudget = 5000;
        this.taskName = "Default.";
        this.taskDescription = "default descirption.";

    }
    public Task(String name, String taskDescription, int date, int time, int budget){
        this.taskName = name;
        this.taskDescription = taskDescription;
        this.taskDate = date;
        this.taskTime = time;
        this.taskBudget = budget;
    }

    public int getTaskDate(){
        return taskDate;
    }

    public int getTaskTime() {
        return taskTime;
    }

    public int getBudget() {
        return taskBudget;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }
}
