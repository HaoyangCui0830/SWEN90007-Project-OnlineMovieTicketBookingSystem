package domain;

import com.google.gson.Gson;

public class CinemaDTO {

	private int cinemaId;
	private String name;
	private String address;
	
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
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * convert CinemaDTO object to Json, for remote access
	 * */
	public static String serialize(CinemaDTO cinemaDTO) {
		Gson gson = new Gson();
		return gson.toJson(cinemaDTO);
	}
	
	/**
	 * Convert Json to CinemaDTO
	 * */
	public static CinemaDTO deserialize(String cinemaString) {
		Gson gson = new Gson();
		return gson.fromJson(cinemaString, CinemaDTO.class);
	}
	
}
