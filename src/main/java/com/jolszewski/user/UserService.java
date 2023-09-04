package com.jolszewski.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
class UserService {

    private static final String API_URL = "https://api.github.com/users/";

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public UserDto getUser(String login) throws Exception {
        String responseContent = sendLoginRequest(login);
        return getUserDataFromResponse(responseContent);
    }

    private UserDto getUserDataFromResponse(String responseContent) throws IOException {
        UserDto user = OBJECT_MAPPER.readValue(responseContent, UserDto.class);
//        TODO Can I calculate during construction?
        user.setCalculations(calculate(user.getRepositoryCount(), user.getFollowerCount()));
        return user;
    }

    private String sendLoginRequest(String login) throws Exception {
        String loginUrl = API_URL.concat(login);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(loginUrl))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() != 200) {
//            TODO More specific exception
            throw new Exception("Bad request.");
        }
        return response.body();
    }

    private static double calculate(int repositoryCount, int followerCount) {
        return  (double) 6 / followerCount * (2 + repositoryCount);
    }
}
