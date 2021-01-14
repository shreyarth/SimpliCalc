package com.p3sec3.authenticator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.p3sec3.model.User;

public class UserAuthTest {
	@BeforeEach
	public void setup() {
		UserAuth.users.add(new User("Simpli", "Simpli"));
		UserAuth.users.add(new User("Jack", "Blakc"));
		UserAuth.users.add(new User("Molly", "1234"));
		UserAuth.users.add(new User("Jon", "section"));
		UserAuth.users.add(new User("Ken", "word"));
		UserAuth.users.add(new User("Xavier", "pass"));
	}
	
	@Test
	public void loginTest() {
		UserAuth userAuth = new UserAuth();
		assertEquals(true, userAuth.login("Jack", "Blakc"));
	}
	
	@Test
	public void wrongLoginTest() {
		UserAuth userAuth = new UserAuth();
		assertEquals(true, userAuth.login("Ken", "Blakc"));
	}
}
