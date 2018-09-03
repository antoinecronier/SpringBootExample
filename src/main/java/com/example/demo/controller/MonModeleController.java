package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.base.BaseRestController;
import com.example.demo.model.MonModele;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(MonModeleController.BASE_URL)
public class MonModeleController extends BaseRestController<MonModele, Long> {

    public static final String BASE_URL = "/MonModele";
}