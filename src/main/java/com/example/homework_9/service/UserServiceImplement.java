package com.example.homework_9.service;

import com.example.homework_9.domain.users.User;
import com.example.homework_9.domain.users.UserRepositoryJPA;
import com.example.homework_9.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserServiceImplement {

    @Autowired  // 서비스와 레포지토리간의 의존성 설정 --> 계층끼리만 통신을 위함
    UserRepositoryJPA userRepositoryJPA;

    public User insertUser(UserDTO user) {
        return userRepositoryJPA.save(User.builder()
                .userID(user.getUserID())
                .name(user.getName())
                .password(user.getPassword())
                .build());
    }

    public List<User> getAllUsers() {
        return userRepositoryJPA.findAll();
    }

    public User getUserByUserID(String userID) {
        return userRepositoryJPA.findById(userID).orElse(null);
    }

    public User updateUserPassword(String userID, String password) {
        User user = userRepositoryJPA.findById(userID).orElse(null);
        userRepositoryJPA.save(User.builder()
                .password(password)
                .build());

        return user;
    }

    public void deleteUser(String userID) {
        userRepositoryJPA.delete(User.builder().userID(userID).build());
    }
}
