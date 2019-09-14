package service;

import java.util.ArrayList;
import java.util.List;

import dataMapper.CinemaMapper;
import dataMapper.CinemaMovieMapper;
import dataMapper.MovieMapper;
import dataMapper.SessionMapper;
import dataMapper.ThreeDMovieMapper;
import domain.CinemaMovie;
import domain.Movie;
import domain.Session;
import domain.ThreeDMovie;
import utils.IdentityMap;
import utils.UnitOfWork;

public class MovieService {

	MovieMapper movieMapper;
	
	public MovieService() {
		movieMapper = new MovieMapper();
	}
	
	/**
	 * collect all movies' info from DB
	 * */
	public List<Movie> getAllMovies(){
		List<Movie> movies = new ArrayList<Movie>();
		movies = movieMapper.findAllMovies();
		return movies;
	}
	
	
	/**
	 * collect one movie's info from DB based on movieId
	 * @param movieId
	 * */
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
	
	/**
	 * insert movie info into DB
	 * @param movie
	 * */
	public void insertMovie(Movie movie) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerNew(movie);
		UnitOfWork.getCurrent().commit();
	}
	
	/**
	 * delete one movie and all related sessions, 3Dmovie iinfo and cinemaMovie relationship
	 * from DB
	 * @param movie
	 * */
	public void deleteMovie(Movie movie) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerDeleted(movie);
		
		// Using Unit of Work to delete related Sessions
		SessionMapper sessionMapper = new SessionMapper();
		List<Session> sessions = sessionMapper.findAllSessionsByMovieId(movie.getMovieId());
		if(sessions!=null) {
			for(Session session : sessions) {
				UnitOfWork.getCurrent().registerDeleted(session);
			}
		}
		
		// Using Unit of Work to delete related ThreeDMovies
		ThreeDMovieMapper threeDMovieMapper = new ThreeDMovieMapper();
		ThreeDMovie threeDMovies = threeDMovieMapper.findThreeDMovieById(movie.getMovieId());
		if(threeDMovies.getHasFreeGlasses()!=null) {
			UnitOfWork.getCurrent().registerDeleted(threeDMovies);
		}
		
		// Using Unit of Work to delete related Cinema Movie Relationship
		CinemaMovieMapper cinemaMovieMapper = new CinemaMovieMapper();
		List<CinemaMovie> cinemaMovies = cinemaMovieMapper.findCinemaMoviesByMovieId(movie.getMovieId());
		if(cinemaMovies != null) {
			for(CinemaMovie cinemaMovie:cinemaMovies) {
				UnitOfWork.getCurrent().registerDeleted(cinemaMovie);
			}
		}
		
		UnitOfWork.getCurrent().commit();
	}
	
	/**
	 * update movie info into DB
	 * @param movie
	 * */
	public void updateMovie(Movie movie) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerDirty(movie);
		UnitOfWork.getCurrent().commit();
	}
	
}
