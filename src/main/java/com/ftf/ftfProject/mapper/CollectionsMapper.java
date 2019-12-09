package com.ftf.ftfProject.mapper;

import com.ftf.ftfProject.entity.Collections;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 收藏表
 */
@Repository
public interface CollectionsMapper {

    @Select("select * from collections")
    List<Collections> getCollections();

    //根据UserId查找收藏表
    @Select("select * from collections where user_id=#{userId}")
    List<Collections> selectByUserId();

    //增加Collections表数据
    @Insert("insert into collections(collections_time, collections_status, message_id, user_id) " +
            "values(#{CollectionsTime}, #{CollectionsStatus}, #{messageId}, #{userId})")
    int saveCollection(Collections collection);


    //删除收藏
    @Delete("delete from collections where collections_id=#{CollectionsId}")
    void deleteCollection(Collections collection);

}
