package domain;

import dataMapper.MovieMapper;
import dataMapper.TicketMapper;
import dataMapper.UserMapper;
import service.SessionService;
import service.TicketService;
import service.UserService;

public class UserAssembler {
	
	public static UserDTO createUserDTO(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setUserId(user.getId());
		userDTO.setUsername(user.getUsername());
		userDTO.setPassword(user.getPassword());
		userDTO.setFirstNameString(user.getFirstNameString());
		userDTO.setLastNameString(user.getLastNameString());
		return userDTO;
	}
	
	public static boolean updateUser(UserDTO userDTO) {
		User user = new User();
		user.setUserId(userDTO.getUserId());
		user.setUsername(userDTO.getUsername());
		user.setPassword(userDTO.getPassword());
		user.setFirstNameString(userDTO.getFirstNameString());
		user.setLastNameString(userDTO.getLastNameString());
				
		boolean result = false;
		try {
			result = new UserMapper().update(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static boolean addUser (UserDTO userDTO) {
		User user = new User();
		user.setUserId(userDTO.getUserId());
		user.setUsername(userDTO.getUsername());
		user.setPassword(userDTO.getPassword());
		user.setFirstNameString(userDTO.getFirstNameString());
		user.setLastNameString(userDTO.getLastNameString());
		boolean result = false;
		try {
			result = new UserMapper().insert(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
		
	}
}
