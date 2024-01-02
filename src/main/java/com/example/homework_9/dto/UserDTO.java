package com.example.homework_9.dto;
public class UserDTO {
    private String userID;
    private String name;
    private String password;

    public UserDTO(String userID, String name, String password) {
        this.userID = userID;
        this.name = name;
        this.password = password;
    }

    public String getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setUserID(String userID){
        this.userID = userID;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

