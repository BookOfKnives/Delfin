package com.eksamen203.demo.services;

import com.eksamen203.demo.model.Task;

import java.util.ArrayList;

public class ProjectCalculator {
    public static int calculateAllTasksTimeToFinish(ArrayList<Task> testTaskArrayList) {
        int totalResult =0;
        for (Task t: testTaskArrayList
             ) {totalResult += t.getTaskTime();
            
        }
        return totalResult;
    }

    public static int calculateAllTasksTotalBudget(ArrayList<Task> testTaskArrayList) {
        int budgetResult = 0;
        for(Task t : testTaskArrayList){
            budgetResult += t.getBudget();
        } return budgetResult;
    }
}
