package com.thymeleaftest01.demo.MainControlle;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class maincontroller {


    @GetMapping("/test")//test af if:thymeleaf
    public String isGenderTest(Model dataModel){
        Boolean gender = true;
        Boolean gender2 = false;
        dataModel.addAttribute("df", gender);
        dataModel.addAttribute("df2", gender2);
        return "test";
    }
    @GetMapping("/testdata")
    public String isGenderTest2(Model dataModel){
        String gender = "dette er gender tekst";
        dataModel.addAttribute("gender2", gender);
        return "TestAfData01";
    }
}
