package com.ftf.ftfProject.service;

import com.ftf.ftfProject.entity.Message;
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
    List<Message> getMessage(String userNikename, int number);

    /**
     * 查询当前用户以审核过的动态条数,并转化成页数
     * @return
     */
    int getpages(String userNikename);

    /**
     * 根据用户名以及动态内容进行查询动态ID
     * @param userNikename
     * @param info
     * @return
     */
    String getMessageId(String userNikename, String info);

    /**
     * 返回总动态条数
     * @return
     */
    int getMessageTotal();

    /**
     * 保存动态，并初始化状态为0
     * @param message
     */
    Boolean saveMessage(Message message);

    /**
     * 根据messageId进行赞数量加1操作
     * @param messagesId
     */
    void incAgreenum(String messagesId);

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
    Boolean deletemessage(String messageId);

    /**
     * 根据传入的messageId进行查询usernikename和messageinfo,并返回字符串
     * @param messageId
     * @return
     */
    String getnameandinfo(String messageId);
}
