package service;

import java.util.ArrayList;
import java.util.List;

import dataMapper.MovieMapper;
import dataMapper.SessionMapper;
import domain.DomainObject;
import domain.Movie;
import domain.Session;
import utils.IdentityMap;
import utils.UnitOfWork;

public class MovieService2 implements Action{

	MovieMapper movieMapper;
	
	public MovieService2() {
		movieMapper = new MovieMapper();
	}
	
	public List<Movie> getAllMovies(){
		List<Movie> movies = new ArrayList<Movie>();
		movies = movieMapper.findAllMovies();
		return movies;
	}
	
	public Movie getMovieById(int movieId) {
		System.out.println("调用了getMoviebyID方法");
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
	
	
	public void insertMovie(Object movie) {
		System.out.println("调用了insertMovie方法");
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerNew((DomainObject)movie);
		UnitOfWork.getCurrent().commit();
		System.out.println(movie);
	}
	
	public void deleteMovie(Object movie) {
		System.out.println("调用了deleteMovie方法");
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerDeleted((DomainObject)movie);
		SessionMapper sessionMapper = new SessionMapper();
		List<Session> sessions = sessionMapper.findAllSessionsByMovieId(((Movie) movie).getMovieId());
		for(Session session : sessions) {
			UnitOfWork.getCurrent().registerDeleted(session);
		}
		UnitOfWork.getCurrent().commit();
	}
	
	public void updateMovie(Object movie) {
		System.out.println("调用了updateMovie方法");
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerDirty((DomainObject)movie);
		UnitOfWork.getCurrent().commit();
	}

	
}
