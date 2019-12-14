package com.ftf.ftfProject.service;

import com.ftf.ftfProject.entity.Img;

import java.util.List;

public interface ImgService {

    /**
     * 根据传入对象进行存储img
     * @return
     */
    public Boolean saveImg(Img img);

    /**
     * 根据messageId进行查询imgs
    * @return
     */
    public List<Img> getImgs(int messageId);
}
