package com.ftf.ftfProject.service.impl;

import com.ftf.ftfProject.Tools.Pack;
import com.ftf.ftfProject.entity.Forward;
import com.ftf.ftfProject.entity.Img;
import com.ftf.ftfProject.mapper.ForwardMapper;
import com.ftf.ftfProject.service.ForwardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Service
public class ForwardServiceImpl implements ForwardService {
    @Autowired
    private ForwardMapper forwardMapper;
    @Autowired
    private ImgServiceImpl imgService;
    @Autowired
    private Pack PackImg;


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

    @Override
    public Boolean forwardImg(Integer messageId, Integer userId) {
        List<Img> imgList = imgService.getImgs(messageId);
        if (imgList != null){
            for (Img img : imgList) {
                String url = img.getImgUrl();  //获取url
                Img img1 = PackImg.PackImg(messageId, url);  //封装实体类
                imgService.saveImg(img1);   //进行保存图片
            }
        }
        return true;
    }
}
