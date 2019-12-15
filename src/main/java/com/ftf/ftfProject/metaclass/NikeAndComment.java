package com.ftf.ftfProject.metaclass;

import com.ftf.ftfProject.entity.Comments;

import java.io.Serializable;

/**
 * 评论界面进行展示该说说的评论，不含回复
 */
public class NikeAndComment implements Serializable {
    private String userNikename;  //用户昵称
    private Comments comments;   //评论

    public String getUserNikename() {
        return userNikename;
    }

    public void setUserNikename(String userNikename) {
        this.userNikename = userNikename;
    }

    public Comments getComments() {
        return comments;
    }

    public void setComments(Comments comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "NikeAndComment{" +
                "userNikename='" + userNikename + '\'' +
                ", comments=" + comments +
                '}';
    }
}
