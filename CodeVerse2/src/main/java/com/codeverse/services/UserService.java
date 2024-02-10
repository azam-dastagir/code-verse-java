package com.codeverse.services;

import com.codeverse.entity.Users;

public interface UserService {
	//adds new user to database
	public String addUser(Users user);

	//validating the user credentials
	public boolean validate(String email, String password);
	
	//Checking weather email exists or not 
	public boolean isEmailExists(String email);
	
	//checking the user is Trainer or Student
	public boolean checkRole(String email);
	
}