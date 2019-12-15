package com.ftf.ftfProject.metaclass;

import com.ftf.ftfProject.entity.Reply;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 回复表在前端显示界面显示数据
 */
public class ReplyPackClass implements Serializable {
    private String userNikename;   //回复人昵称
    private String userByNikename;   //被回复人昵称
    private Reply reply;   //回复表

    public String getUserNikename() {
        return userNikename;
    }

    public void setUserNikename(String userNikename) {
        this.userNikename = userNikename;
    }

    public String getUserByNikename() {
        return userByNikename;
    }

    public void setUserByNikename(String userByNikename) {
        this.userByNikename = userByNikename;
    }

    public Reply getReply() {
        return reply;
    }

    public void setReply(Reply reply) {
        this.reply = reply;
    }

    @Override
    public String toString() {
        return "ReplyPackClass{" +
                "userNikename='" + userNikename + '\'' +
                ", userByNikename='" + userByNikename + '\'' +
                ", reply=" + reply +
                '}';
    }
}
