package com.cg.onlineflatrental.service;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineflatrental.exception.UserNotFoundException;

@Service
public class LoginService implements ILoginService {

	@Autowired
	UserService service;
    @Override
	public boolean login(String username, String password, String userType) throws LoginException, UserNotFoundException {
		boolean flag = false;

		if (username == null) {
			flag = false;
		}
		if (!service.checkValidUser(username,password,userType)) {
			flag = false;
		} else {
			flag = true;
		}
		return flag;
	}

}