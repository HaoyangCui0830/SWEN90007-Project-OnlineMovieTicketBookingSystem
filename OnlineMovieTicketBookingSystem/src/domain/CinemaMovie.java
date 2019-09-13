package domain;

public class CinemaMovie extends DomainObject{

	private int movieId;
	private int cinemaId;
	/**
	 * @param movieId
	 * @param cinemaId
	 */
	public CinemaMovie(int movieId, int cinemaId) {
		super();
		this.movieId = movieId;
		this.cinemaId = cinemaId;
	}
	/**
	 * 
	 */
	public CinemaMovie() {
		super();
	}
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
	
	
	
}