package com.ftf.ftfProject.service;

import com.ftf.ftfProject.entity.Users;
import javax.mail.MessagingException;
import java.util.List;

public interface UserService {

    List<Users> selectAll();

    //登录返回一个布尔值
    Boolean login(Users user);

    //注册用户名查重并且找回密码时候进行用户名进行查重
    Boolean findByUsername(Users user);

    //注册
    void register(Users user);

    //发送验证
    String verify(String email) throws MessagingException;

    //根据邮箱进行查询
    Boolean findByEmail(Users user);

    //根据用户名与密码修改用户并让用户找回密码
    Boolean update(Users user);



    Users findByEmail(String email);
    void addUser(Users users);
}
