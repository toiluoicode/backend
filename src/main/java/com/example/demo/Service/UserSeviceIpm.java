package com.example.demo.Service;

import com.example.demo.Models.User;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserSeviceIpm implements UserSevice{
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public boolean register(User user) {
        User u = userRepository.findByUserName(user.getUserName());
        if(u == null)
        {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            System.out.println(user);
            userRepository.save(user);
            return true;
        }
        return false;
    }
}
