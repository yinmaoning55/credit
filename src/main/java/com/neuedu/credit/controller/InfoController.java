package com.neuedu.credit.controller;

import com.neuedu.credit.Service.TbEntLegalService;
import com.neuedu.credit.Service.TbEnterpriseService;
import com.neuedu.credit.config.security.SessionConfig;
import com.neuedu.credit.pojo.SpecialEntity.ResponseEntity;
import com.neuedu.credit.pojo.TbEntLegal;
import com.neuedu.credit.pojo.TbEnterprise;
import com.neuedu.credit.pojo.enums.ResponseEnum;
import com.neuedu.credit.repository.phoenix.EnterpriseInfoPho;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.List;

/**
 * @Created by elvin on 2018/10/12 14:07.
 * @Describe: 企业信用信息
 */
@Controller
@RequestMapping("/info")
public class InfoController {

    @Autowired
    SessionConfig sessionConfig;
    @Autowired
    TbEnterpriseService enterpriseService;
    @Autowired
    TbEntLegalService entLegalService;
    @Autowired
    EnterpriseInfoPho enterpriseInfoPho;

    @RequestMapping("/suppEnter")
    public String enterprise(Model model) {
        TbEnterprise originalEnterprise = enterpriseService.findByUserId(sessionConfig.getUserId());
        model.addAttribute("oriEnt", originalEnterprise);
        return "info/enterprise";
    }

    /**
     * @return
     * @Created elvin yuan on 15:00 2018/10/12
     * @Describe //TODO 补充企业信用信息
     * @Param
     */
    @ResponseBody
    @RequestMapping(value = "/suppEnter", method = RequestMethod.POST)
    public String supplementEnterprise(TbEnterprise enterprise) {
        TbEnterprise originalEnterprise = enterpriseService.findByUserId(sessionConfig.getUserId());
        originalEnterprise.setRegisteraddr(enterprise.getRegisteraddr());
        originalEnterprise.setRegistermoney(enterprise.getRegistermoney());
        enterpriseService.save(enterprise);
        return "success";
    }

    @RequestMapping("/entlegal")
    public String addEntLegal(Model model) {
        TbEnterprise originalEnterprise = enterpriseService.findByUserId(sessionConfig.getUserId());
        TbEntLegal entLegal = new TbEntLegal();
        entLegal.setEntId(originalEnterprise.getEntid());

        model.addAttribute("legal", entLegal);
        return "info/legal";
    }

    @ResponseBody
    @RequestMapping(value = "/entlegal", method = RequestMethod.POST)
    public ResponseEntity addEntLegal(TbEntLegal entLegal) {
        entLegalService.save(entLegal);
        return new ResponseEntity(ResponseEnum.SUCESSFUL, entLegal);
    }

    /*
     * @Created elvin yuan on 17:24 2018/11/12
     * @Describe //TODO 通过phoenix从Hbase中读取数据
     * @Param entid 企业id号
     * @return
     */
    @RequestMapping("/getEnt/{entid}")
    public String getEnterprise(@PathVariable int entid,Model model) throws SQLException, ParseException {
        TbEnterprise enterprise = enterpriseInfoPho.query(entid).get(0);
        model.addAttribute("ent",enterprise);
        return "info/entshow";
    }

    @RequestMapping(value = "/entList/",method = RequestMethod.POST)
    public String getEnterprise(@RequestParam String name, Model model) throws SQLException, ParseException {
        List<TbEnterprise> entList = enterpriseInfoPho.queryList(name);
        model.addAttribute("entlist",entList);
        return "info/entindex";
    }

   /* @RequestMapping("/entList/{name}")
    public String getEnterprise(@PathVariable String name,Model model) throws SQLException, ParseException {
        List<TbEnterprise> entList = enterpriseInfoPho.queryList(name);
        model.addAttribute("entlist",entList);
        return "info/entindex";
//        return new ResponseEntity(ResponseEnum.SUCESSFUL, entList);
    }*/

    @ResponseBody
    @RequestMapping("/upsert/{sql}")
    public void upEnterprise(@PathVariable String sql) throws SQLException, ParseException {
        enterpriseInfoPho.upsert(sql);
    }
}
