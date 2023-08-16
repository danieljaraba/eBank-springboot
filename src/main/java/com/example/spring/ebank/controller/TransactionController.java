package com.example.spring.ebank.controller;

import com.example.spring.ebank.api.TransactionAPI;
import com.example.spring.ebank.dto.request.TransactionRequestDTO;
import com.example.spring.ebank.dto.request.UserRequestDTO;
import com.example.spring.ebank.dto.response.TransactionResponseDTO;
import com.example.spring.ebank.service.TransactionService;
import com.example.spring.ebank.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class TransactionController implements TransactionAPI {

    private final TransactionService transactionService;

    @Override
    public TransactionResponseDTO send(TransactionRequestDTO transactionRequestDTO) {
        return transactionService.send(transactionRequestDTO);
    }

    @Override
    public List<TransactionResponseDTO> getAllSentsByUser(UserRequestDTO userRequestDTO) {
        return transactionService.getAllSentsByUser(userRequestDTO);
    }

    @Override
    public List<TransactionResponseDTO> getAllReceivesByUser(UserRequestDTO userRequestDTO) {
        return transactionService.getAllReceivesByUser(userRequestDTO);
    }
}
