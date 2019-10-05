package domain;

import com.google.gson.Gson;

public class CinemaMovieDTO {

	private int movieId;
	private int cinemaId;
	/**
	 * @return the movieId
	 */
	public int getMovieId() {
		return movieId;
	}
	/**
	 * @param movieId the movieId to set
	 */
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	/**
	 * @return the cinemaId
	 */
	public int getCinemaId() {
		return cinemaId;
	}
	/**
	 * @param cinemaId the cinemaId to set
	 */
	public void setCinemaId(int cinemaId) {
		this.cinemaId = cinemaId;
	}
	

	/**
	 * convert CinemaMovieDTO object to Json, for remote access
	 * */
	public static String serialize(CinemaMovieDTO cinemaMovieDTO) {
		Gson gson = new Gson();
		return gson.toJson(cinemaMovieDTO);
	}
	
	/**
	 * Convert Json to CinemaMovieDTO
	 * */
	public static CinemaMovieDTO deserialize(String cinemaMovieString) {
		Gson gson = new Gson();
		return gson.fromJson(cinemaMovieString, CinemaMovieDTO.class);
	}
	
}
