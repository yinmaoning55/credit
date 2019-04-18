package com.neuedu.credit.repository;

import com.neuedu.credit.pojo.PaymentOrder;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Created by elvin on 2018/10/9 16:29.
 * @Describe: PaymentOrder DAO
 */
public interface OrderRepository extends JpaRepository<PaymentOrder,String> {
}
