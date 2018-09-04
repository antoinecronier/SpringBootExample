package com.example.demo.repository.security;

import org.springframework.stereotype.Repository;

import com.example.demo.model.security.SecurityUser;
import com.example.demo.repository.base.IBaseRepository;

@Repository
public interface SecurityUserCrudRepository extends IBaseRepository<SecurityUser, Long> {
	SecurityUser findByLogin(String login);
}
