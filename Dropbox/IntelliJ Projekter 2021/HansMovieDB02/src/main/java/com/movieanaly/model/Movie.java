package com.movieanaly.model;

public class Movie implements Comparable<Movie>{
    private int year;
    private int length;
    private String title;
    private String subject;
    private int popularity;
    private boolean awards;

    public Movie(){}

    public Movie(int year, int length, String title, String subject, int popularity, boolean awards) {
        this.year = year;
        this.length = length;
        this.title = title;
        this.subject = subject;
        this.popularity = popularity;
        this.awards = awards;
    }
    @Override
    public String toString(){
        return "Film, navn: \"" + this.title + "\", udgivelsesår: " + this.year + ", spilletid: " + this.length +
         " minutter, genre: " + this.subject + ", popularitet: " + this.popularity + ". " + this.harDenneFilmFåetAwards();
    }

    private String harDenneFilmFåetAwards() {
        if (getAwards())return "Jeg har vundet priser.";
        else return "Jeg har ikke vundet priser. : (";
    }

    @Override
        public int compareTo(Movie m){
        return this.getPopularity() > m.getPopularity() ? 1 : this.getPopularity() < m.getPopularity() ? -1 : 0;
    }
    public boolean getAwards() {
        return awards;
    }


    public int getPopularity() {
        return popularity;
    }
}
