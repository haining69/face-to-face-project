package com.ftf.ftfProject.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
public class Comments implements Serializable {

    private String commentsId;
    private String commentsInfo;
    private Date commentsTime;
    private String messageId;
    private String userChildId;
    private  String userParentId;

    public String getCommentsId() {
        return commentsId;
    }

    public void setCommentsId(String commentsId) {
        this.commentsId = commentsId;
    }

    public String getCommentsInfo() {
        return commentsInfo;
    }

    public void setCommentsInfo(String commentsInfo) {
        this.commentsInfo = commentsInfo;
    }

    public Date getCommentsTime() {
        return commentsTime;
    }

    public void setCommentsTime(Date commentsTime) {
        this.commentsTime = commentsTime;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getUserChildId() {
        return userChildId;
    }

    public void setUserChildId(String userChildId) {
        this.userChildId = userChildId;
    }

    public String getUserParentId() {
        return userParentId;
    }

    public void setUserParentId(String userParentId) {
        this.userParentId = userParentId;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "commentsId='" + commentsId + '\'' +
                ", commentsInfo='" + commentsInfo + '\'' +
                ", commentsTime=" + commentsTime +
                ", messageId='" + messageId + '\'' +
                ", userChildId='" + userChildId + '\'' +
                ", userParentId='" + userParentId + '\'' +
                '}';
    }
}
