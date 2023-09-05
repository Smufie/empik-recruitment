package com.jolszewski.github;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class GithubConnector {
    private static final String API_URL = "https://api.github.com/users/";

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public GithubUserDto sendLoginRequest(String login) throws Exception {
        String loginUrl = API_URL.concat(login);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(loginUrl))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() != 200) {
            throw new RuntimeException("Could not obtain data for url: " + loginUrl + ".");
        }
        return getUserDataFromResponse(response.body());
    }


    private GithubUserDto getUserDataFromResponse(String responseContent) throws IOException {
        return OBJECT_MAPPER.readValue(responseContent, GithubUserDto.class);
    }
}
