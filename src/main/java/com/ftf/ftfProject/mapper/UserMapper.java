package com.ftf.ftfProject.mapper;

import com.ftf.ftfProject.entity.Users;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户表
 */
@Repository
public interface UserMapper {

    @Select("select * from users")
    List<Users> selectAll();

    //登录
    @Select("select * from users where user_nikename=#{userNikename} and user_password=#{userPassword}")
    Users login(Users user);

    //根据用户名进行查询
    @Select("select * from users where user_nikename=#{userNikename}")
    Users findByUsername(Users user);

    //根据用户名进行查询id
    @Select("select * from users where user_nikename=#{userNikename}")
    Users findByUsername1(String userNikename);

    //根据用户Id进行查询用户名
    @Select("select user_nikename from users where user_id=#{userId}")
    String getByUserId(Integer userId);

    //注册 用户名，密码，email，注册时间，默认头像
    @Insert("insert into users(user_nikename, user_password, user_email, user_time, user_Img, user_messagenum) " +
            "values(#{userNikename}, #{userPassword}, #{userEmail}, #{userTime}, #{userImg}, #{userMessageNum})")
    int register(Users user);

    //根据email进行查询用户
    @Select("select * from users where user_email=#{userEmail}")
    Users findByEmail(Users user);

    //删除用户
    @Delete("delete from users where user_id=#{userId}")
    void deleteUser(Users user);

    //找回密码  修改自己账户密码和账户
    @Update("update users set user_nikename=#{userNikename} , user_password=#{userPassword} where user_email=#{userEmail}")
    int updateUser(Users user);

    //根据传入的userId，返回user对象
    @Select("select * from users where user_id=#{userId}")
    Users getUser(Integer userId);

    //ge根据传入的userId，修改自己的头像
    @Update("update users set user_Img = #{userImg} where user_id=#{userId}")
    int updateImg(Integer userId, String userImg);

    //根据传入的用户id进行修改用户信息包括  用户名  真实姓名  个性签名  性别  出生日期
    @Update("update users set user_nikename = #{userNikename} , user_realname = #{realName}" +
            ", user_personalized = #{userPersonalized} , user_sex = #{userSex} " +
            ", user_birthday = #{userBirthday} where user_id=#{userId}")
    int updateUserInfo(Users users);

    //根据传入的userId进行增加发表说说量
    @Update("update users set user_messagenum = user_messagenum+1 where user_id=#{userId}")
    int incMessageNum(Integer userId);

    //根据传入的userId进行减少发表说说量
    @Update("update users set user_messagenum = user_messagenum-1 where user_id = #{userId}")
    int decreaMessageNum(Integer userId);

  /**
     * 后台数据查询
     * @return
     */
    @Select("select * from users where user_id=1")
    Users sclectById();

    @Select("select * from users where user_email=#{email}")
    Users selectByEmail(String email);

    @Insert("insert into users(user_email,user_password,user_nikename,user_time,user_sex,user_status,user_Img,user_birthday)" +
            " values(#{userEmail},#{userPassword},#{userNikename},#{userTime},#{userSex},#{userStatus},#{userImg},#{userBirthday})")
    void insertUser(Users users);
}
