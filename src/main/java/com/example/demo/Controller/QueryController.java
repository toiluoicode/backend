package com.example.demo.Controller;

import com.example.demo.Models.Connect;
import com.example.demo.Models.Query;
import com.example.demo.Service.QueryService;
import com.example.demo.Service.QueryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/query")
public class QueryController {
    @Autowired
    QueryServiceImp queryServiceImp;
    @GetMapping("/findAll")
    public List<Query> findAll(){
        return queryServiceImp.findAll();
    }
    @PostMapping("/addQuery")
    public ResponseEntity<?> addQuery(@RequestBody Query query){
        System.out.println(query.getQueryId());
        boolean success= queryServiceImp.saveQuery(query);
        if(success)
            return ResponseEntity.status(201).body("{\"message\": \"success\"}");
        else
            return ResponseEntity.status(400).body("{\"message\": \"error\"}");
    }
    @DeleteMapping("/deleteQuery/{id}")
    public ResponseEntity<?> deleteQuery(@PathVariable String id){
        boolean success= queryServiceImp.deleteQuery(id);
        if(success)
            return ResponseEntity.status(201).body("{\"message\": \"success\"}");
        else
            return ResponseEntity.status(400).body("{\"message\": \"error\"}");
    }
    @PutMapping("/updateQuery/{id}")
    public ResponseEntity<?> updateQuery(@PathVariable String id,@RequestBody Query query){
        boolean success =queryServiceImp.updateQuery(id,query);
        if(success)
            return ResponseEntity.status(201).body("{\"message\": \"success\"}");
        else
            return ResponseEntity.status(400).body("{\"message\": \"error\"}");
    }
}
