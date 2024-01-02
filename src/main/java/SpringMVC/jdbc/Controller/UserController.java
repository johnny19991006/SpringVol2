package SpringMVC.jdbc.Controller;

import SpringMVC.jdbc.Domain.User;
import SpringMVC.jdbc.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

// CRUD C -> POST, R -> GET, U -> PUT, D -> DELETE

@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("")
    public User createUser(@RequestBody User user) throws SQLException
    {
        return userService.createUser(user);
    }

    @GetMapping("")
    public List<User> findAllUser() throws SQLException
    {
        return userService.findAllUser();
    }

    @GetMapping("/{userId}")
    public User findById(@PathVariable String userId) throws SQLException
    {
        return userService.findById(userId);
    }

    @PutMapping("/{userId}")
    public void updateUsername(@PathVariable String userId, @RequestBody User user) throws SQLException
    {
        userService.updateUsername(userId, user);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable String userId) throws SQLException
    {
        userService.deleteUser(userId);
    }
}
