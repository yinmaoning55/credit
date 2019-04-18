package com.neuedu.credit.repository;

import com.neuedu.credit.pojo.VerificationCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * @Created by elvin on 2018/9/26 15:26.
 * @Describe:
 */
public interface VerificationCodeRepository extends JpaRepository<VerificationCode, Integer>,JpaSpecificationExecutor {
    @Query(value = "SELECT * from verificationcode where sendto = ?1 and usedfor=?2 and sysdate() < expired order by expired desc limit 1",nativeQuery = true)
    VerificationCode QueryBySendtoAndAndExpired(String sendto,int usedfor);
}
