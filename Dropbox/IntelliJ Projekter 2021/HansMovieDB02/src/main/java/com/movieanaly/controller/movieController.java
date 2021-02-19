package com.movieanaly.controller;

import com.movieanaly.model.Movie;
import com.movieanaly.services.FileHandler;
import com.movieanaly.services.HowManyWonAwardService;
import com.movieanaly.services.TilfældigeTiFilmService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Random;

@Controller
public class movieController {
    FileHandler fh = new FileHandler();
    ArrayList<Movie> ALM = fh.lavMovieObjectArrayList();

    @ResponseBody
    @GetMapping("/")
    public String velkomst(){
        System.out.println("Nogen har tilgået! Det her står i konsollen i IntelliJ og bliver out'et til konsollen, hver gang nogen rammer" +
                "/-endpoint'et på serveren.");
        return "Velkommen til  Hans' database!";
    }

    @ResponseBody
    @GetMapping("/1")
    public String fåFørsteFilm(){ //f'rste opgave. Første film.
        System.out.println("Nogen har tilgået den første film..");
        return ALM.get(0).toString();
    }

    @ResponseBody
    @GetMapping("/2")
    public String fåTilfældigFilm(){ //anden opgave, en tilfældig film.
        Random randomInt = new Random();
        int newRan = randomInt.nextInt((ALM.size()));
        System.out.println("Nogen har tilgået den tilfældige film..");
        return ALM.get(newRan).toString();
    }

    @ResponseBody
    @GetMapping("/3") //tredje opgave, ti tilfældlige film sorteret efter pop.
    public String fåTiTilfældigFilmOgSortérDem(){
        String tilfMovieString = "";
        TilfældigeTiFilmService tilf = new TilfældigeTiFilmService(ALM);
        ArrayList<Movie> tilfArray = tilf.lavNyTilfældigArray();
        for (Movie m :tilfArray
             ) { tilfMovieString += m.toString();
             tilfMovieString += "<br>";
        }
        System.out.println("Nogen har tilgået de ti tilfældige film..");
        return tilfMovieString;
    }
    @ResponseBody
    @GetMapping("/4") //fjerde opgave, hvor mange der har en pris.
    public int fåAntalPriser(){
        HowManyWonAwardService HowMany = new HowManyWonAwardService(ALM);
        System.out.println("Nogen har tilgået hvor mange priser.");
        return HowMany.HowManyMoviesHaveAwards();
    }


}
