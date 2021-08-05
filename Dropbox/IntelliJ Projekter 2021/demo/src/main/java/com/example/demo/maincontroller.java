package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class maincontroller {

    private Member member;

    public maincontroller(){
        this.member = new Member();
    }
    //@ResponseBody //forsøg: responsebody gør at HTMLen Ikke GØRES!
    @GetMapping("/")
    public String hello() {
        System.out.println("test");
        return "index";
    }
    @PostMapping(value = "/sign-up")

    public String createNewUser(@RequestParam("name") String name, @RequestParam("mobile") int mobile) {
        return "User created with name: " + name + " and mobile: " + mobile;
    }

    @GetMapping("/x")
    public String x1(Model model){
        model.addAttribute(0001, member);
    }
}
