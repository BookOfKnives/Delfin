package com.eksamen02x001.demo.controllers;

import com.eksamen02x001.demo.models.ProjectModel;
import com.eksamen02x001.demo.repository.ProjectRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.ArrayList;

@Controller
public class ProjectController {

    private ProjectRepository projectRepositoryInstanceForController = new ProjectRepository();

    @GetMapping(value="/showprojects")
    public String showAllProjects(Model model,
                                  HttpServletRequest request){
    ArrayList<ProjectModel> projectList = projectRepositoryInstanceForController.GetAllProjects();
        System.out.println(projectList.get(0).toString());
        System.out.println(projectList.isEmpty());
    model.addAttribute("projectList", projectList);

//        HttpSession session = request.getSession(); //test af ,etode t ilat  lave nye projekter
//        String username = (String) session.getAttribute("CurrentSessionUserName");
//        projectRepositoryInstanceForController.startNewProjectInDatabaseAndReturnNewProjectID(username);

    return "showProjects.html";
    }

    @GetMapping("/createnewproject")
    public String createNewProject(){
        return "createnewproject.html";
    }

    @PostMapping("/createnewproject")
    public String createNewProject(@RequestParam(name="ProjectName") String ProjectName,
                                   @RequestParam(name="ProjectDescription") String ProjectDescription,
                                   //projectowner fås vha. getsession.current user
                                   //samme med projectowner id? måske er den unødvendig
                                  // startdate fås fra localdate.Now()
                                   @RequestParam(name="ProjectDeadline") String ProjectDeadline,
                                   HttpServletRequest request
                                    ){
        HttpSession session = request.getSession();
        String currentUser = (String) session.getAttribute("CurrentSessionUserName");
        int tempId = projectRepositoryInstanceForController.getHighestNumberOfProjectIdNumberAndAddOne();
        ProjectModel temp = new ProjectModel(tempId, ProjectName, ProjectDescription, currentUser, 0, ProjectDeadline);
        projectRepositoryInstanceForController.addProjectToDB(temp);
        return "redirect:";
    }
}
