package com.springbootjpa.controller;

import com.springbootjpa.domain.CustomType;
import com.springbootjpa.domain.Movie;
import com.springbootjpa.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http//127.0.0.1:8080",maxAge = 3600)
public class MovieContorller {

    @Autowired
    private MovieService movieService;

    /**
     *  查询所有   http://127.0.0.1:8086/ssm/api/movie
     * @return
     */
    @RequestMapping(value = "movie",method = RequestMethod.GET)
    public ResponseEntity findAll(){
        List<Movie> movies = movieService.findAll();
        if (movies==null){
            return new ResponseEntity<>(new CustomType(400,"没有数据"), HttpStatus.OK);
        }
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    /**
     *  根据 ID 查询 http://127.0.0.1:8086/ssm/api/movie/10
     * @return
     */
    @RequestMapping(value = "movie/{id}",method = RequestMethod.GET)
    public ResponseEntity findById(
            @PathVariable("id") Integer id
    ){
        System.out.println("接受的ID:"+id);
        Optional<Movie> movie = movieService.findById(id);
        if (movie==null){
            return new ResponseEntity<>(new CustomType(400,"没有数据"),HttpStatus.OK);
        }
        return new ResponseEntity(movie,HttpStatus.OK);
    }

    /**
     *  保存 （新增 、 修改）
     * @param movie
     * @return
     */
    @RequestMapping(value = "movie",method = RequestMethod.POST)
    public ResponseEntity save(
            @RequestBody Movie movie
    ){
        System.out.println("接受的数据是："+movie);
        CustomType customType = new CustomType(200,"保存成功");
        try {
            movieService.save(movie);
        }catch (Exception e){
            customType.setCode(400);
            customType.setMessage("保存失败");
            e.printStackTrace();
        }
        return new ResponseEntity<>(customType,HttpStatus.OK);
    }

    @RequestMapping(value = "movie/{id}",method = RequestMethod.DELETE)
    public ResponseEntity deleteById(
            @PathVariable("id")Integer id
    ){
        System.out.println("删除的ID:"+id);
        CustomType customType = new CustomType(200,"删除成功");
        try {
            movieService.deleteById(id); // 执行错误就抛出异常 输出 catch 里的
        }catch (Exception e){
            customType.setCode(400);
            customType.setMessage("删除失败");
            e.printStackTrace();
        }
        return new ResponseEntity<>(customType,HttpStatus.OK);
    }
}
