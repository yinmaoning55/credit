package com.neuedu.credit.controller;

import com.neuedu.credit.Service.TbUserService;
import com.neuedu.credit.pojo.SpecialEntity.ResponseEntity;
import com.neuedu.credit.pojo.TbUser;
import com.neuedu.credit.pojo.enums.Authentication;
import com.neuedu.credit.pojo.enums.ResponseEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.Date;


/**
 * @Created by elvin on 2018/9/26 9:35.
 * @Describe: 用户 - 注册、登录、登出、找回密码等
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    TbUserService userService;

    /**
     * @Created elvin yuan on 8:54 2018/9/28
     * @Describe //TODO 注册时，需要填写邮箱（用户名）、密码、
     * @Param
     * @return
    */
    @ResponseBody
    @RequestMapping(value = "/register",method = {RequestMethod.POST})
    public String register(TbUser user, Model model){
        user.setUsername(user.getEmail());
        if(user.getUsername() == null || user.getUsername() =="")
        {
            model.addAttribute("m1",user);
            return "redirect:/login/register";
        }
        System.out.println("3====================================================");
        user.setAuthentication(Authentication.NO_AUTHENTICATION.getCode());
        System.out.println("4===================================================");
        Date date = new Date();
        System.out.println("5===================================================");
        user.setCreatetime(new Timestamp(date.getTime()));
        System.out.println("6===================================================");
        user.setModifytime(new Timestamp(date.getTime()));
        System.out.println("7===================================================");
        userService.register(user);
        System.out.println("2====================================================");
        ResponseEntity responseEntity= new ResponseEntity(ResponseEnum.SUCESSFUL,user);
        model.addAttribute("m",user);
        System.out.println("1====================================================");
        return "redirect:/";
    }
    /**
     * @Created elvin yuan on 11:52 2018/11/8
     * @Describe //TODO 绑定手机号
     * @Param 
     * @return 
    */
    @ResponseBody
    @RequestMapping("/bindmobile/{mobile}/{verifycode}")
    public ResponseEntity bindMobile(@PathVariable  String mobile,@PathVariable  String verifycode){
        TbUser user=userService.bindMobile(mobile,verifycode);
        if (user==null)
        {
            return new ResponseEntity(ResponseEnum.FAILED);
        }
        return  new ResponseEntity(ResponseEnum.SUCESSFUL,user);
    }
}
