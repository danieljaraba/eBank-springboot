package com.example.spring.ebank.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponseDTO {

    @NotNull
    @NotEmpty
    @NotBlank
    private String sender;

    @NotNull
    @NotEmpty
    @NotBlank
    private String receiver;

    @NotNull
    @NotEmpty
    @NotBlank
    private long amount;
}
