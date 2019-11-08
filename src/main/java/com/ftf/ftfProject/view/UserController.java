package com.ftf.ftfProject.view;


import com.ftf.ftfProject.entity.*;
import com.ftf.ftfProject.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/view")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    //进入登录页面
    @RequestMapping("/index")
    public String index() {
        System.out.println("hahahahahaha");
        return "login2";
    }

    //登录
    @RequestMapping("/login")
    public Boolean login(Users user) {
        System.out.println(user);
        Boolean a = userService.login(user);
        System.out.println(a);
        return a;
    }

    //注册
    @RequestMapping("/register")
    public void register(Users user){
        user.setUserTime(new Date());
        System.out.println(user.getUserTime());
        userService.register(user);
    }



    //根据用户名进行查找
    @RequestMapping("/findByUsername")
    public Boolean findByUsername(Users user){
        return userService.findByUsername(user);
    }

    //进行验证码
    @RequestMapping("/verify")
    public void verify(Users user, HttpServletResponse response) throws IOException, MessagingException {
        if (userService.findByUsername(user)&&userService.findByEmail(user)){
            String verify = userService.verify(user.getUserEmail());
            response.getWriter().write(verify);
        }else{
            response.getWriter().print("用户名已存在");
        }
    }


    /**
     * 找回密码
     * @return
     */

    @RequestMapping("/forget")
    public void forgetpaw(Users user){

    }


    @RequestMapping("user")
    public List<Users> getAllUsert() {
        return userService.selectAll();
    }
}
