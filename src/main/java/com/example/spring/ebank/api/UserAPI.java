package com.example.spring.ebank.api;

import com.example.spring.ebank.dto.request.UserRequestDTO;
import com.example.spring.ebank.dto.response.UserResponseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(UserAPI.BASE_URL)
public interface UserAPI {
    String BASE_URL = "/api/users";

    @PostMapping("/create")
    UserResponseDTO createUser(@RequestBody @Valid UserRequestDTO userRequest);

    @GetMapping("/all")
    List<UserResponseDTO> getAll();
}
