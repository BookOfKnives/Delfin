package com.eksamen02x001.demo.models;

import java.time.LocalDate;

public class TaskModel {
    private String taskName;
    private String taskDescription;
    private String taskProjectParentName;
    private int taskProjectParentID;
    private LocalDate taskStartDate;

    public TaskModel(String taskName, String taskDescription, String taskProjectParentName, int taskProjectParentID,
                     LocalDate taskDeadline, boolean taskCompletionStatus) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskProjectParentName = taskProjectParentName;
        this.taskProjectParentID = taskProjectParentID;
        this.taskStartDate = LocalDate.now();
        this.taskDeadline = taskDeadline;
        this.taskCompletionStatus = taskCompletionStatus;
    }

    private LocalDate taskDeadline;
    private boolean taskCompletionStatus;


}
