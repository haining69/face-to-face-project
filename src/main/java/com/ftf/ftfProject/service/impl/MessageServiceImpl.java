package com.ftf.ftfProject.service.impl;

import com.ftf.ftfProject.entity.Message;
import com.ftf.ftfProject.mapper.MessageMapper;
import com.ftf.ftfProject.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        int number1 = (number-1)*10;   //根据页数进行查询条数
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
    public void deletemessage(String messageId) {
        messageMapper.deleteMessage(Integer.parseInt(messageId));
    }
}
