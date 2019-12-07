package com.ftf.ftfProject.beforecontroller;

import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/demo")
public class TestControllerDemo {

//    @ResponseBody
    @RequestMapping("/test")
    public String login(){
        return "login";
    }

}
