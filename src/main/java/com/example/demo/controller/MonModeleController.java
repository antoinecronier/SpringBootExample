package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.MonModele;
import com.example.demo.repository.MonModeleCrudRepository;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/MonModele")
public class MonModeleController {

    @Autowired
    MonModeleCrudRepository monModeleCrudRepository;
    Gson gson = new Gson();

    @RequestMapping(path={"/", ""}, method=RequestMethod.GET)
    public String index() {
        return gson.toJson(monModeleCrudRepository.findAll());
    }

    @RequestMapping("/{index}")
    public String getByIndex(@PathVariable("index") Long index) {
        return gson.toJson(monModeleCrudRepository.findById(index));
    }

    /*
     * @RequestBody => raw
     * @ModelAttribute => form
     * */
    @RequestMapping(path={"/", ""}, method=RequestMethod.POST)
    public String postItem(@RequestBody MonModele monModele) {
        return gson.toJson(monModeleCrudRepository.save(monModele));
    }

    @RequestMapping(path={"/", ""}, method=RequestMethod.PUT)
    public String updateItem(@RequestBody MonModele monModele) {
    	return gson.toJson(monModeleCrudRepository.save(monModele));
    }
    
    @RequestMapping(path={"/", ""}, method=RequestMethod.DELETE)
    public String deleteItem(@RequestBody MonModele monModele) {
    	monModeleCrudRepository.delete(monModele);
        return "ok";
    }
}