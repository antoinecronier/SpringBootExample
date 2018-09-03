package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.base.BaseRestController;
import com.example.demo.model.M3;

@RestController
@RequestMapping(M3Controller.BASE_URL)
public class M3Controller extends BaseRestController<M3, Long> {
	public static final String BASE_URL = "/M3";
}