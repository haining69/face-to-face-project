package com.ftf.ftfProject.beforecontroller.CommentsController;


import com.ftf.ftfProject.Tools.Pack;
import com.ftf.ftfProject.entity.Comments;
import com.ftf.ftfProject.metaclass.NikeAndComment;
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
     * @param commentInfo  评论内容
     * @param userId  评论人
     * @param messageId   被评论的说说
     * @return
     */
    @RequestMapping("/savecomment")
    @ResponseBody
    public String SaveComment(Integer messageId,String commentInfo,Integer userId){
        Comments comments = PackComment.PackComment(commentInfo, userId, messageId);
        System.out.println(comments.getCommentsTime());
        if (commentsService.saveComments(comments)){  //保存成功
            messageService.incComment(messageId);  //评论数加一
            return String.valueOf(commentsService.getCommentId(messageId, commentInfo, userId));
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
    public List<NikeAndComment> getComments(String messageId){  //
//        String messageId = "56";
        return commentsService.selectByMessagesid(messageId);
    }
}
