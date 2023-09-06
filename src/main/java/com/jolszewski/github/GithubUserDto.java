package com.jolszewski.github;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Representation of GitHub user data.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubUserDto {
    @JsonProperty("id")
    Long id;
    @JsonProperty("login")
    String login;
    @JsonProperty("name")
    String name;
    @JsonProperty("type")
    String type;
    @JsonProperty("avatar_url")
    String avatarUrl;
    @JsonProperty("created_at")
    String createdAt;

    @JsonProperty(value = "followers", access = JsonProperty.Access.WRITE_ONLY)
    int followerCount;

    @JsonProperty(value = "public_repos", access = JsonProperty.Access.WRITE_ONLY)
    int repositoryCount;

    @JsonProperty("calculations")
    double calculations;

}
