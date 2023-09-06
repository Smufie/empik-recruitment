package com.jolszewski.apicounter;

import jakarta.persistence.*;

/**
 * Entity representing amount of API calls.
 * We suppose that this entity is created only after successful API call occurred.
 */
@Entity(name = "user_login")
class APICallCounter {

    @Id
    @Column(name = "LOGIN", nullable = false)
    private String login;

    @Column(name = "REQUEST_COUNT")
    private int requestCount;

    /**
     * Default constructor which sets request count to 1.
     * It's not suggested to use this constructor because login should never be set to null.
     */
    public APICallCounter() {
        this.requestCount = 1;
    }

    /**
     * Suggested constructor, after successful API call.
     * @param login Login of user, which API was called for.
     */
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
