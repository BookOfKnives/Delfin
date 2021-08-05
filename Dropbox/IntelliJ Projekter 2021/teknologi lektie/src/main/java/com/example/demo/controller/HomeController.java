package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
//0603 2021
//forsøg på at lære at bruge thymeleaf til at opbevare brugerindputtet citat.
@Controller
public class HomeController {

    @GetMapping("/index")
    public String indexGet() {      return "index";
    }

    @GetMapping("/index")
    @ResponseBody
    public String tagImodCitat(HttpServletRequest request) {
        HttpSession session = request.getSession();
        //læring starter lowlevel? lowlevel er at kopiere kode
        session.setAttribute("hans", "typeObject o");

        return "index";
    }

    @GetMapping("/citat")
    public String citatGet(){
        return "citat";
    }
}
