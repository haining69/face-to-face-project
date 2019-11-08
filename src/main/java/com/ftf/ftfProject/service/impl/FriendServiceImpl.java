package com.ftf.ftfProject.service.impl;

import com.ftf.ftfProject.entity.Friend;
import com.ftf.ftfProject.mapper.FriendMapper;
import com.ftf.ftfProject.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FriendServiceImpl implements FriendService {

    @Autowired
    private FriendMapper friendMapper;

    @Override
    public List<Friend> getAllFriend() {
        return friendMapper.findAll();
    }
}
