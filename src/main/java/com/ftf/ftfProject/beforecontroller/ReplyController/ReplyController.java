package com.ftf.ftfProject.beforecontroller.ReplyController;

import com.ftf.ftfProject.Tools.Pack;
import com.ftf.ftfProject.entity.Reply;
import com.ftf.ftfProject.metaclass.ReplyPackClass;
import com.ftf.ftfProject.service.impl.ReplyServiceImpl;
import com.ftf.ftfProject.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/reply")
public class ReplyController {
    @Autowired
    private ReplyServiceImpl replyService;
    @Autowired
    private Pack PackReply;
    @Autowired
    private UserServiceImpl userService;

    /**
     * 根据传回来的评论Id进行铲查询子评论
     * @param commmentId
     * @return
     */
    @RequestMapping("/getreply")
    @ResponseBody
    public List<ReplyPackClass> getReply(Integer commmentId){ //
//        Integer commmentId = 1;
        return replyService.getReply(commmentId);
    }



    @RequestMapping("/savereply")
    @ResponseBody
    public String saveReply(Integer userId, String replyByid, String replyInfo, String userByNikename){
        System.out.println(userId+"+"+replyByid+"+"+replyInfo+"+"+userByNikename);
        if (replyByid.contains("comments")){   //回复主评论  返回回复Id号
            Integer commentsId = new Integer(replyByid.substring(10,replyByid.length()));
            Integer userById = userService.findByUsername1(userByNikename);
            Reply reply = PackReply.PackReply(userId, commentsId, replyInfo, userById);
            //存储
            replyService.saveReply(reply);
            //查询replyId并返回
            return String.valueOf(replyService.getReplyId(userId, commentsId));
        }else {    //回复子评论  返回回复Id号
            Integer replyId = new Integer(replyByid.substring(7,replyByid.length()));
            Integer userById = userService.findByUsername1(userByNikename);
            Reply reply = PackReply.PackReply(userId, replyId, replyInfo, userById);
            //存储
            replyService.saveReply(reply);
            //查询replyId并返回
            return String.valueOf(replyService.getReplyId(userId, replyId));
        }
    }
}
