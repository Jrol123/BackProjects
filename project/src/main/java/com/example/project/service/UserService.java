package com.example.project.service;

import com.example.project.exception.UserNotFoundException;
import com.example.project.model.User;
import com.example.project.repository.UserRepository;
import org.springframework.stereotype.Service;
import lombok.*;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    public void createUser(User user) {
        userRepository.save(user);
    }

    public User getUserById(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Пользователь с указанным id не найден"));
    }
}
