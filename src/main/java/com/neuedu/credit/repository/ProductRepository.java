package com.neuedu.credit.repository;

import com.neuedu.credit.pojo.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
