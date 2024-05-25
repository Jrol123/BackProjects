package com.example.project.controller;

import com.example.project.dto.*;
import com.example.project.model.User;
import com.example.project.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    private final ModelMapper modelMapper;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponseByIdDto getUserById(@PathVariable Long id) {
        var user = userService.getUserById(id);
        var userDto = modelMapper.map(user, UserResponseByIdDto.class);
        return userDto;
    }

    //TODO: Переделать под Body
    @GetMapping("/0-{username}")
    @ResponseStatus(HttpStatus.OK)
    public List<UserResponseByIdDto> getUsersByUsername(@PathVariable String username){
        var users = userService.getAllByName(username);
        List<UserResponseByIdDto> usersDto = new ArrayList<>();
         users.forEach((user) -> usersDto.add(modelMapper.map(user, UserResponseByIdDto.class)));
//        var usersDto = modelMapper.map(users, UsersResponseByUsernameDto.class);
        return usersDto;
    }

    @PostMapping("/create_user")
    @ResponseStatus(HttpStatus.CREATED)
    public UserCreationResponseDto createUser(@RequestBody UserCreationDto creationDto) {
        User user = modelMapper.map(creationDto, User.class);
        userService.createUser(user);

        var userId = user.getId();
        var userCreationResponseDto = new UserCreationResponseDto().setId(userId);
        return userCreationResponseDto;
    }
}
