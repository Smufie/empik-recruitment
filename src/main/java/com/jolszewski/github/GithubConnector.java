package com.jolszewski.github;

import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

@Component
public class GithubConnector {
    private static final String API_URL = "https://api.github.com/users/";
    public static final int REQUEST_TIMEOUT = 10;

    private final HttpClient httpClient;

    public GithubConnector() {
        this.httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(REQUEST_TIMEOUT))
                .build();
    }

    public GithubUserDto getGithubUserData(String login) throws Exception {
        String loginUrl = API_URL.concat(login);
        HttpRequest request = createRequest(loginUrl);
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() != 200) {
            throw new HttpException(loginUrl, response.statusCode());
        }
        return GithubUserConverter.deserializeUserFromJson(response.body());
    }

    private HttpRequest createRequest(String url) throws URISyntaxException {
        return HttpRequest.newBuilder()
                .uri(new URI(url))
                .GET()
                .build();
    }
}
