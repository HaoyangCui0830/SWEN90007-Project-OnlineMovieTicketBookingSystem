package domain;

import dataMapper.ThreeDMovieMapper;

public class ThreeDMovieAssembler {

	public static ThreeDMovieDTO createThreeDMovieDTO(ThreeDMovie threeDMovie) {
		ThreeDMovieDTO result = new ThreeDMovieDTO();
		result.setId(threeDMovie.getId());
		result.setHasFreeGlasses(threeDMovie.getHasFreeGlasses());
		return result;
	}
	
	public static boolean updateThreeDMovie(ThreeDMovieDTO threeDMovieDTO) {
		ThreeDMovie threeDMovie = new ThreeDMovie();
		threeDMovie.setMovieId(threeDMovieDTO.getId());
		threeDMovie.setHasFreeGlasses(threeDMovie.getHasFreeGlasses());
		boolean result = false;
		try {
			result = new ThreeDMovieMapper().update(threeDMovie);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public static boolean addThreeDMovie(ThreeDMovieDTO threeDMovieDTO) {
		ThreeDMovie threeDMovie = new ThreeDMovie();
		threeDMovie.setMovieId(threeDMovieDTO.getId());
		threeDMovie.setHasFreeGlasses(threeDMovie.getHasFreeGlasses());
		boolean result = false;
		try {
			result = new ThreeDMovieMapper().insert(threeDMovie);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
}
