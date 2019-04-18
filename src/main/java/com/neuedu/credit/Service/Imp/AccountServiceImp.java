package com.neuedu.credit.Service.Imp;

import com.neuedu.credit.Service.AccountService;
import com.neuedu.credit.pojo.Account;
import com.neuedu.credit.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @Created by elvin on 2018/10/8 8:48.
 * @Describe:
 */
@Service( value = "AccountService")
public class AccountServiceImp implements AccountService {
    @Autowired
    AccountRepository accountRepository;

    @Override
    public void add(Account account) {
        accountRepository.save(account);
    }

    @Override
    public void changepassword(int userId, String oldpwd, String newpwd) {
        Account account = accountRepository.findByUserId(userId);
        if(account != null)
        {
           if( oldpwd.equals( account.getPaymentpassword()))
           {
               account.setPaymentpassword(newpwd);
               account.setModifytime(new Timestamp(new Date().getTime()));
               accountRepository.save(account);
           }
        }
    }

    @Override
    public void inAccount(int id, Long fund) {
        Account account = accountRepository.findById(id).get();
        account.setUseableFund(account.getUseableFund()+fund);
        account.setModifytime(new Timestamp(new Date().getTime()));
        accountRepository.save(account);
    }

    @Override
    public Account get(int userId) {
        return  accountRepository.findByUserId(userId);
    }

    @Override
    public Account findOne(int id) {
        return accountRepository.findById(id).get();
    }

    @Override
    public List<Account> list() {
        return accountRepository.findAll();
    }

}
