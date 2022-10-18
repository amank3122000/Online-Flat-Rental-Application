package com.cg.onlineflatrental.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineflatrental.DTO.UserDTO;
import com.cg.onlineflatrental.entity.User;
import com.cg.onlineflatrental.exception.UserNotFoundException;
import com.cg.onlineflatrental.exception.ValidationException;
import com.cg.onlineflatrental.repository.IUserRepository;


@Service
@Transactional
public class UserService implements IUserService{
	@Autowired
	private IUserRepository userRepository;
	
	@Override
	public UserDTO viewUser(int userId) throws UserNotFoundException {
		Optional<User> optional = userRepository.findById(userId);
		User user = optional.orElseThrow(() -> new UserNotFoundException("Service.USER_NOT_FOUND"));
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
	public User validateUser(String userName,String password) throws UserNotFoundException,ValidationException {
		Optional<User> optional = userRepository.findByUserName(userName);
		optional.orElseThrow(() -> new UserNotFoundException("Service.USER_NOT_FOUND"));
		if(optional.get().getPassword().equals(password)) {
			return optional.get();
		}
		else {
			throw new ValidationException("Service.INCORRECT_PASSWORD");
		}
	}
	@Override
	public User addUser(User user) throws UserNotFoundException {
		if(userRepository.existsById(user.getUserId())) {
			throw new UserNotFoundException("Service.USER_ALREADY_EXIST");
		}
		else {
			return userRepository.save(user);
		}
		
	}
	@Override
	public User updateUser(User user) throws UserNotFoundException {
		Optional<User> optional = userRepository.findById(user.getUserId());
		optional.orElseThrow(() -> new UserNotFoundException("Service.USER_NOT_FOUND"));
		User user1=optional.get();
		user1.setUserName(user.getUserName());
		user1.setPassword(user.getPassword());
		user1.setUserType(user.getUserType());
		return userRepository.save(user1);
		
	}
	
	@Override
	public User updatePassword(User user,String newPassword) throws UserNotFoundException {
		Optional<User> optional = userRepository.findById(user.getUserId());
		optional.orElseThrow(() -> new UserNotFoundException("Service.USER_NOT_FOUND"));
		User user1=optional.get();
		user1.setPassword(newPassword);
		return userRepository.save(user1);
	}
	
	@Override
	public User removeUser(Integer userId) throws UserNotFoundException {
		Optional<User> optional = userRepository.findById(userId);
		optional.orElseThrow(() -> new UserNotFoundException("Service.USER_NOT_FOUND"));
        userRepository.deleteById(userId);
		return optional.get();
	}
}
