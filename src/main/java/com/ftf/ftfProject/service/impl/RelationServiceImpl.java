package com.ftf.ftfProject.service.impl;

import com.ftf.ftfProject.entity.Relation;
import com.ftf.ftfProject.entity.Users;
import com.ftf.ftfProject.mapper.RelationMapper;
import com.ftf.ftfProject.service.RelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RelationServiceImpl implements RelationService {

    @Autowired
    private RelationMapper relationMapper;
    @Autowired
    private UserServiceImpl userService;

    @Override
    public List<Relation> getAllRelation() {
        return relationMapper.getAllRelation();
    }

    @Override
    public Boolean saveRelation(Relation relation) {
        int i = relationMapper.saveRelation(relation);
        System.out.println(i);
        if (i == 1){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Boolean selectByUserIdAndUserById(Integer userId, Integer userbyId) {
        Relation relation = relationMapper.selectByUserIdAndUserById(userId, userbyId);
//        System.out.println("relation::32"+relation);
        if (relation != null){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<Users> getRelation(Integer userId) {
        //获得当前用户的关注列表
        List<Relation> relations = relationMapper.getRelation(userId);
        List<Users> users = new ArrayList<>();  //创建用户列表
        for (Relation relation : relations) {
            //根据关注表获取已关注人的用户信息
            Users users1 = userService.getUser(Integer.parseInt(relation.getUserById()));
            users.add(users1); //添加已关注的用户
        }
        return users;
    }

}
