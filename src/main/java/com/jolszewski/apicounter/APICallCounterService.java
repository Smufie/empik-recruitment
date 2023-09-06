package com.jolszewski.apicounter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service responsible for registering API calls for specified login.
 */
@Service
public class APICallCounterService {

    @Autowired
    private APICallCounterRepository apiCallCounterRepository;

    /**
     * This method must be called, when API call occurred.
     * @param login Login of user, which API was called for.
     */
    public void callOccurred(String login) {
        Optional<APICallCounter> optionalLoginRequest = apiCallCounterRepository.findById(login);
        optionalLoginRequest.ifPresentOrElse(apiCallCounter -> {
            apiCallCounter.incrementRequestCount();
            apiCallCounterRepository.save(apiCallCounter);
        }, () -> {
            APICallCounter newAPICallCounter = new APICallCounter(login);
            apiCallCounterRepository.save(newAPICallCounter);
        });
    }
}
