package com.ftf.ftfProject.beforecontroller.UserController;


import com.ftf.ftfProject.entity.Users;
import com.ftf.ftfProject.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/beforeuser")
public class LoginController {

    @Autowired
    private UserServiceImpl userService;

    //登录
    @RequestMapping("/login")
    public String login(Users user) {
//        System.out.println(user);
        return userService.login(user);
    }

    @RequestMapping("/getuser")
    @ResponseBody
    public Users getUser(Integer userId){
        System.out.println(userId);
        Users users = userService.getUser(userId);
        System.out.println(users);
        return users;
    }
}
