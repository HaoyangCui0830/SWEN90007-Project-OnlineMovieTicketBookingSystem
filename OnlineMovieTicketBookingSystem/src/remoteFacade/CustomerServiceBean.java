package remoteFacade;

import domain.CustomerDTO;
import dataMapper.CustomerMapper;
import domain.Customer;
import domain.CustomerAssembler;

public class CustomerServiceBean {

	/**
	 * get CustomerDTO object
	 * */
	public CustomerDTO getCustomer(int id) {
		Customer customer = new CustomerMapper().findCustomerById(id);
		CustomerDTO customerDTO = CustomerAssembler.createCustomerDTO(customer);
		return customerDTO;
	}
	
	/**
	 * get CustomerDTO Json
	 * */
	public String getCustomerJson(int id) {
		Customer customer = new CustomerMapper().findCustomerById(id);
		CustomerDTO customerDTO = CustomerAssembler.createCustomerDTO(customer);
		return CustomerDTO.serialize(customerDTO);
	}
	
	/**
	 * update Customer based on input DTO
	 * */
	public boolean updateCustomer(CustomerDTO customerDTO) {
		return CustomerAssembler.updateCustomer(customerDTO);
	}
	
	
	/**
	 * update Customer based on input Json
	 * */
	public boolean updateCustomerJson(String json) {
		CustomerDTO customerDTO = CustomerDTO.deserialize(json);
		return CustomerAssembler.updateCustomer(customerDTO);
	}
	
	/**
	 * add Customer based on input DTO
	 * */
	public boolean addCustomer(CustomerDTO customerDTO) {
		return CustomerAssembler.addCustomer(customerDTO);
	}
	
	/**
	 * add Customer based on input Json
	 * */
	public boolean addCustomerJson(String json) {
		CustomerDTO customerDTO = CustomerDTO.deserialize(json);
		return CustomerAssembler.addCustomer(customerDTO);
	}
	
}
