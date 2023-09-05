package com.jolszewski.user;

import com.jolszewski.github.GithubUserDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class UserController {

    private static final Logger logger = LogManager.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @GetMapping("/users/{login}")
    Object getUser(@PathVariable("login") String login) {
        try {
            GithubUserDto user = userService.getUser(login);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            logger.error("Could not obtain user because of: " + e.getMessage());
            return ResponseEntity.badRequest();
        }
    }
}
