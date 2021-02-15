package com.example.movieanalyser.demo.controller;

import com.example.movieanalyser.demo.services.FileHandler;
import com.example.movieanalyser.demo.model.Movie;
import com.example.movieanalyser.demo.model.MovieModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class moviecontroller {

        FileHandler fh = new FileHandler();
    private int testIntOmAlleKlasserKøres = 0;
    private MovieModel movieModel = new MovieModel();
    private ArrayList<Movie> movieList = new ArrayList<>();

    public void initAll(){
        movieList = fh.readCSVToMakeMovieObjects();
    }

    @ResponseBody
    @GetMapping("/")

    public String helloworld() {
        return "Velkommen til Hans' filmdatabase! Baseret på et-hundrede procent orignal kode! Nul tilsætningsstoffer! Kun 256 farver! ALle pixels opdrættet \n" +
                "på åbne video-arealer med adgang til både CRT- og fladskærme!";
    }

    @ResponseBody
    @GetMapping("/getfirst")
    public String getFirst(){
//        movieList = fh.readCSVToMakeMovieObjects();
//        return movieModel.firstMovie();
        return "test";
    }

    @ResponseBody
    @GetMapping("/getFirstMovie")
    public String firstMovie(){

        return movieList.get(0).toString();
    }
    @ResponseBody
    @GetMapping("/testint")
    public String testString(){
        return "this is a test." + testIntOmAlleKlasserKøres;
    }
    @ResponseBody
    @GetMapping("/fileTest")
    public String fileTest() {
        testIntOmAlleKlasserKøres++;
        try {
            FileHandler fh = new FileHandler();
            return fh.readFileForMakingMovies();
        }
        catch (Exception e){
            System.out.println("fuck this shit, nfile not fount!");
        }return "false";
    }


}
