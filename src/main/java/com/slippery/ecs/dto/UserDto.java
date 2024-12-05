package com.slippery.ecs.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.slippery.ecs.models.User;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class UserDto {
    private String message;
    private String errorMessage;
    private int statusCode;
    private User user;
    private List<User> users;
    private String username;
    private String userEmail;
    private String userPassword;
    private String role;
}
