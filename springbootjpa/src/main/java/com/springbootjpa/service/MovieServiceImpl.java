package com.springbootjpa.service;

import com.springbootjpa.domain.Movie;
import com.springbootjpa.domain.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 *  业务逻辑的实现类
 */
@Service
@Transactional  // 代表所有的事务
public class MovieServiceImpl implements MovieService{
    @Autowired
    private MovieRepository movieRepository;

    /**
     *  有 ID 时修改 没有 ID 时新增
     * @param movie
     */
    @Override
    public void save(Movie movie) {
        movieRepository.save(movie);
    }

    /**
     *  删除
     * @param id
     */
    @Override
    public void deleteById(Integer id) {
        movieRepository.deleteById(id);
    }

    /**
     *  查询所有
     * @return
     */
    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    /**
     *  根据 ID 查询
     * @param id
     * @return
     */
    @Override
    public Optional<Movie> findById(Integer id) {
        return movieRepository.findById(id);
    }
}
