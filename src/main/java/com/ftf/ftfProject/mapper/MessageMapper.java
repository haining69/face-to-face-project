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

    //根据用户名进行查询动态，查询当前用户所有通过审核的动态消息的总个数
    @Select("select count(*) from message where user_id = (select user_id from users where user_nikename=#{haining69}) and messages_state = ${1}")
    int getTotal(String userNikename);

    //返回总动态条数
    @Select("select count(user_id) from message where trim(user_id)=${22}")
    int getMessageTotal();

    //根据用户名进行分页查询动态消息，并按时间进行降序排序（时间在前面的
    @Select("select * from message where user_id in (select user_id from users where user_nikename=#{userNikename}) ORDER BY messages_time DESC limit #{number},5")
    List<Message> getMessage(String userNikename,int number);

    //根据用户名和内容进行查询消息ID
    @Select("select messages_id from message where user_id = (select user_id from users where user_nikename=#{userNikename}) and messages_info = #{info}")
    int getMessageId(String userNikename,String info);

    //根据传入的message_id进行增加点赞数
    @Update("update message set messages_readnum=messages_readnum+1 where messages_id=${messagesId}")
    int incAgreenum(int messagesId);

    //根据传入的message_id进行减少点赞数
    @Update("update message set messages_readnum=messages_readnum-1 where messages_id=${messagesId}")
    int decreaAgreenum(int messagesId);

    //根据传入的message_id进行增加浏览数
    @Update("update message set messages_agreenum=messages_agreenum+1 where messages_id=${messagesId}")
    int incReadnum(int messagesId);


    @Select("select * from message")
    List<Message> getAllMessage();

    //根据UserId查询该用户的所有动态,并进行分页处理
    @Select("select * from message where user_id=(select user_id from users where user_nikename=#{userNikename}) limit=#{number},10")
    List<Message> selectByUserId();

    //增加用户动态
    @Insert("insert into message(messages_info, messages_time, messages_state," +
            "messages_collectnum, messages_commentnum, messages_transpondnum," +
            "messages_agreenum, messages_readnum, user_id)" +
            "values (#{messagesInfo},#{messagesTime}, #{messagestate}," +
            "#{messagesCollectnum},#{messagesCommentnum},#{messagesTranspondnum}," +
            "#{messagesAgreenum},#{messagesReadnum},#{userId})")
    int saveMessage(Message message);

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
    void deleteMessage(int messagesId);
}
