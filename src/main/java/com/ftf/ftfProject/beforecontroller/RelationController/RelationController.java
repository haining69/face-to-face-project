package com.ftf.ftfProject.beforecontroller.RelationController;

import com.ftf.ftfProject.Tools.Pack;
import com.ftf.ftfProject.entity.Relation;
import com.ftf.ftfProject.service.RelationService;
import com.ftf.ftfProject.service.impl.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 关注表
 */
@Controller
@RequestMapping("/relation")
public class RelationController {
    @Autowired
    private RelationService relationService;
    @Autowired
    private MessageServiceImpl messageService;
    @Autowired
    private Pack PackRelation;

    /**
     * 添加关注，如果已经关注了，则不能重复关注
     * @param messageId
     * @param userId
     * @return
     */
    @RequestMapping("/saverelation")
    public String saveRelation(Integer messageId, Integer userId){
        int userById = messageService.getUserId(messageId);
        if (relationService.selectByUserIdAndUserById(userId, userById)){
            return "false";
        }else {
            Relation relation = PackRelation.PackRelation(userId,userById);
            if ("true".equals(relationService.saveRelation(relation))){
                return "true";
            }
        }
        return "false";
    }
}
