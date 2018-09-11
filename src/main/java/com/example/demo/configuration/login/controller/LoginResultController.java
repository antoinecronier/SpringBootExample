package com.example.demo.configuration.login.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginResultController {

	@RequestMapping(path = "/loginResult", method = RequestMethod.GET)
	public ResponseEntity<User> loginPost() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User userDetails = (User)auth.getPrincipal();
        return ResponseEntity.ok(userDetails);
	}
}
