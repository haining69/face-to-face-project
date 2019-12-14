package com.ftf.ftfProject.service.impl;

import com.ftf.ftfProject.entity.Img;
import com.ftf.ftfProject.mapper.ImgMapper;
import com.ftf.ftfProject.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImgServiceImpl implements ImgService {
    @Autowired
    private ImgMapper imgMapper;

    @Override
    public Boolean saveImg(Img img) {
        if (imgMapper.saveImg(img) == 1){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<Img> getImgs(int messageId) {
        return imgMapper.getImgs(messageId);
    }
}
