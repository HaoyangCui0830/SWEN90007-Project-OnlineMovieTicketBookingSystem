package service;

import java.util.List;

import domain.Movie;

public interface Action {
	
	public void insertMovie(Object object);
	
	public List<Movie> getAllMovies();
	
	public Movie getMovieById(int movieId);
	
	public void deleteMovie(Object movie);
	
	public void updateMovie(Object movie);
	
	
	
}
