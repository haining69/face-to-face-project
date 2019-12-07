package com.ftf.ftfProject.mapper;

import com.ftf.ftfProject.entity.Users;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

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
    @Select("select user_id from users where user_nikename=${userNikename}")
    int findByUsername1(String userNikename);

    //注册 (name, money) values(#{name},#{money})
    @Insert("insert into users(user_nikename, user_password, user_email, user_time) values(#{userNikename}, #{userPassword}, #{userEmail}, #{userTime})")
    void register(Users user);

    //根据email进行查询用户
    @Select("select * from users where user_email=#{userEmail}")
    Users findByEmail(Users user);

    //删除用户
    @Delete("delete from users where user_id=#{userId}")
    void deleteUser(Users user);

    //找回密码  修改自己账户密码和账户
    @Update("update users set user_nikename=#{userNikename} , user_password=#{userPassword} where user_email=#{userEmail}")
    int updateUser(Users user);


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
