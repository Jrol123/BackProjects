package com.example.project.service;

import com.example.project.dto.UserEditDto;
import com.example.project.exception.*;
import com.example.project.model.User;
import com.example.project.repository.UserRepository;
import org.springframework.stereotype.Service;
import lombok.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    public void createUser(User user) {
        if (user.getPassword().isEmpty() || user.getUsername().isEmpty()){
            throw new EmptyFieldException("Не все поля заполнены!");
        }
        userRepository.save(user);
    }

    public void removeUser(User user) {
        userRepository.delete(user);
    }

    public User getUserById(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Пользователь с указанным id не найден"));
    }

    public List<User> getAllByName(String username){
        var users =  userRepository.findAllByUsername(username);
        if (users.isEmpty()) {
            throw new NotFoundException("Пользователи с указанным именем не найдены");
        }
        return users;
    }

    public void checkUserCredentials(User user, String username, String password) {
        if (!user.getPassword().equals(password) || !user.getUsername().equals(username)){
            throw new WrongDataException("Неправильный логин и/или пароль!");
        }
    }

    public void updateUserCredentials(User user, UserEditDto updateDto) {
        if (!updateDto.getNew_password().isEmpty()){
            user.setPassword(updateDto.getNew_password());
        }
        if (!updateDto.getNew_username().isEmpty()){
            user.setUsername(updateDto.getNew_username());
        }
        userRepository.save(user);
    }
}
