package com.example.BCSD.service;

import com.example.BCSD.domain.User;

import java.util.List;

public interface UserService {
    User insertUser(User user);

    List<User> getAllUsers();

    User getUserByUserId(Integer id);

    void updateUser(String userid, User user);

    void deleteUser(Integer id);
}
