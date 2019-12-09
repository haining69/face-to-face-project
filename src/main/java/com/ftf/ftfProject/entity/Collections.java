package com.ftf.ftfProject.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
public class Collections implements Serializable {

    private String CollectionsId;
    private Date CollectionsTime;
    private String CollectionsStatus;
    private String messageId;
    private String userId;

    public String getCollectionsId() {
        return CollectionsId;
    }

    public void setCollectionsId(String collectionsId) {
        CollectionsId = collectionsId;
    }

    public void setCollectionsTime(Date collectionsTime) {
        CollectionsTime = collectionsTime;
    }


    public String getCollectionsStatus() {
        return CollectionsStatus;
    }

    public void setCollectionsStatus(String collectionsStatus) {
        CollectionsStatus = collectionsStatus;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Collections{" +
                "CollectionsId='" + CollectionsId + '\'' +
                ", CollectionsTime='" + CollectionsTime + '\'' +
                ", CollectionsStatus='" + CollectionsStatus + '\'' +
                ", messageId='" + messageId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
