package com.training.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.training.springboot.entity.User;
import com.training.springboot.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {


	@Autowired
	UserRepository repository;
	
	@Override
	public List<User> getUsers() {
		
		return repository.findAll();
	}


	@Override
	public User addUser(User user) {
		
		return repository.save(user);
	}


	@Override
	public User getUserById(int id) {
		
		Optional<User> user= repository.findById(id);
		
		if (user.isPresent()){
			return user.get();
		}
		else {
			return null;
		}
	}

	@Override
	public void updateUser(int id,User user) {
		
		Optional<User> oldUser= repository.findById(id);
		
		if (oldUser.isPresent()) {
			User userObj = oldUser.get();
			userObj.setFirstName(user.getFirstName());
			userObj.setLastName(user.getLastName());
			userObj.setAge(user.getAge());
			userObj.setGender(user.getGender());
			repository.save(userObj);
		}
		
		else {
			System.out.println("No data found");
		}
		
	}

	@Override
	public User getUserByFirstName(String firstName) {
	
		return repository.findByFirstName(firstName);
		
	}


	@Override
	public String deleteUserById(int id) {
		
		 repository.deleteById(id);
		 
		 return "deleted" + id;
		 
	}

	
}