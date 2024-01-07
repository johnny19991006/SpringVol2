package com.example.homework_9.dto;

public class UserDTO {
    private String userid;
    private String name;
    private String password;

    public UserDTO(String userid, String name, String password) {
        this.userid = userid;
        this.name = name;
        this.password = password;
    }

    public String getUserID() {
        return userid;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setUserID(String userid) {
        this.userid = userid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

