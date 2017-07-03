package com.adobe.prj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adobe.prj.dao.MovieDao;
import com.adobe.prj.entity.Movie;

@Service
@Transactional
public class MovieService {
	
	@Autowired
	private MovieDao movieDao;
	
	public List<Movie> getMovies() {
		return movieDao.getMovies();
	}
	
	public int addMovie(Movie m) {
		return movieDao.addMovie(m);
	}
}
