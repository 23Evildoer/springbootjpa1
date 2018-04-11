package com.springbootjpa;

import com.springbootjpa.domain.Movie;
import com.springbootjpa.service.MovieService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
		movie.setName("变形金刚5");
		movie.setPrice(80d);
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

	// 通过名字查询
	@Test
	public void findByMovieName(){
		for (Movie movie:movieService.finfByMovieName("头号玩家")){
			System.out.println(movie.getName()+" "+movie.getPrice());
		}
	}

	// 名字模糊查询
	@Test
	public void findByNameLike(){
		for (Movie movie:movieService.findByNameLike("%头%")){
			System.out.println(movie.getName()+" "+movie.getPrice());
		}
	}

	// 查询不包含有名字模糊查询
	@Test
	public void findByNameNoLike(){
		for (Movie movie:movieService.findByNameNoLike("%头%")){
			System.out.println(movie.getName()+" "+movie.getPrice());
		}
	}

	// 模糊查询：名字中不包含 复字 并且价格是 80 的数据
	@Test
	public void findByNameNotLike(){
		for (Movie movie:movieService.findByNameNotLikeAndPrice("%复%",80d)){
			System.out.println(movie.getName()+" "+movie.getPrice());
		}
	}

	// 通过时间段查询
	@Test
	public void findByActionTimeBetween(){
		Date beginDate = new Date();
		Date endDate = new Date();
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			beginDate = sdf.parse("2018-04-08 00:00:00");
			endDate = sdf.parse("2018-04-10 23:59:59");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		for (Movie movie : movieService.findByActionTimeBetween(beginDate, endDate)) {
			System.out.println(movie.getName() + " " + movie.getPrice());
		}
	}
}
