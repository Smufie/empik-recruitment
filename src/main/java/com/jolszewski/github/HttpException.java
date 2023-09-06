package com.jolszewski.github;

/**
 * Thrown when status code of {@link java.net.http.HttpResponse} is not 200.
 */
public class HttpException extends RuntimeException {

    /**
     * Default constructor, which handles exception message creation.
     * @param url address which caused exception
     * @param statusCode response status code
     */
    public HttpException(String url, int statusCode) {
        super("Could not obtain data for url: " + url + ", status code: " + statusCode);
    }
}
