package com.ftf.ftfProject.mapper;

import com.ftf.ftfProject.entity.Relation;
import com.ftf.ftfProject.entity.Users;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 关系表
 */
@Repository
public interface RelationMapper {

    @Select("select * from relation")
    List<Relation> getAllRelation();

    //根据传入的userId进行查询该用户的关注列表
    @Select("select * from relation where user_id=#{userId}")
    List<Relation> getRelation(Integer usersId);

    //根据UserId查询关系表数据
    @Select("select * from relation where user_id=#{userId} and user_byid=#{userbyId}")
    Relation selectByUserIdAndUserById(Integer userId, Integer userbyId);

    //增加用户关系
    @Insert("insert into relation(relation_time, user_id, user_byid)" +
            "values(#{relationTime}, #{userId}, #{userById})")
    int saveRelation(Relation relation);

    //修改用户关系
    @Update("update relation set relation_time=#{relationTime}" +
            "and relation_type=#{relationType}" +
            "and user_id=#{userId}" +
            "and user_byid=#{userById}")
    void updateRelation(Relation relation);

    //删除用户关系
    @Delete("delete from relation where relation_id=#{relationId}")
    void deleteReleation(Relation relation);
}
