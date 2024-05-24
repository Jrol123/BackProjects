package com.example.project.controller;

import com.example.project.dto.*;
import com.example.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    private final ModelMapper modelMapper;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponseByIdDto getUserById(@PathVariable Long id) {
        return modelMapper.map(userService.getUserById(id), UserResponseByIdDto.class);
    }
}
