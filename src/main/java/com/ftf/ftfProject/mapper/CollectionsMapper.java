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

//    @Select("select * from collections")
//    List<Collections> getCollections();

    //根据UserId和messageId查找收藏表数据
    @Select("select * from collections where user_id=#{userId} and message_id = #{messageId}")
    Collections selectByUserId(Integer messageId, Integer userId);

    //添加Collections表数据
    @Insert("insert into collections(collections_time, collections_status, message_id, user_id) " +
            "values(#{CollectionsTime}, #{CollectionsStatus}, #{messageId}, #{userId})")
    int saveCollection(Collections collection);


    //分页进行查询收藏表数据   后期补
    @Select("select * from collections")
    List<Collections> getCollections();


    //删除收藏
    @Delete("delete from collections where collections_id=#{CollectionsId}")
    void deleteCollection(Collections collection);

}
