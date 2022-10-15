package com.cg.onlineflatrental.service;

import java.util.List;

import com.cg.onlineflatrental.entity.User;
import com.cg.onlineflatrental.exception.UserNotFoundException;

public interface IUserService {
	public User viewUser(int userId) throws UserNotFoundException;
	public List<User> viewAllUsers() throws UserNotFoundException;
	public User validateUser(String userName,String password) throws UserNotFoundException;
	public User addUser(User user) throws UserNotFoundException;
	public User updateUser(User user) throws UserNotFoundException;
	public User updatePassword(String userName,String newPassword) throws UserNotFoundException;
	public User removeUser(User user) throws UserNotFoundException;
}