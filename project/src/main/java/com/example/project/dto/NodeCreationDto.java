package com.example.project.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class NodeCreationDto {
    private Long user_id;
    private String text;
}
