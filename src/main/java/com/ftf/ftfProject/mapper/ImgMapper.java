package com.ftf.ftfProject.mapper;

import com.ftf.ftfProject.entity.Img;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 图片表
 */
@Repository
public interface ImgMapper {

    //存储图片
    @Insert("insert into img(message_id, img_url)" +
            "values(#{messageId}, #{imgUrl}) ")
    public int saveImg(Img img);

    //根据messageId查询图片路径
    @Select("select * from img where message_id = #{messageId}")
    public List<Img> getImgs(int messageId);
}
