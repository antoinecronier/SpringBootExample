package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.model.M2;
import com.example.demo.repository.base.IBaseRepository;

@Repository
public interface M2CrudRepository extends IBaseRepository<M2, Long> {

}
