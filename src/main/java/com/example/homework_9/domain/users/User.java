package com.example.homework_9.domain.users;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
public class User {
    @Id //  pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private String userID;

    @Column
    private String name;

    @Column
    private String password;

    @Builder
    public User(String userID, String name, String password){
        this.userID =  userID;
        this.name = name;
        this.password = password;
    }

    public User() {
    }

    public String getUserID(){
        return userID;
    }

    public String getName(){
        return name;
    }

    public String getPassword(){
        return password;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
