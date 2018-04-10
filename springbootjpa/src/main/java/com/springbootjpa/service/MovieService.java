package com.springbootjpa.service;

import com.springbootjpa.domain.Movie;

import java.util.List;
import java.util.Optional;

/**
 *  业务逻辑接口
 */
public interface MovieService {
    // 新增
    void save(Movie movie);

    void deleteById(Integer id);

    List<Movie> findAll();

    // 根据 ID 查询
    Optional<Movie> findById(Integer id);
}
