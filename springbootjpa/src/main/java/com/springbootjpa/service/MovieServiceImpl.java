package com.springbootjpa.service;

import com.springbootjpa.domain.Movie;
import com.springbootjpa.domain.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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

    /**
     *  根据名字查询
     * @param name
     * @return
     */
    @Override
    public List<Movie> finfByMovieName(String name) {
        return movieRepository.findByMovieName(name);
    }

    /**
     *  名字模糊查询
     * @param name
     * @return
     */
    public List<Movie> findByNameLike(String name){
        return movieRepository.findByNameLike(name);
    }

    /**
     *  查询不包含名字的模糊查询
     * @param name
     * @return
     */
    public List<Movie>findByNameNoLike(String name){
        return movieRepository.findByNameNotLike(name);
    }

    /**
     *  模糊查询:查询不包含要查的名字 并且价格是要查的数据
     * @param name
     * @param price
     * @return
     */
    public List<Movie>findByNameNotLikeAndPrice(String name,Double price){
        return movieRepository.findByNameNotLikeAndPrice(name,price);
    }


   /* public List<Movie>findByActionTimeBetweens(Date beginData, Date endData){
        return movieRepository.findByActionTimeBetween(beginData,endData);
    }*/

    /**
     *  通过时间段查询
     * @param beginDate
     * @param endDate
     * @return
     */
    @Override
    public List<Movie> findByActionTimeBetween(Date beginDate, Date endDate) {
        return movieRepository.findByActionTimeBetween(beginDate, endDate);
    }

}
