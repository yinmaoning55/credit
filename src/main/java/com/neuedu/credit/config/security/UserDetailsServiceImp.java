package com.neuedu.credit.config.security;

import com.neuedu.credit.Service.TbUserService;
import com.neuedu.credit.pojo.Role;
import com.neuedu.credit.pojo.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Spring Security AuthenticationException 常用子类：
 * UsernameNotFoundException 用户找不到
 * BadCredentialsException 坏的凭据
 * AccountStatusException 用户状态异常它包含如下子类
 * AccountExpiredException 账户过期
 * LockedException 账户锁定
 * DisabledException 账户不可用
 * CredentialsExpiredException 证书过期
 */


/**
 * @ClassName UserDetail
 * @Description TODO UserDetail Service Class
 * @Author elvin yuan
 * @Date 2018/9/11 14:36
 * @Version 1.0
 **/
@Service
public class UserDetailsServiceImp implements UserDetailsService {
    @Autowired
    private TbUserService userService;

    Map<String,UserInfo> userMap = null;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        userMap = new HashMap<>();
        TbUser sysUser = userService.findByName(s);
        if (sysUser == null) {
            System.out.println("用户名不存在:  " + s);
            throw new UsernameNotFoundException("NOT FOUND");
        }
        UserInfo userInfo;
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        if(sysUser.getRoles().size() == 0)
        {
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        }else {
            for (Role role : sysUser.getRoles()) {
                authorities.add(new SimpleGrantedAuthority(role.getEnName()));
                System.out.println(role.getEnName());
            }
        }
        System.out.println(" 登入系统");
        userInfo = new UserInfo(sysUser.getUsername(), sysUser.getPassword(), authorities);
        userInfo.setUserId(sysUser.getId());
        userMap.put(sysUser.getUsername(),userInfo);
        return userMap.get(s);
    }

    public Map<String, UserInfo> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<String, UserInfo> userMap) {
        this.userMap = userMap;
    }
}
