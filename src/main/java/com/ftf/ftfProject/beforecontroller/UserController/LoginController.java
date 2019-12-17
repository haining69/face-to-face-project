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
    public Users login(Users user) {
//        System.out.println(user);
//        Users user = new Users();
//        user.setUserNikename("tcp666");
//        user.setUserPassword("tcp666666");
        Users users =  userService.login(user);
//        System.out.println(users.toString());
        return users;
    }

    @RequestMapping("/getuser")
    @ResponseBody
    public Users getUser(Integer userId){
        Users users = userService.getUser(userId);
        if (users != null){
            return users;
        }
        return null;

    }
}
