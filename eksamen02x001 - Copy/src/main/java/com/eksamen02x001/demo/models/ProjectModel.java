package com.eksamen02x001.demo.models;

import java.time.LocalDate;

public class ProjectModel {

    private int projectid;
    private String projectName;
    private String projectDescription;
    private String projectOwner;
    private int projectOwnerID;
    private LocalDate projectStartDate;
    private LocalDate projectDeadline;
    private int projectCompletionStatus;

    //denne konstruktør er til at lave projektet med i java-logikken. Den henter selv startdato-info fra LocalDate-klassen vha. now()-metoden.
    public ProjectModel(int projectid, String projectName, String projectDescription, String projectOwner,
                       int projectOwnerID,
                        String projectDeadline
                                                ) {
        this.projectid = projectid;
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.projectOwner = projectOwner;
        this.projectOwnerID = projectOwnerID;
        this.projectStartDate = LocalDate.now();
        this.projectDeadline = LocalDate.parse(projectDeadline);
        this.projectCompletionStatus = 0;
    }

    //denne konstruktør er til at hente projekter fra DBen (forskellen er at den modtager dato-information fra DBen)
    public ProjectModel(int projectid, String projectName, String projectDescription, String projectOwner,
                       int projectOwnerID,
                        String projectStartDate, String projectDeadline,
                        int projectCompletionStatus
    )
                        {
        this.projectid = projectid;
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.projectOwner = projectOwner;
        this.projectOwnerID = projectOwnerID;
        this.projectStartDate = LocalDate.parse(projectStartDate);
        this.projectDeadline = LocalDate.parse(projectDeadline);
        this.projectCompletionStatus = projectCompletionStatus;
    }


    public int getProjectid() {
        return projectid;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public String getProjectOwner() {
        return projectOwner;
    }

    public int getProjectOwnerID() {
        return projectOwnerID;
    }

    public LocalDate getProjectStartDate() {
        return projectStartDate;
    }

    public LocalDate getProjectDeadline() {
        return projectDeadline;
    }

    public int isProjectCompletionStatus() {
        return projectCompletionStatus;
    }

    public String returnProjectStartDate(){
        String tempDateString = projectStartDate.toString(); //testmetode til at se om dato fungerer.
        return tempDateString;
    }

    public String returnProjectDeadline(){
        String tempDeadlineString = projectDeadline.toString(); //ditto test for deadline
        return tempDeadlineString;
    }

    @Override
    public String toString(){
        return "This project has name: " + getProjectName() + ", description: "+getProjectDescription()+getProjectOwner()+getProjectid()+getProjectDeadline()+getProjectStartDate();
    }

}
