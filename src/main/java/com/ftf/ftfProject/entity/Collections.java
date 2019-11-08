package com.ftf.ftfProject.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class Collections implements Serializable {

    private String CollectionsId;
    private String CollectionsTime;
    private String CollectionsStatus;
    private String userId;

    public String getCollectionsId() {
        return CollectionsId;
    }

    public void setCollectionsId(String collectionsId) {
        CollectionsId = collectionsId;
    }

    public String getCollectionsTime() {
        return CollectionsTime;
    }

    public void setCollectionsTime(String collectionsTime) {
        CollectionsTime = collectionsTime;
    }

    public String getCollectionsStatus() {
        return CollectionsStatus;
    }

    public void setCollectionsStatus(String collectionsStatus) {
        CollectionsStatus = collectionsStatus;
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
                ", userId='" + userId + '\'' +
                '}';
    }
}
