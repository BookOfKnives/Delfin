package com.eksamen02x001.demo.controllers;

import com.eksamen02x001.demo.models.ProjectModel;
import com.eksamen02x001.demo.models.TaskModel;
import com.eksamen02x001.demo.repository.ProjectRepository;
import com.eksamen02x001.demo.repository.TaskRepository;
import com.eksamen02x001.demo.service.TimeComparisonService;
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
    private TaskRepository taskRepositoryInstanceForController = new TaskRepository();
    private TimeComparisonService timeComparisonService = new TimeComparisonService();

    @GetMapping(value="/showprojects")
    public String showAllProjects(Model model
                                  ){
        ArrayList<ProjectModel> projectList;

    projectList = projectRepositoryInstanceForController.GetAllProjects();
    model.addAttribute("projectList", projectList);

    return "showProjects.html";
    }

    @GetMapping("/createnewproject")
    public String createNewProject(){
        return "createnewproject.html";
    }

    @PostMapping("/createnewproject")
    public String createNewProject(@RequestParam(name="ProjectName") String ProjectName,
                                   @RequestParam(name="ProjectDescription") String ProjectDescription,
                                   @RequestParam(name="ProjectDeadline") String ProjectDeadline,
                                   HttpServletRequest request
                                    ){
        int IDForTheNewProjectMustAlwaysBeHighest = 0;

        HttpSession session = request.getSession();
        String currentUser = (String) session.getAttribute("CurrentSessionUserName");

        IDForTheNewProjectMustAlwaysBeHighest = projectRepositoryInstanceForController.getHighestNumberOfProjectIdNumberAndAddOne();

        ProjectModel temp = new ProjectModel(IDForTheNewProjectMustAlwaysBeHighest, ProjectName, ProjectDescription, currentUser, 0, ProjectDeadline);
        projectRepositoryInstanceForController.addProjectToDB(temp);
        return "redirect:";
    }


    @PostMapping("/seeoneprojectandtasks")
    public String seeoneprojectandtasks(@RequestParam(name= "numberOfProjectForView") int ProjectNumberID,
                                        Model model)
    {
        int totalNumberOfDaysEstimatedForProjectTasks = 0;
        int numberOfDaysRemainingToDeadline = 0;
        int numberOfDaysRemainingInWhichToCompleteProjectBeforeDeadling = 0;

        ArrayList<ProjectModel> projectList = projectRepositoryInstanceForController.getOneProject(ProjectNumberID);
        model.addAttribute("oneProject", projectList); //selvom det er et array, har det kun et index.

        ArrayList<TaskModel> taskList = taskRepositoryInstanceForController.getAllTasksAssociatedWithProject(ProjectNumberID);
        model.addAttribute("oneProjectTaskList", taskList);

        for(TaskModel t:taskList){
            totalNumberOfDaysEstimatedForProjectTasks += t.getNumberOfDaysToCompletionEstimate();
        }

        LocalDate projectDeadline = projectList.get(0).getProjectDeadline();
        numberOfDaysRemainingToDeadline = timeComparisonService.determineAmountOfDaysBetweenTwoDates(LocalDate.now(), projectDeadline);

        numberOfDaysRemainingInWhichToCompleteProjectBeforeDeadling = numberOfDaysRemainingToDeadline - totalNumberOfDaysEstimatedForProjectTasks;

        model.addAttribute("numberOfDaysRemainingInWhichToCompleteProjectBeforeDeadling", numberOfDaysRemainingInWhichToCompleteProjectBeforeDeadling); //antal dage tilbage før deadline fra i dag
        model.addAttribute("totalNumberOfDaysEstimatedForProjectTasks", totalNumberOfDaysEstimatedForProjectTasks); //jeg får antallet af tasks-dage
        model.addAttribute("numberOfDaysRemainingToDeadline", numberOfDaysRemainingToDeadline); //number of days left before deadline

        model.addAttribute("currentProjectNumber", ProjectNumberID);

        return "seeoneprojectandtasks.html";
    }
}
