package com.ftf.ftfProject.service.impl;

import com.ftf.ftfProject.entity.UserChat;
import com.ftf.ftfProject.mapper.UserChatMapper;
import com.ftf.ftfProject.service.UserChatService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserChatServiceImpl implements UserChatService {

    @Autowired
    private UserChatMapper userChatMapper;

    @Override
    public List<UserChat> getAllUserChat() {
        return userChatMapper.findAll();
    }
}
