package com.ftf.ftfProject.service;

import com.ftf.ftfProject.entity.Comments;
import com.ftf.ftfProject.metaclass.UserComment;

import java.util.List;

public interface CommentsService {

    List<Comments> getAllComments();

    Boolean saveComments(Comments comments);

    /**
     * 根据传入的messageId，返回评论name与内容
     * @param messageId
     * @return
     */
    List<UserComment> selectByMessagesid(String messageId);
}
