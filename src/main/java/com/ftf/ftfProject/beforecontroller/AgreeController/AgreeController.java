package com.ftf.ftfProject.beforecontroller.AgreeController;

import com.ftf.ftfProject.Tools.Pack;
import com.ftf.ftfProject.entity.Agree;
import com.ftf.ftfProject.service.impl.AgreeServiceImpl;
import com.ftf.ftfProject.service.impl.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/agree")
@Controller
public class AgreeController {
    @Autowired
    private AgreeServiceImpl agreeService;
    @Autowired
    private MessageServiceImpl messageService;
    @Autowired
    private Pack PackAgree;

    /**
     * 主页
     * 增加该动态的点赞数  如果点过赞不能重复点赞
     * @param messageId
     */
    @RequestMapping("/incagreenum")
    public String incAgreenum(Integer messageId, Integer userId){
        if (agreeService.getagree(messageId, userId)){  //如果已经点过赞
            return "false";
        }else {
            Agree agree = PackAgree.PackAgree(messageId, userId);
            if ("true".equals(agreeService.saveAgree(agree))){
                messageService.incAgreenum(String.valueOf(messageId));
            }
            return "true";
        }

    }

    /**
     * 主页
     * 减少该动态的点赞数
     * @param messageId
     */
    @RequestMapping("/decreagreenum")
    public void decreAgreenum(String messageId){
        messageService.decreAgreenum(messageId);
    }
}
