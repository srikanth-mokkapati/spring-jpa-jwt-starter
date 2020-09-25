package com.starter.app.dto;

import lombok.Data;

@Data
public class LoginResponse {

    private String username;
    private String bearerToken;
}
