package com.example.movieanalyser.demo.services;

import com.example.movieanalyser.demo.model.Movie;

import java.util.ArrayList;
import java.util.Random;

public class MovieHandler {
    private FileHandler fh;
    private ArrayList<Movie> testicles;

    public MovieHandler(){
        fh = new FileHandler();
        testicles = new ArrayList<Movie>();
    ArrayList<Movie> testicles = fh.readCSVToMakeMovieObjects();
    }

    public Movie getMeARandomMovie(){
        Random random = new Random();
        int randomInt = random.nextInt(testicles.size());
        return testicles.get(randomInt);
    }
    public Movie getMeTheFirstMovie(){
        return testicles.get(0);
    }
}
