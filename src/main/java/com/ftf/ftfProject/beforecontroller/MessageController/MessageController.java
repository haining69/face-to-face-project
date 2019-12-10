package com.ftf.ftfProject.beforecontroller.MessageController;


import com.ftf.ftfProject.Tools.Pack;
import com.ftf.ftfProject.entity.Message;
import com.ftf.ftfProject.service.impl.AgreeServiceImpl;
import com.ftf.ftfProject.service.impl.MessageServiceImpl;
import com.ftf.ftfProject.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 动态Controller
 */
@Controller
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageServiceImpl messageService;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private Pack PackMessage;

    /**
     * 我的故事
     * 根据用户名进行查询该用户的动态信息，并进行分页处理
     * @return
     */
    @RequestMapping("/getmessage")
    @ResponseBody
    public List<Message> getmessage(String userNikename, int page){  //String userNikename, int number
        int pages = messageService.getpages(userNikename); // 返回的页数
        return messageService.getMessage(userNikename, page);   //返回查找的动态，每次返回5条记录
    }




    /**
     * 我的故事
     * 保存动态
     * @param
     * @return
     */
    @RequestMapping("/savemessage")
    @ResponseBody
    public String saveMessage(String userNikename,String info){
        Message message = PackMessage.PackMessage(info);
        message.setUserId(String.valueOf(userService.findByUsername1(userNikename)));
        if (messageService.saveMessage(message) ){  //如果存储成功则进行返回消息id
            String messageid = messageService.getMessageId(userNikename,info);
            return messageid;
        }else {
            return "false";
        }
    }

    /**
     * 我的故事
     * 删除动态,如果成功则返回true，否则，反之
     */
    @RequestMapping("/deletemessage")
    @ResponseBody
    public String deleteMessage(Integer id){
        if (messageService.deletemessage(id)){
            return "true";
        }else {
            return "false";
        }
    }


    @RequestMapping("/getmessagehome")
    @ResponseBody
    public List<Message> getmessagehome(){
        return messageService.getMessagehome();
    }

    /**
     * 主页
     * 进行转发
     * @param userNikename
     * @param messageId
     * @return
     */
    @RequestMapping("/transpondmessage")
    public String TranspondMessage(String userNikename, String messageId){  //
        String info = messageService.getnameandinfo(messageId);
        Message message = PackMessage.PackMessage(info);
        message.setUserId(String.valueOf(userService.findByUsername1(userNikename)));
        if (messageService.saveMessage(message) ){  //如果存储成功则进行返回消息id
            String messageid = messageService.getMessageId(userNikename,info);
            return messageid;
        }else {
            return "false";
        }
    }


    /**
     * 主页
     * 增加当前动态的阅读量
     * @param messageId
     */
    @RequestMapping("/increadnum")
    public void incReadnum(String messageId){
        messageService.incAgreenum(messageId);
    }


}
