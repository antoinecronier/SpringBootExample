package com.example.demo.configuration.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.security.SecurityUser;
import com.example.demo.repository.security.SecurityUserCrudRepository;

@Controller
public class LoginResultController {
	
	@Autowired
	SecurityUserCrudRepository repo;

	@RequestMapping(path = "/loginResult", method = RequestMethod.GET)
	public ResponseEntity<SecurityUser> loginPost() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User userDetails = (User)auth.getPrincipal();
        return ResponseEntity.ok(repo.findByLogin(userDetails.getUsername()));
	}
}
