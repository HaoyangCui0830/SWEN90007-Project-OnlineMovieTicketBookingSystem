package domain;

import java.sql.Time;
import dataMapper.MovieMapper;

public class Movie extends DomainObject{
	
	private int movieId = -1;
	private String name;
	private Time length;
	private float price = -1;

	
	/**
	 * @param movieId
	 * @param name
	 * @param length
	 * @param price
	 */
	public Movie(int movieId, String name, Time length, float price) {
		super();
		this.movieId = movieId;
		this.name = name;
		this.length = length;
		this.price = price;
		
	}
	

	/**
	 * 
	 */
	public Movie() {
		super();
		
	}



	/**
	 * @return the movieId
	 */
	public int getMovieId() {
		if(this.movieId == -1) {
			load();
		}
		return movieId;
	}



	/**
	 * @param movieId the movieId to set
	 */
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}



	/**
	 * @return the name
	 */
	public String getName() {
		if(this.name == null) {
			load();
		}
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the length
	 */
	public Time getLength() {
		if(this.length == null) {
			load();
		}
		return length;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(Time length) {
		this.length = length;
	}

	/**
	 * @return the price
	 */
	public float getPrice() {
		if(this.price == -1) {
			load();
		}
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}
	
	/**
	 * Lazy load (Ghost)
	 * */
	@Override
	void load() {
		Movie movie = new MovieMapper().findMovieById(this.movieId);
		if(this.length == null) {
			this.length = movie.getLength();
		}
		if(this.name == null) {
			this.name = movie.getName();
		}
		if(this.price == -1) {
			this.price = movie.getPrice();
		}
		
	}


	@Override
	public int getId() {
		return this.movieId;
	}
	
}
