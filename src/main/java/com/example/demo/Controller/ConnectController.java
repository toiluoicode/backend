package com.example.demo.Controller;

import com.example.demo.Models.Connect;

import com.example.demo.Service.ConnectServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/connect")
public class ConnectController {
    @Autowired
    ConnectServiceImp connectServiceImp;
    @GetMapping("/findAll")
    public List<Connect> findAll(){
        return connectServiceImp.findAll();
    }
    @PostMapping("/addConnect")
    public ResponseEntity<?> addConnect(@RequestBody Connect connect){
        boolean success= connectServiceImp.addConnect(connect);
        if(success)
            return ResponseEntity.status(201).body("{\"message\": \"success\"}");
        else
            return ResponseEntity.status(400).body("{\"message\": \"error\"}");
    }
    @PutMapping("/updateConnect/{id}")
    public ResponseEntity<?> updateConnect(@PathVariable String id,@RequestBody Connect connect){
        boolean success =connectServiceImp.updateConnect(id,connect);
        if(success)
            return ResponseEntity.status(201).body("{\"message\": \"success\"}");
        else
            return ResponseEntity.status(400).body("{\"message\": \"error\"}");
    }
    @DeleteMapping("/deleteConnect/{id}")
    public ResponseEntity<?> deleteConnect(@PathVariable String id){
        boolean success= connectServiceImp.deleteConnect(id);
        if(success)
            return ResponseEntity.status(201).body("{\"message\": \"success\"}");
        else
            return ResponseEntity.status(400).body("{\"message\": \"error\"}");
    }
}
