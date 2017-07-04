package com.adobe.prj.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adobe.prj.entity.Movie;
import com.adobe.prj.service.MovieService;

@Controller
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@RequestMapping("listMovies.do")
	public String fetchMovies(Model model)
	{
		model.addAttribute("movies",movieService.getMovies());
		return "movieList.jsp";
	}
	
	@RequestMapping("newMovie.do")
	public String getMovieFrom(Model model)
	{
		model.addAttribute("movie",new Movie());
		return "movieForm.jsp";
	}
	
	@RequestMapping("addMovie.do")
	public String addMovie(@ModelAttribute("movie") Movie m, Model model)
	{
		movieService.addMovie(m);
		model.addAttribute("msg", "Movie"+ m.getName() + " added successfully");
		return "index.jsp";
	}
}
