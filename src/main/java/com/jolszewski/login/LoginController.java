package com.jolszewski.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class LoginController {
    @Autowired
    LoginRepository loginRepository;

    public void incrementLoginCount(String login) {
        Optional<UserLogin> userLogin = loginRepository.findByLogin(login);
        if (userLogin.isPresent()) {
            userLogin.get().incrementRequestCount();
            loginRepository.save(userLogin.get());
        } else {
            UserLogin newUserLogin = new UserLogin(login);
            loginRepository.save(newUserLogin);
        }
    }
}
