package com.example.demo.Controller;

import com.example.demo.DTO.UserDTO;
import com.example.demo.Models.User;
import com.example.demo.Service.UserSeviceIpm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {
    @Autowired
    UserSeviceIpm userSeviceIpm;
    @RequestMapping(value = "/Home",method = RequestMethod.GET)
    public String helo (){
        return "helo";
    }

    @CrossOrigin(value = "http://localhost:4200")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login (){
        return "helo";
    }
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @CrossOrigin(value = "http://localhost:4200")
    public ResponseEntity<?> register(@RequestBody User user) {
        System.out.println(user);
        boolean check = userSeviceIpm.register(user);
        if (check) {
            return ResponseEntity.status(200).body("{\"message\": \"success\"}");
        } else {
            return ResponseEntity.status(404).body("{\"message\": \"error\"}");
        }
    }

}
