package com.springbootjpa.domain;

import javax.persistence.*;


/**
 *  实体类
 */
@Entity // 说明此类是实体类
@Table(name = "PRODUCT")// 说明实体对应的表名
public class Product implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // ID 的值 自动增长
    private Integer id;

    @Column
    private String name;

    @Column
    private Double price;

    @Column
    private String description;

    // FetchType.EAGER 及时加载: 不管是否需要都加载关联数据
    // FetchType.LAZY 延迟加载: 当需要关联的数据时则加载;不需要则不加载
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CATEGORY_ID") // 外键
    private Category category;

    public Product() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
