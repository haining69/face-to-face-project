package com.ftf.ftfProject.service.impl;

import com.ftf.ftfProject.entity.Comments;
import com.ftf.ftfProject.mapper.CommentsMapper;
import com.ftf.ftfProject.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsServiceImpl implements CommentsService {

    @Autowired
    private CommentsMapper commentsMapper;

    @Override
    public List<Comments> getAllComments() {
        return commentsMapper.getAllComments();
    }

    @Override
    public Boolean saveComments(Comments comments) {
        int i = commentsMapper.saveComment(comments);
        if (i == 1){
            System.out.println("zhanghaining");
            return true;
        }else{
            return false;
        }
    }
}
