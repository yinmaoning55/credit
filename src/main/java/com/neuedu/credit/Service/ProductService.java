package com.neuedu.credit.Service;

import com.neuedu.credit.pojo.Product;

import java.util.List;

public interface ProductService {
    void add(Product product);
    Product findByName(String name);
    List<Product> findList();
    Product findById(int id);
    void update (Product product);
    void deleteById(int id);
}
