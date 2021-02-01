package com.capstone.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.dao.UserRepo;
import com.capstone.entity.User;

@Service
public class UserService {
	@Autowired
	private UserRepo userRepo;
	
	List<User> users = new ArrayList<User>();
	
	public List<User> getAllUsers(){
		users = (List<User>) userRepo.findAll();
		return users;
	}
	
	public boolean isValidUser(String userName, String password) {
		return getAllUsers().stream().anyMatch(u->u.getUsername().equals(userName) && u.getPassword().equals(password));
	}
	
	public void addUser(User user) {
		userRepo.save(user);
	}
	
	public User findUser(int id) {
		User user = userRepo.findById(id).orElse(null);
		return user;
	}
	
	public void saveUser(User user) {
		userRepo.save(user);
	}
	
	public User findUserByUsername(String username) {
//		getAllUsers();
		User user = getAllUsers().stream().filter(u->u.getUsername().equals(username)).findFirst().get();
		return user;
	}
	
}
