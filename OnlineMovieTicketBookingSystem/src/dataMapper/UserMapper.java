package dataMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import domain.DomainObject;
import domain.User;
import utils.DBConnection;
import utils.IdentityMap;

public class UserMapper extends DataMapper{

	@Override
	public boolean insert(DomainObject object) {
		User user = (User)object;
		String insertUserString = "INSERT INTO users (username, password, role, first_name, last_name) VALUES"
				+ "(?,?,?,?,?)";
		int result = 0;
		//Boolean result = false;
		try {
			PreparedStatement stmt = DBConnection.prepare(insertUserString);
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getRole());
			stmt.setString(4, user.getFirstNameString());
			stmt.setString(5, user.getLastNameString());
			result = stmt.executeUpdate();
			stmt.close();
			DBConnection.closeConnection();
			System.out.println(result);	
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println(this.getClass().toString()+" insert user Problem");
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
		User user = (User)object;
		String deleteUserString = "DELETE FROM users WHERE username = ?";
		int result = 0;
		try {
			PreparedStatement stmt = DBConnection.prepare(deleteUserString);
			stmt.setString(1, user.getUsername());
			result = stmt.executeUpdate();
		}
		catch(SQLException e) {
			System.out.println(this.getClass().toString()+" delete user Problem");
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
		User user = (User)object;
		String updateUserString = "UPDATE users SET password = ?,first_name = ?, last_name = ? WHERE username = ?";
		int result = 0;
		try {
			PreparedStatement stmt = DBConnection.prepare(updateUserString);
			stmt.setString(1, user.getPassword());
			stmt.setString(2, user.getFirstNameString());
			stmt.setString(3, user.getLastNameString());
			stmt.setString(4, user.getUsername());
			
			result = stmt.executeUpdate();
			
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println(this.getClass().toString()+" update user Problem");
		}
		if(result == 0) {
			return false;
		}
		else {
			return true;
		}
	}

	public List<User> findAllUsers(){
		String findAllUsers = "SELECT * FROM users";
		List<User> result = new ArrayList<User>();
		try {
			PreparedStatement stmt = DBConnection.prepare(findAllUsers);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				User user = new User();
				IdentityMap<User> identityMap = IdentityMap.getInstance(user);
				user.setUserId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setRole(rs.getString(4));
				user.setFirstNameString(rs.getString(5));
				user.setLastNameString(rs.getString(6));

				identityMap.put(user.getUserId(), user);
				result.add(user);
			}
		}
		catch(SQLException e) {
			System.out.println(this.getClass().toString()+" view users Problem");
		}
		return result;
	}

	public User findUserByUsername(String username) {
		String findUserByUsername = "Select * FROM users WHERE username = ?";
		User result = new User();
		try {
			PreparedStatement stmt = DBConnection.prepare(findUserByUsername);
			stmt.setString(1, username);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				User user = new User();
				IdentityMap<User> identityMap = IdentityMap.getInstance(user);
				user.setUserId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setRole(rs.getString(4));
				user.setFirstNameString(rs.getString(5));
				user.setLastNameString(rs.getString(6));

				identityMap.put(user.getUserId(), user);
				result = user;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println(this.getClass().toString()+" find user Problem");
		}
		return result;
	}
}
