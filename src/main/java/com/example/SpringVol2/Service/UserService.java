package com.example.SpringVol2.Service;

import com.example.SpringVol2.domain.DTO.JoinRequest;
import com.example.SpringVol2.domain.DTO.LoginRequest;
import com.example.SpringVol2.domain.User;

import java.util.List;

public interface UserService {

    List<User> findUsers();

    User findUserByEmail(String email);

    User createUser(User user);

    User updateUser(String email, User user);

    int deleteUser(User user);

    public boolean checkEmailDuplicate(String email);

    public void join(JoinRequest req);

    public User login(LoginRequest req);

    public User getLoginUserByEmail(String email);
}
