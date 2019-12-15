package com.ftf.ftfProject.service;

import com.ftf.ftfProject.entity.Comments;
import com.ftf.ftfProject.metaclass.NikeAndComment;
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
    List<NikeAndComment> selectByMessagesid(String messageId);

    /**
     * 根据传入的三个参数进行查询messageId
     * @param messageId
     * @param commentInfo
     * @param userId
     * @return
     */
    int getCommentId(Integer messageId,String commentInfo,Integer userId);
}
