package com.eksamen205.demo.mainControl;

import com.eksamen205.demo.model.Task;
import com.eksamen205.demo.repo.databaseMethods;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpServerErrorException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

//3005 2021 5. iteration, eksamen 0

@Controller
public class mainController {
    String message = "welcome to the front page.";
    databaseMethods dbM;
    ArrayList<Task> taskList;


    @GetMapping("/")
    public String index(HttpServletRequest request) {
        HttpSession session = request.getSession();

        session.setAttribute("message", message);

        dbM = new databaseMethods();
        return "index.html";
    }

    @PostMapping("/logpost") //der er noget idenne metode som AWS ikke kan
    //lide.
    public String checkUserNameExists
            (@RequestParam("username") String usernameFromLogin,
             HttpServletRequest request,
             Model transferDataToThymeLeaf)
    {
        HttpSession session = request.getSession();
        message = "you are now inside the system.";

        dbM = new databaseMethods();
        System.out.println("start userlog");

        if (dbM.checkIfUserExists(usernameFromLogin)) {
            //System.out.println("password OK");
            session.setAttribute("userNameOnSession", usernameFromLogin);
            message = "You are now logged in," + usernameFromLogin;
            session.setAttribute("message", message);
            taskList = dbM.getAllTasks();
            session.setAttribute("AllTaskList", taskList);
        } else {
            System.out.println("pw NOT ok");
            message = "You are not logged in. Perhaps your username is wrong?";
         //   session.setAttribute("message", message);
            return "/index.html";
        }
     //   session.setAttribute("currentUserName", usernameFromLogin);
        transferDataToThymeLeaf.addAttribute("currentUserName", usernameFromLogin);
        return "loggedIn";
    }

    @PostMapping("/logpost2") //isoleret test-- det viser sig at der er noget
    //i PostMap Logpost checkUserNameExists-metoden, som AWS ikke kan lide.
    //det er if-statementen i linje 43 (se ovenstående).
    public String testTwo(
            @RequestParam("username") String usernameFromLogin,
             HttpServletRequest request)
    {
        HttpSession session = request.getSession();
                dbM = new databaseMethods();
        dbM.checkIfUserExists(usernameFromLogin);
//end 19:57 jeg har fundet ud af at AWS ikke kan lide if-statements
        //det viste sig at være fordi jeg havde installeret en gammel version af Java på AWS


        session.setAttribute("currentUserName", usernameFromLogin);
        return "/loggedIn.html";
    }

    @GetMapping("/loggedIn")
    public String loggedIn(HttpServletRequest request,

                           Model transferDataToThymeleaf){
        HttpSession session = request.getSession();

        String username = (String) session.getAttribute("currentUserName");

        ArrayList<Task> TaskAL = dbM.getAllTasks();

        transferDataToThymeleaf.addAttribute("AllTaskList", TaskAL);
        session.setAttribute("AllTaskList", TaskAL);
        System.out.println("end of loggedin");

        return "loggedIn.html";
    }

    @PostMapping("/createNewTask")
    public String createNewTask(){
        return "error";
    }
}


