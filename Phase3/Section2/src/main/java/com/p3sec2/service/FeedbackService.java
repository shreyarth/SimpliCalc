package com.p3sec2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.p3sec2.entity.Feedback;
import com.p3sec2.repository.FeedbackDao;

@Service
public class FeedbackService {
	@Autowired
	private FeedbackDao feedbackDao;
	
	public boolean addFeedback(String feedback) {
		feedbackDao.save(new Feedback(feedback));
		return true;
	}
}
