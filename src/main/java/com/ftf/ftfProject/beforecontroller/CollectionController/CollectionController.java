package com.ftf.ftfProject.beforecontroller.CollectionController;

import com.ftf.ftfProject.Tools.Pack;
import com.ftf.ftfProject.entity.Collections;
import com.ftf.ftfProject.service.CollectionsService;
import com.ftf.ftfProject.service.impl.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


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
}
