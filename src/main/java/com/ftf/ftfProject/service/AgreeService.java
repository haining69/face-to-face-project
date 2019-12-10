package com.ftf.ftfProject.service;

import com.ftf.ftfProject.entity.Agree;

public interface AgreeService {

    /**
     * 保存点赞记录
     * @param agree
     * @return
     */
    String saveAgree(Agree agree);

    /**
     * 根据传入的参数，查看是否有这个记录,
     * @param messageId
     * @param userId
     * @return
     */
    Boolean getagree(Integer messageId, Integer userId);
}
