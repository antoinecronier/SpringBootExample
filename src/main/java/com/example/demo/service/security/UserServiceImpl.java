package com.example.demo.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.security.SecurityRole;
import com.example.demo.model.security.SecurityUser;
import com.example.demo.repository.security.SecurityRoleCrudRepository;
import com.example.demo.repository.security.SecurityUserCrudRepository;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private SecurityUserCrudRepository userRepository;
    @Autowired
    private SecurityRoleCrudRepository roleRepository;

    public void save(SecurityUser user) {
        user.setPassword(user.getPassword());
        user.setRoles((Set<SecurityRole>)roleRepository.findAll());
        userRepository.save(user);
    }

    public SecurityUser findByLogin(String login) {
        return userRepository.findByLogin(login);
    }
}
