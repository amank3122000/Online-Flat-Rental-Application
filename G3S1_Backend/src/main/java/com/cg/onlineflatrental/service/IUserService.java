package com.cg.onlineflatrental.service;

import java.util.List;

import com.cg.onlineflatrental.DTO.UserDTO;
import com.cg.onlineflatrental.entity.User;
import com.cg.onlineflatrental.exception.UserNotFoundException;
import com.cg.onlineflatrental.exception.ValidationException;

public interface IUserService {
	public UserDTO viewUser(int userId) throws UserNotFoundException;
	public List<UserDTO> viewAllUsers() throws UserNotFoundException;
	public User validateUser(String userName,String password) throws UserNotFoundException,ValidationException;
	public User addUser(UserDTO user) throws UserNotFoundException;
	public User updateUser(UserDTO user,Integer userId) throws UserNotFoundException;
	public User updatePassword(String userName,String newPassword) throws UserNotFoundException;
	public User removeUser(Integer userId) throws UserNotFoundException;
}