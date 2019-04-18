package com.neuedu.credit.controller;

import com.neuedu.credit.Service.PersonInfoService;
import com.neuedu.credit.Service.TbEnterpriseService;
import com.neuedu.credit.Service.TbUserService;
import com.neuedu.credit.Service.UserAuthenticationService;
import com.neuedu.credit.config.security.SessionConfig;
import com.neuedu.credit.pojo.PersonInfo;
import com.neuedu.credit.pojo.TbEnterprise;
import com.neuedu.credit.pojo.TbUser;
import com.neuedu.credit.pojo.UserAuthentication;
import com.neuedu.credit.pojo.enums.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.*;

/**
 * @Created by elvin on 2018/9/21 10:16.
 * @Describe: 用于前台用户
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    SessionConfig sessionConfig;
    @Autowired
    TbUserService tbUserService;
    @Autowired
    PersonInfoService personInfoService;
    @Autowired
    TbEnterpriseService enterpriseService;
    @Autowired
    UserAuthenticationService userAuthenticationService;

    @RequestMapping("/index")
    public String index(Model model) {
        TbUser tbUser =  tbUserService.findById(sessionConfig.getUserId());
        Map map = new HashMap<>();
        map.put("username",tbUser.getUsername());
        map.put("authType",tbUser.getAuthentication());
        map.put("email",tbUser.getEmail());
        map.put("mobile",tbUser.getMobile());
        model.addAllAttributes(map);
       return "/user/index";
    }

    @ResponseBody
    @RequestMapping("/list")
    public List<TbUser> list() {
        return tbUserService.findAll();
    }

    @ResponseBody
    @RequestMapping("/list/{name}/{page}/{size}")
    public Page<TbUser> list(@PathVariable String name,  @PathVariable int page , @PathVariable int size) {

        return tbUserService.findByPageAndParams(name,page,size);
    }

    @ResponseBody
    @RequestMapping("/get/{id}")
    public TbUser  getById(@PathVariable int id){
        return  tbUserService.findById(id);
    }

    @ResponseBody
    @RequestMapping("/change/{id}/{status}")
    public TbUser changeStatus(@PathVariable int id, @PathVariable int status){
        TbUser tbUser = tbUserService.findById(id);
        tbUser.setStatus(status);
        tbUser.setModifytime(new Timestamp(new Date().getTime()));
        tbUserService.update(tbUser);
        return tbUser;
    }

    @ResponseBody
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public  TbUser save(@RequestParam int[] role, TbUser user) throws Exception {
        if(user.getUsername() == null || user.getUsername() =="")
        {
            throw new Exception("用户名不能为空！");
        }
        user.setAuthentication(Authentication.ENTERPRISE_AUTHENTICATION.getCode());
        Date date = new Date();
        user.setCreatetime(new Timestamp(date.getTime()));
        user.setModifytime(new Timestamp(date.getTime()));
        tbUserService.add(user,role);
        return user;
    }

    @ResponseBody
    @RequestMapping("/addfor")
    public  String addfor(){

        Long beginTime = System.currentTimeMillis();
        List<TbUser> list = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            TbUser user = new TbUser();
            user.setName("测试用户");
            user.setAlias("test"+i);
            user.setUsername(user.getAlias());
//            user.setPassword(new BCryptPasswordEncoder().encode("123456"));
            user.setStatus(1);
            user.setAuthentication(0);
            user.setEmail("qq"+i+"@test.com");
            user.setMobile(""+ (13000+i)+"010029");
            Timestamp timestamp = new Timestamp(new Date().getTime());
            user.setCreatetime(timestamp);
            user.setModifytime(timestamp);
            list.add(user);
        }
        for (TbUser user : list)
        {
            tbUserService.add(user, new int[]{});
        }
        Long endTime = System.currentTimeMillis();
        return "新增100条数据，用时："+ String.valueOf( endTime -beginTime) +"毫秒";
    }
    @ResponseBody
    @RequestMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        TbUser tbUser = tbUserService.findById(id);
        tbUser.setStatus(-1);
        tbUser.setModifytime(new Timestamp(new Date().getTime()));
        tbUserService.update(tbUser);
    }

    @RequestMapping(value = "/auth")
    public String addAuth(Model model){
        model.addAttribute("person","");
        return "/auth/person";
    }

    @ResponseBody
    @RequestMapping(value = "/auth",method ={ RequestMethod.POST} )
    @Transactional
    public PersonInfo addAuth(PersonInfo personInfo){
        personInfo.setCreatetime(new Timestamp(new Date().getTime()));
        personInfoService.add(personInfo);

        UserAuthentication authentication = new UserAuthentication();
        authentication.setUser_id(2);
        authentication.setAuthenticationtype(Authentication.PERSON_AUTHENTICATION.getCode());
        authentication.setAuthenticationinfo_id(personInfo.getId());
        authentication.setStatus(0);
        userAuthenticationService.add(authentication);
        return personInfo;
    }

    /**
     * @Created elvin yuan on 10:00 2018/10/12
     * @Describe //TODO 企业认证 GET 方法
     * @Param userId
     * @return
    */
    @RequestMapping("/auth2")
    public String getAuth2(Model model){
       UserAuthentication authentication = userAuthenticationService.getByUserId(sessionConfig.getUserId());
       TbEnterprise enterprise = new TbEnterprise();
       if(authentication == null)
       {
           model.addAttribute("enterprise",enterprise);
           return "auth/enterprise";
       }
       if(authentication.getAuthenticationtype().equals(Authentication.ENTERPRISE_AUTHENTICATION.getCode())){
           enterprise = enterpriseService.findById(authentication.getAuthenticationinfo_id());
       }
       model.addAttribute("enterprise",enterprise);
       return "/auth/enterprise";
    }

    @ResponseBody
    @RequestMapping(value = "/auth2",method = RequestMethod.POST )
    @Transactional
    public TbEnterprise addAuth2(TbEnterprise enterprise){
        enterprise.setCreatetime(new Timestamp(new Date().getTime()));
        enterpriseService.save(enterprise);

        UserAuthentication authentication = new UserAuthentication();
        authentication.setUser_id(sessionConfig.getUserId());
        authentication.setAuthenticationtype(Authentication.ENTERPRISE_AUTHENTICATION.getCode());
        authentication.setAuthenticationinfo_id(enterprise.getEntid());
        authentication.setStatus(0);
        userAuthenticationService.add(authentication);
        return enterprise;
    }
}
