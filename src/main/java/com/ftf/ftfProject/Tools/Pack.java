package com.ftf.ftfProject.Tools;

import com.ftf.ftfProject.entity.Message;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Pack {
    public Message PackMessage(String info){
        Message message = new Message();
        message.setMessagesInfo(info);
        message.setMessagesAgreenum(0);  //赞同数
        message.setMessagesCollectnum(0);  //收藏数
        message.setMessagesCommentnum(0);  //评论数
        message.setMessagestate(0);    //状态
        message.setMessagesTime(new Date());  //时间戳
        message.setMessagesTranspondnum(0);  //转发数
        message.setMessagesReadnum(0);    //阅读数
        return message;
    }
}
