package com.example.project.dto;

import lombok.Value;

import java.io.Serializable;

@Value
public class ExtendedCredentialsUserDto implements Serializable {
    long id;
    String username;
    String password;
}
