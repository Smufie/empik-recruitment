package com.jolszewski.github;

import com.jolszewski.TestConst;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GithubConnectorUnitTest {
    GithubConnector githubConnector = new GithubConnector();

    @Test
    void shouldReturnUserData() throws Exception {
        GithubUserDto githubUser = githubConnector.getGithubUserData(TestConst.EXISTING_USER_LOGIN);
        assertNotNull(githubUser);
        assertEquals(TestConst.EXISTING_USER_LOGIN, githubUser.getLogin());
    }

    @Test
    void shouldThrowHttpException() {
        assertThrows(HttpException.class, () -> githubConnector.getGithubUserData(TestConst.NOT_EXISTING_USER_LOGIN));
    }
}
