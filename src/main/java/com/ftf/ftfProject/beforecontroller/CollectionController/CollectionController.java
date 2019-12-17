package com.ftf.ftfProject.beforecontroller.CollectionController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ftf.ftfProject.Tools.Pack;
import com.ftf.ftfProject.entity.Collections;
import com.ftf.ftfProject.metaclass.MessageAndUsers;
import com.ftf.ftfProject.service.CollectionsService;
import com.ftf.ftfProject.service.impl.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * 收藏Controller
 */
@Controller
@RequestMapping("/collection")
public class CollectionController {

    @Autowired
    private CollectionsService collectionsService;
    @Autowired
    private MessageServiceImpl messageService;
    @Autowired
    private Pack PackCollection;

    /**
     * 添加收藏  如果收藏过则不能重复收藏
     * @return
     */
    @RequestMapping("/savecollection")
    @ResponseBody
    public String saveCollection(Integer messageId, Integer userId){
        if (collectionsService.selectByUserIdAndMessageId(messageId, userId)){
            System.out.println("收藏过了！");
            return "false";
        }else {
            Collections collections = PackCollection.PackCollection(messageId,userId);
            if ("true".equals(collectionsService.saveCollection(collections))){
                messageService.incCollection(messageId);  //收藏加一
            }
            System.out.println("收藏成功！");
            return "true";
        }
    }


    /**
     * 根据传入的用户Id进行查询用户收藏，并返回收藏内容与用户内容
     * @param userId
     * @return
     */
    @RequestMapping("/getcollection")
    @ResponseBody
    public List<MessageAndUsers> getCollection(Integer userId, Integer pagenum){
        System.out.println(userId+":"+pagenum);
//        int userId = 26;
//        int pagenum = 1;
        return collectionsService.getCollection(userId, pagenum);
    }

    @RequestMapping("/getcollectionmessage")
    @ResponseBody
    public String getCollectionMessage(Integer messageId) throws JsonProcessingException {  //
//        int messageId = 107;
        String haha = collectionsService.getCollectionMessage(messageId);
        System.out.println("haha:"+haha);
        return haha;
    }
}
