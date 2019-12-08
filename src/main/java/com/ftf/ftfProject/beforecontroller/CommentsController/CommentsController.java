package com.ftf.ftfProject.beforecontroller.CommentsController;


import com.ftf.ftfProject.Tools.Pack;
import com.ftf.ftfProject.entity.Comments;
import com.ftf.ftfProject.service.impl.CommentsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
@RequestMapping("/comment")
public class CommentsController {

    @Autowired
    private Pack PackComment;
    @Autowired
    private CommentsServiceImpl commentsService;


    @RequestMapping("/savecomment")
    @ResponseBody
    public String SaveComment(String remark,Integer userId,Integer messageId){
        Comments comments = PackComment.PackComment(remark, userId, messageId);
        System.out.println(comments);
        if (commentsService.saveComments(comments)){
            System.out.println("tangcaiping");
            return "true";
        }else {
            return "false";
        }
    }
}
