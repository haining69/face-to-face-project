package com.ftf.ftfProject.service.impl;

import com.ftf.ftfProject.entity.Comments;
import com.ftf.ftfProject.entity.Message;
import com.ftf.ftfProject.mapper.CommentsMapper;
import com.ftf.ftfProject.metaclass.NikeAndComment;
import com.ftf.ftfProject.metaclass.UserComment;
import com.ftf.ftfProject.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentsServiceImpl implements CommentsService {

    @Autowired
    private CommentsMapper commentsMapper;
    @Autowired
    private UserServiceImpl userService;

    @Override
    public List<Comments> getAllComments() {
        return commentsMapper.getAllComments();
    }

    @Override
    public Boolean saveComments(Comments comments) {
        int i = commentsMapper.saveComment(comments);
        if (i == 1){
//            System.out.println("zhanghaining");
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<NikeAndComment> selectByMessagesid(String messageId) {
        List<Comments> comments = commentsMapper.selectByMessagesid(Integer.parseInt(messageId));  //主评论List
        List<NikeAndComment> nikeAndCommentList = new ArrayList<>();   //包装类的List
        for (Comments comment : comments) {
            NikeAndComment nikeAndComment = new NikeAndComment();   //创建一个NikeAndComment
            nikeAndComment.setUserNikename(userService.getByUserId(Integer.parseInt(comment.getUserId())));  //得到用户名
            nikeAndComment.setComments(comment);
            nikeAndCommentList.add(nikeAndComment);  //添加
        }
        return nikeAndCommentList;
    }

    @Override
    public int getCommentId(Integer messageId, String commentInfo, Integer userId) {
        List<Integer> integerList = commentsMapper.getCommentId(messageId, commentInfo, userId);
        return integerList.get(0);
    }
}
