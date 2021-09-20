package com.firstapp.service;

import org.springframework.stereotype.Component;

@Component
public class LoginService {

	public boolean validateLogin(String userId, String pswrd) {
		return userId.equalsIgnoreCase("vaishali") && pswrd.equalsIgnoreCase("dahiya");
	}
}
