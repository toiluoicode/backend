package com.example.demo.Repository;

import com.example.demo.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepository extends MongoRepository<User, Integer> {
    User findByUserName(String username);
}
