package remoteFacade;

import domain.CustomerDTO;
import dataMapper.CustomerMapper;
import domain.Customer;
import domain.CustomerAssembler;

public class CustomerServiceBean {

	public CustomerDTO getCustomer(int id) {
		Customer customer = new CustomerMapper().findCustomerById(id);
		CustomerDTO customerDTO = CustomerAssembler.createCustomerDTO(customer);
		return customerDTO;
	}
	
	public String getCustomerJson(int id) {
		Customer customer = new CustomerMapper().findCustomerById(id);
		CustomerDTO customerDTO = CustomerAssembler.createCustomerDTO(customer);
		return CustomerDTO.serialize(customerDTO);
	}
	
	public boolean updateCustomer(CustomerDTO customerDTO) {
		return CustomerAssembler.updateCustomer(customerDTO);
	}
	
	public boolean updateCustomerJson(String json) {
		CustomerDTO customerDTO = CustomerDTO.deserialize(json);
		return CustomerAssembler.updateCustomer(customerDTO);
	}
	
	public boolean addCustomer(CustomerDTO customerDTO) {
		return CustomerAssembler.addCustomer(customerDTO);
	}
	
	public boolean addCustomerJson(String json) {
		CustomerDTO customerDTO = CustomerDTO.deserialize(json);
		return CustomerAssembler.addCustomer(customerDTO);
	}
	
}
