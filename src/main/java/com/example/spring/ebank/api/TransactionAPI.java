package com.example.spring.ebank.api;

import com.example.spring.ebank.dto.request.TransactionRequestDTO;
import com.example.spring.ebank.dto.request.UserRequestDTO;
import com.example.spring.ebank.dto.response.TransactionResponseDTO;
import com.example.spring.ebank.model.UserModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(TransactionAPI.BASE_URL)
public interface TransactionAPI {
    String BASE_URL = "/api/transactions";

    @PostMapping("/send")
    TransactionResponseDTO send(@RequestBody @Valid TransactionRequestDTO transactionRequestDTO);

    @GetMapping("/all/sents")
    List<TransactionResponseDTO> getAllSentsByUser(@RequestBody @Valid UserRequestDTO userRequestDTO);

    @GetMapping("/all/receives")
    List<TransactionResponseDTO> getAllReceivesByUser(@RequestBody @Valid UserRequestDTO userRequestDTO);
}
