package remoteFacade;

import dataMapper.MovieMapper;
import domain.Movie;
import domain.MovieAssembler;
import domain.MovieDTO;

public class MovieServiceBean {

	public MovieDTO getMovie(int id) {
		Movie movie = new MovieMapper().findMovieById(id);
		MovieDTO movieDTO = MovieAssembler.createMovieDTO(movie);
		return movieDTO;
	}
	
	public String getMovieJson(int id) {
		Movie movie = new MovieMapper().findMovieById(id);
		MovieDTO movieDTO = MovieAssembler.createMovieDTO(movie);
		return MovieDTO.serialize(movieDTO);
	}
	
	public boolean updateMovie(MovieDTO movieDTO) {
		return MovieAssembler.updateMovie(movieDTO);
	}
	
	public boolean updateMovieJson(String json) {
		MovieDTO movieDTO = MovieDTO.deserialize(json);
		return MovieAssembler.updateMovie(movieDTO);
	}
	
	public boolean addMovie(MovieDTO movieDTO) {
		return MovieAssembler.addMovie(movieDTO);
	}
	
	public boolean addMovieJson(String json) {
		MovieDTO movieDTO = MovieDTO.deserialize(json);
		return MovieAssembler.addMovie(movieDTO);
	}
	
}
