package com.ftf.ftfProject.beforecontroller.CollectionController;

import com.ftf.ftfProject.Tools.Pack;
import com.ftf.ftfProject.entity.Collections;
import com.ftf.ftfProject.service.CollectionsService;
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
    private Pack PackCollection;

    /**
     * 添加收藏
     * @return
     */
    @RequestMapping("/savecollection")
    @ResponseBody
    public String saveCollection(Integer messageId, Integer userId){
        Collections collections = PackCollection.PackCollection(messageId,userId);
        return collectionsService.saveCollection(collections);
    }
}
