package com.ftf.ftfProject.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 聊天消息实体类
 */
@Getter
@Setter
@ToString
public class MSG  implements Serializable {
    private String msgId;
    private String msgContent;
    private String msgSendfrom;
    private String msgSendto;
    private Date msgSendtime;
    private String msgRemark;
    private String msgType;
}
