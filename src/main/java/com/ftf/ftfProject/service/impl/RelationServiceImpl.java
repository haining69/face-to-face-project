package com.ftf.ftfProject.service.impl;

import com.ftf.ftfProject.entity.Relation;
import com.ftf.ftfProject.mapper.RelationMapper;
import com.ftf.ftfProject.service.RelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelationServiceImpl implements RelationService {

    @Autowired
    private RelationMapper relationMapper;

    @Override
    public List<Relation> getAllRelation() {
        return relationMapper.getAllRelation();
    }

    @Override
    public Boolean saveRelation(Relation relation) {
        int i = relationMapper.saveRelation(relation);
        if (i == 1){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Boolean selectByUserIdAndUserById(Integer userId, Integer userbyId) {
        Relation relation = relationMapper.selectByUserIdAndUserById(userId, userbyId);
        if (relation != null){
            return true;
        }else {
            return true;
        }
    }
}
