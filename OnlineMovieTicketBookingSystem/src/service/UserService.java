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
	

	
	public void insertUser(User user) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerNew(user);
		UnitOfWork.getCurrent().commit();
	}
	
	public void deleteUser(User user) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerDeleted(user);
		UnitOfWork.getCurrent().commit();
	}
	
	public void updateUser(User user) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerDirty(user);
		UnitOfWork.getCurrent().commit();
	}
	
	
}
