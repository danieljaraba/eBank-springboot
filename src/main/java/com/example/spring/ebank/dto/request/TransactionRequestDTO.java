package com.example.spring.ebank.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequestDTO {
    @NotBlank
    private String sender;

    @NotBlank
    private String receiver;

    @NotBlank
    private long amount;
}
