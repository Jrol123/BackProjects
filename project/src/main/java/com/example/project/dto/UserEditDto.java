package com.example.project.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.example.project.model.User}
 */
@Value
public class UserEditDto implements Serializable {
    Long id;
    String username;
    String password;
    String new_username;
    String new_password;
}