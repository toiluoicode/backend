package com.example.demo.Repository;

import com.example.demo.Models.Connect;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ConnectRepository extends MongoRepository<Connect, String> {
    Optional<Connect> findById(String id);
}
