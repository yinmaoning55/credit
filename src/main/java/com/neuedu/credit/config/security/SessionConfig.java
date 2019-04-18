package com.neuedu.credit.config.security;

import com.neuedu.credit.Service.TbUserService;
import com.neuedu.credit.pojo.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @Created by elvin on 2018/10/8 15:15.
 * @Describe: 自定义获取session
 */
@Configuration
public class SessionConfig {
    @Autowired
    private TbUserService userService;
    private static int userId;

    private static UserDetails getUserDetails() {
         UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        return userDetails;
    }

    public static String getUserName(){
        return getUserDetails().getUsername();
    }

    public int getUserId(){
        UserInfo userInfo = (UserInfo)getUserDetails();
        System.out.println("获取扩展UserInfo中的内容");
        return userInfo.getUserId();
    }
}
