package service;

import java.util.List;

import domain.Movie;

public class MovieService {

	public List<Movie> getAllMovies(){
		return Movie.getAllMovies();
	}
	
	public Movie getMovieById(int movieId) {
		return Movie.getMovieById(movieId);
	}
	
}
