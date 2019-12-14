package com.ftf.ftfProject.beforecontroller.MessageController;


import com.ftf.ftfProject.Tools.Pack;
import com.ftf.ftfProject.Tools.QiniuUpload;
import com.ftf.ftfProject.entity.Img;
import com.ftf.ftfProject.entity.Message;
import com.ftf.ftfProject.service.impl.ImgServiceImpl;
import com.ftf.ftfProject.service.impl.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 动态Controller
 */
@Controller
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageServiceImpl messageService;
    @Autowired
    private Pack PackMessage;
    @Autowired
    private QiniuUpload qiniuUpload;
    @Autowired
    private ImgServiceImpl imgService;

    /**
     * 我的故事
     * 根据用户名进行查询该用户的动态信息，并进行分页处理
     * @return
     */
    @RequestMapping("/getmessage")
    @ResponseBody
    public List<Message> getmessage(String userNikename, int page){  //String userNikename, int number
        int pages = messageService.getpages(userNikename); // 返回的页数
        return messageService.getMessage(userNikename, page);   //返回查找的动态，每次返回5条记录
    }




    /**
     * 我的故事
     * 保存动态
     * @param
     * @return
     */
    @RequestMapping("/savemessage")
    @ResponseBody
    public List<String> saveMessage(MultipartFile[] files, HttpServletRequest request) throws Exception {
        List<String> imgs = new ArrayList<>();
        String info = request.getParameter("info");
        String userId = request.getParameter("userId");
        System.out.println(userId);
        Message message = PackMessage.PackMessage(info,userId);
        if (messageService.saveMessage(message) ){  //如果存储成功则进行返回消息id
            String messageid = messageService.getMessageId(userId,info);
            System.out.println(messageid);
            imgs.add(messageid);   //传回文章Id
            for (MultipartFile file : files) {    //遍历文件
                //上传文件并返回url
                String url = qiniuUpload.updateFile(file, UUID.randomUUID().toString()+"-"+file.getOriginalFilename());
                //存储图片
                Img img = PackMessage.PackImg(Integer.valueOf(messageid), url);
                imgService.saveImg(img);
                imgs.add(url);    //添加图片的url
            }
            return imgs;
        }else {
            return null;
        }


    }

    /**
     * 我的故事
     * 删除动态,如果成功则返回true，否则，反之
     */
    @RequestMapping("/deletemessage")
    @ResponseBody
    public String deleteMessage(Integer id){
        if (messageService.deletemessage(id)){
            return "true";
        }else {
            return "false";
        }
    }


    /**
     * 主页请求动态数据
     * @return
     */
    @RequestMapping("/getmessagehome")
    @ResponseBody
    public List<Message> getmessagehome(){
        return messageService.getMessagehome();
    }


    /**
     * 根据messageId查询当前动态的图片信息
     * @param messagesId
     * @return
     */
    @RequestMapping("/getmessageimg")
    @ResponseBody
    public List<Img> getMessageImg(Integer messagesId){
//        System.out.println(messagesId);

        return imgService.getImgs(messagesId);
    }



}
