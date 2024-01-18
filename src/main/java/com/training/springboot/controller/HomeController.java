package com.training.springboot.controller;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.springboot.entity.User;
import com.training.springboot.service.UserService;

@RestController
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	UserService service;
	
	@GetMapping("/greet")

	public String greet() {
		return "Hi there!!!!";
	}
	
	//ADDDING USER
	@GetMapping("/users")
	public ResponseEntity<List<User>> users(){
//		List<User> userList = new ArrayList<User>();
//		userList.add(new User("Ankita","Dixit",32,'m'));
//		userList.add(new User("Amy","Mark",33,'m'));
		
		List<User> userList = service.getUsers();
		
		return new ResponseEntity<>(userList,HttpStatus.OK);
		
	}
	
	@PostMapping("/user")
	public ResponseEntity<User> addUser(@RequestBody User user){
	User newUser= service.addUser(user);
	return new ResponseEntity<>(newUser,HttpStatus.CREATED);
	}
	
	//GETTING USER BY ID
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") int id){
		
		return new ResponseEntity<> (service.getUserById(id), HttpStatus.OK);

	}
	
	@PutMapping("/user/{id}")
	public ResponseEntity updateUser(@PathVariable("id") int id,@RequestBody User user) {
		service.updateUser(id, user);
		return new ResponseEntity(HttpStatus.OK);
		
	}
	
	@GetMapping("/user/byName/{firstName}")
	public ResponseEntity<User> getUserByName(@PathVariable("firstName") String firstName){
		return new ResponseEntity<>(service.getUserByFirstName(firstName),HttpStatus.FOUND);
		
	}
}