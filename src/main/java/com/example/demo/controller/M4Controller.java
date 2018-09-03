package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.base.BaseRestController;
import com.example.demo.model.M4;

@RestController
@RequestMapping(M4Controller.BASE_URL)
public class M4Controller extends BaseRestController<M4, Long> {
	public static final String BASE_URL = "/M4";
}