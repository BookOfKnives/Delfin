package com.eksamen203.demo.mainControl;


import com.eksamen203.demo.model.Task;
import com.eksamen203.demo.repositories.mainRepo;
import com.eksamen203.demo.services.DatabaseConnection;
import com.eksamen203.demo.services.InputReader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.util.ArrayList;

//1405 2021 Eksamen 2 iteration 3
//hovedsagen er UDREGNINGEN af projektet.
@Controller
public class mainController {
    private mainRepo mainRepo = new mainRepo();
     private ArrayList<Task> taskArrayList = new ArrayList<>();

    public Task createNewTaskObject(String name, String desc, int date, int time, int budget) {
        Task task = new Task(name, desc, date, time, budget);

        return task;
    }
        @GetMapping("/")
        public String GetTaskFromUser(Model datamodel){
            datamodel.addAttribute("taskArrayList", taskArrayList);
        return "getusertask";

        }
//        @PostMapping("/TaskReceived")
//    public String ReceiveTaskFromUser(@RequestParam("taskName") String taskName, @RequestParam("taskDesc") String taskDesc, HttpServletRequest request){
//
//        String testPath = request.getContextPath();
//        taskArrayList.add(createNewTaskObject(taskName, taskDesc, 0, 0, 0));
//        return "redirect:/"+testPath;
//        }
//        @PostMapping("/TaskReceived")
//    public String ReceiveTaskFromUser(@RequestParam("taskName") String taskName, @RequestParam("taskDesc") String taskDesc, HttpServletRequest request){
//        System.out.println("task reccc");
//        String testPath = request.getContextPath();
//        taskArrayList.add(createNewTaskObject(taskName, taskDesc, 0, 0, 0));
//        return "redirect:/"; //uden testpath
//        }
//

//        @PostMapping("/TaskReceived") //version 2, til SQL istedet for arraylist
//    public String ReceiveTaskFromUser(@RequestParam("TaskName") String taskName, @RequestParam("TaskDesc") String taskDesc, HttpServletRequest request){
//        System.out.println("task reccc");
//        String testPath = request.getContextPath();
//        mainRepo.checkTables();
//        taskArrayList.add(createNewTaskObject(taskName, taskDesc, 0, 0, 0));
//        return "redirect:/"; //uden testpath
//        }

        @PostMapping("/TaskReceived") //version 3, til sql db
    public String ReceiveTaskFromUser(@RequestParam("TaskName") String taskName, @RequestParam("TaskDesc") String taskDesc, HttpServletRequest request){
        System.out.println("til SQL DB rec");

        mainRepo.createNewTask("Job one");

        return "redirect:/"; //uden testpath
        }

        @GetMapping("/deleteMostRecentTask")
    public String DeleteMostRecentTask(){
            System.out.println("deleteMostRecentTask hit");
        taskArrayList = new ArrayList<>();
        return "redirect:/";
        }

    }

