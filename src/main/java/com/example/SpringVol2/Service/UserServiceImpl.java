package com.example.SpringVol2.Service;

import com.example.SpringVol2.domain.User;
import com.example.SpringVol2.mapper.UserMapper;
import com.example.SpringVol2.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<User> findUsers() {
        return userMapper.findUsers();
    }

    @Override
    public User findUserByEmail(String email) {
        return userMapper.findUserByEmail(email);
    }

    @Override
    public User createUser(User user) {
        userMapper.createUser(user);
        return user;
    }

    @Override
    public User updateUser(String email, User user) {
        userMapper.updateUser(user);
        return user;
    }

    @Override
    public int deleteUser(User user) {
        return userMapper.deleteUser(user.getEmail());
    }

}
