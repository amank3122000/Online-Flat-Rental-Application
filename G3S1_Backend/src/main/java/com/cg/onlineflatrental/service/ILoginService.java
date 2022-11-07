package com.cg.onlineflatrental.service;

import javax.security.auth.login.LoginException;

import com.cg.onlineflatrental.exception.UserNotFoundException;

public interface ILoginService  {

	public boolean login(String username, String password, String userType)throws LoginException, UserNotFoundException;

}
