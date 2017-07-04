package com.adobe.prj.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.adobe.prj.dao.MovieDao;
import com.adobe.prj.entity.Movie;

@Repository
public class MovieJpaImpl implements MovieDao {
	@PersistenceContext
	private EntityManager em;
				
	@Override
	public List<Movie> getMovies() {
		// TODO Auto-generated method stub
		TypedQuery<Movie> query= em.createQuery("from Movie",Movie.class);
		return query.getResultList();
	}

	@Override
	public int addMovie(Movie movie) {
		// TODO Auto-generated method stub
		em.persist(movie);
		return movie.getId();
	}

	@Override
	public Movie getmovie(int id) {
		// TODO Auto-generated method stub
		return em.find(Movie.class, id);
	}

	@Override
	public void updateMovie(Movie movie) {
		// TODO Auto-generated method stub
		em.merge(movie);
		}

}
