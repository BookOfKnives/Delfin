package com.eksamen2002.demo.mainController;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

//0805 2021 2. iteration af 2. semester eksamensprojekt
@Controller
public class mainController {

    @GetMapping("/first")
    public String first(){
        return "thisIndex";
    }

    @PostMapping("/submitTask")
    public String second(Model dataModel, @RequestParam(name="taskname") String taskName, @RequestParam(name="taskdesc") String taskDesc)
    {
        dataModel.addAttribute("ModelTaskName", taskName);
        return "submitTask";}

}
