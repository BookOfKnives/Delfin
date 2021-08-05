package com.eksamen02x001.demo.controllers;

import com.eksamen02x001.demo.models.Project;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class TaskController {

    private ArrayList<Project> projectArrayList = new ArrayList<>();
    Project newProject = new Project("yes", "sex");


    @GetMapping(value={"/", "/index"})
    public String index() {


    return "index.html";
    }

    @GetMapping("/task")
    public String greeting(
                           Model model
                           ) {

        model.addAttribute("TaskArrayList", projectArrayList);
        return "task.html";
    }

    @PostMapping("/addtask")
      public String addtask(@RequestParam(name="taskName", required=false) String taskName,
                            @RequestParam(name="taskDescription", required=false) String taskDescription,
                            Model model){
        Project newProject = new Project(taskName, taskDescription);

        projectArrayList.add(newProject);
        model.addAttribute("TaskArrayList", projectArrayList);
    projectArrayList.add(newProject);
    return "redirect:";
    }

    @GetMapping("/addtask")
    public String foo(){
        return "addtask.html";
    }


}
