package domain;

import com.google.gson.Gson;

public class CinemaManagerDTO {
	private int cinemaManagerId;
	private String firstNameString;
	private String lastNameString;
	
	/**
	 * @return the cinemaManagerId
	 */
	public int getCinemaManagerId() {
		return cinemaManagerId;
	}
	/**
	 * @param cinemaManagerId the cinemaManagerId to set
	 */
	public void setCinemaManagerId(int cinemaManagerId) {
		this.cinemaManagerId = cinemaManagerId;
	}
	/**
	 * @return the firstNameString
	 */
	public String getFirstNameString() {
		return firstNameString;
	}
	/**
	 * @param firstNameString the firstNameString to set
	 */
	public void setFirstNameString(String firstNameString) {
		this.firstNameString = firstNameString;
	}
	/**
	 * @return the lastNameString
	 */
	public String getLastNameString() {
		return lastNameString;
	}
	/**
	 * @param lastNameString the lastNameString to set
	 */
	public void setLastNameString(String lastNameString) {
		this.lastNameString = lastNameString;
	}
	
	/**
	 * convert CinemaManagerDTO object to Json, for remote access
	 * */
	public static String serialize(CinemaManagerDTO cinemaManagerDTO) {
		Gson gson = new Gson();
		return gson.toJson(cinemaManagerDTO);
	}
	
	/**
	 * Convert Json to CinemaManagerDTO
	 * */
	public static CinemaManagerDTO deserialize(String cinemaManagerString) {
		Gson gson = new Gson();
		return gson.fromJson(cinemaManagerString, CinemaManagerDTO.class);
	}
}
