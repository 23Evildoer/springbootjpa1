package com.springbootjpa.service;

import com.springbootjpa.domain.Movie;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 *  业务逻辑接口
 */
public interface MovieService {
    // 新增
    void save(Movie movie);

    // 根据 ID 查询
    void deleteById(Integer id);

    // 查询所有
    List<Movie> findAll();

    // 根据 ID 查询
    Optional<Movie> findById(Integer id);

    // 通过名字查询
    List<Movie> finfByMovieName(String name);

    // 模糊查询：名字
    List<Movie> findByNameLike(String name);

    // 模糊查询：不包含要查询的名字的数据
    List<Movie> findByNameNoLike(String name);

    // 模糊查询：不包含要查的名字 并且价格是要查的数据
    List<Movie>findByNameNotLikeAndPrice(String name,Double price);

    // 通过时间段查询
    //List<Movie> findByActionTimeBetween(Date beginData, Date endData);
    List<Movie> findByActionTimeBetween(Date beginDate, Date endDate);
}
