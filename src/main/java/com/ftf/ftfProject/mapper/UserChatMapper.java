package com.ftf.ftfProject.mapper;


import com.ftf.ftfProject.entity.UserChat;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *自己的聊天信息表
 */
@Repository
public interface UserChatMapper {
    //查询所有
    @Select("select * from users_chat")
    List<UserChat> findAll();
}
