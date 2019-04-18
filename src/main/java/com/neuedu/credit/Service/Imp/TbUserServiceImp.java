package com.neuedu.credit.Service.Imp;

import com.neuedu.credit.Service.TbUserService;
import com.neuedu.credit.pojo.TbUser;
import com.neuedu.credit.pojo.UserRole;
import com.neuedu.credit.pojo.VerificationCode;
import com.neuedu.credit.repository.TbUserRepository;
import com.neuedu.credit.repository.User_RoleRepository;
import com.neuedu.credit.repository.VerificationCodeRepository;
import com.neuedu.credit.util.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @Created by elvin on 2018/9/21 10:39.
 * @Describe:
 */
@CacheConfig
@Service(value = "TbUserService")
public class TbUserServiceImp implements TbUserService {
    @Autowired
    TbUserRepository userRepository;
    @Autowired
    User_RoleRepository user_roleRepository;
    @Autowired
    VerificationCodeRepository verificationCodeRepository;
    @Autowired
    EmailUtil emailUtil;

    @Override
    public List<TbUser> findAll() {
        return userRepository.findAll(Sort.by("modifytime").descending());
    }

    @Override
    public Page<TbUser> findByPageAndParams(String name, int pagenumber, int pageSize) {
        Pageable pageable = PageRequest.of(pagenumber - 1, pageSize, Sort.Direction.DESC, "name", "mobile");
        return userRepository.findAllByName(name, pageable);

    }

    @Override
    @Transactional
    public void add(TbUser tbUser, int[] roleIds) {
        userRepository.save(tbUser);
        for (int roleid : roleIds) {
            UserRole userRole = new UserRole();
            userRole.setRolId(roleid);
            userRole.setUserId(tbUser.getId());
            user_roleRepository.save(userRole);
        }
    }

    @Override
    @Transactional
    public Boolean register(TbUser tbUser) {
        // 1 save user
        TbUser existedUser = userRepository.findByUsername(tbUser.getUsername());
        if (existedUser != null) {
            return false;
        }
        tbUser.setPassword(new BCryptPasswordEncoder().encode(tbUser.getPassword()));
        userRepository.save(tbUser);
        // 2 generate VerifyCode and save
        String verifyCode = String
                .valueOf(new Random().nextInt(899999) + 100000);//生成验证码
        VerificationCode verificationCode = new VerificationCode();
        verificationCode.setVerifyCode(verifyCode);
        verificationCode.setSendTo(tbUser.getEmail());
        verificationCode.setUsedfor(0);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Timestamp timestamp = new Timestamp(calendar.getTimeInMillis());
        verificationCode.setExpired(timestamp);
        verificationCodeRepository.save(verificationCode);
        // 3 sendEmail VerifyCode to User
        emailUtil.sendSimpleMail(tbUser.getEmail(), "注册用户激活验证码", String.format("朋友，您好，欢迎注册我们的网站，您的注册验证码是：%1$s" ,verifyCode));
        return true;
    }

    @Override
    @Cacheable(value = "users",key = "#id")
    public TbUser findById(int id) {
        return userRepository.findById(id).get();
    }

    @Override
    public TbUser findByName(String name) {
        String logintype = "username";
        switch (logintype) {
            case "username":
                return userRepository.findByUsername(name);
        }

        return null;
    }

    @Override
    @CachePut(value = "users",key = "#tbUser.id")
    public void update(TbUser tbUser) {
        userRepository.save(tbUser);
    }

    @Override
    public TbUser bindMobile(String mobile, String code) {
        Boolean isVerify = false;
        int userdfor = 0;
        VerificationCode verificationCode = verificationCodeRepository.QueryBySendtoAndAndExpired(mobile,userdfor);
        if (verificationCode!=null)
        {
            if(code.equals(verificationCode.getVerifyCode())){
                isVerify = true;
            }
        }
        if (isVerify)
        {
          TbUser user = userRepository.findByUsername("33004194@qq.com");
          user.setMobile(mobile);
          user.setModifytime(new Timestamp(new Date().getTime()));
          update(user);
          return  user;
        }
        return null;
    }
}
