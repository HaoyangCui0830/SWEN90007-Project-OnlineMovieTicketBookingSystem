package domain;

import dataMapper.CustomerMapper;

public class CustomerAssembler {

	/**
	 * return CustomerDTO object, called by remote facade
	 * */
	public static CustomerDTO createCustomerDTO(Customer customer) {
		CustomerDTO result = new CustomerDTO();
		result.setCustomerId(customer.getCustomerId());
		result.setFirstNameString(customer.getFirstNameString());
		result.setLastNameString(customer.getLastNameString());
		return result;
	}
	
	/**
	 * update customer object, called by remote facade
	 * */
	public static boolean updateCustomer(CustomerDTO customerDTO) {
		Customer customer = new Customer();
		customer.setCustomerId(customerDTO.getCustomerId());
		customer.setFirstNameString(customerDTO.getFirstNameString());
		customer.setLastNameString(customerDTO.getLastNameString());
		boolean result = false;
		try {
			result = new CustomerMapper().update(customer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * insert new customer object, called by remote facade
	 * */
	public static boolean addCustomer(CustomerDTO customerDTO) {
		Customer customer = new Customer();
		customer.setCustomerId(customerDTO.getCustomerId());
		customer.setFirstNameString(customerDTO.getFirstNameString());
		customer.setLastNameString(customerDTO.getLastNameString());
		boolean result = false;
		try {
			result = new CustomerMapper().insert(customer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
}
