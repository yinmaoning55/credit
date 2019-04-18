package com.neuedu.credit.Service.Imp;

import com.neuedu.credit.Service.UserAuthenticationService;
import com.neuedu.credit.pojo.TbUser;
import com.neuedu.credit.pojo.UserAuthentication;
import com.neuedu.credit.repository.TbUserRepository;
import com.neuedu.credit.repository.UserAuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.sql.Timestamp;
import java.util.Date;

/**
 * @Created by elvin on 2018/9/25 15:03.
 * @Describe: 用户认证表
 */
@Service(value = "UserAuthenticationService")
public class UserAuthenticationServiceImp implements UserAuthenticationService {

    @Autowired
    UserAuthenticationRepository authenticationRepository;
    @Autowired
    TbUserRepository userRepository;

    @Override
    public void add(UserAuthentication authentication) {
        authenticationRepository.save(authentication);
    }

    @Override
    public UserAuthentication getByUserId(int userid) {
        return authenticationRepository.findByUseridOrderByIdDesc(userid).get(0);
    }

    @Override
    @Transactional
    public UserAuthentication update(UserAuthentication authentication) {
        UserAuthentication authentication1 = authenticationRepository.findById(authentication.getId()).get();
        authentication1.setStatus(authentication.getStatus());
        authentication1.setRemark(authentication.getRemark());
        authenticationRepository.save(authentication1);
        TbUser user = userRepository.findById(authentication1.getUser_id()).get();
        user.setAuthentication(authentication1.getAuthenticationtype());
        user.setModifytime(new Timestamp(new Date().getTime()));
        userRepository.save(user);
        return authentication1;
    }
}
