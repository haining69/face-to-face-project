package com.ftf.ftfProject.service.impl;

import com.ftf.ftfProject.Tools.Verify;
import com.ftf.ftfProject.entity.Users;
import com.ftf.ftfProject.mapper.UserMapper;
import com.ftf.ftfProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private Verify verify;


    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Users> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public Boolean login(Users user) {
//        System.out.println(user);
        if (userMapper.login(user) != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean findByUsername(Users user) {
        Users user1 = userMapper.findByUsername(user);
//        System.out.println(user1);
        if (user1 == null){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void register(Users user) {
        userMapper.register(user);
    }

    //发送邮箱并返回验证码
    @Override
    public String verify(String email) throws MessagingException {
        String checkcode =  verify.getchcekcode();
        verify.sendMsg(email, checkcode);
        return checkcode;
    }

    //根据用户名进行查询
    @Override
    public Boolean findByEmail(Users user) {
        if (userMapper.findByEmail(user) == null){
            return true;
        }else{
            return false;
        }
    }



    @Override
    public Users findById() {

        return userMapper.sclectById();
    }

    @Override
    public Users findByEmail(String email) {
        return userMapper.selectByEmail(email);
    }

    @Override
    public void addUser(Users users) {
        userMapper.insertUser(users);
    }

}


/**@author 17609184675
 * 发邮件工具类
 */
//public  class MailUtils {
//
//    //    olyznfhadvmgbfhh
//    private static final String USER = "578499233@qq.com"; // 发件人称号，同邮箱地址
//    private static final String PASSWORD = "pfbrwehwyyrjbcjc";//密码
//
//    /**
//     * @param to    收件人邮箱
//     * @param text  邮件正文
//     * @param title 标题
//     */
//    /* 发送验证信息的邮件 */
//    public static boolean sendMail(String to, String text, String title) {
//        try {
//            final Properties props = new Properties();
//            props.put("mail.smtp.auth", "true");
//            props.put("mail.smtp.host", "smtp.qq.com");
//
//            // 发件人的账号
//            props.put("mail.user", USER);
//            //发件人的密码
//            props.put("mail.password", PASSWORD);
//
//            // 构建授权信息，用于进行SMTP进行身份验证
//            Authenticator authenticator = new Authenticator() {
//                @Override
//                protected PasswordAuthentication getPasswordAuthentication() {
//                    // 用户名、密码
//                    String userName = props.getProperty("mail.user");
//                    String password = props.getProperty("mail.password");
//                    return new PasswordAuthentication(userName, password);
//                }
//            };
//            // 使用环境属性和授权信息，创建邮件会话
//            Session mailSession = Session.getInstance(props, authenticator);
//            // 创建邮件消息
//            MimeMessage message = new MimeMessage(mailSession);
//            // 设置发件人
//            String username = props.getProperty("mail.user");
//            InternetAddress form = new InternetAddress(username);
//            message.setFrom(form);
//
//            // 设置收件人
//            InternetAddress toAddress = new InternetAddress(to);
//            message.setRecipient(Message.RecipientType.TO, toAddress);
//
//            // 设置邮件标题
//            message.setSubject(title);
//
//            // 设置邮件的内容体
//            message.setContent(text, "text/html;charset=UTF-8");
//            // 发送邮件
//            Transport.send(message);
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
//
//    public void send(String email,String message) {
//
//        try {
//
//            boolean flag= MailUtils.sendMail(email,message,"测试邮件");
//            if(flag)
//                System.out.println("发送成功");
//            else
//                System.out.println("发送失败");
//
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//}
