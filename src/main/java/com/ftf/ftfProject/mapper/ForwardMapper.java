package com.ftf.ftfProject.mapper;

import com.ftf.ftfProject.entity.Forward;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * 转发表
 */
@Repository
public interface ForwardMapper {

    //增加转发表记录
    @Insert("insert into forward(message_id, user_id)" +
            "values(#{messageId}, #{userId})")
    int saveForward(Forward forward);

    //查询转发记录
    @Select("select * from forward where message_id = #{messageId} and user_id = #{userId}")
    Forward getForward(Integer messageId, Integer userId);
}
