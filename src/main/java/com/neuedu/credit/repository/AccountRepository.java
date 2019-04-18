package com.neuedu.credit.repository;

import com.neuedu.credit.pojo.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Created by elvin on 2018/10/8 8:45.
 * @Describe:
 */
public interface AccountRepository extends JpaRepository<Account,Integer> {
    Account findByUserId(Integer userid);
}
