package com.wartest06.demo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WARControl {

    @ResponseBody
    @GetMapping("/1")
    public String hello1(){
        return "Hello fra totalControl";
    }
}
