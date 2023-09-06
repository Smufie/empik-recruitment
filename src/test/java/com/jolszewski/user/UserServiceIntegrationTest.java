package com.jolszewski.user;

import com.jolszewski.TestConst;
import com.jolszewski.github.GithubUserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class UserServiceIntegrationTest {

    @Autowired
    UserService userService;

    @Test
    void shouldReturnUserData() throws Exception {
        GithubUserDto githubUser = userService.getUser(TestConst.EXISTING_USER_LOGIN);
        assertNotNull(githubUser);
    }

    @Test
    void shouldThrowException() {
        assertThrows(Exception.class, () -> userService.getUser(TestConst.NOT_EXISTING_USER_LOGIN));
    }

}
