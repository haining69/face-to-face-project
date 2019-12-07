package com.ftf.ftfProject.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
public class Users implements Serializable {

    private String userId;
    private String userEmail;
    private String userPassword;
    private String userNikename;
    private Date userTime;//注册时间
    private String userSex;
    private int userStatus;
    private String userStatusStr;
    private String userImg;
    private Date userBirthday;

}
