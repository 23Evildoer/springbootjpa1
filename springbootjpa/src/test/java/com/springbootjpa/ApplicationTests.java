package com.springbootjpa;

import com.springbootjpa.domain.Movie;
import com.springbootjpa.service.MovieService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
	@Autowired
	private MovieService movieService;

	// 新增方法
	@Test
	public void save() {
		Movie movie = new Movie();
		movie.setName("复仇者联盟");
		movie.setPrice(50d);
		movie.setActionTime(new Date());

		movieService.save(movie);
	}

	// 修改方法
	@Test
	public void remove() {
		Movie movie = new Movie();
		movie.setId(2);
		movie.setName("复仇者联盟3");
		movie.setPrice(50d);
		movie.setActionTime(new Date());
		movieService.save(movie);
	}

	// 查询所有
	@Test
	public void findAll(){
		for (Movie movie:movieService.findAll()){
			System.out.println(movie.getName()+" "+movie.getPrice());
		}
	}
	// 根据 ID 查询
	@Test
	public  void  getOne(){
		Optional<Movie> movie = movieService.findById(2);
		System.out.println(movie.get().getName()+" "+movie.get().getPrice());
	}

	// 删除
	@Test
	public void deleteById(){
		movieService.deleteById(2);
	}

}
