package com.jolszewski.user;

import com.jolszewski.apicounter.APICallCounterService;
import com.jolszewski.github.GithubConnector;
import com.jolszewski.github.GithubUserDto;
import com.jolszewski.calculation.CalculationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Logical operations for user domain.
 */
@Service
class UserService {

    @Autowired
    GithubConnector githubConnector;

    @Autowired
    APICallCounterService apiCallCounterService;

    /**
     * Tries to obtain GitHub user data.
     * @param login valid GitHub login
     * @return GitHub user data
     * @throws Exception when something goes wrong during process
     */
    public GithubUserDto getUser(String login) throws Exception {
        GithubUserDto githubUser = githubConnector.getGithubUserData(login);
        CalculationData calculationData = new CalculationData(githubUser.getFollowerCount(), githubUser.getRepositoryCount());
        githubUser.setCalculations(calculationData.getResult());
        apiCallCounterService.callOccurred(login);
        return githubUser;
    }
}
