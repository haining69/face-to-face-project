package com.ftf.ftfProject.service;


import com.ftf.ftfProject.entity.Forward;

public interface ForwardService {

    /**
     * 增加转发表的记录
     * 增加成功返回true
     * 增加失败返回false
     * @param forward
     * @return
     */
    Boolean saveForward(Forward forward);

    /**
     * 根据传入的messageId和userId查询有没有该记录,
     * 如果有则进行返回true，如果没有则进行返回false
     * @param messageId
     * @param userId
     * @return
     */
    Boolean getForward(Integer messageId, Integer userId);

    /**
     * 根据传入的messageId进行查询文章图片，并给转发用户进行存储图片
     * @param messageId
     * @return
     */
    Boolean forwardImg(Integer messageId, Integer userId);
}
