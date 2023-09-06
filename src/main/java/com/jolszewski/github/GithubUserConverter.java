package com.jolszewski.github;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Responsible for deserializing {@link GithubUserDto} from json string.
 */
class GithubUserConverter {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     * Deserializes {@link GithubUserDto} from json string.
     * @param json String containing json data.
     * @return Deserialized {@link GithubUserDto}.
     * @throws IOException if deserialization could not be finished
     */
    public static GithubUserDto deserializeUserFromJson(String json) throws IOException {
        return OBJECT_MAPPER.readValue(json, GithubUserDto.class);
    }
}
