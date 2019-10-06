package domain;

import java.sql.Time;

import dataMapper.MovieMapper;

public class MovieAssembler {

	public static MovieDTO createMovieDTO(Movie movie) {
		MovieDTO movieDTO = new MovieDTO();
		movieDTO.setMovieId(movie.getMovieId());
		movieDTO.setLength(movie.getLength().toString());
		movieDTO.setName(movie.getName());
		movieDTO.setPrice(movie.getPrice());
		return movieDTO;
	}
	
	public static boolean updateMovie(MovieDTO movieDTO) {
		Movie movie= new Movie();
		movie.setMovieId(movieDTO.getMovieId());
		movie.setLength(Time.valueOf(movieDTO.getLength()));
		movie.setName(movieDTO.getName());
		movie.setPrice(movieDTO.getPrice());
		boolean result = false;
		try {
			result = new MovieMapper().update(movie);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public static boolean addMovie(MovieDTO movieDTO) {
		Movie movie= new Movie();
		movie.setMovieId(movieDTO.getMovieId());
		movie.setLength(Time.valueOf(movieDTO.getLength()));
		movie.setName(movieDTO.getName());
		movie.setPrice(movieDTO.getPrice());
		boolean result = false;
		try {
			result = new MovieMapper().insert(movie);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
}
