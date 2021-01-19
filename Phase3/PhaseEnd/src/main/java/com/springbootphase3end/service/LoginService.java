package com.springbootphase3end.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

	public boolean validateUser(String username) {
		return username.equals("test");
	}
}