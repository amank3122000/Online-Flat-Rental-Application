package com.cg.onlineflatrental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineflatrental.DTO.UserDTO;
import com.cg.onlineflatrental.entity.User;
import com.cg.onlineflatrental.exception.UserNotFoundException;
import com.cg.onlineflatrental.exception.ValidationException;
import com.cg.onlineflatrental.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private Environment environment;

	@GetMapping("/users/{id}")
	public ResponseEntity<UserDTO> viewUser(@PathVariable Integer id) throws UserNotFoundException {
		UserDTO user = userService.viewUser(id);
		ResponseEntity<UserDTO> retvalue = new ResponseEntity<UserDTO>(user, HttpStatus.OK);
		return retvalue;
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<UserDTO>> viewAllUsers() throws UserNotFoundException {
		List<UserDTO> list=userService.viewAllUsers();
		return new ResponseEntity<List<UserDTO>>(list,HttpStatus.OK);
	}
	
	@PostMapping("/users")
	public ResponseEntity<String> addUser(@RequestBody UserDTO user) throws UserNotFoundException {
		User user1=userService.addUser(user);
		String successMessage = "User id: "+ user1.getUserId()+" ,"+environment.getProperty("API.INSERT_SUCCESS");
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<String> updateUser(@RequestBody UserDTO user,@PathVariable Integer id) throws UserNotFoundException{
		User user1 = userService.updateUser(user,id);
		String successMessage = "User id: "+ user1.getUserId()+" ,"+environment.getProperty("API.UPDATE_SUCCESS");
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
		
	}
	
	@PatchMapping("/users/{newpass}")
	public ResponseEntity<String> updatePassword(@RequestBody String userName,@PathVariable String newpass) throws UserNotFoundException{
		User user1 = userService.updatePassword(userName, newpass);
		String successMessage = "User id: "+ user1.getUserId()+" ,"+environment.getProperty("API.UPDATE_SUCCESS");
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<String> removeUser(@PathVariable Integer id) throws UserNotFoundException{
		User user1=userService.removeUser(id);
		String successMessage = "User id: "+ user1.getUserId()+" ,"+environment.getProperty("API.DELETE_SUCCESS");
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}
	
	@PatchMapping("/users/{username}/{password}")
	public ResponseEntity<String> validateUser(@PathVariable String username, @PathVariable String password) throws UserNotFoundException, ValidationException {
		User user1=userService.validateUser(username,password);
		String successMessage = "User id: "+ user1.getUserId()+" ,"+environment.getProperty("API.VALIDATE_SUCCESS");
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}

}

