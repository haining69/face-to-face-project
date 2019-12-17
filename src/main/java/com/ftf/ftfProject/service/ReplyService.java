package com.ftf.ftfProject.service;

import com.ftf.ftfProject.entity.Reply;
import com.ftf.ftfProject.metaclass.ReplyPackClass;

import java.util.List;

public interface ReplyService {

    /**
     * 根据传来的评论Id进行查询子评论
     * @param parent
     * @return
     */
    List<ReplyPackClass> getReply(String parent);

    /**
     * 根据传来的reply对象，保存reply;
     * @param reply
     * @return
     */
    Boolean saveReply(Reply reply);

    /**
     * 根据传来的userId与父Id进行查询replyId
     * @param userId
     * @param parent
     * @return
     */
    int getReplyId(int userId, String parent);
}
