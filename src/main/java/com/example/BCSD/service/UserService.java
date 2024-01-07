package com.example.BCSD.service;

import com.example.BCSD.domain.User;
import com.example.BCSD.domain.dto.LoginRequest;
import com.example.BCSD.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    /**
     * loginId 중복 체크
     * 회원가입 기능 구현 시 사용
     * 중복되면 true return
     */
    public User insertUser(User user) {
        userRepository.save(User.builder()
                .loginId(user.getLoginId())
                .userName(user.getUserName())
                .userPw(encoder.encode(user.getUserPw()))
                .build());
        return user;

    }

    public User login(LoginRequest req) {
        Optional<User> optionalUser = userRepository.findByLoginId(req.getLoginId());
        System.out.println(optionalUser.get().getId());
        System.out.println(optionalUser.get().getLoginId());
        System.out.println(optionalUser.get().getUserName());
        System.out.println(optionalUser.get().getUserPw());
        System.out.println(req.getPassword());

        if(optionalUser.isEmpty()) {
            return null;
        }

        User user = optionalUser.get();

        if (!encoder.matches(req.getPassword(), user.getUserPw())) {
            return null;
        }

        return user;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getLoginUserById(Integer id) {
        if(id == null) return null;

        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElse(null);

    }

    public User getLoginUserByLoginId(String loginId) {
        if (loginId == null) return null;

        Optional<User> optionalUser = userRepository.findByLoginId(loginId);
        return optionalUser.orElse(null);
    }
    public User getUserByUserId(Integer id) {
        return userRepository.findById(id).orElse(new User(null, null, null));
    }

    public void updateUser(String loginId, User user) {
        userRepository.save(User.builder()
                .loginId(loginId)
                .userName(user.getUserName())
                .userPw(user.getUserPw())
                .build());
    }


    public void deleteUser(Integer id) {
        userRepository.deleteById(id);

    }

}
