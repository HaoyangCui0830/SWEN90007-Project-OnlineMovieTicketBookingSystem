package service;

import java.util.ArrayList;
import java.util.List;

import dataMapper.MovieMapper;
import dataMapper.SessionMapper;
import domain.Movie;
import domain.Session;
import utils.IdentityMap;
import utils.UnitOfWork;

public class MovieService {

	MovieMapper movieMapper;
	
	public MovieService() {
		movieMapper = new MovieMapper();
	}
	
	public List<Movie> getAllMovies(){
		List<Movie> movies = new ArrayList<Movie>();
		movies = movieMapper.findAllMovies();
		return movies;
	}
	
	public Movie getMovieById(int movieId) {
		Movie movie = new Movie();
		movie.setMovieId(movieId);
		IdentityMap<Movie> identityMap = IdentityMap.getInstance(movie);
		Movie movieInIdentityMap = identityMap.get(movie.getMovieId());
		if(movieInIdentityMap != null) {
			Movie result = movieInIdentityMap;
			return result;
		}
		else {
			return movieMapper.findMovieById(movieId);
		}
	}
	
	
	public void insertMovie(Movie movie) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerNew(movie);
		UnitOfWork.getCurrent().commit();
	}
	
	public void deleteMovie(Movie movie) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerDeleted(movie);
		SessionMapper sessionMapper = new SessionMapper();
		List<Session> sessions = sessionMapper.findAllSessionsByMovieId(movie.getMovieId());
		for(Session session : sessions) {
			UnitOfWork.getCurrent().registerDeleted(session);
		}
		UnitOfWork.getCurrent().commit();
	}
	
	public void updateMovie(Movie movie) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerDirty(movie);
		UnitOfWork.getCurrent().commit();
	}
	
}
