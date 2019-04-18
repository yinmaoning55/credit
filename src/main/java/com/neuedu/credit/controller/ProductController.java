package com.neuedu.credit.controller;

import com.neuedu.credit.Service.ProductService;
import com.neuedu.credit.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * @Created by elvin on 2018/9/19 16:57.
 * @Describe:
 */
@Controller
@RequestMapping("/pro")
public class ProductController {

    @Autowired
    ProductService productService;

    /**
     * 添加商品并自动上架
     * @param product
     * @return
     */
    @ResponseBody
    @RequestMapping("/add")
    public Product add(Product product){
        Date date = new Date();
        product.setCreatetime(date);
        product.setModifytime(date);
        productService.add(product);
        return  product;
    }

    @ResponseBody
    @RequestMapping("/get/{id}")
    public Product getById(@PathVariable  int id){
       return  productService.findById(id);
    }

    @ResponseBody
    @RequestMapping("/list")
    public List<Product> getList(){
       return   productService.findList();
    }

    @ResponseBody
    @RequestMapping("/update/{id}/{state}")
    public Product updateById(@PathVariable int id, @PathVariable int state){
        Product product =  productService.findById(id);
        product.setState(state);
        product.setModifytime(new Date());
        productService.update(product);
        return product;
    }
}
