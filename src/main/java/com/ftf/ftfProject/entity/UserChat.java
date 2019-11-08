package com.ftf.ftfProject.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
public class UserChat implements Serializable {
    private String uId;
    private String uName;
    private String uPwd;
    private String uIp;
    private Date uLastLogin;
    private Date uLastExit;
}
