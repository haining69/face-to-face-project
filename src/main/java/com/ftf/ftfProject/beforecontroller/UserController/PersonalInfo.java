package com.ftf.ftfProject.beforecontroller.UserController;

import com.ftf.ftfProject.Tools.Pack;
import com.ftf.ftfProject.Tools.QiniuUpload;
import com.ftf.ftfProject.entity.Users;
import com.ftf.ftfProject.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


/**
 * 用户查询个人信息
 */
@Controller
@RequestMapping("/personinfo")
public class PersonalInfo {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private QiniuUpload qiniuUpload;
    @Autowired
    private Pack PackUser;

    //根据用户Id进行查询用户信息
    @RequestMapping("/getpersoninfo")
    @ResponseBody
    public Users getPersonInfo(Integer userId){
        return userService.getUser(userId);
    }


    /**
     * 修改个人头像
     * 如果成功返回用户存储在七牛云上的图片路径
     * 否则返回false
     * @param file
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/updateImg")
    @ResponseBody
    public String updateImg(MultipartFile file, HttpServletRequest request) throws Exception {
        String url = null;   //存储上传成功的图片路径
        String userId = request.getParameter("userId");  //获取用户Id
        if (file != null){
            //上传文件并返回url
            url = qiniuUpload.updateFile(file, UUID.randomUUID().toString()+"-"+file.getOriginalFilename());
            //存储图片
            userService.updateImg(Integer.parseInt(userId), url);
            return url;
        }else {
            return "false";
        }
    }

    /**
     *修改用户个人信息  ,如果用户名存在并于当前用户不同时返回false
     *如果用户名不存在进行进行更新并返回true
     * 如果与当前用户一致，则进行更新
     * @param userNikename
     * @param realName
     * @param userPersonalized
     * @param userSex
     * @param userBirthday
     * @return
     */
    @RequestMapping("/updateuserinfo")
    @ResponseBody
    public String updateUserInfo(Integer userId1, String userNikename, String realName , String userPersonalized ,String userSex ,String userBirthday) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//定义一个formate
        Date date = simpleDateFormat.parse(userBirthday);//将formate型转化成Date数据类型
        int userId = userService.findByUsername1(userNikename);
        if (userId == -1){   //说明没有重名，保存更改的信息
            Users users = PackUser.PackUser(userId1,userNikename, realName, userPersonalized, userSex, date);
            userService.updateUserInfo(users);   //更新信息
//            System.out.println("没崇明");
//            System.out.println(users);
            return "true";
        }else {  //如果用户名存在
            if (userId == userId1){  //如果用户名与当前用户一致
                Users users = PackUser.PackUser(userId1, userNikename, realName, userPersonalized, userSex, date);
                userService.updateUserInfo(users);   //更新信息
//                System.out.println("没更新用户名！");
//                System.out.println(users);
                return "true";
            }else {
                return "false";
            }
        }
    }
}
