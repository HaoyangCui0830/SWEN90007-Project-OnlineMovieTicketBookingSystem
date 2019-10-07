package service;

import java.util.List;

import dataMapper.TicketMapper;
import dataMapper.UserMapper;
import domain.Ticket;
import domain.User;
import utils.IdentityMap;
import utils.UnitOfWork;

public class UserService{
	UserMapper userMapper;
	
	public UserService() {
		this.userMapper = new UserMapper();// TODO Auto-generated constructor stub
	}
	
	public List<User> getAllUsers(){
		
		return userMapper.findAllUsers();
	}
	
	public User getUserByUsername(String username) {
		
		User user = new UserMapper().findUserByUsername(username);
		return user;
		
	}
	

	
	public boolean insertUser(User user,String owner) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerNew(user);
		boolean result = UnitOfWork.getCurrent().commit(owner);
		return result;
	}
	
	public boolean deleteUser(User user,String owner) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerDeleted(user);
		boolean result = UnitOfWork.getCurrent().commit(owner);
		return result;
	}
	
	public boolean updateUser(User user,String owner) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerDirty(user);
		boolean result = UnitOfWork.getCurrent().commit(owner);
		return result;
	}
	
	
}
