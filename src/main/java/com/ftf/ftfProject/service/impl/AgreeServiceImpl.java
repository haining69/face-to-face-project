package com.ftf.ftfProject.service.impl;

import com.ftf.ftfProject.entity.Agree;
import com.ftf.ftfProject.mapper.AgreeMapper;
import com.ftf.ftfProject.service.AgreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgreeServiceImpl implements AgreeService {
    @Autowired
    private AgreeMapper agreeMapper;

    @Override
    public String saveAgree(Agree agree) {
        int i =  agreeMapper.saveAgree(agree);
        System.out.println(i);
        if (i == 1){
            return "true";
        }else {
            return "false";
        }
    }

    @Override
    public Boolean getagree(Integer messageId, Integer userId) {
        Agree agree = agreeMapper.getagree(messageId, userId);
        if (agree != null){
            return true;
        }
        return false;
    }
}
