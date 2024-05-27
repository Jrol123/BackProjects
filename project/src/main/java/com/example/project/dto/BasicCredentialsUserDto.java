package com.example.project.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.example.project.model.User}
 */
@Value
public class BasicCredentialsUserDto implements Serializable {
    String username;
    String password;
}