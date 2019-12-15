package com.ftf.ftfProject.Tools;

import com.ftf.ftfProject.entity.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Pack {
    /**
     * 创建一个message对象
     * @param info
     * @return
     */
    public Message PackMessage(String info, String userId){
        Message message = new Message();
        message.setMessagesInfo(info);
        message.setMessagesAgreenum(0);  //赞同数
        message.setMessagesCollectnum(0);  //收藏数
        message.setMessagesCommentnum(0);  //评论数
        message.setMessagestate(0);    //状态
        message.setMessagesTime(new Date());  //时间戳
        message.setMessagesTranspondnum(0);  //转发数
        message.setMessagesReadnum(0);    //阅读数
        message.setUserId(userId);
        return message;
    }

    /**
     * 创建Comments,并初始化返回对象
     * @return
     */
    public Comments PackComment(String remark,Integer userId,Integer messageId){
        Comments comments = new Comments();
        comments.setCommentsInfo(remark);   //评论内容
        comments.setCommentsTime(new Date());  //评论时间
        comments.setUserId(String.valueOf(userId));  //评论人ID
        comments.setMessageId(String.valueOf(messageId));   //动态ID
        return comments;
    }

    /**
     * 创建Collections对象，初始化并返回对象
     * @param messageId
     * @param userId
     * @return
     */
    public Collections PackCollection(Integer messageId, Integer userId){
        Collections collections = new Collections();
        collections.setCollectionsTime(new Date());
        collections.setCollectionsStatus("无");
        collections.setMessageId(String.valueOf(messageId));
        collections.setUserId(String.valueOf(userId));
        return collections;
    }


    /**
     * 创建Agree对象，初始化并返回对象
     * @param messageId
     * @param userId
     * @return
     */
    public Agree PackAgree(Integer messageId, Integer userId){
        Agree agree = new Agree();
        agree.setMessageId(messageId);
        agree.setUserId(userId);
        return agree;
    }

    /**
     * 创建Relation对象，初始化并返回对象
     * @return
     */
    public Relation PackRelation(Integer userId, Integer userbyId){
        Relation relation = new Relation();
        relation.setRelationTime(new Date());
        relation.setUserId(String.valueOf(userId));
        relation.setUserById(String.valueOf(userbyId));
        return relation;
    }

    /**
     * 创建Forward对象，初始化并返回对象
     * @param messageId
     * @param userId
     * @return
     */
    public Forward PackForward(Integer messageId, Integer userId){
        Forward forward = new Forward();
        forward.setMessageId(messageId);
        forward.setUserId(userId);
        return forward;
    }

    /**
     * 创建Img对象，初始化并返回对象
     * @param messageId
     * @param url
     * @return
     */
    public Img PackImg(Integer messageId, String url){
        Img img = new Img();
        img.setMessageId(messageId);
        img.setImgUrl(url);
        return img;
    }

    /**
     * 创建user对象，初始化并返回对象
     * @param userEmail
     * @param userNikename
     * @param userPassword
     * @return
     */
    public Users PackUser(String userEmail, String userNikename, String userPassword){
        Users user = new Users();
        user.setUserNikename(userNikename);  //用户名
        user.setUserPassword(userPassword);  //密码
        user.setUserEmail(userEmail);   //email
        user.setUserTime(new Date());   //注册时间
        user.setUserImg("http://q2cp0cbhu.bkt.clouddn.com/25df441c-0c52-4f22-b379-68705d721805");
        user.setUserMessageNum(0);
        user.setUserBirthday(new Date());
        return user;
    }


    /**
     * 修改用户信息封装的user类，初始化并返回对象
     * @param userId
     * @param userNikename
     * @param realName
     * @param userPersonalized
     * @param userSex
     * @param userBirthday
     * @return
     */
    public Users PackUser(Integer userId , String userNikename, String realName , String userPersonalized ,String userSex ,Date userBirthday){
        Users user = new Users();
        user.setUserId(String.valueOf(userId));
        user.setUserNikename(userNikename);  //用户名
        user.setRealName(realName);  //密码
        user.setUserPersonalized(userPersonalized);   //email
        user.setUserSex(userSex);   //注册时间
        user.setUserMessageNum(0);
        user.setUserBirthday(userBirthday);
        return user;
    }

    /**
     * 创建回复表对象，初始化并返回对象
     * @param userId
     * @param parentid
     * @param replyInfo
     * @param userById
     * @return
     */
    public Reply PackReply(Integer userId, Integer parentid, String replyInfo, Integer userById){
        Reply reply = new Reply();
        reply.setReplyUserId(userId);
        reply.setReplyByUserId(userById);
        reply.setReplyInfo(replyInfo);
        reply.setCommentParentId(parentid);
        reply.setReplyTime(new Date());
        return reply;
    }
}
