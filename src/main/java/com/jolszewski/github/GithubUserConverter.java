package com.jolszewski.github;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

class GithubUserConverter {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static GithubUserDto deserializeUserFromJson(String json) throws IOException {
        return OBJECT_MAPPER.readValue(json, GithubUserDto.class);
    }
}
