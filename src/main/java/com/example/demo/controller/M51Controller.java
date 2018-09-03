package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.base.BaseRestController;
import com.example.demo.model.M51;

@RestController
@RequestMapping(M51Controller.BASE_URL)
public class M51Controller extends BaseRestController<M51, Long> {
	public static final String BASE_URL = "/M51";
}