package com.ftf.ftfProject.beforecontroller.UserController;


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

    //注册
    @RequestMapping("/register")
    public void register(Users user){
        user.setUserTime(new Date());
        user.setUserImg("http://q2cp0cbhu.bkt.clouddn.com/25df441c-0c52-4f22-b379-68705d721805");  //设置默认头像
//        System.out.println(user.getUserTime());
        userService.register(user);
    }



    //进行验证码  验证
    @RequestMapping("/verify")
    public String verify(Users user, HttpServletResponse response) throws IOException, MessagingException {
        if (!userService.findByUsername(user)&&!userService.findByEmail(user)){
            String verify = userService.verify(user.getUserEmail());
            return verify;
        }else{
            return "用户名已存在";
        }
    }

}
