package com.eksamen02x003.controllers;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping("/")
    public void index(HttpServletResponse response) throws IOException {

        response.sendRedirect("/dashboard");

    }
}

