package com.ftf.ftfProject.service.impl;

import com.ftf.ftfProject.entity.Message;
import com.ftf.ftfProject.mapper.MessageMapper;
import com.ftf.ftfProject.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper messageMapper;

    @Override
    public List<Message> getAllMessage() {
        return messageMapper.getAllMessage();
    }

    @Override
    public List<Message> getMessage(String userNikename, int number) {
        int number1 = (number-1)*5;   //根据页数进行查询条数
        return messageMapper.getMessage(userNikename, number1);
    }

    @Override
    public int getpages(String userNikename) {
        System.out.println(userNikename);
        int total =  messageMapper.getTotal(userNikename);
//        System.out.println("total=" + total);
        return  (total+4)/5;
    }

    @Override
    public String getMessageId(String userNikename, String info) {
        int messageid = messageMapper.getMessageId(userNikename, info);
        return String.valueOf(messageid);
    }

    @Override
    public int getMessageTotal() {
        return messageMapper.getMessageTotal();
    }

    @Override
    public Boolean saveMessage(Message message) {
        int i = messageMapper.saveMessage(message);
        if (i == 1){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void incAgreenum(String messagesId) {
        messageMapper.incAgreenum(Integer.parseInt(messagesId));
    }

    @Override
    public void decreAgreenum(String messagesId) {
        messageMapper.decreaAgreenum(Integer.parseInt(messagesId));
    }

    @Override
    public void incReadnum(String messagesId) {
        messageMapper.incReadnum(Integer.parseInt(messagesId));
    }

    @Override
    public Boolean deletemessage(Integer messageId) {
        int i = messageMapper.deleteMessage(messageId);
        if (i == 1){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public String getnameandinfo(String messageId) {
        String info = messageMapper.getinfo(Integer.parseInt(messageId));
        String username = messageMapper.getusername(Integer.parseInt(messageId));
        System.out.println(username+":\n"+info);
        return username+":\n"+info;
    }
}
