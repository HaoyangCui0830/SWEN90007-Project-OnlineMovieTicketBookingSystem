package domain;

import com.google.gson.Gson;

public class UserDTO {
	private int userId;
	private String firstNameString;
	private String lastNameString;
	private String username;
	private String password;
	private String role;
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstNameString() {
		return firstNameString;
	}
	public void setFirstNameString(String firstNameString) {
		this.firstNameString = firstNameString;
	}
	public String getLastNameString() {
		return lastNameString;
	}
	public void setLastNameString(String lastNameString) {
		this.lastNameString = lastNameString;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	/**
	 * convert TicketDTO object to Json, for remote access
	 * */
	public static String serialize(UserDTO userDTO) {
		Gson gson = new Gson();
		return gson.toJson(userDTO);
	}
	
	/**
	 * Convert Json to MovieDTO
	 * */
	public static UserDTO deserialize(String userString) {
		Gson gson = new Gson();
		return gson.fromJson(userString, UserDTO.class);
	}
}
