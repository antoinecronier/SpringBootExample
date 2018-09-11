package com.example.demo.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.security.SecurityRole;
import com.example.demo.model.security.SecurityUser;
import com.example.demo.repository.security.SecurityUserCrudRepository;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    private SecurityUserCrudRepository userRepository;

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
    	SecurityUser user = userRepository.findByLogin(login);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();

        if (user.getEnable()) {

            for (SecurityRole role : user.getRoles()){
                grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole()));
            }
		}
        
        String idForEncode = "bcrypt";
        Map<String,PasswordEncoder> encoders = new HashMap<String,PasswordEncoder>();
        encoders.put(idForEncode, new BCryptPasswordEncoder());
        encoders.put("pbkdf2", new Pbkdf2PasswordEncoder());
        encoders.put("scrypt", new SCryptPasswordEncoder());
        
        PasswordEncoder passwordEncoder =
        	    new DelegatingPasswordEncoder(idForEncode,encoders);
        
        UserBuilder userBuilder = org.springframework.security.core.userdetails.User.builder();
        userBuilder.username(user.getLogin());
        userBuilder.password(passwordEncoder.encode(user.getPassword()));
        userBuilder.authorities(grantedAuthorities);
        
        return userBuilder.build();
    }
}
