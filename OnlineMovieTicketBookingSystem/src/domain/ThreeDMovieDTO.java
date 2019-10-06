package domain;

import com.google.gson.Gson;

public class ThreeDMovieDTO {

	private int id;
	private Boolean hasFreeGlasses;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the hasFreeGlasses
	 */
	public Boolean getHasFreeGlasses() {
		return hasFreeGlasses;
	}
	/**
	 * @param hasFreeGlasses the hasFreeGlasses to set
	 */
	public void setHasFreeGlasses(Boolean hasFreeGlasses) {
		this.hasFreeGlasses = hasFreeGlasses;
	}
	
	/**
	 * convert ThreeDMovieDTO object to Json, for remote access
	 * */
	public static String serialize(ThreeDMovieDTO threeDMovieDTO) {
		Gson gson = new Gson();
		return gson.toJson(threeDMovieDTO);
	}
	
	
	/**
	 * Convert Json to ThreeDMovieDTO
	 * */
	public static ThreeDMovieDTO deserialize(String threeDMovieString) {
		Gson gson = new Gson();
		return gson.fromJson(threeDMovieString, ThreeDMovieDTO.class);
	}
	
}
