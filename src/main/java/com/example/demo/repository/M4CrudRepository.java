package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.model.M4;
import com.example.demo.repository.base.IBaseRepository;

@Repository
public interface M4CrudRepository extends IBaseRepository<M4, Long> {

}
