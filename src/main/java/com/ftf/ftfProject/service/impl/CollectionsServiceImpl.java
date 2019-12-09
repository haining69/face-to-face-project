package com.ftf.ftfProject.service.impl;

import com.ftf.ftfProject.entity.Collections;
import com.ftf.ftfProject.mapper.CollectionsMapper;
import com.ftf.ftfProject.service.CollectionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionsServiceImpl implements CollectionsService {

    @Autowired
    private CollectionsMapper collectionsMapper;

    @Override
    public List<Collections> getCollections() {
        return collectionsMapper.getCollections();
    }

    @Override
    public String  saveCollection(Collections collections) {
        int i = collectionsMapper.saveCollection(collections);
        if (i == 1){
            return "true";
        }else {
            return "false";
        }
    }
}
