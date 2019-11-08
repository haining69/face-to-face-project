package com.ftf.ftfProject.mapper;


import com.ftf.ftfProject.entity.Friend;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 好友表
 */
@Repository
public interface FriendMapper {
    //查询所有
    @Select("select * from friend")
    List<Friend> findAll();
}
