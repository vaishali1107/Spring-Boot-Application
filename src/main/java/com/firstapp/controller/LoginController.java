package com.firstapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.firstapp.service.LoginService;

@Controller
@SessionAttributes("name")
public class LoginController {
	
	@Autowired
	LoginService loginService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)

	public String loginPage(ModelMap map) {
        
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)

	public String loggedIn(@RequestParam String name,@RequestParam String password, ModelMap map) {
		
		if(!loginService.validateLogin(name, password))
		{
			map.put("errormessage", "Invalid credentials");
			return "login";
		}
		map.put("name", name);
		map.put("password", password);
		return "welcome";
	}

}
