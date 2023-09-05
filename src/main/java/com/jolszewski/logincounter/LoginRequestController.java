package com.jolszewski.logincounter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class LoginRequestController {
    @Autowired
    LoginRequestRepository loginRequestRepository;

    public void incrementLoginCount(String login) {
        Optional<LoginRequest> userLogin = loginRequestRepository.findById(login);
        if (userLogin.isPresent()) {
            userLogin.get().incrementRequestCount();
            loginRequestRepository.save(userLogin.get());
        } else {
            LoginRequest newLoginRequest = new LoginRequest(login);
            loginRequestRepository.save(newLoginRequest);
        }
    }
}
