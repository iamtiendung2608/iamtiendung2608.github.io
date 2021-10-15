package com.example.demo.Controller;


import org.springframework.stereotype.Service;


import com.example.demo.Service.UserService;
import com.example.demo.UserAccount.AppUser;

@Service
public class RequestRegist {


	private UserService userService;
	
	public RequestRegist(UserService userService) {
		super();
		this.userService = userService;
	}

	public String regist(AppUser user) {
		// TODO Auto-generated method stub
		return userService.signUpUser(
				new AppUser(user.getUsername()
						,user.getPassword()
						,user.getName()
						,user.getAge())
				);
	}
}
