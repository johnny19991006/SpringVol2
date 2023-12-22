package com.example.homework_9.repository;

import com.example.homework_9.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Slf4j
public class UserRepository {
    static public ArrayList<UserDTO> users;

    static {
        users = new ArrayList<>();
        users.add(new UserDTO("1", "HeoJunki", "gjwnsrl1012"));
        users.add(new UserDTO("2", "Junki", "wnsrl1012"));
        users.add(new UserDTO("3", "ki", "rl1012"));
    }

    public UserDTO insertUser(UserDTO user) {
        users.add(user);
        return user;
    }

    public List<UserDTO> getAllUsers() {
        return users;
    }

    public UserDTO getUserByUserID(String userID) {
        return users.stream()
                .filter(userDTO -> userDTO.getUserID().equals(userID))
                .findAny()
                .orElse(new UserDTO("", "", ""));
    }

    public void updateUserPassword(String userID, UserDTO user) {
        users.stream()
                .filter(userDTO -> userDTO.getUserID().equals(userID))
                .findAny()
                .orElse(new UserDTO("", "", ""))
                .setPassword(user.getPassword());
    }

    public void deleteUser(String userID) {
        users.removeIf(userDTO -> userDTO.getUserID().equals(userID));
    }
}

