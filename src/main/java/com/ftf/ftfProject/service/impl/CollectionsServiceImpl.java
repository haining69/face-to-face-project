package com.ftf.ftfProject.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ftf.ftfProject.entity.Collections;
import com.ftf.ftfProject.entity.Img;
import com.ftf.ftfProject.entity.Message;
import com.ftf.ftfProject.entity.Users;
import com.ftf.ftfProject.mapper.CollectionsMapper;
import com.ftf.ftfProject.metaclass.MessageAndImgs;
import com.ftf.ftfProject.metaclass.MessageAndUsers;
import com.ftf.ftfProject.service.CollectionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CollectionsServiceImpl implements CollectionsService {

    @Autowired
    private CollectionsMapper collectionsMapper;
    @Autowired
    private  MessageServiceImpl messageService;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private ImgServiceImpl imgService;


    @Override
    public String  saveCollection(Collections collections) {
        int i = collectionsMapper.saveCollection(collections);
        if (i == 1){
            return "true";
        }else {
            return "false";
        }
    }

    @Override
    public Boolean selectByUserIdAndMessageId(Integer messageId, Integer userId) {
        Collections collections =  collectionsMapper.selectByUserId(messageId, userId);
        if (collections != null){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<MessageAndUsers> getCollection(Integer userId, Integer pagenum) {
        int number1 = (pagenum-1)*5;   //根据页数进行查询条数
        List<MessageAndUsers> messageAndUsers = new ArrayList<>();  //
        List<Collections> collections = collectionsMapper.getCollections(userId, number1);
        for (Collections collection : collections) {
            MessageAndUsers messageAndUsers1 = new MessageAndUsers();
            messageAndUsers1.setMessage(messageService.getMessageById(Integer.parseInt(collection.getMessageId())));  //封装message
            messageAndUsers1.setUsers(userService.getUser(userId));  //封装user
            messageAndUsers.add(messageAndUsers1);    //装入List
        }
        return messageAndUsers;
    }

    @Override
    public String getCollectionMessage(Integer messageId) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        MessageAndImgs messageAndImgs = new MessageAndImgs();
        Message message = messageService.getMessageById(messageId);  //获取message
        Users users = userService.getUser(Integer.parseInt(message.getUserId()));  //获取user
        List<Img> imgs = imgService.getImgs(messageId);  //获取图片
        messageAndImgs.setMessage(message);
        messageAndImgs.setImgs(imgs);
        return "["+objectMapper.writeValueAsString(messageAndImgs)+","+objectMapper.writeValueAsString(users)+"]";

    }


}
