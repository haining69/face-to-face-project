package com.ftf.ftfProject.service;

import com.ftf.ftfProject.entity.Collections;

import java.util.List;

public interface CollectionsService {

    List<Collections> getCollections();

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
}
