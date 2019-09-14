package service;

import java.util.ArrayList;
import java.util.List;

import dataMapper.MovieMapper;
import domain.Cinema;

public class CinemaService {

	/**
	 * Find all cinemas based on movieId (cinemas that show this movie)
	 * @param movieId
	 * */
	public List<Cinema> getCinemasByMovieId(int movieId){
		MovieMapper movieMapper = new MovieMapper();
		List<Cinema> cinemas = new ArrayList<Cinema>();
		cinemas = movieMapper.findCinemaByMovieId(movieId);
		return cinemas;
	}
	
}
