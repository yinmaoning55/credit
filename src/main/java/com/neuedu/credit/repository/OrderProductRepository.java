package com.neuedu.credit.repository;

import com.neuedu.credit.pojo.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Created by elvin on 2018/10/9 17:05.
 * @Describe:
 */
public interface OrderProductRepository extends JpaRepository<OrderProduct,Integer> {
    List<OrderProduct> findAllByOrderno(String orderno);
}
