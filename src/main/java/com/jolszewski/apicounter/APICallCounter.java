package com.jolszewski.apicounter;

import jakarta.persistence.*;

@Entity(name = "user_login")
class APICallCounter {

    @Id
    @Column(name = "LOGIN", nullable = false)
    private String login;

    @Column(name = "REQUEST_COUNT")
    private int requestCount;

    public APICallCounter() {
        this.requestCount = 1;
    }

    public APICallCounter(String login) {
        this.login = login;
        this.requestCount = 1;
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
        setRequestCount(getRequestCount() + 1);
    }
}
