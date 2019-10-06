package domain;

import com.google.gson.Gson;

public class CustomerDTO {

	private int customerId;
	private String firstNameString;
	private String lastNameString;
	/**
	 * @return the customerId
	 */
	public int getCustomerId() {
		return customerId;
	}
	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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
	

	public static String serialize(CustomerDTO customerDTO) {
		Gson gson = new Gson();
		return gson.toJson(customerDTO);
	}
	
	public static CustomerDTO deserialize(String customerString) {
		Gson gson = new Gson();
		return gson.fromJson(customerString, CustomerDTO.class);
	}
}
