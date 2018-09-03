package com.example.demo.repository.base;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IBaseRepository<T, ID extends Serializable> extends CrudRepository<T, ID> {

}
