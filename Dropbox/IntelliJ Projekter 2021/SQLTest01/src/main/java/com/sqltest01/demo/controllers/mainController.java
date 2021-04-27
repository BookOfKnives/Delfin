package com.sqltest01.demo.controllers;

import com.sqltest01.demo.models.Department;
import com.sqltest01.demo.repo.Repo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
//I really hate import statements
@Controller
public class mainController {

    private Repo depoRepo = new Repo();

    @GetMapping(value="/")
    public String testOne(Model dataObject){
        ArrayList<Department> allDept = new ArrayList<>();
        allDept = depoRepo.getAllDepartments();

        dataObject.addAttribute("departments",allDept);

        return "index";
    }
}
