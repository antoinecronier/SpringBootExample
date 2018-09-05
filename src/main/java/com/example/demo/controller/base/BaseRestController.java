package com.example.demo.controller.base;

import java.io.Serializable;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.repository.base.IBaseRepository;

public abstract class BaseRestController<T, ID extends Serializable> {

	@Autowired
	IBaseRepository<T, ID> crudRepository;

	@RequestMapping(path = { "/", "" }, method = RequestMethod.GET)
	public ResponseEntity<Iterable<T>> index() {
		Iterable<T> items = crudRepository.findAll();
		new ResponseEntity<T>(HttpStatus.OK);
		return ResponseEntity.ok(items);
	}

	@RequestMapping("/{index}")
	public ResponseEntity<Optional<T>> getByIndex(@PathVariable("index") ID index) {
		Optional<T> item = crudRepository.findById(index);
		new ResponseEntity<T>(HttpStatus.OK);
		return ResponseEntity.ok(item);
	}

	@RequestMapping(path = { "/", "" }, method = RequestMethod.POST)
	public ResponseEntity<T> postItem(@RequestBody T item, HttpServletResponse response) {

		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "origin, content-type, accept, x-requested-with");
		response.addHeader("Access-Control-Max-Age", "3600");

		crudRepository.save(item);
		new ResponseEntity<T>(HttpStatus.OK);
		return ResponseEntity.ok(item);
	}

	@RequestMapping(path = { "/", "" }, method = RequestMethod.PUT)
	public ResponseEntity<T> updateItem(@RequestBody T item) {
		crudRepository.save(item);
		new ResponseEntity<T>(HttpStatus.OK);
		return ResponseEntity.ok(item);
	}

	@RequestMapping(path = { "/", "" }, method = RequestMethod.DELETE)
	public ResponseEntity<T> deleteItem(@RequestBody T item) {
		crudRepository.delete(item);
		new ResponseEntity<T>(HttpStatus.OK);
		return ResponseEntity.ok(item);
	}
}
