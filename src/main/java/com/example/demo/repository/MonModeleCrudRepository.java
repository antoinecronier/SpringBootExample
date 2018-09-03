package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.model.MonModele;
import com.example.demo.repository.base.IBaseRepository;

@Repository
public interface MonModeleCrudRepository extends IBaseRepository<MonModele, Long> {

}
