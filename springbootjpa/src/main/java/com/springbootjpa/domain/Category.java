package com.springbootjpa.domain;

import javax.persistence.*;

@Entity
@Table(name = "CATEGORY")
public class Category implements java.io.Serializable {
    private static final long serialVersionUID = 1926249345902514397L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // 自动增长
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    // @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "category") // 一对多的注解
    // private Set<Product> products = new HashSet<Product>(0);  //  一对多的写法

    public Category() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}