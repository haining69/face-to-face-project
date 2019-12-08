package com.ftf.ftfProject.metaclass;

import java.io.Serializable;

public class UserComment implements Serializable {
    private String userNikename;
    private String commentInfo;

    public String getUserNikename() {
        return userNikename;
    }

    public void setUserNikename(String userNikename) {
        this.userNikename = userNikename;
    }

    public String getCommentInfo() {
        return commentInfo;
    }

    public void setCommentInfo(String commentInfo) {
        this.commentInfo = commentInfo;
    }

    @Override
    public String toString() {
        return "UserComment{" +
                "userNikename='" + userNikename + '\'' +
                ", commentInfo='" + commentInfo + '\'' +
                '}';
    }
}
