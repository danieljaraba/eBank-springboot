package com.example.spring.ebank.mapper;

import com.example.spring.ebank.dto.request.TransactionRequestDTO;
import com.example.spring.ebank.dto.response.TransactionResponseDTO;
import com.example.spring.ebank.model.Transaction;
import com.example.spring.ebank.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    @Mapping(target = "sender", source = "sender")
    @Mapping(target = "receiver", source = "receiver")
    @Mapping(target = "id" , expression = "java(null)")
    Transaction toTransaction(TransactionRequestDTO transactionRequestDTO, UserModel sender, UserModel receiver);

    @Mapping(target = "sender", source = "sender")
    @Mapping(target = "receiver", source = "receiver")
    @Mapping(target = "id" , expression = "java(null)")
    Transaction toTransaction(TransactionResponseDTO transactionResponseDTO, UserModel sender, UserModel receiver);

    @Mapping(target = "sender", expression = "java(transaction.getSender().getId().toString())")
    @Mapping(target = "receiver", expression = "java(transaction.getReceiver().getId().toString())")
    TransactionResponseDTO toTransactionResponseDTO(Transaction transaction);
}