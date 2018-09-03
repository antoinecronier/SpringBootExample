package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.base.BaseRestController;
import com.example.demo.model.M2;

@RestController
@RequestMapping(M2Controller.BASE_URL)
public class M2Controller extends BaseRestController<M2, Long> {
	public static final String BASE_URL = "/M2";
}
