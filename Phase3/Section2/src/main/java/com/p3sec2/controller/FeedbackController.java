package com.p3sec2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FeedbackController {
	@GetMapping("/")
	public String feedback() {
		return "feedback.html";
	}
}
