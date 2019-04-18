package com.neuedu.credit.controller;

import com.neuedu.credit.Service.AccountService;
import com.neuedu.credit.config.security.SessionConfig;
import com.neuedu.credit.pojo.Account;
import com.neuedu.credit.pojo.SpecialEntity.ResponseEntity;
import com.neuedu.credit.pojo.enums.ResponseEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @Created by elvin on 2018/10/8 8:44.
 * @Describe: 资金账户
 */
@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountService accountService;
    @Autowired
    SessionConfig sessionConfig;

    /**
     * @Created elvin yuan on 8:51 2018/10/8
     * @Describe //TODO 开通资金账户
     * @Param
     * @return
    */
    @ResponseBody
    @RequestMapping("/add/{pwd}")
    public ResponseEntity addAccount(@PathVariable String pwd, HttpServletRequest request){
        try {
            Account account = new Account();
            account.setUserId(sessionConfig.getUserId());
            account.setUseableFund(1L);
            account.setTotalConsumption(0L);
            account.setForzenFund(0);
            account.setPaymentpassword(pwd);
            account.setModifytime(new Timestamp(new Date().getTime()));
            accountService.add(account);
        } catch (DataIntegrityViolationException divE)
        {
            return  new ResponseEntity(ResponseEnum.FAILED,"不可重复开通资金账户！");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return  new ResponseEntity(ResponseEnum.SUCESSFUL,"用户添加成功！");
    }

    @ResponseBody
    @RequestMapping("/change/{pwd}/{newpwd}")
    public ResponseEntity changePwd(@PathVariable String pwd,@PathVariable String newpwd){
        accountService.changepassword(1,pwd,newpwd);
        return  new ResponseEntity(ResponseEnum.SUCESSFUL,"用户添加成功！");
    }
    @ResponseBody
    @RequestMapping("/get")
    public ResponseEntity getAccount(){
        Account account = accountService.get(1);
        return  new ResponseEntity(ResponseEnum.SUCESSFUL,account);
    }

}
