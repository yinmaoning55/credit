package com.neuedu.credit.controller;

import com.neuedu.credit.Service.AccountService;
import com.neuedu.credit.Service.PersonInfoService;
import com.neuedu.credit.Service.TbEnterpriseService;
import com.neuedu.credit.Service.UserAuthenticationService;
import com.neuedu.credit.pojo.Account;
import com.neuedu.credit.pojo.PersonInfo;
import com.neuedu.credit.pojo.SpecialEntity.ResponseEntity;
import com.neuedu.credit.pojo.TbEnterprise;
import com.neuedu.credit.pojo.UserAuthentication;
import com.neuedu.credit.pojo.enums.ResponseEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Created by elvin on 2018/9/25 15:44.
 * @Describe:
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    PersonInfoService personInfoService;
    @Autowired
    TbEnterpriseService enterpriseService;
    @Autowired
    UserAuthenticationService userAuthenticationService;
    @Autowired
    AccountService accountService;

    /**
     * @Created elvin yuan on 17:13 2018/11/7
     * @Describe //TODO 查询用户最近提交的实名认证信息
     * @Param
     * @return
    */
    @ResponseBody
    @RequestMapping("/get/auth/{userid}")
    public UserAuthentication getAuthentication(@PathVariable int userid){
        return userAuthenticationService.getByUserId(userid);
    }

    /**
     * @Created elvin yuan on 17:15 2018/11/7
     * @Describe //TODO 审核
     * @Param id: authId； status 1 通过，2失败
     * @return
    */
    @ResponseBody
    @RequestMapping("/change/auth/{id}/{status}")
    public UserAuthentication changeAuthentication(@PathVariable int id,@PathVariable int status){
        UserAuthentication authentication = new UserAuthentication();
        authentication.setStatus(status);
        authentication.setId(id);
        return userAuthenticationService.update(authentication);
    }

    @ResponseBody
    @RequestMapping("/get/person/{id}")
    public PersonInfo getPersonInfo(@PathVariable int id){
        return personInfoService.get(id);
    }
    @ResponseBody
    @RequestMapping("/get/enter/{id}")
    public TbEnterprise getEnterprise(@PathVariable int entid){
        return enterpriseService.findById(entid);
    }

    @ResponseBody
    @RequestMapping("/accounts")
    public ResponseEntity accountList(){
       List<Account> accountList = accountService.list();
       return new ResponseEntity(ResponseEnum.SUCESSFUL,accountList);
    }

    @ResponseBody
    @RequestMapping("/inaccount/{id}/{found}")
    public ResponseEntity inAccount(@PathVariable int id, @PathVariable Long found){

        accountService.inAccount(id,found);
        return new ResponseEntity(ResponseEnum.SUCESSFUL,"充值成功");
    }

}
