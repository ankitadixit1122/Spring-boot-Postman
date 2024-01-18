package com.training.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.springboot.entity.User;

public interface UserRepository extends JpaRepository <User,Integer>{
	
	User findByFirstName(String firstName);

}
