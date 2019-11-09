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

@Controller
@ResponseBody
@RequestMapping("/beforeuser")
public class ForgetController {

    @Autowired
    private UserServiceImpl userService;

    /**
     * 找回密码
     * @return
     */
    //发送验证码
    @RequestMapping("/sendVerify")
    public String sendVerify(Users user, HttpServletResponse response) throws MessagingException, IOException {
        if (userService.findByEmail(user) != null){
            String verify = userService.verify(user.getUserEmail());
            return verify;
        }else{
            return null;
        }
    }

    //根据用户名进行查找
    @RequestMapping("/findByUsername")
    public Boolean findByUsername(Users user){
        return userService.findByUsername(user);
    }


    //找回密码并且更新密码与用户名
    @RequestMapping("/update")
    public Boolean update(Users user){
//        System.out.println(user);
        return userService.update(user);
    }

}
