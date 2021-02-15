package com.example.movieanalyser.demo.model;

public class Movie {
    private int year;
    private int length;
    private String title;
    private String subject;
    private int popularity;
    private boolean awards;

    public Movie(){}

    public Movie(int year, int length, String title, String subject, int popularity, boolean awards){
        this.year =year;
        this.length=length;
        this.title=title;
        this.subject=subject;
        this.popularity=popularity;
        this.awards=awards;
    }

    public void setYear(int year){
        this.year=year;
    }
    public int getYear() {
        return year;
    }
    public void setLength(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public int getPopularity() {
        return popularity;
    }

    public boolean getAwards() {
        return awards;
    }

    public void setAwards(boolean awards) {
        this.awards = awards;
    }

    @Override
    public String toString() {
        return "THis movie has " + this.subject + ", " + this.title + ", " + this.awards + ", " + this.length + ", " + this.popularity;
    }
}
