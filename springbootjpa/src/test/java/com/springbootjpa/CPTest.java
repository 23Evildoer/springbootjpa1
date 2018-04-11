package com.springbootjpa;

import com.springbootjpa.domain.Category;
import com.springbootjpa.domain.Movie;
import com.springbootjpa.domain.Product;
import com.springbootjpa.service.CategoryService;
import com.springbootjpa.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CPTest {
    @Autowired
    private CategoryService  categoryService;

    @Autowired
    private ProductService productService;


    //  新增 Category 类数据
    @Test
    public void saveCategory(){
        Category category = new Category();
        category.setName("电器类");
        category.setDescription("通电用");
        categoryService.save(category);
    }


    // 新增 product 类中数据
    @Test
    public void saveProduct() {
        //Category category = categoryService.findById(12).get();  //  .get() 是 获得 根据 ID 查询出来集合的 对象
        Optional<Category> category = categoryService.findById(12);
        Product product = new Product();
        product.setName("海尔空调");
        product.setPrice(5000d);
        product.setDescription("省电");
        // 设置商品与商品类别的关系
        product.setCategory(category.get());

        productService.save(product);
    }

    // step 3:
    @Test
    public void list() {
        for (Product product : productService.findAll()) {
            System.out.println(product.getName() + " " + product.getCategory().getName());
        }
    }

}
