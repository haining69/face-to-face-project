package com.ftf.ftfProject.beforecontroller.MessageController;


import com.alibaba.fastjson.JSONObject;
import com.ftf.ftfProject.entity.Message;
import com.ftf.ftfProject.service.impl.MessageServiceImpl;
import com.ftf.ftfProject.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageServiceImpl messageService;
    @Autowired
    private UserServiceImpl userService;

    /**
     * 根据用户名进行查询该用户的动态信息，并进行分页处理
     * @return
     */
    @RequestMapping("/getmessage")
    @ResponseBody
    public List<Message> getmessage(String userNikename, int page){  //String userNikename, int number
        int pages = messageService.getpages(userNikename);
        return messageService.getMessage(userNikename, page);
    }

    /**
     * 保存动态
     * @param
     * @return
     */
    @RequestMapping("/savemessage")
    @ResponseBody
    public String saveMessage(HttpServletRequest request){
//        JSONObject jo = new JSONObject();
//        Map<String, String> map = (Map<String, String>)jo.parse(data);
        String info = request.getParameter("info");
        String userNikename = request.getParameter("userNikename");
        Message message = new Message();
        message.setMessagesInfo(info);
        message.setMessagesAgreenum(0);  //赞同数
        message.setMessagesCollectnum(0);  //收藏数
        message.setMessagesCommentnum(0);  //评论数
        message.setMessagestate(0);    //状态
        message.setMessagesTime(new Date());  //时间戳
        message.setMessagesTranspondnum(0);  //转发数
        message.setMessagesReadnum(0);    //阅读数
        message.setUserId(String.valueOf(userService.findByUsername1(userNikename)));
        if (messageService.saveMessage(message) ){  //如果存储成功则进行返回消息id
            String messageid = messageService.getMessageId(userNikename,info);
            return messageid;
        }else {
            return "false";
        }
    }

    /**
     * 删除动态
     */
    @RequestMapping("/deletemessage")
    public void deleteMessage(String messageId){
        messageService.deletemessage(messageId);
    }

    /**
     * 增加该动态的点赞数
     * @param messageId
     */
    @RequestMapping("/incagreenum")
    public void incAgreenum(String messageId){
        messageService.incAgreenum(messageId);
    }

    /**
     * 减少该动态的点赞数
     * @param messageId
     */
    @RequestMapping("/decreagreenum")
    public void decreAgreenum(String messageId){
        messageService.decreAgreenum(messageId);
    }

    /**
     * 增加当前动态的
     * @param messageId
     */
    @RequestMapping("/increadnum")
    public void incReadnum(String messageId){
        messageService.incAgreenum(messageId);
    }
}
