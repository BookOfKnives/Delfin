package com.eksamen02x001.demo.models;

public class TaskModel {
    private int taskID;
    private String taskName;
    private String taskDescription;
    private int taskProjectParentID;
    private int taskNumberOfDaysToCompletionEstimate;
    private int taskCompletionStatus;


    public TaskModel(int taskID,
                    String taskName,
                     String taskDescription,
                     int taskProjectParentID,
                     int taskNumberOfDaysToCompletionEstimate,
                     int taskCompletionStatus
                     ) {
        this.taskID = taskID;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskProjectParentID = taskProjectParentID;
        this.taskNumberOfDaysToCompletionEstimate = taskNumberOfDaysToCompletionEstimate;
        this.taskCompletionStatus = taskCompletionStatus;
            }



    public String getTaskName() {
        return taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public int getTaskProjectParentID() {
        return taskProjectParentID;
    }

    public int getNumberOfDaysToCompletionEstimate() {
        return taskNumberOfDaysToCompletionEstimate;
    }

    public int isTaskCompletionStatus() {
        return taskCompletionStatus;
    }

    public int getTaskID() {return taskID;}
}
