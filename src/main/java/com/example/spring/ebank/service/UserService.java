package com.example.spring.ebank.service;

import com.example.spring.ebank.dto.request.UserRequestDTO;
import com.example.spring.ebank.dto.response.TransactionResponseDTO;
import com.example.spring.ebank.dto.response.UserResponseDTO;
import com.example.spring.ebank.mapper.TransactionMapper;
import com.example.spring.ebank.mapper.UserMapper;
import com.example.spring.ebank.model.Transaction;
import com.example.spring.ebank.model.UserModel;
import com.example.spring.ebank.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public UserResponseDTO createUser(UserRequestDTO userRequest){
        UserModel userModel = userMapper.toUser(userRequest);
        userModel.setId(UUID.randomUUID());
        return userMapper.toUserResponseDTO(userRepository.save(userModel));
    }

    public List<UserResponseDTO> getAll(){
        List<UserModel> userModels = userRepository.findAll();
        List<UserResponseDTO> userResponseDTOList = new ArrayList<>();
        for (UserModel user : userModels){
            userResponseDTOList.add(userMapper.toUserResponseDTO(user));
        }
        return userResponseDTOList;
    }
}
