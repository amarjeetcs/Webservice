package com.amarjeet.restapi.controller;

import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amarjeet.restapi.entity.User;
import com.amarjeet.restapi.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
	}

	@GetMapping("/getUser")
	public List<User> getUser(){
		return userService.getUser();
	}
	
	@PutMapping("/updateUser")
	public User updateUser(@RequestBody User user)
	{
		return userService.addUser(user);
	}
	
	@DeleteMapping("/deleteUser")
	public List<User> deleteUser(Long userId)
	{
		return userService.deleteAll();
	}
	
	@DeleteMapping("{userId}")
	public Long deleteUserById(@PathVariable("userId") Long userId) {
		return userService.deleteUserById(userId);
		
	}
}
