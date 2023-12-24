package CRUD.bcsdbeginner.repository;

import CRUD.bcsdbeginner.DTO.UserDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    // db 연동 코드들
    static public ArrayList<UserDTO> users;

    static {
        users = new ArrayList<>();
        users.add(new UserDTO("황현식", "hwang", "1234"));
        users.add(new UserDTO("허준기", "HoHo", "4321"));
    }

    public UserDTO insertUser(UserDTO user){
        users.add(user);
        return user;
    }

    public List<UserDTO> getAllUsers(){
        return users;
    }

    public UserDTO getUserByUserId(String userId){
        return users.stream()
                .filter(userDomain -> userDomain.getUserId().equals(userId))
                .findAny()
                .orElse(new UserDTO("","",""));
    }

    public void updateUserPw(String userId, UserDTO user){
        users.stream()
                .filter(userDomain -> userDomain.getUserId().equals(userId))
                .findAny()
                .orElse(new UserDTO("","",""))
                .setUserPw(user.getUserPw());
    }

    public void deleteUser(String userId){
        users.removeIf(userDomain -> userDomain.getUserId().equals(userId));
    }
}
