package com.starter.app.service.impl;

import com.starter.app.db.models.User;
import com.starter.app.db.models.UserContext;
import com.starter.app.db.repository.UserRepository;
import com.starter.app.service.MyUserDetailsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements MyUserDetailsService {

    private static final Logger logger = LogManager.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findOneByUsername(username);
        if (user.isPresent()) {
            UserContext userContext = new UserContext(user.get());
            return userContext;
        }
        return null;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
