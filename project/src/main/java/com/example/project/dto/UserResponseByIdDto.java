package com.example.project.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseByIdDto {
    private long id;
    private String username;
}
