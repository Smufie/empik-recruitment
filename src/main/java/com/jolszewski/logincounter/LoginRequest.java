package com.jolszewski.logincounter;

import jakarta.persistence.*;

@Entity(name = "user_login")
class LoginRequest {

    @Id
    @Column(name = "LOGIN", nullable = false)
    private String login;

    @Column(name = "REQUEST_COUNT")
    private int requestCount;

    public LoginRequest() {
        this.requestCount = 0;
    }

    public LoginRequest(String login) {
        this.login = login;
        this.requestCount = 0;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getRequestCount() {
        return requestCount;
    }

    public void setRequestCount(int requestCount) {
        this.requestCount = requestCount;
    }

    public void incrementRequestCount() {
        this.requestCount++;
    }
}
