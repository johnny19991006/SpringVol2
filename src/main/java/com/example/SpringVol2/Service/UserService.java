package com.example.SpringVol2.Service;

import com.example.SpringVol2.domain.User;
import com.example.SpringVol2.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class UserService implements  UserServiceIF{
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public List<User> findUsers() {
        return userRepository.findUsers();
    }

    @Transactional
    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Transactional
    @Override
    public User createUser(User user) {
        return userRepository.createUser(user);
    }

    @Transactional
    @Override
    public User updateUser(String email, User user) {
        return userRepository.updateUser(email, user);
    }

    @Transactional
    @Override
    public int deleteUser(User user) {
        return userRepository.deleteUser(user);
    }

}
