package com.starter.app.service;

import com.starter.app.db.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface MyUserDetailsService extends UserDetailsService {

    List<User> getUsers();

}
