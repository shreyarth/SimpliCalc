package com.capstone.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.capstone.entity.User;
import com.capstone.service.ProdService;
import com.capstone.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}

	@PostMapping("/login")
	public String login(@RequestParam("username") String userName, @RequestParam("password") String password, HttpSession session) {
		if(userService.isValidUser(userName, password)) {
			session.setAttribute("username", userName);
			session.setAttribute("password", password);
			return ("redirect:/");
		}
		return ("redirect:/register");
	}

	@GetMapping("/register")
	public String addUser(ModelMap model) {
		model.addAttribute("user", new User());
		return "register";
	}

	@PostMapping("/register")
	public String addUserPost(@ModelAttribute("user") User user, ModelMap model, HttpSession session) {
		userService.addUser(user);
		model.put("username", user.getUsername());
		session.setAttribute("username", user.getUsername());
		session.setAttribute("password", user.getPassword());
		return ("redirect:/");
	}

	@GetMapping("/edituser")
	public String editUserForm(@SessionAttribute("username")String username, ModelMap model) {
		User user = userService.findUserByUsername(username);
		System.out.println(user);
		model.addAttribute("user", user);
		if (user == null) {
			return ("redirect:/register");
		}
		return "edituser";
	}

	@PostMapping("/edituser")
	public String editSaveUser(@ModelAttribute("user") User user) {
		userService.saveUser(user);
		return ("redirect:/");
	}
	
	@GetMapping("/allusers")
	public String getAllUsers(ModelMap model) {
		List<User> allUsers = userService.getAllUsers();
		model.addAttribute("allusers", allUsers);
		return "allusers";
		
	}
	
	@GetMapping("/edituserbyid/{id}")
	public String adminEditUser(@PathVariable("id")int id, ModelMap model) {
		User user = userService.findUser(id);
		model.addAttribute("user", user);
		return "edituser";
	}
	
	@PostMapping("/edituserbyid/{id}")
	public String adminSaveUser(@ModelAttribute("user") User user) {
		userService.saveUser(user);
		return ("redirect:/");
	}
}
