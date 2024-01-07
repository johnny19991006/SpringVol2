package bcsd.SpringVol2.controller;

import bcsd.SpringVol2.auth.JwtUtils;
import bcsd.SpringVol2.domain.dto.LoginRequest;
import bcsd.SpringVol2.domain.entity.User;
import bcsd.SpringVol2.service.UserService;
import bcsd.SpringVol2.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final JwtUtils jwtUtils;

    @PostMapping
    public void insertUser(@RequestBody User user){
        userService.insertUser(user);
    }

    @GetMapping("")
    public List<User> findAllUsers(){
        return userService.findAllUsers();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable(name = "id") Long id){
        return userService.findById(id);
    }

    @GetMapping("/name/{username}")
    public User findByUserName(@PathVariable(name = "username") String username){
        return userService.findByName(username);
    }

    @GetMapping("/id/{userid}")
    public User findByUserId(@PathVariable(name = "userid") String userid){
        return userService.findByUserId(userid);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUserName(@PathVariable(name = "id") Long id,
                               @RequestHeader(name = "token") String token,
                               @RequestBody User user){
        try {
            if (jwtUtils.isValidToken(token)) {
                userService.updateUserInfo(id, user);
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                throw new IllegalArgumentException();
            }
        } catch (Exception e){
            log.error("update user token error id : {}", id);
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable(name = "id") Long id, @RequestHeader("token") String token){
        try {
            if (jwtUtils.isValidToken(token)) {
                userService.deleteUser(id);
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                throw new IllegalArgumentException();
            }
        } catch (Exception e){
            log.error("delete user token error id : {}", id);
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

    }

    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody LoginRequest loginRequest){
        User user = userService.login(loginRequest);

        HttpHeaders headers = new HttpHeaders();

        if(user!=null){
            String token = jwtUtils.createToken(user.getUserid(),2*1000*60);
            headers.set("token", token);
            return new ResponseEntity<>(headers, HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}
