package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.security.SecurityUser;
import com.example.demo.repository.security.SecurityUserCrudRepository;

@RestController
@RequestMapping(RegisterController.BASE_URL)
public class RegisterController {
	
	public static final String BASE_URL = "/register";
	
	@Autowired
	SecurityUserCrudRepository crudRepository;
	
	@RequestMapping(path={"/", ""}, method=RequestMethod.POST)
    public ResponseEntity<SecurityUser> postItem(@RequestBody SecurityUser item) {
    	crudRepository.save(item);
    	new ResponseEntity<SecurityUser>(HttpStatus.OK);
		return ResponseEntity.ok(item);
    }
}
