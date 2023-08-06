package com.amarjeet.restapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.amarjeet.restapi.entity.User;
import com.amarjeet.restapi.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public User addUser(User user)
	{
		return userRepository.save(user);
	}
	
	public List<User> getUser()
	{
		return userRepository.findAll();
		
	}
	
	public User updateUser(User user)
	{
		return userRepository.save(user);
	}
	
	public Long deleteUserById(Long userId)
	{
		userRepository.deleteById(userId);
		//return "user deleted";
		return null;
	}

	public List<User> deleteAll() {
		userRepository.deleteAll();
		return null;
	}

}
