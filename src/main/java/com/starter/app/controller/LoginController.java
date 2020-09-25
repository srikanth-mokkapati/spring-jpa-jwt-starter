package com.starter.app.controller;

import com.starter.app.config.securityutil.JWTTokenUtil;
import com.starter.app.db.models.User;
import com.starter.app.db.models.UserContext;
import com.starter.app.dto.JWTRequest;
import com.starter.app.dto.LoginResponse;
import com.starter.app.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class LoginController{

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTTokenUtil jwtTokenUtil;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JWTRequest authenticationRequest) throws Exception {
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        final String token = jwtTokenUtil.generateToken(authenticationRequest.getUsername());
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setUsername(authenticationRequest.getUsername());
        loginResponse.setBearerToken(token);
        return ResponseEntity.ok(loginResponse);
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    @GetMapping(value = "/getUsers")
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userDetailsService.getUsers());
    }

}