package com.neuedu.credit.Service;

import com.neuedu.credit.pojo.Account;

import java.util.List;

/**
 * @Created by elvin on 2018/10/8 8:46.
 * @Describe:
 */
public interface AccountService {
    void add(Account account);
    void changepassword(int userId,String oldpwd,String newpwd);
    void inAccount(int id,Long fund);
    Account get(int userId);
    Account findOne(int id);
    List<Account> list();
}
