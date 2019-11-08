package com.ftf.ftfProject.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class Friend implements Serializable {
    private String uId;
    private String uByid;
}
