package com.cg.onlineflatrental.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = "/login")
@CrossOrigin(origins="http://localhost:3000")

@Api(value = "login")
public class LoginController {
    @Autowired
	private ILoginService service;
    private static final Logger LOGGER = LogManager.getLogger(UserService.class);

    @GetMapping(value = "/authenticateUser/{username}/{password}/{usertype}")

	public ResponseEntity<User> login(@PathVariable String username, @PathVariable String password, @PathVariable String usertype) {
		ResponseEntity<User> rentity;
		if (service.login(username,password,usertype)) {
			User user = new User(username,password,usertype);
			rentity = new ResponseEntity<User>(user, HttpStatus.ACCEPTED)  ;
		} else {
			rentity = new ResponseEntity<User>(HttpStatus.UNAUTHORIZED);
		}
		return rentity;
	}

}
