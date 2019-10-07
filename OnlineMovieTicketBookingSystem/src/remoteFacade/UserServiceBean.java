package remoteFacade;

import dataMapper.UserMapper;
import domain.TicketAssembler;
import domain.TicketDTO;
import domain.User;
import domain.UserAssembler;
import domain.UserDTO;

public class UserServiceBean {
	
	public UserDTO getUser(String username) {
		User user = new UserMapper().findUserByUsername(username);
		UserDTO userDTO = UserAssembler.createUserDTO(user);
		return userDTO;
	}
	
	public String getUserString(String username) {
		User user = new UserMapper().findUserByUsername(username);
		UserDTO userDTO = UserAssembler.createUserDTO(user);
		return UserDTO.serialize(userDTO);
	}
	
	public boolean addUser(UserDTO userDTO) {
		return UserAssembler.addUser(userDTO);
	}
	
	public boolean addUserJson(String json) {
		UserDTO userDTO = UserDTO.deserialize(json);
		return UserAssembler.addUser(userDTO);
	}
	
	public boolean updateUser(UserDTO userDTO) {
		return UserAssembler.updateUser(userDTO);
	}
	
	public boolean updateUserJson(String json) {
		UserDTO userDTO = UserDTO.deserialize(json);
		return UserAssembler.updateUser(userDTO);
	}
}
