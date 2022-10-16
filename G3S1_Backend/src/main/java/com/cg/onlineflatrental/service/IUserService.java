package com.cg.onlineflatrental.service;

import java.util.List;

import com.cg.onlineflatrental.DTO.UserDTO;
import com.cg.onlineflatrental.entity.User;
import com.cg.onlineflatrental.exception.UserNotFoundException;

public interface IUserService {
	public UserDTO viewUser(int userId) throws UserNotFoundException;
	public List<UserDTO> viewAllUsers() throws UserNotFoundException;
	public UserDTO validateUser(String userName,String password) throws UserNotFoundException;
	public User addUser(UserDTO user) throws UserNotFoundException;
	public User updateUser(UserDTO user) throws UserNotFoundException;
	public User updatePassword(String userName,String newPassword) throws UserNotFoundException;
	public User removeUser(UserDTO user) throws UserNotFoundException;
}