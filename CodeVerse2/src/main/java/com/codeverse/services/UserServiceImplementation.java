package com.codeverse.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeverse.entity.Users;
import com.codeverse.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService {
	@Autowired
	UserRepository repo;
	
	@Override
	public String addUser(Users user) {
		repo.save(user);
		return "Student Added Successfully";
	}

	@Override
	public boolean validate(String email, String password) {
		Users user = repo.findByEmail(email);
		return user!=null && user.getPassword().equals(password);
	}
	
	@Override
	public boolean checkRole(String email) {
		Users user = repo.findByEmail(email);
		if (user.getRole().contentEquals("Student")) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isEmailExists(String email) {
		Users emailUser = repo.findByEmail(email);
		if (emailUser!= null) {
			return true;
		}
		else {
			return false;
		}
		
	}

}
