package com.neuedu.credit.Service.Imp;

import com.neuedu.credit.Service.ProductService;
import com.neuedu.credit.pojo.Product;
import com.neuedu.credit.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ProductServiceImp
 * @Description TODO
 * @Author elvin yuan
 * @Date 2018/9/1914:41
 * @Version 1.0
 **/
@Service(value = "ProductService")
public class ProductServiceImp implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public void add(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findByName(String name) {
        return null;
    }

    @Override
    public List<Product> findList() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id).get();
    }

    @Override
    public void update(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteById(int id) {

    }
}
