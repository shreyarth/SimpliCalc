package com.section1.controller;

import java.util.List;
import static java.util.Objects.isNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.section1.dao.UserDao;
import com.section1.model.User;

@Controller
public class UserController {
	@Autowired
	private UserDao repository;

	@PostMapping("/adduser")
	public String newEmp(User user) {
		repository.save(user);
		return ("redirect:/listusers");
	}

	@GetMapping("/adduser")
	public ModelAndView addnewUser() {
		User user = new User();
		return new ModelAndView("newuser", "form", user);
	}

	@GetMapping("/")
	public String login() {
		return "login";
	}

	@GetMapping("/listusers")
	public ModelAndView listUsers(User user) {
		List<User> allusers = (List<User>) repository.findAll();
		return new ModelAndView("users", "users", allusers);
	}

	@GetMapping("/edituser")
	public ModelAndView editUserForm(@RequestParam("id") long id) {
		ModelAndView mav = new ModelAndView("editform");
		User user = repository.findById(id).orElse(null);
		if(user == null) {
			System.out.println("This is an error");
			return new ModelAndView("newuser", "form", new User());
		}
		mav.addObject("edituser", user);
		return mav;
		
	}

	@PostMapping("/edituser")
	public String editsaveUser(@ModelAttribute("user") User user) {

		repository.save(user);
		return ("redirect:/listusers");
	}

}
