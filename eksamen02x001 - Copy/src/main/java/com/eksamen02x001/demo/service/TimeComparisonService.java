package com.eksamen02x001.demo.service;

import com.eksamen02x001.demo.models.ProjectModel;
import com.eksamen02x001.demo.models.TaskModel;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class TimeComparisonService {

    LocalDate localDate;

    public int determineAmountOfDaysBetweenTwoDates(LocalDate currentDate, LocalDate deadline){
        long numberOfDays = 0;
        int numberOfDaysInInt = 0;

        numberOfDays = ChronoUnit.DAYS.between(currentDate, deadline); //antagelse at vi gerne vil have et positivt (>0 tal)
        numberOfDaysInInt = Math.toIntExact(numberOfDays);

        return numberOfDaysInInt;
    }

}
