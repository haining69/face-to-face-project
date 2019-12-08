package com.ftf.ftfProject.mapper;

import com.ftf.ftfProject.entity.Comments;
import com.ftf.ftfProject.entity.Message;
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
    @Select("select * from comments where message_id=#{messageId}")
    List<Comments> selectByMessagesid(Message message);

    //增加当前说说的评论
    @Insert("insert into comments(comments_info, comments_time, message_id, userparent_id)" +
            "values(#{commentsInfo}, #{commentsTime}, #{messageId}, #{userParentId})")
    int saveComment(Comments comments);

    //评论不能修改

    //删除评论
    @Delete("delete from comments where comments_id=#{commentsId}")
    void deleteComment(Comments comments);
}
