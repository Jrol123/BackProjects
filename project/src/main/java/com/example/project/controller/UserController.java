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

    @GetMapping("/get_users")
    @ResponseStatus(HttpStatus.OK)
    public List<UserResponseByIdDto> getUsersByUsername(@RequestBody UserNameDto allUsersDto){
        var username = allUsersDto.getUsername();
        var users = userService.getAllByName(username);
//        var usersDto = users.forEach((user) -> modelMapper.map(user, UserResponseByIdDto.class));
        List<UserResponseByIdDto> usersDto = new ArrayList<>();
        users.forEach((user) -> usersDto.add(modelMapper.map(user, UserResponseByIdDto.class)));
        return usersDto;
    }

    @PostMapping("/create_user")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseDto createUser(@RequestBody BasicCredentialsUserDto creationDto) {
        User user = modelMapper.map(creationDto, User.class);
        userService.createUser(user);

//        var userId = user.getId();
//        var userCreationResponseDto = new UserIdDto().setId(userId);

        ResponseDto response = new ResponseDto("Успех!");

        return response;
    }

    // TODO: Летит из-за отсутствия каскадного удаления
    @DeleteMapping("/delete_user")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDto deleteUser(@RequestBody ExtendedCredentialsUserDto deletionDto) {
        User user = userService.getUserById(deletionDto.getId());
        userService.checkUserCredentials(user, deletionDto.getUsername(), deletionDto.getPassword());
        ResponseDto response = new ResponseDto("Успех!");
//        var response = modelMapper.map("Успех!", ResponseDto.class);
        userService.removeUser(user);
        return response;
    }

    @PatchMapping("/update_user")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDto updateUser(@RequestBody UserEditDto updateDto){
        User user = userService.getUserById(updateDto.getId());
        userService.checkUserCredentials(user, updateDto.getUsername(), updateDto.getPassword());
        userService.updateUserCredentials(user, updateDto);

        ResponseDto response = new ResponseDto("Успех!");
        return response;
    }
}
