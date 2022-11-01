package com.cg.onlineflatrental.DTO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDTO {
	
private Integer userId;
	
	@NotNull(message = "{Please provide valid user name}")
	private String userName;
	
	@NotNull(message = "{Please provide valid password}")
	@Size(min=5, max=15, message="{Password should have a size between 5 to 15.}")
	private String password;
	
	@NotNull(message = "{Please provide valid userType}")
	private String userType;
	
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserDTO(int userId, String userName, String password, String userType) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.userType = userType;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", userName=" + userName + ", password=" + password + ", userType="
				+ userType + "]";
	}
	
}
