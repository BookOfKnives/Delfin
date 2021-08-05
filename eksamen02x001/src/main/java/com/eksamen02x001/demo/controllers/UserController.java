package com.eksamen02x001.demo.controllers;

import com.eksamen02x001.demo.models.Project;
import com.eksamen02x001.demo.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class UserController {

    private ArrayList<User> UserArrayList = new ArrayList<>();



    @GetMapping("/User")
    public String greeting(
                           Model model
                           ) {

        model.addAttribute("UserArrayList", UserArrayList);
        return "User.html";
    }

   @PostMapping("/addUser")
      public String addtask(@RequestParam(name="UserName", required=false) String userName,
                            @RequestParam(name="UserDescription", required=false) String userDescription,
                            Model model){
        User tempUser = new User(userName, userDescription);

        UserArrayList.add(tempUser);
        model.addAttribute("UserArrayList", UserArrayList);
       UserArrayList.add(tempUser);
    return "redirect:";
    }

    @GetMapping("/adduser")
    public String foo(){
        return "adduser.html";
    }


}
