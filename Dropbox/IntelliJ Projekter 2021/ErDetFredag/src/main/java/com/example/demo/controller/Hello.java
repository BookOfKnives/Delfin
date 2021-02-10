package com.example.demo.controller;

import com.example.demo.services.erDetFredag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Hello {
    erDetFredag edf = new erDetFredag();
    @ResponseBody
    @GetMapping("test")
    public String testTwo(){
        return edf.totalFredagFinal();
    }

}
