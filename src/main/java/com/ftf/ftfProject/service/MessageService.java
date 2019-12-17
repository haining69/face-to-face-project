package com.ftf.ftfProject.service;

import com.ftf.ftfProject.entity.Message;
import com.ftf.ftfProject.metaclass.MessageAndImgs;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;

public interface MessageService {

    List<Message> getAllMessage();

    /**
     * 根据用户名进行连接查询，并进行分页处理
     * @return
     */
    List<MessageAndImgs> getMessage(Integer userId, int number);

    /**
     * 查询当前用户以审核过的动态条数,并转化成页数
     * @return
     */
    int getpages(Integer userId);

    /**
     * 根据用户名以及动态内容进行查询动态ID
     * @param userNikename
     * @param info
     * @return
     */
    String getMessageId(String userNikename, String info);

    /**
     * 根据传入的messageId进行查询messageInfo
     * @param messageId
     * @return
     */
    String getMessageInfo(String messageId);

    /**
     * 返回总动态条数
     * @return
     */
    int getMessageTotal();

    /**
     * 保存动态，并初始化状态为0  我的故事页面
     * @param message
     */
    Boolean saveMessage(Message message);

    /**
     * 给主页返回数据，动态信息
     * @return
     */
    List<Message> getMessagehome();

    /**
     * 根据messageId进行赞数量加1操作
     * @param messagesId
     */
    void incAgreenum(Integer messagesId);

    /**
     * 根据messageId进行收藏数加1操作
     * @param messagesId
     */
    void incCollection(Integer messagesId);


    /**
     * 根据messageId进行转发数量加1操作
     * @param messagesId
     */
    void incTranspond(Integer messagesId);

    /**
     * 根据messageId进行评论数量加1操作
     * @param messagesId
     */
    void incComment(Integer messagesId);


    /**
     * 根据messageId进行赞数量减1操作
     * @param messagesId
     */
    void decreAgreenum(String messagesId);


    /**
     * 根据messageId进行阅读数量加1操作
     * @param messagesId
     */
    void incReadnum(String messagesId);

    /**
     *删除动态，如果删除成功返回true，否则反之
     * @param messageId
     */
    Boolean deletemessage(Integer messageId);

    /**
     * 根据传入的messageId进行查询usernikename和messageinfo,并返回字符串
     * @param messageId
     * @return
     */
    String getnameandinfo(String messageId);

    /**
     * 根据传入的messageId进行查询userId
     * @param messageId
     * @return
     */
    int getUserId(Integer messageId);

    /**
     * 根据messageId进行查询message对象
     * @param messageId
     * @return
     */
    Message getMessageById(Integer messageId);

    /**
     * 根据传入的消息内容与用户Id进行查询消息对象
     * @param info
     * @param userId
     * @return
     */
    Boolean selectuserIdAndInfo(String info,String userId);
}
