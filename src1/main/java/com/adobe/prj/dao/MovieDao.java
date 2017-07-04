package com.adobe.prj.dao;

import java.util.List;

import com.adobe.prj.entity.Movie;

public interface MovieDao {
	List<Movie> getMovies();
	int addMovie(Movie movie);
	Movie getmovie(int id);
	void updateMovie(Movie movie);

}
