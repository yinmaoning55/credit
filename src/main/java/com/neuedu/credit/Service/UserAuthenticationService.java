package com.neuedu.credit.Service;

import com.neuedu.credit.pojo.UserAuthentication;

/**
 * @Created by elvin on 2018/9/25 15:02.
 * @Describe:
 */
public interface UserAuthenticationService {
    void add (UserAuthentication authentication);
    UserAuthentication getByUserId(int userid);
    UserAuthentication update(UserAuthentication authentication);
}
