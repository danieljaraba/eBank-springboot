package com.example.spring.ebank.repository;

import com.example.spring.ebank.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel, UUID> {

    UserModel findFirstById(UUID id);

}
