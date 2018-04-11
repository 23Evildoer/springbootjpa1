package com.springbootjpa.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 *  实体类 /  封装类  /  JavaBean  /  pojo
 */
@Entity // 说明此类是实体类
@Table(name = "MOVIE")// 说明实体对应的表名
public class Movie implements Serializable{
    @Id // id 表示是主键
    @GeneratedValue(strategy = GenerationType.AUTO) // ID 的值 自动增长
    private Integer id;

    // 说明类中属性对应表中的字段（字段名, 长度, 非空  not null）
    //@Column(name = "abc_name",length = 100,nullable = false)
    @Column
    private String  name;
    @Column
    private Double  price;
    @Column(name = "action_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 后端到前端
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8") // 前端到后端
    private Date    actionTime;

    public Movie() {
    }

    public Movie(Integer id, String name, Double price, Date actionTime) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.actionTime = actionTime;
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

    public Date getActionTime() {
        return actionTime;
    }

    public void setActionTime(Date actionTime) {
        this.actionTime = actionTime;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", actionTime=" + actionTime +
                '}';
    }
}
