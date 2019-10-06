package remoteFacade;

import dataMapper.MovieMapper;
import domain.Movie;
import domain.MovieAssembler;
import domain.MovieDTO;

public class MovieServiceBean {

	/**
	 * get MovieDTO object
	 * */
	public MovieDTO getMovie(int id) {
		Movie movie = new MovieMapper().findMovieById(id);
		MovieDTO movieDTO = MovieAssembler.createMovieDTO(movie);
		return movieDTO;
	}
	
	/**
	 * get MovieDTO JSON
	 * */
	public String getMovieJson(int id) {
		Movie movie = new MovieMapper().findMovieById(id);
		MovieDTO movieDTO = MovieAssembler.createMovieDTO(movie);
		return MovieDTO.serialize(movieDTO);
	}
	
	/**
	 * update Movie based on DTO
	 * */
	public boolean updateMovie(MovieDTO movieDTO) {
		return MovieAssembler.updateMovie(movieDTO);
	}
	
	/**
	 * update Movie based on input Json
	 * */
	public boolean updateMovieJson(String json) {
		MovieDTO movieDTO = MovieDTO.deserialize(json);
		return MovieAssembler.updateMovie(movieDTO);
	}
	
	/**
	 * add Movie based on DTO
	 * */
	public boolean addMovie(MovieDTO movieDTO) {
		return MovieAssembler.addMovie(movieDTO);
	}
	
	/**
	 * add Movie based on input Json
	 * */
	public boolean addMovieJson(String json) {
		MovieDTO movieDTO = MovieDTO.deserialize(json);
		return MovieAssembler.addMovie(movieDTO);
	}
	
}
