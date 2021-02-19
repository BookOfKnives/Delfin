package com.movieanaly.services;

import com.movieanaly.model.Movie;

import java.io.File;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    ArrayList<Movie> ALM = new ArrayList<>();
    File file = new File("src/main/resources/static/film-new.csv");
    Scanner sc;
    public FileHandler(){

        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("fil ikke fundet i FileHandler scanner");
        }
    }

    public ArrayList<Movie> lavMovieObjectArrayList() {
     sc.nextLine();
     sc.nextLine();
     while (sc.hasNextLine()) {
         String[] movieArray = sc.nextLine().split(";");
         Movie movie = new Movie(Integer.parseInt(movieArray[0]), Integer.parseInt(movieArray[1]), movieArray[2], movieArray[3], Integer.parseInt(movieArray[4]), parseMovieBoolean(movieArray[5]));
         ALM.add(movie);
     }
        return ALM;
    }

    private boolean parseMovieBoolean(String s) {
        if (s.equalsIgnoreCase("yes")) return true;
        else return false;

    }
}
