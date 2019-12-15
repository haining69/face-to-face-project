package com.ftf.ftfProject.mapper;

import com.ftf.ftfProject.entity.Reply;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 回复表dao层
 */
@Repository
public interface ReplyMapper {

    //根据评论父Id进行查询子评论
    @Select("select * from reply where commentparent_id = #{commentId}")
    List<Reply> getReplys(Integer commentId);

    //保存回复评论 评论人   被评论人   评论内容  回复的评论Id   评论时间
    @Update("insert into reply(reply_userid, reply_byuserid, reply_info, commentparent_id, reply_time)" +
            "values(#{replyUserId}, #{replyByUserId}, #{replyInfo}, #{commentParentId}, #{replyTime})")
    int saveReply(Reply reply);

    //寻找replyId
    @Select("select reply_id from reply where reply_userid=#{userId} and reply_byuserid=#{pearentId} ORDER BY reply_time DESC")
    List<Integer> getReplyId(int userId, int pearentId);
}
