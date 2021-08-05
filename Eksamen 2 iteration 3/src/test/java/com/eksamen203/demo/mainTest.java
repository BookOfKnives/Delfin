package com.eksamen203.demo;

import com.eksamen203.demo.mainControl.mainController;
import com.eksamen203.demo.model.Task;
import com.eksamen203.demo.services.ProjectCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class mainTest {
    private mainController mainC;
    private ArrayList<Task> testTaskArrayList;

    @BeforeEach public void initAll(){
        mainController mainC = new mainController();
        Task testTask01 = mainC.createNewTaskObject("et", "this task is a SQL task.", 5, 10, 500);
        Task testTask02 = mainC.createNewTaskObject("to", "this task is a SQL task.", 7, 40, 600);
        Task testTask03 = mainC.createNewTaskObject("tre", "this task is a SQL task.", 7, 80, 600);
        Task testTask04 = mainC.createNewTaskObject("fire", "this task is a SQL task.", 9, 35, 700);

        testTaskArrayList = new ArrayList<>();
        testTaskArrayList.add(testTask01);
        testTaskArrayList.add(testTask02);
        testTaskArrayList.add(testTask03);
        testTaskArrayList.add(testTask04);
    }
    @Test public void testGetDateFunctionOfTask() {
        assertEquals(20, testTaskArrayList.get(0).getTaskDate());
    }
    @Test public void testCalculationOfTotalTaskTime(){
        assertEquals(165,ProjectCalculator.calculateAllTasksTimeToFinish(testTaskArrayList));
    }
    @Test public void testCalculateBudget(){
        assertEquals(2400, ProjectCalculator.calculateAllTasksTotalBudget(testTaskArrayList));
    }
    @Test public void testAtArrayListOfTasksFindes() {
        assertFalse(testTaskArrayList.isEmpty());
    }
        @Test public void testTaskName(){
            assertEquals("text for testing getName function of Task. Expected to fail.", testTaskArrayList.get(1).getTaskName());
        }
    }

