package com.jolszewski.user;

import com.jolszewski.login.LoginController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    LoginController loginController;

    @GetMapping("/users/{login}")
    Object getUser(@PathVariable("login") String login) {
        try {
            UserDto user = userService.getUser(login);
            loginController.incrementLoginCount(login);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest();
        }
    }
}
