package com.ftf.ftfProject.mapper;

import com.ftf.ftfProject.entity.MSG;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 聊天信息表
 */
@Repository
public interface MSGMapper {

    //查询所有
    @Select("select * from msg")
    List<MSG> findAll();
}
