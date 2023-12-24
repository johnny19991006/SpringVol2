package bcsd.BoardAPI.service;

import bcsd.BoardAPI.repository.UserRepository;
import bcsd.BoardAPI.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    // 모든 유저 검색
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    // 유저 아이디 검색
    public User getUserByUserId(String userId) {
        return userRepository.findById(userId);
    }

    // 유저 등록
    public User registerUser(User user) {
        return userRepository.createUser(user);
    }

    // 유저 수정
    public void modifyUser(String userId, User user) {
        userRepository.updateUsername(userId, user);
    }

    // 유저 삭제
    public void removeUser(String userId) {
        userRepository.deleteUser(userId);
    }
}