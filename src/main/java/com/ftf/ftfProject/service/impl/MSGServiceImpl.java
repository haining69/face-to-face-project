package com.ftf.ftfProject.service.impl;

import com.ftf.ftfProject.entity.MSG;
import com.ftf.ftfProject.mapper.MSGMapper;
import com.ftf.ftfProject.service.MSGService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MSGServiceImpl implements MSGService {

    @Autowired
    private MSGMapper msgMapper;

    @Override
    public List<MSG> getAllMSG() {
        return msgMapper.findAll();
    }
}
