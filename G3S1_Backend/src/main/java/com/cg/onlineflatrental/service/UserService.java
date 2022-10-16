package com.cg.onlineflatrental.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import com.cg.onlineflatrental.DTO.UserDTO;
import com.cg.onlineflatrental.entity.User;
import com.cg.onlineflatrental.exception.UserNotFoundException;
import com.cg.onlineflatrental.repository.IUserRepository;


public class UserService implements IUserService{
	@Autowired
	private IUserRepository userRepository;
	
	@Override
	public UserDTO viewUser(int userId) throws UserNotFoundException {
		Optional<User> optional = userRepository.findById(userId);
		User user = optional.orElseThrow(() -> new UserNotFoundException("Service.CUSTOMER_NOT_FOUND"));
		UserDTO user1 = new UserDTO();
		user1.setUserId(user.getUserId());
		user1.setUserName(user.getUserName());
		user1.setPassword(user.getPassword());
		user1.setUserType(user.getUserType());
		return user1;
	}
	@Override
	public List<UserDTO> viewAllUsers() throws UserNotFoundException{
		Iterable<User> users = userRepository.findAll();
		List<UserDTO> usersList = new ArrayList<>();
		users.forEach(user -> {
			UserDTO user1 = new UserDTO();
			user1.setUserId(user.getUserId());
			user1.setUserName(user.getUserName());
			user1.setPassword(user.getPassword());
			user1.setUserType(user.getUserType());
			usersList.add(user1);
		});
		if (usersList.isEmpty())
			throw new UserNotFoundException("Service.USERS_NOT_FOUND");
		return usersList;
	}
	@Override
	public UserDTO validateUser(String userName,String password) {
		UserDTO user = new UserDTO();
		return user;
	}
	@Override
	public User addUser(UserDTO user) throws UserNotFoundException {
		if(userRepository.existsById(user.getUserId())) {
			throw new UserNotFoundException("Service.USER_ALREADY_EXIST");
		}
		else {
			User user1 = new User();
			user1.setUserId(user.getUserId());
			user1.setUserName(user.getUserName());
			user1.setPassword(user.getPassword());
			user1.setUserType(user.getUserType());
			userRepository.save(user1);
			return user1;
		}
		
	}
	@Override
	public User updateUser(UserDTO user) throws UserNotFoundException {
		Optional<User> user1 = userRepository.findById(user.getUserId());
		user1.orElseThrow(() -> new UserNotFoundException("Service.USER_NOT_FOUND"));
		User user2=user1.get();
		user2.setUserName(user.getUserName());
		user2.setPassword(user.getPassword());
		user2.setUserType(user.getUserType());
		userRepository.save(user2);
		return user2;
	}
	@Override
	public User updatePassword(String userName,String newPassword) throws UserNotFoundException {
		Optional<User> user1 = userRepository.findByUserName(userName);
		user1.orElseThrow(() -> new UserNotFoundException("Service.USER_NOT_FOUND"));
		User user=user1.get();
		user.setPassword(newPassword);
		userRepository.save(user);
		return user;
	}
	@Override
	public User removeUser(UserDTO user) throws UserNotFoundException {
		Optional<User> user1 = userRepository.findById(user.getUserId());
		user1.orElseThrow(() -> new UserNotFoundException("Service.USER_NOT_FOUND"));
		User user2=user1.get();
		userRepository.deleteById(user.getUserId());
		return user2;
	}
}
