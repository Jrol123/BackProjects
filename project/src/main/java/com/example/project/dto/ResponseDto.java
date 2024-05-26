package com.example.project.dto;

import lombok.*;
import lombok.experimental.Accessors;

@Data
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {
    private String message;
}