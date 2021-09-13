package com.eksamen02x001.demo.controllers;

import com.eksamen02x001.demo.models.TaskModel;
import com.eksamen02x001.demo.repository.TaskRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TaskController {

    private TaskRepository taskRepositoryInstanceForController = new TaskRepository();

    @GetMapping("createnewtask")
    public String createNewTask(){
        return "createNewTask.html";
    }

    @PostMapping("createnewtask")
    public String createNewTask(@RequestParam(name="taskName") String TaskName,
                                @RequestParam(name="taskDescription") String TaskDescription,
                                @RequestParam(name="taskTimeEstimate") int taskTimeEstimate,
                                @RequestParam(name="taskParentProjectId") int taskParentProjectId
                                ){

        int IDForNewTaskMustBeOneHigherThanHighestCurrentTaskID = 0;
        IDForNewTaskMustBeOneHigherThanHighestCurrentTaskID = taskRepositoryInstanceForController.getHighestNumberOfTaskIDAndAddOne();

    TaskModel newTempTask = new TaskModel(IDForNewTaskMustBeOneHigherThanHighestCurrentTaskID, TaskName, TaskDescription, taskParentProjectId, taskTimeEstimate,0);
        taskRepositoryInstanceForController.addTaskToDB(newTempTask);

        return "redirect:";
    }

    @PostMapping("marktaskasdone")
    public String markTaskAsDone(@RequestParam(name="taskIDnumber") int taskIDnumber){
        taskRepositoryInstanceForController.markTaskAsDone(taskIDnumber);

        return "redirect:";
    }
}
