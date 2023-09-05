package com.jolszewski.user;

import com.jolszewski.github.GithubConnector;
import com.jolszewski.github.GithubUserDto;
import com.jolszewski.logincounter.LoginRequestController;
import com.jolszewski.util.Calculations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class UserService {

    @Autowired
    GithubConnector githubConnector;

    @Autowired
    LoginRequestController loginRequestController;

    public GithubUserDto getUser(String login) throws Exception {
        GithubUserDto githubUser = githubConnector.sendLoginRequest(login);
        githubUser.setCalculations(Calculations.calculate(githubUser.getRepositoryCount(), githubUser.getFollowerCount()));
        loginRequestController.incrementLoginCount(login);
        return githubUser;
    }
}
