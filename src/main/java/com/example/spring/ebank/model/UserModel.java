package com.example.spring.ebank.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {

    @Id
    private UUID id;

    private String name;
    private long money;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sender")
    private List<Transaction> sentTransactions;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "receiver")
    private List<Transaction> receivedTransactions;
}
