package com.jolszewski.user;

import com.jolszewski.apicounter.APICallCounterService;
import com.jolszewski.github.GithubConnector;
import com.jolszewski.github.GithubUserDto;
import com.jolszewski.calculation.CalculationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class UserService {

    @Autowired
    GithubConnector githubConnector;

    @Autowired
    APICallCounterService apiCallCounterService;

    public GithubUserDto getUser(String login) throws Exception {
        GithubUserDto githubUser = githubConnector.getGithubUserData(login);
        CalculationData calculationData = new CalculationData(githubUser.getFollowerCount(), githubUser.getRepositoryCount());
        githubUser.setCalculations(calculationData.getResult());
        apiCallCounterService.callOccurred(login);
        return githubUser;
    }
}
