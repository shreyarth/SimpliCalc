package com.p3sec3.authenticator;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import com.p3sec3.model.User;

public class UserAuth {
	public static Set<User> users = new HashSet<>();
	private User user;
	
	public boolean login(String userName, String password) {
//		if(user.getUserName().equals(userName) && user.getPassword().equals(password)) {
//			return true;
//		}
//		boolean bool = users.contains(user.getUserName().equals(userName)&& users.contains(user.getPassword().equals(password)));
//		System.out.println(bool);
//		return false;
		AtomicBoolean userExists = new AtomicBoolean(false);
		users.stream().filter(u-> u.getUserName().equals(userName)&&
				u.getPassword().equals(password)).findFirst()
				.ifPresent(x->{
					userExists.set(true);
					user = x;
				});
		return userExists.get();
	}
}
