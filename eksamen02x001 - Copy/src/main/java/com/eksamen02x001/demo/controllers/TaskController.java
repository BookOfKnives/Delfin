package com.eksamen02x001.demo.controllers;

import com.eksamen02x001.demo.models.TaskModel;
import com.eksamen02x001.demo.repository.TaskRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class TaskController {

    private TaskRepository TaskRepository = new TaskRepository();
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

    TaskModel newTempTask = new TaskModel(TaskName, TaskDescription, taskParentProjectId, taskTimeEstimate,0);
        TaskRepository.addTaskToDB(newTempTask);
        return "redirect:";
    }
}
