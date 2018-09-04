package com.example.demo.repository.security;

import org.springframework.stereotype.Repository;

import com.example.demo.model.security.SecurityRole;
import com.example.demo.repository.base.IBaseRepository;

@Repository
public interface SecurityRoleCrudRepository extends  IBaseRepository<SecurityRole, Long> {

}
