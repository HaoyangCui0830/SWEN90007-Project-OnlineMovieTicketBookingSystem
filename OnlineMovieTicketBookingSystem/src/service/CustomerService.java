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
	
	/**
	 * Collect all customer info from DB
	 * */
	public List<Customer> getAllCustomers(){
		List<Customer> customers = new ArrayList<Customer>();
		customers = this.customerMapper.findAllCustomers();
		return customers;
	}
	
	/**
	 * Collect one customer by id
	 * @param customerId
	 * */
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
	
	/**
	 * insert customer info into DB
	 * @param customer
	 * */
	public void insertCustomer(Customer customer) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerNew(customer);
		UnitOfWork.getCurrent().commit();
	}
	
	/**
	 * delete customer from DB
	 * @param customer
	 * */
	public void deleteCustomer(Customer customer) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerDeleted(customer);
		UnitOfWork.getCurrent().commit();
	}
	
	/**
	 * update customer info into DB
	 * @param customer
	 * */
	public void updateCustomer(Customer customer) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerDirty(customer);
		UnitOfWork.getCurrent().commit();
	}
	
}
