package com.example.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * DTO for {@link com.example.project.model.User}
 */
@Data
//@Accessors(chain = true)
public class AllUsersDto implements Serializable {
    String username;
}