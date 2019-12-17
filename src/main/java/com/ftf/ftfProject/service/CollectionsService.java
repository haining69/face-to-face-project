package com.ftf.ftfProject.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ftf.ftfProject.entity.Collections;
import com.ftf.ftfProject.metaclass.MessageAndUsers;

import java.util.List;

public interface CollectionsService {


    /**
     * 保存收藏
     * @return
     */
    String saveCollection(Collections collections);

    /**
     * 根据messageId和userId查询收藏表
     * @param messageId
     * @param userId
     * @return
     */
    Boolean selectByUserIdAndMessageId(Integer messageId,Integer userId);

    /**
     * 根据传入的用户Id继续查询用户收藏信息，并返回包装类
     * @param userId
     * @return
     */
    List<MessageAndUsers> getCollection(Integer userId,Integer pagenum);

    /**
     * 根据messageId进行查询user与message和imgs
     * @param messageId
     * @return
     */
    String getCollectionMessage(Integer messageId) throws JsonProcessingException;
}
