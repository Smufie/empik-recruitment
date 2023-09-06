package com.jolszewski.github;

public class HttpException extends RuntimeException {

    public HttpException(String url, int statusCode) {
        super("Could not obtain data for url: " + url + ", status code: " + statusCode);
    }
}
