package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.base.BaseRestController;
import com.example.demo.model.M51M52;

@RestController
@RequestMapping(M51M52Controller.BASE_URL)
public class M51M52Controller extends BaseRestController<M51M52, Long> {
	public static final String BASE_URL = "/M51M52";
}