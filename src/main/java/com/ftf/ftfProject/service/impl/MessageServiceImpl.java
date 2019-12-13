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
    public String getMessageId(String userId, String info) {
        int messageid = messageMapper.getMessageId(userId, info);
        return String.valueOf(messageid);
    }

    @Override
    public String getMessageInfo(String messageId) {
        return messageMapper.getinfo(Integer.parseInt(messageId));
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
    public List<Message> getMessagehome() {
        return messageMapper.getMessagehome();
    }

    @Override
    public void incAgreenum(String messagesId) {
        messageMapper.incAgreenum(Integer.parseInt(messagesId));
    }

    @Override
    public void incCollection(Integer messagesId) {
        messageMapper.incColection(messagesId);
    }

    @Override
    public void incTranspond(Integer messagesId) {
        messageMapper.incTranspond(messagesId);
    }

    @Override
    public void incComment(Integer messagesId) {
        messageMapper.incComment(messagesId);
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
//        System.out.println(messageId);
        String info = messageMapper.getinfo(Integer.parseInt(messageId));
        String username = messageMapper.getusername(Integer.parseInt(messageId));
//        System.out.println("转发自："+username+"\n"+info);
        return "转发自："+username+"\n"+info;
    }

    @Override
    public int getUserId(Integer messageId) {
        return 0;
    }

    @Override
    public Boolean selectuserIdAndInfo(String info, String userId) {
        if (messageMapper.selectuserIdAndInfo(userId,info) != null){
            return true;
        }else {
            return false;
        }
    }

}
