package domain;

import com.google.gson.Gson;

public class SessionDTO {

	private int sessionId;
	private String startTime;
	private String endTime;
	private int movieId;
	private int seats;
	private int availableSeats;
	/**
	 * @return the sessionId
	 */
	public int getSessionId() {
		return sessionId;
	}
	/**
	 * @param sessionId the sessionId to set
	 */
	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}
	
	/**
	 * @return the startTime
	 */
	public String getStartTime() {
		return startTime;
	}
	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	/**
	 * @return the endTime
	 */
	public String getEndTime() {
		return endTime;
	}
	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
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
	 * @return the seats
	 */
	public int getSeats() {
		return seats;
	}
	/**
	 * @param seats the seats to set
	 */
	public void setSeats(int seats) {
		this.seats = seats;
	}
	/**
	 * @return the availableSeats
	 */
	public int getAvailableSeats() {
		return availableSeats;
	}
	/**
	 * @param availableSeats the availableSeats to set
	 */
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	
	

	/**
	 * convert SessionDTO object to Json, for remote access
	 * */
	public static String serialize(SessionDTO sessionDTO) {
		Gson gson = new Gson();
		return gson.toJson(sessionDTO);
	}
	
	/**
	 * Convert Json to SessionDTO
	 * */
	public static SessionDTO deserialize(String sessionString) {
		Gson gson = new Gson();
		return gson.fromJson(sessionString, SessionDTO.class);
	}
	
	
	
}
