package com.ftf.ftfProject.service.impl;

import com.ftf.ftfProject.entity.Forward;
import com.ftf.ftfProject.mapper.ForwardMapper;
import com.ftf.ftfProject.service.ForwardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ForwardServiceImpl implements ForwardService {
    @Autowired
    private ForwardMapper forwardMapper;


    @Override
    public Boolean saveForward(Forward forward) {
        if (forwardMapper.saveForward(forward) == 1){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Boolean getForward(Integer messageId, Integer userId) {
        if (forwardMapper.getForward(messageId, userId) != null){
            return true;
        }else {
            return false;
        }
    }
}
