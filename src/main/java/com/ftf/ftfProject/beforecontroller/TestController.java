package com.ftf.ftfProject.beforecontroller;

import com.ftf.ftfProject.entity.*;
import com.ftf.ftfProject.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/view1")
public class TestController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private CollectionsServiceImpl collectionsService;

    @Autowired
    private CommentsServiceImpl commentsService;

    @Autowired
    private MessageServiceImpl messageService;

    @Autowired
    private RelationServiceImpl relationService;

    //进入登录页面
    @RequestMapping("/index")
    public String index() {
        System.out.println("hahahahahaha");
        return "templates/login";
    }

    //登录
    @RequestMapping("login")
    public String login(Users user) {
        return userService.login(user);
    }

    //注册
    @RequestMapping("/register")
    public void register(Users user){
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
//            System.out.println("wangyongxianfg"+verify);
            response.getWriter().write(verify);
        }else{
            response.getWriter().print("用户名已存在");
        }
    }


    @RequestMapping("user")
    public List<Users> getAllUsert() {
        return userService.selectAll();
    }

    @RequestMapping("collection")
    public List<Collections> getAllCollection() {
        return collectionsService.getCollections();
    }

    @RequestMapping("comment")
    public List<Comments> getAllComment() {
        return commentsService.getAllComments();
    }

    @RequestMapping("message")
    public List<Message> getAllMessage() {
        return messageService.getAllMessage();
    }

    @RequestMapping("relation")
    public List<Relation> getAllRelation() {
        return relationService.getAllRelation();
    }

}
