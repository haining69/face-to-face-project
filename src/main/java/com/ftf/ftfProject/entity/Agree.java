package com.ftf.ftfProject.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class Agree implements Serializable {
    private Integer agreeId;
    private Integer messageId;
    private Integer userId;

    public Integer getAgreeId() {
        return agreeId;
    }

    public void setAgreeId(Integer agreeId) {
        this.agreeId = agreeId;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Agree{" +
                "agreeId=" + agreeId +
                ", messageId=" + messageId +
                ", userId=" + userId +
                '}';
    }
}
