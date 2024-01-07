package com.example.SpringVol2.Service;

import com.example.SpringVol2.domain.DTO.JoinRequest;
import com.example.SpringVol2.domain.DTO.LoginRequest;
import com.example.SpringVol2.domain.User;
import com.example.SpringVol2.mapper.UserMapper;
import com.example.SpringVol2.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Transactional
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserMapper userMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
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

    // 이메일 중복 체크
    public boolean checkEmailDuplicate(String email) {
        return userRepository.existsByEmail(email);
    }

    // 회원가입
    public void join(JoinRequest req) {
        userRepository.save(req.toEntity());
    }

    // 로그인
    public User login(LoginRequest req) {
        Optional<User> optionalUser = userRepository.findByEmail(req.getLoginEmail());

        // 일치하는 유저가 없으면
        if(optionalUser.isEmpty()) {
            return null;
        }

        User user = optionalUser.get();

        // 찾아온 유저의 비밀번호가 입력된 비밀번호와 다르면
        if(!user.getPassword().equals(req.getPassword())) {
            return null;
        }

        return user;
    }

    // 이메일을 입력받아 User을 리턴해주는 기능
    public User getLoginUserByEmail(String email) {
        if(email == null) return null;

        Optional<User> optionalUser = userRepository.findByEmail(email);
        if(optionalUser.isEmpty()) return null;

        return optionalUser.get();
    }



}
