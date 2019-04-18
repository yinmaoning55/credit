package com.neuedu.credit.controller;

import com.neuedu.credit.Service.CreditObjectionService;
import com.neuedu.credit.config.security.SessionConfig;
import com.neuedu.credit.pojo.CreditObjection;
import com.neuedu.credit.pojo.SpecialEntity.ResponseEntity;
import com.neuedu.credit.pojo.enums.ResponseEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import java.sql.Timestamp;
import java.util.Date;

/**
 * @Created by elvin on 2018/10/11 11:01.
 * @Describe: 信用异议
 */
@Controller
@RequestMapping("/objection")
public class ObjectionCotroller {
    private static final String TAG = "ObjectionCotroller";
    @Autowired
    SessionConfig sessionConfig;
    @Autowired
    CreditObjectionService objectionService;

    @RequestMapping("/add")
    public String addObjection(Model model){
        CreditObjection objection = new CreditObjection();
        model.addAttribute("obj",objection);
        return "other/objection";
    }
    @ResponseBody
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResponseEntity addObjection(CreditObjection objection){
        objection.setUserId(sessionConfig.getUserId());
        objection.setCreatetime(new Timestamp(new Date().getTime()));
        objectionService.save(objection);
        return new ResponseEntity(ResponseEnum.SUCESSFUL,objection);
    }
}
