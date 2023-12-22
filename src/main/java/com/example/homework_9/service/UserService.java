package com.example.homework_9.service;

import com.example.homework_9.dto.UserDTO;
import com.example.homework_9.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired  // 서비스와 레포지토리간의 의존성 설정 --> 계층끼리만 통신을 위함
    UserRepository userRepository;

    public UserDTO insertUser(UserDTO user) {
        return userRepository.insertUser(user);
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public UserDTO getUserByUserID(String userID) {
        return userRepository.getUserByUserID(userID);
    }

    public void updateUserPassword(String userID, UserDTO user) {
        userRepository.updateUserPassword(userID, user);
    }

    public void deleteUser(String userID) {
        userRepository.deleteUser(userID);
    }
}
