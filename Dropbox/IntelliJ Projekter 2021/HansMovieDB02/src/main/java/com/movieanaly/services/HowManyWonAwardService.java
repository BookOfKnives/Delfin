package com.movieanaly.services;

import com.movieanaly.model.Movie;

import java.util.ArrayList;

public class HowManyWonAwardService {
    ArrayList<Movie> ALM;
    int antalFilmMedAwards = 0;

    public HowManyWonAwardService(ArrayList<Movie> ALM){
        this.ALM = ALM;
    }

    public int HowManyMoviesHaveAwards(){
        for (Movie m :
                ALM) {
            if (m.getAwards()) antalFilmMedAwards++;
        }return antalFilmMedAwards;
    }
}
