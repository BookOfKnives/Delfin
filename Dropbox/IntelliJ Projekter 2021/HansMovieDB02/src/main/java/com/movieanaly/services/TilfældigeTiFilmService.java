package com.movieanaly.services;

import com.movieanaly.model.Movie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class TilfældigeTiFilmService {
    ArrayList<Movie> ALM;
    ArrayList<Movie> AListMedTiFilm = new ArrayList<Movie>();

    public TilfældigeTiFilmService(ArrayList<Movie> ALM){
        this.ALM = ALM;
    }

    public ArrayList<Movie> lavNyTilfældigArray() {
        for (int i = 0; i < 10; i++) {
            Random danrom = new Random();
            AListMedTiFilm.add(ALM.get(danrom.nextInt(ALM.size())));
            Collections.sort(AListMedTiFilm);
        } return AListMedTiFilm;
    }

}
