package service;

import java.util.ArrayList;
import java.util.List;

import dataMapper.CustomerMapper;
import domain.Customer;
import utils.IdentityMap;
import utils.UnitOfWork;

public class CustomerService {

	private CustomerMapper customerMapper;
	
	public CustomerService() {
		this.customerMapper = new CustomerMapper();
	}
	
	public List<Customer> getAllCustomers(){
		List<Customer> customers = new ArrayList<Customer>();
		customers = this.customerMapper.findAllCustomers();
		return customers;
	}
	
	public Customer findCustomerById(int customerId) {
		Customer customer = new Customer();
		customer.setCustomerId(customerId);
		IdentityMap<Customer> identityMap = IdentityMap.getInstance(customer);
		Customer customerInIdentityMap = identityMap.get(customer.getCustomerId());
		if(customerInIdentityMap != null) {
			Customer result = customerInIdentityMap;
			return result;
		}
		else {
			return customerMapper.findCustomerById(customerId);
		}
	}
	
	public void insertCustomer(Customer customer) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerNew(customer);
		UnitOfWork.getCurrent().commit();
	}
	
	public void deleteCustomer(Customer customer) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerDeleted(customer);
		UnitOfWork.getCurrent().commit();
	}
	
	public void updateCustomer(Customer customer) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerDirty(customer);
		UnitOfWork.getCurrent().commit();
	}
	
}
