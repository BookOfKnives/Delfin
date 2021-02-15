package com.example.demo.services;

import java.util.Calendar;

public class erDetFredag {
    private Calendar cal = Calendar.getInstance();
    private int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

    public String jamenErDet() {
        return "Det er " + lavTalletOmDagOmTilNavn(hvadDagErDet()) + " idag.";

    }

    public String lavTalletOmDagOmTilNavn(int dagTal){
        String ugedag = "";
        switch (dagTal) {

            case 1:
                ugedag = "søndag";
                break;
            case 2:
                ugedag = "mandag";
                break;
            case 3:
                ugedag = "tirsdag";
                break;
            case 4:
                ugedag = "onsdag";
                break;
            case 5:
                ugedag = "torsdag";
                break;
            case 6:
                ugedag = "fredag";
                break;
            case 7:
                ugedag = "søndag";
                break;

        }
return ugedag;

    }

    public int hvadDagErDet(){
        return dayOfWeek;
    }

    public boolean ErDetFredagSpørgsmål(){
        return(hvadDagErDet() == 6);

    }
    public String hvisDetErFredag(){
        if(ErDetFredagSpørgsmål()) return("Det errrrrrr FREDDAAGGGGGG!!!!!");
        else return("Det er ikke fredag.");
    }

    public String totalFredagFinal(){
        return "" + jamenErDet() + "\n" + hvisDetErFredag();
    }
}
