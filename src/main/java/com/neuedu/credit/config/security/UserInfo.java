package com.neuedu.credit.config.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * @Created by elvin on 2018/10/12 14:31.
 * @Describe:
 */
public class UserInfo extends User {
    private int UserId;

    public UserInfo(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }


}
