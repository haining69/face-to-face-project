package com.ftf.ftfProject.beforecontroller.UserController;

import com.ftf.ftfProject.Tools.QiniuUpload;
import com.ftf.ftfProject.entity.Users;
import com.ftf.ftfProject.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;


/**
 * 用户更新个人信息
 */
@Controller
@RequestMapping("/personinfo")
public class PersonalInfo {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private QiniuUpload qiniuUpload;

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
     * 修改用户个人信息  ,如果用户名存在返回false
     * 如果用户名不存在进行进行更新并返回true
     * @param users
     * @return
     */
    @RequestMapping("/updateuserinfo")
    @ResponseBody
    public String updateUserInfo(Users users, Integer userId){
        if (!userService.findByUsername(users)){   //如果该用户名不存在则进行更新  如果存在则不进行更新
            userService.updateUserInfo(users, userId);
            return "true";
        }else {
            return "false";
        }
    }
}
