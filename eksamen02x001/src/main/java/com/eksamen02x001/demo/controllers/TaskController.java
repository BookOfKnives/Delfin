package com.eksamen02x001.demo.controllers;

import com.eksamen02x001.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class TaskController {
    @Autowired // This gets the bean called TaskRepository, which is auto-generated by Spring
    private TaskRepository taskRepo;

    @GetMapping("/task")
    public String task(@RequestParam(name = "id", required = false, defaultValue = "TaskId") Integer id, Model model) {
        model.addAttribute("id", id);
        return "task.html";
    }

}