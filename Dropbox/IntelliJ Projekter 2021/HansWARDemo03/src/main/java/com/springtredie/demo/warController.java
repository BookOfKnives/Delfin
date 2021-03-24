package com.springtredie.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import services.HelloService;

@Controller
public class warController {

    HelloService hl = new HelloService();
    @ResponseBody
    @GetMapping("/01")
    public String velkomst(){
        System.out.println("Nu tilgåes noget");
        hl.HelloWorldService();
        return "Hej";
    }
    @ResponseBody
    @GetMapping("/02")
    public String velkomst2(){
        System.out.println("Nu tilgåes noge22222t");
        return hl.HelloWorldService();

    }
}
