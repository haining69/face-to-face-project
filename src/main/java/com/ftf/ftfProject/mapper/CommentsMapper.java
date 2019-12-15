package com.ftf.ftfProject.mapper;

import com.ftf.ftfProject.entity.Comments;
import com.ftf.ftfProject.entity.Message;
import com.ftf.ftfProject.metaclass.UserComment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 评论表
 */
@Repository
public interface CommentsMapper {

    @Select("select * from comments")
    List<Comments> getAllComments();

    //根据messages_id查找当前评论表数据
    @Select("select * from comments where message_id=#{messageId} ORDER BY comments_time ASC")
    List<Comments> selectByMessagesid(int messageId);

    //增加当前说说的评论
    @Insert("insert into comments(comments_info, comments_time, message_id, user_id)" +
            "values(#{commentsInfo}, #{commentsTime}, #{messageId}, #{userId})")
    int saveComment(Comments comments);

    //根据三个参数查询
    @Select("select comments_id from comments where comments_info=#{commentInfo} and user_id=#{userId} and message_id=#{messageId} ORDER BY comments_time DESC")
    List<Integer> getCommentId(Integer messageId,String commentInfo,Integer userId);

    //删除评论
    @Delete("delete from comments where comments_id=#{commentsId}")
    void deleteComment(Comments comments);
}
