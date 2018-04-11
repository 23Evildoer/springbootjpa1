package com.springbootjpa.service;


import com.springbootjpa.domain.Product;
import com.springbootjpa.domain.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    /**
     *  新增或者修改
     * @param product
     */
    public void save(Product product){
        productRepository.save(product);
    }


    /**
     *  查询所有
     */
    public List<Product> findAll(){
        return productRepository.findAll();
    }

}
