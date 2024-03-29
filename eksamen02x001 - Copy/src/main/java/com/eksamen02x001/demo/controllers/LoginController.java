package com.eksamen02x001.demo.controllers;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
@Controller
public class LoginController {

    @GetMapping(value={"/", "/index.html", "/index"})
    public String index(HttpServletRequest request)
    {
        String username ="";

        HttpSession session = request.getSession();
        username = (String) session.getAttribute("CurrentSessionUserName");
        if (username == null) return "login.html";
        //username = "default test";//sat username til dfealt for at gøre testning lettere
        session.setAttribute("CurrentSessionUserName", username);

        return "index.html";
    }

    @PostMapping("/login")
    public String login(HttpServletRequest request,
                        @RequestParam(name="username") String username) {

        HttpSession session = request.getSession();
        session.setAttribute("CurrentSessionUserName", username);
        System.out.println("username set to: "+ username);

        return "redirect:";
    }

}

