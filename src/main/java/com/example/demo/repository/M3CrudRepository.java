package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.model.M3;
import com.example.demo.repository.base.IBaseRepository;

@Repository
public interface M3CrudRepository extends IBaseRepository<M3, Long> {

}