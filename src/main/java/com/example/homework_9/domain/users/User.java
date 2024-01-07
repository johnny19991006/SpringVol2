package com.example.homework_9.domain.users;

import com.example.homework_9.UserRole;
import jakarta.persistence.*;
import lombok.Builder;

@Entity
@Builder
@Table(name = "users")
public class User {
    @Id //  pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    @Column(name = "userid")
    private String userid;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    private UserRole role;

    @Builder
    public User(String userid, String name, String password, UserRole role) {
        this.userid = userid;
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public User() {
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

    public UserRole getRole() {
        return role;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
