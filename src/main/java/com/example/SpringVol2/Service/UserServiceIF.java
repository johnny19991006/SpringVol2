package com.example.SpringVol2.Service;

import com.example.SpringVol2.domain.User;

import java.util.List;

public interface UserServiceIF {

    List<User> findUsers();

    User findUserByEmail(String email);

    User createUser(User user);

    User updateUser(String email, User user);

    int deleteUser(User user);
}
