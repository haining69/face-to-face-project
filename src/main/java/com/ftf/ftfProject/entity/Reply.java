package com.ftf.ftfProject.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 回复表
 */
public class Reply implements Serializable {
    private Integer replyId;    //主键
    private Integer replyUserId;  //回复人
    private Integer replyByUserId;   //被回复人
    private String replyInfo;  //回复内容
    private String commentParent;   //上一条评论Id
    private Date replyTime;   //回复时间


    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public Integer getReplyUserId() {
        return replyUserId;
    }

    public void setReplyUserId(Integer replyUserId) {
        this.replyUserId = replyUserId;
    }

    public Integer getReplyByUserId() {
        return replyByUserId;
    }

    public void setReplyByUserId(Integer replyByUserId) {
        this.replyByUserId = replyByUserId;
    }

    public String getReplyInfo() {
        return replyInfo;
    }

    public void setReplyInfo(String replyInfo) {
        this.replyInfo = replyInfo;
    }

    public String getCommentParent() {
        return commentParent;
    }

    public void setCommentParent(String commentParent) {
        this.commentParent = commentParent;
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "replyId=" + replyId +
                ", replyUserId=" + replyUserId +
                ", replyByUserId=" + replyByUserId +
                ", replyInfo='" + replyInfo + '\'' +
                ", commentParent='" + commentParent + '\'' +
                ", replyTime=" + replyTime +
                '}';
    }
}
