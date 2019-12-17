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
     * @param parent
     * @return
     */
    @RequestMapping("/getreply")
    @ResponseBody
    public List<ReplyPackClass> getReply(String parent){ //
        System.out.println(parent);
        return replyService.getReply(parent);
    }


    /**
     * 保存回复，
     * @param userId  回复人
     * @param replyByid  上一条回复
     * @param replyInfo  回复内容
     * @param userByNikename  被回复人名字
     * @return
     */
    @RequestMapping("/savereply")
    @ResponseBody
    public String saveReply(Integer userId, String replyByid, String replyInfo, String userByNikename){
        System.out.println(userId+"+"+replyByid+"+"+replyInfo+"+"+userByNikename);
        Integer userById = userService.findByUsername1(userByNikename);  //找到被回复人的ID号
        Reply reply = PackReply.PackReply(userId, replyByid, replyInfo, userById);  //进行打包
        //存储
        replyService.saveReply(reply);
        //查询replyId并返回
        return String.valueOf(replyService.getReplyId(userId, replyByid));

    }
}
