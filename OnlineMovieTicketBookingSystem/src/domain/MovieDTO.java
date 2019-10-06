package domain;

import java.sql.Time;

import com.google.gson.Gson;

public class MovieDTO {

	private int movieId;
	private String name;
	private String length;
	private float price;
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
	 * @return the name
	 */
	public String getName() {
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
	public String getLength() {
		return length;
	}
	/**
	 * @param length the length to set
	 */
	public void setLength(String length) {
		this.length = length;
	}
	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}
	
	

	/**
	 * convert MovieDTO object to Json, for remote access
	 * */
	public static String serialize(MovieDTO movieDTO) {
		Gson gson = new Gson();
		return gson.toJson(movieDTO);
	}
	
	/**
	 * Convert Json to MovieDTO
	 * */
	public static MovieDTO deserialize(String movieString) {
		Gson gson = new Gson();
		return gson.fromJson(movieString, MovieDTO.class);
	}
	
}
