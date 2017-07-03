/**
 * 1) index.html
 * 	<a href="listMovies.do"> List All movies </a>
 * 2) DispatcherServlet is invoked
 * 3) DispatcherServlet checks with Handler mapping to find out which controller class contains the matching 
 * 	RequestMapping.
 * 4) Controller with the matching @RequestMapping is executed.
 * 5) Controller code invokes Service code which is injected using @Autowired.
 * 6) Service method invokes DAO code which is injected using @Autowired.
 * 7) DAO uses EntityManager for CRUD Operation which is injected using @PersistenceContext.
 * 	EntityManager uses JPA for SQL generation.
 */
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
	
	// Model is container which is given to the view.
	@RequestMapping("listMovies.do")
	public String fetchMovie(Model model) {
		model.addAttribute("movies", movieService.getMovies());
		return "movieList.jsp";
	}
	
	@RequestMapping("newMovie.do")
	public String getMovieForm(Model model) {
		model.addAttribute("movie", new Movie());
		return "movieForm.jsp";
	}
	
	@RequestMapping("addMovie.do")
	public String addMovie (@ModelAttribute("movie") Movie m, Model model) {
		movieService.addMovie(m);
		model.addAttribute("msg", "Movie " + m.getName() + " added successfully!!!");
		return "index.jsp";
	}
}
