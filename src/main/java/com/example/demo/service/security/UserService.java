package com.example.demo.service.security;

import com.example.demo.model.security.SecurityUser;

public interface UserService {
    void save(SecurityUser user);

    SecurityUser findByLogin(String login);
}
