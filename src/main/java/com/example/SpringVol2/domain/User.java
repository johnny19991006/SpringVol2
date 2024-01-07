package com.example.SpringVol2.domain;

import lombok.Data;

@Data
public class User {
    private Integer userId;

    private String email;

    private String password;

    private UserRole role;
}