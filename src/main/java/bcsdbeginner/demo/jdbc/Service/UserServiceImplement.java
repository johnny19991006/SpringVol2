package bcsdbeginner.demo.jdbc.Service;

import bcsdbeginner.demo.jdbc.Domain.User;
import bcsdbeginner.demo.jdbc.Domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplement implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImplement(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        userRepository.save(User.builder().userId(user.getUserId())
                .userName(user.getUserName()).userPw(user.getUserPw())
                .build());
        return user;
    }
    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }
    @Override
    public User findById(String userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public User updateUserName(String userId, String userName) {
        User user = userRepository.findById(userId).orElse(null);
        userRepository.save(User.builder().userName(user.getUserName()).build());

        return user;
    }

    @Override
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}
