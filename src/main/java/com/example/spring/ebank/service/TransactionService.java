package com.example.spring.ebank.service;

import com.example.spring.ebank.dto.request.TransactionRequestDTO;
import com.example.spring.ebank.dto.request.UserRequestDTO;
import com.example.spring.ebank.dto.response.TransactionResponseDTO;
import com.example.spring.ebank.mapper.TransactionMapper;
import com.example.spring.ebank.mapper.UserMapper;
import com.example.spring.ebank.model.Transaction;
import com.example.spring.ebank.model.UserModel;
import com.example.spring.ebank.repository.TransactionRepository;
import com.example.spring.ebank.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;

    private final TransactionMapper transactionMapper;
    private final UserMapper userMapper;

    public TransactionResponseDTO send(TransactionRequestDTO transactionRequestDTO){
        // TODO: Validate that sender have enough money and sender != receiver
        UserModel receiver = userRepository.getReferenceById(UUID.fromString(transactionRequestDTO.getReceiver()));
        UserModel sender = userRepository.getReferenceById(UUID.fromString(transactionRequestDTO.getSender()));
        Transaction transaction = transactionMapper.toTransaction(transactionRequestDTO, sender, receiver);
        receiver.setMoney(receiver.getMoney()+transaction.getAmount());
        sender.setMoney(sender.getMoney()-transaction.getAmount());
        userRepository.save(receiver);
        userRepository.save(sender);
        transaction.setId(UUID.randomUUID());
        return transactionMapper.toTransactionResponseDTO(transactionRepository.save(transaction));
    }

    public List<TransactionResponseDTO> getAllSentsByUser(UserRequestDTO userRequestDTO){
        UserModel userModel = userRepository.findFirstById(userMapper.toUser(userRequestDTO).getId());
        List<TransactionResponseDTO> transactionResponseDTOList = new ArrayList<>();
        for(Transaction sent: userModel.getSentTransactions()){
            transactionResponseDTOList.add(transactionMapper.toTransactionResponseDTO(sent));
        }
        return transactionResponseDTOList;
    }

    public List<TransactionResponseDTO> getAllReceivesByUser(UserRequestDTO userRequestDTO){
        UserModel userModel = userRepository.findFirstById(userMapper.toUser(userRequestDTO).getId());
        List<TransactionResponseDTO> transactionResponseDTOList = new ArrayList<>();
        for(Transaction received: userModel.getReceivedTransactions()){
            transactionResponseDTOList.add(transactionMapper.toTransactionResponseDTO(received));
        }
        return transactionResponseDTOList;
    }
}
