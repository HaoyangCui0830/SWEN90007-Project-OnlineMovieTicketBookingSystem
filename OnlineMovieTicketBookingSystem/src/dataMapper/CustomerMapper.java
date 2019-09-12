package dataMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.Customer;
import domain.DomainObject;
import utils.DBConnection;
import utils.IdentityMap;

public class CustomerMapper extends DataMapper{

	@Override
	public boolean insert(DomainObject object) {
		Customer customer = (Customer)object;
		String insertCustomerString = "INSERT INTO Customer (firstname, lastname) VALUES"
				+ "(?,?)";
		int result = 0;
		//Boolean result = false;
		try {
			PreparedStatement stmt = DBConnection.prepare(insertCustomerString);
			stmt.setString(1, customer.getFirstNameString());
			stmt.setString(2, customer.getLastNameString());
			result = stmt.executeUpdate();
			stmt.close();
			DBConnection.closeConnection();
			System.out.println(result);
			
		}
		catch(SQLException e) {
			System.out.println(this.getClass().toString()+" insert customer Problem");
		}
		if(result == 0) {
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public boolean delete(DomainObject object) throws Exception {
		Customer customer = (Customer)object;
		String deleteCustomerString = "DELETE FROM Customer WHERE customer_id = ?";
		int result = 0;
		try {
			PreparedStatement stmt = DBConnection.prepare(deleteCustomerString);
			stmt.setInt(1, customer.getCustomerId());
			result = stmt.executeUpdate();
		}
		catch(SQLException e) {
			System.out.println(this.getClass().toString()+" delete customer Problem");
		}
		if(result == 0) {
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public boolean update(DomainObject object) throws Exception {
		Customer customer = (Customer)object;
		String updateCustomerString = "UPDATE Customer SET firstname = ?,"
				+ "lastname = ? WHERE customer_id = ?";
		int result = 0;
		try {
			PreparedStatement stmt = DBConnection.prepare(updateCustomerString);
			stmt.setString(1, customer.getFirstNameString());
			stmt.setString(2, customer.getLastNameString());
			result = stmt.executeUpdate();
			
		}
		catch(SQLException e) {
			System.out.println(this.getClass().toString()+" update customer Problem");
		}
		if(result == 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public List<Customer> findAllCustomers(){
		String findAllCustomerString = "SELECT * FROM Customer";
		List<Customer> result = new ArrayList<Customer>();
		try {
			PreparedStatement stmt = DBConnection.prepare(findAllCustomerString);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Customer customer = new Customer();
				IdentityMap<Customer> identityMap = IdentityMap.getInstance(customer);
				customer.setCustomerId(rs.getInt(1));
				customer.setFirstNameString(rs.getString(2));
				customer.setLastNameString(rs.getString(3));
				identityMap.put(customer.getCustomerId(), customer);
				result.add(customer);
			}
		}
		catch(SQLException e) {
			System.out.println(this.getClass().toString()+" view customer Problem");
		}
		return result;
	}
	
	public Customer findCustomerById(int customerId) {
		String findCustomerByIdString = "SELECT * FROM Customer WHERE customer_id = ?";
		Customer result = new Customer();
		try {
			PreparedStatement stmt = DBConnection.prepare(findCustomerByIdString);
			stmt.setInt(1, customerId);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Customer customer = new Customer();
				IdentityMap<Customer> identityMap = IdentityMap.getInstance(customer);
				customer.setCustomerId(rs.getInt(1));
				customer.setFirstNameString(rs.getString(2));
				customer.setLastNameString(rs.getString(3));
				identityMap.put(customer.getCustomerId(), customer);
				result = customer;
			}
		}
		catch(SQLException e) {
			System.out.println(this.getClass().toString()+" view by customer id Problem");
		}
		return result;
	}


}
