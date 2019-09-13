package domain;

import java.sql.Time;

import dataMapper.ThreeDMovieMapper;

public class ThreeDMovie extends Movie{

	private Boolean hasFreeGlasses;

	/**
	 * @param movieId
	 * @param name
	 * @param length
	 * @param price
	 * @param hasFreeGlasses
	 */
	public ThreeDMovie(int movieId, String name, Time length, float price, Boolean hasFreeGlasses) {
		super(movieId, name, length, price);
		this.hasFreeGlasses = hasFreeGlasses;
	}

	/**
	 * @param movieId
	 * @param name
	 * @param length
	 * @param price
	 */
	public ThreeDMovie(int movieId, String name, Time length, float price) {
		super(movieId, name, length, price);
	}
	
	/**
	 * @param movieId
	 * @param name
	 * @param length
	 * @param price
	 */
	public ThreeDMovie() {
		super();
	}

	/**
	 * @return the hasFreeGlasses
	 */
	public Boolean getHasFreeGlasses() {
		if(this.hasFreeGlasses == null) {
			load();
		}
		return hasFreeGlasses;
	}

	/**
	 * @param hasFreeGlasses the hasFreeGlasses to set
	 */
	public void setHasFreeGlasses(Boolean hasFreeGlasses) {
		this.hasFreeGlasses = hasFreeGlasses;
	}
	
	@Override
	void load() {
		ThreeDMovie threeDMovie = new ThreeDMovieMapper().findThreeDMovieById(this.getMovieId());
		if(this.hasFreeGlasses == null ) {
			this.hasFreeGlasses = threeDMovie.hasFreeGlasses;
		}
	}
	
}
