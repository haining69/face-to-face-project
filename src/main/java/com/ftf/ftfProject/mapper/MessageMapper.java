package com.ftf.ftfProject.mapper;

import com.ftf.ftfProject.entity.Message;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 动态表
 */
@Repository
public interface MessageMapper {

    @Select("select * from message")
    List<Message> getAllMessage();

    //根据UserId查询该用户的所有动态
    @Select("select * from message where user_id=#{userId}")
    List<Message> selectByUserId();

    //增加用户动态
    @Insert("insert into message(messages_type, messages_info, messages_time, " +
            "messages_collectnum, messages_commentnum, messages_transpondnum, " +
            "messages_agreenum, messages_readnum, messages_label, user_id)" +
            "values (#{messagesType},#{messagesInfo},#{messagesTime}," +
            "#{messagesCollectnum},#{messagesCommentnum},#{messagesTranspondnum}," +
            "#{messagesAgreenum},#{messagesReadnum},#{messagesLabel},#{userId})")
    void saveMessage(Message message);

    //修改用户动态
    @Update("update message set messages_type=#{messagesType}" +
            "and messages_info=#{messagesInfo}" +
            "and messages_time=#{messagesTime}" +
            "and messages_collectnum=#{messagesCollectnum}" +
            "and messages_commentnum=#{messagesCommentnum}" +
            "and messages_transpondnum=#{messagesTranspondnum}" +
            "and messages_agreenum=#{messagesAgreenum}" +
            "and messages_readnum=#{messagesReadnum}" +
            "and messages_label=#{messagesLabel}" +
            "and user_id=#{userId}")
    void updateMessage(Message message);

    //删除用户动态
    @Delete("delete from message where messages_id=#{messagesId}")
    void deleteMessage(Message message);
}
