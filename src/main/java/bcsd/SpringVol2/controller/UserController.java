package bcsd.SpringVol2.controller;

import bcsd.SpringVol2.dto.UserDTO;
import bcsd.SpringVol2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("")
    public UserDTO createUser(@RequestBody UserDTO user) throws SQLException {
        return userService.createUser(user);
    }

    @GetMapping("")
    public List<UserDTO> findAllUsers() throws SQLException{
        return userService.findAllUsers();
    }

    @GetMapping("/{userId}")
    public UserDTO findByUserId(@PathVariable(name = "userId") String userId) throws SQLException{
        return userService.findByUserId(userId);
    }

    @PutMapping("/{userId}")
    public void updateUsername(@PathVariable(name = "userId") String userId, @RequestBody UserDTO user) throws SQLException{
        userService.updateUserInfo(userId, user);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable(name = "userId") String userId) throws SQLException{
        userService.deleteUser(userId);
    }
}
