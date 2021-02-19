package com.movieanaly.services;

import com.movieanaly.model.Movie;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class testclass { //det her er min testklasse, heri tester jeg mine funktioner

    FileHandler fhTest; //FileHandler objekt, den læser csv-filen og laver et arrayList
    ArrayList<Movie> ALM; //dette er ArrayListen
    @Before
    public void setup(){ //denne metode kaldes før enhver test, den initiaislierer filehandleren og arrayListen
        fhTest = new FileHandler();
        ALM = fhTest.lavMovieObjectArrayList();
    }

    @Test
    public void testAtViKanToStringeFraMovieOBjTilArrayList(){ //første test. Printer første, anden og tredje film på listen.

        System.out.println(ALM.get(0).toString());
        System.out.println(ALM.get(1).toString());
        System.out.println(ALM.get(2).toString());
    }
    @Test
    public void testTiTilfældigeService(){ //anden test. Printer ti tilfældige film, sortert ascenderende efter popularitet.
                TilfældigeTiFilmService ttfm = new TilfældigeTiFilmService(ALM);
        ArrayList<Movie> tiFilm = ttfm.lavNyTilfældigArray();
        for (Movie m :
                tiFilm) {
            System.out.println(m.toString());
        }
    }
    @Test
    public void testHowManyMoviesHaveAwards(){ //tredje test. Printer antal film med awards = true.
        HowManyWonAwardService HowMany = new HowManyWonAwardService(ALM);
        System.out.println(HowMany.HowManyMoviesHaveAwards());
    }

}
