package com.eksamen02x003.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private Date startDate;
    private Date stopDate;

    protected Project() {
    }

    public Project(String title, String description, Date startDate, Date stopDate) {
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.stopDate = stopDate;
    }

    @Override
    public String toString() {
        return String.format("Project[id=%d, title='%s']", id, title);
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

    public Date getStartDate() {
        return startDate;
    }

    public Date getStopDate() {
        return stopDate;
    }
}
