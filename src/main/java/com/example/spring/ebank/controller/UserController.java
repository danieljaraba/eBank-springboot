package com.example.spring.ebank.controller;

import com.example.spring.ebank.api.UserAPI;
import com.example.spring.ebank.dto.request.UserRequestDTO;
import com.example.spring.ebank.dto.response.UserResponseDTO;
import com.example.spring.ebank.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController implements UserAPI {

    private final UserService userService;

    @Override
    public UserResponseDTO createUser(UserRequestDTO userRequest) {
        return userService.createUser(userRequest);
    }

    @Override
    public List<UserResponseDTO> getAll() {
        return userService.getAll();
    }
}
