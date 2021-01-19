package com.springbootphase3end.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.springbootphase3end.entity.Tasks;
import com.springbootphase3end.service.LoginService;

@Controller
@SessionAttributes("name")
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String showLoginPage(ModelMap model){
		return "login";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String showWelcomePage(ModelMap model, @RequestParam String username){
		
		boolean isValidUser = loginService.validateUser(username);
		
		if (!isValidUser) {
			return ("redirect:/register");
		}
		
		model.put("username", username);
		
		return "welcome";
	}
	
	/*
	@GetMapping("/register")
	public ModelAndView registerUser() {
		User user = new User();
		return new ModelAndView("newuser", "form", user);
	}
	
	@PostMapping("/register")
	public String newUser(User user, ModelMap model) {
		loginService.addUser(user.getUsername());
		model.put("username", user.getUsername());
		return "welcome";
	}
	*/
}
