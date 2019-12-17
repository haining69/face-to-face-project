package com.ftf.ftfProject.beforecontroller.ForwardController;

import com.ftf.ftfProject.Tools.Pack;
import com.ftf.ftfProject.entity.Forward;
import com.ftf.ftfProject.entity.Message;
import com.ftf.ftfProject.service.impl.ForwardServiceImpl;
import com.ftf.ftfProject.service.impl.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/forward")
public class ForwardController {
    @Autowired
    private ForwardServiceImpl forwardService;
    @Autowired
    private MessageServiceImpl messageService;
    @Autowired
    private Pack PackMessage;
    @Autowired
    private Pack PackForward;


    /**
     * 主页
     * 进行转发,不能是自己的动态，转发不了
     * 转发成功则返回true
     * 否则返回false
     * @param  messageId,userId
     * @param messageId
     * @return
     */
    @RequestMapping("/forwardmessage")
    @ResponseBody
    public String forwardmessage(Integer messageId, Integer userId){
        //得到转发的谁Id
        int userById = messageService.getUserId(messageId);
        if (userId != userById){
            if (forwardService.getForward(messageId,userId)){
                System.out.println("转发失败了！");
                return "false";
            }else {
                String info = messageService.getnameandinfo(String.valueOf(messageId));  //获得消息
                Message message = PackMessage.PackMessage(info,String.valueOf(userId));  //包装
                message.setMessagestate(1);
                System.out.println(message.getMessagesTime());
                Forward forward = PackForward.PackForward(messageId, userId);  //转发表记录数据
                if (messageService.saveMessage(message) && forwardService.saveForward(forward)){  //如果存储成功则进行返回消息id
                    //查询转发messageId
                    String str = messageService.getMessageId(String.valueOf(userId), info);
                    //查询文章图片,并进行保存
                    forwardService.forwardImg(messageId, Integer.parseInt(str));
                    //转发加一
                    messageService.incTranspond(messageId);
                    System.out.println("转发成功！");
                    return "true";
                }else {
                    return "false";
                }
            }
        }
        return "false";
    }
}
