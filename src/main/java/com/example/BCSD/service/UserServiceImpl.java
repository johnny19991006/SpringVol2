package com.example.BCSD.service;

import com.example.BCSD.domain.User;
import com.example.BCSD.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User insertUser(User user) {
        userRepository.save(User.builder()
                .userId(user.getUserId())
                .userName(user.getUserName())
                .userPw(user.getUserPw())
                .build());
        return user;

    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByUserId(Integer id) {
        return userRepository.findById(id).orElse(new User(null, null, null));
    }

    @Override
    public void updateUser(String userid, User user) {
        userRepository.save(User.builder()
                .userId(user.getUserId())
                .userName(user.getUserName())
                .userPw(user.getUserPw())
                .build());
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);

    }

}
