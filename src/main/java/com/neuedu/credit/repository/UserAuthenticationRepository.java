package com.neuedu.credit.repository;

import com.neuedu.credit.pojo.UserAuthentication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @Created by elvin on 2018/9/25 15:04.
 * @Describe:
 */
public interface UserAuthenticationRepository extends JpaRepository<UserAuthentication,Integer>,JpaSpecificationExecutor {
    List<UserAuthentication> findByUseridOrderByIdDesc(int userid);
}
