package com.neuedu.credit.repository;

import com.neuedu.credit.pojo.TbUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * @Created by elvin on 2018/9/21 10:35.
 * @Describe:
 */
public interface TbUserRepository extends JpaRepository<TbUser,Integer>,JpaSpecificationExecutor {
    Page<TbUser> findAllByName(String name, Pageable pageable);
    TbUser findByUsername(String username);
    TbUser findByMobile(String mobile);
    TbUser findByEmail(String email);
}
