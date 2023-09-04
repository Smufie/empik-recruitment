package com.jolszewski.login;

import jakarta.persistence.*;

@Entity(name = "user_login")
class UserLogin {

    @Id
    @Column(name = "LOGIN", nullable = false)
    private String login;

    @Column(name = "REQUEST_COUNT")
    private int requestCount;

    public UserLogin() {}

    public UserLogin(String login) {
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
