package com.example.project.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * DTO for {@link com.example.project.model.User}
 */
@Data
//@Accessors(chain = true)
public class UserNameDto implements Serializable {
    private String username;
}