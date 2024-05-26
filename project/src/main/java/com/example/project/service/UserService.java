package com.example.project.service;

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
        userRepository.save(user);
    }

    public void removeUser(User user) {
        userRepository.delete(user);
    }

    public User getUserById(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Пользователь с указанным id не найден"));
    }

    public List<User> getAllByName(String username){
        var users =  userRepository.findAllByUsername(username);
        if (users.isEmpty()) {
            throw new UserNotFoundException("Пользователи с указанным именем не найдены");
        }
        return users;
    }
}
