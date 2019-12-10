package com.ftf.ftfProject.beforecontroller.CommentsController;


import com.ftf.ftfProject.Tools.Pack;
import com.ftf.ftfProject.entity.Comments;
import com.ftf.ftfProject.metaclass.UserComment;
import com.ftf.ftfProject.service.impl.CommentsServiceImpl;
import com.ftf.ftfProject.service.impl.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 评论Controller
 */
@Repository
@RequestMapping("/comment")
public class CommentsController {

    @Autowired
    private Pack PackComment;
    @Autowired
    private CommentsServiceImpl commentsService;
    @Autowired
    private MessageServiceImpl messageService;


    /**
     * 保存评论
     * @param remark
     * @param userId
     * @param messageId
     * @return
     */
    @RequestMapping("/savecomment")
    @ResponseBody
    public String SaveComment(String remark,Integer userId,Integer messageId){
        Comments comments = PackComment.PackComment(remark, userId, messageId);
        if (commentsService.saveComments(comments)){  //保存成功
            messageService.incComment(messageId);  //评论数加一
            return "true";
        }else {
            return "false";
        }
    }

    /**
     * 获取当前说说的评论
     * @param messageId
     * @return
     */
    @RequestMapping("/getcomments")
    @ResponseBody
    public List<UserComment> getComments(String messageId){
        return commentsService.selectByMessagesid(messageId);
    }
}
