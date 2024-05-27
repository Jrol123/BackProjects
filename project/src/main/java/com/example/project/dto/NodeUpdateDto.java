package com.example.project.dto;

import lombok.Data;

@Data
public class NodeUpdateDto {
    private Long user_id;
    String username;
    String password;
    private Long id;
    private String name;
    private String text;
}
