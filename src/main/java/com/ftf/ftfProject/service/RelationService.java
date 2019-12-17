package com.ftf.ftfProject.service;

import com.ftf.ftfProject.entity.Relation;
import com.ftf.ftfProject.entity.Users;

import java.util.List;

public interface RelationService {

    List<Relation> getAllRelation();

    /**
     * 保存关注
     * @return
     */
    Boolean saveRelation(Relation relation);

    /**
     * 根据关注人的id和被关注的id进行查询，看是否关注过
     * @param userId
     * @param userbyId
     * @return
     */
    Boolean selectByUserIdAndUserById(Integer userId,Integer userbyId);

    /**
     * 根据传入的userId进行查询该用户的关注表
     * 并返回用户列表
     * @param userId
     * @return
     */
    List<Users> getRelation(Integer userId);
}
