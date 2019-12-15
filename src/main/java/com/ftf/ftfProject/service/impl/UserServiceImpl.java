package com.ftf.ftfProject.service.impl;

import com.ftf.ftfProject.Tools.Verify;
import com.ftf.ftfProject.entity.Users;
import com.ftf.ftfProject.mapper.UserMapper;
import com.ftf.ftfProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private Verify verify;


    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Users> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public Users login(Users user) {
//        System.out.println(user);
        Users users = userMapper.login(user);
        if (users != null) {
            return users;
        } else {
            return null;
        }
    }


    @Override
    public Boolean findByUsername(Users user) {
        Users user1 = userMapper.findByUsername(user);
//        System.out.println(user1);
        if (user1 == null){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public int findByUsername1(String userNikename) {
        Users user = userMapper.findByUsername1(userNikename);
        if (user != null){
            return Integer.parseInt(user.getUserId());
        }else {
            return -1;
        }
    }

    @Override
    public String getByUserId(Integer userId) {
        return userMapper.getByUserId(userId);
    }

    @Override
    public Users getUser(Integer userId) {
        return userMapper.getUser(userId);
    }

    @Override
    public Boolean register(Users user) {
        if (userMapper.register(user) == 1){
            return true;
        }else {
            return false;
        }
    }

    //发送邮箱并返回验证码
    @Override
    public String verify(String email) throws MessagingException {
        String checkcode =  verify.getchcekcode();
        verify.sendMsg(email, checkcode);
        return checkcode;
    }

    //根据用户名进行查询
    @Override
    public Boolean findByEmail(Users user) {
        if (userMapper.findByEmail(user) == null){
            return false;
        }else{
            return true;
        }
    }

    //更新用户  修改密码和账户名
    @Override
    public Boolean update(Users user) {
        if (userMapper.updateUser(user) > 0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Boolean updateImg(Integer userId, String url) {
        if (userMapper.updateImg(userId, url) == 1){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Boolean updateUserInfo(Users users) {
        if (userMapper.updateUserInfo(users) == 1){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Boolean incMessageNum(Integer userId) {
        if (userMapper.incMessageNum(userId) == 1){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Boolean decreaMessageNum(Integer userId) {
        if (userMapper.decreaMessageNum(userId) == 1){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Users findByEmail(String email) {
        return userMapper.selectByEmail(email);
    }


    @Override
    public void addUser(Users users) {
        userMapper.insertUser(users);
    }

}


