package domain;

import dataMapper.CinemaMovieMapper;

public class CinemaMovieAssembler {

	public static CinemaMovieDTO createCinemaMovieDTO(CinemaMovie cinemaMovie) {
		CinemaMovieDTO cinemaMovieDTO = new CinemaMovieDTO();
		cinemaMovieDTO.setCinemaId(cinemaMovie.getCinemaId());
		cinemaMovieDTO.setMovieId(cinemaMovie.getMovieId());
		return cinemaMovieDTO;
	}
	
	
	public static boolean updateCinemaMovie(CinemaMovieDTO cinemaMovieDTO) {
		CinemaMovie cinemaMovie = new CinemaMovie();
		cinemaMovie.setCinemaId(cinemaMovieDTO.getCinemaId());
		cinemaMovie.setMovieId(cinemaMovieDTO.getMovieId());
		boolean result = false;
		try {
			result = new CinemaMovieMapper().update(cinemaMovie);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public static boolean addCinemaMovie(CinemaMovieDTO cinemaMovieDTO) {
		CinemaMovie cinemaMovie = new CinemaMovie();
		cinemaMovie.setCinemaId(cinemaMovieDTO.getCinemaId());
		cinemaMovie.setMovieId(cinemaMovieDTO.getMovieId());
		boolean result = false;
		try {
			result = new CinemaMovieMapper().insert(cinemaMovie);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
