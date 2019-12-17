package com.ftf.ftfProject.service.impl;

import com.ftf.ftfProject.entity.Reply;
import com.ftf.ftfProject.mapper.ReplyMapper;
import com.ftf.ftfProject.metaclass.ReplyPackClass;
import com.ftf.ftfProject.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {
    @Autowired
    private ReplyMapper replyMapper;
    @Autowired
    private UserServiceImpl userService;

    @Override
    public List<ReplyPackClass> getReply(String parent) {
        List<Reply> replies = replyMapper.getReplys(parent);  //获取当前评论的所有子评论
        List<ReplyPackClass> replyPackClassList = new ArrayList<>();
        for (Reply reply : replies) {
            ReplyPackClass replyPackClass = new ReplyPackClass();
            replyPackClass.setUserNikename(userService.getByUserId(reply.getReplyUserId()));   //回复人用户名
//            System.out.println(reply.getReplyByUserId()+":"+userService.getByUserId(reply.getReplyByUserId()));
            replyPackClass.setUserByNikename(userService.getByUserId(reply.getReplyByUserId()));   //被回复人用户名
            replyPackClass.setReply(reply);
//            System.out.println(replyPackClass.toString());
            replyPackClassList.add(replyPackClass);
        }
        return replyPackClassList;
    }

    @Override
    public Boolean saveReply(Reply reply) {
        if (replyMapper.saveReply(reply) == 1){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public int getReplyId(int userId, String parent) {
        List<Integer> integers =  replyMapper.getReplyId(userId, parent);
        if (integers.size() > 0){
            return integers.get(0);
        }
        return -1;
    }
}
