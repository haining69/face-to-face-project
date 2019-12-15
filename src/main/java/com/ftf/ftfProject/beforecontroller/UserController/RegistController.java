package com.ftf.ftfProject.beforecontroller.UserController;


import com.ftf.ftfProject.Tools.Pack;
import com.ftf.ftfProject.entity.Users;
import com.ftf.ftfProject.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Controller
@ResponseBody
@RequestMapping("/beforeuser")
public class RegistController {

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private Pack PackUser;

    /**
     * 注册，如果成功返回true
     * 负责返回false
     * @param userEmail
     * @param userNikename
     * @param userPassword
     * @return
     */
    @RequestMapping("/register")
    @ResponseBody
    public String  register(String userEmail, String userNikename, String userPassword){
        Users user = PackUser.PackUser(userEmail, userNikename, userPassword);
        if (userService.register(user)){  //如果注册成功，则返回true
            return "true";
        }else {
            return "false";
        }
    }



    //进行验证码  验证
    @RequestMapping("/verify")
    @ResponseBody
    public String verify(Users user) throws MessagingException {
        if (!userService.findByUsername(user)&&!userService.findByEmail(user)){
            String verify = userService.verify(user.getUserEmail());
            return verify;
        }else{
            return "用户名已存在";
        }
    }

}
