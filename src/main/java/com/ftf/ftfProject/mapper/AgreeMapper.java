package com.ftf.ftfProject.mapper;

import com.ftf.ftfProject.entity.Agree;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * 点赞表
 */
@Repository
public interface AgreeMapper {

    //增加点赞表数据
    @Insert("insert into agree(message_id, user_id)" +
            "values(#{messageId}, #{userId})")
    int saveAgree(Agree agree);

    //根据文章id与userId查询点赞id
    @Select("select agree_id from agree where message_id = #{messageId} and user_id = #{userId}")
    Agree getagree(Integer messageId, Integer userId);
}