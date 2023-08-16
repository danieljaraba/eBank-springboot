package com.example.spring.ebank.mapper;

import com.example.spring.ebank.dto.request.UserRequestDTO;
import com.example.spring.ebank.dto.response.UserResponseDTO;
import com.example.spring.ebank.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserModel toUser(UserResponseDTO userResponseDTO);
    UserModel toUser(UserRequestDTO userRequestDTO);

    UserResponseDTO toUserResponseDTO(UserModel userModel);
}
