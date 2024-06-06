package com.example.demo.Repository;

import com.example.demo.Models.Connect;
import com.example.demo.Models.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface QueryRepository extends MongoRepository<Query, String>{
    Optional<Query> findById(String id);
}
