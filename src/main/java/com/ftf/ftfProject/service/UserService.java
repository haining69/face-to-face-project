package com.ftf.ftfProject.service;

import com.ftf.ftfProject.entity.Users;
import javax.mail.MessagingException;
import java.util.List;

public interface UserService {

    List<Users> selectAll();

    //登录返回一个布尔值
    Users login(Users user);

    //注册用户名查重并且找回密码时候进行用户名进行查重
    Boolean findByUsername(Users user);

    //根据用户名进行查询用户id
    int findByUsername1(String userNikename);

    /**
     * 根据用户Id进行查询用户名
     * @param userId
     * @return
     */
    String getByUserId(Integer userId);

    //根据传入的userId返回user对象数据
    Users getUser(Integer userId);

    //注册
    Boolean register(Users user);

    //发送验证
    String verify(String email) throws MessagingException;

    //根据邮箱进行查询
    Boolean findByEmail(Users user);

    //根据用户名与密码修改用户并让用户找回密码
    Boolean update(Users user);

    //根据传入的userId进行修改用户头像
    Boolean updateImg(Integer userId, String url);

    //根据传入的userId进行更新该用户信息
    Boolean updateUserInfo(Users users);

    //根据传入的userId进行增加发表说说量
    Boolean incMessageNum(Integer userId);

    //根据传入的userId进行减少发表说说量
    Boolean decreaMessageNum(Integer userId);



    Users findByEmail(String email);
    void addUser(Users users);
}
