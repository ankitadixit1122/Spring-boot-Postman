package com.training.springboot.service;

import java.util.List;

//import org.springframework.http.ResponseEntity;

import com.training.springboot.entity.User;

public interface UserService {
	
	List<User> getUsers();
	
	User addUser(User user);
	
	User getUserById(int id);
	
	void updateUser(int id,User user);
	
	User getUserByFirstName(String firstName);
	
	String deleteUserById(int id);
	

}
