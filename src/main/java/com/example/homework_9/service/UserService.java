package com.example.homework_9.service;

import com.example.homework_9.domain.users.User;
import com.example.homework_9.dto.JoinRequest;
import com.example.homework_9.dto.LoginRequest;
import com.example.homework_9.repository.UserRepositoryLogin;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepositoryLogin userRepositoryLogin;
    private final BCryptPasswordEncoder encoder;

    /*
        userId 중복 체크
        회원가입 기능 구현 시 사용
        중복되면 true
     */
    public boolean checkUserIdDuplicate(String userid) {
        return userRepositoryLogin.existsByUserid(userid);
    }

    /*
        name 중복 체크
        회원가입 기능 구현 시 사용
        중복되면 true
     */
    public boolean checkNameDuplicate(String name) {
        return userRepositoryLogin.existsByName(name);
    }

    public void join(JoinRequest request) {
        userRepositoryLogin.save(request.toEntity(encoder.encode(request.getPassword())));
    }

    /*
        로그인
        화면에서 LoginRequest(LoginId, password)을 입력받아 일치하면 User return

     */
    public User login(LoginRequest request) {
        Optional<User> optionalUser = userRepositoryLogin.findByUserid(request.getUserId());

        if (optionalUser.isEmpty()) {
            return null;
        }

        User user = optionalUser.get();

        if (!user.getPassword().equals(request.getPassword())) {
            return null;
        }

        return user;
    }

    public User getLoginUserById(String userid) {
        if (userid == null) {
            return null;
        }

        Optional<User> optionalUser = userRepositoryLogin.findByUserid(userid);
        if (optionalUser.isEmpty()) {
            return null;
        }

        return optionalUser.get();
    }

}
