package com.jolszewski.user;

import com.jolszewski.github.GithubUserDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Class containing entry points to user functionalities.
 */
@RestController
public class UserController {

    private static final Logger logger = LogManager.getLogger(UserController.class);

    @Autowired
    UserService userService;

    /**
     * Endpoint which tries to obtain GitHub user data.
     * @param login valid GitHub login.
     * @return User data in JSON format. If any problem happens, it returns 400 code.
     */
    @GetMapping("/users/{login}")
    Object getUser(@PathVariable("login") String login) {
        try {
            GithubUserDto user = userService.getUser(login);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            logger.error("Could not obtain user.", e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
