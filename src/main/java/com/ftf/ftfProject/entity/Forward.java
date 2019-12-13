package com.ftf.ftfProject.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class Forward implements Serializable {
    private Integer forwardId;
    private Integer messageId;
    private Integer userId;

    public Integer getForwardId() {
        return forwardId;
    }

    public void setForwardId(Integer forwardId) {
        this.forwardId = forwardId;
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
        return "Forward{" +
                "forwardId=" + forwardId +
                ", messageId=" + messageId +
                ", userId=" + userId +
                '}';
    }
}
