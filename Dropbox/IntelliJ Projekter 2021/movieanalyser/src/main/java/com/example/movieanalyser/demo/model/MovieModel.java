package com.example.movieanalyser.demo.model;

import java.util.ArrayList;

public class MovieModel {
//denne klasse laver film
    ArrayList<Movie> ALMovie = new ArrayList<>();

    public MovieModel(){
           }

    public Movie makeMovie(){
        Movie movie = new Movie();
        return movie;
    }

    public String firstMovie() {
    return "this is the first string from firstMovie";
    }
}
