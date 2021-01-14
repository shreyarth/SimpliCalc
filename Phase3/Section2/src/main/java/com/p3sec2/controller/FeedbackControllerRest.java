package com.p3sec2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.p3sec2.service.FeedbackService;

@RestController
@RequestMapping("/")
public class FeedbackControllerRest {
	@Autowired
	private FeedbackService feedbackService;

	@PostMapping("/save")
	public String addFeedback(@RequestParam("feedback") String feedback) {
		if (feedbackService.addFeedback(feedback)) {
			return "Feedback added";
		}
		return "Could not add feedback";
	}
}
