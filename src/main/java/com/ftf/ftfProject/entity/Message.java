package com.ftf.ftfProject.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@ToString
public class Message implements Serializable {

    private String messagesId;
    private String messagesType;
    private String messagesInfo;
    private Date messagesTime;
    private Integer messagestate;
    private Integer messagesCollectnum;
    private Integer messagesCommentnum;
    private Integer messagesTranspondnum;
    private Integer messagesAgreenum;
    private Integer messagesReadnum;
    private String messagesLabel;
    private String userId;

    public String getMessagesId() {
        return messagesId;
    }

    public void setMessagesId(String messagesId) {
        this.messagesId = messagesId;
    }

    public String getMessagesType() {
        return messagesType;
    }

    public void setMessagesType(String messagesType) {
        this.messagesType = messagesType;
    }

    public String getMessagesInfo() {
        return messagesInfo;
    }

    public void setMessagesInfo(String messagesInfo) {
        this.messagesInfo = messagesInfo;
    }

    public Date getMessagesTime() {
        return messagesTime;
    }

    public void setMessagesTime(Date messagesTime) {
        this.messagesTime = messagesTime;
    }

    public Integer getMessagestate() {
        return messagestate;
    }

    public void setMessagestate(Integer messagestate) {
        this.messagestate = messagestate;
    }

    public Integer getMessagesCollectnum() {
        return messagesCollectnum;
    }

    public void setMessagesCollectnum(Integer messagesCollectnum) {
        this.messagesCollectnum = messagesCollectnum;
    }

    public Integer getMessagesCommentnum() {
        return messagesCommentnum;
    }

    public void setMessagesCommentnum(Integer messagesCommentnum) {
        this.messagesCommentnum = messagesCommentnum;
    }

    public Integer getMessagesTranspondnum() {
        return messagesTranspondnum;
    }

    public void setMessagesTranspondnum(Integer messagesTranspondnum) {
        this.messagesTranspondnum = messagesTranspondnum;
    }

    public Integer getMessagesAgreenum() {
        return messagesAgreenum;
    }

    public void setMessagesAgreenum(Integer messagesAgreenum) {
        this.messagesAgreenum = messagesAgreenum;
    }

    public Integer getMessagesReadnum() {
        return messagesReadnum;
    }

    public void setMessagesReadnum(Integer messagesReadnum) {
        this.messagesReadnum = messagesReadnum;
    }

    public String getMessagesLabel() {
        return messagesLabel;
    }

    public void setMessagesLabel(String messagesLabel) {
        this.messagesLabel = messagesLabel;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messagesId='" + messagesId + '\'' +
                ", messagesType='" + messagesType + '\'' +
                ", messagesInfo='" + messagesInfo + '\'' +
                ", messagesTime=" + messagesTime +
                ", messagestate=" + messagestate +
                ", messagesCollectnum=" + messagesCollectnum +
                ", messagesCommentnum=" + messagesCommentnum +
                ", messagesTranspondnum=" + messagesTranspondnum +
                ", messagesAgreenum=" + messagesAgreenum +
                ", messagesReadnum=" + messagesReadnum +
                ", messagesLabel='" + messagesLabel + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
