package com.neuedu.credit.repository;

import com.neuedu.credit.pojo.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Created by elvin on 2018/9/21 17:13.
 * @Describe:
 */
public interface User_RoleRepository extends JpaRepository<UserRole,Integer> {
}
