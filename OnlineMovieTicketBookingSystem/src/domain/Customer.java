package domain;

import dataMapper.CustomerMapper;

public class Customer extends DomainObject{

	private int customerId = -1;
	private String firstNameString;
	private String lastNameString;
	

	/**
	 * @param customerId
	 */
	public Customer(int customerId) {
		super();
		this.customerId = customerId;
	}

	/**
	 * @param customerId
	 * @param firstNameString
	 * @param lastNameString
	 */
	public Customer(int customerId, String firstNameString, String lastNameString) {
		super();
		this.customerId = customerId;
		this.firstNameString = firstNameString;
		this.lastNameString = lastNameString;
	}

	
	
	/**
	 * 
	 */
	public Customer() {
		super();
	}

	/**
	 * @return the customerId
	 */
	public int getCustomerId() {
		if(this.customerId == -1) {
			load();
		}
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
		if(this.firstNameString == null) {
			load();
		}
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
		if(this.lastNameString == null) {
			load();
		}
		return lastNameString;
	}

	/**
	 * @param lastNameString the lastNameString to set
	 */
	public void setLastNameString(String lastNameString) {
		this.lastNameString = lastNameString;
	}

	@Override
	void load() {
		Customer customer = new CustomerMapper().findCustomerById(this.customerId);
		if(this.firstNameString == null) {
			this.firstNameString = customer.firstNameString;
		}
		if(this.lastNameString == null ) {
			this.lastNameString = customer.lastNameString;
		}
	}
	
	
}
