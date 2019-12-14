package com.ftf.ftfProject.metaclass;

import com.ftf.ftfProject.entity.Img;
import com.ftf.ftfProject.entity.Message;

import java.io.Serializable;
import java.util.List;

public class MessageAndImgs implements Serializable {
    private Message message;   //文章内容
    private List<Img> imgs;   //文章的图片集

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public List<Img> getImgs() {
        return imgs;
    }

    public void setImgs(List<Img> imgs) {
        this.imgs = imgs;
    }

    @Override
    public String toString() {
        return "MessageAndImgs{" +
                "message=" + message +
                ", imgs=" + imgs +
                '}';
    }
}
