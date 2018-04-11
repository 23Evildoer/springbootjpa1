package com.springbootjpa.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 *  持久层：由 jpa 关理
 */
public interface MovieRepository extends JpaRepository<Movie,Integer>{
    // 包含了一般的增删改查


    // hql:Hiberante Query Language: Hiberante 查询语言 -  类名- 属性名 |    类名：Movie 别名:m  属性名：name | :name 是Param中的值
   @Query(value = "select m from Movie m where m.name=:name")
    List<Movie> findByMovieName(@Param("name")String name);

   // 模糊查询:名字
   List<Movie>findByNameLike(String name);

   // 查询不包含名字模糊
   List<Movie>findByNameNotLike(String name);

   // 模糊查询：不包含要查的名字 并且价格是要查的数据
    List<Movie>findByNameNotLikeAndPrice(String name,Double price);

    // 通过时间段查询
    //List<Movie> findByActionTimeBetween(Date beginData,Date endData);
    List<Movie> findByActionTimeBetween(Date beginDate, Date endDate);
}
