package com.ftf.ftfProject.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
public class Relation implements Serializable {

    private String relationId;
    private Date relationTime;
    private String relationType;
    private String userId;
    private String userById;

    public String getRelationId() {
        return relationId;
    }

    public void setRelationId(String relationId) {
        this.relationId = relationId;
    }

    public Date getRelationTime() {
        return relationTime;
    }

    public void setRelationTime(Date relationTime) {
        this.relationTime = relationTime;
    }

    public String getRelationType() {
        return relationType;
    }

    public void setRelationType(String relationType) {
        this.relationType = relationType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserById() {
        return userById;
    }

    public void setUserById(String userById) {
        this.userById = userById;
    }

    @Override
    public String toString() {
        return "Relation{" +
                "relationId='" + relationId + '\'' +
                ", relationTime=" + relationTime +
                ", relationType='" + relationType + '\'' +
                ", userId='" + userId + '\'' +
                ", userById='" + userById + '\'' +
                '}';
    }
}
