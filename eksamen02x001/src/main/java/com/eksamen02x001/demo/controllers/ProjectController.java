package com.eksamen02x001.demo.controllers;

import com.eksamen02x001.demo.models.Project;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class ProjectController {

    private ArrayList<Project> ProjectArrayList = new ArrayList<>();
    Project newProject = new Project("yes", "sex");

    @GetMapping("/project")
    public String greeting(
                           Model model
                           ) {

        model.addAttribute("ProjectArrayList", ProjectArrayList);
        return "project.html";
    }

    @PostMapping("/addProject")
      public String addproject(@RequestParam(name="projectName", required=false) String projectName,
                            @RequestParam(name="projectDescription", required=false) String projectDescription,
                            Model model){
        Project newProject = new Project(projectName, projectDescription);

        ProjectArrayList.add(newProject);
        model.addAttribute("ProjectArrayList", ProjectArrayList);
    ProjectArrayList.add(newProject);
    return "redirect:";
    }

    @GetMapping("/addproject")
    public String foo(){
        return "addproject.html";
    }


}
