package CRUD.bcsdbeginner.service;

import CRUD.bcsdbeginner.domain.UserDomain;
import CRUD.bcsdbeginner.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public UserDomain insertUser(UserDomain user){
        return userRepository.insertUser(user);
    }

    public List<UserDomain> getAllUsers(){
        return userRepository.getAllUsers();
    }
    public UserDomain getUserByUserId(String userId){
        return userRepository.getUserByUserId(userId);
    }

    public void updateUserPw(String userId, UserDomain user){
        userRepository.updateUserPw(userId, user);
    }
    public void deleteUser(String userId){
        userRepository.deleteUser(userId);
    }
}
